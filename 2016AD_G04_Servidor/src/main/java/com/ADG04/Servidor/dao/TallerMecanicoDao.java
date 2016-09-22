package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.TallerMecanico;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class TallerMecanicoDao extends GenericDao<TallerMecanico, Integer> {

	private static TallerMecanicoDao instancia;


	private TallerMecanicoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static TallerMecanicoDao getInstancia(){
		if(instancia == null){	
			instancia = new TallerMecanicoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
}
