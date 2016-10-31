package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MapaDeRutaCoordenadaDao extends GenericDao<MapaDeRutaE, Integer> {

	private static MapaDeRutaCoordenadaDao instancia;


	private MapaDeRutaCoordenadaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static MapaDeRutaCoordenadaDao getInstancia(){
		if(instancia == null){	
			instancia = new MapaDeRutaCoordenadaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
}
