package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;

public class MapaDeRuta{

	private int idMapaDeRuta;
	private List<Envio> envios;
	private List<Coordenada> coordenadas;
	private float duracion; //en horas
	private float cantKm;
	private float costo;
	private Sucursal sucursalDestino;
	private Sucursal sucursalOrigen;

	public MapaDeRuta() {
	}

	public MapaDeRuta(float duracion, int cantKm) {
		super();
		this.duracion = duracion;
		this.cantKm = cantKm;
	}

	public int getIdMapaDeRuta() {
		return idMapaDeRuta;
	}

	public void setIdMapaDeRuta(int idMapaDeRuta) {
		this.idMapaDeRuta = idMapaDeRuta;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public float getCantKm() {
		return cantKm;
	}

	public void setCantKm(float cant) {
		this.cantKm = cant;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public DTO_MapaDeRuta toDTO() {
		DTO_MapaDeRuta dto = new DTO_MapaDeRuta();
		dto.setCantKm(this.getCantKm());
		dto.setCosto(this.getCosto());
		dto.setDuracion(this.getDuracion());
		dto.setId(this.getIdMapaDeRuta());
		dto.setIdSucursalDestino(this.getSucursalDestino().getIdSucursal());
		dto.setIdSucursalOrigen(this.getSucursalOrigen().getIdSucursal());
		
		List<DTO_Coordenada> listaCoordenadas = new ArrayList<DTO_Coordenada>();
		for(Coordenada coord : this.getCoordenadas()){
			DTO_Coordenada c = new DTO_Coordenada();
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			listaCoordenadas.add(c);
		}
		dto.setCoordenadas(listaCoordenadas);
		
		return dto;
	}
	
	public Date calcularFechaEstimadaDeEntrega() {//(int idSucursalOrigen, int idSucursalDestino){
		
		//MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(idSucursalOrigen, idSucursalDestino);
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getById(this.idMapaDeRuta);
		System.out.println("calcularFechaEstimadaDeEntrega , mapa de ruta id " + mr.getIdMapaDeRuta());
		if(mr!=null){
			Date hoy = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoy);
			//se calculara 1 dia mas a lo que lleva el viaje de sucursal a sucursal (politica de la empresa)
			int tiempoViaje = (int) mr.getDuracion() + 24;
			calendar.add(Calendar.HOUR, tiempoViaje);
			return calendar.getTime();
		}
		else
			return null;
	}
	
	public Date calcularFechaEstimadaDeEntrega(Date fechaPartida) {
		
		//MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(idSucursalOrigen, idSucursalDestino);
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getById(this.idMapaDeRuta);
		System.out.println("calcularFechaEstimadaDeEntrega , mapa de ruta id " + mr.getIdMapaDeRuta());
		if(mr!=null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaPartida);
			//se calculara 1 dia mas a lo que lleva el viaje de sucursal a sucursal (politica de la empresa)
			int tiempoViaje = (int) mr.getDuracion() + 24;
			calendar.add(Calendar.HOUR, tiempoViaje);
			return calendar.getTime();
		}
		else
			return null;
	}

	public MapaDeRuta fromDTO(DTO_MapaDeRuta mapa) {
		MapaDeRuta mr = new MapaDeRuta();
		mr.setCantKm(mapa.getCantKm());
		
		List<Coordenada> listaCoordenadas = new ArrayList<Coordenada>();
		for(DTO_Coordenada coord : mapa.getCoordenadas()){
			Coordenada c = new Coordenada();
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			listaCoordenadas.add(c);
		}
		
		mr.setCoordenadas(listaCoordenadas);
		mr.setCosto(mapa.getCosto());
		mr.setDuracion(mapa.getDuracion());
		mr.setSucursalDestino(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(mapa.getIdSucursalDestino())));
		mr.setSucursalOrigen(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(mapa.getIdSucursalOrigen())));
		if(mapa.getId()!=null)
			mr.setIdMapaDeRuta(mapa.getId());
		return mr;
	}

	public MapaDeRutaE toEntity(){
		MapaDeRutaE me = new MapaDeRutaE();
		me.setCantKm(this.cantKm);
		me.setCosto(this.costo);
		me.setDuracion(this.duracion);
		me.setIdMapaDeRuta(this.idMapaDeRuta);
		me.setSucursalDestino(SucursalDao.getInstancia().getById(this.sucursalDestino.getIdSucursal()));
		me.setSucursalOrigen(SucursalDao.getInstancia().getById(this.sucursalOrigen.getIdSucursal()));
		
		List<CoordenadaE> listaCoord = new ArrayList<CoordenadaE>();
		for(Coordenada c : this.getCoordenadas()){
			CoordenadaE cord = new CoordenadaE();
			cord.setLatitud(c.getLatitud());
			cord.setLongitud(c.getLongitud());
			cord.setIdCoordenada(c.getIdCoordenada());
			listaCoord.add(cord);
		}
		me.setCoordenadas(listaCoord);
		return me;
	}
	
	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		MapaDeRutaDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}



	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		MapaDeRutaDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
		em.close();
	}

	public MapaDeRuta fromEntity(MapaDeRutaE mapa) {
		MapaDeRuta mr = new MapaDeRuta();
		mr.setCantKm(mapa.getCantKm());
		mr.setCosto(mapa.getCosto());
		mr.setDuracion(mapa.getDuracion());
		mr.setIdMapaDeRuta(mapa.getIdMapaDeRuta());
		mr.setSucursalDestino(new Sucursal().fromEntity(mapa.getSucursalDestino()));
		mr.setSucursalOrigen(new Sucursal().fromEntity(mapa.getSucursalOrigen()));
		mr.setIdMapaDeRuta(mapa.getIdMapaDeRuta());
		
		List<Coordenada> listaCoordenadas = new ArrayList<Coordenada>();
		for(CoordenadaE coord : mapa.getCoordenadas()){
			Coordenada c = new Coordenada();
			c.setLatitud(coord.getLatitud());
			c.setLongitud(coord.getLongitud());
			c.setIdCoordenada(coord.getIdCoordenada());
			listaCoordenadas.add(c);
		}
		mr.setCoordenadas(listaCoordenadas);
		
		return mr;
	}


}
