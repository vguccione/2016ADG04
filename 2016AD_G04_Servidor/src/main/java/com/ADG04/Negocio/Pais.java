package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;









import com.ADG04.bean.Administracion.DTO_Pais;

public class Pais implements java.io.Serializable {
 
	private int idPais;
	private String descripcion;
	private List<Direccion> direcciones;

	public Pais() {
	}

	public Pais(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	public DTO_Pais toDTO(){
		DTO_Pais p = new DTO_Pais();
		p.setDescripcion(this.descripcion);
		p.setId(this.idPais);
		return p;
	}
	


	
}
