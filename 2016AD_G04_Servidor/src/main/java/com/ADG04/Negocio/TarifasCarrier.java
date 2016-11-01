package com.ADG04.Negocio;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;


@Table(name="TarifasCarrier")
public class TarifasCarrier implements java.io.Serializable{	
	
	
	
	@Column(name="IdTarifasCarrier")
	private int idTarifasCarrier;
	
	@Column(name="Comentarios")
	private String comentarios;
	
	@Column(name="Prioridad")
	private String prioridad;
	
	@Column(name="PrecioKMExtra")
	private float precioKMExtra;
	
	@Column(name="Tarifa")
	private float tarifa;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private Proveedor proveedor;

	public TarifasCarrier() {
		
	}
	
	public TarifasCarrier(String comentarios, String prioridad,
			float precioKMExtra, float tarifa, Proveedor proveedor) {
		super();
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
	}

	public TarifasCarrier(int idTarifasCarrier, String comentarios,
			String prioridad, float precioKMExtra, float tarifa,
			Proveedor proveedor) {
		super();
		this.idTarifasCarrier = idTarifasCarrier;
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
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
	
	

	public int getIdTarifasCarrier() {
		return idTarifasCarrier;
	}

	public void setIdTarifasCarrier(int idTarifasCarrier) {
		this.idTarifasCarrier = idTarifasCarrier;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public DTO_TarifasCarrier toDTO() {
		DTO_TarifasCarrier pc = new DTO_TarifasCarrier();
		pc.setIdProveedor(this.getProveedor().getIdProveedor());
		pc.setId(this.getIdTarifasCarrier());
		
		pc.setComentarios(this.getComentarios());
		pc.setPrioridad(this.getPrioridad());
		pc.setPrecioKMExtra(this.getPrecioKMExtra());
		pc.setTarifa(this.getTarifa());
		return pc;
	}

	
}