package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Envio")
public class Envio implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdEnvio", unique = true, nullable = false)
	private int idEnvio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="IdMapaDeRuta")
	private MapaDeRuta mapaDeRuta;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "IdCoordenadaActual", nullable = false)
	private Coordenada posicionActual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private Sucursal sucursalDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private Sucursal sucursalOrigen;

	@OneToOne(fetch = FetchType.LAZY)
	private Vehiculo vehiculo;

	@Column(name = "Estado", nullable = false, length = 20)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaLlegadaEstimada", nullable = false, length = 10)
	private Date fechaYHoraLlegadaEstimada;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FechaSalida", nullable = false, length = 10)
	private Date fechaYHoraSalida;

	@Column(name = "Propio", nullable = false)
	private boolean propio;

	@Column(name = "NroTracking")
	private Integer nroTracking;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "envio")
	private List<Encomienda> encomiendas;

	public Envio() {
	}

	


	public Envio(Vehiculo vehiculo, String estado,
			Date fechaYHoraLlegadaEstimada, Date fechaYHoraSalida,
			boolean propio, Integer nroTracking) {
		super();
		this.vehiculo = vehiculo;
		this.estado = estado;
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.propio = propio;
		this.nroTracking = nroTracking;
	}




	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Coordenada getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(Coordenada posicionActual) {
		this.posicionActual = posicionActual;
	}

	public MapaDeRuta getMapaDeRuta() {
		return mapaDeRuta;
	}

	public void setMapaDeRuta(MapaDeRuta mapaDeRuta) {
		this.mapaDeRuta = mapaDeRuta;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaYHoraLlegadaEstimada() {
		return fechaYHoraLlegadaEstimada;
	}


	public void setFechaYHoraLlegadaEstimada(Date fechaYHoraLlegadaEstimada) {
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
	}


	public Date getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(Date fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}


	public boolean isPropio() {
		return this.propio;
	}

	public void setPropio(boolean propio) {
		this.propio = propio;
	}

	public Integer getNroTracking() {
		return this.nroTracking;
	}

	public void setNroTracking(Integer nroTracking) {
		this.nroTracking = nroTracking;
	}

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}
}
