package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TareaMantenimientoRealizada")
public class TareaMantenimientoRealizada implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdTareaMantenimientoRealizada", unique = true, nullable = false)
	private int idTareaMantenimientoRealizada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTareaMantenimiento", nullable = false)
	private TareaMantenimiento tareaMantenimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProveedor", nullable = false)
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVehiculo", nullable = false)
	private Vehiculo vehiculo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FechaRealizada", nullable = false, length = 23)
	private Date fechaRealizada;

	@Column(name = "CantidadKilometros", nullable = true, precision = 53, scale = 0)
	private double cantidadKilometros;

	public TareaMantenimientoRealizada() {
	}

	public TareaMantenimientoRealizada(TareaMantenimiento tareaMantenimiento, Proveedor proveedor,
			Vehiculo vehiculo, Date fechaRealizada, double cantidadKilometros) {
		this.tareaMantenimiento = tareaMantenimiento;
		this.proveedor = proveedor;
		this.vehiculo = vehiculo;
		this.fechaRealizada = fechaRealizada;
		this.cantidadKilometros = cantidadKilometros;
	}
	
	public int getIdTareaMantenimientoRealizada() {
		return this.idTareaMantenimientoRealizada;
	}

	public void setIdTareaMantenimientoRealizada(
			int idTareaMantenimientoRealizada) {
		this.idTareaMantenimientoRealizada = idTareaMantenimientoRealizada;
	}


	public TareaMantenimiento getTareaMantenimiento() {
		return this.tareaMantenimiento;
	}

	public void setTareaMantenimiento(TareaMantenimiento tareaMantenimiento) {
		this.tareaMantenimiento = tareaMantenimiento;
	}


	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaRealizada() {
		return this.fechaRealizada;
	}

	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}
	public double getCantidadKilometros() {
		
		return this.cantidadKilometros;
	}

	public void setCantidadKilometros(double cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}

}
