package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.model.TarifasCarrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class TarifasCarrierDao extends GenericDao<TarifasCarrier, Integer> {

	private static TarifasCarrierDao instancia;


	private TarifasCarrierDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static TarifasCarrierDao getInstancia(){
		if(instancia == null){	
			instancia = new TarifasCarrierDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<TarifasCarrier> getTarifasCarrierByProveedor(String filtro) {
		try {
			  String f = filtro + '%';
			  Query query = entityManager.createQuery("from TarifasCarrier t where t.proveedor.razonSocial like :filtro");
			  query.setParameter("filtro", f);
			  return query.getResultList();
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer tarifas carrier por proveedor");
	            return null;
	        }
	}
	
}
