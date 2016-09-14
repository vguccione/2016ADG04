package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Factura;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FacturaDao extends GenericDao<Factura, Integer> {

	
	public FacturaDao(EntityManager entityManager) {
        super(entityManager);
    }

}
