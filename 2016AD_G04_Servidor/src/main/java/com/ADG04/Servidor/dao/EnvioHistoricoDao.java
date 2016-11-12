package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.EnvioHistoricoE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EnvioHistoricoDao extends GenericDao<EnvioHistoricoE, Integer> {

	private static EnvioHistoricoDao instancia;


	private EnvioHistoricoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static EnvioHistoricoDao getInstancia(){
		if(instancia == null){	
			instancia = new EnvioHistoricoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<EnvioHistoricoE> getAllOrderByFechaASC(int id) {
		try {
			  
			  Query query = entityManager.createQuery("from EnvioHistoricoE eh where envio.idEnvio=:id");
			  query.setParameter("id", id);
			  return query.getResultList();
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error al buscar historico");
	            return null;
	        }
	}
	

}
