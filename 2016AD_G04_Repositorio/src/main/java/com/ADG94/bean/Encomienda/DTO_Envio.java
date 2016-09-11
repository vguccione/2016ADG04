package com.ADG94.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_Envio implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String estado;
	private String posicionActual;
	private List<DTO_Encomienda> encomiendas;
	
	
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


	public String getPosicionActual() {
		return posicionActual;
	}


	public void setPosicionActual(String posicionActual) {
		this.posicionActual = posicionActual;
	}


	public List<DTO_Encomienda> getEncomiendas() {
		return encomiendas;
	}


	public void setEncomiendas(List<DTO_Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}

}
