package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteParticular;
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
	
	public Carrier getByCuit(String cuit){
		try {
			  Query query = entityManager.createQuery("from Carrier where cuit =:cuit");
			  query.setParameter("cuit", cuit);
			  Carrier c = (Carrier) query.getSingleResult();
			  return c;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer proveedor por cuit");
	            return null;
	        }
	}
	
}
