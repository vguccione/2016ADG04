package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

public class TareaMantenimientoPorKm extends TareaMantenimiento implements java.io.Serializable {

	private float cantidadKilometros;

	public TareaMantenimientoPorKm() {
		super();
	}

	public TareaMantenimientoPorKm(PlanMantenimiento planMantenimiento, String tarea) {
		super(planMantenimiento, tarea);
	}

	public float getCantidadKilometros() {
		return this.cantidadKilometros;
	}

	public void setCantidadKilometros(float cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}

}
