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
public class ProductoEncomienda implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdProductoEncomienda", unique = true, nullable = false)
	private int idProductoEncomienda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEncomienda", nullable = false)
	private Encomienda encomienda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProducto", nullable = false)
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
