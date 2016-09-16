package com.ADG94.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;

public class DTO_ActividadEncomienda implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date fecha;
	private String descripcion;
	private Integer idEncomienda;
	
	public DTO_ActividadEncomienda(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	
	
}
