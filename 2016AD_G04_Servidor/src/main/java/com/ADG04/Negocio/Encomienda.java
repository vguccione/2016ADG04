package com.ADG04.Negocio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.bean.Encomienda.DTO_Encomienda;


public class Encomienda implements java.io.Serializable {

	private int idEncomienda;
	private Direccion direccionDestino;
	private Sucursal sucursalDestno;
	private Sucursal sucursalOrigen;
	private Direccion direccionOrigen;
	private Sucursal sucursalActual;
	private Cliente cliente;
	private String tipoEncomienda;
	private Date fechaCreacion;
	private Date fechaEstimadaEntrega;
	private String estado;
	private boolean tercerizado;
	private float largo;
	private float alto;
	private float ancho;
	private float peso;
	private float volumen;
	private String tratamiento;
	private Boolean apilable;
	private Short cantApilable;
	private Boolean refrigerado;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private String fragilidad;
	private String nombreReceptor;
	private String apellidoReceptor;
	private String dniReceptor;
	private float volumenGranel;
	private String unidadGranel;
	private String cargaGranel;
	private List<ProductoEncomienda> productoEncomiendas;
	private boolean terciarizado;
	private ServicioSeguridad servicioSeguridad;
	private Manifiesto manifiesto;
	private Factura factura;
	private Remito remito;
	private boolean internacional;
	private List<Envio> envios;
	
	public Encomienda() {
	}

	public Encomienda(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
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

	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}

	public Seguro getSeguro() {
		Seguro p = new Seguro();
		p.setTarifa(123.0F);
		p.setTarifaPorKm(456.0F);
		//TODO: revisar
		//p.setProveedor(ProveedorDao.getInstancia().getById(1));
		p.setProveedor(new Proveedor(1));
		return p;
	}

	public Sucursal getSucursalDestno() {
		return sucursalDestno;
	}

	public void setSucursalDestno(Sucursal sucursalDestno) {
		this.sucursalDestno = sucursalDestno;
	}

	public boolean isTerciarizado() {
		return terciarizado;
	}

	public void setTerciarizado(boolean terciarizado) {
		this.terciarizado = terciarizado;
	}

	public ServicioSeguridad getServicioSeguridad() {
		return servicioSeguridad;
	}

	public void setServicioSeguridad(ServicioSeguridad servicioSeguridad) {
		this.servicioSeguridad = servicioSeguridad;
	}

	public Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
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
