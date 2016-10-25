package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.CarrierDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.TallerMecanicoDao;
import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.model.TallerMecanico;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Proveedor.DTO_Carrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TallerMecanico;


public class _GestionProveedor extends Proveedor {

	private EntityManagerFactory factory;
	
	public _GestionProveedor(Proveedor prov){
		super();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	
	public void altaSeguro(DTO_Seguro dtoSeguro) {

		Seguro seguro = new Seguro();
		seguro.setActivo(this.getActivo());
		seguro.setRazonSocial(this.getRazonSocial());
		seguro.setCuit(this.getCuit());
		seguro.setEmail(this.getEmail());
		seguro.setTelefono(this.getTelefono());	
		seguro.setTarifa(dtoSeguro.getTarifa());
		seguro.setTarifaPorKm(dtoSeguro.getTarifaPorKm());
		seguro.setDescripcion(dtoSeguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		seguro.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().persist(seguro);
		tx.commit();
	}
	
	public void altaCarrier(DTO_Carrier dtoCarrier) {
		
		
		Carrier carrier = new Carrier();
		carrier.setActivo(this.getActivo());
		carrier.setRazonSocial(this.getRazonSocial());
		carrier.setCuit(this.getCuit());
		carrier.setEmail(this.getEmail());
		carrier.setTelefono(this.getTelefono());	
		carrier.setTarifa(dtoCarrier.getTarifa());
		carrier.setComentarios(dtoCarrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		carrier.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().persist(carrier);
		tx.commit();
	}
	
	public void altaTallerMecanico(DTO_TallerMecanico taller) {
		
		TallerMecanico tm = new TallerMecanico();
		tm.setActivo(this.getActivo());
		tm.setRazonSocial(this.getRazonSocial());
		tm.setCuit(this.getCuit());
		tm.setEmail(this.getEmail());
		tm.setTelefono(this.getTelefono());	
		tm.setTarifa(taller.getTarifa());
		tm.setTipoTaller(taller.getTipoTaller());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		tm.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TallerMecanicoDao.getInstancia().persist(tm);
		tx.commit();
	}
	
	public void altaServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setActivo(this.getActivo());
		ss.setRazonSocial(this.getRazonSocial());
		ss.setCuit(this.getCuit());
		ss.setEmail(this.getEmail());
		ss.setTelefono(this.getTelefono());	
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		ss.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().persist(ss);
		tx.commit();
	}

	
	
	public void modificarSeguro(DTO_Seguro dtoseguro){
		Seguro seguro = new Seguro();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seguro.getIdProveedor());
		seguro.setIdProveedor(dtoseguro.getIdProveedor());
		seguro.setActivo(this.getActivo());
		seguro.setRazonSocial(this.getRazonSocial());
		seguro.setCuit(this.getCuit());
		seguro.setEmail(this.getEmail());
		seguro.setTelefono(this.getTelefono());	
		seguro.setTarifa(dtoseguro.getTarifa());
		seguro.setTarifaPorKm(dtoseguro.getTarifaPorKm());
		seguro.setDescripcion(dtoseguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		seguro.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().saveOrUpdate(seguro);
		tx.commit();
	}

	
	public void modificarCarrier(DTO_Carrier dtocarrier) {
		
		Carrier carrier = new Carrier();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(carrier.getIdProveedor());
		carrier.setIdProveedor(dtocarrier.getIdProveedor());
		carrier.setActivo(this.getActivo());
		carrier.setRazonSocial(this.getRazonSocial());
		carrier.setCuit(this.getCuit());
		carrier.setEmail(this.getEmail());
		carrier.setTelefono(this.getTelefono());	
		carrier.setTarifa(dtocarrier.getTarifa());
		carrier.setComentarios(dtocarrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		carrier.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().saveOrUpdate(carrier);
		tx.commit();
	}
	
	public void modificarTallerMecanico(DTO_TallerMecanico taller) {
		
		TallerMecanico tm = new TallerMecanico();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(taller.getIdProveedor());
		tm.setIdProveedor(taller.getIdProveedor());
		tm.setActivo(this.getActivo());
		tm.setRazonSocial(this.getRazonSocial());
		tm.setCuit(this.getCuit());
		tm.setEmail(this.getEmail());
		tm.setTelefono(this.getTelefono());	
		tm.setTarifa(taller.getTarifa());
		tm.setTipoTaller(taller.getTipoTaller());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		tm.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TallerMecanicoDao.getInstancia().saveOrUpdate(tm);
		tx.commit();
	}
	
	public void modificarServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setIdProveedor(seg.getIdProveedor());
		ss.setActivo(this.getActivo());
		ss.setRazonSocial(this.getRazonSocial());
		ss.setCuit(this.getCuit());
		ss.setEmail(this.getEmail());
		ss.setTelefono(this.getTelefono());	
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(this.getDireccion().toDTO());
		
		ss.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		tx.commit();
	}

	
	public void bajaProveedor(Integer id) {
		ProveedorDao.getInstancia().remove(this);

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
	
	public DTO_TallerMecanico buscarTaller(String cuit) {
		return TallerMecanicoDao.getInstancia().getByCuit(cuit).toDTO();
	}
	
	public DTO_TallerMecanico getTallerMecanico(Integer id) {
		return TallerMecanicoDao.getInstancia().getById(id).toDTO();
	}
	
	public DTO_Carrier buscarCarrier(String cuit) {
		return CarrierDao.getInstancia().getByCuit(cuit).toDTO();
	}
	
	public DTO_Carrier getCarrier(Integer id) {
		return CarrierDao.getInstancia().getById(id).toDTO();
	}
	
	public List<DTO_Seguro> getSeguros(){
		List<Seguro> seguros = SeguroDao.getInstancia().getAll();
		List<DTO_Seguro> segurosDTO = new ArrayList<DTO_Seguro>();
		for(Seguro seguro : seguros){
			segurosDTO.add(seguro.toDTO());
		}
		return segurosDTO;
	}
	
	public List<DTO_Carrier> getCarriers(){
		List<Carrier> carriers = CarrierDao.getInstancia().getAll();
		List<DTO_Carrier> carriersDTO = new ArrayList<DTO_Carrier>();
		for(Carrier carrier : carriers){
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
	
	public List<DTO_TallerMecanico> getDTO_TalleresMecanicos(){
		List<TallerMecanico> tallers = TallerMecanicoDao.getInstancia().getAll();
		List<DTO_TallerMecanico> talleresDTO = new ArrayList<DTO_TallerMecanico>();
		for(TallerMecanico taller : tallers){
			talleresDTO.add(taller.toDTO());
		}
		return talleresDTO;
	}
	

}
