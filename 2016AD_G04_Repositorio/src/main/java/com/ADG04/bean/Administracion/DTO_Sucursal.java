package com.ADG04.bean.Administracion;

import java.io.Serializable;
/*import java.util.ArrayList;
import java.util.List;

import dto.Encomienda.DTO_Envio;
import dto.Vehiculo.DTO_Vehiculo;*/

public class DTO_Sucursal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descripcion;
	private DTO_Direccion direccion;
	private String telefono;
	private Integer idGerente; 
	
	/*private List<DTO_Empleado> empleados;
	private List<DTO_Destino> destinos;
	private List<DTO_Stock> stocks;
	private List<DTO_Vehiculo> vehiculos;
	private List<DTO_Envio> envios;*/

	public DTO_Sucursal(){
		/*empleados = new ArrayList<DTO_Empleado>();
		destinos = new ArrayList<DTO_Destino>();
		stocks = new ArrayList<DTO_Stock>();
		vehiculos = new ArrayList<DTO_Vehiculo>();
		envios = new ArrayList<DTO_Envio>();*/
	}

	public DTO_Sucursal(int idSucursal) {
		this.id = idSucursal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public DTO_Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(DTO_Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

	/*public List<DTO_Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<DTO_Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<DTO_Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<DTO_Destino> destinos) {
		this.destinos = destinos;
	}

	public List<DTO_Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<DTO_Stock> stocks) {
		this.stocks = stocks;
	}

	public List<DTO_Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<DTO_Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<DTO_Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<DTO_Envio> envios) {
		this.envios = envios;
	}*/

}
