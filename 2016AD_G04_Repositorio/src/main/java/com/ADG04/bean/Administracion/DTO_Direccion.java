package com.ADG04.bean.Administracion;

public class DTO_Direccion {
	
	private static final long serialVersionUID = 1L;
	
	private int idDireccion;
	
	private DTO_Pais pais;
	private DTO_Provincia provincia;
	private String calle;
	private int nro;
	private String localidad;

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	private int codigoPostal;
	
	public DTO_Direccion(){
		
	}
	
	public DTO_Pais getPais() {
		return this.pais;
	}
	
	public void setPais(DTO_Pais pais) {
		this.pais = pais;
	}	
	
	public DTO_Provincia getProvincia(){
		return this.provincia;
	}
	
	public void setProvincia(DTO_Provincia  provincia){
		this.provincia = provincia;
	}
		
	public String getCalle() {
		return this.calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNro() {
		return this.nro;
	}
	
	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public String getLocalidad() {
		return this.localidad;
	}
	
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public int getCodigoPostal() {
		return this.codigoPostal;
	}	
	
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}	
		
}
