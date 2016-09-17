package com.ADG04.bean.Vehiculo;

import java.io.Serializable;
import java.util.Date;

public class DTO_TareaMantenimientoRealizada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idTareaMantenimiento;
	private Integer idVehiculo;
	private Date fecha;
	private float cantidadKilometros;
	private Integer idProveedor;
	
	public DTO_TareaMantenimientoRealizada(){
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getIdTareaMantenimiento() {
		return idTareaMantenimiento;
	}

	public void setIdTareaMantenimiento(Integer idTareaMantenimiento) {
		this.idTareaMantenimiento = idTareaMantenimiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCantidadKilometros() {
		return cantidadKilometros;
	}

	public void setCantidadKilometros(float cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
}
