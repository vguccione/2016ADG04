package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Rol;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class RolDao extends GenericDao<Rol, Integer> {

	
	private static RolDao instancia;


	private RolDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static RolDao getInstancia(){
		if(instancia == null){	
			instancia = new RolDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<Rol> buscarRolesUsuario(String usuario) {
		try{
		return entityManager.createQuery("select r from Rol r join r.usuarios ru"
				+ " where ru.idUsuario=:usuario")
				            .setParameter("usuario", Integer.valueOf(usuario))
				            .getResultList();
		}catch(Exception e){
            System.out.println(e);
            System.out.println("ErrorDAO: Listar roles usuario");
		}
		return null;
	}
}
