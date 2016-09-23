package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;

import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao extends GenericDao<Usuario, Integer> {

	
	private static UsuarioDao instancia;


	private UsuarioDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static UsuarioDao getInstancia(){
		if(instancia == null){	
			instancia = new UsuarioDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public Usuario getByDni(String dni) {
		try {
		  Query query = entityManager.createQuery("from Usuario where dni =:dni");
		  query.setParameter("dni", dni);
		  Usuario u = (Usuario) query.getSingleResult();
		  return u;
		       
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error en traer usuario por dni");
            return null;
        }
	}


	@SuppressWarnings("unchecked")
	public List<Usuario> listarEmpleados(Integer idSucursal) {
		try{
			return entityManager
	                .createQuery("from Usuario e where e.sucursal.idSucursal = :idSucursal ")
	                .setParameter("idSucursal", idSucursal)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar empleados por Sucursal");
        }
        return null;
	}

	public Usuario buscarUsuario(String usuario) {
		try {
			  Query query = entityManager.createQuery("from Usuario where usuario =:usuario");
			  query.setParameter("usuario", usuario);
			  Usuario u = (Usuario) query.getSingleResult();
			  return u;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer usuario");
	            return null;
	        }
	}

}
