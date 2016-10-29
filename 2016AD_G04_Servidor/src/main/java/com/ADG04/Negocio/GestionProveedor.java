package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.TarifasCarrierDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.model.TarifasCarrier;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;


public class GestionProveedor {

	private EntityManagerFactory factory;
	private Proveedor proveedor;
	private Seguro seguro;
	private TarifasCarrier tarifaCarrier;
	private ServicioSeguridad ss;
	
	public GestionProveedor(Proveedor prov){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		proveedor = prov;
		seguro = new Seguro();
		tarifaCarrier = new TarifasCarrier();
		ss = new ServicioSeguridad();
	}
	
	
	public void saveOrUpdate() {
				
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProveedorDao.getInstancia().saveOrUpdate(proveedor);
		tx.commit();
		
	}
	
	public void altaSeguro(String tipoSeguro, String descripcion, float tarifa,float tarifaPorKm) {
		
		seguro = new Seguro(tipoSeguro, descripcion, tarifa,tarifaPorKm, proveedor);
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().persist(seguro);
		tx.commit();
	}
	
	public void altaTarifasCarrier(String comentarios, String prioridad,float precioKMExtra, float tarifa){	
	
		tarifaCarrier =  new TarifasCarrier(comentarios, prioridad, precioKMExtra, tarifa, proveedor);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TarifasCarrierDao.getInstancia().persist(tarifaCarrier);
		tx.commit();
	}
	
		
	public void altaServicioSeguridad(String descripcion, float tarifa) {
		
		ss = new ServicioSeguridad(descripcion, tarifa, proveedor);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().persist(ss);
		tx.commit();
	}

	
	
	public void modificarSeguro(int idSeguro, String tipoSeguro, String descripcion, float tarifa,float tarifaPorKm){
		Seguro seguro = new Seguro(idSeguro, tipoSeguro, descripcion, tarifa,tarifaPorKm, proveedor);

		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().saveOrUpdate(seguro);
		tx.commit();
	}

	
	public void modificarTarifasCarrier(int idTarifaCarrier, String comentarios, String prioridad,float precioKMExtra, float tarifa) {
		
		tarifaCarrier = new TarifasCarrier(idTarifaCarrier, comentarios, prioridad, precioKMExtra,tarifa, proveedor);		
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TarifasCarrierDao.getInstancia().saveOrUpdate(tarifaCarrier);
		tx.commit();
	}
	
	
	
	public void modificarServicioSeguridad(int idServicioSeguridad, String descripcion, float tarifa) {
		
		ss = new ServicioSeguridad(idServicioSeguridad, descripcion, tarifa, proveedor);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		tx.commit();
	}

	
	public void remove() {
		//Proveedor p = ProveedorDao.getInstancia().getById(id);
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
		List<Seguro> seguros = SeguroDao.getInstancia().getAll();
		List<DTO_Seguro> segurosDTO = new ArrayList<DTO_Seguro>();
		for(Seguro seguro : seguros){
			segurosDTO.add(seguro.toDTO());
		}
		return segurosDTO;
	}
	
	public List<DTO_TarifasCarrier> getCarriers(){
		List<TarifasCarrier> carriers = TarifasCarrierDao.getInstancia().getAll();
		List<DTO_TarifasCarrier> carriersDTO = new ArrayList<DTO_TarifasCarrier>();

		for(TarifasCarrier carrier : carriers){	
			carriersDTO.add(carrier.toDTO());
		}
		return carriersDTO;
	}
	
	public List<DTO_ServicioSeguridad> getServicioSeguridad(){
		List<ServicioSeguridad> ss = ServicioSeguridadDao.getInstancia().getAll();
		List<DTO_ServicioSeguridad> ssDTO = new ArrayList<DTO_ServicioSeguridad>();
		for(ServicioSeguridad s : ss){
			ssDTO.add(s.toDTO());
		}
		return ssDTO;
	}
	

}
