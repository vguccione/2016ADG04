package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
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

import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;


@Table(name = "Vehiculo")
public class Vehiculo implements java.io.Serializable {

	
	
	@Column(name = "IdVehiculo", unique = true, nullable = false)
	private int idVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPlanMantenimiento")
	private PlanMantenimiento planMantenimiento;
	
	@Column(name="Estado")
	private String estado;
	
	@Column(name = "Largo", precision = 53, scale = 0)
	private float largo;

	@Column(name = "Alto", precision = 53, scale = 0)
	private float alto;

	@Column(name = "Ancho", precision = 53, scale = 0)
	private float ancho;

	@Column(name = "Peso", precision = 53, scale = 0)
	private float peso;

	@Column(name = "Volumen", precision = 53, scale = 0)
	private float volumen;

	@Column(name = "Refrigerado")
	private Boolean refrigerado;

	@Column(name = "CondicionTransporte", length = 50)
	private String condicionTransporte;

	@Column(name = "KmRecorridos", nullable = false, precision = 53, scale = 0)
	private float kmRecorridos;

	@Column(name = "Marca", nullable = false, length = 100)
	private String marca;
	
	@Column(name = "Modelo", nullable = false, length = 100)
	private String modelo;

	@Column(name = "Patente", nullable = false, length = 15)
	private String patente;
	
	@Column(name="TemperaturaMin", nullable=true)
	private Float temperaturaMin;
	
	@Column(name="TemperaturaMax", nullable=true)
	private Float temperaturaMax;

	@Column(name = "Anio", nullable = false)
	private String anio;

	@Column(name = "Tara", nullable = false, precision = 53, scale = 0)
	private float tara;
	
	@Column(name="Tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="idSucursal")
	private Sucursal sucursal;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
	private List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculo")
	private List<CondicionesEspecialesVehiculo> condicionesEspecialesVehiculos;

	@Column(name="FechaIngreso", nullable=false)
	private Date FechaIngreso;
	

	public Vehiculo() {
	}

  	public Vehiculo(String estado, float largo, float alto, float ancho,
			float peso, float volumen, Boolean refrigerado,
			String condicionTransporte, float kmRecorridos, String marca,
			String modelo, String patente, Float temperaturaMin,
			Float temperaturaMax, String anio, float tara, String tipo,
			Date fechaIngreso) {
		super();
		this.estado = estado;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.volumen = volumen;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.kmRecorridos = kmRecorridos;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.anio = anio;
		this.tara = tara;
		this.tipo = tipo;
		FechaIngreso = fechaIngreso;
	}




	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
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


	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public float getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
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

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
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
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public DTO_Vehiculo toDTO() {
		DTO_Vehiculo v = new DTO_Vehiculo();
		v.setEstado(this.estado);
		v.setSucursal(this.getSucursal().toDTO());
		v.setId(this.getIdVehiculo());
		v.setAlto(alto);
		v.setAncho(ancho);
		v.setKmsRecorridos(this.getKmRecorridos());
		v.setLargo(largo);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setPatente(patente);
		v.setPeso(peso);
		v.setTipo(tipo);
		v.setTemperaturaMax(temperaturaMax);
		v.setTemperaturaMin(temperaturaMin);
		if(refrigerado==null)
			refrigerado = false;
		else
			refrigerado=true;
		v.setRefrigerado(refrigerado);
		v.setTara(tara);
		v.setVolumen(volumen);
		v.setFechaIngreso(this.getFechaIngreso());
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(this.getPlanMantenimiento().getIdPlanMantenimiento());
		v.setPlanMantenimiento(pm.toDTO());
		return v;
	}

}
