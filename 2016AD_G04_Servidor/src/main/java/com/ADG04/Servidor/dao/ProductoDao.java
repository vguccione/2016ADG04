package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ProductoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProductoDao extends GenericDao<ProductoE, Integer> {

	private static ProductoDao instancia;


	private ProductoDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ProductoDao getInstancia(){
		if(instancia == null){	
			instancia = new ProductoDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public ProductoE getByClienteCodigo(Integer idCliente, String codigoProducto) {
		return (ProductoE) entityManager.createQuery("select p from ProductoE p where p.idCliente=:idCliente and p.codigoProducto=:codigoProducto")
						    .setParameter("idCliente", idCliente)
						    .setParameter("codigoProducto", codigoProducto)
						    .getSingleResult();
	}

}
