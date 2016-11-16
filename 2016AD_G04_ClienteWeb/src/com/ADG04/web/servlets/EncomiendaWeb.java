package com.ADG04.web.servlets;

public class EncomiendaWeb {

	private Integer idEncomienda;
	private Integer idCliente;
	private Boolean envioAsignado;
		
	public EncomiendaWeb(Integer idEncomienda, Integer idCliente,
			Boolean envioAsignado) {
		super();
		this.idEncomienda = idEncomienda;
		this.idCliente = idCliente;
		this.envioAsignado = envioAsignado;
	}
	public Integer getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Boolean getEnvioAsignado() {
		return envioAsignado;
	}
	public void setEnvioAsignado(Boolean envioAsignado) {
		this.envioAsignado = envioAsignado;
	}
	
	public String toString() {
        return "{\"idEncomienda\":\"" + idEncomienda.toString() 
        		+ "\", \"idCliente\":\"" + idCliente.toString() 
        		+ "\", \"envioAsignado\":\"" + this.tieneEnvio() 
        		+ "\", \"verEncomienda\":\"" + "<a href=ServletVerEncomiendasParticular?idEncomienda="+idEncomienda.toString()+">Ver Encomienda</a>" + "\"}";
    }
	
	private String tieneEnvio(){
		if(envioAsignado)
			return "Si";
		else
			return "No";
	}
}
