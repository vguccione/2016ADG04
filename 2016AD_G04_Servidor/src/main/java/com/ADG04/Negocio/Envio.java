package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





















import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;



public class Envio{

	
	private int idEnvio;

	private Proveedor proveedor;
	private MapaDeRuta mapaDeRuta;
	private Coordenada posicionActual;
	private Sucursal sucursalDestino;
	private Sucursal sucursalOrigen;
	private Vehiculo vehiculo;
	private String estado;
	private Date fechaYHoraLlegadaEstimada;
	private Date fechaYHoraSalida;
	private boolean propio;
	private Integer nroTracking;
	private List<Encomienda> encomiendas;

	public Envio() {
	}

	public Envio(Proveedor proveedor, MapaDeRuta mapaDeRuta,
			Coordenada posicionActual, Sucursal sucursalDestino,
			Sucursal sucursalOrigen, Vehiculo vehiculo, String estado,
			Date fechaYHoraLlegadaEstimada, Date fechaYHoraSalida,
			boolean propio, Integer nroTracking) {
		super();
		this.proveedor = proveedor;
		this.mapaDeRuta = mapaDeRuta;
		this.posicionActual = posicionActual;
		this.sucursalDestino = sucursalDestino;
		this.sucursalOrigen = sucursalOrigen;
		this.vehiculo = vehiculo;
		this.estado = estado;
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.propio = propio;
		this.nroTracking = nroTracking;
	}



	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Coordenada getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(Coordenada posicionActual) {
		this.posicionActual = posicionActual;
	}

	public void setPosicionActual(String latitud, String longitud){
		
		//Busco si hay una coordenada que coincide con esta latitud y longitud. Si esta, la uso. si no, la creo
		CoordenadaE coord = CoordenadaDao.getInstancia().getByLatitudLongitud(latitud, longitud);
		
		if(coord == null){
			coord = new CoordenadaE(latitud, longitud);
			CoordenadaDao.getInstancia().saveOrUpdate(coord);
		}
				
		this.posicionActual = new Coordenada(latitud, longitud);
		this.posicionActual.setIdCoordenada(coord.getIdCoordenada());
	}
	
	public MapaDeRuta getMapaDeRuta() {
		return mapaDeRuta;
	}

	public void setMapaDeRuta(MapaDeRuta mapaDeRuta) {
		this.mapaDeRuta = mapaDeRuta;
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

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaYHoraLlegadaEstimada() {
		return fechaYHoraLlegadaEstimada;
	}


	public void setFechaYHoraLlegadaEstimada(Date fechaYHoraLlegadaEstimada) {
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
	}


	public Date getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(Date fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}


	public boolean isPropio() {
		return this.propio;
	}

	public void setPropio(boolean propio) {
		this.propio = propio;
	}

	public Integer getNroTracking() {
		return this.nroTracking;
	}

	public void setNroTracking(Integer nroTracking) {
		this.nroTracking = nroTracking;
	}

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}

	@Override
	public String toString() {
		return "Envio [idEnvio=" + idEnvio 
				+ ", posicionActual=" + posicionActual + ", sucursalDestino="
				+ sucursalDestino.getIdSucursal() + ", sucursalOrigen=" + sucursalOrigen.getIdSucursal()
				+ ", vehiculo=" + vehiculo.getIdVehiculo() + ", estado=" + estado
				+ ", fechaYHoraLlegadaEstimada=" + fechaYHoraLlegadaEstimada
				+ ", fechaYHoraSalida=" + fechaYHoraSalida + ", propio="
				+ propio + ", nroTracking=" + nroTracking + "]";
	}
	
	public DTO_Envio toDTO(){
		if(this.propio){
			DTO_EnvioPropio dto = new DTO_EnvioPropio();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			dto.setFechaYHoraLlegada(this.getFechaYHoraLlegadaEstimada());
			dto.setFechaYHoraSalida(this.getFechaYHoraSalida());
			dto.setIdHojaDeRuta(this.getMapaDeRuta().getIdMapaDeRuta());
			dto.setIdVehiculo(this.getVehiculo().getIdVehiculo());
			return dto;
		}
		else{
			DTO_EnvioTercerizado dto = new DTO_EnvioTercerizado();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			dto.setIdProveedor(this.getProveedor().getIdProveedor());
			dto.setNumeroTracking(String.valueOf(this.getNroTracking()));
			return dto;
		}
		
	}

	
	/*Actualiza la posicion con latitud y longitud, y actualiza el estado: 
	*   Pendiente,	//por salir en viaje
	* 	VehiculoCompleto, //se lleno la capacidad del vehiculo
	* 	EnViaje,	//esta en viaje
	* 	Desviado,   //el vehiculo asignado al envio no esta siguiendo la ruta acordada
	* 	Alerta,     //el vehiculo asignado hace 10 minutos que esta en otra ruta
	* 	Demorado,   //el envio llego mas tarde de lo pautado
	* 	Concluido   //llego a destino
	* La idea es llamar este metodo cada 5 minutos desde la web para actualizar el estado del envio. 
	* La coordenadaActual sera obtenida del XML provisto por los vehiculos.
	*/
	public void actualizarEstadoVehiculo(String latitud, String longitud) {
			
		this.setPosicionActual(latitud, longitud);
		
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		MapaDeRutaE mr = e.getMapaDeRuta();
		
		List<CoordenadaE> lista = mr.getCoordenadas();
		Boolean encontrado = false;
		
		for(CoordenadaE coord: mr.getCoordenadas()){
			if(posicionActual.getLatitud().equals(coord.getLatitud()) && posicionActual.getLongitud().equals(coord.getLongitud())){
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
		e.setPosicionActual(CoordenadaDao.getInstancia().getById(posicionActual.getIdCoordenada()));
		EnvioDao.getInstancia().saveOrUpdate(e);
	}
	
	public void estaEnvioDemorado(){
		
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		Date hoy = new Date();
		if(e.getFechaYHoraLlegadaEstimada().compareTo(hoy)<0){
			e.setEstado(EnvioEstado.Demorado.toString());
			EnvioDao.getInstancia().saveOrUpdate(e);
		}
	}

	
	
}
