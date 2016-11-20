package com.ADG04.web.servlets;

public class EncomiendaWeb {

	private Integer idEncomienda;
	private Integer idCliente;
	private Boolean envioAsignado;
	private String estado;
	private String tipo;	
	
	public EncomiendaWeb(Integer idEncomienda, Integer idCliente, String estado,
			Boolean envioAsignado) {
		super();
		this.idEncomienda = idEncomienda;
		this.idCliente = idCliente;
		this.estado = estado;
		this.envioAsignado = envioAsignado;
	}
	public EncomiendaWeb() {
		// TODO Auto-generated constructor stub
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
	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String toString() {
		
        String msg = "{\"idEncomienda\":\"" + idEncomienda.toString() 
        		+ "\", \"idCliente\":\"" + idCliente.toString() 
        		+ "\", \"estado\":\"" + this.getEstado()
        		+ "\", \"envioAsignado\":\"" + this.tieneEnvio();
        
        if(this.getTipo().equals("P"))
        	msg += "\", \"verEncomienda\":\"" + "<a href=ServletVerEncomiendasParticular?action=getEncomienda&idEncomienda="+idEncomienda.toString()+">Ver Encomienda</a>" + "\"}";
        if(this.getTipo().equals("E"))
        	msg += "\", \"verEncomienda\":\"" + "<a href=ServletVerEncomiendasParticular?action=getEncomiendaEmpresa&idEncomienda="+idEncomienda.toString()+">Ver Encomienda</a>" + "\"}";
        
        return msg;
    }
	
	private String tieneEnvio(){
		if(envioAsignado)
			return "Si";
		else
			return "No";
	}
}
