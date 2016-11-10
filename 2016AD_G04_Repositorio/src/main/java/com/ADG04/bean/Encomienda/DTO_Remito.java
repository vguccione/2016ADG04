package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class DTO_Remito implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date fecha;
	private boolean conformado;
	private String apellidoReceptor;
	private String nombreReceptor;
	private String dniReceptor;
	private List<DTO_ItemRemito> detalle;
	private Date fechaEstimadaEntrega;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private int idEncomienda;
	
	public DTO_Remito(){
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public int getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isConformado() {
		return conformado;
	}

	public void setConformado(boolean conformado) {
		this.conformado = conformado;
	}

	

	public String getApellidoReceptor() {
		return apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getNombreReceptor() {
		return nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getDniReceptor() {
		return dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public List<DTO_ItemRemito> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DTO_ItemRemito> detalle) {
		this.detalle = detalle;
	}

	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getCondicionTransporte() {
		return condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public String getIndicacionesManipulacion() {
		return indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}	

}
