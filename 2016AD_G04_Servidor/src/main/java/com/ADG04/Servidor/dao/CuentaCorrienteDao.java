package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.CuentaCorriente;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CuentaCorrienteDao extends GenericDao<CuentaCorriente, Long> {

	
	public CuentaCorrienteDao(EntityManager entityManager) {
        super(entityManager);
    }

}
