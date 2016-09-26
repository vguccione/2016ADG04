package com.ADG04.bean.Encomienda;

import java.io.Serializable;

public class DTO_ItemManifiesto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int idManifiesto;
	private int cantidad;
	private int idProducto;
	private String descripcion;
	
	public DTO_ItemManifiesto(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdManifiesto() {
		return idManifiesto;
	}

	public void setIdManifiesto(int idManifiesto) {
		this.idManifiesto = idManifiesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
