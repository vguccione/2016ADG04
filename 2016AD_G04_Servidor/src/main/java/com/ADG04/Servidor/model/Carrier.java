package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_Carrier;

@Entity
@Table(name="PrecioCarrier")
@PrimaryKeyJoinColumn(name="idProveedor") 
public class Carrier extends Proveedor {
	@OneToOne
	@JoinColumn(name="idDestino")
	private Direccion direccion;
	private String comentarios;
	private String prioridad;
	private float precioKMExtra;
	private float tarifa;

	public Carrier() {
		
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDestino(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public float getPrecioKMExtra() {
		return precioKMExtra;
	}

	public void setPrecioKMExtra(float precioKMExtra) {
		this.precioKMExtra = precioKMExtra;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}

	public DTO_Carrier toDTO() {
		DTO_Carrier pc = new DTO_Carrier();
		pc.setIdProveedor(this.getIdProveedor());
		pc.setIdDireccion(this.getDireccion().getIdDireccion());
		pc.setComentarios(this.getComentarios());
		pc.setPrioridad(this.getPrioridad());
		pc.setPrecioKMExtra(this.getPrecioKMExtra());
		pc.setTarifa(this.getTarifa());
		return pc;
	}

	
}