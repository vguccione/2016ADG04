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
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.Provincia;
import com.ADG04.Servidor.model.Rol;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;


public class GestionAdministracion {


	private EntityManagerFactory factory;
	
	private Usuario usuario;
	private Sucursal sucursal;
	private Pais pais;
	private Provincia provincia;
	private Direccion direccion;
	
	public GestionAdministracion(Usuario usuario, Sucursal sucursal, Pais pais,
			Provincia provincia, Direccion direccion) {
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
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
				
		SucursalDao.getInstancia().persist(sucursal);
		
		tx.commit();
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
	
	
	public Direccion crearDireccion(DTO_Direccion direccion) {
		
		/*Crear Direccion*/
		Direccion dir = new Direccion();
		dir.setCalle(direccion.getCalle());
		dir.setCodigoPostal(direccion.getCodigoPostal());
		dir.setLocalidad(direccion.getLocalidad());
		dir.setNro(direccion.getNro());
		
		ProvinciaDao provDao = ProvinciaDao.getInstancia();
		Provincia prov = (Provincia) provDao.getById(direccion.getProvincia().getId());
		
		dir.setProvincia(prov);
		
		PaisDao paisDao = PaisDao.getInstancia();
		Pais pais = (Pais) paisDao.getById(direccion.getPais().getId());
		
		dir.setPais(pais);
		
		return dir;
	}

}
