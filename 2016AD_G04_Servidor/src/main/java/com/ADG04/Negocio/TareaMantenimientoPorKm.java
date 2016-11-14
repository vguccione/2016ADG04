package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.TareaMantenimientoDao;
import com.ADG04.Servidor.model.TareaMantenimientoPorKmE;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

public class TareaMantenimientoPorKm extends TareaMantenimiento{

	private float cantidadKilometros;

	public TareaMantenimientoPorKm() {
		super();
	}

	public TareaMantenimientoPorKm(PlanMantenimiento planMantenimiento, String tarea) {
		super(planMantenimiento, tarea);
	}

	public TareaMantenimientoPorKm(PlanMantenimiento pm, String tarea,
			float cant) {
		super(pm, tarea);
		this.cantidadKilometros=cant;
	}

	public float getCantidadKilometros() {
		return this.cantidadKilometros;
	}

	public void setCantidadKilometros(float cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		TareaMantenimientoDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}

	public TareaMantenimientoPorKmE toEntity(){
		TareaMantenimientoPorKmE tt = new TareaMantenimientoPorKmE();
		tt.setCantidadKilometros(cantidadKilometros);
		if(this.getIdTareaMantenimiento()!=0)
			tt.setIdTareaMantenimiento(this.getIdTareaMantenimiento());
		tt.setPlanMantenimiento(PlanMantenimientoDao.getInstancia().getById(this.getPlanMantenimiento().getIdPlanMantenimiento()));
		tt.setTarea(this.getTarea());
		
		return tt;
	}
}
