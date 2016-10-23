package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class RolUsuarioDao extends GenericDao<RolUsuario, Integer> {

	
	private static RolUsuarioDao instancia;


	private RolUsuarioDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static RolUsuarioDao getInstancia(){
		if(instancia == null){	
			instancia = new RolUsuarioDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<RolUsuario> buscarRolesUsuario(String usuario) {
		try{
		return entityManager.createQuery("select ru from RolUsuario ru join ru.usuarios u where u.idUsuario=:usuario")
				            .setParameter("usuario", Integer.valueOf(usuario))
				            .getResultList();
		}catch(Exception e){
            System.out.println(e);
            System.out.println("ErrorDAO: Listar roles usuario");
		}
		return null;
	}
}
