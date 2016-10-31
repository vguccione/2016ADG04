package com.ADG04.Negocio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.dao.RolDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.PaisE;
import com.ADG04.Servidor.model.ProvinciaE;
import com.ADG04.Servidor.model.RolE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;


public class GestionAdministracion {


	private EntityManagerFactory factory;
	
	private UsuarioE usuario;
	private SucursalE sucursal;
	private PaisE pais;
	private ProvinciaE provincia;
	private DireccionE direccion;
	
	public GestionAdministracion(UsuarioE usuario, SucursalE sucursal, PaisE pais,
			ProvinciaE provincia, DireccionE direccion) {
		super();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		this.usuario = usuario;
		this.sucursal = sucursal;
		this.pais = pais;
		this.provincia = provincia;
		this.direccion = direccion;
	}

	public GestionAdministracion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*Usuario*/	

	public void guardarUsuario() {
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UsuarioDao.getInstancia().persist(usuario);
		tx.commit();
	}
	
	public void modificarUsuario() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		UsuarioDao.getInstancia().saveOrUpdate(usuario);
		tx.commit();
	}
	 
		
	/*Sucursal*/
	public void guardarSucursal() {	
	/*	EntityManager em =  EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	*/
		SucursalDao.getInstancia().persist(sucursal);
	//	tx.commit();
	}

	public void modificarSucursal() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SucursalDao.getInstancia().saveOrUpdate(sucursal);
		tx.commit();
	}
	
	
	public void guardarPais(){
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PaisDao.getInstancia().persist(pais);
		tx.commit();
	}
	
	public void guardarProvincia(){
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProvinciaDao.getInstancia().persist(provincia);
		tx.commit();
	}
	
	
	public DireccionE crearDireccion(DTO_Direccion direccion) {
		
		/*Crear Direccion*/
		DireccionE dir = new DireccionE();
		dir.setCalle(direccion.getCalle());
		dir.setCodigoPostal(direccion.getCodigoPostal());
		dir.setLocalidad(direccion.getLocalidad());
		dir.setNro(direccion.getNro());
		
		ProvinciaDao provDao = ProvinciaDao.getInstancia();
		ProvinciaE prov = (ProvinciaE) provDao.getById(direccion.getProvincia().getId());
		
		dir.setProvincia(prov);
		
		PaisDao paisDao = PaisDao.getInstancia();
		PaisE pais = (PaisE) paisDao.getById(direccion.getPais().getId());
		
		dir.setPais(pais);
		
		return dir;
	}

}
