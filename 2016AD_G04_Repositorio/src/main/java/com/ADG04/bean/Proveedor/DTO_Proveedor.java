package com.ADG04.bean.Proveedor;

import java.io.Serializable;
import java.util.List;

public class DTO_Proveedor implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String activo;
	private String razonSocial;
	private String cuit;
	private String categoria;
	private String direccion;
	private String codigoPostal;
	private String localidad;
	private String provincia;
	private String pais;
	private String email;
	private String telefono;
	private String metodoPago;
	private String tipo;
	private String especialidad;
	private String tallerOficial;
	private List<DTO_FacturaProveedor> facturas;

	public DTO_Proveedor() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}

	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	
	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
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



	public String getMetodoPago() {
		return metodoPago;
	}



	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTallerOficial() {
		return tallerOficial;
	}

	public void setTallerOficial(String tallerOficial) {
		this.tallerOficial = tallerOficial;
	}


	public List<DTO_FacturaProveedor> getFacturas() {
		return facturas;
	}



	public void setFacturas(List<DTO_FacturaProveedor> facturas) {
		this.facturas = facturas;
	}
}
