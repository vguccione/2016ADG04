package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ServicioSeguridadDao extends GenericDao<ServicioSeguridad, Integer> {

	private static ServicioSeguridadDao instancia;


	private ServicioSeguridadDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ServicioSeguridadDao getInstancia(){
		if(instancia == null){	
			instancia = new ServicioSeguridadDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
}
