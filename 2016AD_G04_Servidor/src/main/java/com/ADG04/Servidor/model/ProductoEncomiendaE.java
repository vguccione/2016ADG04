package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductoEncomienda")
public class ProductoEncomiendaE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdProductoEncomienda", unique = true, nullable = false)
	private int idProductoEncomienda;

	@Column(name = "cantidad", unique = true, nullable = false)
	private float cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEncomienda", nullable = false)
	private EncomiendaE encomienda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProducto", nullable = false)
	private ProductoE producto;

	public ProductoEncomiendaE() {
	}

	public ProductoEncomiendaE(EncomiendaE encomienda,ProductoE producto) {
		this.encomienda = encomienda;
		this.producto = producto;
	}

	
	public int getIdProductoEncomienda() {
		return this.idProductoEncomienda;
	}

	public void setIdProductoEncomienda(int idProductoEncomienda) {
		this.idProductoEncomienda = idProductoEncomienda;
	}

	public EncomiendaE getEncomienda() {
		return this.encomienda;
	}

	public void setEncomienda(EncomiendaE encomienda) {
		this.encomienda = encomienda;
	}

	public ProductoE getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoE producto) {
		this.producto = producto;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
