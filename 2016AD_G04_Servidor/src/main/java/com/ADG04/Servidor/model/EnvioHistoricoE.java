package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;


@Entity
@Table(name = "EnvioHistorico")
public class EnvioHistoricoE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdEnvioHistorico", unique = true, nullable = false)
	private int idEnvioHistorico;

	
	@Column(name = "Estado", nullable = false, length = 20)
	private String estado;
	
	@Column(name = "FechaActualizacion")
	private Date fechaActualizacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEnvio", nullable = false)
	private EnvioE envio;

	public EnvioHistoricoE() {
	}

	
	public EnvioHistoricoE(String estado,
			Date fechaActualizacion, EnvioE envio) {
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

	public EnvioE getEnvio() {
		return envio;
	}

	public void setEnvio(EnvioE envio) {
		this.envio = envio;
	}

	
	
	
}
