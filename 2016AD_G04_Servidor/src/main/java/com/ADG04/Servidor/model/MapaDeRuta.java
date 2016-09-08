package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

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

@Entity
@Table(name = "MapaDeRuta")
public class MapaDeRuta implements java.io.Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "IdMapaDeRuta", unique = true, nullable = false)
	private int idMapaDeRuta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private Sucursal sucursalByIdSucursalDestino;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private Sucursal sucursalByIdSucursalOrigen;

	@Column(name = "DisanciaKm", nullable = false, precision = 53, scale = 0)
	private double disanciaKm;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mapaDeRuta")
	private List<Envio> envios;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mapaDeRuta")
	private List<MapaDeRutaCoordenada> mapaDeRutaCoordenadas;

	public MapaDeRuta() {
	}

	public MapaDeRuta(Sucursal sucursalByIdSucursalDestino,
			Sucursal sucursalByIdSucursalOrigen, double disanciaKm) {
		this.sucursalByIdSucursalDestino = sucursalByIdSucursalDestino;
		this.sucursalByIdSucursalOrigen = sucursalByIdSucursalOrigen;
		this.disanciaKm = disanciaKm;
	}

	public int getIdMapaDeRuta() {
		return this.idMapaDeRuta;
	}

	public void setIdMapaDeRuta(int idMapaDeRuta) {
		this.idMapaDeRuta = idMapaDeRuta;
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

	public double getDisanciaKm() {
		return this.disanciaKm;
	}

	public void setDisanciaKm(double disanciaKm) {
		this.disanciaKm = disanciaKm;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public List<MapaDeRutaCoordenada> getMapaDeRutaCoordenadas() {
		return mapaDeRutaCoordenadas;
	}

	public void setMapaDeRutaCoordenadas(
			List<MapaDeRutaCoordenada> mapaDeRutaCoordenadas) {
		this.mapaDeRutaCoordenadas = mapaDeRutaCoordenadas;
	}

}
