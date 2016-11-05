package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import com.ADG04.Servidor.model.CuentaCorrienteE;











public class CuentaCorriente{
	private int idCtaCte;
	private Cliente cliente;
	private double credito;
	private double limiteCredito;
	private List<Factura> facturas;
	private String formaPago;

	public CuentaCorriente() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CuentaCorriente(double credito, double limiteCredito,
			String formaPago) {
		super();
		this.credito = credito;
		this.limiteCredito = limiteCredito;
		this.formaPago = formaPago;
	}



	public int getIdCtaCte() {
		return idCtaCte;
	}

	public void setIdCtaCte(int idCtaCte) {
		this.idCtaCte = idCtaCte;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}



	public CuentaCorriente fromEntity(CuentaCorrienteE ctc) {
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.setCredito(ctc.getCredito());
		cuenta.setFormaPago(ctc.getFormaPago());
		cuenta.setIdCtaCte(ctc.getIdCtaCte());
		cuenta.setLimiteCredito(ctc.getLimiteCredito());
		return cuenta;
	}

}