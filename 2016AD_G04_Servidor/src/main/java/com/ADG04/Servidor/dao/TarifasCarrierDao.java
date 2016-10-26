package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TarifasCarrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class TarifasCarrierDao extends GenericDao<TarifasCarrier, Integer> {

	private static TarifasCarrierDao instancia;


	private TarifasCarrierDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static TarifasCarrierDao getInstancia(){
		if(instancia == null){	
			instancia = new TarifasCarrierDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public TarifasCarrier getByCuit(String cuit){
		try {
			  Query query = entityManager.createQuery("from Carrier where cuit =:cuit");
			  query.setParameter("cuit", cuit);
			  TarifasCarrier c = (TarifasCarrier) query.getSingleResult();
			  return c;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer proveedor por cuit");
	            return null;
	        }
	}
	
}
