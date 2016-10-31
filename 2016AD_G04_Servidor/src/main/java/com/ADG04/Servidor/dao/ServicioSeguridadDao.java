package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ServicioSeguridadDao extends GenericDao<ServicioSeguridadE, Integer> {

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
	public List<ServicioSeguridadE> getServiciosSeguridadByProveedor(String filtro) {
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
