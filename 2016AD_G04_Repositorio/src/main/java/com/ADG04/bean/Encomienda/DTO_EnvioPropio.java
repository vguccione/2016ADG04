package com.ADG04.bean.Encomienda;

import java.util.Date;

public class DTO_EnvioPropio extends DTO_Envio{
	private static final long serialVersionUID = 1L;
	private Integer idVehiculo;
	private Integer idHojaDeRuta;
	private Date fechaSalida;
	private String horaSalida;
	private Date fechaLlegada;
	private String horaLlegada;
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

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

}
