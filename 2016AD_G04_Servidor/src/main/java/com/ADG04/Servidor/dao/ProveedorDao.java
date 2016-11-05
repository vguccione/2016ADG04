package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProveedorDao extends GenericDao<ProveedorE, Integer> {

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

	public List<ProveedorE> getByTipo(char tipo) {
		try {
			  Query query = entityManager.createQuery("from ProveedorE where tipo =:tipo");
			  query.setParameter("tipo", tipo);
			  List<ProveedorE> lista = query.getResultList();
			  return lista;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error al traer proveedores por tipo");
	            return null;
	        }
		}

	public List<ProveedorE> getProveedorByRazonSocial(String filtro) {
		try{
			String f= filtro+"%";
			return entityManager
	                .createQuery("from ProveedorE c where razonSocial like :filtro")
	                .setParameter("filtro", f)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar proveedores por razon social");
        }
        return null;
	}

	public ProveedorE getByCuit(String cuit) {
		try{
			return (ProveedorE) entityManager
	                .createQuery("from ProveedorE  where cuit =:cuit")
	                .setParameter("cuit", cuit)
	                .getSingleResult();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Buscar proveedor por cuit");
        }
        return null;
	}

}
