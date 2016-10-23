package com.ADG04.bean.Cliente;

import java.io.Serializable;

import com.ADG04.bean.Administracion.DTO_Direccion;

public class DTO_ClienteParticular extends DTO_Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private String dni;
	public DTO_ClienteParticular(){
		
	}

	
	public String getDni(){
		return this.dni;
	}
	
	public void setDni(String dni){
		this.dni = dni;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getApellido(){
		return this.apellido;
	}
	
	public void setApellido(String apellido){
		this.apellido = apellido;
	}	
	
}
