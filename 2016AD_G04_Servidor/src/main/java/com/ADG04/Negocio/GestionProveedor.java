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


public class GestionProveedor {

	private EntityManagerFactory factory;
	private Proveedor proveedor;
	private Seguro seguro;
	private Carrier carrier;
	private TallerMecanico tm;
	private ServicioSeguridad ss;
	
	public GestionProveedor(Proveedor prov){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		proveedor = prov;
		seguro = new Seguro();
		carrier = new Carrier();
		tm = new TallerMecanico();
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
		seguro.setActivo(proveedor.getActivo());
		seguro.setRazonSocial(proveedor.getRazonSocial());
		seguro.setCuit(proveedor.getCuit());
		seguro.setEmail(proveedor.getEmail());
		seguro.setTelefono(proveedor.getTelefono());	
		seguro.setTarifa(dtoSeguro.getTarifa());
		seguro.setTarifaPorKm(dtoSeguro.getTarifaPorKm());
		seguro.setDescripcion(dtoSeguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		seguro.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().persist(seguro);
		tx.commit();
	}
	
	public void altaCarrier(DTO_Carrier dtoCarrier) {
		
		
		//proveedor = ProveedorDao.getInstancia().getById(dtoCarrier.getIdProveedor());
		carrier.setActivo(proveedor.getActivo());
		carrier.setRazonSocial(proveedor.getRazonSocial());
		carrier.setCuit(proveedor.getCuit());
		carrier.setEmail(proveedor.getEmail());
		carrier.setTelefono(proveedor.getTelefono());	
		carrier.setTarifa(dtoCarrier.getTarifa());
		carrier.setComentarios(dtoCarrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		carrier.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().persist(carrier);
		tx.commit();
	}
	
	public void altaTallerMecanico(DTO_TallerMecanico taller) {
		
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(taller.getIdProveedor());
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
		
		//ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
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

	
	
	public void modificarSeguro(DTO_Seguro dtoseguro){
		//Seguro s = new Seguro();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seguro.getIdProveedor());
		seguro.setIdProveedor(dtoseguro.getIdProveedor());
		seguro.setActivo(proveedor.getActivo());
		seguro.setRazonSocial(proveedor.getRazonSocial());
		seguro.setCuit(proveedor.getCuit());
		seguro.setEmail(proveedor.getEmail());
		seguro.setTelefono(proveedor.getTelefono());	
		seguro.setTarifa(dtoseguro.getTarifa());
		seguro.setTarifaPorKm(dtoseguro.getTarifaPorKm());
		seguro.setDescripcion(dtoseguro.getDescripcion());
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		seguro.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SeguroDao.getInstancia().saveOrUpdate(seguro);
		tx.commit();
	}

	
	public void modificarCarrier(DTO_Carrier dtocarrier) {
		
		//Carrier c = new Carrier();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(carrier.getIdProveedor());
		carrier.setIdProveedor(dtocarrier.getIdProveedor());
		carrier.setActivo(proveedor.getActivo());
		carrier.setRazonSocial(proveedor.getRazonSocial());
		carrier.setCuit(proveedor.getCuit());
		carrier.setEmail(proveedor.getEmail());
		carrier.setTelefono(proveedor.getTelefono());	
		carrier.setTarifa(dtocarrier.getTarifa());
		carrier.setComentarios(dtocarrier.getComentarios());
		
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(proveedor.getDireccion().toDTO());
		
		carrier.setDireccion(dir);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		CarrierDao.getInstancia().saveOrUpdate(carrier);
		tx.commit();
	}
	
	public void modificarTallerMecanico(DTO_TallerMecanico taller) {
		
		//TallerMecanico tm = new TallerMecanico();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(taller.getIdProveedor());
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
		
		//ServicioSeguridad ss = new ServicioSeguridad();
		//Proveedor proveedor = ProveedorDao.getInstancia().getById(seg.getIdProveedor());
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
		//Proveedor p = ProveedorDao.getInstancia().getById(id);
		if (proveedor != null){
			ProveedorDao.getInstancia().remove(proveedor);
		}
	}


	

}
