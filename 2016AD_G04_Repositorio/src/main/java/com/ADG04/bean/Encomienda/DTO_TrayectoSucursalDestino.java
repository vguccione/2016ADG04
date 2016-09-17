package com.ADG04.bean.Encomienda;

public class DTO_TrayectoSucursalDestino extends DTO_Trayecto{
	private static final long serialVersionUID = 1L;
	private Integer idSucursalOrigen;
	private String direccionDestino;
	private String codigoPostalDestino;
	private String localidadDestino;
	private String provinciaDestino;


	public DTO_TrayectoSucursalDestino(){
		
	}

	public Integer getIdSucursalOrigen() {
		return idSucursalOrigen;
	}

	public void setIdSucursalOrigen(Integer idSucursalOrigen) {
		this.idSucursalOrigen = idSucursalOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public String getCodigoPostalDestino() {
		return codigoPostalDestino;
	}

	public void setCodigoPostalDestino(String codigoPostalDestino) {
		this.codigoPostalDestino = codigoPostalDestino;
	}

	public String getLocalidadDestino() {
		return localidadDestino;
	}

	public void setLocalidadDestino(String localidadDestino) {
		this.localidadDestino = localidadDestino;
	}

	public String getProvinciaDestino() {
		return provinciaDestino;
	}

	public void setProvinciaDestino(String provinciaDestino) {
		this.provinciaDestino = provinciaDestino;
	}

}
