package com.ADG94.bean.Encomienda;

import java.sql.Time;
import java.util.Date;
import java.util.List;



public class DTO_EncomiendaEmpresa extends DTO_Encomienda{
	private static final long serialVersionUID = 1L;
	private Integer idCliente;
	private Integer idDireccionEntrega;
	private boolean aRetirar;
	private String lugarRetiro;
	private Date fechaRetiro;
	private Time horaMinima;
	private Time horaMaxima;
	private List<DTO_ProductoClienteEncomienda> productos;
	
	//Sin Logistica
	private DTO_Manifiesto manifiesto;
	
	//A Granel
	private float volumenGranel;
	private String unidadGranel;
	private String cargaGranel;
	
	public DTO_EncomiendaEmpresa(){
		super();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdDireccionEntrega() {
		return idDireccionEntrega;
	}

	public void setIdDireccionEntrega(Integer idDireccionEntrega) {
		this.idDireccionEntrega = idDireccionEntrega;
	}

	public boolean isaRetirar() {
		return aRetirar;
	}

	public void setaRetirar(boolean aRetirar) {
		this.aRetirar = aRetirar;
	}

	public String getLugarRetiro() {
		return lugarRetiro;
	}

	public void setLugarRetiro(String lugarRetiro) {
		this.lugarRetiro = lugarRetiro;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Time getHoraMinima() {
		return horaMinima;
	}

	public void setHoraMinima(Time horaMinima) {
		this.horaMinima = horaMinima;
	}

	public Time getHoraMaxima() {
		return horaMaxima;
	}

	public void setHoraMaxima(Time horaMaxima) {
		this.horaMaxima = horaMaxima;
	}

	public List<DTO_ProductoClienteEncomienda> getProductos() {
		return productos;
	}

	public void setProductos(List<DTO_ProductoClienteEncomienda> productos) {
		this.productos = productos;
	}

	public DTO_Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(DTO_Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public float getVolumenGranel() {
		return volumenGranel;
	}

	public void setVolumenGranel(float volumenGranel) {
		this.volumenGranel = volumenGranel;
	}

	public String getUnidadGranel() {
		return unidadGranel;
	}

	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}

	public String getCargaGranel() {
		return cargaGranel;
	}

	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
