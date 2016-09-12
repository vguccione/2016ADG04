package com.ADG94.bean.Cliente;

import java.io.Serializable;

public class DTO_ItemFactura implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int idFactura;
	private int cantidad;
	private float valor;
	private String descripcion;
	
	public DTO_ItemFactura(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getFactura() {
		return idFactura;
	}
	
	public void setFactura(int factura) {
		this.idFactura = factura;
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
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}

}
