package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.TareaMantenimientoDao;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

public class TareaMantenimientoPorTiempo extends TareaMantenimiento{

	private int cantidadDias;

	public TareaMantenimientoPorTiempo() {
		super();
	}

	public TareaMantenimientoPorTiempo(PlanMantenimiento planMantenimiento, String tarea) {
		super(planMantenimiento, tarea);
	}
	
	public TareaMantenimientoPorTiempo(PlanMantenimiento pm, String tarea,
			int cant) {
		super(pm, tarea);
		this.cantidadDias=cant;
	}

	public int getCantidadDias() {
		return this.cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
	
	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		TareaMantenimientoDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}
	
	public TareaMantenimientoPorTiempoE toEntity(){
		TareaMantenimientoPorTiempoE tt = new TareaMantenimientoPorTiempoE();
		tt.setCantidadDias(cantidadDias);
		if(this.getIdTareaMantenimiento()!=0)
			tt.setIdTareaMantenimiento(this.getIdTareaMantenimiento());
		tt.setPlanMantenimiento(PlanMantenimientoDao.getInstancia().getById(this.getPlanMantenimiento().getIdPlanMantenimiento()));
		tt.setTarea(this.getTarea());
		
		return tt;
	}
	
	

}
