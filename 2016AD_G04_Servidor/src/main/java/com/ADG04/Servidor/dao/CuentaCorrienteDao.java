package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.CuentaCorrienteE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CuentaCorrienteDao extends GenericDao<CuentaCorrienteE, Integer> {

	
	private static CuentaCorrienteDao instancia;


	private CuentaCorrienteDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static CuentaCorrienteDao getInstancia(){
		if(instancia == null){	
			instancia = new CuentaCorrienteDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
