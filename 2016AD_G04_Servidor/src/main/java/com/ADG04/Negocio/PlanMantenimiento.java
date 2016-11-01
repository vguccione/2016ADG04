package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;

public class PlanMantenimiento{
 
	private int idPlanMantenimiento;
	private String descripcion;
	private String comentarios;
	private List<Vehiculo> vehiculos;
	private List<TareaMantenimiento> tareaMantenimientos;

	public PlanMantenimiento() {
	}

	public PlanMantenimiento(String descripcion,String comentarios) {
		this.descripcion = descripcion;
		this.comentarios = comentarios;
	}


	public int getIdPlanMantenimiento() {
		return this.idPlanMantenimiento;
	}

	public void setIdPlanMantenimiento(int idPlanMantenimiento) {
		this.idPlanMantenimiento = idPlanMantenimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<TareaMantenimiento> getTareaMantenimientos() {
		return tareaMantenimientos;
	}

	public void setTareaMantenimientos(List<TareaMantenimiento> tareaMantenimientos) {
		this.tareaMantenimientos = tareaMantenimientos;
	}

	public void addTarea(TareaMantenimiento tarea){
		
		if(this.tareaMantenimientos == null)
			this.tareaMantenimientos = new ArrayList<TareaMantenimiento>();
		
		this.tareaMantenimientos.add(tarea);
	}

	public DTO_PlanMantenimiento toDTO() {
		DTO_PlanMantenimiento dto = new DTO_PlanMantenimiento();
		dto.setId(this.getIdPlanMantenimiento());
		dto.setComentarios(this.getComentarios());
		dto.setDescripcion(this.getDescripcion());
		return dto;
	}
}
