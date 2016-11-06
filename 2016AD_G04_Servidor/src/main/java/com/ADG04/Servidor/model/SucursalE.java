package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;

@Entity
@Table(name = "Sucursal")
public class SucursalE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdSucursal", unique = true, nullable = false)
	private int idSucursal;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name = "Telefono")
	private String telefono;
	
	@OneToOne
	@JoinColumn(name = "IdGerente", nullable = true)
	private UsuarioE gerente;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name = "IdDireccion", nullable = false)
	private DireccionE direccion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalOrigen")
	private List<EnvioE> enviosSucursalDestino;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalDestino")
	private List<EnvioE> enviosSucursalOrigen;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalDestno")
	private List<EncomiendaE> encomiendasSucursalDestino;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalOrigen")
	private List<EncomiendaE> encomiendasSucursalOrigen;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalActual")
	private List<EncomiendaE> encomiendasSucursalActual;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal")
	private List<UsuarioE> usuarios; 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal", cascade=CascadeType.ALL)
	private List<VehiculoE> vehiculos;
	
	@OneToOne
	@JoinColumn(name="Coordenada")
	private CoordenadaE coordenadas;

	public SucursalE() {
	}
	
	public SucursalE(String descripcion, String telefono) {
		super();
		this.descripcion = descripcion;
		this.telefono = telefono;
	}




	public SucursalE(int idSucursal, String descripcion, String telefono) {
		super();
		this.idSucursal=idSucursal;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DireccionE getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionE direccion) {
		this.direccion = direccion;
	}

	public List<EnvioE> getEnviosSucursalDestino() {
		return enviosSucursalDestino;
	}

	public void setEnviosSucursalDestino(List<EnvioE> enviosSucursalDestino) {
		this.enviosSucursalDestino = enviosSucursalDestino;
	}

	public List<EnvioE> getEnviosSucursalOrigen() {
		return enviosSucursalOrigen;
	}

	public void setEnviosSucursalOrigen(List<EnvioE> enviosSucursalOrigen) {
		this.enviosSucursalOrigen = enviosSucursalOrigen;
	}

	public UsuarioE getGerente() {
		return gerente;
	}

	public void setGerente(UsuarioE gerente) {
		this.gerente = gerente;
	}

	public List<EncomiendaE> getEncomiendasSucursalDestino() {
		return encomiendasSucursalDestino;
	}

	public void setEncomiendasSucursalDestino(
			List<EncomiendaE> encomiendasSucursalDestino) {
		this.encomiendasSucursalDestino = encomiendasSucursalDestino;
	}

	public List<EncomiendaE> getEncomiendasSucursalOrigen() {
		return encomiendasSucursalOrigen;
	}

	public void setEncomiendasSucursalOrigen(
			List<EncomiendaE> encomiendasSucursalOrigen) {
		this.encomiendasSucursalOrigen = encomiendasSucursalOrigen;
	}

	public List<EncomiendaE> getEncomiendasSucursalActual() {
		return encomiendasSucursalActual;
	}

	public void setEncomiendasSucursalActual(
			List<EncomiendaE> encomiendasSucursalActual) {
		this.encomiendasSucursalActual = encomiendasSucursalActual;
	}

	public List<UsuarioE> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioE> usuarios) {
		this.usuarios = usuarios;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	
	

	public List<VehiculoE> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<VehiculoE> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	

	public CoordenadaE getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(CoordenadaE coordenadas) {
		this.coordenadas = coordenadas;
	}


}
