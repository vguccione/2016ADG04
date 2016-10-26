package com.ADG04.bean.Proveedor;

import java.io.Serializable;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;

public class DTO_Proveedor implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String activo;
	private String razonSocial;
	private String cuit;
	private DTO_Direccion direccion;
	private String email;
	private String telefono;
	private char tipo;
	private boolean TallerOficial;
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


	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public List<DTO_FacturaProveedor> getFacturas() {
		return facturas;
	}


	public boolean isTallerOficial() {
		return TallerOficial;
	}

	public void setTallerOficial(boolean tallerOficial) {
		TallerOficial = tallerOficial;
	}

	public void setFacturas(List<DTO_FacturaProveedor> facturas) {
		this.facturas = facturas;
	}
}
