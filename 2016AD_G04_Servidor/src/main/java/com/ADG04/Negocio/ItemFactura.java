package com.ADG04.Negocio;

import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class ItemFactura{
	private int idItemFactura;
	private Factura factura;
	private String descripcion;
	private int cantidad;
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
