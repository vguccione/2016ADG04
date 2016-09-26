package com.ADG04.Servidor.model;
// default package

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_RolUsuario;

@Entity
@Table(name = "RolUsuario")
public class RolUsuario implements java.io.Serializable {


	@Id
	@GeneratedValue
	@Column(name = "IdRolUsuario", unique = true, nullable = false)
	private int idRolUsuario;

	@Column(name = "Descripcion", nullable = false, length = 50)
	private String descripcion;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "rolUsuario")
	private List<Usuario> usuarios;

	public RolUsuario() {
	}

	public RolUsuario(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdRolUsuario() {
		return this.idRolUsuario;
	}

	public void setIdRolUsuario(int idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public DTO_RolUsuario toDTO() {
		DTO_RolUsuario rol = new DTO_RolUsuario();
		rol.setdescripcion(this.descripcion);
		rol.setId(this.getIdRolUsuario());
		
		return rol;
	}


}
