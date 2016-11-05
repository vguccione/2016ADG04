package com.ADG04.Servidor.model;
// default package

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_Rol;

@Entity
@Table(name = "Rol")
public class RolE implements java.io.Serializable {


	@Id
	@GeneratedValue
	@Column(name = "IdRol", unique = true, nullable = false)
	private int idRol;

	@Column(name = "Descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@ManyToMany(mappedBy="roles")	
	private List<UsuarioE> usuarios;


	public RolE() {
	}

	
	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public List<UsuarioE> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioE> usuarios) {
		this.usuarios = usuarios;
	}


	public RolE(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
