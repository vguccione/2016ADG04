package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTO_Envio implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String estado;
	private DTO_Coordenada posicionActual;
	private List<DTO_Encomienda> encomiendas;
	private Date fechaActualizacion;
	
	
	public DTO_Envio(){
		encomiendas = new ArrayList<DTO_Encomienda>();
	}


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}



	public DTO_Coordenada getPosicionActual() {
		return posicionActual;
	}


	public void setPosicionActual(DTO_Coordenada posicionActual) {
		this.posicionActual = posicionActual;
	}


	public List<DTO_Encomienda> getEncomiendas() {
		return encomiendas;
	}


	public void setEncomiendas(List<DTO_Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}


	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}
