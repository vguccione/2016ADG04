package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TareaMantenimientoRealizadaE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class TareaMantenimientoRealizadaDao extends GenericDao<TareaMantenimientoRealizadaE, Integer> {
	private static TareaMantenimientoRealizadaDao instancia;


	private TareaMantenimientoRealizadaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static TareaMantenimientoRealizadaDao getInstancia(){
		if(instancia == null){	
			instancia = new TareaMantenimientoRealizadaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<TareaMantenimientoRealizadaE> getByPatenteVehiculo(String filtro) {
		try{
			String f= filtro+"%";
			return entityManager
	                .createQuery("from TareaMantenimientoRealizadaE tr where "
	                		+ " tr.vehiculo.patente like :filtro")
	                .setParameter("filtro", f)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar tareas por vehiculo");
        }
        return null;
	}

}
