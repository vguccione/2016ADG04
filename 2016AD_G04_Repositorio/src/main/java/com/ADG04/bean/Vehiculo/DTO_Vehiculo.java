package com.ADG04.bean.Vehiculo;

import java.io.Serializable;
import java.util.Date;

import com.ADG04.bean.Administracion.DTO_Sucursal;


public class DTO_Vehiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date fechaIngreso;
	private String tipo;

	private float largo;
	private float ancho;
	private float alto;
	private float peso;
	private float volumen;
	private boolean refrigerado;
	private String condicionTransporte;
	private float kmsRecorridos;
	private Float temperaturaMin;
	private Float temperaturaMax;
	

	private String patente;
	private String modelo;
	private String marca;
	private String anio;
	
	private String estado;

	public DTO_Vehiculo(Date fechaIngreso, float largo, float ancho,
			float alto, float peso, float volumen, boolean refrigerado,
			String condicionTransporte, float kmsRecorridos, String patente,
			String modelo, String marca, String anio, String estado, float tara) {
		super();
		this.fechaIngreso = fechaIngreso;
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		this.peso = peso;
		this.volumen = volumen;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.kmsRecorridos = kmsRecorridos;
		this.patente = patente;
		this.modelo = modelo;
		this.marca = marca;
		this.anio = anio;
		this.estado = estado;
		this.tara = tara;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCondicionTransporte() {
		return condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public float getKmsRecorridos() {
		return kmsRecorridos;
	}

	public void setKmsRecorridos(float kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	private float tara;
	
	//private float costoKM;
	//private Date fechaIngreso;
	
	//private Date ultimoMantenimiento;
	//private Date ultimoUso;
	//private Date vencimientoGarantia;
	//private Integer idSucursal;
	private DTO_Sucursal sucursal;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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
/*
	public float getCostoKM() {
		return costoKM;
	}

	public void setCostoKM(float costoKM) {
		this.costoKM = costoKM;
	}*/
/*
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}*/
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
	public DTO_Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(DTO_Sucursal sucursal) {
		this.sucursal = sucursal;
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

	public DTO_PlanMantenimiento getPlanMantenimiento() {
		return planMantenimiento;
	}

	public void setPlanMantenimiento(DTO_PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
/*
	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}*/

}
