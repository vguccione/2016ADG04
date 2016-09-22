package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_TallerMecanico;


@Entity
@Table(name="TallerMecanico")
@PrimaryKeyJoinColumn(name="idProveedor") 
public class TallerMecanico extends Proveedor implements java.io.Serializable{
	
	@Column(name="Tarifa")
	private float tarifa;

	@Column(name="TipoTaller")
	private String tipoTaller;

	public TallerMecanico() {
		
	}

	public TallerMecanico(float tarifa, String tipoTaller) {
		super();
		this.tarifa = tarifa;
		this.tipoTaller = tipoTaller;
	}


	public float getTarifa() {
		return tarifa;
	}


	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}


	public String getTipoTaller() {
		return tipoTaller;
	}


	public void setTipoTaller(String tipoTaller) {
		this.tipoTaller = tipoTaller;
	}


	public DTO_TallerMecanico toDTO() {
		DTO_TallerMecanico t = new DTO_TallerMecanico();
		t.setIdProveedor(this.getIdProveedor());
		t.setTarifa(this.tarifa);
		t.setTipoTaller(this.tipoTaller);
		return t;
	}
}