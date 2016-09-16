package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteDao extends GenericDao<Cliente, Integer> {

	private static ClienteDao instancia;


	private ClienteDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ClienteDao getInstancia(){
		if(instancia == null){	
			instancia = new ClienteDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
}
