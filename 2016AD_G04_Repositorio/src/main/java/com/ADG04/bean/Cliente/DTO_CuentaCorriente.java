package com.ADG04.bean.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_CuentaCorriente implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private float credito;
	private float limiteCredito;
	private String formaPago;
	private List<DTO_Factura> facturas;
	
	/*ToDo: no tenemos recibos en nuestro modelo!!!*/
	//private List<DTO_ReciboPago> recibos;

	
	public DTO_CuentaCorriente(){
		facturas = new ArrayList<DTO_Factura>();
		///recibos = new ArrayList<DTO_ReciboPago>();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public List<DTO_Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<DTO_Factura> facturas) {
		this.facturas = facturas;
	}

	public void addFactura(DTO_Factura factura){
		this.facturas.add(factura);
	}
	
	/*
	public List<DTO_ReciboPago> getRecibos() {
		return recibos;
	}

	public void setRecibos(List<DTO_ReciboPago> recibos) {
		this.recibos = recibos;
	}*/
}
