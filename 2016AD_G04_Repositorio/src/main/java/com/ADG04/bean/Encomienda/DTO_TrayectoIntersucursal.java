package com.ADG04.bean.Encomienda;

public class DTO_TrayectoIntersucursal extends DTO_Trayecto{
	private static final long serialVersionUID = 1L;
	private Integer idSucursalOrigen;
	private Integer idSucursalDestino;

	public DTO_TrayectoIntersucursal(){
		
	}

	public Integer getIdSucursalOrigen() {
		return idSucursalOrigen;
	}

	public void setIdSucursalOrigen(Integer idSucursalOrigen) {
		this.idSucursalOrigen = idSucursalOrigen;
	}

	public Integer getIdSucursalDestino() {
		return idSucursalDestino;
	}

	public void setIdSucursalDestino(Integer idSucursalDestino) {
		this.idSucursalDestino = idSucursalDestino;
	}


}
