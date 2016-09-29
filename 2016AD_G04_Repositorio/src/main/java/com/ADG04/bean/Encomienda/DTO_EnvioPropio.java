package com.ADG04.bean.Encomienda;

import java.util.Date;

public class DTO_EnvioPropio extends DTO_Envio{
	private static final long serialVersionUID = 1L;
	private Integer idVehiculo;
	private Integer idHojaDeRuta;
	private Date fechaYHoraSalida;
	private Date fechaYHoraLlegada;
	private Integer idDestino;
	
	public DTO_EnvioPropio(){
		super();
	}



	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
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

}
