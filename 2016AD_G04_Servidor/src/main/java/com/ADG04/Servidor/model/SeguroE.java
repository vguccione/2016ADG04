package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_Seguro;


@Entity
@Table(name="Seguro")
public class SeguroE implements java.io.Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="IdSeguro")
	private int idSeguro;

	@Column(name="TipoSeguro")
	private String tipoSeguro;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Tarifa")
	private float tarifa;

	@Column(name="TarifaPorKm")
	private float tarifaPorKm;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorE proveedor;

	public SeguroE() {
		
	}
	
	public SeguroE(int idSeguro, String tipoSeguro, String descripcion,
			float tarifa, float tarifaPorKm, ProveedorE proveedor) {
		super();
		this.idSeguro = idSeguro;
		this.tipoSeguro = tipoSeguro;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.tarifaPorKm = tarifaPorKm;
		this.proveedor = proveedor;
	}



	public SeguroE(String tipoSeguro, String descripcion, float tarifa,
			float tarifaPorKm, ProveedorE proveedor) {
		super();
		this.tipoSeguro = tipoSeguro;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.tarifaPorKm = tarifaPorKm;
		this.proveedor = proveedor;
	}



	public int getIdSeguro() {
		return idSeguro;
	}



	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
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
	
	

	public ProveedorE getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorE proveedor) {
		this.proveedor = proveedor;
	}

	public DTO_Seguro toDTO() {
		DTO_Seguro s = new DTO_Seguro();
		s.setId(this.getIdSeguro());
		s.setIdProveedor(this.getProveedor().getIdProveedor());
		s.setTipoSeguro(this.getTipoSeguro());
		s.setDescripcion(this.descripcion);
		s.setTarifa(this.getTarifa());
		s.setTarifaPorKm(this.tarifaPorKm);
		return s;
	}
}