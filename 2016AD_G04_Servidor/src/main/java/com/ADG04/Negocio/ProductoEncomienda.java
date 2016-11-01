package com.ADG04.Negocio;

public class ProductoEncomienda implements java.io.Serializable {

	private int idProductoEncomienda;
	private Encomienda encomienda;
	private Producto producto;

	public ProductoEncomienda() {
	}

	public ProductoEncomienda(Encomienda encomienda,Producto producto) {
		this.encomienda = encomienda;
		this.producto = producto;
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

}
