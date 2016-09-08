package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
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
	private RolUsuario rolUsuario;

	@Column(name = "Nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "Apellido", nullable = false, length = 100)
	private String apellido;

	@Column(name = "Dni", nullable = false, length = 8)	
	private String dni;

	
	public Usuario() {
	}

	public Usuario(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public Usuario(int idUsuario, Sucursal sucursal, RolUsuario rolUsuario,
			String nombre, String apellido, String dni) {
		this.idUsuario = idUsuario;
		this.sucursal = sucursal;
		this.rolUsuario = rolUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}


	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public RolUsuario getRolUsuario() {
		return this.rolUsuario;
	}

	public void setRolUsuario(RolUsuario rolUsuario) {
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

}
