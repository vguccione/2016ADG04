package com.ADG04.bean.Administracion;

import java.io.Serializable;

public class DTO_Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descripcion;

	public DTO_Rol(){}
	
	public DTO_Rol(int idRolUsuario, String descripcionRol)
	{
		this.id = idRolUsuario;
		this.descripcion = descripcionRol;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String pais) {
		this.descripcion = pais;
	}
	
}
