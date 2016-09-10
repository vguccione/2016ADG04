package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdCliente", unique = true, nullable = false)
	private int idCliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTipoCliente", nullable = false)
	private TipoCliente tipoCliente;
	
	@Column(name = "RazonSocial", length = 50)
	private String razonSocial;
	
	@Column(name = "Cuit", length = 50)
	private String cuit;
	
	@Column(name = "Estado", nullable = false)
	private boolean estado;

	@Column(name = "Email", nullable = false, length = 50)
	private String email;

	@Column(name = "Telefono", nullable = false, length = 50)
	private String telefono;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <Producto> productos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <Encomienda> encomiendas;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <CuentaCorriente> cuentaCorrientes;

	public Cliente() {
	}

	public Cliente(TipoCliente tipoCliente, //Direccion direccion,
			boolean estado, String email, String telefono) {
		this.tipoCliente = tipoCliente;
		//this.direccion = direccion;
		this.estado = estado;
		this.email = email;
		this.telefono = telefono;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return this.cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}

	public List<CuentaCorriente> getCuentaCorrientes() {
		return cuentaCorrientes;
	}

	public void setCuentaCorrientes(List<CuentaCorriente> cuentaCorrientes) {
		this.cuentaCorrientes = cuentaCorrientes;
	}

}
