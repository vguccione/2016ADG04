package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		LocalDateTime timePoint = LocalDateTime.now();
		LocalDateTime fminus1day = timePoint.minusDays(1);
		Timestamp fecha = Timestamp.valueOf(fminus1day);
		
		@SuppressWarnings("unchecked")
		List<Encomienda> encomiendas = entityManager.createQuery("select e from Encomienda"
																+ " where e.fechaEstimadaEntrega = :fecha"
																+ " and e.estado='Colocada'")
																.setParameter("fecha", fecha)
																.getResultList();
		return encomiendas;
	}

}
