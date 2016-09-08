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
@Table(name = "MapaDeRutaCoordenada")
public class MapaDeRutaCoordenada implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdMapaDeRutaCoordenada", unique = true, nullable = false)
	private int idMapaDeRutaCoordenada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdMapaDeRuta", nullable = false)
	private MapaDeRuta mapaDeRuta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCoordenada", nullable = false)
	private Coordenada coordenada;

	public MapaDeRutaCoordenada() {
	}

	public MapaDeRutaCoordenada(MapaDeRuta mapaDeRuta, Coordenada coordenada) {
		this.mapaDeRuta = mapaDeRuta;
		this.coordenada = coordenada;
	}

	public int getIdMapaDeRutaCoordenada() {
		return this.idMapaDeRutaCoordenada;
	}

	public void setIdMapaDeRutaCoordenada(int idMapaDeRutaCoordenada) {
		this.idMapaDeRutaCoordenada = idMapaDeRutaCoordenada;
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

}
