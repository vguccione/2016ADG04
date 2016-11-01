package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;














import com.ADG04.Servidor.dao.TarifasCarrierDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.FacturaE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;


public class GestionProveedor {
	
	private int idProveedor;
	private DireccionE direccion;
	private String activo;
	private String cuit;
	private String razonSocial;
	private String email;
	private String telefono;
	private boolean tallerOficial;
	private char tipo;
	private List<SeguroE> seguros;
	private List<ServicioSeguridadE> servicios;
	private List<TarifasCarrierE> tarifasCarrier;

	
	public GestionProveedor(int idProveedor, DireccionE dir, String act, String cuit,
			String razonSocial, String email, String telefono,
			boolean tallerOficial, char tipo){
		
		if(idProveedor!=0)
			this.idProveedor=idProveedor;
		this.direccion = dir;
		this.activo=act;
		this.cuit=cuit;
		this.razonSocial=razonSocial;
		this.email=email;
		this.telefono=telefono;
		this.tallerOficial=tallerOficial;
		this.tipo=tipo;
	}
	
	public ProveedorE toEntity(){
		ProveedorE prov = new ProveedorE(this.idProveedor,this.direccion, this.activo,
				this.cuit, this.razonSocial, this.email, this.telefono,
				this.tallerOficial, this.tipo);
		return prov;
	}
	
	public void saveOrUpdate() {
				
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		ProveedorE proveedor = toEntity();
		ProveedorDao.getInstancia().saveOrUpdate(proveedor);
	//	tx.commit();
		
	}
	
	public void altaSeguro(String tipoSeguro, String descripcion, float tarifa,float tarifaPorKm) {
		
		ProveedorE proveedor = toEntity();
		SeguroE seguro = new SeguroE(tipoSeguro, descripcion, tarifa,tarifaPorKm, proveedor);
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		
		SeguroDao.getInstancia().persist(seguro);
		this.seguros.add(seguro);
		//tx.commit();
	}
	
	public void altaTarifasCarrier(String comentarios, String prioridad,float precioKMExtra, float tarifa){	
	
		ProveedorE proveedor = toEntity();
		TarifasCarrierE tarifaCarrier =  new TarifasCarrierE(comentarios, prioridad, precioKMExtra, tarifa, proveedor);
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		
		TarifasCarrierDao.getInstancia().persist(tarifaCarrier);
		this.tarifasCarrier.add(tarifaCarrier);
		//tx.commit();
	}
	
		
	public void altaServicioSeguridad(String descripcion, float tarifa) {
		
		ProveedorE proveedor = toEntity();
		ServicioSeguridadE ss = new ServicioSeguridadE(descripcion, tarifa, proveedor);
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
			
		ServicioSeguridadDao.getInstancia().persist(ss);
		this.servicios.add(ss);
		//tx.commit();
	}

	
	
	public void modificarSeguro(int idSeguro, String tipoSeguro, String descripcion, float tarifa,float tarifaPorKm){
		ProveedorE proveedor = toEntity();
		SeguroE seguro = new SeguroE(idSeguro, tipoSeguro, descripcion, tarifa,tarifaPorKm, proveedor);
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		
		SeguroDao.getInstancia().saveOrUpdate(seguro);
		//tx.commit();
	}

	
	public void modificarTarifasCarrier(int idTarifaCarrier, String comentarios, String prioridad,float precioKMExtra, float tarifa) {
		
		ProveedorE proveedor = toEntity();
		TarifasCarrierE tarifaCarrier = new TarifasCarrierE(idTarifaCarrier, comentarios, prioridad, precioKMExtra,tarifa, proveedor);		
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
			
		TarifasCarrierDao.getInstancia().saveOrUpdate(tarifaCarrier);
		//tx.commit();
	}
	
	
	
	public void modificarServicioSeguridad(int idServicioSeguridad, String descripcion, float tarifa) {
		
		ProveedorE proveedor = toEntity();
		ServicioSeguridadE ss = new ServicioSeguridadE(idServicioSeguridad, descripcion, tarifa, proveedor);
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		//tx.commit();
	}

	
	public void remove() {
		ProveedorE proveedor = toEntity();
		if (proveedor != null){
			ProveedorDao.getInstancia().remove(proveedor);
		}
	}


	
	public DTO_ServicioSeguridad getServicioSeguridad(Integer id) {
		return ServicioSeguridadDao.getInstancia().getById(id).toDTO();
	}
	
	public DTO_Seguro getSeguro(Integer id) {
		return SeguroDao.getInstancia().getById(id).toDTO();
	}

	public DTO_Proveedor getProveedor(Integer id) {
		return ProveedorDao.getInstancia().getById(id).toDTO();
	}
	
	
	public DTO_TarifasCarrier getCarrier(Integer id) {
		return TarifasCarrierDao.getInstancia().getById(id).toDTO();
	}
	
	public List<DTO_Seguro> getSeguros(){
		List<SeguroE> seguros = SeguroDao.getInstancia().getAll();
		List<DTO_Seguro> segurosDTO = new ArrayList<DTO_Seguro>();
		for(SeguroE seguro : seguros){
			segurosDTO.add(seguro.toDTO());
		}
		return segurosDTO;
	}
	
	public List<DTO_TarifasCarrier> getCarriers(){
		List<TarifasCarrierE> carriers = TarifasCarrierDao.getInstancia().getAll();
		List<DTO_TarifasCarrier> carriersDTO = new ArrayList<DTO_TarifasCarrier>();

		for(TarifasCarrierE carrier : carriers){	
			carriersDTO.add(carrier.toDTO());
		}
		return carriersDTO;
	}
	
	public List<DTO_ServicioSeguridad> getServicioSeguridad(){
		List<ServicioSeguridadE> ss = ServicioSeguridadDao.getInstancia().getAll();
		List<DTO_ServicioSeguridad> ssDTO = new ArrayList<DTO_ServicioSeguridad>();
		for(ServicioSeguridadE s : ss){
			ssDTO.add(s.toDTO());
		}
		return ssDTO;
	}
	

}
