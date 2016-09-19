package com.ADG04.bean.Cliente;

import java.io.Serializable;

import com.ADG04.bean.Administracion.DTO_Direccion;

public class DTO_ClienteParticular implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String dni;
	private boolean estado;
	private DTO_Direccion direccion;
	private String email;
	private String telefono;
	
	public DTO_ClienteParticular(){
		
	}

	public void setId(int id){
		this.id = id;
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
	
	public Integer getId() {
		return id;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public DTO_Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(DTO_Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
