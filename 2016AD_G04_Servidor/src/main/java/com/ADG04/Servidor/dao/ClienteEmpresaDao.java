package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteEmpresaDao extends GenericDao<Cliente, Integer> {

	private static ClienteEmpresaDao instancia;


	private ClienteEmpresaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ClienteEmpresaDao getInstancia(){
		if(instancia == null){	
			instancia = new ClienteEmpresaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
}
