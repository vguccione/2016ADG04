package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;












import javax.management.relation.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.RolDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.RolE;
import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;

public class Usuario{

	private int idUsuario;
	private int idSucursal;
	private Rol rolUsuario;
	private String nombre;
	private String apellido;
	private String dni;
	private String usuario;
	private String password;
	private Date ultimoAcceso;
	private Date fechaCreacion;
	private List<Rol> roles;
	
	public Usuario() {
	}

	public Usuario(int idSucursal, int idUsuario, String nombre, String apellido, String usuario,
			String dni, String password, Date ultimoAcceso, Date fechaCreacion) {
		super();
		this.idSucursal = idSucursal;
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.dni = dni;
		this.password = password;
		this.ultimoAcceso = ultimoAcceso;
		this.fechaCreacion = fechaCreacion;
	}

	
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Rol getRolUsuario() {
		return this.rolUsuario;
	}

	public void setRolUsuario(Rol rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", sucursal=" + idSucursal
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", password=" + password + ", ultimoAcceso="
				+ ultimoAcceso + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	
	
	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public DTO_Usuario toDTO(){
		DTO_Usuario u = new DTO_Usuario();
		u.setDni(this.getDni());
		u.setNombre(this.getNombre());
		u.setApellido(this.getApellido());
		u.setPassword(this.getPassword());
		u.setFechaCreacion(this.getFechaCreacion());
		u.setUltimoAcceso(this.getUltimoAcceso());
		u.setIdUsuario(this.getIdUsuario());
		u.setIdSucursal(this.getIdSucursal());
		u.setUsuario(this.getUsuario());
		List<DTO_Rol> roles = new ArrayList<DTO_Rol>();
		for(Rol r: this.getRoles()){
			roles.add(r.toDTO());
		}
		u.setRoles(roles);
		
		return u;
	}
	
	public Usuario fromDTO(DTO_Usuario usu){
		if(usu!=null){
			Usuario usuario =new Usuario(usu.getIdSucursal(), usu.getIdUsuario(), usu.getNombre(), usu.getApellido(), 
					 usu.getUsuario(),usu.getDni(), usu.getPassword(), usu.getUltimoAcceso(), usu.getFechaCreacion());
			
			List<Rol> roles = new ArrayList<Rol>();
			for(DTO_Rol r: usu.getRoles()){
				Rol rol = new Rol();
				rol.setDescripcion(r.getdescripcion());
				rol.setIdRol(r.getId());
				roles.add(rol);
			}
			usuario.setRoles(roles);
			
			return usuario;
		}
		else
			return null;
	}
	
	public UsuarioE toEntity(){
		UsuarioE usu = new UsuarioE();
		usu.setApellido(this.apellido);
		usu.setDni(dni);
		usu.setFechaCreacion(fechaCreacion);
		usu.setIdUsuario(idUsuario);
		usu.setUsuario(this.usuario);
		usu.setNombre(nombre);
		usu.setPassword(password);
		usu.setSucursal(SucursalDao.getInstancia().getById(this.getIdSucursal()));
		usu.setUltimoAcceso(ultimoAcceso);
		
		List<RolE> rolesE = new ArrayList<RolE>();
		for(Rol r:this.getRoles()){
			RolE rol = RolDao.getInstancia().getById(r.getIdRol());
			rolesE.add(rol);
		}
		
		usu.setRoles(rolesE);
		return usu;
	}
	
	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		UsuarioDao.getInstancia().persist(this.toEntity());
		tx.commit();
	}
	
	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();		
		UsuarioDao.getInstancia().saveOrUpdate(this.toEntity());
		tx.commit();
	}

	public Usuario fromEntity(UsuarioE usu) {
		if(usu!=null){
			Usuario usuario =new Usuario(usu.getSucursal().getIdSucursal(), usu.getIdUsuario(), usu.getNombre(), usu.getApellido(), 
					 usu.getUsuario(),usu.getDni(), usu.getPassword(), usu.getUltimoAcceso(), usu.getFechaCreacion());
			
			List<Rol> roles = new ArrayList<Rol>();
			for(RolE r: usu.getRoles()){
				Rol rol = new Rol();
				rol.setDescripcion(r.getDescripcion());
				rol.setIdRol(r.getIdRol());
				roles.add(rol);
			}
			usuario.setRoles(roles);
			
			return usuario;
		}
		else
			return null;
	}

	
}
