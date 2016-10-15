package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MapaDeRutaDao extends GenericDao<MapaDeRuta, Integer> {

	
	private static MapaDeRutaDao instancia;


	private MapaDeRutaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static MapaDeRutaDao getInstancia(){
		if(instancia == null){	
			instancia = new MapaDeRutaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public MapaDeRuta getBySucursalOrigenyDestino(int idSucursalOrigen, int idSucursalDestino) {
		try{
			return (MapaDeRuta) entityManager.createQuery("from MapaDeRuta mr where mr.sucursalOrigen.idSucursal=:idSucursalOrigen"
												+ " and mr.sucursalDestino.idSucursal=:idSucursalDestino")
												.setParameter("idSucursalOrigen", idSucursalOrigen)
												.setParameter("idSucursalDestino", idSucursalDestino).getSingleResult();
		}
		catch(Exception e){
			return null;
		}
	}

}
