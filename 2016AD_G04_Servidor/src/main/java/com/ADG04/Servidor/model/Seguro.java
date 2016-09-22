package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_Seguro;


@Entity
@Table(name="Seguro")
@PrimaryKeyJoinColumn(name="idProveedor") 
public class Seguro extends Proveedor {

	@Column(name="TipoSeguro")
	private String tipoSeguro;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Tarifa")
	private float tarifa;

	@Column(name="TarifaPorKm")
	private float tarifaPorKm;

	public Seguro() {
		
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	

	public float getTarifaPorKm() {
		return tarifaPorKm;
	}

	public void setTarifaPorKm(float tarifaPorKm) {
		this.tarifaPorKm = tarifaPorKm;
	}

	public DTO_Seguro toDTO() {
		DTO_Seguro s = new DTO_Seguro();
		s.setIdProveedor(this.getIdProveedor());
		s.setTipoSeguro(this.getTipoSeguro());
		s.setDescripcion(this.descripcion);
		s.setTarifa(this.getTarifa());
		s.setTarifaPorKm(this.tarifaPorKm);
		return s;
	}
}