package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.Cliente;


public class ClienteDao extends GenericDao<Cliente, Long> {

	public ClienteDao(EntityManager entityManager) {
        super(entityManager);
    }



}
