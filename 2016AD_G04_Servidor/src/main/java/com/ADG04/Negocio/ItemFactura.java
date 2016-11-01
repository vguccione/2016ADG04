package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


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



@Table(name = "ItemFactura")
public class ItemFactura implements java.io.Serializable {

	
	
	@Column(name = "IdItemFactura", unique = true, nullable = false)
	private int idItemFactura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdFactura")
	private Factura factura;

	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name = "Cantidad", nullable = false)
	private int cantidad;

	@Column(name = "Valor", nullable = false, scale = 4)
	private float valor;

	public ItemFactura() {
	}


	public ItemFactura(String descripcion, int cantidad, float valor) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdItemFactura() {
		return this.idItemFactura;
	}

	public void setIdItemFactura(int idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}


	public DTO_ItemFactura toDTO() {
		DTO_ItemFactura item= new DTO_ItemFactura();
    	item.setCantidad(this.cantidad);
    	item.setDescripcion(this.descripcion);
    	item.setFactura(this.factura.getIdFactura());
    	item.setId(this.idItemFactura);
    	item.setValor(this.valor);
    	return item;
	}


}
