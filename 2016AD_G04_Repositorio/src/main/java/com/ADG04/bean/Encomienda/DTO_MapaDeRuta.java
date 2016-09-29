package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.List;


public class DTO_MapaDeRuta implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idEnvio;
	private float duracion;
	private float cantKm;
	private Integer idSucursalOrigen;
	private Integer idSucursalDestino;
	private List<DTO_Coordenada> coordenadas;

	public DTO_MapaDeRuta(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
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

	public void setCantKm(float cantKm) {
		this.cantKm = cantKm;
	}

	public Integer getIdSucursalOrigen() {
		return idSucursalOrigen;
	}

	public void setIdSucursalOrigen(Integer idSucursalOrigen) {
		this.idSucursalOrigen = idSucursalOrigen;
	}

	public Integer getIdSucursalDestino() {
		return idSucursalDestino;
	}

	public void setIdSucursalDestino(Integer idSucursalDestino) {
		this.idSucursalDestino = idSucursalDestino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DTO_Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<DTO_Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	
}
