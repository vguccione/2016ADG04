package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class TareaMantenimientoDao extends GenericDao<TareaMantenimientoE, Integer> {


	private static TareaMantenimientoDao instancia;


	private TareaMantenimientoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static TareaMantenimientoDao getInstancia(){
		if(instancia == null){	
			instancia = new TareaMantenimientoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
