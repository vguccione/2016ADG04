package com.ADG04.Negocio;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_RolUsuario;
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
	
	/*Usuario*/
	
	public void altaUsuario(DTO_Usuario usuario) {
		Sucursal suc = (Sucursal) SucursalDao.getInstancia().getById(usuario.getIdSucursal());
		RolUsuario rol = (RolUsuario) RolUsuarioDao.getInstancia().getById(usuario.getIdRolUsuario());
		
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
		u.setUsuario(usuario.getNombreUsuario());
		u.setPassword(usuario.getPassword());
		
		UsuarioDao.getInstancia().persist(u);
		tx.commit();
	}
	
	public void modificarUsuario(DTO_Usuario usuario) {
		Sucursal suc = (Sucursal) SucursalDao.getInstancia().getById(usuario.getIdSucursal());
		RolUsuario rol = (RolUsuario) RolUsuarioDao.getInstancia().getById(usuario.getIdRolUsuario());
		
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
		u.setUsuario(usuario.getNombreUsuario());
		u.setPassword(usuario.getPassword());
		
		UsuarioDao.getInstancia().saveOrUpdate(u);
		tx.commit();
	}
	
	
	public void bajaUsuario(Integer idUsuario){	
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Usuario u = UsuarioDao.getInstancia().getById(idUsuario);
		
		if (u != null)
			UsuarioDao.getInstancia().remove(u); //baja logica o total?
		
		tx.commit();
	}
	
	
	public DTO_Usuario getUsuario(Integer idUsuario) {
		return UsuarioDao.getInstancia().getById(idUsuario).toDTO();
	}
	
	public DTO_Usuario getUsuario(String dni) {
		return UsuarioDao.getInstancia().getByDni(dni).toDTO();
	}
	
	
	 public DTO_Usuario login(String usuario, String password){
		 Usuario u = UsuarioDao.getInstancia().buscarUsuario(usuario);
		 if (u.getPassword().equals(password))
			 return u.toDTO();
		 else
			 return null;
	 }
	 
	 public List<DTO_Usuario> listarEmpleados(){
		 List<Usuario> empleados = UsuarioDao.getInstancia().getAll();
		 List<DTO_Usuario> empleadosDTO = new ArrayList<DTO_Usuario>();
	    for(Usuario empleado : empleados){
	    	empleadosDTO.add(empleado.toDTO());	    		
	    }
		return empleadosDTO;
	 }
	 public List<DTO_Usuario> listarEmpleados(Integer idSucursal){
		 List<Usuario> empleados = UsuarioDao.getInstancia().listarEmpleados(idSucursal);
		 List<DTO_Usuario> empleadosDTO = new ArrayList<DTO_Usuario>();
	    for(Usuario empleado : empleados){
	    	empleadosDTO.add(empleado.toDTO());	    		
	    }
		return empleadosDTO;
	 }
	 
	 //Roles
	 public List<DTO_RolUsuario> listarRoles(){
		 List<RolUsuario> lista = RolUsuarioDao.getInstancia().getAll();
		 List<DTO_RolUsuario> listaDTO = new ArrayList<DTO_RolUsuario>();
         for(RolUsuario p: lista)
         	listaDTO.add(p.toDTO());
         
		 return listaDTO;
	 }
	 
	 
	 public List<DTO_RolUsuario> buscarRolesUsuario(String usuario){
		 List<RolUsuario> roles = RolUsuarioDao.getInstancia().buscarRolesUsuario(usuario);
		 List<DTO_RolUsuario> dtoRoles = new ArrayList<DTO_RolUsuario>();
	    	for(RolUsuario rol : roles){
	    		DTO_RolUsuario dto = new DTO_RolUsuario();
	    		dto.setId(rol.getIdRolUsuario());
	    		dto.setdescripcion(rol.getDescripcion());
	    		dtoRoles.add(dto);	    		
	    	}
		return dtoRoles;
	 }
	 
		
	/*Sucursal*/

	public int altaSucursal(DTO_Sucursal sucursal) {	
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
		
		return s.getIdSucursal();
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
	

	 public List<DTO_Sucursal> listarSucursales(){
		 List<Sucursal> sucursales = SucursalDao.getInstancia().getAll();
		 List<DTO_Sucursal> sucursalesDTO = new ArrayList<DTO_Sucursal>();
		 for(Sucursal sucursal : sucursales){
	    	sucursalesDTO.add(sucursal.toDTO());	    		
	    }
		return sucursalesDTO;
	 }
	
	/*Direccion*/
	
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
	
	public List<DTO_Pais> listarPaises(){
		List<Pais> paises = PaisDao.getInstancia().getAll();
		List<DTO_Pais> paisesDTO = new ArrayList<DTO_Pais>();
	    for(Pais pais : paises){
	    	paisesDTO.add(pais.toDTO());	    		
	    }
		return paisesDTO;
	}
	
	public List<DTO_Provincia> listarProvincias(int idPais){
		List<Provincia> provincias = ProvinciaDao.getInstancia().getByPais(idPais);
		List<DTO_Provincia> provinciasDTO = new ArrayList<DTO_Provincia>();
	    for(Provincia prov : provincias){
	    	provinciasDTO.add(prov.toDTO());	    		
	    }
		return provinciasDTO;
	}
	
	
	
}
