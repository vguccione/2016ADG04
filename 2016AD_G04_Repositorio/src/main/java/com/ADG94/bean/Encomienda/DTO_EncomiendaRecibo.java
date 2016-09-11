package com.ADG94.bean.Encomienda;

import java.util.Date;


public class DTO_EncomiendaRecibo {
	private Integer id;
	private Integer idEncomienda;
	private Date fecha;
	
	
	public DTO_EncomiendaRecibo() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

}
