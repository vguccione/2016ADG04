package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_Carrier;

@Entity
@Table(name="Carrier")
@PrimaryKeyJoinColumn(name="idProveedor") 
public class Carrier extends Proveedor implements java.io.Serializable{	
	@Column(name="Comentarios")
	private String comentarios;
	
	@Column(name="Prioridad")
	private String prioridad;
	
	@Column(name="PrecioKMExtra")
	private float precioKMExtra;
	
	@Column(name="Tarifa")
	private float tarifa;

	public Carrier() {
		
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