package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MapaDeRuta")
public class MapaDeRuta implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdMapaDeRuta", unique = true, nullable = false)
	private int idMapaDeRuta;

	@OneToMany(mappedBy="mapaDeRuta")
	private List<Envio> envios;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MapaDeRutaCoordenada", joinColumns=@JoinColumn(name="IdMapaDeRuta"), 
	inverseJoinColumns=@JoinColumn(name="IdCoordenada"))
	private List<Coordenada> coordenadas;
	
	@Column(name="Duracion")
	private float duracion;
	
	@Column(name="CantKm")
	private float cantKm;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdSucursalDestino")
	private Sucursal sucursalDestino;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdSucursalOrigen")
	private Sucursal sucursalOrigen;

	public MapaDeRuta() {
	}

	public MapaDeRuta(float duracion, int cantKm) {
		super();
		this.duracion = duracion;
		this.cantKm = cantKm;
	}

	public int getIdMapaDeRuta() {
		return idMapaDeRuta;
	}

	public void setIdMapaDeRuta(int idMapaDeRuta) {
		this.idMapaDeRuta = idMapaDeRuta;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public float getCantKm() {
		return cantKm;
	}

	public void setCantKm(float cant) {
		this.cantKm = cant;
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

}
