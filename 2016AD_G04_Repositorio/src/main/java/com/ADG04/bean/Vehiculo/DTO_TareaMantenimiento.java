package com.ADG04.bean.Vehiculo;

import java.io.Serializable;

public abstract class DTO_TareaMantenimiento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tarea;
	private String tipo;
	private Integer idPlanMantenimiento;

	public DTO_TareaMantenimiento(){
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIdPlanMantenimiento() {
		return idPlanMantenimiento;
	}

	public void setIdPlanMantenimiento(Integer idPlanMantenimiento) {
		this.idPlanMantenimiento = idPlanMantenimiento;
	}
}
