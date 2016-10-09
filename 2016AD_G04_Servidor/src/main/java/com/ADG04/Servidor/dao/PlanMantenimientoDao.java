package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.PlanMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimientoPorKm;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempo;
import com.ADG04.Servidor.model.TareaMantenimientoRealizada;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PlanMantenimientoDao extends GenericDao<PlanMantenimiento, Integer> {
	private static PlanMantenimientoDao instancia;


	private PlanMantenimientoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static PlanMantenimientoDao getInstancia(){
		if(instancia == null){	
			instancia = new PlanMantenimientoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public boolean tareaPerteneceAVehiculo(Integer idTareaMantenimiento, Integer idVehiculo) {
		// TODO Completar
		return true;
	}
	
	//Obtener las tareas que ya deberían haberse realizado, ya sea xq se pasa del tiempo o de la cantidad de km que tiene el vehiculo
	public List<TareaMantenimiento> getTareasVencidas(Integer idVehiculo){
		
		
		return null;
	}
	
	//Obtener las tareas que ya deberían haberse realizado, xq ya e paso el tiempo
	public List<TareaMantenimientoPorTiempo> getTareasVencidasPorTiempo(Integer idVehiculo){
		
		//TODO: se puede optimizar trayendo solamente las por tiempo directamente.	
		List<TareaMantenimiento> tareas = this.getPlanByIdVehiculo(idVehiculo).getTareaMantenimientos();
		
		//Me quedo con las tareas que son por tiempo
		List<TareaMantenimientoPorTiempo> tareasVencidas = new ArrayList<TareaMantenimientoPorTiempo>();
		
		//Por cada una de estas tareas, tengo que buscar cual fue la ultima vez que se realizo.
		for(TareaMantenimiento t:tareas){
			if(t.getClass().equals(TareaMantenimientoPorTiempo.class)){
				
				PlanMantenimiento plan = (PlanMantenimiento)entityManager.createQuery("select ts "
						+ " from PlanMantenimiento p"
						+ " join p.vehiculos v"
						+ " join v.tareasMantenimientoRealizadas ts"
						+ " where v.idVehiculo=:idVeh").setParameter("idVeh", idVehiculo)
						.getResultList();
						
				
			}
		}
				
		//
		
		return tareasVencidas;
	}	
	
	@SuppressWarnings("unchecked")
	public PlanMantenimiento getPlanByIdVehiculo(int idVehiculo) {
			
		PlanMantenimiento plan = (PlanMantenimiento)entityManager.createQuery("select p "
				+ " from PlanMantenimiento p"
				+ " join p.vehiculos v"
				+ " where v.idVehiculo=:idVeh").setParameter("idVeh", idVehiculo)
				.getSingleResult();
		
		//for(Object o :lista){
		
			//PlanMantenimiento plan = new PlanMantenimiento();
			//PlanMantenimiento plan = (PlanMantenimiento) o;
			//plan.setDescripcion(c.getDescripcion());
			//plan.setComentarios(c.getComentarios());
			//plan.setIdPlanMantenimiento(c.getIdPlanMantenimiento());
			
			//Busco las tareas de Mantenimiento
			List<Object> tareas = entityManager.createQuery("select ts"
					+ " from PlanMantenimiento p"
					+ " join p.tareaMantenimientos ts"
					+ " where p.idPlanMantenimiento=:idPlan").setParameter("idPlan", plan.getIdPlanMantenimiento())
					.getResultList();
									
			for(Object t :tareas){
				if(t.getClass().equals(TareaMantenimientoPorKm.class)){
					System.out.println("TareaMantenimientoPorKm - " + ((TareaMantenimientoPorKm)t).getTarea());
					plan.addTarea((TareaMantenimientoPorKm)t);
				}
				else{
					System.out.println("TareaMantenimientoPorTiempo - " + ((TareaMantenimientoPorTiempo)t).getTarea());
					plan.addTarea((TareaMantenimientoPorTiempo)t);
				}
				
			}
			
			//TareaMantenimientoPorKm tareaKm = (TareaMantenimientoPorKm) o[1];
			//TareaMantenimientoPorTiempo tareaTiempo = (TareaMantenimientoPorTiempo) o[2];
				
			
			//list.add(plan);
		//}
		
		return plan;
	}

}
