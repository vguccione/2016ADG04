package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteDao extends GenericDao<ClienteE, Integer> {

	private static ClienteDao instancia;


	private ClienteDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ClienteDao getInstancia(){
		if(instancia == null){	
			instancia = new ClienteDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public ClienteE getByDni(String dni) {
		try {
		  Query query = entityManager.createQuery("from ClienteE where dni =:dni");
		  query.setParameter("dni", dni);
		  ClienteE c = (ClienteE) query.getSingleResult();
		  return c;
		       
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error en traer usuario por dni");
            return null;
        }
	}
	

	public boolean tieneEncomiendas(Integer id) {
		try{
			List<EncomiendaE> encomiendas= 	entityManager
	                .createQuery("from EncomiendaE e where cliente.idCliente=:id")
	                .setParameter("id", id)
	                .getResultList();
			if(encomiendas.size()>0)
				return true;
			else
				return false;
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: obtener encomiendas");
        }
		return false;
	}

	public ClienteE getByCuit(String cuit) {
		try {
			  Query query = entityManager.createQuery("from ClienteE where cuit =:cuit");
			  query.setParameter("cuit", cuit);
			  ClienteE c = (ClienteE) query.getSingleResult();
			  return c;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer Cliente por cuit");
	            return null;
	        }
	}
}
