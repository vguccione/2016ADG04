package com.ADG04.bean.Encomienda;

import java.io.Serializable;

public class DTO_Coordenada implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String longitud;
	private String latitud;
	public DTO_Coordenada(int id, String longitud, String latitud) {
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
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	

}
