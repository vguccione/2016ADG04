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


public class _GestionProveedor extends ProveedorE{

	private EntityManagerFactory factory;

	private SeguroE seguro;
	private TarifasCarrierE carrier;
	private ServicioSeguridadE ss;
	
	public _GestionProveedor(){
		super();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		seguro = new SeguroE();
		carrier = new TarifasCarrierE();
		ss = new ServicioSeguridadE();
	}
	
	
	public void altaProveedor(){
				
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProveedorDao.getInstancia().saveOrUpdate(this);
		tx.commit();
		
	}
	
	public void altaSeguro(DTO_Seguro dtoSeguro) {
		
		//this.proveedor = ProveedorDao.getInstancia().getById(dtoSeguro.getIdProveedor());
		seguro.setTarifa(dtoSeguro.getTarifa());
		seguro.setTarifaPorKm(dtoSeguro.getTarifaPorKm());
		seguro.setDescripcion(dtoSeguro.getDescripcion());
		seguro.setProveedor(this);
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().persist(seguro);
		tx.commit();
	}
	
	public void altaTarifasCarrier(DTO_TarifasCarrier dtoCarrier) {	
		//proveedor = ProveedorDao.getInstancia().getById(dtoCarrier.getIdProveedor());
		carrier.setTarifa(dtoCarrier.getTarifa());
		carrier.setComentarios(dtoCarrier.getComentarios());
		carrier.setPrecioKMExtra(dtoCarrier.getPrecioKMExtra());
		carrier.setPrioridad(dtoCarrier.getPrioridad());
		carrier.setProveedor(this);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TarifasCarrierDao.getInstancia().persist(carrier);
		tx.commit();
	}
	
		
	public void altaServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		//ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		ss.setProveedor(this);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().persist(ss);
		tx.commit();
	}

	
	
	public void modificarSeguro(DTO_Seguro dtoseguro){
		//Seguro s = new Seguro();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seguro.getIdProveedor());
		seguro.setTarifa(dtoseguro.getTarifa());
		seguro.setTarifaPorKm(dtoseguro.getTarifaPorKm());
		seguro.setDescripcion(dtoseguro.getDescripcion());
		seguro.setProveedor(this);
		seguro.setIdSeguro(dtoseguro.getId());

		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().saveOrUpdate(seguro);
		tx.commit();
	}

	
	public void modificarTarifasCarrier(DTO_TarifasCarrier dtocarrier) {
		
		//Carrier c = new Carrier();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(carrier.getIdProveedor());
		carrier.setTarifa(dtocarrier.getTarifa());
		carrier.setComentarios(dtocarrier.getComentarios());
		carrier.setPrecioKMExtra(dtocarrier.getPrecioKMExtra());
		carrier.setPrioridad(dtocarrier.getPrioridad());
		carrier.setProveedor(this);
		carrier.setIdTarifasCarrier(dtocarrier.getId());
		
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TarifasCarrierDao.getInstancia().saveOrUpdate(carrier);
		tx.commit();
	}
	
	
	
	public void modificarServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		//ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		ss.setProveedor(this);
		ss.setIdServicioSeguridad(seg.getId());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		tx.commit();
	}

	
	public void bajaProveedor(Integer id) {
		//Proveedor p = ProveedorDao.getInstancia().getById(id);
			ProveedorDao.getInstancia().remove(this);
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