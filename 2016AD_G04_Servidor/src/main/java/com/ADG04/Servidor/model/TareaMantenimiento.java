package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TareaMantenimiento")
public class TareaMantenimiento implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdTareaMantenimiento", unique = true, nullable = false)
	private int idTareaMantenimiento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPlanMantenimiento", nullable = false)
	private PlanMantenimiento planMantenimiento;

	@Column(name = "Tarea", nullable = false)
	private String tarea;

	@Column(name = "CantidadKilometros", precision = 53, scale = 0)
	private Double cantidadKilometros;

	@Column(name = "CantidadDias", precision = 53, scale = 0)
	private Double cantidadDias;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tareaMantenimiento")
	private List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas;

	public TareaMantenimiento() {
	}

	public TareaMantenimiento(PlanMantenimiento planMantenimiento, String tarea) {
		this.planMantenimiento = planMantenimiento;
		this.tarea = tarea;
	}
	
	public int getIdTareaMantenimiento() {
		return this.idTareaMantenimiento;
	}

	public void setIdTareaMantenimiento(int idTareaMantenimiento) {
		this.idTareaMantenimiento = idTareaMantenimiento;
	}


	public PlanMantenimiento getPlanMantenimiento() {
		return this.planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}


	public String getTarea() {
		return this.tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Double getCantidadKilometros() {
		return this.cantidadKilometros;
	}

	public void setCantidadKilometros(Double cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}


	public Double getCantidadDias() {
		return this.cantidadDias;
	}

	public void setCantidadDias(Double cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public List<TareaMantenimientoRealizada> getTareasMantenimientoRealizadas() {
		return tareasMantenimientoRealizadas;
	}

	public void setTareasMantenimientoRealizadas(
			List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas) {
		this.tareasMantenimientoRealizadas = tareasMantenimientoRealizadas;
	}

}
