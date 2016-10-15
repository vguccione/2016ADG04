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
		Date hoy = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hoy);
	//	calendar.add(Calendar.HOUR, (int) mr.getDuracion());
		
		@SuppressWarnings("unchecked")
		List<Encomienda> encomiendas = entityManager.createQuery("select e from Envio e "
																+ " join e.encomiendas enc"
																+ " where e.fechaYHoraLlegadaEstimada == :fecha"
																+ " and enc.estado='Colocada'")
																.setParameter("fecha", calendar.getTime())
																.getResultList();
		return encomiendas;
	}

}
