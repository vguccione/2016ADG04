package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;

@Entity
@Table(name = "ItemRemito")
public class ItemRemito implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdItemFactura", unique = true, nullable = false)
	private int idItemRemito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdRemito")
	private Remito remito;

	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name = "Cantidad", nullable = false)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto producto;

	public ItemRemito() {
	}


	public ItemRemito(int idItemRemito,String descripcion,
			int cantidad) {
		super();
		this.idItemRemito = idItemRemito;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getIdItemRemito() {
		return idItemRemito;
	}


	public void setIdItemRemito(int idItemRemito) {
		this.idItemRemito = idItemRemito;
	}


	public Remito getRemito() {
		return remito;
	}


	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public DTO_ItemRemito toDTO() {
		DTO_ItemRemito item= new DTO_ItemRemito();
    	item.setCantidad(this.cantidad);
    	item.setDescripcion(this.descripcion);
    	item.setId(this.idItemRemito);
    	return item;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
