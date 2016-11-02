package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;

import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao extends GenericDao<UsuarioE, Integer> {

	
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

	public UsuarioE getByDni(String dni) {
		try {
		  Query query = entityManager.createQuery("from UsuarioE where dni =:dni");
		  query.setParameter("dni", dni);
		  UsuarioE u = (UsuarioE) query.getSingleResult();
		  return u;
		       
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error en traer usuario por dni");
            return null;
        }
	}


	@SuppressWarnings("unchecked")
	public List<UsuarioE> listarEmpleados(Integer idSucursal) {
		try{
			return entityManager
	                .createQuery("from UsuarioE u where u.sucursal.idSucursal = :idSucursal ")
	                .setParameter("idSucursal", idSucursal)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar empleados por Sucursal");
        }
        return null;
	}

	public UsuarioE buscarUsuario(String usuario) {
		try {
			  Query query = entityManager.createQuery("from UsuarioE where usuario =:usuario");
			  query.setParameter("usuario", usuario);
			  UsuarioE u = (UsuarioE) query.getSingleResult();
			  return u;
			       
	        } catch (Exception e){
	            System.out.println(e);
	            System.out.println("Error en traer usuario");
	            return null;
	        }
	}

	public List<UsuarioE> getUsuariosByNombreApellidoOUsuario(String filtro) {
		try{
			String f= filtro+"%";
			return entityManager
	                .createQuery("from UsuarioE  where (nombre like :filtro OR apellido like :filtro OR usuario like :filtro)")
	                .setParameter("filtro", f)
	                .getResultList();
        }catch(Exception e){
                System.out.println(e);
                System.out.println("ErrorDAO: Listar usuarios por nombre, apellido o usuario");
        }
        return null;
	}

}
