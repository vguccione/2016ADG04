package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Negocio.GestionVehiculo;
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
	
	
	public long getEstadoAsignacion(Vehiculo v) {

		long asignado = 0;
		asignado = (long) entityManager.createQuery("select count(*) from Envio e "
				+ " where e.vehiculo.idVehiculo =:idVehiculo"
				+ " and e.estado!=:pendiente")
				.setParameter("idVehiculo", v.getIdVehiculo())
				.setParameter("pendiente", EnvioEstado.Pendiente.toString())
				.getSingleResult();

		return asignado;
	}
/*
	@SuppressWarnings("unchecked")
	public List<Vehiculo> listarVehiculosEnvios2(int idSucursalDestino, float peso, float volumen) {
		
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		List<Integer> idsVehiculos =  entityManager.createQuery("Select e.vehiculo.idVehiculo"
				+ " from Envio e"
				+ " where e.sucursalDestino.idSucursal=:idSucursalDestino"
				+ " group by e.vehiculo.idVehiculo")
				.setParameter("idSucursalDestino", idSucursalDestino)
				.getResultList();
		
		
		
		for(int id: idsVehiculos){
			Vehiculo v = this.getById(id);
			if(new GestionVehiculo(v).estaUtilizable()){
				vehiculos.add(v);
			}
		}
		return vehiculos;
	}*/

	@SuppressWarnings("unchecked")
	/**
	 * Busca vehículos que se estén disponibles en la sucursal indicada, que puedan cargar el peso y el volumen indicado.
	 * */
	public List<Vehiculo> getPorVolumenPesoSucursalTareasRealizadas(int idSucursal, float peso, float volumen) {
			
		return (List<Vehiculo>)entityManager.createQuery("Select tmr.vehiculo "
				+ " from TareaMantenimientoRealizada tmr "
				+ " join tmr.tareaMantenimiento t"
				+ " where tmr.vehiculo.sucursal.idSucursal =:idSucursal "
				+ " and tmr.vehiculo.volumen >= :volumen and (tmr.vehiculo.peso - tmr.vehiculo.tara) >= :peso"
				+ " group by tmr.vehiculo, t.planMantenimiento"
				+ " having count(*) >= (Select count(*) from "
				+ " TareaMantenimiento tm where tm.planMantenimiento ="
				+ " t.planMantenimiento)").setParameter("idSucursal", idSucursal)
				.setParameter("volumen", volumen).setParameter("peso", peso)
				.getResultList();

	}

	public List<Vehiculo> getVehiculosByModelMarcaPatente(String filtro) {
		try{
			String f= filtro+"%";
			return entityManager
	                .createQuery("from Vehiculo v where (modelo like :filtro OR marca like :filtro OR patente like :filtro)")
	                .setParameter("filtro", f)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar vehiculos por modelo, marca o patente");
        }
        return null;
	}


}
