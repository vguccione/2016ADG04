package com.ADG04.Negocio;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.CarrierDao;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ItemFacturaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.ItemFactura;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;

//Gestion Encomienda	
public class GestionEncomienda {
	
	private static GestionEncomienda instancia;
		
	private EntityManagerFactory factory;
	
	private GestionEncomienda(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionEncomienda getInstancia(){
		if(instancia == null){
			instancia = new GestionEncomienda();
		} 
		return instancia;
	}

	public void altaEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		Sucursal origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		Sucursal destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		Cliente cli = ClienteDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		Encomienda encomienda = new Encomienda();
		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		
		encomienda.setAlto(dtoEncomienda.getAlto());
		encomienda.setPeso(dtoEncomienda.getPeso());
		encomienda.setVolumen(dtoEncomienda.getVolumen());
		encomienda.setTratamiento(dtoEncomienda.getTratamiento()); 
		encomienda.setApilable(dtoEncomienda.getApilable());
		encomienda.setCantApilable(dtoEncomienda.getCantApilable()); 
		encomienda.setRefrigerado(dtoEncomienda.getRefrigerado());
		encomienda.setCondicionTransporte(dtoEncomienda.getCondicionTransporte()); 
		encomienda.setIndicacionesManipulacion(dtoEncomienda.getIndicacionesManipulacion());
		encomienda.setFragilidad(dtoEncomienda.getFragilidad()); 
		encomienda.setNombreReceptor(dtoEncomienda.getNombreReceptor()); 
		encomienda.setApellidoReceptor(dtoEncomienda.getApellidoReceptor());
		encomienda.setDniReceptor(dtoEncomienda.getDniReceptor()); 
		encomienda.setVolumenGranel(dtoEncomienda.getVolumenGranel()); 
		encomienda.setUnidadGranel(dtoEncomienda.getUnidadGranel());
		encomienda.setCargaGranel(dtoEncomienda.getCargaGranel());		
		encomienda.setTipoEncomienda("P");//Encomeinda partiular
		
		encomienda.setTercerizado(this.esTercerizada(encomienda));
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		EncomiendaDao.getInstancia().persist(encomienda);
		
		// TODO
/*		DTO_Manifiesto dtoM = encomienda.getManifiesto();
		if(dtoM != null){
			Entity_Manifiesto m = new Entity_Manifiesto();
			m.setCategoria(dtoM.getCategoria());
			m.setOtro(dtoM.getOtro());
			m.setFecha(dtoM.getFecha());
			m.setDescripcion(dtoM.getDescripcion());
			m.setArchivo(dtoM.getArchivo());
			
			e.setManifiesto(m);
		}
	*/	
		
		tx.commit();
		
		
	}

	public void facturarEncomiendaParticular(int idEncomienda){
		
		List<ItemFactura>  detalle = new ArrayList<ItemFactura>();
		
		Encomienda encomienda = EncomiendaDao.getInstancia().getById(idEncomienda);
		
		//Calculo la primer linea de la factura - El valor del transporte
		float kilometros = encomienda.getKMs();
		float costoPorKm = encomienda.getCostoPorKm();

		List<ItemFactura> items = new ArrayList<ItemFactura>();

		//Costo por Km
		ItemFactura itemTransporte = new ItemFactura();
		itemTransporte.setDescripcion("Transporte: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(calcularPrecio(encomienda));
		items.add(itemTransporte);
						
		//Segunda Linea Seguros
		Seguro pSeguro = encomienda.getSeguro();
		if(pSeguro != null){
			ItemFactura itemSeguro = new ItemFactura();
			itemSeguro.setDescripcion("Seguro: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
			itemSeguro.setCantidad(1);
			itemSeguro.setValor((float)(pSeguro.getTarifa() + (pSeguro.getTarifaPorKm() * kilometros)));
			items.add(itemSeguro);
		}
				
		//TODO Tercer Linea Servicioo Seguridad
		/*Entity_ServicioSeguridad ss = encomienda.getServicioSeguridad();
		if(ss != null){
			Entity_DetalleFacturaCliente d3 = new Entity_DetalleFacturaCliente();
			d3.setLinea(linea);
			d3.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());	
			d3.setSubtotal(ss.getTarifa());
			
			costo =+ ss.getTarifa();
			linea++;
			
			costoTotal = costoTotal + costo;
			detalle.add(d3);
		}*/
		
		//TODO: impuestos??????????Cuarta Linea Impueestos
	/*	costo = (float) (costoTotal * 0.21);
		Entity_DetalleFacturaCliente d4 = new Entity_DetalleFacturaCliente();
		d4.setLinea(linea);
		d4.setDescripcion("IVA 21%");	
		d4.setSubtotal(costo);
		
		costoTotal = costoTotal + costo;
		linea++;
		detalle.add(d4);
		*/
	
		Factura factura = new Factura();
		factura.setFecha(new Date());
		factura.setPagada(false);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		factura.setVencimiento(c.getTime());
		//factura.setItemFacturas(items);
						
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//guardo la factura
		FacturaDao.getInstancia().persist(factura);
		
		//guardo los items
		for(ItemFactura item:items){
			item.setFactura(factura);
			ItemFacturaDao.getInstancia().persist(item);
		}
		
		//actualizo la encomienda
		encomienda.setFactura(factura);
		EncomiendaDao.getInstancia().persist(encomienda);
		
		tx.commit();
	}
	
	private float calcularPrecio(Encomienda encomienda) {
		// TODO Auto-generated method stub
		return 23;
	}

	private boolean esTercerizada(Encomienda encomienda) {
		// TODO armar logica que determina si va por camion de tercero
		return false;
	}

	public int getFacturaParticularByIdEncomienda(int idEncomienda) {

		return EncomiendaDao.getInstancia().getById(idEncomienda).getFactura().getIdFactura();
		
	}
	
	public Integer asignarEnvio(Integer idEncomienda, Integer idCarrier){
		Encomienda e = EncomiendaDao.getInstancia().getById(idEncomienda);
		if(e != null){
			if(e.isTercerizado()){ 
				Envio envioTercerizado = new Envio();
				Carrier prov = CarrierDao.getInstancia().getById(idCarrier);
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
				envioTercerizado.setProveedor(prov);
				envioTercerizado.setNroTracking(2000);
				envioTercerizado.setSucursalOrigen(e.getSucursalOrigen());
				envioTercerizado.setSucursalDestino(e.getSucursalDestino());
				List<Encomienda> lista = new ArrayList<Encomienda>();
				lista.add(e);
				envioTercerizado.setEncomiendas(lista);
							
				Envio envio = EnvioDao.getInstancia().saveOrUpdate(envioTercerizado);;
				
				return envio.getIdEnvio();
			} else {
				//Busco si ya hay algun envio que vaya a la misma ciudad
				boolean nuevoEnvio = true;
				List<Vehiculo> vehiculos = VehiculoDao.getInstancia().listarVehiculosEnvios(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal(), e.getVolumen(), e.getPeso());
				for(Vehiculo v: vehiculos){
					
					Envio envProp = EnvioDao.getInstancia().getByVehiculo(v.getIdVehiculo());
					
					//Sumo los pesos y los volumenes
					boolean pesoOK = false;
					boolean volumenOK = false;
					float peso = 0;
					float volumen = 0;
					float pesoTotal = v.getPeso() - v.getTara();
					float volumenTotal = v.getVolumen();
					for(Encomienda enc: envProp.getEncomiendas()){
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
						
						List<Encomienda> encomiendas = envProp.getEncomiendas();
						encomiendas.add(e);
						envProp.setEncomiendas(encomiendas);
				
						float volumen70 = (float)(volumen + e.getVolumen()/volumenTotal);
						float peso70 = (float)(peso + e.getPeso()/pesoTotal);
						
						if(peso70 > 0.7 || volumen70 > 0.7){
							envProp.setEstado("Listo");
						}
						
						e.setEstado(EncomiendaEstado.Colocada.toString());
						
						EnvioDao.getInstancia().saveOrUpdate(envProp);
						EncomiendaDao.getInstancia().saveOrUpdate(e);
						nuevoEnvio = false;
						
						
						return envProp.getIdEnvio();
					} 
				}//End loop
				
				//Es un nuevo envio por que no se encontro camion disponible
				if (nuevoEnvio){
					//Buscar Vehiculo para asignar
					List<Vehiculo> vehiculosDisponibles = VehiculoDao.getInstancia().listarVehiculosDisponibles(e.getSucursalOrigen().getIdSucursal(),  e.getVolumen(), e.getPeso());
					for(Vehiculo v: vehiculosDisponibles){
						//Sumo los pesos y los volumenes
						boolean pesoOK = false;
						boolean volumenOK = false;
						float pesoTotal = v.getPeso() - v.getTara();
						float volumenTotal = v.getVolumen();
						
						
						//Verifico si entra el nuevo pedido
						if(pesoTotal >= e.getPeso()){
							pesoOK = true;
						}
						if(volumenTotal >= e.getVolumen()){
							volumenOK = true;
						}
						if(pesoOK && volumenOK){ //lo asigno a este envio
							//Genero el envio
										
							Envio envioPropio = new Envio();
							envioPropio.setEstado(EnvioEstado.Pendiente.toString());
							envioPropio.setFechaYHoraSalida(new Date());
							envioPropio.setPosicionActual(e.getSucursalActual().getCoordenadas());
							envioPropio.setFechaYHoraLlegadaEstimada(null);
							envioPropio.setVehiculo(v);
							envioPropio.setSucursalDestino(e.getSucursalDestino());
							List<Encomienda> lista = new ArrayList<Encomienda>();
							lista.add(e);
							envioPropio.setEncomiendas(lista);
							float volumen70 = (float)(e.getVolumen()/volumenTotal);
							float peso70 = (float)(e.getPeso()/pesoTotal);
							
							if(peso70 > 0.7 || volumen70 > 0.7){
								e.setEstado(EncomiendaEstado.Colocada.toString());
							}
							
							Envio envio = EnvioDao.getInstancia().saveOrUpdate(envioPropio);
							EncomiendaDao.getInstancia().saveOrUpdate(e);
							return envio.getIdEnvio();
						}
					}//End for
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
		
		/*Coloco el vehiculo como completo y listo para salir si hay encomiendas por vencer*/
		List<Encomienda> encomiendasColocadasPorVencer = EncomiendaDao.getInstancia().obtenerEncomiendasColocadasPorVencerHoy();
		for(Encomienda enc : encomiendasColocadasPorVencer){
		      enc.setEstado(EncomiendaEstado.EnViaje.toString());
		      enc.getEnvio().setEstado(EnvioEstado.VehiculoCompleto.toString());    
		}
		return null;
	}
	
	
	
}
