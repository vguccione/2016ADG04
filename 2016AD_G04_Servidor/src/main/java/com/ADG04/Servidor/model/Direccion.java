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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Direccion")
public class Direccion implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdDireccion", unique = true, nullable = false)
	private int idDireccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPais", nullable = false)
	private Pais pais;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProvincia", nullable = false)
	private Provincia provincia;
	
	@Column(name = "Calle", nullable = false, length = 100)
	private String calle;
	
	@Column(name = "Nro", nullable = false)
	private int nro;

	@Column(name = "Localidad", nullable = false, length = 100)
	private String localidad;
	private int codigoPostal;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direccion")
	private List<Sucursal> sucursales;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direccionOrigen")
	private List<Encomienda> encomiendasOrigen;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "direccion")
	private List<Proveedor> proveedores;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="direccion")
	private Cliente cliente;
	
	public Direccion() {
	}


	public Direccion(Pais pais, Provincia provincia,
			String calle, int nro, String localidad, int codigoPostal) {
		super();
		this.pais = pais;
		this.provincia = provincia;
		this.calle = calle;
		this.nro = nro;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}



	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return this.nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name = "CodigoPostal", nullable = false)
	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public List<Sucursal> getSucursales() {
		return sucursales;
	}


	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}


	public List<Encomienda> getEncomiendasOrigen() {
		return encomiendasOrigen;
	}


	public void setEncomiendasOrigen(
			List<Encomienda> encomiendasOrigen) {
		this.encomiendasOrigen = encomiendasOrigen;
	}


	public List<Proveedor> getProveedores() {
		return proveedores;
	}


	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
