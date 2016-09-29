package com.ADG04.bean.Encomienda;

import java.io.Serializable;

public class DTO_Coordenada implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private double longitud;
	private double latitud;
	public DTO_Coordenada(int id, double longitud, double latitud) {
		super();
		this.id = id;
		this.longitud = longitud;
		this.latitud = latitud;
	}
	public DTO_Coordenada() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	

}
