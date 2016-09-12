package com.ADG94.bean.Encomienda;

import java.io.Serializable;

public class DTO_Destinatario  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dni;
	private String nombre;
	private String apellido;
	private Integer idEncomienda;
	public DTO_Destinatario(){
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

}
