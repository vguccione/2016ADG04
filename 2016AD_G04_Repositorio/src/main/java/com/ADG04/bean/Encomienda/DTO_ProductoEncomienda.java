package com.ADG04.bean.Encomienda;

import java.io.Serializable;


public class DTO_ProductoEncomienda implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private float cantidad;
	private Integer idProductoCliente;
	
	public DTO_ProductoEncomienda(){
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdProductoCliente() {
		return idProductoCliente;
	}

	public void setIdProductoCliente(Integer idProductoCliente) {
		this.idProductoCliente = idProductoCliente;
	}

}
