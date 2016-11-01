package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.*;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.*;

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
		SucursalE origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		SucursalE destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		ClienteE cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		EncomiendaE encomienda = new EncomiendaE();
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
			ManifiestoE m = new ManifiestoE();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiestoE im = new ItemManifiestoE();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
	
	public EncomiendaE crearEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		SucursalE actual = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalActual().getId());
		SucursalE origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		SucursalE destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		ClienteE cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		EncomiendaE encomienda = new EncomiendaE();
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
			ManifiestoE m = new ManifiestoE();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiestoE im = new ItemManifiestoE();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
				ir.setProducto(prod);
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/
		EncomiendaE enc = EncomiendaDao.getInstancia().saveOrUpdate(encomienda);
		tx.commit();
		return enc;
		
	}

	public void modificarEncomiendaParticular(DTO_EncomiendaParticular dtoEncomienda) {
		SucursalE origen = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalOrigen().getId());
		SucursalE destino = SucursalDao.getInstancia().getById(dtoEncomienda.getSucursalDestino().getId());
		ClienteE cli = ClienteParticularDao.getInstancia().getById(dtoEncomienda.getCliente().getId());
				
		EncomiendaE encomienda = new EncomiendaE();
		
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
			ManifiestoE m = new ManifiestoE();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiestoE im = new ItemManifiestoE();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
		
		EncomiendaE encomienda = EncomiendaDao.getInstancia().getById(idEncomienda);
		
		//Calculo la primer linea de la factura - El valor del transporte lo define la cantidad de km y el costo
		//que se obtiene del mapa de ruta. 
		SucursalE sucursalOrigen =encomienda.getSucursalOrigen();
		SucursalE sucursalDestino=encomienda.getSucursalDestino();
		float kilometros =MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCantKm();
		float costo = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCosto();

		List<ItemFacturaE> items = new ArrayList<ItemFacturaE>();

		//Costo por Km
		ItemFacturaE itemTransporte = new ItemFacturaE();
		itemTransporte.setDescripcion("Transporte: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(costo);
		items.add(itemTransporte);
						
		//Segunda Linea Seguros
		SeguroE pSeguro = encomienda.getSeguro();
		if(pSeguro != null){
			ItemFacturaE itemSeguro = new ItemFacturaE();
			itemSeguro.setDescripcion("Seguro: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
			itemSeguro.setCantidad(1);
			itemSeguro.setValor((float)(pSeguro.getTarifa() + (pSeguro.getTarifaPorKm() * kilometros)));
			items.add(itemSeguro);
		}
				
		//Tercer Linea Servicio Seguridad
		ServicioSeguridadE ss = encomienda.getServicioSeguridad();
		if(ss != null){
			ItemFacturaE itemSeguridad = new ItemFacturaE();
			itemSeguridad.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());
			itemSeguridad.setCantidad(1);
			itemSeguridad.setValor((float)(ss.getTarifa()));
			items.add(itemSeguridad);
		}
	
		//Cuarta Linea Impueestos
		ItemFacturaE itemImpuesto = new ItemFacturaE();
		itemImpuesto.setDescripcion("IVA 21%");
		itemImpuesto.setCantidad(1);
		float costoTotal = (float) (this.calcularPrecioTotal(encomienda) * 0.21);
		itemImpuesto.setValor(costoTotal);
		items.add(itemImpuesto);
		
		FacturaE factura = new FacturaE();
		factura.setFecha(new Date());
		factura.setPagada(false);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		factura.setVencimiento(c.getTime());
		
		
		//almaceno los items
		for(ItemFacturaE item:items){
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
	
	private float calcularPrecioTotal(EncomiendaE encomienda) {
		FacturaE factura = FacturaDao.getInstancia().getById(encomienda.getFactura().getIdFactura());
		float costoTotal=0;
		for(ItemFacturaE item: factura.getItemsFactura()){
			costoTotal =+ item.getValor();
		}
		return costoTotal;
	}


	public int getFacturaParticularByIdEncomienda(int idEncomienda) {

		return EncomiendaDao.getInstancia().getById(idEncomienda).getFactura().getIdFactura();
		
	}
	
	
	public void altaEncomiendaEmpresa(DTO_EncomiendaEmpresa dtoEncomienda) {
		DireccionE origen = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionOrigen().getIdDireccion());
		DireccionE destino = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionDestino().getIdDireccion());
		
		ClienteE cli = ClienteEmpresaDao.getInstancia().getById(dtoEncomienda.getEmpresa().getId());
				
		EncomiendaE encomienda = new EncomiendaE();
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
			ManifiestoE m = new ManifiestoE();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiestoE im = new ItemManifiestoE();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
		DireccionE origen = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionOrigen().getIdDireccion());
		DireccionE destino = DireccionDao.getInstancia().getById(dtoEncomienda.getDireccionDestino().getIdDireccion());
		ClienteE cli = ClienteEmpresaDao.getInstancia().getById(dtoEncomienda.getEmpresa().getId());
				
		EncomiendaE encomienda = new EncomiendaE();
	
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
			ManifiestoE m = new ManifiestoE();
			m.setEncomienda(encomienda);
			m.setFecha(new Date());		
			m.setEncomienda(encomienda);
		
			List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
			for(DTO_ItemManifiesto item:dtoM.getDetalle()){
				if(item!=null){
					ItemManifiestoE im = new ItemManifiestoE();
					im.setCantidad(item.getCantidad());
					im.setDescripcion(item.getDescripcion());
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(dtoR.getApellidoReceptor());
			remito.setConformado(dtoR.isConformado());
			remito.setDniReceptor(dtoR.getDniReceptor());
			remito.setFechaConformado(dtoR.getFecha());
			remito.setNombreReceptor(dtoR.getNombreReceptor());
			remito.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(dtoR.getCondicionTransporte());
			remito.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(DTO_ItemRemito item:dtoR.getDetalle()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getId());
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
		EncomiendaE encomienda = EncomiendaDao.getInstancia().getById(idEncomienda);
		
		//Calculo la primer linea de la factura - El valor del transporte lo define la cantidad de km y el costo
		//que se obtiene del mapa de ruta. 
		SucursalE sucursalOrigen =encomienda.getSucursalOrigen();
		SucursalE sucursalDestino=encomienda.getSucursalDestino();
		float kilometros =MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCantKm();
		float costo = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCosto();

		List<ItemFacturaE> items = new ArrayList<ItemFacturaE>();

		//Costo por Km
		ItemFacturaE itemTransporte = new ItemFacturaE();
		itemTransporte.setDescripcion("Transporte: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(costo);
		items.add(itemTransporte);
						
		//Segunda Linea Seguros
		SeguroE pSeguro = encomienda.getSeguro();
		if(pSeguro != null){
			ItemFacturaE itemSeguro = new ItemFacturaE();
			itemSeguro.setDescripcion("Seguro: " + encomienda.getCliente().getEmail() + "-" + encomienda.getSucursalOrigen().getDescripcion() + "-" + encomienda.getSucursalDestino().getDescripcion());
			itemSeguro.setCantidad(1);
			itemSeguro.setValor((float)(pSeguro.getTarifa() + (pSeguro.getTarifaPorKm() * kilometros)));
			items.add(itemSeguro);
		}
				
		//Tercer Linea Servicio Seguridad
		ServicioSeguridadE ss = encomienda.getServicioSeguridad();
		if(ss != null){
			ItemFacturaE itemSeguridad = new ItemFacturaE();
			itemSeguridad.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());
			itemSeguridad.setCantidad(1);
			itemSeguridad.setValor((float)(ss.getTarifa()));
			items.add(itemSeguridad);
		}
	
		//Cuarta Linea Impuestos
		ItemFacturaE itemImpuesto = new ItemFacturaE();
		itemImpuesto.setDescripcion("IVA 21%");
		itemImpuesto.setCantidad(1);
		float costoTotal = (float) (this.calcularPrecioTotal(encomienda) * 0.21);
		itemImpuesto.setValor(costoTotal);
		items.add(itemImpuesto);
		
		FacturaE factura = new FacturaE();
		factura.setFecha(new Date());
		factura.setPagada(false);
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		factura.setVencimiento(c.getTime());
		
		
		//almaceno los items
		for(ItemFacturaE item:items){
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
	
	public boolean esEnvioTercerizado(EncomiendaE encomienda){
		if(encomienda.getVolumenGranel()!=0){
			return true;
		}
		if(encomienda.isInternacional()){
			return true;
		}
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(encomienda.getSucursalOrigen().getIdSucursal(), encomienda.getSucursalDestino().getIdSucursal());
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
	
	
	public boolean hayVehiculosDisponibles(EncomiendaE encomienda){
		
		List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(encomienda.getSucursalOrigen().getIdSucursal(),  encomienda.getVolumen(), encomienda.getPeso());
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
		
		EncomiendaE e = EncomiendaDao.getInstancia().getById(idEncomienda);
		System.out.println(e.toString());
		Integer idEnvio = null;
		if(e != null){
			if(esEnvioTercerizado(e)){ 
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
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
		

		/*Coloco las encomiendas en viaje y envio en viaje si hay encomiendas por vencer*/
		ponerEnViajeEncomiendasPorVencer();
		
		return idEnvio;
	}
	
	public void ponerEnViajeEncomiendasPorVencer(){
		List<EncomiendaE> encomiendasColocadasPorVencer = EncomiendaDao.getInstancia().obtenerEncomiendasColocadasPorVencerHoy();
		for(EncomiendaE enc : encomiendasColocadasPorVencer){
		      enc.setEstado(EncomiendaEstado.EnViaje.toString());
		      EnvioE envio = EnvioDao.getInstancia().getByEncomiendaColocada(enc.getIdEncomienda());
		      if(envio!=null){
			      envio.setEstado(EnvioEstado.EnViaje.toString());
			      
				  EncomiendaDao.getInstancia().saveOrUpdate(enc);
				  EnvioDao.getInstancia().saveOrUpdate(envio);
		      }
		}
	}
	
	public void cambiarEstadoEncomienda(int idEncomienda, EncomiendaEstado estado){
		EncomiendaE enc = EncomiendaDao.getInstancia().getById(idEncomienda);
		enc.setEstado(estado.toString());
		EncomiendaDao.getInstancia().saveOrUpdate(enc);
	}
	
	public void cambiarEstadoEnvio(int idEnvio, EnvioEstado estado){
		EnvioE env = EnvioDao.getInstancia().getById(idEnvio);
		env.setEstado(estado.toString());
		EnvioDao.getInstancia().saveOrUpdate(env);
	}
	
	public void pagarEncomienda(int idEncomienda){
		try{
			EncomiendaE enc = EncomiendaDao.getInstancia().getById(idEncomienda);
			FacturaE factura = enc.getFactura();
			factura.setPagada(true);
			FacturaDao.getInstancia().saveOrUpdate(factura);
		}
		catch(Exception e){
			System.out.println("Error al pagar encomienda");
			e.printStackTrace();
		}
	}
	
	public Date calcularFechaEstimadaDeEntrega(int idSucursalOrigen, int idSucursalDestino){
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(idSucursalOrigen, idSucursalDestino);
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
	public List<EncomiendaE> getEncomiendasPendientesBySucursal(int idSucursal){
		//TODO: hacer
		return EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
	}
	
	private List<VehiculoE> listarVehiculosDisponibles(int idSucursalOrigen, float volumen, float peso){

		List<VehiculoE> vehiculos = VehiculoDao.getInstancia().getPorVolumenPesoSucursalTareasRealizadas(idSucursalOrigen, peso, volumen);
				
		for(VehiculoE vehiculo: vehiculos){
			GestionVehiculo gVehiculo = new GestionVehiculo(vehiculo);
			if(gVehiculo.estaUtilizable() && !gVehiculo.estaAsignado() && !gVehiculo.tieneTareasVencidas()){
				vehiculos.add(gVehiculo.getVehiculo());
			}
		}
		return vehiculos;
		
	}


}
