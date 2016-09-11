package com.ADG94.bean.Cliente;

import java.io.Serializable;

public class DTO_DireccionEntrega implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private int posicion;
	private String direccion;
	private String codigoPostal;
	private String localidad;
	private String provincia;
	private String pais;
	private String horarioEntrega;
	private String diasEntrega;
	private Integer idCliente;
	
	public DTO_DireccionEntrega(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
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
	public String getHorarioEntrega() {
		return horarioEntrega;
	}
	public void setHorarioEntrega(String horarioEntrega) {
		this.horarioEntrega = horarioEntrega;
	}
	public String getDiasEntrega() {
		return diasEntrega;
	}
	public void setDiasEntrega(String diasEntrega) {
		this.diasEntrega = diasEntrega;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
}
