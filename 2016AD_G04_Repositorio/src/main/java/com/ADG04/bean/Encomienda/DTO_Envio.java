package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_Envio implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String estado;
	private DTO_Coordenada posicionActual;
	private List<DTO_EncomiendaParticular> encomiendas;
	
	
	public DTO_Envio(){
		encomiendas = new ArrayList<DTO_EncomiendaParticular>();
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


	public List<DTO_EncomiendaParticular> getEncomiendas() {
		return encomiendas;
	}


	public void setEncomiendas(List<DTO_EncomiendaParticular> encomiendas) {
		this.encomiendas = encomiendas;
	}

}
