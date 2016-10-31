package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import com.ADG04.Servidor.model.ItemRemitoE;
import com.ADG04.Servidor.util.EntityManagerProvider;



public class ItemRemitoDao extends GenericDao<ItemRemitoE, Integer> {

	private static ItemRemitoDao instancia;


	private ItemRemitoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ItemRemitoDao getInstancia(){
		if(instancia == null){	
			instancia = new ItemRemitoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
