package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Remito")
public class Remito implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "IdRemito", unique = true, nullable = false)
	private int idRemito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEncomienda", nullable = false)
	private Encomienda encomienda;

	@Column(name = "NombreReceptor", nullable = false, length = 100)
	private String nombreReceptor;

	@Column(name = "ApellidoReceptor", nullable = false, length = 100)
	private String apellidoReceptor;
	
	@Column(name = "DniReceptor", nullable = false, length = 8)
	private String dniReceptor;

	@Column(name = "Conformado", nullable = false)
	private boolean conformado;

	@Column(name = "FechaConformado", nullable = false)
	private boolean fechaConformado;

	public Remito() {
	}

	public Remito(Encomienda encomienda, String nombreReceptor,
			String apellidoReceptor, String dniReceptor, boolean conformado,
			boolean fechaConformado) {
		this.encomienda = encomienda;
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.conformado = conformado;
		this.fechaConformado = fechaConformado;
	}

	
	public int getIdRemito() {
		return this.idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}


	public Encomienda getEncomienda() {
		return this.encomienda;
	}

	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public boolean isConformado() {
		return this.conformado;
	}

	public void setConformado(boolean conformado) {
		this.conformado = conformado;
	}


	public boolean isFechaConformado() {
		return this.fechaConformado;
	}

	public void setFechaConformado(boolean fechaConformado) {
		this.fechaConformado = fechaConformado;
	}

}
