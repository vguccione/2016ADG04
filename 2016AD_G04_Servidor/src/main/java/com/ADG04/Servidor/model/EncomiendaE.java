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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.bean.Encomienda.DTO_Encomienda;

@Entity
@Table(name = "Encomienda")
public class EncomiendaE implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "IdEncomienda", unique = true, nullable = false)
	private int idEncomienda;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDireccionDestino")
	private DireccionE direccionDestino;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSucursalDestino", nullable = false)
	private SucursalE sucursalDestno;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSucursalOrigen", nullable = false)
	private SucursalE sucursalOrigen;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDireccionOrigen")
	private DireccionE direccionOrigen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdSucursalActual")
	private SucursalE sucursalActual;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdCliente", nullable = false)
	private ClienteE cliente;

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
	private float largo;

	@Column(name = "Alto", precision = 53, scale = 0)
	private float alto;

	@Column(name = "Ancho", precision = 53, scale = 0)
	private float ancho;

	@Column(name = "Peso", precision = 53, scale = 0)
	private float peso;

	@Column(name = "Volumen", precision = 53, scale = 0)
	private float volumen;

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
	private float volumenGranel;

	@Column(name = "UnidadGranel", length = 25)
	private String unidadGranel;

	@Column(name = "CargaGranel", length = 100)
	private String cargaGranel;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "encomienda")
	private List<ProductoEncomiendaE> productoEncomiendas;
	
	@Column(name="EsTerciarizado")
	private boolean terciarizado;
	
	@Column(name="ServicioSeguridad")
	private ServicioSeguridadE servicioSeguridad;
	
	@OneToOne(mappedBy="encomienda", cascade=CascadeType.ALL, orphanRemoval=true)
	private ManifiestoE manifiesto;
	
	@OneToOne(mappedBy="encomienda", cascade=CascadeType.ALL, orphanRemoval=true)
	private FacturaE factura;
	
	@OneToOne(mappedBy="encomienda", cascade=CascadeType.ALL, orphanRemoval=true)
	private RemitoE remito;
	
	@Column(name="Internacional")
	private boolean internacional;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "encomiendas")
	private List<EnvioE> envios;
	

	public EncomiendaE() {
	}

	public EncomiendaE(//ItemFactura itemFactura,
			SucursalE sucursalDestino, 
			SucursalE sucursalOrigen, ClienteE cliente,
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

	public FacturaE getFactura() {
		return this.factura;
	}

	public void setFactura(FacturaE factura) {
		this.factura = factura;
	}

	public DireccionE getDireccionDestino() {
		return this.direccionDestino;
	}

	public void setDireccionDestino(
			DireccionE direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public SucursalE getSucursalDestino() {
		return this.sucursalDestno;
	}

	public void setSucursalDestino(
			SucursalE sucursalDestino) {
		this.sucursalDestno = sucursalDestino;
	}

	public SucursalE getSucursalOrigen() {
		return this.sucursalOrigen;
	}

	public void setSucursalOrigen(
			SucursalE sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public DireccionE getDireccionOrigen() {
		return this.direccionOrigen;
	}

	public void setDireccionOrigen(
			DireccionE direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}


	public SucursalE getSucursalActual() {
		return this.sucursalActual;
	}

	public void setSucursalActual(SucursalE sucursalActual) {
		this.sucursalActual = sucursalActual;
	}

	public ClienteE getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteE cliente) {
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

	public float getLargo() {
		return this.largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAlto() {
		return this.alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return this.ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return this.volumen;
	}

	public void setVolumen(float volumen) {
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

	public float getVolumenGranel() {
		return this.volumenGranel;
	}

	public void setVolumenGranel(float volumenGranel) {
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

	public List<ProductoEncomiendaE> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomiendaE> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}

	public SeguroE getSeguro() {
		SeguroE p = new SeguroE();
		p.setTarifa(123.0F);
		p.setTarifaPorKm(456.0F);
		p.setProveedor(ProveedorDao.getInstancia().getById(1));
		return p;
	}

	public SucursalE getSucursalDestno() {
		return sucursalDestno;
	}

	public void setSucursalDestno(SucursalE sucursalDestno) {
		this.sucursalDestno = sucursalDestno;
	}

	public boolean isTerciarizado() {
		return terciarizado;
	}

	public void setTerciarizado(boolean terciarizado) {
		this.terciarizado = terciarizado;
	}

	public ServicioSeguridadE getServicioSeguridad() {
		return servicioSeguridad;
	}

	public void setServicioSeguridad(ServicioSeguridadE servicioSeguridad) {
		this.servicioSeguridad = servicioSeguridad;
	}

	public ManifiestoE getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(ManifiestoE manifiesto) {
		this.manifiesto = manifiesto;
	}

	public RemitoE getRemito() {
		return remito;
	}

	public void setRemito(RemitoE remito) {
		this.remito = remito;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public List<EnvioE> getEnvios() {
		return envios;
	}

	public void setEnvios(List<EnvioE> envios) {
		this.envios = envios;
	}

	@Override
	public String toString() {
		return "Encomienda [cliente=" + cliente.getIdCliente() + ", tipoEncomienda=" + tipoEncomienda
				+ ", fechaCreacion=" + fechaCreacion
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", estado=" + estado + ", tercerizado=" + tercerizado
				+ ", largo=" + largo + ", alto=" + alto + ", ancho=" + ancho
				+ ", peso=" + peso + ", volumen=" + volumen + ", tratamiento="
				+ tratamiento + ", apilable=" + apilable + ", cantApilable="
				+ cantApilable + ", refrigerado=" + refrigerado
				+ ", condicionTransporte=" + condicionTransporte
				+ ", indicacionesManipulacion=" + indicacionesManipulacion
				+ ", fragilidad=" + fragilidad + ", nombreReceptor="
				+ nombreReceptor + ", apellidoReceptor=" + apellidoReceptor
				+ ", dniReceptor=" + dniReceptor + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel + ", productoEncomiendas="
				+ productoEncomiendas + ", terciarizado=" + terciarizado +""
						+ " internacional +" + internacional + "]";
	}

	public DTO_Encomienda toDTO() {
		DTO_Encomienda dto = new DTO_Encomienda();
		dto.setAlto(this.getAlto());
		dto.setAncho(this.getAncho());
		dto.setApellidoReceptor(this.getApellidoReceptor());
		dto.setApilable(this.getApilable());
		dto.setCantApilable(this.getCantApilable());
		dto.setCargaGranel(this.getCargaGranel());
		dto.setCondicionTransporte(this.getCondicionTransporte());
		dto.setTipoEncomienda(this.getTipoEncomienda());
		if(this.getFactura()!=null)
			dto.setFactura(this.getFactura().toDTO());
		
		dto.setDniReceptor(this.getDniReceptor());
		dto.setEstado(this.getEstado());
		dto.setFechaCreacion(this.getFechaCreacion());
		dto.setFragilidad(this.getFragilidad());
		dto.setIdEncomienda(this.getIdEncomienda());
		dto.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		dto.setInternacional(this.internacional);
		dto.setLargo(this.getLargo());
		if(this.getManifiesto()!=null)
			dto.setManifiesto(this.getManifiesto().toDTO());
		
		dto.setNombreReceptor(this.getNombreReceptor());
		dto.setPeso(this.getPeso());
		dto.setRefrigerado(this.refrigerado);
		dto.setSucursalActual(this.getSucursalActual().toDTO());
		dto.setSucursalDestino(this.getSucursalDestino().toDTO());
		dto.setSucursalOrigen(this.getSucursalOrigen().toDTO());
		dto.setTercerizada(this.tercerizado);
		dto.setTratamiento(this.getTratamiento());
		dto.setUnidadGranel(this.getUnidadGranel());
		dto.setVolumen(this.getVolumen());
		dto.setVolumenGranel(this.getVolumenGranel());
		dto.setCliente(this.getCliente().toDTO());
		return dto;
	}

	
	
}
