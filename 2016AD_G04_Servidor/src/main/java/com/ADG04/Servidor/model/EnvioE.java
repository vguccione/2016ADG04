package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;


@Entity
@Table(name = "Envio")
public class EnvioE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdEnvio", unique = true, nullable = false)
	private int idEnvio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProveedor")
	private ProveedorE proveedor;
	
	@ManyToOne
	@JoinColumn(name="IdMapaDeRuta")
	private MapaDeRutaE mapaDeRuta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCoordenadaActual", nullable = false)
	private CoordenadaE posicionActual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private SucursalE sucursalDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private SucursalE sucursalOrigen;

	@OneToOne(fetch = FetchType.LAZY)
	private VehiculoE vehiculo;

	@Column(name = "Estado", nullable = false, length = 20)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaLlegadaEstimada", nullable = false, length = 10)
	private Date fechaYHoraLlegadaEstimada;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FechaSalida", nullable = false, length = 10)
	private Date fechaYHoraSalida;

	@Column(name = "Propio", nullable = false)
	private boolean propio;

	@Column(name = "NroTracking")
	private Integer nroTracking;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "EncomiendaEnvio", joinColumns = {
			@JoinColumn(name = "idEnvio", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idEncomienda",
					nullable = false, updatable = false) })
	private List<EncomiendaE> encomiendas;

	public EnvioE() {
	}

	public EnvioE(VehiculoE vehiculo, String estado,
			Date fechaYHoraLlegadaEstimada, Date fechaYHoraSalida,
			boolean propio, Integer nroTracking) {
		super();
		this.vehiculo = vehiculo;
		this.estado = estado;
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.propio = propio;
		this.nroTracking = nroTracking;
	}




	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public ProveedorE getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(ProveedorE proveedor) {
		this.proveedor = proveedor;
	}

	public CoordenadaE getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(CoordenadaE posicionActual) {
		this.posicionActual = posicionActual;
	}

	public MapaDeRutaE getMapaDeRuta() {
		return mapaDeRuta;
	}

	public void setMapaDeRuta(MapaDeRutaE mapaDeRuta) {
		this.mapaDeRuta = mapaDeRuta;
	}

	public SucursalE getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(SucursalE sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public SucursalE getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(SucursalE sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public VehiculoE getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(VehiculoE vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaYHoraLlegadaEstimada() {
		return fechaYHoraLlegadaEstimada;
	}


	public void setFechaYHoraLlegadaEstimada(Date fechaYHoraLlegadaEstimada) {
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
	}


	public Date getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(Date fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}


	public boolean isPropio() {
		return this.propio;
	}

	public void setPropio(boolean propio) {
		this.propio = propio;
	}

	public Integer getNroTracking() {
		return this.nroTracking;
	}

	public void setNroTracking(Integer nroTracking) {
		this.nroTracking = nroTracking;
	}

	public List<EncomiendaE> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<EncomiendaE> encomiendas) {
		this.encomiendas = encomiendas;
	}

	@Override
	public String toString() {
		return "Envio [idEnvio=" + idEnvio 
				+ ", posicionActual=" + posicionActual + ", sucursalDestino="
				+ sucursalDestino.getIdSucursal() + ", sucursalOrigen=" + sucursalOrigen.getIdSucursal()
				+ ", vehiculo=" + vehiculo.getIdVehiculo() + ", estado=" + estado
				+ ", fechaYHoraLlegadaEstimada=" + fechaYHoraLlegadaEstimada
				+ ", fechaYHoraSalida=" + fechaYHoraSalida + ", propio="
				+ propio + ", nroTracking=" + nroTracking + "]";
	}
	
	public DTO_Envio toDTO(){
		if(this.propio){
			DTO_EnvioPropio dto = new DTO_EnvioPropio();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			dto.setFechaYHoraLlegada(this.getFechaYHoraLlegadaEstimada());
			dto.setFechaYHoraSalida(this.getFechaYHoraSalida());
			dto.setIdHojaDeRuta(this.getMapaDeRuta().getIdMapaDeRuta());
			dto.setIdVehiculo(this.getVehiculo().getIdVehiculo());
			return dto;
		}
		else{
			DTO_EnvioTercerizado dto = new DTO_EnvioTercerizado();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			dto.setIdProveedor(this.getProveedor().getIdProveedor());
			dto.setNumeroTracking(String.valueOf(this.getNroTracking()));
			return dto;
		}
		
	}
	
	
}
