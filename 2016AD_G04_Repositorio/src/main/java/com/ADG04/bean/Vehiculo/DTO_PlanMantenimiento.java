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
	private List<DTO_TareasPorKilometro> tareasPorKM;
	private List<DTO_TareasPorTiempo> tareasPorTiempo;
	
	public DTO_PlanMantenimiento(){
		tareasPorKM = new ArrayList<DTO_TareasPorKilometro>();
		tareasPorTiempo = new ArrayList<DTO_TareasPorTiempo>();
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

	public List<DTO_TareasPorKilometro> getTareasPorKM() {
		return tareasPorKM;
	}

	public void setTareasPorKM(List<DTO_TareasPorKilometro> tareasPorKM) {
		this.tareasPorKM = tareasPorKM;
	}

	public List<DTO_TareasPorTiempo> getTareasPorTiempo() {
		return tareasPorTiempo;
	}

	public void setTareasPorTiempo(List<DTO_TareasPorTiempo> tareasPorTiempo) {
		this.tareasPorTiempo = tareasPorTiempo;
	}

	public void addTarea(DTO_TareasPorKilometro tareaPorKm){
		this.tareasPorKM.add(tareaPorKm);
	}
	
	public void addTarea(DTO_TareasPorTiempo tareaPorTiempo){
		this.tareasPorTiempo.add(tareaPorTiempo);
	}
}
