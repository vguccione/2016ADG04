package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;

import com.ADG04.bean.Administracion.DTO_Sucursal;

public class DTO_EnvioPropio extends DTO_Envio implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idVehiculo;
	private Integer idHojaDeRuta;
	private Date fechaYHoraSalida;
	private Date fechaYHoraLlegada;
	private Integer idDestino;
	private DTO_Sucursal sucursalOrigen;
	private DTO_Sucursal sucursalDestino;
	
	public DTO_EnvioPropio(){
		super();
	}

	
	public int getIdVehiculo() {
		return idVehiculo;
	}


	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}


	public Integer getIdHojaDeRuta() {
		return idHojaDeRuta;
	}

	public void setIdHojaDeRuta(Integer idHojaDeRuta) {
		this.idHojaDeRuta = idHojaDeRuta;
	}

	public Date getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(Date fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}

	public Date getFechaYHoraLlegada() {
		return fechaYHoraLlegada;
	}



	public void setFechaYHoraLlegada(Date fechaYHoraLlegada) {
		this.fechaYHoraLlegada = fechaYHoraLlegada;
	}



	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public DTO_Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(DTO_Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public DTO_Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(DTO_Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	
	

}
