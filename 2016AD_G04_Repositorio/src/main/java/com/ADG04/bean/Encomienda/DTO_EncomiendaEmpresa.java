package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class DTO_EncomiendaEmpresa implements Serializable{

	private int idEncomienda;
	private DTO_ItemFactura itemFactura;
	private DTO_Direccion direccionByIdDireccionDestino;
	private DTO_Sucursal sucursalByIdSucursalDestino;
	private DTO_Envio envio;
	private DTO_Sucursal sucursalByIdSucursalOrigen;
	private DTO_Direccion direccionByIdDireccionOrigen;
	private DTO_Sucursal sucursalByIdSucursalActual;
	private DTO_ClienteParticular cliente;
	private String tipoEncomienda;
	private Date fechaCreacion;
	private Date fechaEstimadaEntrega;
	private String estado;
	private boolean tercerizado;
	private Float largo;
	private Float alto;
	private Float ancho;
	private Float peso;
	private Float volumen;
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
	private Float volumenGranel;
	private String unidadGranel;
	private String cargaGranel;
	private List<DTO_Remito> remitos;
	private List<DTO_ProductoEncomienda> productoEncomiendas;

	public DTO_EncomiendaEmpresa() {
	}

	public int getIdEncomienda() {
		return this.idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public DTO_ItemFactura getItemFactura() {
		return this.itemFactura;
	}

	public void setItemFactura(DTO_ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}

	public DTO_Direccion getDireccionByIdDireccionDestino() {
		return this.direccionByIdDireccionDestino;
	}

	public void setDireccionByIdDireccionDestino(DTO_Direccion direccionByIdDireccionDestino) {
		this.direccionByIdDireccionDestino = direccionByIdDireccionDestino;
	}

	public DTO_Sucursal getSucursalByIdSucursalDestino() {
		return this.sucursalByIdSucursalDestino;
	}

	public void setSucursalByIdSucursalDestino(
			DTO_Sucursal sucursalByIdSucursalDestino) {
		this.sucursalByIdSucursalDestino = sucursalByIdSucursalDestino;
	}

	public DTO_Envio getEnvio() {
		return this.envio;
	}

	public void setEnvio(DTO_Envio envio) {
		this.envio = envio;
	}


	public DTO_Sucursal getSucursalByIdSucursalOrigen() {
		return this.sucursalByIdSucursalOrigen;
	}

	public void setSucursalByIdSucursalOrigen(
			DTO_Sucursal sucursalByIdSucursalOrigen) {
		this.sucursalByIdSucursalOrigen = sucursalByIdSucursalOrigen;
	}

	public DTO_Direccion getDireccionByIdDireccionOrigen() {
		return this.direccionByIdDireccionOrigen;
	}

	public void setDireccionByIdDireccionOrigen(
			DTO_Direccion direccionByIdDireccionOrigen) {
		this.direccionByIdDireccionOrigen = direccionByIdDireccionOrigen;
	}


	public DTO_Sucursal getSucursalByIdSucursalActual() {
		return this.sucursalByIdSucursalActual;
	}

	public void setSucursalByIdSucursalActual(
			DTO_Sucursal sucursalByIdSucursalActual) {
		this.sucursalByIdSucursalActual = sucursalByIdSucursalActual;
	}

	public DTO_ClienteParticular getCliente() {
		return this.cliente;
	}

	public void setCliente(DTO_ClienteParticular cliente) {
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

	public Float getLargo() {
		return this.largo;
	}

	public void setLargo(Float largo) {
		this.largo = largo;
	}

	public Float getAlto() {
		return this.alto;
	}

	public void setAlto(Float alto) {
		this.alto = alto;
	}

	public Float getAncho() {
		return this.ancho;
	}

	public void setAncho(Float ancho) {
		this.ancho = ancho;
	}

	public Float getPeso() {
		return this.peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getVolumen() {
		return this.volumen;
	}

	public void setVolumen(Float volumen) {
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

	public Float getVolumenGranel() {
		return this.volumenGranel;
	}

	public void setVolumenGranel(Float volumenGranel) {
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

	public List<DTO_Remito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<DTO_Remito> remitos) {
		this.remitos = remitos;
	}

	public List<DTO_ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<DTO_ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}


}
