package com.ADG94.bean.Administracion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DTO_Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	private Date ultimoAcceso;
	private Date fechaCreacion;
	private DTO_RolUsuario rolUsuario;  
	private Integer idEmpleado;
		
	public DTO_Usuario() {
	
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	
	public DTO_RolUsuario getRolUsuario() {
		return this.rolUsuario;
	}

	public void setrolUsuarios(DTO_RolUsuario rol) {
		this.rolUsuario = rol;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
