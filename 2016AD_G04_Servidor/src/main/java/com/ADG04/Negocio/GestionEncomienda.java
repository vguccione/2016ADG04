package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.CarrierDao;
import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.ItemFactura;
import com.ADG04.Servidor.model.ItemManifiesto;
import com.ADG04.Servidor.model.ItemRemito;
import com.ADG04.Servidor.model.Manifiesto;
import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.Producto;
import com.ADG04.Servidor.model.Remito;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_Remito;


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

	public Envio getInfoEnvio(int idEnvio){
		return EnvioDao.getInstancia().getById(idEnvio);
	}
	
	public void altaEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		Sucursal origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		Sucursal destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		Cliente cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		Encomienda encomienda = new Encomienda();
		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		encomienda.setInternacional(dtoEncomienda.isInternacional());
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
		encomienda.setTipoEncomienda("P");
		
		encomienda.setTercerizado(dtoEncomienda.isTercerizada());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
		encomienda.setFechaEstimadaEntrega(dtoEncomienda.getFechaEstimadaEntrega());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		DTO_Manifiesto dtoM = dtoEncomienda.getManifiesto();
		if(dtoM != null){
			Manifiesto m = new Manifiesto();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiesto im = new ItemManifiesto();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
					im.setProducto(prod);
					im.setManifiesto(m);
					itemsManifiesto.add(im);
				}
			}
			m.setItemsManifiesto(itemsManifiesto);
			
			encomienda.setManifiesto(m);
		}
		
		DTO_Remito dtoR = dtoEncomienda.getRemito();
		if(dtoR != null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemito ir = new ItemRemito();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
	}
	
	public Encomienda crearEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		Sucursal actual = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalActual().getId());
		Sucursal origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		Sucursal destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		Cliente cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		Encomienda encomienda = new Encomienda();
		encomienda.setCliente(cli);
		encomienda.setSucursalActual(actual);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		encomienda.setInternacional(dtoEncomienda.isInternacional());
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
		encomienda.setTipoEncomienda("P");
		//encomienda.setFechaEstimadaEntrega(dtoEncomienda.getFechaEstimadaEntrega());
		encomienda.setFechaEstimadaEntrega(dtoEncomienda.getFechaEstimadaEntrega());
		//encomienda.setFechaEstimadaEntrega(calcularFechaEstimadaDeEntrega(
		//		dtoEncomienda.getSucursalOrigen().getId(),	dtoEncomienda.getSucursalDestino().getId()));
		encomienda.setTercerizado(dtoEncomienda.isTercerizada());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		DTO_Manifiesto dtoM = dtoEncomienda.getManifiesto();
		if(dtoM != null){
			Manifiesto m = new Manifiesto();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiesto im = new ItemManifiesto();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
					im.setProducto(prod);
					im.setManifiesto(m);
					itemsManifiesto.add(im);
				}
			}
			m.setItemsManifiesto(itemsManifiesto);
			
			encomienda.setManifiesto(m);
		}
		
		DTO_Remito dtoR = dtoEncomienda.getRemito();
		if(dtoR != null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemito ir = new ItemRemito();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		Encomienda enc = EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
		return enc;
		
	}

	public void modificarEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		Sucursal origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		Sucursal destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		Cliente cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		Encomienda encomienda = new Encomienda();
		
		encomienda.setIdEncomienda(dtoEncomienda.getIdEncomienda());
		
		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		encomienda.setInternacional(dtoEncomienda.isInternacional());
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
		encomienda.setTipoEncomienda("P");
		
		encomienda.setTercerizado(dtoEncomienda.isTercerizada());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		DTO_Manifiesto dtoM = dtoEncomienda.getManifiesto();
		if(dtoM != null){
			Manifiesto m = new Manifiesto();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiesto im = new ItemManifiesto();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
					im.setProducto(prod);
					im.setManifiesto(m);
					itemsManifiesto.add(im);
				}
			}
			m.setItemsManifiesto(itemsManifiesto);
			
			encomienda.setManifiesto(m);
		}
		
		DTO_Remito dtoR = dtoEncomienda.getRemito();
		if(dtoR != null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemito ir = new ItemRemito();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
	}
	
	public void facturarEncomiendaParticular(int idEncomienda){
		
		Encomienda encomienda = EncomiendaDao.getInstancia().getById(idEncomienda);
		
		//Calculo la primer linea de la factura - El valor del transporte lo define la cantidad de km y el costo
		//que se obtiene del mapa de ruta. 
		Sucursal sucursalOrigen =encomienda.getSucursalOrigen();
		Sucursal sucursalDestino=encomienda.getSucursalDestino();
		float kilometros =MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCantKm();
		float costo = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCosto();

		List<ItemFactura> items = new ArrayList<ItemFactura>();

		//Costo por Km
		ItemFactura itemTransporte = new ItemFactura();
		itemTransporte.setDescripcion("Transporte: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(costo);
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
				
		//Tercer Linea Servicio Seguridad
		ServicioSeguridad ss = encomienda.getServicioSeguridad();
		if(ss != null){
			ItemFactura itemSeguridad = new ItemFactura();
			itemSeguridad.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());
			itemSeguridad.setCantidad(1);
			itemSeguridad.setValor((float)(ss.getTarifa()));
			items.add(itemSeguridad);
		}
	
		//Cuarta Linea Impueestos
		ItemFactura itemImpuesto = new ItemFactura();
		itemImpuesto.setDescripcion("IVA 21%");
		itemImpuesto.setCantidad(1);
		float costoTotal = (float) (this.calcularPrecioTotal(encomienda) * 0.21);
		itemImpuesto.setValor(costoTotal);
		items.add(itemImpuesto);
		
		Factura factura = new Factura();
		factura.setFecha(new Date());
		factura.setPagada(false);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		factura.setVencimiento(c.getTime());
		
		
		//almaceno los items
		for(ItemFactura item:items){
			item.setFactura(factura);
		}
		
		factura.setItemsFactura(items);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//actualizo la encomienda
		encomienda.setFactura(factura);
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		
		tx.commit();
	}
	
	private float calcularPrecioTotal(Encomienda encomienda) {
		Factura factura = FacturaDao.getInstancia().getById(encomienda.getFactura().getIdFactura());
		float costoTotal=0;
		for(ItemFactura item: factura.getItemsFactura()){
			costoTotal =+ item.getValor();
		}
		return costoTotal;
	}


	public int getFacturaParticularByIdEncomienda(int idEncomienda) {

		return EncomiendaDao.getInstancia().getById(idEncomienda).getFactura().getIdFactura();
		
	}
	
	
	public void altaEncomiendaEmpresa(DTO_EncomiendaEmpresa dtoEncomienda) {
		Direccion origen = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionOrigen().getIdDireccion());
		Direccion destino = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionDestino().getIdDireccion());
		
		Cliente cli = ClienteEmpresaDao.getInstancia().getById(dtoEncomienda.getEmpresa().getId());
				
		Encomienda encomienda = new Encomienda();
		encomienda.setCliente(cli);
		encomienda.setDireccionDestino(destino);
		encomienda.setDireccionOrigen(origen);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		encomienda.setInternacional(dtoEncomienda.isInternacional());
		
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
		encomienda.setTipoEncomienda("E");
		
		encomienda.setTercerizado(dtoEncomienda.isTercerizada());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		DTO_Manifiesto dtoM = dtoEncomienda.getManifiesto();
		if(dtoM != null){
			Manifiesto m = new Manifiesto();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiesto im = new ItemManifiesto();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
					im.setProducto(prod);
					im.setManifiesto(m);
					itemsManifiesto.add(im);
				}
			}
			m.setItemsManifiesto(itemsManifiesto);
			
			encomienda.setManifiesto(m);
		}
		
		DTO_Remito dtoR = dtoEncomienda.getRemito();
		if(dtoR != null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemito ir = new ItemRemito();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
	}
	
	
	public void modificarEncomiendaEmpresa(DTO_EncomiendaEmpresa dtoEncomienda) {
		Direccion origen = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionOrigen().getIdDireccion());
		Direccion destino = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionDestino().getIdDireccion());
		Cliente cli = ClienteEmpresaDao.getInstancia().getById(dtoEncomienda.getEmpresa().getId());
				
		Encomienda encomienda = new Encomienda();
	
		encomienda.setIdEncomienda(dtoEncomienda.getIdEncomienda());
	
		encomienda.setCliente(cli);
		encomienda.setDireccionDestino(destino);
		encomienda.setDireccionOrigen(origen);
		encomienda.setLargo(dtoEncomienda.getLargo());
		encomienda.setAncho(dtoEncomienda.getAncho());
		encomienda.setInternacional(dtoEncomienda.isInternacional());
		
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
		encomienda.setTipoEncomienda("E");
		
		encomienda.setTercerizado(dtoEncomienda.isTercerizada());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
					
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		
		DTO_Manifiesto dtoM = dtoEncomienda.getManifiesto();
		if(dtoM != null){
			Manifiesto m = new Manifiesto();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiesto> itemsManifiesto = new ArrayList<ItemManifiesto>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiesto im = new ItemManifiesto();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
					im.setProducto(prod);
					im.setManifiesto(m);
					itemsManifiesto.add(im);
				}
			}
			m.setItemsManifiesto(itemsManifiesto);
			
			encomienda.setManifiesto(m);
		}
		
		DTO_Remito dtoR = dtoEncomienda.getRemito();
		if(dtoR != null){
			Remito remito = new Remito();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemito ir = new ItemRemito();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				Producto prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
	}
	
	
	public void facturarEncomiendaEmpresa(int idEncomienda){
		Encomienda encomienda = EncomiendaDao.getInstancia().getById(idEncomienda);
		
		//Calculo la primer linea de la factura - El valor del transporte lo define la cantidad de km y el costo
		//que se obtiene del mapa de ruta. 
		Sucursal sucursalOrigen =encomienda.getSucursalOrigen();
		Sucursal sucursalDestino=encomienda.getSucursalDestino();
		float kilometros =MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCantKm();
		float costo = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCosto();

		List<ItemFactura> items = new ArrayList<ItemFactura>();

		//Costo por Km
		ItemFactura itemTransporte = new ItemFactura();
		itemTransporte.setDescripcion("Transporte: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(costo);
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
				
		//Tercer Linea Servicio Seguridad
		ServicioSeguridad ss = encomienda.getServicioSeguridad();
		if(ss != null){
			ItemFactura itemSeguridad = new ItemFactura();
			itemSeguridad.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());
			itemSeguridad.setCantidad(1);
			itemSeguridad.setValor((float)(ss.getTarifa()));
			items.add(itemSeguridad);
		}
	
		//Cuarta Linea Impuestos
		ItemFactura itemImpuesto = new ItemFactura();
		itemImpuesto.setDescripcion("IVA 21%");
		itemImpuesto.setCantidad(1);
		float costoTotal = (float) (this.calcularPrecioTotal(encomienda) * 0.21);
		itemImpuesto.setValor(costoTotal);
		items.add(itemImpuesto);
		
		Factura factura = new Factura();
		factura.setFecha(new Date());
		factura.setPagada(false);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		factura.setVencimiento(c.getTime());
		
		
		//almaceno los items
		for(ItemFactura item:items){
			item.setFactura(factura);
		}
		
		factura.setItemsFactura(items);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//actualizo la encomienda
		encomienda.setFactura(factura);
		EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		
		tx.commit();
	}
	
	public boolean esEnvioTercerizado(Encomienda encomienda){
		if(encomienda.getVolumenGranel()!=0){
			return true;
		}
		if(encomienda.isInternacional()){
			return true;
		}
		MapaDeRuta mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(encomienda.getSucursalOrigen().getIdSucursal(), encomienda.getSucursalDestino().getIdSucursal());
		if(mr!=null){
			Date hoy = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoy);
			calendar.add(Calendar.HOUR, (int) mr.getDuracion());
			
			//Si tengo que enviarlo si o si hoy para que llegue y no hay vehiculos disponibles
			if(encomienda.getFechaEstimadaEntrega().compareTo(calendar.getTime())==0 ){
				if(!hayVehiculosDisponibles(encomienda)){
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
	
	
	public boolean hayVehiculosDisponibles(Encomienda encomienda){
		List<Vehiculo> vehiculosDisponibles = VehiculoDao.getInstancia().listarVehiculosDisponibles(encomienda.getSucursalOrigen().getIdSucursal(),  encomienda.getVolumen(), encomienda.getPeso());
		boolean pesoOK = false;
		boolean volumenOK = false;
		
		for(Vehiculo v: vehiculosDisponibles){
			//Sumo los pesos y los volumenes
			if(!pesoOK || !volumenOK){ //si aun no se  encontro ya vehiculo
				float pesoTotal = v.getPeso() - v.getTara();
				float volumenTotal = v.getVolumen();
				float peso = 0;
				float volumen = 0;
				
				Envio envio = (Envio) EnvioDao.getInstancia().getByVehiculo(v.getIdVehiculo());
				if(envio!=null){
					if(envio.getEstado()==EnvioEstado.Pendiente.toString()){
						for(Encomienda enc: envio.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
					}
				}		
				//Verifico si entra el  pedido
				if(pesoTotal >= peso + encomienda.getPeso()){
					pesoOK = true;
				}
				if(volumenTotal >= volumen + encomienda.getVolumen()){
					volumenOK = true;
				}

				if(pesoOK && volumenOK){ 
					return true;
				}
			}
		}
		return false;
	}
	
	public Integer asignarEnvio(Integer idEncomienda, Integer idCarrier){
		/*antes de asignar busco encomiendas por vencer asi ya las pongo en viaje 
		 * y asi marco esos envios y vehiculos como no disponibles*/
		ponerEnViajeEncomiendasPorVencer();
		
		Encomienda e = EncomiendaDao.getInstancia().getById(idEncomienda);
		System.out.println(e.toString());
		Integer idEnvio = null;
		if(e != null){
			if(esEnvioTercerizado(e)){ 
				Envio envioTercerizado = new Envio();
				if(e.isInternacional()){
					Carrier prov = CarrierDao.getInstancia().getById(idCarrier);
					envioTercerizado.setProveedor(prov);
				}
				MapaDeRuta mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
				envioTercerizado.setNroTracking(2000);
				envioTercerizado.setSucursalOrigen(e.getSucursalOrigen());
				envioTercerizado.setSucursalDestino(e.getSucursalDestino());
				envioTercerizado.setFechaYHoraSalida(new Date());
				envioTercerizado.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
				envioTercerizado.setMapaDeRuta(mr);
				List<Encomienda> lista = new ArrayList<Encomienda>();
				lista.add(e);
				envioTercerizado.setEncomiendas(lista);
				e.setEstado(EncomiendaEstado.Colocada.toString());
				
				Envio envio = EnvioDao.getInstancia().saveOrUpdate(envioTercerizado);;
				EncomiendaDao.getInstancia().saveOrUpdate(e);
				
				idEnvio = envio.getIdEnvio();
			} else {
				//Busco si ya hay algun envio que vaya a la misma ciudad y pendientes
				boolean nuevoEnvio = true;
				List<Envio> envios = EnvioDao.getInstancia().listarEnviosPorSucursalDestino(e.getSucursalDestino().getIdSucursal(), e.getFechaEstimadaEntrega());
				boolean pesoOK = false;
				boolean volumenOK = false;
				for(Envio envProp: envios){
					if(!pesoOK || !volumenOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
						//Sumo los pesos y los volumenes
						float peso = 0;
						float volumen = 0;
						float pesoTotal = envProp.getVehiculo().getPeso() - envProp.getVehiculo().getTara();
						float volumenTotal = envProp.getVehiculo().getVolumen();
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
							
							
							idEnvio =  envProp.getIdEnvio();
						} 
					}
				}//End loop
				
				//Es un nuevo envio por que no se encontro camion disponible
				if (nuevoEnvio){
					//Buscar Vehiculo para asignar que no pertezca a un envio en curso (<>Pendiente)
					List<Vehiculo> vehiculosDisponibles = VehiculoDao.getInstancia().listarVehiculosDisponibles(e.getSucursalOrigen().getIdSucursal(),  e.getVolumen(), e.getPeso());
					boolean pesoNuevoOK = false;
					boolean volumenNuevoOK = false;
					
					for(Vehiculo v: vehiculosDisponibles){
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
								
								MapaDeRuta mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
								
								Envio envioPropio = new Envio();
								envioPropio.setEstado(EnvioEstado.Pendiente.toString());
								envioPropio.setFechaYHoraSalida(new Date());
								envioPropio.setPosicionActual(e.getSucursalActual().getCoordenadas());
								envioPropio.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
								envioPropio.setVehiculo(v);
								envioPropio.setSucursalOrigen(e.getSucursalActual());
								envioPropio.setSucursalDestino(e.getSucursalDestino());
								envioPropio.setMapaDeRuta(mr);
								List<Encomienda> lista = new ArrayList<Encomienda>();
								lista.add(e);
								envioPropio.setEncomiendas(lista);
								float volumen70 = (float)(e.getVolumen()/volumenTotal);
								float peso70 = (float)(e.getPeso()/pesoTotal);
								
								if(peso70 > 0.7 || volumen70 > 0.7){
									e.setEstado(EncomiendaEstado.Colocada.toString());
									envioPropio.setEstado(EnvioEstado.Pendiente.toString());
								}
								
								Envio envio = EnvioDao.getInstancia().saveOrUpdate(envioPropio);
								EncomiendaDao.getInstancia().saveOrUpdate(e);
								idEnvio =  envio.getIdEnvio();
							}
						}
					}//End for
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
		

		/*Coloco las encomiendas en viaje y envio en viaje si hay encomiendas por vencer*/
		ponerEnViajeEncomiendasPorVencer();
		
		return idEnvio;
	}
	
	public void ponerEnViajeEncomiendasPorVencer(){
		List<Encomienda> encomiendasColocadasPorVencer = EncomiendaDao.getInstancia().obtenerEncomiendasColocadasPorVencerHoy();
		for(Encomienda enc : encomiendasColocadasPorVencer){
		      enc.setEstado(EncomiendaEstado.EnViaje.toString());
		      Envio envio = EnvioDao.getInstancia().getByEncomiendaColocada(enc.getIdEncomienda());
		      if(envio!=null){
			      envio.setEstado(EnvioEstado.EnViaje.toString());
			      
				  EncomiendaDao.getInstancia().saveOrUpdate(enc);
				  EnvioDao.getInstancia().saveOrUpdate(envio);
		      }
		}
	}
	
	public void cambiarEstadoEncomienda(int idEncomienda, EncomiendaEstado estado){
		Encomienda enc = EncomiendaDao.getInstancia().getById(idEncomienda);
		enc.setEstado(estado.toString());
		EncomiendaDao.getInstancia().saveOrUpdate(enc);
	}
	
	public void cambiarEstadoEnvio(int idEnvio, EnvioEstado estado){
		Envio env = EnvioDao.getInstancia().getById(idEnvio);
		env.setEstado(estado.toString());
		EnvioDao.getInstancia().saveOrUpdate(env);
	}
	
	public void pagarEncomienda(int idEncomienda){
		try{
			Encomienda enc = EncomiendaDao.getInstancia().getById(idEncomienda);
			Factura factura = enc.getFactura();
			factura.setPagada(true);
			FacturaDao.getInstancia().saveOrUpdate(factura);
		}
		catch(Exception e){
			System.out.println("Error al pagar encomienda");
			e.printStackTrace();
		}
	}
	
	public Date calcularFechaEstimadaDeEntrega(int idSucursalOrigen, int idSucursalDestino){
		MapaDeRuta mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(idSucursalOrigen, idSucursalDestino);
		if(mr!=null){
			Date hoy = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoy);
			calendar.add(Calendar.HOUR, (int) mr.getDuracion());
			return calendar.getTime();
		}
		else
			return null;
	}

	/**
	 * Encomiendas que aun no se asignaron a un envío
	 * @return
	 */
	public List<Encomienda> getEncomiendasPendientesBySucursal(int idSucursal){
		//TODO: hacer
		return EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
	}
}
