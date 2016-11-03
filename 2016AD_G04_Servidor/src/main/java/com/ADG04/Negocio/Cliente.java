package com.ADG04.Negocio;

import java.util.List;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

public class Cliente{

	private int idCliente;
	private boolean estado;
	private String email;
	private String telefono;
	private List <Encomienda> encomiendas;
	private Direccion direccion;

	public Cliente() {
	}



	public Cliente(int idCliente, boolean estado, String email, String telefono, Direccion dir) {
		super();
		this.idCliente = idCliente;
		this.estado = estado;
		this.email = email;
		this.telefono = telefono;
		this.direccion=dir;
	}

	public Cliente(boolean estado, String email, String telefono,
			Direccion direccion) {
		super();
		this.estado = estado;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public boolean getEstado(){
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}



	public DTO_Cliente toDTO() {
		DTO_Cliente cli = new DTO_Cliente();
		cli.setId(this.getIdCliente());
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());		
		cli.setDireccion(this.getDireccion().toDTO());
		
		return cli;
	}



	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ClienteDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}



	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ClienteDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}



	private ClienteE toEntity() {
		ClienteE cli = new ClienteE();
		cli.setEmail(email);
		cli.setEstado(estado);
		cli.setIdCliente(idCliente);
		cli.setTelefono(telefono);
		DireccionE dir = new DireccionE(this.getDireccion().getPais().toEntity(), this.getDireccion().getProvincia().toEntity(), 
				this.getDireccion().getCalle(),this.getDireccion().getNro(), this.getDireccion().getLocalidad(),
				this.getDireccion().getCodigoPostal());
		cli.setDireccion(dir);
		
		return cli;
	}
				

}
