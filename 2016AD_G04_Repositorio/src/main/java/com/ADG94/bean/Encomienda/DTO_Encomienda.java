package com.ADG94.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;

public  class DTO_Encomienda implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer idSucursalOrigen;
	private Integer idDestino;
	private Integer idSucursalActual;
	private Date fechaRecepcion;
	private Date fechaMaxima;
	private String estado;
	private Integer idAseguradora;
	private Integer idSeguro;
	private Integer idServicioSeguridad;
	private float largo;
	private float alto;
	private float ancho;
	private float peso;
	private float volumen;
	private String tratamiento;
	private boolean apilable;
	private int cantApilable;
	private boolean refrigerado;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private String fragilidad;
	private boolean tercerizado;
	private float kilometrosRecorridos;
	private boolean facturado;
	private float valorEstimado;
	private float distanciaEstimadaKM;
	private Integer idFacturaCliente;
	

	public DTO_Encomienda(){

	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdSucursalOrigen() {
		return idSucursalOrigen;
	}

	public void setIdSucursalOrigen(Integer idSucursalOrigen) {
		this.idSucursalOrigen = idSucursalOrigen;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public Integer getIdAseguradora() {
		return idAseguradora;
	}

	public void setIdAseguradora(Integer idAseguradora) {
		this.idAseguradora = idAseguradora;
	}

	public Integer getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(Integer idSeguro) {
		this.idSeguro = idSeguro;
	}

	public Integer getIdServicioSeguridad() {
		return idServicioSeguridad;
	}

	public void setIdServicioSeguridad(Integer idServicioSeguridad) {
		this.idServicioSeguridad = idServicioSeguridad;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdSucursalActual() {
		return idSucursalActual;
	}

	public void setIdSucursalActual(Integer idSucursalActual) {
		this.idSucursalActual = idSucursalActual;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public boolean isApilable() {
		return apilable;
	}

	public void setApilable(boolean apilable) {
		this.apilable = apilable;
	}

	public int getCantApilable() {
		return cantApilable;
	}

	public void setCantApilable(int cantApilable) {
		this.cantApilable = cantApilable;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
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

	public boolean isTercerizado() {
		return tercerizado;
	}

	public void setTercerizado(boolean tercerizado) {
		this.tercerizado = tercerizado;
	}

	public float getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}

	public void setKilometrosRecorridos(float kilometrosRecorridos) {
		this.kilometrosRecorridos = kilometrosRecorridos;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}

	public float getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(float valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public float getDistanciaEstimadaKM() {
		return distanciaEstimadaKM;
	}

	public void setDistanciaEstimadaKM(float distanciaEstimadaKM) {
		this.distanciaEstimadaKM = distanciaEstimadaKM;
	}

	public Integer getIdFacturaCliente() {
		return idFacturaCliente;
	}
	
	public void setIdFacturaCliente(Integer idFacturaCliente) {
		this.idFacturaCliente = idFacturaCliente;
	}
}
