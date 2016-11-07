package com.ADG04.Negocio;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.TarifasCarrierDao;
import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;

public class TarifasCarrier implements java.io.Serializable{	
	
	private int idTarifasCarrier;
	
	private String comentarios;
	
	private String prioridad;
	
	private float precioKMExtra;
	
	private float tarifa;
	
	private Proveedor proveedor;

	public TarifasCarrier() {
		
	}
	
	public TarifasCarrier(String comentarios, String prioridad,
			float precioKMExtra, float tarifa, Proveedor proveedor) {
		super();
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
	}

	public TarifasCarrier(int idTarifasCarrier, String comentarios,
			String prioridad, float precioKMExtra, float tarifa,
			Proveedor proveedor) {
		super();
		this.idTarifasCarrier = idTarifasCarrier;
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public float getPrecioKMExtra() {
		return precioKMExtra;
	}

	public void setPrecioKMExtra(float precioKMExtra) {
		this.precioKMExtra = precioKMExtra;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
	

	public int getIdTarifasCarrier() {
		return idTarifasCarrier;
	}

	public void setIdTarifasCarrier(int idTarifasCarrier) {
		this.idTarifasCarrier = idTarifasCarrier;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public DTO_TarifasCarrier toDTO() {
		DTO_TarifasCarrier pc = new DTO_TarifasCarrier();
		pc.setIdProveedor(this.getProveedor().getIdProveedor());
		pc.setId(this.getIdTarifasCarrier());
		
		pc.setComentarios(this.getComentarios());
		pc.setPrioridad(this.getPrioridad());
		pc.setPrecioKMExtra(this.getPrecioKMExtra());
		pc.setTarifa(this.getTarifa());
		return pc;
	}

	public TarifasCarrier fromDTO(DTO_TarifasCarrier tarifa) {
		if(tarifa!=null){
			TarifasCarrier tc = new TarifasCarrier();
			tc.setComentarios(tarifa.getComentarios());
			if(tarifa.getId()!=null)
				tc.setIdTarifasCarrier(tarifa.getId());
			tc.setPrecioKMExtra(tarifa.getPrecioKMExtra());
			tc.setPrioridad(tarifa.getPrioridad());
			tc.setProveedor(new Proveedor().fromEntity(ProveedorDao.getInstancia().getById(tarifa.getIdProveedor())));
			tc.setTarifa(tarifa.getTarifa());
			return tc;
		}
		else
			return null;
	}
	
	public TarifasCarrierE toEntity(){
		TarifasCarrierE tc = new TarifasCarrierE();
		tc.setComentarios(comentarios);
		tc.setIdTarifasCarrier(idTarifasCarrier);
		tc.setPrecioKMExtra(precioKMExtra);
		tc.setPrioridad(prioridad);
		tc.setTarifa(tarifa);
		tc.setProveedor(ProveedorDao.getInstancia().getById(this.proveedor.getIdProveedor()));
		return tc;
	}

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		TarifasCarrierDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}

	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		TarifasCarrierDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}

	public TarifasCarrier fromEntity(TarifasCarrierE tarifa) {
		if(tarifa!=null){
			TarifasCarrier tc = new TarifasCarrier();
			tc.setComentarios(tarifa.getComentarios());
			tc.setIdTarifasCarrier(tarifa.getIdTarifasCarrier());
			tc.setPrecioKMExtra(tarifa.getPrecioKMExtra());
			tc.setPrioridad(tarifa.getPrioridad());
			tc.setProveedor(new Proveedor().fromEntity(ProveedorDao.getInstancia().getById(tarifa.getProveedor().getIdProveedor())));
			tc.setTarifa(tarifa.getTarifa());
			return tc;
		}
		else
			return null;
	}

	
}