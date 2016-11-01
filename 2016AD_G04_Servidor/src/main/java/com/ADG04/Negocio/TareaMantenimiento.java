package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
















import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
    

public abstract class TareaMantenimiento{

	private int idTareaMantenimiento;
	private PlanMantenimiento planMantenimiento;
	private String tarea;
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

	public List<TareaMantenimientoRealizada> getTareasMantenimientoRealizadas() {
		return tareasMantenimientoRealizadas;
	}

	public void setTareasMantenimientoRealizadas(
			List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas) {
		this.tareasMantenimientoRealizadas = tareasMantenimientoRealizadas;
	}

	public DTO_TareaMantenimiento toDTO() {
		DTO_TareaMantenimiento dto = new DTO_TareaMantenimiento();
		dto.setId(this.getIdTareaMantenimiento());
		dto.setIdPlanMantenimiento(this.getPlanMantenimiento().getIdPlanMantenimiento());
		dto.setTarea(this.getTarea());
		return dto;
	}

}
