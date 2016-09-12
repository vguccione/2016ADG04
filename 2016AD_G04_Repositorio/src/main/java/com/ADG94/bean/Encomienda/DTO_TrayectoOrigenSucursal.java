package com.ADG94.bean.Encomienda;

public class DTO_TrayectoOrigenSucursal extends DTO_Trayecto{
	private static final long serialVersionUID = 1L;
	private String direccionOrigen;
	private String codigoPostalOrigen;
	private String localidadOrigen;
	private String provinciaOrigen;
	private Integer idSucursalDestino;

	public DTO_TrayectoOrigenSucursal(){
	
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}

	public String getCodigoPostalOrigen() {
		return codigoPostalOrigen;
	}

	public void setCodigoPostalOrigen(String codigoPostalOrigen) {
		this.codigoPostalOrigen = codigoPostalOrigen;
	}

	public String getLocalidadOrigen() {
		return localidadOrigen;
	}

	public void setLocalidadOrigen(String localidadOrigen) {
		this.localidadOrigen = localidadOrigen;
	}

	public String getProvinciaOrigen() {
		return provinciaOrigen;
	}

	public void setProvinciaOrigen(String provinciaOrigen) {
		this.provinciaOrigen = provinciaOrigen;
	}

	public Integer getIdSucursalDestino() {
		return idSucursalDestino;
	}

	public void setIdSucursalDestino(Integer idSucursalDestino) {
		this.idSucursalDestino = idSucursalDestino;
	}



}
