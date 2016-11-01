package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;

public class MapaDeRuta implements java.io.Serializable {

	private int idMapaDeRuta;
	private List<Envio> envios;
	private List<Coordenada> coordenadas;
	private float duracion; //en horas
	private float cantKm;
	private float costo;
	private Sucursal sucursalDestino;
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
