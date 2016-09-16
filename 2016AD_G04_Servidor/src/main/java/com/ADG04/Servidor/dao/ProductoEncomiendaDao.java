package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ProductoEncomienda;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProductoEncomiendaDao extends GenericDao<ProductoEncomienda, Integer> {
	private static ProductoEncomiendaDao instancia;


	private ProductoEncomiendaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ProductoEncomiendaDao getInstancia(){
		if(instancia == null){	
			instancia = new ProductoEncomiendaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

}
