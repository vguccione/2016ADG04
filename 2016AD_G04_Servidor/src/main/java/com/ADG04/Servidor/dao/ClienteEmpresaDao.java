package com.ADG04.Servidor.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.model.ClienteEmpresa;
import com.ADG04.Servidor.util.EntityManagerProvider;


public class ClienteEmpresaDao extends GenericDao<ClienteEmpresa, Integer> {

	private static ClienteEmpresaDao instancia;


	private ClienteEmpresaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ClienteEmpresaDao getInstancia(){
		if(instancia == null){	
			instancia = new ClienteEmpresaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteEmpresa> listarClientes() {
		try{
			return entityManager
	                .createQuery("from Cliente c where c.class = 'e'")
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar clientes empresas");
        }
        return null;
	}

	public ClienteEmpresa getByCuit(String cuit) {
		try{
			return (ClienteEmpresa) entityManager
	                .createQuery("from Cliente c where c.class = 'e' and cuit = :cuit")
	                .setParameter("cuit", cuit)
	                .getSingleResult();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar clientes empresas por cuit");
        }
        return null;
	}

	public List<ClienteEmpresa> getEmpresaByRazonSocial(String filtro) {
		try{
			String f= filtro+"%";
			return entityManager
	                .createQuery("from Cliente c where c.class = 'e' and razonSocial like :filtro")
	                .setParameter("filtro", f)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar clientes empresas por razon social");
        }
        return null;
	}
	
}
