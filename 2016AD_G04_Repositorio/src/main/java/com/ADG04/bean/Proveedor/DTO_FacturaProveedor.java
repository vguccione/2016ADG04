package com.ADG04.bean.Proveedor;

import java.io.Serializable;
import java.util.Date;

public class DTO_FacturaProveedor implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String numero;
	private Date fecha;
	private Date vencimiento;
	private float montoTotal;
	private float montoPendiente;
	private Integer idProveedor;
	
	public DTO_FacturaProveedor(){

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getMontoPendiente() {
		return montoPendiente;
	}

	public void setMontoPendiente(float montoPendiente) {
		this.montoPendiente = montoPendiente;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

}
