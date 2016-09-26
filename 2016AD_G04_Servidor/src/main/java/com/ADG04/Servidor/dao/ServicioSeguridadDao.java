package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Seguro;
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
	
	public ServicioSeguridad getByCuit(String cuit){
		try {
			  Query query = entityManager.createQuery("from ServicioSeguridad where cuit =:cuit");
			  query.setParameter("cuit", cuit);
			  ServicioSeguridad ss = (ServicioSeguridad) query.getSingleResult();
			  return ss;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer proveedor por cuit");
	            return null;
	        }
	}
	
}
