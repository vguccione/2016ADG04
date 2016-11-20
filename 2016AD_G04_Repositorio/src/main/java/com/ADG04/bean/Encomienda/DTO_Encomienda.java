package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class DTO_Encomienda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idEncomienda;
	private int idCarrier;
	private DTO_ItemFactura itemFactura;
	private DTO_Direccion direccionOrigen;
	private DTO_Direccion direccionDestino;
	private List<DTO_Envio> envios;
	
	private DTO_Cliente cliente;
	
	private DTO_Sucursal sucursalOrigen;
	private DTO_Sucursal sucursalActual;
	private DTO_Sucursal sucursalDestino;
	
	private Date fechaCreacion;
	private Date fechaEstimadaEntrega;
	private String estado;
	private String tipoEncomienda;

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
	private DTO_Remito remito;
	private DTO_Manifiesto manifiesto;
	private DTO_Factura factura;
	private boolean tercerizada;
	private boolean internacional;
	private int idServicioSeguridad;

			
	public DTO_Encomienda() {
		super();
		envios = new ArrayList<DTO_Envio>();
	}
	
	
	
	public List<DTO_Envio> getEnvios() {
		return envios;
	}



	public void setEnvios(List<DTO_Envio> envios) {
		this.envios = envios;
	}



	public int getIdServicioSeguridad() {
		return idServicioSeguridad;
	}



	public void setIdServicioSeguridad(int idServicioSeguridad) {
		this.idServicioSeguridad = idServicioSeguridad;
	}



	public int getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public DTO_ItemFactura getItemFactura() {
		return itemFactura;
	}
	public void setItemFactura(DTO_ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}
	public DTO_Direccion getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(DTO_Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public DTO_Direccion getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(DTO_Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	
	public DTO_Sucursal getSucursalActual() {
		return sucursalActual;
	}
	public void setSucursalActual(DTO_Sucursal sucursalActual) {
		this.sucursalActual = sucursalActual;
	}
	public DTO_Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}
	public void setSucursalOrigen(DTO_Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}
	public DTO_Sucursal getSucursalDestino() {
		return sucursalDestino;
	}
	public void setSucursalDestino(DTO_Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}
	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
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
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Boolean getApilable() {
		return apilable;
	}
	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}
	public Short getCantApilable() {
		return cantApilable;
	}
	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
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
	public String getIndicacionesManipulacion() {
		return indicacionesManipulacion;
	}
	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}
	public String getFragilidad() {
		return fragilidad;
	}
	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}
	public String getNombreReceptor() {
		return nombreReceptor;
	}
	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}
	public String getApellidoReceptor() {
		return apellidoReceptor;
	}
	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}
	public String getDniReceptor() {
		return dniReceptor;
	}
	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}
	public float getVolumenGranel() {
		return volumenGranel;
	}
	public void setVolumenGranel(float volumenGranel) {
		this.volumenGranel = volumenGranel;
	}
	public String getUnidadGranel() {
		return unidadGranel;
	}
	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}
	public String getCargaGranel() {
		return cargaGranel;
	}
	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}
	public DTO_Remito getRemito() {
		return remito;
	}
	public void setRemito(DTO_Remito remito) {
		this.remito = remito;
	}
	public DTO_Manifiesto getManifiesto() {
		return manifiesto;
	}
	public void setManifiesto(DTO_Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}
	public DTO_Factura getFactura() {
		return factura;
	}
	public void setFactura(DTO_Factura factura) {
		this.factura = factura;
	}
	public boolean isTercerizada() {
		return tercerizada;
	}
	public void setTercerizada(boolean tercerizada) {
		this.tercerizada = tercerizada;
	}
	public boolean isInternacional() {
		return internacional;
	}
	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}
	public DTO_Cliente getCliente() {
		return cliente;
	}
	public void setCliente(DTO_Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTipoEncomienda() {
		return tipoEncomienda;
	}
	public void setTipoEncomienda(String tipoEncomienda) {
		this.tipoEncomienda = tipoEncomienda;
	}

	public int getIdCarrier() {
		return idCarrier;
	}

	public void setIdCarrier(int idCarrier) {
		this.idCarrier = idCarrier;
	}

	public void addEnvio(DTO_Envio e) {
		if(this.envios == null)
			this.envios = new ArrayList<DTO_Envio>();
			
		this.envios.add(e);
	}
	

	
}
