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
import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ItemFacturaDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.RemitoDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Carrier;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.ItemFactura;
import com.ADG04.Servidor.model.ItemManifiesto;
import com.ADG04.Servidor.model.ItemRemito;
import com.ADG04.Servidor.model.Manifiesto;
import com.ADG04.Servidor.model.Producto;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.Remito;
import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.model.Seguro;
import com.ADG04.Servidor.model.ServicioSeguridad;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
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
		
		List<ItemFactura>  detalle = new ArrayList<ItemFactura>();
		
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
		
		List<ItemFactura>  detalle = new ArrayList<ItemFactura>();
		
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
	
	
	public Integer asignarEnvio(Integer idEncomienda, Integer idCarrier){
		Encomienda e = EncomiendaDao.getInstancia().getById(idEncomienda);
		if(e != null){
			if(e.isTercerizado()){ 
				Envio envioTercerizado = new Envio();
				if(e.isInternacional()){
					Carrier prov = CarrierDao.getInstancia().getById(idCarrier);
					envioTercerizado.setProveedor(prov);
				}
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
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
