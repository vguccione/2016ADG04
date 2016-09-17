package com.ADG04.bean.Encomienda;

import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class DTO_Encomienda {

	private int idEncomienda;
	private DTO_ItemFactura itemFactura;
	private DTO_Direccion direccionOrigen;
	private DTO_Direccion direccionDestino;

	private DTO_Envio envio;
	
	private DTO_Sucursal sucursalOrigen;
	private DTO_Sucursal sucursalDestino;
	
	private Date fechaCreacion;
	private Date fechaEstimadaEntrega;
	private String estado;

	private Double largo;
	private Double alto;
	private Double ancho;
	private Double peso;
	private Double volumen;
	private String tratamiento;
	private Boolean apilable;
	private Short cantApilable;
	private Boolean refrigerado;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private String fragilidad;

	private String nombreReceptor;
	private String apellidoReceptor;
	private String dniReceptor;
	
	private Double volumenGranel;
	private String unidadGranel;
	private String cargaGranel;
	private List<DTO_Remito> remitos;
			
	public DTO_Encomienda() {
		super();
	}
	public int getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public DTO_ItemFactura getItemFactura() {
		return itemFactura;
	}
	public void setItemFactura(DTO_ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}
	public DTO_Direccion getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(DTO_Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public DTO_Direccion getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(DTO_Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	public DTO_Envio getEnvio() {
		return envio;
	}
	public void setEnvio(DTO_Envio envio) {
		this.envio = envio;
	}
	public DTO_Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}
	public void setSucursalOrigen(DTO_Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}
	public DTO_Sucursal getSucursalDestino() {
		return sucursalDestino;
	}
	public void setSucursalDestino(DTO_Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}
	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getLargo() {
		return largo;
	}
	public void setLargo(Double largo) {
		this.largo = largo;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getVolumen() {
		return volumen;
	}
	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Boolean getApilable() {
		return apilable;
	}
	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}
	public Short getCantApilable() {
		return cantApilable;
	}
	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
	}
	public Boolean getRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(Boolean refrigerado) {
		this.refrigerado = refrigerado;
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
	public String getFragilidad() {
		return fragilidad;
	}
	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}
	public String getNombreReceptor() {
		return nombreReceptor;
	}
	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}
	public String getApellidoReceptor() {
		return apellidoReceptor;
	}
	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}
	public String getDniReceptor() {
		return dniReceptor;
	}
	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}
	public Double getVolumenGranel() {
		return volumenGranel;
	}
	public void setVolumenGranel(Double volumenGranel) {
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
	public List<DTO_Remito> getRemitos() {
		return remitos;
	}
	public void setRemitos(List<DTO_Remito> remitos) {
		this.remitos = remitos;
	}

	
}
