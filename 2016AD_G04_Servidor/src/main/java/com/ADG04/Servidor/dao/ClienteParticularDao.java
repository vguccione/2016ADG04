package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteParticularDao extends GenericDao<ClienteParticular, Integer> {

	private static ClienteParticularDao instancia;


	private ClienteParticularDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ClienteParticularDao getInstancia(){
		if(instancia == null){	
			instancia = new ClienteParticularDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public ClienteParticular getByDni(String dni) {
		try {
		  Query query = entityManager.createQuery("from Cliente where dni =:dni");
		  query.setParameter("dni", dni);
		  ClienteParticular c = (ClienteParticular) query.getSingleResult();
		  return c;
		       
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error en traer usuario por dni");
            return null;
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteParticular> listarClientes() {
		try{
			return entityManager
	                .createQuery("from Cliente c where c.class = 'p'")
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar clientes particulares");
        }
        return null;
	}
}

