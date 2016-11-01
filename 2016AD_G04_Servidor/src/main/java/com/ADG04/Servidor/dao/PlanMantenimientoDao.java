package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.PlanMantenimientoE;
import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.model.TareaMantenimientoPorKmE;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempoE;
import com.ADG04.Servidor.model.TareaMantenimientoRealizadaE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class PlanMantenimientoDao extends GenericDao<PlanMantenimientoE, Integer> {
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
	
	//Obtener las tareas que ya deberían haberse realizado, xq ya e paso el tiempo
	@SuppressWarnings("unchecked")
	public List<TareaMantenimientoPorKmE> getTareasVencidasPorKm(Integer idVehiculo){
		
		//Me quedo con las tareas que son por tiempo
		List<TareaMantenimientoPorKmE> tareasVencidas = new ArrayList<TareaMantenimientoPorKmE>();
		
		//Por cada una de estas tareas, tengo que buscar cuando fue la ultima vez que se realizo.
		List<Object[]> lista = (List<Object[]>)entityManager.createQuery("select tt, v.kmRecorridos "
				+ " from PlanMantenimientoE p"
				+ " join p.tareaMantenimientos tt"
				+ " join p.vehiculos v"
				//+ " left outer join v.tareasMantenimientoRealizadas ts"
				+ " where v.idVehiculo=:idVeh").setParameter("idVeh", idVehiculo)
				.getResultList();
			
		for(Object[] o :lista){
			
			//Si la tarea es de kms, me tengo que fijar cuatos kms tenia la ultima vez que se hizo
			if(o[0].getClass().equals(TareaMantenimientoPorKmE.class)){
				
				TareaMantenimientoPorKmE tarea = (TareaMantenimientoPorKmE) o[0];
				System.out.println(tarea.getTarea() + " Cantidad de Kms: " + tarea.getCantidadKilometros());
													
				float kmRecorridos = (float)o[1];
				float frecuenciaKm = tarea.getCantidadKilometros();
				System.out.println("La tarea : " + tarea.getTarea() + " se debe hacer cada " + frecuenciaKm);
				System.out.println(". El Vehiculo ahora tiene " + kmRecorridos);

				boolean estaVencida = false;
				
				//Cuantos kms tenia el vehiculo la ultima vez que se realizó la tarea??
				
				//Tengo que fijarme cuando se realizó por última vez cada tarea
				List<TareaMantenimientoRealizadaE> tRealizadas = (List<TareaMantenimientoRealizadaE>)entityManager.createQuery("select tr "
						+ " from TareaMantenimientoRealizadaE tr"
						+ " where tr.tareaMantenimiento.idTareaMantenimiento=:idTarea")
						.setParameter("idTarea", tarea.getIdTareaMantenimiento())
						.getResultList(); 
				
				for(TareaMantenimientoRealizadaE tRealizada:tRealizadas){
				
					if(tRealizada != null){
						
						float kmCuandoSeRealizoTarea = tRealizada.getCantidadKilometros();
						System.out.println("La tarea se realizo cuando el Vehículo tenía " + kmCuandoSeRealizoTarea);
						//Si: (kmRecorridos - kmCuandoSeRealizoTarea) > frecuencia ----> esta vencida							
						float kmExcedidos = (kmRecorridos - kmCuandoSeRealizoTarea) - frecuenciaKm;
						if(kmExcedidos > 0){
							System.out.println("Tarea vencida, el vehículo está sobrepasado por " + kmExcedidos +" kms.");
							estaVencida = true;
							tareasVencidas.add(tarea);
						}
						else{
							System.out.println("Le quedan " + kmExcedidos + " para realizar la tarea.");
						}
					}
					else{
						estaVencida = true;
						tareasVencidas.add(tarea);
					}						
				}
				
				System.out.println("---------------------------");
			}
		}
			
		return tareasVencidas;
	}	

	
	//Obtener las tareas que ya deberían haberse realizado, xq ya e paso el tiempo
	@SuppressWarnings("unchecked")
	public List<TareaMantenimientoPorTiempoE> getTareasVencidasPorTiempo(Integer idVehiculo){
			
		//Me quedo con las tareas que son por tiempo
		List<TareaMantenimientoPorTiempoE> tareasVencidas = new ArrayList<TareaMantenimientoPorTiempoE>();

		List<Object[]> lista = (List<Object[]>)entityManager.createQuery("select tt, v.FechaIngreso "
				+ " from PlanMantenimientoE p"
				+ " join p.tareaMantenimientos tt"
				+ " join p.vehiculos v"
				//+ " left outer join v.tareasMantenimientoRealizadas ts"
				+ " where v.idVehiculo=:idVeh").setParameter("idVeh", idVehiculo)
				.getResultList();
		
		for(Object[] o :lista){
			
			//Si la tarea es de tiempo, me tengo que fijar cuanto paso de la ultima vez.
			if(o[0].getClass().equals(TareaMantenimientoPorTiempoE.class)){
				
				TareaMantenimientoPorTiempoE tarea = (TareaMantenimientoPorTiempoE) o[0];
				System.out.println(tarea.getTarea() + " Cantidad de días: " + tarea.getCantidadDias());
													
				Date fhIngreso = (Date)o[1];
			
				int cantDias = tarea.getCantidadDias();
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, (cantDias * -1));
				Date fechaIdealTareaRealizada = cal.getTime();
				System.out.println("fecha Ideal TareaRealizada: " + fechaIdealTareaRealizada.getYear()+"-"+fechaIdealTareaRealizada.getMonth()+"-"+fechaIdealTareaRealizada.getDay());
				System.out.println("Fecha ingreso del vehículo: " + fhIngreso);
				//Si el vehículo ingresó después de la fecha ideal de realizar la tarea, la misma no está vencida.
				boolean estaVencida = false;
				if(fechaIdealTareaRealizada.before(fhIngreso))
				{
					System.out.println("El vehículo ingresó después de la fecha en la cual tenía que hacerse mantenimiento");
				}else{
					
					System.out.println("Id tarea: " + tarea.getIdTareaMantenimiento());
					
					//Tengo que fijarme cuando se realizó por última vez esta tarea.
					List<TareaMantenimientoRealizadaE> tRealizadas = (List<TareaMantenimientoRealizadaE>)entityManager.createQuery("select tr "
							+ " from TareaMantenimientoRealizadaE tr"
							+ " where tr.tareaMantenimiento.idTareaMantenimiento=:idTarea")
							.setParameter("idTarea", tarea.getIdTareaMantenimiento())
							.getResultList();
				
					for(TareaMantenimientoRealizadaE tRealizada:tRealizadas){
						
						if(tRealizada != null){
							
							Calendar cal2 = Calendar.getInstance();
							cal2.setTime(tRealizada.getFechaRealizada());
							//Sumo la cantidad de días, si es mayor a la fecha de hoy, no esta vencida. Caso contrario, está vencida.
							cal2.add(Calendar.DATE, (cantDias));	 
							System.out.println("La tarea se realizo el día: " + tRealizada.getFechaRealizada());	
							if(cal2.getTime().before(new Date())){
								System.out.println("Tarea vencida, debería haberse realizado el " + fechaIdealTareaRealizada);
								estaVencida = true;
								tareasVencidas.add(tarea);
							}
						}
						else{
							estaVencida = true;
							tareasVencidas.add(tarea);
						}
					}	
				}
				
				System.out.println("---------------------------");
			}
		}
		
		return tareasVencidas;
	}	
		

	
	@SuppressWarnings("unchecked")
	public PlanMantenimientoE getPlanByIdVehiculo(int idVehiculo) {
			
		PlanMantenimientoE plan = (PlanMantenimientoE)entityManager.createQuery("select p "
				+ " from PlanMantenimientoE p"
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
			List<TareaMantenimientoE> tareas = (List<TareaMantenimientoE>)entityManager.createQuery("select ts"
					+ " from PlanMantenimientoE p"
					+ " join p.tareaMantenimientos ts"
					+ " where p.idPlanMantenimiento=:idPlan").setParameter("idPlan", plan.getIdPlanMantenimiento())
					.getResultList();
			
			plan.setTareaMantenimientos(tareas);
			
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
