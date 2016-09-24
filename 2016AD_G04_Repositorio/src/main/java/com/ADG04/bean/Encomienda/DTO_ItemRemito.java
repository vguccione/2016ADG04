package com.ADG04.bean.Encomienda;

import java.io.Serializable;

public class DTO_ItemRemito implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int idRemito;
	private int cantidad;
	private String descripcion;
	
	public DTO_ItemRemito(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdRemito() {
		return idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}
	

}
