package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CuentaCorriente")
public class CuentaCorriente implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdCtaCte", unique = true, nullable = false)
	private int idCtaCte;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCliente")
	private Cliente cliente;
	
	@Column(name = "Credito", nullable = false, precision = 53, scale = 0)	
	private double credito;
	
	@Column(name = "LimiteCredito", nullable = false, precision = 53, scale = 0)	
	private double limiteCredito;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuentaCorriente")
	private List<Factura> facturas;
	
	@Column(name="FormaPago")
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

}