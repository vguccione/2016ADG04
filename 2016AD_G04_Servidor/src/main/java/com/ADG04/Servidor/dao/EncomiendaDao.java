package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class EncomiendaDao extends GenericDao<EncomiendaE, Integer> {

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
	public List<EncomiendaE> obtenerEncomiendasColocadasPorVencerHoy() {		
		List<EncomiendaE> encomiendas = new ArrayList<EncomiendaE>();
		try{
			encomiendas = entityManager.createQuery("select enc from EncomiendaE enc "
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

	public EncomiendaE getByEnvio(int idEnvio) {
		EncomiendaE enc = null;
		try{
			enc = (EncomiendaE) entityManager.createQuery("select enc from EncomiendaE enc"
					+ " join enc.envios env"
					+ " where env.idEnvio =:idEnvio").setParameter("idEnvio", idEnvio).getSingleResult();
		}
		catch(Exception e){
			return null;
		}
		return enc;
	}
	
	public List<EncomiendaE> getEncomiendasByEnvio(int idEnvio) {
		List<EncomiendaE> enc = null;
		try{
			enc = (List<EncomiendaE>) entityManager.createQuery("select enc from EncomiendaE enc"
					+ " join enc.envios env"
					+ " where env.idEnvio =:idEnvio").setParameter("idEnvio", idEnvio).getResultList();
		}
		catch(Exception e){
			return null;
		}
		return enc;
	}

	@SuppressWarnings("unchecked")
	public List<EncomiendaE> getEncomiendasPendientesBySucursal(int idSucursal) {
		
		//Tengo que buscar las encomiendas que no tienen envios asignados, en la sucursal determinada
		/*select * from Encomienda e 
		left outer join  Encomiendaenvio ee on ee.idEncomienda=e.IdEncomienda
		where ee.idEncomienda is null*/
		
		List<EncomiendaE> encs = (List<EncomiendaE>)entityManager.createQuery("select enc from EncomiendaE enc where "
				+ "enc.sucursalOrigen.idSucursal =:idSuc").setParameter("idSuc", idSucursal).getResultList();
		
		List<EncomiendaE> encsPendientes = new ArrayList<EncomiendaE>();
    	for(EncomiendaE e:encs){
    		if(e.getEnvios() == null || e.getEnvios().isEmpty()){
    			encsPendientes.add(e);
    		}
    	}
				 
		return encsPendientes;
	}

	@SuppressWarnings("unchecked")
	public List<EncomiendaE> getAllParticulares() {
		List<EncomiendaE> encomiendas = new ArrayList<EncomiendaE>();
		try{
			encomiendas = entityManager.createQuery("select enc from EncomiendaE enc "
					+ " where tipoEncomienda='P'"
					+ " ORDER BY fechaCreacion DESC").getResultList();
		}
		catch(Exception e){
			System.out.println("No existen encomiendas particulares");
		}
		return encomiendas;
	}

	@SuppressWarnings("unchecked")
	public List<EncomiendaE> getAllEmpresas() {
		List<EncomiendaE> encomiendas = new ArrayList<EncomiendaE>();
		try{
			encomiendas = entityManager.createQuery("select enc from EncomiendaE enc "
					+ " where tipoEncomienda='E'"
					+ " ORDER BY fechaCreacion DESC").getResultList();
		}
		catch(Exception e){
			System.out.println("No existen encomiendas particulares");
		}
		return encomiendas;
	}

	public List<EncomiendaE> getBySucursalActual(int idSucursal) {
		List<EncomiendaE> encomiendas = new ArrayList<EncomiendaE>();
		try{
			encomiendas = entityManager.createQuery("select enc from EncomiendaE enc "
					+ " where sucursalActual.idSucusal=:idSucursal")
					.setParameter("idSucursal",idSucursal)
					.getResultList();
		}
		catch(Exception e){
			System.out.println("No existen encomiendas para esa sucursal");
		}
		return encomiendas;
	}
	
	public List<EncomiendaE> getBySucursalActualPendientes(int idSucursal) {
		List<EncomiendaE> encomiendas = new ArrayList<EncomiendaE>();
		try{
			encomiendas = entityManager.createQuery("select enc from EncomiendaE enc "
					+ " where sucursalActual.idSucusal=:idSucursal"
					+ " AND (estado='EnEsperaAsignacion' OR estado='Ingresada') ")
					.setParameter("idSucursal",idSucursal)
					.getResultList();
		}
		catch(Exception e){
			System.out.println("No existen encomiendas pendientes para esa sucursal");
		}
		return encomiendas;
	}

}
