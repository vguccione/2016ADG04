package com.ADG04.bean.Encomienda;

import java.io.Serializable;


public class DTO_Trayecto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idHojaRuta;
	private float distanciaKM;
	private float tiempoDias;
	private String descripcion;

	public DTO_Trayecto(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdHojaRuta() {
		return idHojaRuta;
	}

	public void setIdHojaRuta(Integer idHojaRuta) {
		this.idHojaRuta = idHojaRuta;
	}

	public float getDistanciaKM() {
		return distanciaKM;
	}

	public void setDistanciaKM(float distanciaKM) {
		this.distanciaKM = distanciaKM;
	}

	public float getTiempoDias() {
		return tiempoDias;
	}

	public void setTiempoDias(float tiempoDias) {
		this.tiempoDias = tiempoDias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
