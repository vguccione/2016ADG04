package com.ADG04.Negocio;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.dao.RolUsuarioDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.Provincia;
import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;



public class GestionAdministracion {

private static GestionAdministracion instancia;
	
	private EntityManagerFactory factory;
	
	private GestionAdministracion(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionAdministracion getInstancia(){
		if(instancia == null){
			instancia = new GestionAdministracion();
		} 
		return instancia;
	}
	
	public void altaUsuario(DTO_Usuario usuario) {
		Sucursal suc = (Sucursal) SucursalDao.getInstancia().getById(usuario.getId());
		RolUsuario rol = new RolUsuario(usuario.getRolUsuario().getdescripcion());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Usuario u= new Usuario();
		u.setNombre(usuario.getNombre());
		u.setApellido(usuario.getApellido());
		u.setDni(usuario.getDni());
		u.setUltimoAcceso(usuario.getUltimoAcceso());
		u.setFechaCreacion(usuario.getFechaCreacion());
		u.setSucursal(suc);
		u.setRolUsuario(rol);
		
		UsuarioDao.getInstancia().persist(u);
		tx.commit();
		//EntityManagerProvider.getInstance().close();
	}
	
	public void modificarUsuario(DTO_Usuario usuario) {
		EntityManager em = factory.createEntityManager();
		
		Sucursal suc = (Sucursal) SucursalDao.getInstancia().getById(usuario.getId());
		RolUsuario rol = new RolUsuario(usuario.getRolUsuario().getdescripcion());
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Usuario u= new Usuario();
		u.setNombre(usuario.getNombre());
		u.setApellido(usuario.getApellido());
		u.setDni(usuario.getDni());
		u.setUltimoAcceso(usuario.getUltimoAcceso());
		u.setFechaCreacion(usuario.getFechaCreacion());
		u.setSucursal(suc);
		u.setRolUsuario(rol);
		UsuarioDao.getInstancia().saveOrUpdate(u);
		tx.commit();
		//EntityManagerProvider.getInstance().close();
	}
	
	
	public void bajaUsuario(Integer idUsuario){
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Usuario u = UsuarioDao.getInstancia().getById(idUsuario);
		
		if (u != null)
			UsuarioDao.getInstancia().remove(u); //baja logica o total?
		
		tx.commit();
		//EntityManagerProvider.getInstance().close();
	}
	
	
	public DTO_Usuario getUsuario(Integer idUsuario) {
		return UsuarioDao.getInstancia().getById(idUsuario).toDTO();
	}
	
	public DTO_Usuario getUsuario(String dni) {
		return UsuarioDao.getInstancia().getByDni(dni).toDTO();
	}

	public void altaSucursal(DTO_Sucursal sucursal) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		/*Crear Direccion*/
		Direccion dir = crearDireccion(sucursal.getDireccion());
			
		/*Crear Sucursal*/		
		Sucursal s = new Sucursal();
		s.setDescripcion(sucursal.getDescripcion());
		s.setTelefono(sucursal.getTelefono());
		s.setDireccion(dir);
		
		SucursalDao.getInstancia().persist(s);
		tx.commit();
	}

	public void modificarSucursal(DTO_Sucursal sucursal) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		/*Crear Direccion*/
		Direccion dir = crearDireccion(sucursal.getDireccion());
		
		Sucursal s = new Sucursal();
		s.setDescripcion(sucursal.getDescripcion());
		s.setTelefono(sucursal.getTelefono());
		s.setDireccion(dir);
		
		SucursalDao.getInstancia().saveOrUpdate(s);
		tx.commit();
	}

	public void bajaSucursal(Integer idSucursal){
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Sucursal s = SucursalDao.getInstancia().getById(idSucursal);
		
		if (s != null)
			SucursalDao.getInstancia().remove(s); //baja logica o total?
		
		tx.commit();
	}

	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		 return SucursalDao.getInstancia().getById(idSucursal).toDTO();
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
