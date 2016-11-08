package com.ADG04.bean.Proveedor;

import java.io.Serializable;

import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Sucursal;


public class DTO_TarifasCarrier implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idProveedor;
	private Integer idDireccion;
	private String comentarios;
	private String prioridad;
	private float precioKMExtra;
	private float tarifa;
	private String ciudad;
	private DTO_Pais pais;
	private DTO_Sucursal origen;
	

	public DTO_TarifasCarrier() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public float getPrecioKMExtra() {
		return precioKMExtra;
	}

	public void setPrecioKMExtra(float precioKMExtra) {
		this.precioKMExtra = precioKMExtra;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public DTO_Pais getPais() {
		return pais;
	}

	public void setPais(DTO_Pais pais) {
		this.pais = pais;
	}

	public DTO_Sucursal getOrigen() {
		return origen;
	}

	public void setOrigen(DTO_Sucursal origen) {
		this.origen = origen;
	}


		
}
