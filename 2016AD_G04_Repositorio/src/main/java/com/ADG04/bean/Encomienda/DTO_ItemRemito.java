package com.ADG04.bean.Encomienda;

import java.io.Serializable;

import com.ADG04.bean.Cliente.DTO_Producto;

public class DTO_ItemRemito implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private DTO_Remito remito;
	private int cantidad;
	private String descripcion;
	private DTO_Producto producto;
	
	public DTO_ItemRemito(){
	}
	
	

	public DTO_ItemRemito(String descripcion,
			int idProducto,int cantidad) {
		
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.producto = new DTO_Producto();
		this.producto.setId(idProducto);
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


	public DTO_Remito getRemito() {
		return remito;
	}

	public void setRemito(DTO_Remito remito) {
		this.remito = remito;
	}

	public DTO_Producto getProducto() {
		return producto;
	}

	public void setProducto(DTO_Producto producto) {
		this.producto = producto;
	}


	
}
