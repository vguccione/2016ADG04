package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DTO_EnvioHistorico implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String estado;
	private DTO_Envio envio;
	private Date fecha;
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
	public DTO_Envio getEnvio() {
		return envio;
	}
	public void setEnvio(DTO_Envio envio) {
		this.envio = envio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
