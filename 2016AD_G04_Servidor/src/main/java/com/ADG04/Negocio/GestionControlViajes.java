package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EncomiendaEstado;
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
		MapaDeRutaE hr = new MapaDeRutaE();
		hr.setCantKm(mapa.getCantKm());
		hr.setDuracion(mapa.getDuracion());
		hr.setSucursalDestino(SucursalDao.getInstancia().getById(mapa.getIdSucursalDestino()));
		hr.setSucursalOrigen(SucursalDao.getInstancia().getById(mapa.getIdSucursalOrigen()));
		
		List<CoordenadaE> lista  = new ArrayList<CoordenadaE>();
		for(DTO_Coordenada coord : mapa.getCoordenadas()){
			CoordenadaE c = new CoordenadaE();
			c.setIdCoordenada(coord.getId());
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			lista.add(c);
		}
		
		hr.setCoordenadas(lista);
		MapaDeRutaDao.getInstancia().persist(hr);
	}
	
	public void modificarMapaDeRuta(DTO_MapaDeRuta mapa){
		MapaDeRutaE hr = new MapaDeRutaE();
		hr.setIdMapaDeRuta(mapa.getId());
		hr.setCantKm(mapa.getCantKm());
		hr.setDuracion(mapa.getDuracion());
		hr.setSucursalDestino(SucursalDao.getInstancia().getById(mapa.getIdSucursalDestino()));
		hr.setSucursalOrigen(SucursalDao.getInstancia().getById(mapa.getIdSucursalOrigen()));
		
		List<CoordenadaE> lista  = new ArrayList<CoordenadaE>();
		for(DTO_Coordenada coord : mapa.getCoordenadas()){
			CoordenadaE c = new CoordenadaE();
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
	}
	
	
	/*La idea es llamar este metodo cada 5 minutos desde la web para actualizar
	 * el estado del envio
	 * La coordenadaActual sera obtenida del XML provisto por los vehiculos
	 */
	public void actualizarEstadoVehiculo(int idEnvio, CoordenadaE coordActual){
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		MapaDeRutaE mr = e.getMapaDeRuta();
		List<CoordenadaE> lista = mr.getCoordenadas();
		Boolean encontrado = false;
		for(CoordenadaE coord: mr.getCoordenadas()){
			if(coordActual.getLatitud().equals(coord.getLatitud()) && coordActual.getLongitud().equals(coord.getLongitud())){
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
		e.setPosicionActual(CoordenadaDao.getInstancia().getById(coordActual.getIdCoordenada()));
		EnvioDao.getInstancia().saveOrUpdate(e);
	}
	
	public void estaEnvioDemorado(int idEnvio){
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		Date hoy = new Date();
		if(e.getFechaYHoraLlegadaEstimada().compareTo(hoy)<0){
			e.setEstado(EnvioEstado.Demorado.toString());
			EnvioDao.getInstancia().saveOrUpdate(e);
		}
	}
	
	public void concluirEnvio(int idEnvio){
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		EncomiendaE enc = EncomiendaDao.getInstancia().getByEnvio(idEnvio);
		try{
			enc.setEstado(EncomiendaEstado.EnSucursalDestino.toString());
			EncomiendaDao.getInstancia().saveOrUpdate(enc);
			e.setEstado(EnvioEstado.Concluido.toString());
			EnvioDao.getInstancia().saveOrUpdate(e);
		}
		catch(Exception exc){
			System.out.println("Error al concluir envio");
			exc.printStackTrace();
		}
		
	}
		
}
