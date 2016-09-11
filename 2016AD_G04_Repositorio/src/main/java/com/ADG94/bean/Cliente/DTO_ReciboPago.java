package com.ADG94.bean.Cliente;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class DTO_ReciboPago implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date fecha; 
	private List<DTO_DetalleReciboPago> detalle;
	private float monto;
	
	public DTO_ReciboPago(){
		detalle = new ArrayList<DTO_DetalleReciboPago>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DTO_DetalleReciboPago> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DTO_DetalleReciboPago> detalle) {
		this.detalle = detalle;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
