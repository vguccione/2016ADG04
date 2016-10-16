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

	@SuppressWarnings("unchecked")
	public List<Encomienda> obtenerEncomiendasColocadasPorVencerHoy() {		
		List<Encomienda> encomiendas = new ArrayList<Encomienda>();
		try{
			encomiendas = entityManager.createQuery("select enc from Encomienda enc "
																	+ " join enc.envios env"
																	+ " join env.mapaDeRuta mr"
																	+ " where enc.estado='Colocada'"
																	+ " and enc.fechaEstimadaEntrega <="
																	+ " addhours((mr.duracion-24),enc.fechaCreacion)")
																	.getResultList();
		}
		catch(Exception e){
			System.out.println("No existen encomiendas por vencer");
		}
		return encomiendas;
	}

	public Encomienda getByEnvio(int idEnvio) {
		Encomienda enc = null;
		try{
			enc = (Encomienda) entityManager.createQuery("select enc from Encomienda enc"
					+ " join enc.envios env"
					+ " where env.idEnvio =:idEnvio").setParameter("idEnvio", idEnvio).getSingleResult();
		}
		catch(Exception e){
			return null;
		}
		return enc;
	}

	@SuppressWarnings("unchecked")
	public List<Encomienda> getEncomiendasPendientesBySucursal(int idSucursal) {
		
		//Tengo que buscar las encomiendas que no tienen envios asignados, en la sucursal determinada
		/*select * from Encomienda e 
		left outer join  Encomiendaenvio ee on ee.idEncomienda=e.IdEncomienda
		where ee.idEncomienda is null*/
		
		List<Encomienda> encs = (List<Encomienda>)entityManager.createQuery("select enc from Encomienda enc where "
				+ "enc.sucursalOrigen.idSucursal =:idSuc").setParameter("idSuc", idSucursal).getResultList();
		
		List<Encomienda> encsPendientes = new ArrayList<Encomienda>();
    	for(Encomienda e:encs){
    		if(e.getEnvios() == null || e.getEnvios().isEmpty()){
    			encsPendientes.add(e);
    		}
    	}
				 
		return encsPendientes;
	}

}
