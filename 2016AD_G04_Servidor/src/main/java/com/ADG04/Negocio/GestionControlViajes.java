package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;


public class GestionControlViajes {

	private static GestionControlViajes instancia;
	
	private EntityManagerFactory factory;
	
	private GestionControlViajes(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionControlViajes getInstancia(){
		if(instancia == null){
			instancia = new GestionControlViajes();
		}
		return instancia;
	}
	
	
	public void altaMapaDeRuta(DTO_MapaDeRuta mapa){
		MapaDeRuta hr = new MapaDeRuta();
		hr.setCantKm(mapa.getCantKm());
		hr.setDuracion(mapa.getDuracion());
		hr.setSucursalDestino(SucursalDao.getInstancia().getById(mapa.getIdSucursalDestino()));
		hr.setSucursalOrigen(SucursalDao.getInstancia().getById(mapa.getIdSucursalOrigen()));
		
		List<Coordenada> lista  = new ArrayList<Coordenada>();
		for(DTO_Coordenada coord : mapa.getCoordenadas()){
			Coordenada c = new Coordenada();
			c.setIdCoordenada(coord.getId());
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			lista.add(c);
		}
		
		hr.setCoordenadas(lista);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		MapaDeRutaDao.getInstancia().persist(hr);

		tx.commit();
	}
	
	public void modificarMapaDeRuta(DTO_MapaDeRuta mapa){
		MapaDeRuta hr = new MapaDeRuta();
		hr.setIdMapaDeRuta(mapa.getId());
		hr.setCantKm(mapa.getCantKm());
		hr.setDuracion(mapa.getDuracion());
		hr.setSucursalDestino(SucursalDao.getInstancia().getById(mapa.getIdSucursalDestino()));
		hr.setSucursalOrigen(SucursalDao.getInstancia().getById(mapa.getIdSucursalOrigen()));
		
		List<Coordenada> lista  = new ArrayList<Coordenada>();
		for(DTO_Coordenada coord : mapa.getCoordenadas()){
			Coordenada c = new Coordenada();
			c.setIdCoordenada(coord.getId());
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			lista.add(c);
		}

		hr.setCoordenadas(lista);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		MapaDeRutaDao.getInstancia().saveOrUpdate(hr);

		tx.commit();
	}
	
	
	/*La idea es llamar este metodo cada 5 minutos desde la web para actualizar
	 * el estado del envio
	 * La coordenadaActual sera obtenida del XML provisto por los vehiculos
	 */
	public void actualizarEstadoVehiculo(int idEnvio, Coordenada coordActual){
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Envio e = EnvioDao.getInstancia().getById(idEnvio);
		MapaDeRuta mr = e.getMapaDeRuta();
		List<Coordenada> lista = mr.getCoordenadas();
		Boolean encontrado = false;
		for(Coordenada coord: mr.getCoordenadas()){
			if(coordActual.getLatitud()==coord.getLatitud() && coordActual.getLongitud()==coord.getLongitud()){
				encontrado=true;
			}
		}
		
		if(!encontrado){
			if(e.getEstado()==EnvioEstado.EnViaje.toString()){
				e.setEstado(EnvioEstado.Desviado.toString());
			}
			else {
				if(e.getEstado()==EnvioEstado.Desviado.toString()){
					e.setEstado(EnvioEstado.Alerta.toString());
				}
			}
		}
		e.setPosicionActual(coordActual);
		EnvioDao.getInstancia().saveOrUpdate(e);
		tx.commit();
	}
	
	public void estaEnvioDemorado(int idEnvio){
		Envio e = EnvioDao.getInstancia().getById(idEnvio);
		Date hoy = new Date();
		if(e.getFechaYHoraLlegadaEstimada().compareTo(hoy)<0){
			e.setEstado(EnvioEstado.Demorado.toString());
			EntityManager em = factory.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			EnvioDao.getInstancia().saveOrUpdate(e);
			tx.commit();
		}
	}
	
	public void concluirEnvio(int idEnvio){
		Envio e = EnvioDao.getInstancia().getById(idEnvio);
		e.setEstado(EnvioEstado.Concluido.toString());
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EnvioDao.getInstancia().saveOrUpdate(e);
		tx.commit();
	}
		
}
