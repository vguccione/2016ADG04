package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class VehiculoDao extends GenericDao<Vehiculo, Integer> {

	private static VehiculoDao instancia;


	private VehiculoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static VehiculoDao getInstancia(){
		if(instancia == null){	
			instancia = new VehiculoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public List<Vehiculo> listarVehiculosDisponibles(int idSucursal){
		@SuppressWarnings("unchecked")
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		@SuppressWarnings("unchecked")
		List<Integer> idsVehiculos =  entityManager.createQuery("Select tmr.vehiculo.idVehiculo "
															+ " from TareaMantenimientoRealizada tmr "
															+ " join tmr.tareaMantenimiento t"
															+ " where tmr.vehiculo.sucursal.idSucursal =:idSucursal"
															+ " group by tmr.vehiculo, t.planMantenimiento"
															+ " having count(*) >= (Select count(*) from "
															+ " TareaMantenimiento tm where tm.planMantenimiento ="
															+ " t.planMantenimiento)").setParameter("idSucursal", idSucursal)
												.getResultList();
		
		
		
		for(int id: idsVehiculos){
			Vehiculo v = this.getById(id);
			if(this.estaUtilizable(v)){
				vehiculos.add(v);
			}
		}
		return vehiculos;
	}
	
	public boolean estaUtilizable(Vehiculo v){
		String estado = (String) entityManager.createQuery("select estado from Vehiculo v"
								+ " where v.idVehiculo =:idVehiculo")
								.setParameter("idVehiculo", v.getIdVehiculo()).getSingleResult();
		if(estado == EnvioEstado.Pendiente.toString() || estado == "")
			return true;
		else
			return false;
	}
	

}
