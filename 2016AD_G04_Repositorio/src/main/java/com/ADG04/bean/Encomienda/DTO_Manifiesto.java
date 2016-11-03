package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DTO_Manifiesto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
	private int idManifiesto;
	private List<DTO_ItemManifiesto> detalle = new ArrayList<DTO_ItemManifiesto>();
	
	public DTO_Manifiesto(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdManifiesto() {
		return idManifiesto;
	}

	public void setIdManifiesto(int idManifiesto) {
		this.idManifiesto = idManifiesto;
	}

	public List<DTO_ItemManifiesto> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DTO_ItemManifiesto> detalle) {
		this.detalle = detalle;
	}

	public void addItem(DTO_ItemManifiesto item) {
		this.detalle.add(item);
		
	}
	

}

