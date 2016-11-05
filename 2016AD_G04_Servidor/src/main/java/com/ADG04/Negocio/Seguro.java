package com.ADG04.Negocio;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Proveedor.DTO_Seguro;

public class Seguro implements java.io.Serializable{
	
	private int idSeguro;
	private String tipoSeguro;
	private String descripcion;
	private float tarifa;
	private float tarifaPorKm;
	private Proveedor proveedor;

	public Seguro() {
		
	}
	
	public Seguro(int idSeguro, String tipoSeguro, String descripcion,
			float tarifa, float tarifaPorKm, Proveedor proveedor) {
		super();
		this.idSeguro = idSeguro;
		this.tipoSeguro = tipoSeguro;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.tarifaPorKm = tarifaPorKm;
		this.proveedor = proveedor;
	}



	public Seguro(String tipoSeguro, String descripcion, float tarifa,
			float tarifaPorKm, Proveedor proveedor) {
		super();
		this.tipoSeguro = tipoSeguro;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.tarifaPorKm = tarifaPorKm;
		this.proveedor = proveedor;
	}



	public int getIdSeguro() {
		return idSeguro;
	}



	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}



	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	

	public float getTarifaPorKm() {
		return tarifaPorKm;
	}

	public void setTarifaPorKm(float tarifaPorKm) {
		this.tarifaPorKm = tarifaPorKm;
	}
	
	

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public DTO_Seguro toDTO() {
		DTO_Seguro s = new DTO_Seguro();
		s.setId(this.getIdSeguro());
		s.setIdProveedor(this.getProveedor().getIdProveedor());
		s.setTipoSeguro(this.getTipoSeguro());
		s.setDescripcion(this.descripcion);
		s.setTarifa(this.getTarifa());
		s.setTarifaPorKm(this.tarifaPorKm);
		return s;
	}

	public Seguro fromDTO(DTO_Seguro seguro) {
		Seguro seg=new Seguro();
		seg.setDescripcion(seguro.getDescripcion());
		if(seguro.getId()!=null)
			seg.setIdSeguro(seguro.getId());
		seg.setProveedor(new Proveedor().fromEntity(ProveedorDao.getInstancia().getById(seguro.getIdProveedor())));
		seg.setTarifa(seguro.getTarifa());
		seg.setTipoSeguro(seguro.getTipoSeguro());
		return seg;
	}
	
	public Seguro fromEntity(SeguroE seguro) {
		Seguro seg=new Seguro();
		seg.setDescripcion(seguro.getDescripcion());
		seg.setIdSeguro(seguro.getIdSeguro());
		seg.setProveedor(new Proveedor().fromEntity(seguro.getProveedor()));
		seg.setTarifa(seguro.getTarifa());
		seg.setTipoSeguro(seguro.getTipoSeguro());
		return seg;
	}
	
	
	public SeguroE toEntity(){
		SeguroE s = new SeguroE();
		s.setIdSeguro(this.getIdSeguro());
		s.setProveedor(ProveedorDao.getInstancia().getById(this.getProveedor().getIdProveedor()));
		s.setTipoSeguro(this.getTipoSeguro());
		s.setDescripcion(this.descripcion);
		s.setTarifa(this.getTarifa());
		s.setTarifaPorKm(this.tarifaPorKm);
		return s;
	}
	
	public void guardar(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		SeguroDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}
	
	public void modificar(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		SeguroDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}
	
}