package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.ServicioSeguridad;
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
	
	public TallerMecanico getByCuit(String cuit){
		try {
			  Query query = entityManager.createQuery("from TallerMecanico where cuit =:cuit");
			  query.setParameter("cuit", cuit);
			  TallerMecanico tm = (TallerMecanico) query.getSingleResult();
			  return tm;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer proveedor por cuit");
	            return null;
	        }
	}

	
}
