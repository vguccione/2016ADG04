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

import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;


@Entity
@Table(name = "MapaDeRuta")
public class MapaDeRutaE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdMapaDeRuta", unique = true, nullable = false)
	private int idMapaDeRuta;

	@OneToMany(mappedBy="mapaDeRuta")
	private List<EnvioE> envios;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="MapaDeRutaCoordenada", joinColumns=@JoinColumn(name="IdMapaDeRuta"), 
	inverseJoinColumns=@JoinColumn(name="IdCoordenada"))
	private List<CoordenadaE> coordenadas;
	
	@Column(name="Duracion")
	private float duracion; //en horas
	
	@Column(name="CantKm")
	private float cantKm;
	
	@Column(name="costo")
	private float costo;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdSucursalDestino")
	private SucursalE sucursalDestino;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdSucursalOrigen")
	private SucursalE sucursalOrigen;

	public MapaDeRutaE() {
	}

	public MapaDeRutaE(float duracion, int cantKm) {
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

	public List<EnvioE> getEnvios() {
		return envios;
	}

	public void setEnvios(List<EnvioE> envios) {
		this.envios = envios;
	}

	public List<CoordenadaE> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<CoordenadaE> coordenadas) {
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

	public SucursalE getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(SucursalE sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public SucursalE getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(SucursalE sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public DTO_MapaDeRuta toDTO() {
		DTO_MapaDeRuta dto = new DTO_MapaDeRuta();
		dto.setCantKm(this.getCantKm());
		dto.setCosto(this.getCosto());
		dto.setDuracion(this.getDuracion());
		dto.setId(this.getIdMapaDeRuta());
		dto.setIdSucursalDestino(this.getSucursalDestino().getIdSucursal());
		dto.setIdSucursalOrigen(this.getSucursalOrigen().getIdSucursal());
		return dto;
	}
	
	

}
