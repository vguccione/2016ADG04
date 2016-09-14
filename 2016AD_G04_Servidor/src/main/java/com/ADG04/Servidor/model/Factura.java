package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Factura")
public class Factura implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "IdFactura", unique = true, nullable = false)
	private int idFactura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCtaCte")
	private CuentaCorriente cuentaCorriente;
	
	@Column(name = "TipoFactura", nullable = false, length = 1)
	private char tipoFactura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fecha", nullable = false, length = 23)
	private Date fecha;
	
	@Column(name = "Pagada", nullable = false)
	private boolean pagada;
	
	@Column(name="FechaVencimiento")
	private Date fechaVencimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Vencimiento", nullable = false, length = 23)
	private Date vencimiento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura")
	private List<ItemFactura> itemFacturas;

	public Factura() {
	}

	public Factura(int idFactura, char tipoFactura, Date fecha, boolean pagada,
			Date vencimiento) {
		this.idFactura = idFactura;
		this.tipoFactura = tipoFactura;
		this.fecha = fecha;
		this.pagada = pagada;
		this.vencimiento = vencimiento;
	}

	public Factura(CuentaCorriente cuentaCorriente,
			char tipoFactura, Date fecha, boolean pagada, Date vencimiento) {
		this.cuentaCorriente = cuentaCorriente;
		this.tipoFactura = tipoFactura;
		this.fecha = fecha;
		this.pagada = pagada;
		this.vencimiento = vencimiento;
	}

	
	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	
	public CuentaCorriente getCuentaCorriente() {
		return this.cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public char getTipoFactura() {
		return this.tipoFactura;
	}

	public void setTipoFactura(char tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean isPagada() {
		return this.pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public Date getVencimiento() {
		return this.vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public List<ItemFactura> getItemFacturas() {
		return itemFacturas;
	}

	public void setItemFacturas(List<ItemFactura> itemFacturas) {
		this.itemFacturas = itemFacturas;
	}

}
