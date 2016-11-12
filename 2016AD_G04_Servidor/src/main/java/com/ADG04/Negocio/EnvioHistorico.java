package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.Servidor.model.EnvioHistoricoE;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioHistorico;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;

public class EnvioHistorico implements java.io.Serializable {

	private int idEnvioHistorico;
	private String estado;
	private Date fechaActualizacion;
	private Envio envio;

	public EnvioHistorico() {
	}

	
	public EnvioHistorico(String estado,
			Date fechaActualizacion, Envio envio) {
		super();
		this.estado = estado;
		this.fechaActualizacion = fechaActualizacion;
		this.envio = envio;
	}


	public int getIdEnvioHistorico() {
		return idEnvioHistorico;
	}

	public void setIdEnvioHistorico(int idEnvioHistorico) {
		this.idEnvioHistorico = idEnvioHistorico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}


	public EnvioHistorico fromEntity(EnvioHistoricoE hist) {
		EnvioHistorico eh = new EnvioHistorico();
		eh.setEnvio(new Envio().fromEntity(hist.getEnvio()));
		eh.setEstado(hist.getEstado());
		eh.setFechaActualizacion(hist.getFechaActualizacion());
		eh.setIdEnvioHistorico(hist.getIdEnvioHistorico());
		return eh;
	}


	public DTO_EnvioHistorico toDTO() {
		DTO_EnvioHistorico dto = new DTO_EnvioHistorico();
		dto.setEnvio(this.envio.toDTO());
		dto.setEstado(this.estado);
		dto.setFecha(this.fechaActualizacion);
		dto.setId(this.idEnvioHistorico);
		return dto;
	}

	
	
	
}
