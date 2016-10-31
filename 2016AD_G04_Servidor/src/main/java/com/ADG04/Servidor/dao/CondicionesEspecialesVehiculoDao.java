package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.CondicionesEspecialesVehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CondicionesEspecialesVehiculoDao extends GenericDao<CondicionesEspecialesVehiculoE, Integer> {

	private static CondicionesEspecialesVehiculoDao instancia;


	private CondicionesEspecialesVehiculoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static CondicionesEspecialesVehiculoDao getInstancia(){
		if(instancia == null){	
			instancia = new CondicionesEspecialesVehiculoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
