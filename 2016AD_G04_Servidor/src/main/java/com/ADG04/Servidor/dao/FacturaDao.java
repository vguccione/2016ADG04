package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.FacturaE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FacturaDao extends GenericDao<FacturaE, Integer> {

	private static final FacturaE Factura = null;
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

	public FacturaE getFacturaCliente(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente");
			  query.setParameter("cliente", idCliente);
			  FacturaE f = (FacturaE) query.getSingleResult();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer factura por cliente");
	            return null;
	        }
	}

	public List<FacturaE> listarFacturasClientePendientes(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente and pagada=false" );
			  query.setParameter("cliente", idCliente);
			  List<FacturaE> f = (List<FacturaE>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente pendiente");
	            return null;
	        }
	        
	}

	public List<FacturaE> listarFacturasCliente(Integer idCliente) {
		try {
			  Query query = entityManager.createQuery("from Factura where cliente =:cliente");
			  query.setParameter("cliente", idCliente);
			  List<FacturaE> f = (List<FacturaE>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente");
	            return null;
	        }
	}

	public List<FacturaE> listarFacturasClientePendientes() {
		try {
			  Query query = entityManager.createQuery("from Factura where  pagada=false" );
			  List<FacturaE> f = (List<FacturaE>) query.getResultList();
			  return f;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas pendientes");
	            return null;
	        }
	}

	public List<FacturaE> getFacturasByCliente(String filtro, boolean pendientes) {
		try {
			  Query query;
			  String f = filtro+'%';
			  if(pendientes)
				  query = entityManager.createQuery("from Factura f where f.encomienda.cliente.dni like :filtro and pagada=false" );
			  else{
				  query = entityManager.createQuery("from Factura f where f.encomienda.cliente.dni like :filtro" );
			  }
			  query.setParameter("filtro", f);
			  List<FacturaE> facturas = (List<FacturaE>) query.getResultList();
			  return facturas;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en listar facturas por cliente");
	            return null;
	        }
	}

}
