package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Encomienda")
public class Encomienda implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdEncomienda", unique = true, nullable = false)
	private int idEncomienda;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdFactura", nullable = true)
	private Factura factura;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDireccionDestino")
	private Direccion direccionDestino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private Sucursal sucursalDestno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdEnvio", nullable = true)
	private Envio envio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private Sucursal sucursalOrigen;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDireccionOrigen")
	private Direccion direccionOrigen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSucursalActual")
	private Sucursal sucursalActual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCliente", nullable = false)
	private Cliente cliente;

	@Column(name = "TipoEncomienda", nullable = false, length = 2)
	private String tipoEncomienda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FechaCreacion", nullable = false, length = 23)
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FechaEstimadaEntrega", nullable = true, length = 23)
	private Date fechaEstimadaEntrega;

	@Column(name = "Estado", nullable = false, length = 50)
	private String estado;

	@Column(name = "Tercerizado", nullable = false)
	private boolean tercerizado;

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

	@Column(name = "Tratamiento", length = 50)
	private String tratamiento;

	@Column(name = "Apilable")
	private Boolean apilable;

	@Column(name = "CantApilable")
	private Short cantApilable;

	@Column(name = "Refrigerado")
	private Boolean refrigerado;

	@Column(name = "CondicionTransporte", length = 50)
	private String condicionTransporte;

	@Column(name = "IndicacionesManipulacion", length = 1000)
	private String indicacionesManipulacion;

	@Column(name = "Fragilidad", length = 20)
	private String fragilidad;

	@Column(name = "NombreReceptor", nullable = false, length = 100)
	private String nombreReceptor;

	@Column(name = "ApellidoReceptor", nullable = false, length = 100)
	private String apellidoReceptor;

	@Column(name = "DniReceptor", nullable = false, length = 8)
	private String dniReceptor;

	@Column(name = "VolumenGranel", precision = 53, scale = 0)
	private Double volumenGranel;

	@Column(name = "UnidadGranel", length = 25)
	private String unidadGranel;

	@Column(name = "CargaGranel", length = 100)
	private String cargaGranel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encomienda")
	private List<Remito> remitos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encomienda")
	private List<ProductoEncomienda> productoEncomiendas;

	public Encomienda() {
	}

	public Encomienda(//ItemFactura itemFactura,
			Sucursal sucursalDestino, Envio envio,
			Sucursal sucursalOrigen, Cliente cliente,
			String tipoEncomienda, Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			{
	//	this.itemFactura = itemFactura;
		this.sucursalDestno = sucursalDestino;
		//this.envio = envio;
		this.sucursalOrigen = sucursalOrigen;
		this.cliente = cliente;
		this.tipoEncomienda = tipoEncomienda;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		//this.tercerizado = tercerizado;
		//this.nombreReceptor = nombreReceptor;
	//	this.apellidoReceptor = apellidoReceptor;
	//	this.dniReceptor = dniReceptor;
	}

	public int getIdEncomienda() {
		return this.idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Direccion getDireccionDestino() {
		return this.direccionDestino;
	}

	public void setDireccionDestino(
			Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public Sucursal getSucursalDestino() {
		return this.sucursalDestno;
	}

	public void setSucursalDestino(
			Sucursal sucursalDestino) {
		this.sucursalDestno = sucursalDestino;
	}

	public Envio getEnvio() {
		return this.envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}


	public Sucursal getSucursalOrigen() {
		return this.sucursalOrigen;
	}

	public void setSucursalOrigen(
			Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Direccion getDireccionOrigen() {
		return this.direccionOrigen;
	}

	public void setDireccionOrigen(
			Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}


	public Sucursal getSucursalActual() {
		return this.sucursalActual;
	}

	public void setSucursalActual(Sucursal sucursalActual) {
		this.sucursalActual = sucursalActual;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipoEncomienda() {
		return this.tipoEncomienda;
	}

	public void setTipoEncomienda(String tipoEncomienda) {
		this.tipoEncomienda = tipoEncomienda;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstimadaEntrega() {
		return this.fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isTercerizado() {
		return this.tercerizado;
	}

	public void setTercerizado(boolean tercerizado) {
		this.tercerizado = tercerizado;
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

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Boolean getApilable() {
		return this.apilable;
	}

	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}

	public Short getCantApilable() {
		return this.cantApilable;
	}

	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
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

	public String getIndicacionesManipulacion() {
		return this.indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}

	public String getFragilidad() {
		return this.fragilidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public Double getVolumenGranel() {
		return this.volumenGranel;
	}

	public void setVolumenGranel(Double volumenGranel) {
		this.volumenGranel = volumenGranel;
	}

	public String getUnidadGranel() {
		return this.unidadGranel;
	}

	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}

	public String getCargaGranel() {
		return this.cargaGranel;
	}

	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}

	public List<Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<Remito> remitos) {
		this.remitos = remitos;
	}

	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}

	public float getKMs() {
		// TODO se calcula cada vez que se pide, o se calcula cuando se da de alta la encomienda y lo guardamos????
		return 0;
	}

	public float getCostoKMExtra() {
		// TODO esto????
		return 0;
	}

	public float getCostoPorKm() {
		// TODO y esto??????
		return 0;
	}

	public Seguro getSeguro() {
		// TODO hay que hacer esto!!!!!!1, tenemos que guardar un proovedor de tipo "Seguro"
		Seguro p = new Seguro();
		p.setTarifa(123.0F);
		p.setTarifaPorKm(456.0F);
		p.setIdProveedor(1);
		return p;
	}

}
