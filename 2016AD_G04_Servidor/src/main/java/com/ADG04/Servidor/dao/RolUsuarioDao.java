package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.RolUsuario;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class RolUsuarioDao extends GenericDao<RolUsuario, Integer> {

	
	public RolUsuarioDao(EntityManager entityManager) {
        super(entityManager);
    }

}
