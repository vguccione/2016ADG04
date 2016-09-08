package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CondicionesEspecialesVehiculo")
public class CondicionesEspecialesVehiculo implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdCondicionesEspecialesVehiculo", unique = true, nullable = false)
	private int idCondicionesEspecialesVehiculo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVehiculo", nullable = false)
	private Vehiculo vehiculo;

	@Column(name = "Descripcion", nullable = false, length = 200)
	private String descripcion;

	public CondicionesEspecialesVehiculo() {
	}

	public CondicionesEspecialesVehiculo(Vehiculo vehiculo, String descripcion) {
		this.vehiculo = vehiculo;
		this.descripcion = descripcion;
	}

	public int getIdCondicionesEspecialesVehiculo() {
		return this.idCondicionesEspecialesVehiculo;
	}

	public void setIdCondicionesEspecialesVehiculo(
			int idCondicionesEspecialesVehiculo) {
		this.idCondicionesEspecialesVehiculo = idCondicionesEspecialesVehiculo;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
