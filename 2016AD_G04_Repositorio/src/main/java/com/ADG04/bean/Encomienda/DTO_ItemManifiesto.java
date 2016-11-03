package com.ADG04.bean.Encomienda;

import java.io.Serializable;

import com.ADG04.bean.Cliente.DTO_Producto;

public class DTO_ItemManifiesto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int idManifiesto;
	private int cantidad;
	private DTO_Producto Producto;
	private String descripcion;
	
	public DTO_ItemManifiesto(){
	}
	
	public DTO_ItemManifiesto(String descripcion){
		this.descripcion = descripcion;
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

	
	public DTO_Producto getProducto() {
		return Producto;
	}

	public void setProducto(DTO_Producto producto) {
		Producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
