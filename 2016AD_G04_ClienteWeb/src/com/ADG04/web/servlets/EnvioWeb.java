package com.ADG04.web.servlets;

public class EnvioWeb {

	private Integer idEnvio;
	private Integer idSucursalDestino;
	private Integer idSucursalOrigen;
	private String estado;
		
	public EnvioWeb(Integer idEnvio, String estado,	Integer idSucursalOrigen, Integer idSucursalDestino) {
		super();
		this.idEnvio = idEnvio;
		this.estado = estado;
		this.idSucursalOrigen = idSucursalOrigen;
		this.idSucursalDestino = idSucursalDestino;
	}
	
	public Integer getIdEnvio() {
		return idEnvio;
	}
		
	public Integer getIdSucursalDestino() {
		return idSucursalDestino;
	}
	
	public Integer getIdSucursalOrigen() {
		return idSucursalOrigen;
	}	
	
	public String getEstado() {
		return estado;
	}	
	
	public String toString() {
        return "{\"idEnvio\":\"" + idEnvio.toString() 
        		+ "\", \"idSucursalOrigen\":\"" + idSucursalOrigen.toString() 
        		+ "\", \"idSucursalDestino\":\"" + idSucursalDestino.toString() 
				+ "\", \"estado\":\"" + estado
        		+ "\", \"verEnvio\":\"" + "<a href=ServletVerEnvio?idEnvio="+idEnvio.toString()+">Ver Envio</a>" + "\"}";
    }
	
}
