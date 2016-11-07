package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;














import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.CuentaCorrienteE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;


public class ClienteEmpresa extends Cliente{

	private String razonSocial;
	private String cuit;
	private List <Producto> productos;
	private CuentaCorriente cuentaCorrientes;
	
	public ClienteEmpresa() {
		super();
	}

	

	public ClienteEmpresa(String razonSocial, String cuit) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}



	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getCuit() {
		return cuit;
	}



	public void setCuit(String cuit) {
		this.cuit = cuit;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public CuentaCorriente getCuentaCorrientes() {
		return cuentaCorrientes;
	}



	public void setCuentaCorrientes(CuentaCorriente cuentaCorrientes) {
		this.cuentaCorrientes = cuentaCorrientes;
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

	public DTO_ClienteEmpresa toDTO(){
		DTO_ClienteEmpresa cli = new DTO_ClienteEmpresa();
		cli.setId(this.getIdCliente());
		cli.setRazonSocial(this.razonSocial);
		cli.setCuit(this.cuit);
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());
			
		cli.setDireccion(this.getDireccion().toDTO());
		
		return cli;
	}
	
	
	public ClienteEmpresaE toEntity() {
		ClienteEmpresaE cli = new ClienteEmpresaE();
		cli.setEmail(this.getEmail());
		cli.setEstado(this.getEstado());
		cli.setIdCliente(this.getIdCliente());
		cli.setTelefono(this.getTelefono());
		cli.setRazonSocial(this.getRazonSocial());
		cli.setCuit(this.getCuit());
		DireccionE dir = new DireccionE(this.getDireccion().getPais().toEntity(), this.getDireccion().getProvincia().toEntity(), 
				this.getDireccion().getCalle(),this.getDireccion().getNro(), this.getDireccion().getLocalidad(),
				this.getDireccion().getCodigoPostal());
		
		CuentaCorrienteE cte = new CuentaCorrienteE(this.getCuentaCorrientes().getCredito(),this.getCuentaCorrientes().getLimiteCredito(),this.getCuentaCorrientes().getFormaPago());
		
		cli.setCuentaCorrientes(cte);
		cli.setDireccion(dir);
		
		return cli;
	}



	public ClienteEmpresa fromEntity(ClienteEmpresaE cliente) {
		if(cliente!=null){
			ClienteEmpresa cli = new ClienteEmpresa();
			cli.setIdCliente(cliente.getIdCliente());
			cli.setCuit(cliente.getCuit());
			cli.setDireccion(new Direccion().fromEntity(cliente.getDireccion()));
			cli.setRazonSocial(cliente.getRazonSocial());
			cli.setEmail(cliente.getEmail());
			cli.setTelefono(cliente.getTelefono());
			cli.setEstado(cliente.getEstado());
			cli.setCuentaCorrientes(new CuentaCorriente().fromEntity(cliente.getCuentaCorrientes()));
			return cli;
		}
		else
			return null;
	}
}
