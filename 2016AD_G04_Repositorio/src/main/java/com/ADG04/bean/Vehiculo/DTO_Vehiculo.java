package com.ADG04.bean.Vehiculo;

import java.io.Serializable;
import java.util.Date;

import com.ADG94.bean.Administracion.DTO_Sucursal;


public class DTO_Vehiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private float largo;
	private float ancho;
	private float alto;
	private float peso;
	private float volumen;
	private boolean refrigerado;
	private String condicionTransporte;
	private float kmsRecorridos;

	private String patente;
	private int modelo;
	private String marca;
	private int anio;
	
	private float tara;
	
	private float costoKM;
	private Date fechaIngreso;
	
	//private Date ultimoMantenimiento;
	//private Date ultimoUso;
	//private Date vencimientoGarantia;
	//private Integer idSucursal;
	private DTO_Sucursal sucursalActual;
	//private Float temperaturaMin;
	//private Float temperaturaMax;
	private DTO_PlanMantenimiento planMantenimiento;
		
	public DTO_Vehiculo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
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
		return kmsRecorridos;
	}

	public void setKilometros(float kilometros) {
		this.kmsRecorridos = kilometros;
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
/*
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

*/
	public DTO_Sucursal getSucursalActual() {
		return sucursalActual;
	}

	public void setSucursalActual(DTO_Sucursal sucursalActual) {
		this.sucursalActual = sucursalActual;
	}
/*
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
*/
	public DTO_PlanMantenimiento getPlanMantenimiento() {
		return planMantenimiento;
	}

	public void setPlanMantenimiento(DTO_PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}*/

}
