package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteEmpresa;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FacturaDao extends GenericDao<Factura, Integer> {

	private static final Factura Factura = null;
	private static FacturaDao instancia;


	private FacturaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static FacturaDao getInstancia(){
		if(instancia == null){	
			instancia = new FacturaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public Factura getFacturaCliente(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente");
			  query.setParameter("cliente", idCliente);
			  Factura f = (Factura) query.getSingleResult();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer factura por cliente");
	            return null;
	        }
	}

	public List<Factura> listarFacturasClientePendientes(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente and pagada=false" );
			  query.setParameter("cliente", idCliente);
			  List<Factura> f = (List<Factura>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente pendiente");
	            return null;
	        }
	        
	}

	public List<Factura> listarFacturasCliente(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente");
			  query.setParameter("cliente", idCliente);
			  List<Factura> f = (List<Factura>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente");
	            return null;
	        }
	}

	public List<Factura> listarFacturasClientePendientes() {
		try {
			  Query query = entityManager.createQuery("from Factura where  pagada=false" );
			  List<Factura> f = (List<Factura>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas pendientes");
	            return null;
	        }
	}

	public List<Factura> getFacturasByCliente(String filtro, boolean pendientes) {
		try {
			  Query query;
			  String f = filtro+'%';
			  if(pendientes)
				  query = entityManager.createQuery("from Factura f where f.encomienda.cliente.dni like :filtro and pagada=false" );
			  else{
				  query = entityManager.createQuery("from Factura f where f.encomienda.cliente.dni like :filtro" );
			  }
			  query.setParameter("filtro", f);
			  List<Factura> facturas = (List<Factura>) query.getResultList();
			  return facturas;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente");
	            return null;
	        }
	}

}
