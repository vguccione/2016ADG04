package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;

public class DTO_Manifiesto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String categoria;
	private String otro;
	private Date fecha;
	private String descripcion;
	private String archivo;
	
	public DTO_Manifiesto(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getOtro() {
		return otro;
	}
	public void setOtro(String otro) {
		this.otro = otro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}
