package com.ADG04.bean.Vehiculo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_PlanMantenimiento  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descripcion;
	private float tolerancia;
	private String comentarios;
	private List<DTO_TareaMantenimiento> tareasMantenimiento;
	
	public DTO_PlanMantenimiento(){
		tareasMantenimiento = new ArrayList<DTO_TareaMantenimiento>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTolerancia() {
		return tolerancia;
	}

	public void setTolerancia(float tolerancia) {
		this.tolerancia = tolerancia;
	}

	public List<DTO_TareaMantenimiento> getTareasMantenimiento() {
		return tareasMantenimiento;
	}

	public void setTareasMantenimiento(
			List<DTO_TareaMantenimiento> tareasMantenimiento) {
		this.tareasMantenimiento = tareasMantenimiento;
	}

	public void addTarea(DTO_TareaMantenimiento tarea){
		if(this.tareasMantenimiento == null){
			this.tareasMantenimiento = new ArrayList<DTO_TareaMantenimiento>();
		}
		
		this.tareasMantenimiento.add(tarea);
	}
}
