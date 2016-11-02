package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ProvinciaE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProvinciaDao extends GenericDao<ProvinciaE, Integer> {

	private static ProvinciaDao instancia;


	private ProvinciaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ProvinciaDao getInstancia(){
		if(instancia == null){	
			instancia = new ProvinciaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<ProvinciaE> getByPais(int idPais) {
		try{
		return entityManager.createQuery("from ProvinciaE where pais=:pais")
				            .setParameter("pais", idPais)
				            .getResultList();
		}catch(Exception e){
            System.out.println(e);
            System.out.println("ErrorDAO: Listar provincias");
		}
		return null;
	}

	public List<ProvinciaE> getByPais(String pais) {
		String p = pais +'%';
		try{
			return entityManager.createQuery("from ProvinciaE where pais.descripcion like :pais")
					            .setParameter("pais", p)
					            .getResultList();
			}catch(Exception e){
	            System.out.println(e);
	            System.out.println("ErrorDAO: Listar provincias");
			}
			return null;
	}

	public ProvinciaE getByNombre(String prov) {
		String p = prov +'%';
		try{
			return (ProvinciaE) entityManager.createQuery("from ProvinciaE where descripcion like :prov")
					            .setParameter("prov", p)
					            .getSingleResult();
			}catch(Exception e){
	            System.out.println(e);
	            System.out.println("ErrorDAO: Listar provincias");
			}
			return null;
	}

}
