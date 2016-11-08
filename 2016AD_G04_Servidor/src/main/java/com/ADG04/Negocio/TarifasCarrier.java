package com.ADG04.Negocio;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.SucursalDao;
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
	
	private String ciudad;
	
	private Pais pais;

	private Sucursal origen;
	
	public TarifasCarrier() {
		
	}
	
	public TarifasCarrier(String comentarios, String prioridad,
			float precioKMExtra, float tarifa, Proveedor proveedor, String ciudad, Pais pais, Sucursal origen) {
		super();
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
		this.ciudad=ciudad;
		this.pais=pais;
		this.origen=origen;
	}

	public TarifasCarrier(int idTarifasCarrier, String comentarios,
			String prioridad, float precioKMExtra, float tarifa,
			Proveedor proveedor,String ciudad, Pais pais, Sucursal origen) {
		super();
		this.idTarifasCarrier = idTarifasCarrier;
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
		this.ciudad=ciudad;
		this.pais=pais;
		this.origen=origen;
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

	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

	public Sucursal getOrigen() {
		return origen;
	}

	public void setOrigen(Sucursal origen) {
		this.origen = origen;
	}

	public DTO_TarifasCarrier toDTO() {
		DTO_TarifasCarrier pc = new DTO_TarifasCarrier();
		pc.setIdProveedor(this.getProveedor().getIdProveedor());
		pc.setId(this.getIdTarifasCarrier());
		
		pc.setComentarios(this.getComentarios());
		pc.setPrioridad(this.getPrioridad());
		pc.setPrecioKMExtra(this.getPrecioKMExtra());
		pc.setTarifa(this.getTarifa());
		pc.setCiudad(this.getCiudad());
		pc.setPais(pais.toDTO());
		pc.setOrigen(this.origen.toDTO());
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
			tc.setCiudad(tarifa.getCiudad());
			tc.setPais(new Pais().fromEntity(PaisDao.getInstancia().getById(tarifa.getPais().getId())));
			tc.setOrigen(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(tarifa.getOrigen().getId())));
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
		tc.setCiudad(ciudad);
		tc.setPais(PaisDao.getInstancia().getById(pais.getIdPais()));
		tc.setOrigen(SucursalDao.getInstancia().getById(origen.getIdSucursal()));
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
			tc.setCiudad(tarifa.getCiudad());
			tc.setPais(new Pais().fromEntity(tarifa.getPais()));
			
			tc.setOrigen(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(tarifa.getOrigen().getIdSucursal())));
			return tc;
		}
		else
			return null;
	}

	
}