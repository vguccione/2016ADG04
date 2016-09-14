package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteDao extends GenericDao<Cliente, Integer> {

	public ClienteDao(EntityManager entityManager) {
        super(entityManager);
    }

	public Cliente getCliente(String cuit){
		
		try{
		int id = 1;
		Cliente cliente = this.getById(id);
		
		return cliente;
		}
		catch(Exception ex){
			System.out.print(ex.getMessage());
			throw ex;
		}
	}

}
