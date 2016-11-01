package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;



















import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
  
public class ClienteParticular extends Cliente{

	private String nombre;
	private String apellido;
	private String dni;

	public ClienteParticular() {
	}

	

	public ClienteParticular(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public DTO_ClienteParticular toDTO(){

		DTO_ClienteParticular cli = new DTO_ClienteParticular();
		cli.setId(this.getIdCliente());
		cli.setDni(this.getDni());
		cli.setNombre(this.getNombre());
		cli.setApellido(this.getApellido());
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());
		
		cli.setDireccion(this.getDireccion().toDTO());
		
		return cli;
	}
}
