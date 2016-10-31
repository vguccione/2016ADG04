package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class TarifasCarrierDao extends GenericDao<TarifasCarrierE, Integer> {

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
	public List<TarifasCarrierE> getTarifasCarrierByProveedor(String filtro) {
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
