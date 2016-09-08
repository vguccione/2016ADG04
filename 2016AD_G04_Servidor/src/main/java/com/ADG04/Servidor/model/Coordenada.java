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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Coordenada")
public class Coordenada implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdCoordenada", unique = true, nullable = false)
	private int idCoordenada;
	
	@Column(name = "Latitud", nullable = false, precision = 53, scale = 0)
	private double latitud;
	
	@Column(name = "Longitud", nullable = false, precision = 53, scale = 0)
	private double longitud;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coordenada")
	private List<Envio> envios;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coordenada")
	private List<MapaDeRutaCoordenada> mapaDeRutaCoordenadas;

	public Coordenada() {
	}

	public Coordenada(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	
	public int getIdCoordenada() {
		return this.idCoordenada;
	}

	public void setIdCoordenada(int idCoordenada) {
		this.idCoordenada = idCoordenada;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	
	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
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
