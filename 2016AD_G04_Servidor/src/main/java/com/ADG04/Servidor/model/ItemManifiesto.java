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

import com.ADG04.bean.Cliente.DTO_ItemManifiesto;

@Entity
@Table(name = "ItemManifiesto")
public class ItemManifiesto implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdItemManifiesto", unique = true, nullable = false)
	private int idItemManifiesto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdManifiesto")
	private Manifiesto manifiesto;

	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name = "Cantidad", nullable = false)
	private int cantidad;

	@Column(name = "Producto")
	private Producto producto;

	public ItemManifiesto() {
	}


	public ItemManifiesto(String descripcion, int cantidad) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Manifiesto getManifiesto() {
		return manifiesto;
	}


	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}


	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DTO_ItemManifiesto toDTO(){
    	DTO_ItemManifiesto im = new DTO_ItemManifiesto();
    	im.setCantidad(this.cantidad);
    	im.setDescripcion(this.descripcion);
    	im.setIdManifiesto(this.getManifiesto().getIdManifiesto());
    	im.setIdProducto(this.getProducto().getIdProducto());
    	return im;
    }


}
