package com.ADG04.Negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.CarrierDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.TallerMecanicoDao;
import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.model.TallerMecanico;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Proveedor.DTO_Carrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TallerMecanico;


public class GestionProveedor {

	private static GestionProveedor instancia;
	
	private EntityManagerFactory factory;
	
	private GestionProveedor(){
		
	}
	
	public static GestionProveedor getInstancia(){
		if(instancia == null){
			instancia = new GestionProveedor();
		} 
		return instancia;
	}

	
	public void altaSeguro(DTO_Seguro seguro) {
		
		Seguro s = new Seguro();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(seguro.getIdProveedor());
		s.setActivo(proveedor.getActivo());
		s.setRazonSocial(proveedor.getRazonSocial());
		s.setCuit(proveedor.getCuit());
		s.setEmail(proveedor.getEmail());
		s.setTelefono(proveedor.getTelefono());	
		s.setTarifa(seguro.getTarifa());
		s.setTarifaPorKm(seguro.getTarifaPorKm());
		s.setDescripcion(seguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		s.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().persist(s);
		tx.commit();
	}
	
	public void altaCarrier(DTO_Carrier carrier) {
		
		Carrier c = new Carrier();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(carrier.getIdProveedor());
		c.setActivo(proveedor.getActivo());
		c.setRazonSocial(proveedor.getRazonSocial());
		c.setCuit(proveedor.getCuit());
		c.setEmail(proveedor.getEmail());
		c.setTelefono(proveedor.getTelefono());	
		c.setTarifa(carrier.getTarifa());
		c.setComentarios(carrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		c.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().persist(c);
		tx.commit();
	}
	
	public void altaTallerMecanico(DTO_TallerMecanico taller) {
		
		TallerMecanico tm = new TallerMecanico();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(taller.getIdProveedor());
		tm.setActivo(proveedor.getActivo());
		tm.setRazonSocial(proveedor.getRazonSocial());
		tm.setCuit(proveedor.getCuit());
		tm.setEmail(proveedor.getEmail());
		tm.setTelefono(proveedor.getTelefono());	
		tm.setTarifa(taller.getTarifa());
		tm.setTipoTaller(taller.getTipoTaller());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		tm.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TallerMecanicoDao.getInstancia().persist(tm);
		tx.commit();
	}
	
	public void altaServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		ServicioSeguridad ss = new ServicioSeguridad();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setActivo(proveedor.getActivo());
		ss.setRazonSocial(proveedor.getRazonSocial());
		ss.setCuit(proveedor.getCuit());
		ss.setEmail(proveedor.getEmail());
		ss.setTelefono(proveedor.getTelefono());	
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		ss.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().persist(ss);
		tx.commit();
	}

	
	
	public void modificarSeguro(DTO_Seguro seguro){
		Seguro s = new Seguro();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(seguro.getIdProveedor());
		s.setIdProveedor(seguro.getIdProveedor());
		s.setActivo(proveedor.getActivo());
		s.setRazonSocial(proveedor.getRazonSocial());
		s.setCuit(proveedor.getCuit());
		s.setEmail(proveedor.getEmail());
		s.setTelefono(proveedor.getTelefono());	
		s.setTarifa(seguro.getTarifa());
		s.setTarifaPorKm(seguro.getTarifaPorKm());
		s.setDescripcion(seguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		s.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().saveOrUpdate(s);
		tx.commit();
	}

	
	public void modificarCarrier(DTO_Carrier carrier) {
		
		Carrier c = new Carrier();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(carrier.getIdProveedor());
		c.setIdProveedor(carrier.getIdProveedor());
		c.setActivo(proveedor.getActivo());
		c.setRazonSocial(proveedor.getRazonSocial());
		c.setCuit(proveedor.getCuit());
		c.setEmail(proveedor.getEmail());
		c.setTelefono(proveedor.getTelefono());	
		c.setTarifa(carrier.getTarifa());
		c.setComentarios(carrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		c.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().saveOrUpdate(c);
		tx.commit();
	}
	
	public void modificarTallerMecanico(DTO_TallerMecanico taller) {
		
		TallerMecanico tm = new TallerMecanico();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(taller.getIdProveedor());
		tm.setIdProveedor(taller.getIdProveedor());
		tm.setActivo(proveedor.getActivo());
		tm.setRazonSocial(proveedor.getRazonSocial());
		tm.setCuit(proveedor.getCuit());
		tm.setEmail(proveedor.getEmail());
		tm.setTelefono(proveedor.getTelefono());	
		tm.setTarifa(taller.getTarifa());
		tm.setTipoTaller(taller.getTipoTaller());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		tm.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TallerMecanicoDao.getInstancia().saveOrUpdate(tm);
		tx.commit();
	}
	
	public void modificarServicioSeguridad(DTO_ServicioSeguridad seg) {
		
		ServicioSeguridad ss = new ServicioSeguridad();
		Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
		ss.setIdProveedor(seg.getIdProveedor());
		ss.setActivo(proveedor.getActivo());
		ss.setRazonSocial(proveedor.getRazonSocial());
		ss.setCuit(proveedor.getCuit());
		ss.setEmail(proveedor.getEmail());
		ss.setTelefono(proveedor.getTelefono());	
		ss.setTarifa(seg.getTarifa());
		ss.setDescripcion(seg.getDescripcion());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		ss.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ServicioSeguridadDao.getInstancia().saveOrUpdate(ss);
		tx.commit();
	}

	
	public void bajaProveedor(Integer id) {
		Proveedor p = ProveedorDao.getInstancia().getById(id);
		if (p != null){
			ProveedorDao.getInstancia().remove(p);
		}
	}

	/*public DTO_Proveedor buscarProveedor(String cuit) {
		return ProveedorDao.getInstancia().buscarProveedor(cuit).toDTO();
	}
	
	public DTO_Proveedor getProveedor(Integer id) {
		return ProveedorDao.getInstancia().getById(id).toDTO();
	}*/
	

}
