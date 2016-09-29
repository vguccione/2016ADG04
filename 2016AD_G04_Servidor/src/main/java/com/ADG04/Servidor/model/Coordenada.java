package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "coordenadas")
	private List<MapaDeRuta> rutas;

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

	public List<MapaDeRuta> getRutas() {
		return rutas;
	}

	public void setRutas(List<MapaDeRuta> rutas) {
		this.rutas = rutas;
	}


}
