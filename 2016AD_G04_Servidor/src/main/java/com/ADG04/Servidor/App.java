package com.ADG04.Servidor;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ADG04.Negocio.*;
import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.*;
import com.ADG04.Servidor.rmi.DistribucionPaquetesRMI;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.*;
import com.ADG04.bean.Cliente.*;
import com.ADG04.bean.Encomienda.*;
import com.ADG04.bean.Proveedor.*;
import com.ADG04.bean.Vehiculo.*;


/**
 * Hello world!
 *
 */
public class App 
{

	public static void main(String[] args) throws IOException, BusinessException {
		Integer idEncomienda = AltaEncomiendaParticular();
		Encomienda enc = new Encomienda().fromEntity(EncomiendaDao.getInstancia().getById(idEncomienda));
		System.out.println("Fecha estimada entrega :");
		System.out.println(enc.getFechaEstimadaEntrega());
		
		//verificar que exista sucursal 3 con mapa de ruta de 1 a 3 y de 2 a 3
/*
 * IdMapaDeRuta	CantKm	costo	Duracion	IdSucursalDestino	IdSucursalOrigen
	1			1000	48		72				2					1
	1002		100		220		42				3					1
	1003		30		44		32				2					3
 * */
		int idEnvio = enc.asignarEnvio(null, 3);
		
		if(enc.existeDemoraEntrega(idEnvio)){
			System.out.println("Existe Demora");
		}
		
	}
	
	private static Integer AltaEncomiendaParticular() throws IOException, BusinessException {
		EncomiendaParticular enc = new EncomiendaParticular();
		enc.setAlto(100f);
		enc.setAncho(100f);
		enc.setApellidoReceptor("apellido");
		enc.setApilable(false);
		enc.setCliente(new Cliente().fromEntity(ClienteDao.getInstancia().getById(1)));
		enc.setCondicionTransporte("ninguna");
		enc.setDniReceptor("121212");
		enc.setEstado(EncomiendaEstado.Ingresada.toString());
		enc.setFechaCreacion(new Date());
		
		int idSucursalOrigen = 1;
		int idSucursalDestino = 2;
		enc.setSucursalActual(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalOrigen)));
		enc.setSucursalOrigen(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalOrigen)));
		enc.setSucursalDestino(new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalDestino)));
		
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(idSucursalOrigen, idSucursalDestino);
		
		Date fechaEstimadaEntrega = new MapaDeRuta().fromEntity(mr).calcularFechaEstimadaDeEntrega(); 
		enc.setFechaEstimadaEntrega(fechaEstimadaEntrega);
		enc.setIndicacionesManipulacion("");
		enc.setInternacional(false);
		enc.setLargo(100f);
		enc.setNombreReceptor("nombre");
		enc.setPeso(200f);
		enc.setRefrigerado(false);
		enc.setTratamiento("ninguno");
		enc.setTerciarizado(false);
		enc.setVolumen(200f);
		
		Manifiesto m = new Manifiesto();
		m.setFecha(new Date());
		ItemManifiesto im = new ItemManifiesto();
		im.setCantidad(10);
		im.setDescripcion("hola");
		im.setProducto(new Producto().fromEntity(ProductoDao.getInstancia().getById(4)));
		List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
		itemsManifiesto.add(im);
		m.setItemsManifiesto(itemsManifiesto);
		
		enc.setManifiesto(m);
		
		Integer idEncomienda =  enc.saveOrUpdate();
		
		return idEncomienda;
		
	}
	
/*	public static void main(String[] args) throws IOException {
		
		try {
		//	TestEncomienda();
			testControlViajes();
			
		} catch (Exception e) {
				e.printStackTrace();
		}	
		finally{
			System.exit(1);
		}
	}*/
	
//	
//    public static void main( String[] args ) throws IOException, NotBoundException
//    {
//    	DTO_Producto prod = new DTO_Producto();
//    	prod.setCategoria("a");
//    	prod.setCodigo("codigo");
//    	prod.setDescripcion("descr");
//    	prod.setIdCliente(1);
//    	prod.setUnidad("p");
//    	
//    	Producto p = new Producto().fromDTO(prod);
//    	p.guardar();
//    	
//    	System.exit(0);
//    }
//    
//    	private static void TestAltaCliente() {  	
//    	DTO_Direccion dir = new DTO_Direccion();
//    	
//    	PaisE pais = (PaisE) PaisDao.getInstancia().getById(1);
//    	ProvinciaE prov = (ProvinciaE) ProvinciaDao.getInstancia().getById(1);
//    	
//    	dir.setCalle("Una calle");
//    	dir.setCodigoPostal(1234);
//    	dir.setLocalidad("Capital Federal");
//    	dir.setNro(123);
//    	dir.setPais(new Pais().fromEntity(pais).toDTO());
//    	dir.setProvincia(new Provincia().fromEntity(prov).toDTO());
//    	
//    	DTO_ClienteParticular cliParticular = new DTO_ClienteParticular();
//    	
//    	cliParticular.setApellido("Guccione");
//    	cliParticular.setDni("32437264");
//		cliParticular.setEmail("vguccione@gmail.com");
//		cliParticular.setEstado(true);
//		cliParticular.setNombre("Vanesa");
//		cliParticular.setTelefono("1556932544");
//		cliParticular.setDireccion(dir);
//		
//		//GestionCliente.getInstancia().altaClienteParticular(cliParticular);
//    }
//	
//	public static void TestFacturaEncomiendaParticular(){
//		
//		System.out.println("---------------TestFacturaEncomiendaParticular--------------------");
//		
//		GestionEncomienda.getInstancia().facturarEncomiendaParticular(1);
//
//		System.out.println("Id de Factura generada:");
//		int idFactura = GestionEncomienda.getInstancia().getFacturaParticularByIdEncomienda(1);
//		System.out.println(idFactura);
//		
//		System.out.println("-------------------------------------------------------------------");
//	}
//	
//	public static Integer TestEncomienda(int idSucursalOrigen, int idSucursalDestino, String dniCliente, int nmro, float alto
//			,float peso, float volumen, float carga, int dias, float largo, float ancho) throws BusinessException, SecurityException, IOException{
//		
//		int idCliente = ClienteDao.getInstancia().getByDni(dniCliente).getIdCliente();
//		
//		DTO_ClienteParticular cli = new DTO_ClienteParticular();
//		cli.setDni(dniCliente);
//		cli.setId(idCliente);
//    	DTO_Sucursal sucursalOrigen = new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalOrigen)).toDTO();
//    	DTO_Sucursal sucursalDestino = new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalDestino)).toDTO();
//    	
//    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();
//
//		encomienda.setCliente(cli);
//		encomienda.setSucursalOrigen(sucursalOrigen);
//		encomienda.setSucursalDestino(sucursalDestino);
//		encomienda.setLargo(largo);	//123
//		encomienda.setAncho(ancho);	//123
//		
//		encomienda.setAlto(alto);//12.0f
//		encomienda.setPeso(peso); //430f
//		encomienda.setVolumen(volumen);	//44.5f
//		encomienda.setTratamiento("nada"); 
//		encomienda.setApilable(true);
//		encomienda.setCantApilable((short)2); 
//		encomienda.setRefrigerado(false);
//		encomienda.setCondicionTransporte(null); 
//		encomienda.setIndicacionesManipulacion(null);
//		encomienda.setFragilidad("no"); 
//		encomienda.setNombreReceptor("Alfredo"); 
//		encomienda.setApellidoReceptor("Receptor");
//		encomienda.setDniReceptor("99876543"); 
//		encomienda.setVolumenGranel(0f); 
//		encomienda.setUnidadGranel(null);
//		encomienda.setCargaGranel(null);	
//		
//		//se calcula dentro del create
//		//encomienda.setFechaEstimadaEntrega(GestionEncomienda.getInstancia().calcularFechaEstimadaDeEntrega(sucursalOrigen.getId(), sucursalDestino.getId()));
//		
//		DTO_Manifiesto manifiesto = new DTO_Manifiesto();
//		manifiesto.setFecha(new Date());
//		List<DTO_ItemManifiesto>items = new ArrayList<DTO_ItemManifiesto>();
//		DTO_ItemManifiesto item = new DTO_ItemManifiesto();
//		item.setCantidad(10);
//		item.setDescripcion("hola que tal ");
//		DTO_Producto producto = ProductoDao.getInstancia().getById(1).toDTO();
//		item.setProducto(producto);
//		
//		items.add(item);
//		manifiesto.setDetalle(items);
//		encomienda.setManifiesto(manifiesto);
//		
//		
//		DTO_Remito remito = new DTO_Remito();
//		remito.setApellidoReceptor("Apellido receptor");
//		remito.setNombreReceptor("Nombre receptor");
//		remito.setDniReceptor("12312321");
//		remito.setConformado(false);
//		remito.setFecha(new Date());
//		remito.setFechaEstimadaEntrega(new Date());
//		remito.setCondicionTransporte(encomienda.getCondicionTransporte());
//		remito.setIndicacionesManipulacion(encomienda.getIndicacionesManipulacion());
//		
//		List<DTO_ItemRemito>itemsr = new ArrayList<DTO_ItemRemito>();
//		DTO_ItemRemito itemr = new DTO_ItemRemito();
//		item.setCantidad(10);
//		item.setDescripcion("hola que tal remito");
//		DTO_Producto productor = ProductoDao.getInstancia().getById(1).toDTO();
//		itemr.setCantidad(10);
//		itemr.setProducto(productor);
//		itemr.setRemito(remito);
//		itemsr.add(itemr);
//		remito.setDetalle(itemsr);
//		
//		encomienda.setRemito(remito);
//		
//    	//GestionEncomienda.getInstancia().altaEncomiendaParticular(encomienda);
//		
//		int idEncomienda = new DistribucionPaquetesRMI().nuevaEncomiedaParticular(encomienda);
//		System.out.println(idEncomienda);
//		return idEncomienda;
//    }
//    
//	public static void testControlViajes() throws IOException, BusinessException{	
//
//		//Creo una encomienda particular
//		System.out.println("Crear encomienda");
//		Integer idEncomienda = TestEncomienda(1,2,"34242342",123,12,430,44.5f,123,1,123,123);
//		EncomiendaE enc = EncomiendaDao.getInstancia().getById(idEncomienda);
//		System.out.println("Encomienda id: " + idEncomienda);
//		System.out.println("Press key");
//		
//		
//		//Intento asignarla a un envío.
//		System.out.println("-------Asignar la encomienda "+enc.getIdEncomienda()+" a un envío------------");
//		
//		
//		//Direccion direccionDestino = new Direccion();
//	//	direccionDestino.setIdDireccion(enc.getDireccionDestino().getIdDireccion());
//
//		//Direccion direccionOrigen = new Direccion();
//		//direccionOrigen.setIdDireccion(enc.getDireccionOrigen().getIdDireccion());
//
//		EncomiendaParticular encomiendaNegocio = NewEncomienda(enc);
//		
//		Integer idEnvio = encomiendaNegocio.asignarEnvio(null); //;GestionEncomienda.getInstancia().asignarEnvio(enc.getIdEncomienda(), null);
//		if(idEnvio == null || idEnvio <= 0){
//			System.out.println("No se pudo generar el envío");
//		}
//		else {
//			EnvioE envioEntity = EnvioDao.getInstancia().getById(idEnvio);
//			System.out.println("Estado Inicial del Envio: "+envioEntity.getEstado()+". Envío " + idEnvio);
//			//System.in.read();
//			
//			/*Seguira en viaje*/
//			System.out.println("---------Seguira en viaje----------");
//			System.out.println("Estado del envio cuando sigue en curso");
//			
//			
//			//Proveedor proveedor = new Proveedor();
//			//proveedor.setIdProveedor(envioEntity.getProveedor().getIdProveedor());
//			MapaDeRuta mapaDeRuta = new MapaDeRuta();
//			mapaDeRuta.setIdMapaDeRuta(envioEntity.getMapaDeRuta().getIdMapaDeRuta());
//			
//			Vehiculo vehiculo = new Vehiculo();
//			vehiculo.setIdVehiculo(envioEntity.getVehiculo().getIdVehiculo());
//			
//			Sucursal sucursalOrigen = new Sucursal();
//			sucursalOrigen.setIdSucursal(enc.getSucursalOrigen().getIdSucursal());
//			
//			Sucursal sucursalDestino = new Sucursal();
//			sucursalDestino.setIdSucursal(enc.getSucursalDestino().getIdSucursal());
//			
//			Envio envio = new Envio(null, mapaDeRuta,
//					null, sucursalDestino,
//					sucursalOrigen, vehiculo, envioEntity.getEstado(),
//					envioEntity.getFechaYHoraLlegadaEstimada(), envioEntity.getFechaYHoraSalida(),
//					envioEntity.isPropio(), envioEntity.getNroTracking());
//			envio.setIdEnvio(envioEntity.getIdEnvio());
//			//busco una coordenada para probar
//			CoordenadaE ce = CoordenadaDao.getInstancia().getById(1);
//			envio.actualizarEstadoVehiculo(ce.getLatitud(), ce.getLongitud());
//			
//			System.out.println(envio.getEstado());
//			System.out.println("----------------------------------------");
//			////System.in.read();
//			
//			/*Se indicara desviado*/
//			/*System.out.println("---------------------------------------------------------------");
//			CoordenadaE coordAct = new CoordenadaE();
//			coordAct.setLatitud("54°35′59″S");
//			coordAct.setLongitud("48°22′55″O﻿");
//			CoordenadaE coord = CoordenadaDao.getInstancia().saveOrUpdate(coordAct);
//			System.out.println("---------Nueva coordenada: "+coord.getIdCoordenada()+"-------------------");
//			//System.in.read();*/
//			
//			//Desviado
//			System.out.println("-----------------------------------------");
//			System.out.println("Estado del envio cuando se pasan coordenadas fuera de su mapa de ruta:");
//			envio.actualizarEstadoVehiculo("54°35′59″S", "48°22′55″O﻿");
//			System.out.println(envio.getEstado());	
//			System.out.println("-------------------");
//			//System.in.read();		
//			System.out.println("");
//			
//			System.out.println("-----------------------------------------");
//			System.out.println("Estado del envio cuando se pasan nuevamente coordenadas fuera de su mapa de ruta:");
//			envio.actualizarEstadoVehiculo("54°35′59″S", "48°22′55″O﻿");
//			System.out.println(envio.getEstado());	
//			System.out.println("-------------------");
//			//System.in.read();		
//			System.out.println("");
//			
//			/*Se indicara demorado*/
//			System.out.println("-------Se indicara demorado------------");
//			System.out.println("Estado del envio cuando se chequea la fecha de llegada y la actual:");
//			envio.estaEnvioDemorado();
//			System.out.println("Envio llegando tarde: "+envio.getEstado());	
//			
//			System.out.println("");
//			System.out.println("-------------------------------------");
//			//System.in.read();
//		}
//		
//		sigueElTest();
//	}
//	
//	private static void sigueElTest() throws IOException, BusinessException {
//
//		System.out.println("----------------Otra encomienda---------------------");
//		int idEncomienda = TestEncomienda(1,2,"34242342",100,100f,430f,100f,0f,10, 123, 123);
//		EncomiendaE enc = EncomiendaDao.getInstancia().getById(idEncomienda);
//		System.out.println("-------------Encomienda:"+idEncomienda+"------------------------");
//		//System.in.read();
//
//		Encomienda encomiendaNegocio = NewEncomienda(enc);		
//			
//		System.out.println("---------------Le asigno envío----------------------");
//		Integer idEnvio2 = encomiendaNegocio.asignarEnvio(null); //GestionEncomienda.getInstancia().asignarEnvio(idEncomienda, null);
//
//		if(idEnvio2 == null || idEnvio2 <= 0){
//			System.out.println("No se pudo generar el envío");
//			return;
//		}
//		
//		System.out.println("-----------------Envío: "+idEnvio2+"--------------------");
//		//System.in.read();
//
//		Envio envio2 = GetEnvio(EnvioDao.getInstancia().getById(idEnvio2), encomiendaNegocio);
//		
//		/*Se indicara concluido*/
//		System.out.println("--------------Se indicara concluido-----------------------");
//		System.out.println("Estado del envio y su encomienda cuando llega a destino");
//		//GestionControlViajes.getInstancia().concluirEnvio(envio2.getIdEnvio());
//		envio2.concluirEnvio();
//		System.out.println("Estado del envio " + envio2.getEstado());
//		System.out.println("Estado de la encomienda: " + EncomiendaDao.getInstancia().getById(idEncomienda).getEstado());
//
//
//		System.out.println("------------------------Test finalizado!!!!------------------");
//		System.out.println("-------------------------------------------------------------");
//		
//		/*		
//		
//		EnvioDao.getInstancia().removeById(envio2.getIdEnvio());
//		EnvioDao.getInstancia().remove(EnvioDao.getInstancia().getById(idEnvio2));
//		EncomiendaDao.getInstancia().remove(enc);
//		EncomiendaDao.getInstancia().remove(EncomiendaDao.getInstancia().getById(encomiendaNegocio.getIdEncomienda()));
//
//*/
//		
//	}
//
//	private static Envio GetEnvio(EnvioE envioEntity, Encomienda enc) {
//
//		Sucursal sucursalOrigen = new Sucursal();
//		sucursalOrigen.setIdSucursal(enc.getSucursalOrigen().getIdSucursal());
//		
//		Sucursal sucursalDestino = new Sucursal();
//		sucursalDestino.setIdSucursal(enc.getSucursalDestino().getIdSucursal());
//		
//		//Proveedor proveedor = new Proveedor();
//		//proveedor.setIdProveedor(envioEntity.getProveedor().getIdProveedor());
//		MapaDeRuta mapaDeRuta = new MapaDeRuta();
//		mapaDeRuta.setIdMapaDeRuta(envioEntity.getMapaDeRuta().getIdMapaDeRuta());
//		
//		Vehiculo vehiculo = new Vehiculo();
//		vehiculo.setIdVehiculo(envioEntity.getVehiculo().getIdVehiculo());
//		
//		Envio envio = new Envio(null, mapaDeRuta,
//				null, sucursalDestino,
//				sucursalOrigen, vehiculo, envioEntity.getEstado(),
//				envioEntity.getFechaYHoraLlegadaEstimada(), envioEntity.getFechaYHoraSalida(),
//				envioEntity.isPropio(), envioEntity.getNroTracking());
//		envio.setIdEnvio(envioEntity.getIdEnvio());
//		
//		return envio;
//	}
//
//	private static EncomiendaParticular NewEncomienda(EncomiendaE enc) {
//		
//		//Cuando creo la encomienda, la sucursal actual es la misma que la de origen
//			Sucursal sucursalActual = new Sucursal();
//			sucursalActual.setIdSucursal(enc.getSucursalOrigen().getIdSucursal());
//			
//			Sucursal sucursalOrigen = new Sucursal();
//			sucursalOrigen.setIdSucursal(enc.getSucursalOrigen().getIdSucursal());
//			
//			Sucursal sucursalDestino = new Sucursal();
//			sucursalDestino.setIdSucursal(enc.getSucursalDestino().getIdSucursal());
//			
//			//Direccion direccionDestino = new Direccion();
//		//	direccionDestino.setIdDireccion(enc.getDireccionDestino().getIdDireccion());
//
//			//Direccion direccionOrigen = new Direccion();
//			//direccionOrigen.setIdDireccion(enc.getDireccionOrigen().getIdDireccion());
//
//			Cliente cliente = new Cliente();
//			cliente.setIdCliente(enc.getCliente().getIdCliente());
//			
//			ServicioSeguridad servicioSeg = null;
//			//servicioSeg.setIdServicioSeguridad(enc.getServicioSeguridad().getIdServicioSeguridad());
//			
//			Manifiesto manifiesto = new Manifiesto(enc.getManifiesto().getIdManifiesto(), enc.getManifiesto().getFecha());
//			
//			for (ItemManifiestoE item : enc.getManifiesto().getItemsManifiesto()) {
//				Producto producto = null;
//				
//				if(item.getProducto() != null){
//						producto = new Producto();
//						producto.setIdProducto(item.getProducto().getIdProducto());
//				}
//				
//				manifiesto.addItem(new ItemManifiesto(item.getDescripcion(), item.getCantidad(), producto)); 
//			}
//			
//			EncomiendaParticular encomiendaNegocio = 		
//					new EncomiendaParticular(null, sucursalDestino, sucursalOrigen, null, sucursalActual, cliente, 
//							enc.getFechaCreacion(), enc.getFechaEstimadaEntrega(), enc.getEstado(), enc.isTercerizado(), 
//							enc.getLargo(), enc.getAlto(), enc.getAncho(), enc.getPeso(), enc.getVolumen(), enc.getTratamiento(), 
//							enc.getApilable(), enc.getCantApilable(), enc.getRefrigerado(), enc.getCondicionTransporte(), 
//							enc.getIndicacionesManipulacion(), enc.getFragilidad(), enc.getNombreReceptor(), 
//							enc.getApellidoReceptor(), enc.getDniReceptor(), enc.getVolumenGranel(), enc.getUnidadGranel(), 
//							enc.getCargaGranel(), servicioSeg, manifiesto, enc.isInternacional());
//			encomiendaNegocio.setIdEncomienda(enc.getIdEncomienda());
//			
//			return encomiendaNegocio;
//	}
//
//	/*
//	 * Test varias encomiendas y tratar de asignarlas a envios.
//	 */
//	public static void testAsignarEnvios() throws IOException, BusinessException{
//		
//		/*encomienda con 70% peso de posible vehiculo 1 (unico con tareas de mantenimiento realizadas) */
//				
//		System.out.println("encomienda con 70% peso de posible - vehiculo 1 - (unico con tareas de mantenimiento realizadas)");
//		EncomiendaE enc = testEncomienda(1,2,1,100,100f,430f,100f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//		
//		EnvioE envio = new EnvioE();
//		Integer idEnvio = GestionEncomienda.getInstancia().asignarEnvio(enc.getIdEncomienda(), null);
//		
//		if(idEnvio != null) {
//			System.out.println("----Asignada al envío : "+idEnvio+"----------");
//			//System.in.read();
//			
//			envio = (EnvioE) EnvioDao.getInstancia().getById(idEnvio);
//			System.out.println("Encomienda con 70% del peso del vehiculo 1 que esta disponible");
//			System.out.println("Peso del Vehiculo: " + (envio.getVehiculo().getPeso() - envio.getVehiculo().getTara()));
//			System.out.println("Peso de la encomienda: " + enc.getPeso());
//			System.out.println("Envio creado para vehiculo "+ envio.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc.getEstado());
//			System.out.println(envio.toString());
//			System.out.println("------------------------------------");
//			
//			//EnvioDao.getInstancia().remove(envio);
//			//EncomiendaDao.getInstancia().remove(enc);
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//			System.out.println("---------------------------------------------------");
//		
//		}
//		
//		System.out.println("-----------------------------------------------------------------------------");
//		//System.in.read();
//		
//		/*Encomienda con 70% volumen de posible vehiculo 1 (unico con tareas de mantenimiento realizadas) */
//		System.out.println("Encomienda con 70% volumen de posible vehiculo 1 (unico con tareas de mantenimiento realizadas)");
//		//System.in.read();		
//		EncomiendaE enc2 = testEncomienda(1,2,1,100,100f,100f,2264f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc2.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();		
//		
//		EnvioE envio2 = new EnvioE();
//		Integer idEnvio2 = GestionEncomienda.getInstancia().asignarEnvio(enc2.getIdEncomienda(), null);
//		if(idEnvio2!=null){
//			System.out.println("----Asignada al envío : "+idEnvio2+"----------");
//			//System.in.read();
//		
//			envio2 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio2);
//			System.out.println("Encomienda con 70% del volumen del vehiculo 1 que esta disponible");
//			System.out.println("Volumen del Vehiculo: " + envio2.getVehiculo().getVolumen());
//			System.out.println("Volumen de la encomienda: " + enc2.getVolumen());
//			System.out.println("Envio creado para vehiculo "+ envio2.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio2.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio2.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio2.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc2.getEstado());
//			//System.out.println(envio.toString());
//			
//			EnvioDao.getInstancia().remove(envio2);
//			EncomiendaDao.getInstancia().remove(enc2);
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//		}
//		
//		System.out.println("-----------------------------------------------------------------------------");
//		//System.in.read();		
//		
//		/*Varias encomiendas asignadas hasta ocupar maximo peso*/
//		System.out.println("Varias encomiendas asignadas hasta ocupar maximo peso");
//		EncomiendaE enc3 = testEncomienda(1,2,1,100,100f,100f,100f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc3.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//		
//		EnvioE envio3 = new EnvioE();
//		Integer idEnvio3 = GestionEncomienda.getInstancia().asignarEnvio(enc3.getIdEncomienda(), null);
//		
//		if(idEnvio3!=null){
//			System.out.println("----Asignada al envío : "+idEnvio3+"----------");
//			//System.in.read();
//
//			envio3 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio3);
//			System.out.println("Encomienda con peso = 100");
//			System.out.println("Peso del Vehiculo: " + (envio3.getVehiculo().getPeso() - envio3.getVehiculo().getTara()));
//			System.out.println("Peso de la encomienda: " + enc3.getPeso());
//			System.out.println("Envio creado para vehiculo "+ envio3.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio3.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio3.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio3.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc3.getEstado());
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//		}
//					
//		System.out.println("--------------------------------------------------------------------");
//		//System.in.read();
//		
//		EncomiendaE enc4 = testEncomienda(1,2,1,100,100f,200f,100f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc4.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//
//		EnvioE envio4 = new EnvioE();
//		Integer idEnvio4 = GestionEncomienda.getInstancia().asignarEnvio(enc4.getIdEncomienda(), null);
//		if(idEnvio4!=null){
//			System.out.println("----Asignada al envío : "+idEnvio4+"----------");
//			//System.in.read();
//
//			envio4 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio4);
//			System.out.println("Encomienda con peso = 200");
//			System.out.println("Peso del Vehiculo: " + (envio4.getVehiculo().getPeso() - envio4.getVehiculo().getTara()));
//			System.out.println("Peso de la encomienda: " + enc4.getPeso());
//			System.out.println("Envio creado para vehiculo "+ envio4.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio4.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio4.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio4.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc4.getEstado());
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//		}
//		
//			
//		System.out.println("--------------------------------------------------------------------");
//		//System.in.read();		
//		
//		EncomiendaE enc5 = testEncomienda(1,2,1,100,100f,300f,100f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc5.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//
//		Integer idEnvio5 = GestionEncomienda.getInstancia().asignarEnvio(enc5.getIdEncomienda(), null);
//		EnvioE envio5 = new EnvioE();
//		if(idEnvio5!=null){
//			System.out.println("----Asignada al envío : "+idEnvio5+"----------");
//			//System.in.read();
//
//			envio5 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio5);
//			System.out.println("Encomienda con peso = 300");
//			System.out.println("Peso del Vehiculo: " + (envio5.getVehiculo().getPeso() - envio5.getVehiculo().getTara()));
//			System.out.println("Peso de la encomienda: " + enc5.getPeso());
//			System.out.println("Envio creado para vehiculo "+ envio5.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio5.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio5.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio5.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc5.getEstado());
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//		}
//		
//		System.out.println("--------------------------------------------------------------------");
//		//System.in.read();		
//		
//		EncomiendaE enc6 = testEncomienda(1,2,1,100,100f,200f,100f,0f,10);
//		System.out.println("----Nueva encomienda: "+enc6.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//
//		EnvioE envio6 = new EnvioE();
//		Integer idEnvio6 = GestionEncomienda.getInstancia().asignarEnvio(enc6.getIdEncomienda(), null);
//		if(idEnvio6 != null){
//			System.out.println("----Asignada al envío : "+idEnvio6+"----------");
//			//System.in.read();
//
//
//			envio6 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio6);
//			System.out.println("Encomienda con peso = 200");
//			System.out.println("Peso del Vehiculo: " + (envio6.getVehiculo().getPeso() - envio6.getVehiculo().getTara()));
//			System.out.println("Peso de la encomienda: " + enc6.getPeso());
//			System.out.println("Envio creado para vehiculo "+ envio6.getVehiculo().getIdVehiculo());
//			System.out.println("sucursal origen:  "+ envio6.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio6.getSucursalDestino().getDescripcion());
//			System.out.println("estado :  "+ envio6.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc6.getEstado());
//		}
//		else{
//			System.out.println("Encomienda con peso = 200");
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//			}
//		
//		System.out.println("-----------------------------------------------------------------------------------");
//		//System.in.read();		
//		/*
//		EnvioDao.getInstancia().remove(envio3);
//		EnvioDao.getInstancia().remove(envio6);
//		EncomiendaDao.getInstancia().remove(enc3);
//		EncomiendaDao.getInstancia().remove(enc4);
//		EncomiendaDao.getInstancia().remove(enc5);
//		EncomiendaDao.getInstancia().remove(enc6);
//		*/	
//		
//		
//		/*verificar metodo esEnvioTercerizado
//		 * para encomienda con volumen granel
//		 * y para encomienda que vence si no se manda ya*/
//		
//		System.out.println("-----------------------------------------------------------------------------------");
//		System.out.println("verificar metodo esEnvioTercerizado");
//		System.out.println("para encomienda con volumen granel");
//		System.out.println("y para encomienda que vence si no se manda ya");
//		EncomiendaE enc7 = testEncomienda(1,2,1,100,100f,200f,100f,200f,10);
//		System.out.println("----Nueva encomienda: "+enc7.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//		
//		EnvioE envio7 = new EnvioE();
//		Integer idEnvio7 = GestionEncomienda.getInstancia().asignarEnvio(enc7.getIdEncomienda(), null);
//		if(idEnvio7 != null){
//			System.out.println("----Asignada al envío : "+idEnvio7+"----------");
//			//System.in.read();
//
//			envio7 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio7);
//			System.out.println("Encomienda Tercerizada, con volumen granel "+ enc7.getVolumenGranel());
//			System.out.println("sucursal origen:  "+ envio7.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio7.getSucursalDestino().getDescripcion());
//			System.out.println("estado :  "+ envio7.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc7.getEstado());
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//		}
//				
//		System.out.println("-----------------------------------------------------------------------------------");
//		//System.in.read();		
//
//		//EnvioDao.getInstancia().remove(envio7);
//		//EncomiendaDao.getInstancia().remove(enc7);
//
//
//		EncomiendaE enc8 = testEncomienda(1,2,1,100,100f,200f,100f,200f,1);
//
//		System.out.println("----Nueva encomienda: "+enc8.getIdEncomienda()+". Se intentará asignar a un envío----------");
//		//System.in.read();
//		EnvioE envio8 = new EnvioE();
//		Integer idEnvio8 = GestionEncomienda.getInstancia().asignarEnvio(enc8.getIdEncomienda(), null);
//		if(idEnvio8 != null){
//			System.out.println("----Asignada al envío : "+idEnvio8+"----------");
//			//System.in.read();
//
//			envio8 = (EnvioE) EnvioDao.getInstancia().getById(idEnvio8);
//			System.out.println("Encomienda Tercerizada con fecha estimada de entrega: "+ enc8.getFechaEstimadaEntrega());
//			System.out.println("sucursal origen:  "+ envio8.getSucursalOrigen().getDescripcion());
//			System.out.println("sucursal destino:  "+ envio8.getSucursalDestino().getDescripcion());
//			System.out.println("estado envio:  "+ envio8.getEstado());
//			System.out.println("Encomienda tiene estado :  "+ enc8.getEstado());
//		}
//		else{
//			System.out.println("No se pudo asignar la encomienda a un envio.");
//			}
//		System.out.println("-----------------------------------------------------------------------------------");
//		//System.in.read();		
//
//	//	EnvioDao.getInstancia().remove(envio8);
//	//	EncomiendaDao.getInstancia().remove(enc8);
//		
//	}
//	
//	
//	/*
//	 * Crear encomienda particular.
//	 * Fecha de recepcion: hoy + días por parámtro.
//	 */
//	public static EncomiendaE testEncomienda(int idSucursalOrigen, int idSucursalDestino, int idCliente, int nmro, float alto
//			,float peso, float volumen, float carga, int dias) throws BusinessException, SecurityException, IOException{
//				
//		float nro = nmro;
//		DTO_ClienteParticular cli = new DTO_ClienteParticular();
//		cli.setId(idCliente);
//    	DTO_Sucursal sucursalOrigen = new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalOrigen)).toDTO();
//    	DTO_Sucursal sucursalDestino = new Sucursal().fromEntity(SucursalDao.getInstancia().getById(idSucursalDestino)).toDTO();
//    	
//    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();
//
//		encomienda.setCliente(cli);
//		encomienda.setSucursalActual(sucursalOrigen);
//		encomienda.setSucursalOrigen(sucursalOrigen);
//		encomienda.setSucursalDestino(sucursalDestino);
//		encomienda.setLargo(nro);
//		encomienda.setAncho(nro);
//			
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date()); // Configuramos la fecha que se recibe
//		calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
//		Date fecha = calendar.getTime();
//		encomienda.setFechaEstimadaEntrega(fecha);
//		
//		encomienda.setAlto(alto);
//		encomienda.setPeso(peso);
//		encomienda.setVolumen(volumen);
//		encomienda.setTratamiento("nada"); 
//		encomienda.setApilable(true);
//		encomienda.setCantApilable((short)2); 
//		encomienda.setRefrigerado(false);
//		encomienda.setCondicionTransporte(null); 
//		encomienda.setIndicacionesManipulacion(null);
//		encomienda.setFragilidad("no"); 
//		encomienda.setNombreReceptor("Alfredo"); 
//		encomienda.setApellidoReceptor("Receptor");
//		encomienda.setDniReceptor("99876543"); 
//		encomienda.setVolumenGranel(carga); 
//		encomienda.setUnidadGranel(null);
//		if(carga>0)
//			encomienda.setCargaGranel("Carga Granel");	
//		
//		//EncomiendaE enc = GestionEncomienda.getInstancia().crearEncomiendaParticular(encomienda);
//		
//		int idEncomienda = new DistribucionPaquetesRMI().nuevaEncomiedaParticular(encomienda);
//		System.out.println(idEncomienda);
//			
//		return EncomiendaDao.getInstancia().getById(idEncomienda);
//	}
	
	
	
}
