package com.ADG04.bean.Encomienda;

import java.io.Serializable;


public class DTO_ProductoEncomienda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cantidad;
	private Integer idProductoCliente;
	private Integer idEncomienda;
	private String descProducto;
	
	public DTO_ProductoEncomienda(){
	}
	
	public DTO_ProductoEncomienda(Integer cantidad, Integer idProductoCliente) {
		super();
		this.cantidad = cantidad;
		this.idProductoCliente = idProductoCliente;
	}
	
	public DTO_ProductoEncomienda(Integer cantidad, Integer idProductoCliente,
			Integer idEncomienda) {
		super();
		this.cantidad = cantidad;
		this.idProductoCliente = idProductoCliente;
		this.idEncomienda = idEncomienda;
	}



	public DTO_ProductoEncomienda(Integer id, Integer cantidad,
			Integer idProductoCliente, Integer idEncomienda, String descProducto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.idProductoCliente = idProductoCliente;
		this.idEncomienda = idEncomienda;
		this.descProducto = descProducto;
	}

	public String getDescProducto() {
		return descProducto;
	}

	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdProductoCliente() {
		return idProductoCliente;
	}

	public void setIdProductoCliente(Integer idProductoCliente) {
		this.idProductoCliente = idProductoCliente;
	}

	public Integer getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	
}
