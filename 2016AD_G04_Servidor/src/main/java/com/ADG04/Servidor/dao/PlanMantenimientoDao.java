package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.PlanMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimientoPorKm;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempo;
import com.ADG04.Servidor.model.TareaMantenimientoRealizada;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		//List<TareaMantenimiento> tareas = this.getPlanByIdVehiculo(idVehiculo).getTareaMantenimientos();
		
		//Me quedo con las tareas que son por tiempo
		List<TareaMantenimientoPorTiempo> tareasVencidas = new ArrayList<TareaMantenimientoPorTiempo>();
		
		//Por cada una de estas tareas, tengo que buscar cuando fue la ultima vez que se realizo.
		//for(TareaMantenimiento t:tareas){
			//if(t.getClass().equals(TareaMantenimientoPorTiempo.class)){
				//Tareas, TareasRealizadas, Vehiculo
				List<Object[]> lista = (List<Object[]>)entityManager.createQuery("select tt, v.FechaIngreso "
						+ " from PlanMantenimiento p"
						+ " join p.tareaMantenimientos tt"
						+ " join p.vehiculos v"
						//+ " left outer join v.tareasMantenimientoRealizadas ts"
						+ " where v.idVehiculo=:idVeh").setParameter("idVeh", idVehiculo)
						.getResultList();
				
				for(Object[] o :lista){
					
					//Si la tarea es de tiempo, me tengo que fijar cuanto paso de la ultima vez.
					if(o[0].getClass().equals(TareaMantenimientoPorTiempo.class)){
						
						TareaMantenimientoPorTiempo tarea = (TareaMantenimientoPorTiempo) o[0];
						System.out.println(tarea.getTarea() + " Cantidad de días: " + tarea.getCantidadDias());
															
						Date fhIngreso = (Date)o[1];
					
						int cantDias = tarea.getCantidadDias();
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, (cantDias * -1));
						Date fechaIdealTareaRealizada = cal.getTime();
						//System.out.println("fecha Ideal TareaRealizada: " + fechaIdealTareaRealizada);
						//System.out.println("Fecha ingreso del vehículo: " + fhIngreso);
						//Si el vehículo ingresó después de la fecha ideal de realizar la tarea, la misma no está vencida.
						boolean estaVencida = false;
						if(fechaIdealTareaRealizada.before(fhIngreso))
						{
							System.out.println("El vehículo ingresó después de la fecha en la cual tenía que hacerse mantenimiento");
						}else{
							
							System.out.println("Id tarea: " + tarea.getIdTareaMantenimiento());
							
							//Tengo que fijarme cuando se realizó por última vez esta tarea.
							TareaMantenimientoRealizada tRealizada = (TareaMantenimientoRealizada)entityManager.createQuery("select tr "
									+ " from TareaMantenimientoRealizada tr"
									+ " where tr.tareaMantenimiento.idTareaMantenimiento=:idTarea")
									.setParameter("idTarea", tarea.getIdTareaMantenimiento())
									.getSingleResult();
							
							if(tRealizada != null){
								
								Calendar cal2 = Calendar.getInstance();
								cal2.setTime(tRealizada.getFechaRealizada());
								//Sumo la cantidad de días, si es mayor a la fecha de hoy, no esta vencida. Caso contrario, está vencida.
								cal2.add(Calendar.DATE, (cantDias));	 
								
								if(cal2.getTime().before(new Date())){
									System.out.println("Tarea vencida, debería haberse realizado el " + fechaIdealTareaRealizada);
									estaVencida = true;
								}
							}
							else{
								estaVencida = true;
							}
							
						}
						
						System.out.println("---------------------------");
					}
					//list.add(cjdto);
				}
				//return list;
				
				//for(TareaMantenimiento t:plan.getTareaMantenimientos()){
					
				//}
			//}
	//	}
				
		//De las tareas del plan, tengo que ver cuales corresponde realizar.
		
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
									
			//System.out.println("Aca tenemos " + tareas.size() + " tareas");
			/*
			for(Object t :tareas){
				if(t.getClass().equals(TareaMantenimientoPorKm.class)){
					System.out.println("TareaMantenimientoPorKm - " + ((TareaMantenimientoPorKm)t).getTarea());
					plan.addTarea((TareaMantenimientoPorKm)t);
				}
				else{
					System.out.println("TareaMantenimientoPorTiempo - " + ((TareaMantenimientoPorTiempo)t).getTarea());
					plan.addTarea((TareaMantenimientoPorTiempo)t);
				}
				
			}*/
			
			//System.out.println("El plan tiene " + plan.getTareaMantenimientos().size() + " tareas");
			
		return plan;
	}

}
