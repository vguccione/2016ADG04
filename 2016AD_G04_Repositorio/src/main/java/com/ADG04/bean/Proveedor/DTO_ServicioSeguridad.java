package com.ADG04.bean.Proveedor;

import java.io.Serializable;

public class DTO_ServicioSeguridad implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descripcion;
	private float tarifa;
	private Integer idProveedor;
	
	public DTO_ServicioSeguridad(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
}
