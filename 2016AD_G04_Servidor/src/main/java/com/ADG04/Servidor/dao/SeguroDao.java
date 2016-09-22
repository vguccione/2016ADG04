package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class SeguroDao extends GenericDao<Seguro, Integer> {

	private static SeguroDao instancia;


	private SeguroDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static SeguroDao getInstancia(){
		if(instancia == null){	
			instancia = new SeguroDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
}
