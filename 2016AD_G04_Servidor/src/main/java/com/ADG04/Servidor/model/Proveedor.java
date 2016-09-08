package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
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
@Table(name = "Proveedor")
public class Proveedor implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdProveedor", unique = true, nullable = false)
	private int idProveedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTipoProveedor", nullable = false)
	private TipoProveedor tipoProveedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdDireccion")
	private Direccion direccion;

	@Column(name = "Activo", nullable = false, length = 1)
	private String activo;

	@Column(name = "Cuit", nullable = false, length = 10)
	private String cuit;

	@Column(name = "RazonSocial", nullable = false, length = 50)
	private String razonSocial;
	
	@Column(name = "Email", nullable = false, length = 50)
	private String email;

	@Column(name = "Telefono", nullable = false, length = 50)
	private String telefono;

	@Column(name = "TarifaPorKm", precision = 53, scale = 0)
	private Double tarifaPorKm;

	@Column(name = "Tarifa", precision = 53, scale = 0)
	private Double tarifa;

	@Column(name = "TipoTaller", length = 20)
	private String tipoTaller;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	private List<TareaMantenimientoRealizada> tareaMantenimientoRealizadas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	private List<Envio> envios;
	
	public Proveedor() {
	}

	public Proveedor(TipoProveedor tipoProveedor,
			String activo, String cuit, String razonSocial, String email,
			String telefono) {
		this.tipoProveedor = tipoProveedor;
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public TipoProveedor getTipoProveedor() {
		return this.tipoProveedor;
	}

	public void setTipoProveedor(TipoProveedor tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCuit() {
		return this.cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getTarifaPorKm() {
		return this.tarifaPorKm;
	}

	public void setTarifaPorKm(Double tarifaPorKm) {
		this.tarifaPorKm = tarifaPorKm;
	}

	public Double getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipoTaller() {
		return this.tipoTaller;
	}

	public void setTipoTaller(String tipoTaller) {
		this.tipoTaller = tipoTaller;
	}

	public List<TareaMantenimientoRealizada> getTareaMantenimientoRealizadas() {
		return tareaMantenimientoRealizadas;
	}

	public void setTareaMantenimientoRealizadas(
			List<TareaMantenimientoRealizada> tareaMantenimientoRealizadas) {
		this.tareaMantenimientoRealizadas = tareaMantenimientoRealizadas;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}
	
	
}
