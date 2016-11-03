package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;






import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Encomienda;


public abstract class Encomienda{

	protected int idEncomienda;
	protected Direccion direccionDestino;
	protected Sucursal sucursalDestno;
	protected Sucursal sucursalOrigen;
	protected Direccion direccionOrigen;
	protected Sucursal sucursalActual;
	protected Cliente cliente;

	protected Date fechaCreacion;
	protected Date fechaEstimadaEntrega;
	protected String estado;
	protected boolean tercerizado;
	protected float largo;
	protected float alto;
	protected float ancho;
	protected float peso;
	protected float volumen;
	protected String tratamiento;
	protected Boolean apilable;
	protected Short cantApilable;
	protected Boolean refrigerado;
	protected String condicionTransporte;
	protected String indicacionesManipulacion;
	protected String fragilidad;
	protected String nombreReceptor;
	protected String apellidoReceptor;
	protected String dniReceptor;
	protected float volumenGranel;
	protected String unidadGranel;
	protected String cargaGranel;

	protected ServicioSeguridad servicioSeguridad;
	protected Manifiesto manifiesto;
	protected Factura factura;
	protected Remito remito;
	protected boolean internacional;
	protected List<Envio> envios;
	
	public Encomienda() {
	}

	
	
	protected Encomienda(Direccion direccionDestino, Sucursal sucursalDestno,
			Sucursal sucursalOrigen, Direccion direccionOrigen,
			Sucursal sucursalActual, Cliente cliente, Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado, boolean tercerizado,
			float largo, float alto, float ancho, float peso, float volumen,
			String tratamiento, Boolean apilable, Short cantApilable,
			Boolean refrigerado, String condicionTransporte,
			String indicacionesManipulacion, String fragilidad,
			String nombreReceptor, String apellidoReceptor, String dniReceptor,
			float volumenGranel, String unidadGranel, String cargaGranel,
			ServicioSeguridad servicioSeguridad,
			Manifiesto manifiesto, 
			//Factura factura, Remito remito,
			boolean internacional) {
		super();
		this.direccionDestino = direccionDestino;
		this.sucursalDestno = sucursalDestno;
		this.sucursalOrigen = sucursalOrigen;
		this.direccionOrigen = direccionOrigen;
		this.sucursalActual = sucursalActual;
		this.cliente = cliente;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		this.tercerizado = tercerizado;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.volumen = volumen;
		this.tratamiento = tratamiento;
		this.apilable = apilable;
		this.cantApilable = cantApilable;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.indicacionesManipulacion = indicacionesManipulacion;
		this.fragilidad = fragilidad;
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.volumenGranel = volumenGranel;
		this.unidadGranel = unidadGranel;
		this.cargaGranel = cargaGranel;
		this.servicioSeguridad = servicioSeguridad;
		this.manifiesto = manifiesto;
		this.factura = factura;
		this.remito = remito;
		this.internacional = internacional;
	}



	public Encomienda(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
			Sucursal sucursalOrigen, Cliente cliente,
			Date fechaCreacion, Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			{
	//	this.itemFactura = itemFactura;
		this.sucursalDestno = sucursalDestino;
		//this.envio = envio;
		this.sucursalOrigen = sucursalOrigen;
		this.cliente = cliente;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		//this.tercerizado = tercerizado;
		//this.nombreReceptor = nombreReceptor;
	//	this.apellidoReceptor = apellidoReceptor;
	//	this.dniReceptor = dniReceptor;
	}

	public Integer asignarEnvio(Integer idCarrier) {
		
		/*antes de asignar busco encomiendas por vencer asi ya las pongo en viaje 
		 * y asi marco esos envios y vehiculos como no disponibles*/
		//ponerEnViajeEncomiendasPorVencer();
		
		EncomiendaE e = EncomiendaDao.getInstancia().getById(idEncomienda);
		System.out.println(e.toString());
		Integer idEnvio = null;
		if(e != null){
			if(esEnvioTercerizado()){ 
				EnvioE envioTercerizado = new EnvioE();
				if(e.isInternacional()){
					ProveedorE prov = ProveedorDao.getInstancia().getById(idCarrier);
					envioTercerizado.setProveedor(prov);
				}
				MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
				envioTercerizado.setNroTracking(2000);
				envioTercerizado.setSucursalOrigen(e.getSucursalOrigen());
				envioTercerizado.setSucursalDestino(e.getSucursalDestino());
				envioTercerizado.setFechaYHoraSalida(new Date());
				envioTercerizado.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
				envioTercerizado.setMapaDeRuta(mr);
				envioTercerizado.setPropio(false);
				List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
				lista.add(e);
				envioTercerizado.setEncomiendas(lista);
				e.setEstado(EncomiendaEstado.Colocada.toString());
				
				EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioTercerizado);;
				EncomiendaDao.getInstancia().saveOrUpdate(e);
				
				idEnvio = envio.getIdEnvio();
			} else {
				//Busco si ya hay algun envio que vaya a la misma ciudad y pendientes
				boolean nuevoEnvio = true;
				List<EnvioE> envios = EnvioDao.getInstancia().listarEnviosPorSucursalDestino(e.getSucursalDestino().getIdSucursal(), e.getFechaEstimadaEntrega());
				boolean pesoOK = false;
				boolean volumenOK = false;
				for(EnvioE envProp: envios){
					if(!pesoOK || !volumenOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
						//Sumo los pesos y los volumenes
						float peso = 0;
						float volumen = 0;
						float pesoTotal = envProp.getVehiculo().getPeso() - envProp.getVehiculo().getTara();
						float volumenTotal = envProp.getVehiculo().getVolumen();
						for(EncomiendaE enc: envProp.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
						
						//Verifico si entra el nuevo pedido
						if(pesoTotal >= peso + e.getPeso()){
							pesoOK = true;
						}
						if(volumenTotal >= volumen + e.getVolumen()){
							volumenOK = true;
						}
	
						if(pesoOK && volumenOK){ //lo asigno a este envio
							
							List<EncomiendaE> encomiendas = envProp.getEncomiendas();
							encomiendas.add(e);
							envProp.setEncomiendas(encomiendas);
							envProp.setPropio(true);
					
							float volumen70 = (float)(volumen + e.getVolumen()/volumenTotal);
							float peso70 = (float)(peso + e.getPeso()/pesoTotal);
							
							if(peso70 > 0.7 || volumen70 > 0.7){
								envProp.setEstado("Listo");
							}
						
							e.setEstado(EncomiendaEstado.Colocada.toString());
							
							EnvioDao.getInstancia().saveOrUpdate(envProp);
							EncomiendaDao.getInstancia().saveOrUpdate(e);
							nuevoEnvio = false;
							
							
							idEnvio =  envProp.getIdEnvio();
						} 
					}
				}//End loop
				
				//Es un nuevo envio por que no se encontro camion disponible
				if (nuevoEnvio){
					//Buscar Vehiculo para asignar que no pertezca a un envio en curso (<>Pendiente)
					List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(e.getSucursalOrigen().getIdSucursal(),  e.getVolumen(), e.getPeso());
					boolean pesoNuevoOK = false;
					boolean volumenNuevoOK = false;
					
					if(vehiculosDisponibles.size() == 0) {
						System.out.println("No hay vehículos disponibles para generar el envío");
					} else {
						for(VehiculoE v: vehiculosDisponibles){
							//Sumo los pesos y los volumenes
							if(!pesoNuevoOK || !volumenNuevoOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
								float pesoTotal = v.getPeso() - v.getTara();
								float volumenTotal = v.getVolumen();
								
								
								//Verifico si entra el nuevo pedido
								if(pesoTotal >= e.getPeso()){
									pesoNuevoOK = true;
								}
								if(volumenTotal >= e.getVolumen()){
									volumenNuevoOK = true;
								}
								if(pesoNuevoOK && volumenNuevoOK){ //lo asigno a este envio
									//Genero el envio
									
									MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
									
									EnvioE envioPropio = new EnvioE();
									envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									envioPropio.setFechaYHoraSalida(new Date());
									
									envioPropio.setPosicionActual(e.getSucursalActual().getCoordenadas());
									envioPropio.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
									envioPropio.setVehiculo(v);
									envioPropio.setPropio(true);
								
									envioPropio.setSucursalOrigen(e.getSucursalActual());
									envioPropio.setSucursalDestino(e.getSucursalDestino());
									envioPropio.setMapaDeRuta(mr);
									List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
									lista.add(e);
									envioPropio.setEncomiendas(lista);
									float volumen70 = (float)(e.getVolumen()/volumenTotal);
									float peso70 = (float)(e.getPeso()/pesoTotal);
									
									if(peso70 > 0.7 || volumen70 > 0.7){
										e.setEstado(EncomiendaEstado.Colocada.toString());
										envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									}
									
									EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioPropio);
									EncomiendaDao.getInstancia().saveOrUpdate(e);
									idEnvio =  envio.getIdEnvio();
								}
							}
						}//End for
					}
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
		

		/*Coloco las encomiendas en viaje y envio en viaje si hay encomiendas por vencer*/
//		ponerEnViajeEncomiendasPorVencer();
		
		return idEnvio;
	}
	
	
	public int getIdEncomienda() {
		return this.idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Direccion getDireccionDestino() {
		return this.direccionDestino;
	}

	public void setDireccionDestino(
			Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public Sucursal getSucursalDestino() {
		return this.sucursalDestno;
	}

	public void setSucursalDestino(
			Sucursal sucursalDestino) {
		this.sucursalDestno = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return this.sucursalOrigen;
	}

	public void setSucursalOrigen(
			Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Direccion getDireccionOrigen() {
		return this.direccionOrigen;
	}

	public void setDireccionOrigen(
			Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}


	public Sucursal getSucursalActual() {
		return this.sucursalActual;
	}

	public void setSucursalActual(Sucursal sucursalActual) {
		this.sucursalActual = sucursalActual;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstimadaEntrega() {
		return this.fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isTercerizado() {
		return this.tercerizado;
	}

	public void setTercerizado(boolean tercerizado) {
		this.tercerizado = tercerizado;
	}

	public float getLargo() {
		return this.largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAlto() {
		return this.alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return this.ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return this.volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Boolean getApilable() {
		return this.apilable;
	}

	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}

	public Short getCantApilable() {
		return this.cantApilable;
	}

	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
	}

	public Boolean getRefrigerado() {
		return this.refrigerado;
	}

	public void setRefrigerado(Boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public String getCondicionTransporte() {
		return this.condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public String getIndicacionesManipulacion() {
		return this.indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}

	public String getFragilidad() {
		return this.fragilidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public float getVolumenGranel() {
		return this.volumenGranel;
	}

	public void setVolumenGranel(float volumenGranel) {
		this.volumenGranel = volumenGranel;
	}

	public String getUnidadGranel() {
		return this.unidadGranel;
	}

	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}

	public String getCargaGranel() {
		return this.cargaGranel;
	}

	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}

	public Seguro getSeguro() {
		Seguro p = new Seguro();
		p.setTarifa(123.0F);
		p.setTarifaPorKm(456.0F);
		//TODO: revisar
		//p.setProveedor(ProveedorDao.getInstancia().getById(1));
		p.setProveedor(new Proveedor(1));
		return p;
	}

	public Sucursal getSucursalDestno() {
		return sucursalDestno;
	}

	public void setSucursalDestno(Sucursal sucursalDestno) {
		this.sucursalDestno = sucursalDestno;
	}

	public boolean isTerciarizado() {
		return tercerizado;
	}

	public void setTerciarizado(boolean terciarizado) {
		this.tercerizado = terciarizado;
	}

	public ServicioSeguridad getServicioSeguridad() {
		return servicioSeguridad;
	}

	public void setServicioSeguridad(ServicioSeguridad servicioSeguridad) {
		this.servicioSeguridad = servicioSeguridad;
	}

	public Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}

	@Override
	public String toString() {
		return "Encomienda [cliente=" + cliente.getIdCliente()
				+ ", fechaCreacion=" + fechaCreacion
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", estado=" + estado + ", tercerizado=" + tercerizado
				+ ", largo=" + largo + ", alto=" + alto + ", ancho=" + ancho
				+ ", peso=" + peso + ", volumen=" + volumen + ", tratamiento="
				+ tratamiento + ", apilable=" + apilable + ", cantApilable="
				+ cantApilable + ", refrigerado=" + refrigerado
				+ ", condicionTransporte=" + condicionTransporte
				+ ", indicacionesManipulacion=" + indicacionesManipulacion
				+ ", fragilidad=" + fragilidad + ", nombreReceptor="
				+ nombreReceptor + ", apellidoReceptor=" + apellidoReceptor
				+ ", dniReceptor=" + dniReceptor + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel + ", terciarizado=" + tercerizado +""
						+ " internacional +" + internacional + "]";
	}

	public boolean esEnvioTercerizado(){
		
		if(this.getVolumenGranel()!=0){
			return true;
		}
		if(this.isInternacional()){
			return true;
		}
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(this.getSucursalOrigen().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
		if(mr!=null){
			Date hoy = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoy);
			calendar.add(Calendar.HOUR, (int) mr.getDuracion());
			
			//Si tengo que enviarlo si o si hoy para que llegue y no hay vehiculos disponibles
			if(this.getFechaEstimadaEntrega().compareTo(calendar.getTime())==0 ){
				if(!hayVehiculosDisponibles()){
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}


	public boolean hayVehiculosDisponibles(){
		
		List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(this.getSucursalOrigen().getIdSucursal(),  
				this.getVolumen(), this.getPeso());
		boolean pesoOK = false;
		boolean volumenOK = false;
		
		for(VehiculoE v: vehiculosDisponibles){
			//Sumo los pesos y los volumenes
			if(!pesoOK || !volumenOK){ //si aun no se  encontro ya vehiculo
				float pesoTotal = v.getPeso() - v.getTara();
				float volumenTotal = v.getVolumen();
				float peso = 0;
				float volumen = 0;
				
				EnvioE envio = (EnvioE) EnvioDao.getInstancia().getByVehiculo(v.getIdVehiculo());
				if(envio!=null){
					if(envio.getEstado()==EnvioEstado.Pendiente.toString()){
						for(EncomiendaE enc: envio.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
					}
				}		
				//Verifico si entra el  pedido
				if(pesoTotal >= peso + this.getPeso()){
					pesoOK = true;
				}
				if(volumenTotal >= volumen + this.getVolumen()){
					volumenOK = true;
				}

				if(pesoOK && volumenOK){ 
					return true;
				}
			}
		}
		return false;
	}

	public List<EncomiendaE> getEncomiendasPendientesBySucursal(int idSucursal){
		//TODO: hacer
		return EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
	}
	
	//TODO: esto tiene que ir en Sucursal??????
	private List<VehiculoE> listarVehiculosDisponibles(int idSucursalOrigen, float volumen, float peso){

		List<VehiculoE> vehiculos = VehiculoDao.getInstancia().getPorVolumenPesoSucursalTareasRealizadas(idSucursalOrigen, peso, volumen);
		List<VehiculoE> vehiculosDisponibles = new ArrayList<VehiculoE>();
		
		for(VehiculoE vehiculo: vehiculos){
			GestionVehiculo gVehiculo = new GestionVehiculo(vehiculo);
			if(gVehiculo.estaUtilizable() && !gVehiculo.estaAsignado() && !gVehiculo.tieneTareasVencidas()){
				vehiculosDisponibles.add(gVehiculo.getVehiculo());
			}
		}
		
		return vehiculosDisponibles;
		
	}
}
