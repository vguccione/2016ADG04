package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EncomiendaDao extends GenericDao<Encomienda, Integer> {

	private static EncomiendaDao instancia;


	private EncomiendaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static EncomiendaDao getInstancia(){
		if(instancia == null){	
			instancia = new EncomiendaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<Encomienda> obtenerEncomiendasColocadasPorVencerHoy() {
		/*TODO */
		
		/*
		 * select * 
from encomienda enc
join EncomiendaEnvio ee
on ee.idEncomienda=enc.IdEncomienda
join envio env
on env.idEnvio=ee.idEnvio
join MapaDeRuta mr
on mr.IdMapaDeRuta=env.IdMapaDeRuta
where enc.FechaEstimadaEntrega>=(DATEADD(hour,mr.Duracion,enc.FechaCreacion))
		 * */
		
		@SuppressWarnings("unchecked")
		List<Encomienda> encomiendas = entityManager.createQuery("select enc from Encomienda enc "
																+ " join enc.envios env"
																+ " join env.mapaDeRuta mr"
																+ " where enc.fechaEstimadaEntrega <="
																+ " addhours(mr.duracion,enc.fechaCreacion)")
																.getResultList();
		return encomiendas;
	}

}
