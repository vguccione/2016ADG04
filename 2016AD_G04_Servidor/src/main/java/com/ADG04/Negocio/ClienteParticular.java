package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;


























import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
  
public class ClienteParticular extends Cliente{

	private String nombre;
	private String apellido;
	private String dni;

	public ClienteParticular() {
	}

	

	public ClienteParticular(String nombre, String apellido, String dni) {
		super();
		this.setTipo('P');
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public DTO_ClienteParticular toDTO(){

		DTO_ClienteParticular cli = new DTO_ClienteParticular();

		cli.setTipo('P');
		cli.setId(this.getIdCliente());
		cli.setDni(this.getDni());
		cli.setNombre(this.getNombre());
		cli.setApellido(this.getApellido());
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());
		
		cli.setDireccion(this.getDireccion().toDTO());
		
		return cli;
	}
	
	
	public ClienteParticularE toEntity() {
		ClienteParticularE cli = new ClienteParticularE();
		cli.setEmail(this.getEmail());
		cli.setEstado(this.getEstado());
		cli.setIdCliente(this.getIdCliente());
		cli.setTelefono(this.getTelefono());
		cli.setNombre(this.getNombre());
		cli.setApellido(this.getApellido());
		cli.setDni(this.getDni());
		DireccionE dir = new DireccionE(this.getDireccion().getPais().toEntity(), this.getDireccion().getProvincia().toEntity(), 
				this.getDireccion().getCalle(),this.getDireccion().getNro(), this.getDireccion().getLocalidad(),
				this.getDireccion().getCodigoPostal());
		cli.setDireccion(dir);
		
		return cli;
	}
	
	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ClienteParticularDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}



	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ClienteParticularDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}
	
	
	public ClienteParticular fromEntity(ClienteParticularE cliente) {
		
		if(cliente!=null){
			ClienteParticular cli = new ClienteParticular();
			cli.setApellido(cliente.getApellido());
			cli.setDireccion(new Direccion().fromEntity(cliente.getDireccion()));
			cli.setDni(cliente.getDni());
			cli.setEmail(cliente.getEmail());
			cli.setEstado(cliente.getEstado());
			cli.setIdCliente(cliente.getIdCliente());
			cli.setNombre(cliente.getNombre());
			cli.setTelefono(cliente.getTelefono());
			cli.setTipo('P');
			
			return cli;
		}
		else
			return null;
	}
}
