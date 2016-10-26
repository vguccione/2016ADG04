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
	private TarifasCarrier carrier;
	private ServicioSeguridad ss;
	
	public GestionProveedor(Proveedor prov){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		proveedor = prov;
		seguro = new Seguro();
		carrier = new TarifasCarrier();
		ss = new ServicioSeguridad();
	}
	
	
	public void altaProveedor(){
				
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProveedorDao.getInstancia().saveOrUpdate(proveedor);
		tx.commit();
		
	}
	
	public void altaSeguro(DTO_Seguro dtoSeguro) {
		
		//this.proveedor = ProveedorDao.getInstancia().getById(dtoSeguro.getIdProveedor());
		seguro.setTarifa(dtoSeguro.getTarifa());
		seguro.setTarifaPorKm(dtoSeguro.getTarifaPorKm());
		seguro.setDescripcion(dtoSeguro.getDescripcion());
		seguro.setProveedor(proveedor);
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
		carrier.setProveedor(proveedor);
		
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
		ss.setProveedor(proveedor);
		
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
		seguro.setProveedor(proveedor);
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
		carrier.setProveedor(proveedor);
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
		ss.setProveedor(proveedor);
		ss.setIdServicioSeguridad(seg.getId());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		tx.commit();
	}

	
	public void bajaProveedor(Integer id) {
		//Proveedor p = ProveedorDao.getInstancia().getById(id);
		if (proveedor != null){
			ProveedorDao.getInstancia().remove(proveedor);
		}
	}

	
	public DTO_ServicioSeguridad buscarServicioSeguridad(String cuit) {
		return ServicioSeguridadDao.getInstancia().getByCuit(cuit).toDTO();
	}
	
	public DTO_ServicioSeguridad getServicioSeguridad(Integer id) {
		return ServicioSeguridadDao.getInstancia().getById(id).toDTO();
	}
	
	public DTO_Seguro buscarSeguro(String cuit) {
		return SeguroDao.getInstancia().getByCuit(cuit).toDTO();
	}
	
	public DTO_Seguro getSeguro(Integer id) {
		return SeguroDao.getInstancia().getById(id).toDTO();
	}

	public DTO_Proveedor getProveedor(Integer id) {
		return ProveedorDao.getInstancia().getById(id).toDTO();
	}
	
	public DTO_TarifasCarrier buscarCarrier(String cuit) {
		return TarifasCarrierDao.getInstancia().getByCuit(cuit).toDTO();
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
