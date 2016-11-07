package com.ADG04.bean.Cliente;

import java.io.Serializable;

import com.ADG04.bean.Administracion.DTO_Direccion;

public class DTO_Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private DTO_Direccion direccion;
	private String email;
	private String telefono;
	private boolean estado;
	private char tipo;
	
	public DTO_Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO_Cliente(Integer id, DTO_Direccion direccion, String email,
			String telefono, boolean estado) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
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
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
