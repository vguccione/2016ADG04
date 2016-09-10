package com.ADG94.bean;

import java.io.Serializable;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cuit;
	private String razonSocial;
	
	public ClienteDTO(){ }
	
	public String getCuit(){
		return cuit;
	}
	
	public String getRazonSocial(){
		return razonSocial;
	}
	
	public void setCuit(String cuit){
		this.cuit = cuit;
	}
	
	public void setRazonSocial(String razonSocial){
		this.razonSocial = razonSocial;
	}
}
