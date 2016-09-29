package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdVehiculo", unique = true, nullable = false)
	private int idVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPlanMantenimiento")
	private PlanMantenimiento planMantenimiento;
	
	@Column(name="Estado")
	private String estado;
	
	@Column(name = "Largo", precision = 53, scale = 0)
	private Double largo;

	@Column(name = "Alto", precision = 53, scale = 0)
	private Double alto;

	@Column(name = "Ancho", precision = 53, scale = 0)
	private Double ancho;

	@Column(name = "Peso", precision = 53, scale = 0)
	private Double peso;

	@Column(name = "Volumen", precision = 53, scale = 0)
	private Double volumen;

	@Column(name = "Refrigerado")
	private Boolean refrigerado;

	@Column(name = "CondicionTransporte", length = 50)
	private String condicionTransporte;

	@Column(name = "KmRecorridos", nullable = false, precision = 53, scale = 0)
	private double kmRecorridos;

	@Column(name = "Marca", nullable = false, length = 100)
	private String marca;
	
	@Column(name = "Modelo", nullable = false, length = 100)
	private String modelo;

	@Column(name = "Patente", nullable = false, length = 15)
	private String patente;

	@Column(name = "Anio", nullable = false)
	private String anio;

	@Column(name = "Tara", nullable = false, precision = 53, scale = 0)
	private double tara;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
	private List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
	private List<CondicionesEspecialesVehiculo> condicionesEspecialesVehiculos;

	public Vehiculo() {
	}

	public Vehiculo(PlanMantenimiento planMantenimiento,
			double kmRecorridos, String marca, String modelo, String patente,
			String anio, double tara) {
		this.planMantenimiento = planMantenimiento;
		this.kmRecorridos = kmRecorridos;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.tara = tara;
	}
	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}


	public PlanMantenimiento getPlanMantenimiento() {
		return this.planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}


	public Double getLargo() {
		return this.largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getAlto() {
		return this.alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getAncho() {
		return this.ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getVolumen() {
		return this.volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	public Boolean getRefrigerado() {
		return this.refrigerado;
	}

	public void setRefrigerado(Boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public String getCondicionTransporte() {
		return this.condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}
	
	public double getKmRecorridos() {
		return this.kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return this.patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public List<TareaMantenimientoRealizada> getTareasMantenimientoRealizadas() {
		return tareasMantenimientoRealizadas;
	}

	public void setTareasMantenimientoRealizadas(
			List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas) {
		this.tareasMantenimientoRealizadas = tareasMantenimientoRealizadas;
	}


	public List<CondicionesEspecialesVehiculo> getCondicionesEspecialesVehiculos() {
		return condicionesEspecialesVehiculos;
	}

	public void setCondicionesEspecialesVehiculos(
			List<CondicionesEspecialesVehiculo> condicionesEspecialesVehiculos) {
		this.condicionesEspecialesVehiculos = condicionesEspecialesVehiculos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
