package com.ADG94.bean.Vehiculo;

import java.io.Serializable;
import java.util.Date;


public class DTO_Vehiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	private String patente;
	private String marca;
	private int modelo;
	private float kilometros;
	private float ancho;
	private float alto;
	private float largo;
	private float peso;
	private float tara;
	private float volumen;
	private float costoKM;
	private Date fechaIngreso;
	private Date ultimoMantenimiento;
	private Date ultimoUso;
	private Date vencimientoGarantia;
	private Integer idSucursal;
	private Integer idSucursalActual;
	private Float temperaturaMin;
	private Float temperaturaMax;
	private Integer idPlanMantenimiento;
	private Integer idEnvio;
	public DTO_Vehiculo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public float getKilometros() {
		return kilometros;
	}

	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public float getCostoKM() {
		return costoKM;
	}

	public void setCostoKM(float costoKM) {
		this.costoKM = costoKM;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getUltimoMantenimiento() {
		return ultimoMantenimiento;
	}

	public void setUltimoMantenimiento(Date ultimoMantenimiento) {
		this.ultimoMantenimiento = ultimoMantenimiento;
	}

	public Date getUltimoUso() {
		return ultimoUso;
	}

	public void setUltimoUso(Date ultimoUso) {
		this.ultimoUso = ultimoUso;
	}

	public Date getVencimientoGarantia() {
		return vencimientoGarantia;
	}

	public void setVencimientoGarantia(Date vencimientoGarantia) {
		this.vencimientoGarantia = vencimientoGarantia;
	}

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Integer getIdSucursalActual() {
		return idSucursalActual;
	}

	public void setIdSucursalActual(Integer idSucursalActual) {
		this.idSucursalActual = idSucursalActual;
	}

	public Float getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(Float temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public Float getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(Float temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public Integer getIdPlanMantenimiento() {
		return idPlanMantenimiento;
	}

	public void setIdPlanMantenimiento(Integer idPlanMantenimiento) {
		this.idPlanMantenimiento = idPlanMantenimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}

}
