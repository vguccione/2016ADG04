package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.ItemManifiesto;
import com.ADG04.Servidor.util.EntityManagerProvider;



public class ItemManifiestoDao extends GenericDao<ItemManifiesto, Integer> {

	private static ItemManifiestoDao instancia;


	private ItemManifiestoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ItemManifiestoDao getInstancia(){
		if(instancia == null){	
			instancia = new ItemManifiestoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
