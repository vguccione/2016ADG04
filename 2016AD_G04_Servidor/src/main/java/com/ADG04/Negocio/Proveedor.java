package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;



















import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;


public class Proveedor{
 
	private int idProveedor;
	private Direccion direccion;
	private String activo;
	private String cuit;
	private String razonSocial;
	private String email;
	private String telefono;
	private boolean tallerOficial;
	private char tipo;
	private List<Envio> envios;
	
	public Proveedor() {
	}

	
	public Proveedor(Direccion direccion, String activo, String cuit,
			String razonSocial, String email, String telefono,
			boolean tallerOficial, char tipo) {
		super();
		this.direccion = direccion;
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
		this.tallerOficial = tallerOficial;
		this.tipo = tipo;
	}
	
	

	public Proveedor(int idProveedor, Direccion direccion, String activo,
			String cuit, String razonSocial, String email, String telefono,
			boolean tallerOficial, char tipo) {
		super();
		this.idProveedor = idProveedor;
		this.direccion = direccion;
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
		this.tallerOficial = tallerOficial;
		this.tipo = tipo;
	}
	

	public Proveedor(String activo, String cuit, String razonSocial, String email,
			String telefono) {
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
	}

	public Proveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}


	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCuit() {
		return this.cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}
	
	

	public boolean isTallerOficial() {
		return tallerOficial;
	}

	public void setTallerOficial(boolean tallerOficial) {
		this.tallerOficial = tallerOficial;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public DTO_Proveedor toDTO() {
		DTO_Proveedor prov = new DTO_Proveedor();
		prov.setId(this.getIdProveedor());
		prov.setActivo(this.getActivo());
		prov.setCuit(this.getCuit());
		prov.setDireccion(this.getDireccion().toDTO());
		prov.setEmail(this.getEmail());
		prov.setRazonSocial(this.getRazonSocial());
		prov.setTallerOficial(this.isTallerOficial());
		prov.setTipo(this.getTipo());
		prov.setTelefono(this.getTelefono());
		
		return prov;
	}
	


	public ProveedorE toEntity(){
		ProveedorE prov = new ProveedorE(this.idProveedor,this.getDireccion().toEntity(),this.getActivo(),this.getCuit(),
				this.getRazonSocial(), this.getEmail(),this.getTelefono(),this.isTallerOficial(),this.getTipo());
		return prov;
	}

	
	public void remove() {
		ProveedorE proveedor = toEntity();
		if (proveedor != null){
			ProveedorDao.getInstancia().remove(proveedor);
		}
	}
	
	public void saveOrUpdate() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ProveedorE proveedor = toEntity();
		ProveedorDao.getInstancia().saveOrUpdate(proveedor);
		em.getTransaction().commit();
	}


	public Proveedor fromDTO(DTO_Proveedor dto) {
		Proveedor p = new Proveedor();
		p.setActivo(dto.getActivo());
		p.setCuit(dto.getCuit());
		p.setDireccion(new Direccion().fromDTO(dto.getDireccion()));
		p.setEmail(dto.getEmail());
		p.setIdProveedor(dto.getId());
		p.setRazonSocial(dto.getRazonSocial());
		p.setTallerOficial(dto.isTallerOficial());
		p.setTelefono(dto.getTelefono());
		p.setTipo(dto.getTipo());
		return p;
	}
}
