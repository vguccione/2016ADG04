package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.ManifiestoE;
import com.ADG04.Servidor.util.EntityManagerProvider;



public class ManifiestoDao extends GenericDao<ManifiestoE, Integer> {

	private static ManifiestoDao instancia;


	private ManifiestoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ManifiestoDao getInstancia(){
		if(instancia == null){	
			instancia = new ManifiestoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
