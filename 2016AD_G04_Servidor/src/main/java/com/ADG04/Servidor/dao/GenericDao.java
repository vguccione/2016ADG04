package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class GenericDao<E,PK> {


    protected EntityManager entityManager;

    public GenericDao(EntityManager entityManager) {
        this.entityManager = entityManager;
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
        if (ids.isEmpty())
            return new ArrayList();
        Class<E> type = this.getType();
        Query query = entityManager.createQuery("from " + type.getName() + " where id in (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    public E getById(PK id) {
    	System.out.println("public E getById(PK " + id +")");
    	System.out.println(this.getType().toGenericString());
        return entityManager.find(this.getType(), id);

    }

    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        Class<E> type = this.getType();
        return entityManager
                .createQuery("from " + type.getCanonicalName()).getResultList();
    }


    public E saveOrUpdate(E object) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        E newEntity = entityManager.merge(object);
        tx.commit();
        return newEntity;
    }



    public void persist(E object) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        this.entityManager.persist(object);
        tx.commit();
    }


    public void remove(E object) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(object);
        tx.commit();
    }

    public void removeById(PK id) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        E object =entityManager.getReference(this.getType(), id);
        entityManager.remove(object);
        entityManager.flush();
        tx.commit();
    }






}
