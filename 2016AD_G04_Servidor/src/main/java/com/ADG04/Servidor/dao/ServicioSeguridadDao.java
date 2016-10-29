package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TarifasCarrier;
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
	
	@SuppressWarnings("unchecked")
	public List<ServicioSeguridad> getServiciosSeguridadByProveedor(String filtro) {
		try {
			  String f = filtro + '%';
			  Query query = entityManager.createQuery("from ServicioSeguridad s where s.proveedor.razonSocial like :filtro");
			  query.setParameter("filtro", f);
			  return query.getResultList();
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer servicios seguridad por proveedor");
	            return null;
	        }
	}
	
}
