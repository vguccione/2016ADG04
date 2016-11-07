package com.ADG04.Negocio;
// default package

import java.util.List;












import com.ADG04.Servidor.model.RolE;
import com.ADG04.bean.Administracion.DTO_Rol;

public class Rol{

	private int idRol;
	private String descripcion;
	private List<Usuario> usuarios;

	public Rol() {
	}
	
	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public Rol(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public DTO_Rol toDTO() {
		DTO_Rol rol = new DTO_Rol();
		rol.setdescripcion(this.descripcion);
		rol.setId(this.idRol);
		
		return rol;
	}

	public Rol fromEntity(RolE p) {
		if(p!=null){
			Rol r = new Rol();
			r.setDescripcion(p.getDescripcion());
			r.setIdRol(p.getIdRol());
			return r;
		}
		else
			return null;
	}


}
