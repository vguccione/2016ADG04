package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Usuario;



@Entity
@Table(name="Usuario")
public class Usuario implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdUsuario", unique = true, nullable = false)
	private int idUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursal")
	private Sucursal sucursal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdRolUsuario")
	private Rol rolUsuario;

	@Column(name = "Nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "Apellido", nullable = false, length = 100)
	private String apellido;

	@Column(name = "Dni", nullable = false, length = 8)	
	private String dni;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "UltimoAcceso")
	private Date ultimoAcceso;
	
	@Column(name = "fechaCreacion")
	private Date fechaCreacion;

	@ManyToMany
	@JoinTable(name="UsuarioRol",
        joinColumns=
            @JoinColumn(name="Usuario"),
        inverseJoinColumns=
            @JoinColumn(name="IdRol"))	
	private List<Rol> roles;
	
	public Usuario() {
	}

	public Usuario(Sucursal sucursal, String nombre, String apellido, String usuario,
			String dni, String password, Date ultimoAcceso, Date fechaCreacion) {
		super();
		this.sucursal = sucursal;
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
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
		return "Usuario [idUsuario=" + idUsuario + ", sucursal=" + sucursal
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
		
		List<DTO_Rol> roles = new ArrayList<DTO_Rol>();
		for(Rol r: this.getRoles()){
			roles.add(r.toDTO());
		}
		u.setRoles(roles);
		
		return u;
	}

	
}
