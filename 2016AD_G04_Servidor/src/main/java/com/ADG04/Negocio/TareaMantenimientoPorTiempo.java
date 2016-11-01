package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

public class TareaMantenimientoPorTiempo extends TareaMantenimiento implements java.io.Serializable {

	private int cantidadDias;

	public TareaMantenimientoPorTiempo() {
		super();
	}

	public TareaMantenimientoPorTiempo(PlanMantenimiento planMantenimiento, String tarea) {
		super(planMantenimiento, tarea);
	}
	
	public int getCantidadDias() {
		return this.cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

}
