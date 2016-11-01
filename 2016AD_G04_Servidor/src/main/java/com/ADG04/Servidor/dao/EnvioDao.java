package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EnvioDao extends GenericDao<EnvioE, Integer> {

	private static EnvioDao instancia;


	private EnvioDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static EnvioDao getInstancia(){
		if(instancia == null){	
			instancia = new EnvioDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}
	
	public List<EnvioE> getByVehiculo(int idVehiculo){
		List<EnvioE> envios = entityManager.createQuery("from Envio e where e.vehiculo.idVehiculo=:idVehiculo")
										.setParameter("idVehiculo", idVehiculo)
										.getResultList();
		
		return envios;
	}

	public Object getByVehiculoYSucursal(int idVehiculo, int idSucursalDestino) {
		try{
			EnvioE e = (EnvioE) entityManager.createQuery("from Envio e where e.vehiculo.idVehiculo=:idVehiculo"
					+ " and e.sucursalDestino.idSucursal=:idSucursal")
					.setParameter("idVehiculo", idVehiculo)
					.setParameter("idSucursal", idSucursalDestino)
					.getSingleResult();
	
			return e;
		}catch(Exception ex){
			System.out.println("No se encontro envio para la sucursal y el vehiculo solicitado");
			return null;
		}
	}

	public List<EnvioE> listarEnviosPorSucursalDestino(int idSucursalDestino, Date fecha) {
		@SuppressWarnings("unchecked")
		List<EnvioE> envios = entityManager.createQuery("from EnvioE e"
				+ " where e.sucursalDestino.idSucursal=:idSucursal"
				+ " and e.estado='Pendiente'"
				+ " and e.fechaYHoraLlegadaEstimada >=:fecha"
				+ " ORDER BY e.fechaYHoraLlegadaEstimada ASC")
				.setParameter("idSucursal", idSucursalDestino)
				.setParameter("fecha", fecha)
				.getResultList();

		return envios;
		
	}

	public EnvioE getByEncomiendaColocada(int idEncomienda) {
		EnvioE envio = null;
		try{
			envio = (EnvioE) entityManager.createQuery("select e from Envio e "
					+ " join e.encomiendas enc"
					+ " where enc.estado='Colocada'"
					+ " and e.estado='Pendiente'"
					+ " and enc.idEncomienda=:idEncomienda")
					.setParameter("idEncomienda", idEncomienda)
					.getSingleResult();
		}
		catch(Exception e){
			System.out.println("No hay envio pendiente para esa encomienda colocada");
			e.printStackTrace();
			return null;
		}
		return envio;
	}

	public List<EnvioE> getEnviosPropios() {
		try{
			List<EnvioE> envios = entityManager.createQuery("from Envio e where propio=1 "
					+ "ORDER BY idEnvio DESC ")
				.getResultList();
			return envios;
		}
		catch(Exception e){
			System.out.println("No hay envios propios");
			e.printStackTrace();
			return null;
		}
	}
	
	public List<EnvioE> getEnviosTercerizados() {
		try{
			List<EnvioE> envios = entityManager.createQuery("from Envio e where propio=0"
					+ " ORDER BY idEnvio DESC")
				.getResultList();
			return envios;
		}
		catch(Exception e){
			System.out.println("No hay envios propios");
			e.printStackTrace();
			return null;
		}
	}

	public List<EnvioE> getEnviosTercerizadosByEstado(String filtro) {
		String f = filtro+'%';
		try{
			@SuppressWarnings("unchecked")
			List<EnvioE> envios = entityManager.createQuery("from Envio e where propio=0"
					+ " AND estado like :filtro "
					+ " ORDER BY idEnvio DESC").setParameter("filtro", f)
				.getResultList();
			return envios;
		}
		catch(Exception e){
			System.out.println("No hay envios tercerizados con ese estado");
			e.printStackTrace();
			return null;
		}
	}
	
	public List<EnvioE> getEnviosPropiosByEstado(String filtro) {
		String f = filtro+'%';
		try{
			@SuppressWarnings("unchecked")
			List<EnvioE> envios = entityManager.createQuery("from Envio e where propio=1"
					+ " AND estado like :filtro"
					+ " ORDER BY idEnvio DESC").setParameter("filtro", f)
				.getResultList();
			return envios;
		}
		catch(Exception e){
			System.out.println("No hay envios propios con ese estado");
			e.printStackTrace();
			return null;
		}
	}
	

}
