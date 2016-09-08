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
@Table(name = "Envio")
public class Envio implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdEnvio", unique = true, nullable = false)
	private int idEnvio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProveedor")
	private Proveedor proveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdMapaDeRuta")
	private MapaDeRuta mapaDeRuta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCoordenadaActual", nullable = false)
	private Coordenada coordenada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private Sucursal sucursalByIdSucursalDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private Sucursal sucursalByIdSucursalOrigen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdVehiculo")
	private Vehiculo vehiculo;

	@Column(name = "Estado", nullable = false, length = 20)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaLlegadaEstimada", nullable = false, length = 10)
	private Date fechaLlegadaEstimada;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "HoraLlegadaEstimada", nullable = false, length = 16)
	private Date horaLlegadaEstimada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FechaSalida", nullable = false, length = 10)
	private Date fechaSalida;

	@Temporal(TemporalType.TIME)
	@Column(name = "HoraSalida", nullable = false, length = 16)
	private Date horaSalida;

	@Column(name = "Propio", nullable = false)
	private boolean propio;

	@Column(name = "NroTracking")
	private Integer nroTracking;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "envio")
	private List<Encomienda> encomiendas;

	public Envio() {
	}

	public Envio(Coordenada coordenada,
			Sucursal sucursalByIdSucursalDestino,
			Sucursal sucursalByIdSucursalOrigen, String estado,
			Date fechaLlegadaEstimada, Date horaLlegadaEstimada,
			Date fechaSalida, Date horaSalida, boolean propio) {
		this.coordenada = coordenada;
		this.sucursalByIdSucursalDestino = sucursalByIdSucursalDestino;
		this.sucursalByIdSucursalOrigen = sucursalByIdSucursalOrigen;
		this.estado = estado;
		this.fechaLlegadaEstimada = fechaLlegadaEstimada;
		this.horaLlegadaEstimada = horaLlegadaEstimada;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.propio = propio;
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

	public MapaDeRuta getMapaDeRuta() {
		return this.mapaDeRuta;
	}

	public void setMapaDeRuta(MapaDeRuta mapaDeRuta) {
		this.mapaDeRuta = mapaDeRuta;
	}


	public Coordenada getCoordenada() {
		return this.coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Sucursal getSucursalByIdSucursalDestino() {
		return this.sucursalByIdSucursalDestino;
	}

	public void setSucursalByIdSucursalDestino(
			Sucursal sucursalByIdSucursalDestino) {
		this.sucursalByIdSucursalDestino = sucursalByIdSucursalDestino;
	}

	public Sucursal getSucursalByIdSucursalOrigen() {
		return this.sucursalByIdSucursalOrigen;
	}

	public void setSucursalByIdSucursalOrigen(
			Sucursal sucursalByIdSucursalOrigen) {
		this.sucursalByIdSucursalOrigen = sucursalByIdSucursalOrigen;
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

	public Date getFechaLlegadaEstimada() {
		return this.fechaLlegadaEstimada;
	}

	public void setFechaLlegadaEstimada(Date fechaLlegadaEstimada) {
		this.fechaLlegadaEstimada = fechaLlegadaEstimada;
	}


	public Date getHoraLlegadaEstimada() {
		return this.horaLlegadaEstimada;
	}

	public void setHoraLlegadaEstimada(Date horaLlegadaEstimada) {
		this.horaLlegadaEstimada = horaLlegadaEstimada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
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
