package com.ADG94.bean.Cliente;

import java.io.Serializable;

public class DTO_DetalleReciboPago implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idFactura;
	private float montoPagado;
	
	public DTO_DetalleReciboPago(){		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public float getMontoPagado() {
		return montoPagado;
	}
	public void setMontoPagado(float montoPagado) {
		this.montoPagado = montoPagado;
	}
}
