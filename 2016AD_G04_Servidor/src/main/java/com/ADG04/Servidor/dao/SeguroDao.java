package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class SeguroDao extends GenericDao<SeguroE, Integer> {

	private static SeguroDao instancia;


	private SeguroDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static SeguroDao getInstancia(){
		if(instancia == null){	
			instancia = new SeguroDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	

	@SuppressWarnings("unchecked")
	public List<SeguroE> getSegurosByProveedor(String filtro) {
		try {
			  String f = filtro + '%';
			  Query query = entityManager.createQuery("from Seguro s where s.proveedor.razonSocial like :filtro");
			  query.setParameter("filtro", f);
			  return query.getResultList();
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer seguros por proveedor");
	            return null;
	        }
	}
	
	
}
