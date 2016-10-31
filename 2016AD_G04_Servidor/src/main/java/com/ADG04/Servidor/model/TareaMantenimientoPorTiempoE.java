package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("t")  
public class TareaMantenimientoPorTiempoE extends TareaMantenimientoE implements java.io.Serializable {

	@Column(name = "CantidadDias")
	private int cantidadDias;

	public TareaMantenimientoPorTiempoE() {
		super();
	}

	public TareaMantenimientoPorTiempoE(PlanMantenimientoE planMantenimiento, String tarea) {
		super(planMantenimiento, tarea);
	}
	
	public int getCantidadDias() {
		return this.cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

}
