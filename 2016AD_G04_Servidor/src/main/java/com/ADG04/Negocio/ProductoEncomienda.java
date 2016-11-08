package com.ADG04.Negocio;

import com.ADG04.Servidor.model.ProductoEncomiendaE;
import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;

public class ProductoEncomienda{

	private int idProductoEncomienda;
	private Encomienda encomienda;
	private Producto producto;
	private float cantidad;
	
	public ProductoEncomienda() {
	}

	public ProductoEncomienda(Encomienda encomienda,Producto producto) {
		this.encomienda = encomienda;
		this.producto = producto;
	}

	
	public ProductoEncomienda(Producto producto) {
		this.producto =producto;
	}

	public int getIdProductoEncomienda() {
		return this.idProductoEncomienda;
	}

	public void setIdProductoEncomienda(int idProductoEncomienda) {
		this.idProductoEncomienda = idProductoEncomienda;
	}

	public Encomienda getEncomienda() {
		return this.encomienda;
	}

	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DTO_ProductoEncomienda toDTO() {
		
		DTO_ProductoEncomienda p = new DTO_ProductoEncomienda();
		
		p.setCantidad(this.cantidad);
		p.setIdEncomienda(this.encomienda.getIdEncomienda());
		p.setIdProductoCliente(this.producto.getIdProducto());
		
		return p;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoEncomienda fromEntity(ProductoEncomiendaE byId) {
		// TODO Auto-generated method stub
		return null;
	}

}
