package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class SucursalDao extends GenericDao<SucursalE, Integer> {

	private static SucursalDao instancia;


	private SucursalDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static SucursalDao getInstancia(){
		if(instancia == null){	
			instancia = new SucursalDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<SucursalE> getSucursalesByNombre(String filtro) {
		try {
			  String f = filtro+'%';
			  Query query = entityManager.createQuery("from SucursalE where (descripcion like :filtro ) ");
			  query.setParameter("filtro", f);
			  return query.getResultList();
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error al buscar sucursales");
	            return null;
	        }
	}

	public boolean tieneEncomiendas(Integer id) {
		try{
			List<EncomiendaE> encomiendas= 	entityManager
	                .createQuery("from EncomiendaE e where sucursalOrigen.idSucursal=:id OR"
	                		+ " sucursalDestino.idSucursal=:id OR sucursalActual.idSucursal=:id")
	                .setParameter("id", id)
	                .getResultList();
			if(encomiendas.size()>0)
				return true;
			else
				return false;
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: obtener encomiendas");
        }
		return false;
	}

}
