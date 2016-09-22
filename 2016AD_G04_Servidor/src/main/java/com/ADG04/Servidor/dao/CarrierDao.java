package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class CarrierDao extends GenericDao<Carrier, Integer> {

	private static CarrierDao instancia;


	private CarrierDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static CarrierDao getInstancia(){
		if(instancia == null){	
			instancia = new CarrierDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
}
