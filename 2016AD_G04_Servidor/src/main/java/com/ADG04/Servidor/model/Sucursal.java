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
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;

@Entity
@Table(name = "Sucursal")
public class Sucursal implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdSucursal", unique = true, nullable = false)
	private int idSucursal;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name = "Telefono")
	private String telefono;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDireccion", nullable = false)
	private Direccion direccion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalByIdSucursalOrigen")
	private List<MapaDeRuta> mapasSucursalOrigen;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalByIdSucursalDestino")
	private List<MapaDeRuta> mapasSucursalDestino;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalByIdSucursalDestino")
	private List<Envio> enviosSucursalDestino;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalByIdSucursalOrigen")
	private List<Envio> enviosSucursalOrigen;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalDestno")
	private List<Encomienda> encomiendasSucursalDestino;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalOrigen")
	private List<Encomienda> encomiendasSucursalOrigen;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursalActual")
	private List<Encomienda> encomiendasSucursalActual;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sucursal")
	private List<Usuario> usuarios;

	public Sucursal() {
	}
	
	public Sucursal(String descripcion, String telefono) {
		super();
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<MapaDeRuta> getMapasSucursalOrigen() {
		return mapasSucursalOrigen;
	}

	public void setMapasSucursalOrigen(List<MapaDeRuta> mapasSucursalOrigen) {
		this.mapasSucursalOrigen = mapasSucursalOrigen;
	}

	public List<MapaDeRuta> getMapasSucursalDestino() {
		return mapasSucursalDestino;
	}

	public void setMapasSucursalDestino(List<MapaDeRuta> mapasSucursalDestino) {
		this.mapasSucursalDestino = mapasSucursalDestino;
	}

	public List<Envio> getEnviosSucursalDestino() {
		return enviosSucursalDestino;
	}

	public void setEnviosSucursalDestino(List<Envio> enviosSucursalDestino) {
		this.enviosSucursalDestino = enviosSucursalDestino;
	}

	public List<Envio> getEnviosSucursalOrigen() {
		return enviosSucursalOrigen;
	}

	public void setEnviosSucursalOrigen(List<Envio> enviosSucursalOrigen) {
		this.enviosSucursalOrigen = enviosSucursalOrigen;
	}

	public List<Encomienda> getEncomiendasSucursalDestino() {
		return encomiendasSucursalDestino;
	}

	public void setEncomiendasSucursalDestino(
			List<Encomienda> encomiendasSucursalDestino) {
		this.encomiendasSucursalDestino = encomiendasSucursalDestino;
	}

	public List<Encomienda> getEncomiendasSucursalOrigen() {
		return encomiendasSucursalOrigen;
	}

	public void setEncomiendasSucursalOrigen(
			List<Encomienda> encomiendasSucursalOrigen) {
		this.encomiendasSucursalOrigen = encomiendasSucursalOrigen;
	}

	public List<Encomienda> getEncomiendasSucursalActual() {
		return encomiendasSucursalActual;
	}

	public void setEncomiendasSucursalActual(
			List<Encomienda> encomiendasSucursalActual) {
		this.encomiendasSucursalActual = encomiendasSucursalActual;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public void setTelefono(String telefono) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getTelefono() {
		return telefono;//afkash alidhahd
	}

	public DTO_Sucursal toDTO(){
		DTO_Sucursal s = new DTO_Sucursal();
		s.setDescripcion(this.descripcion);
		s.setTelefono(this.telefono);
		return s;
	}

}
