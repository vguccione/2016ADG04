package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class EnvioDao extends GenericDao<Envio, Integer> {

	private static EnvioDao instancia;


	private EnvioDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static EnvioDao getInstancia(){
		if(instancia == null){	
			instancia = new EnvioDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public Envio getByVehiculo(int idVehiculo){
		Envio e = (Envio) entityManager.createQuery("from Envio e where e.vehiculo=:idVehiculo")
										.setParameter("idVehiculo", idVehiculo)
										.getSingleResult();
		
		return e;
	}

	public Object getByVehiculoYSucursal(int idVehiculo, int idSucursalDestino) {
		Envio e = (Envio) entityManager.createQuery("from Envio e where e.vehiculo=:idVehiculo"
				+ " and e.sucursalDestino=:idSucursal").setParameter("idSucursal", idSucursalDestino)
				.setParameter("idVehiculo", idVehiculo)
				.getSingleResult();

return e;
	}
	

}
