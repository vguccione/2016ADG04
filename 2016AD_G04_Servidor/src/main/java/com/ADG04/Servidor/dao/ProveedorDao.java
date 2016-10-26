package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.TarifasCarrier;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDao extends GenericDao<Proveedor, Integer> {

	private static ProveedorDao instancia;


	private ProveedorDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ProveedorDao getInstancia(){
		if(instancia == null){	
			instancia = new ProveedorDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<Proveedor> getByTipo(char tipo) {
		try {
			  Query query = entityManager.createQuery("from Proveedor where tipo =:tipo");
			  query.setParameter("tipo", tipo);
			  List<Proveedor> lista = query.getResultList();
			  return lista;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error al traer proveedores por tipo");
	            return null;
	        }
		}

}
