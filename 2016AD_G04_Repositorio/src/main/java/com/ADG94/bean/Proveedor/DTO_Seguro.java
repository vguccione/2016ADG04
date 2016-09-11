package com.ADG94.bean.Proveedor;

import java.io.Serializable;

public class DTO_Seguro implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipoSeguro;
	private String descripcion;
	private Integer idProveedor;
	private float tarifa;

	
	public DTO_Seguro(){
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipoSeguro() {
		return tipoSeguro;
	}


	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}


	public float getTarifa() {
		return tarifa;
	}


	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}


}
