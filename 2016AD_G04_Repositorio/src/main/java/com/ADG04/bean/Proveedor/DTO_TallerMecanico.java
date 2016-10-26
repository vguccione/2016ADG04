package com.ADG04.bean.Proveedor;

import java.io.Serializable;


public class DTO_TallerMecanico extends DTO_Proveedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer idProveedor;
	private float tarifa;
	private String tipoTaller;

	public DTO_TallerMecanico() {
		
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

	public String getTipoTaller() {
		return tipoTaller;
	}

	public void setTipoTaller(String tipoTaller) {
		this.tipoTaller = tipoTaller;
	}
	
	
}
