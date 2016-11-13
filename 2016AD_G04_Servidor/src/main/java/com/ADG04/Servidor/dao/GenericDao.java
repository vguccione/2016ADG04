package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.util.ExceptionManager;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class GenericDao<E,PK> {

    Logger logger = Logger.getLogger("MyLog");  

    protected EntityManager entityManager;

    public GenericDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        
        //Initialize log
        ExceptionManager.InitLogger(this.getType().getName()+"-GenericDao", logger);
    }

    @SuppressWarnings("unchecked")
    protected Class<E> getType() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
        Type type = actualTypeArguments[0];
        return (Class<E>) type;
    }


    @SuppressWarnings("unchecked")
    public List<E> getByIds(List<PK> ids){
    	
    	try{
	        if (ids.isEmpty())
	            return new ArrayList();
	        Class<E> type = this.getType();
	        Query query = entityManager.createQuery("from " + type.getName() + " where id in (:ids)");
	        query.setParameter("ids", ids);
	        return query.getResultList();
    	}
    	catch(Exception ex){
    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	}
    }

    public E getById(PK id) {
    	/*System.out.println("public E getById(PK " + id +")");
    	System.out.println(this.getType().toGenericString());*/
        
    	try{
    		return entityManager.find(this.getType(), id);
    	}
    	catch(Exception ex){
    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	}
    }

    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        
    	try{
	    	Class<E> type = this.getType();
	        return entityManager
	                .createQuery("from " + type.getCanonicalName()).getResultList();
    	}
    	catch(Exception ex){
    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	} 
    }


    public E saveOrUpdate(E object) {

    	EntityTransaction tx = null;
    	
    	try{
    		tx = entityManager.getTransaction();
	        tx.begin();
	        E newEntity = entityManager.merge(object);
	        tx.commit();
	        return newEntity;
        }
        catch(Exception ex){
        	if(tx != null && tx.isActive())
        		tx.rollback();
        	
        	ExceptionManager.LogException(ex, logger);
        	throw ex;
        }
    }



    public void persist(E object) {
    	
    	EntityTransaction tx = null;
    	
    	try{
	        tx = entityManager.getTransaction();
	        tx.begin();
	        this.entityManager.persist(object);
	        tx.commit();
    	}
    	catch(Exception ex){
        	if(tx != null  && tx.isActive())
        		tx.rollback();

    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	}
    }


    public void remove(E object) {
    	
    	EntityTransaction tx = null;
    	try {
	        tx = entityManager.getTransaction();
	        tx.begin();
	        entityManager.remove(object);
	        tx.commit();
    	}
    	catch(Exception ex){
        	if(tx != null  && tx.isActive())
        		tx.rollback();

    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	}
    }

    public void removeById(PK id) {
        
    	EntityTransaction tx = null;
    	
    	try {
	    	tx = entityManager.getTransaction();
	        tx.begin();
	        E object =entityManager.getReference(this.getType(), id);
	        entityManager.remove(object);
	        entityManager.flush();
	        tx.commit();
    	}
    	catch(Exception ex){
        	if(tx != null && tx.isActive())
        		tx.rollback();
        	
    		ExceptionManager.LogException(ex, logger);
    		throw ex;
    	}
    }


}
