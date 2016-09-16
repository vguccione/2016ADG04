package com.ADG04.Servidor.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static EntityManagerProvider instance;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    private EntityManagerProvider() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
    }


    public static EntityManagerProvider getInstance() {
        if(instance == null){
            instance = new EntityManagerProvider();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void close(){
        entityManagerFactory.close();
    }

}
