package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CoordenadaDao extends GenericDao<CoordenadaE, Integer> {

	
	private static CoordenadaDao instancia;


	private CoordenadaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static CoordenadaDao getInstancia(){
		if(instancia == null){	
			instancia = new CoordenadaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	//TODO: revisar
	@SuppressWarnings("unchecked")
	public CoordenadaE getByLatitudLongitud(String latitud, String longitud) {

		List<CoordenadaE> cs = (List<CoordenadaE>)entityManager.createQuery("from Usuario where dni =:dni")
					.setParameter("latitud", latitud)
					.setParameter("longitud", longitud).getResultList();
		
		if(!cs.isEmpty())
			return cs.get(0);
		
		return null;
	}
	
}
