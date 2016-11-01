package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.property.Getter;

import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.*;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Encomienda.DTO_Encomienda;

public class EncomiendaParticular extends Encomienda{

	public EncomiendaParticular() {
	}

	public EncomiendaParticular(Direccion direccionDestino, Sucursal sucursalDestno,
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
		
		super(direccionDestino, sucursalDestno, sucursalOrigen, direccionOrigen, sucursalActual, 
				cliente, fechaCreacion, fechaEstimadaEntrega, estado, tercerizado, largo, alto, ancho, peso, volumen, 
				tratamiento, apilable, cantApilable, refrigerado, condicionTransporte, indicacionesManipulacion, 
				fragilidad, nombreReceptor, apellidoReceptor, dniReceptor, volumenGranel, unidadGranel, cargaGranel, 
				servicioSeguridad, manifiesto, 
				//factura, remito, 
				internacional);
	}
	
	public EncomiendaParticular(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
			Sucursal sucursalOrigen, Cliente cliente,
			Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			
	{
		super(sucursalDestino, sucursalOrigen, cliente, fechaCreacion, fechaEstimadaEntrega, estado);
	}
	
	@Override
	public String toString() {
		return "Encomienda [cliente=" + getCliente().getIdCliente()
				+ ", fechaCreacion=" + getFechaCreacion()
				+ ", fechaEstimadaEntrega=" + getFechaEstimadaEntrega()
				+ ", estado=" + getEstado() + ", tercerizado=" + isTercerizado()
				+ ", largo=" + getLargo() + ", alto=" + getAlto() + ", ancho=" + getAncho()
				+ ", peso=" + getPeso() + ", volumen=" + getVolumen()+ ", tratamiento="
				+ getTratamiento() + ", apilable=" + getApilable() + ", cantApilable="
				+ getCantApilable() + ", refrigerado=" + getRefrigerado()
				+ ", condicionTransporte=" + getCondicionTransporte()
				+ ", indicacionesManipulacion=" + getIndicacionesManipulacion()
				+ ", fragilidad=" + getFragilidad() + ", nombreReceptor="
				+ getNombreReceptor() + ", apellidoReceptor=" + getApellidoReceptor()
				+ ", dniReceptor=" + getDniReceptor() + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel + "terciarizado= " + isTercerizado()
						+ " internacional +" + internacional + "]";
	}

	public DTO_Encomienda toDTO() {
		DTO_Encomienda dto = new DTO_Encomienda();
		dto.setAlto(this.getAlto());
		dto.setAncho(this.getAncho());
		dto.setApellidoReceptor(this.getApellidoReceptor());
		dto.setApilable(this.getApilable());
		dto.setCantApilable(this.getCantApilable());
		dto.setCargaGranel(this.getCargaGranel());
		dto.setCondicionTransporte(this.getCondicionTransporte());
		dto.setTipoEncomienda("P");
		if(this.getFactura()!=null)
			dto.setFactura(this.getFactura().toDTO());
		
		dto.setDniReceptor(this.getDniReceptor());
		dto.setEstado(this.getEstado());
		dto.setFechaCreacion(this.getFechaCreacion());
		dto.setFragilidad(this.getFragilidad());
		dto.setIdEncomienda(this.getIdEncomienda());
		dto.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		dto.setInternacional(this.internacional);
		dto.setLargo(this.getLargo());
		if(this.getManifiesto()!=null)
			dto.setManifiesto(this.getManifiesto().toDTO());
		
		dto.setNombreReceptor(this.getNombreReceptor());
		dto.setPeso(this.getPeso());
		dto.setRefrigerado(this.refrigerado);
		dto.setSucursalActual(this.getSucursalActual().toDTO());
		dto.setSucursalDestino(this.getSucursalDestino().toDTO());
		dto.setSucursalOrigen(this.getSucursalOrigen().toDTO());
		dto.setTercerizada(this.tercerizado);
		dto.setTratamiento(this.getTratamiento());
		dto.setUnidadGranel(this.getUnidadGranel());
		dto.setVolumen(this.getVolumen());
		dto.setVolumenGranel(this.getVolumenGranel());
		dto.setCliente(this.getCliente().toDTO());
		return dto;
	}

	public Integer saveOrUpdate() {
		
		SucursalE actual = SucursalDao.getInstancia().getById(this.getSucursalActual().getIdSucursal());
		SucursalE origen = SucursalDao.getInstancia().getById(this.getSucursalOrigen().getIdSucursal());
		SucursalE destino = SucursalDao.getInstancia().getById(this.getSucursalDestino().getIdSucursal());
		ClienteE cli = ClienteParticularDao.getInstancia().getById(this.getCliente().getIdCliente());
				
		EncomiendaE encomienda = new EncomiendaE();
		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalActual(actual);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(this.getLargo());
		encomienda.setAncho(this.getAncho());
		encomienda.setInternacional(this.isInternacional());
		encomienda.setAlto(this.getAlto());
		encomienda.setPeso(this.getPeso());
		encomienda.setVolumen(this.getVolumen());
		encomienda.setTratamiento(this.getTratamiento()); 
		encomienda.setApilable(this.getApilable());
		encomienda.setCantApilable(this.getCantApilable()); 
		encomienda.setRefrigerado(this.getRefrigerado());
		encomienda.setCondicionTransporte(this.getCondicionTransporte()); 
		encomienda.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		encomienda.setFragilidad(this.getFragilidad()); 
		encomienda.setNombreReceptor(this.getNombreReceptor()); 
		encomienda.setApellidoReceptor(this.getApellidoReceptor());
		encomienda.setDniReceptor(this.getDniReceptor()); 
		encomienda.setVolumenGranel(this.getVolumenGranel()); 
		encomienda.setUnidadGranel(this.getUnidadGranel());
		encomienda.setCargaGranel(this.getCargaGranel());		
		encomienda.setTipoEncomienda("P");
		
		encomienda.setTercerizado(this.isTercerizado());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
		
		//El Mapa de Ruta es el encargado de calcular la fecha de entrega, porque la calculamos en base a 
		//la distancia
		System.out.println("MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino");
		MapaDeRutaE m = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(this.getSucursalOrigen().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
		System.out.println(this.getSucursalOrigen().getIdSucursal());
		System.out.println(this.getSucursalDestino().getIdSucursal());
		System.out.println(m.getIdMapaDeRuta());
		MapaDeRuta mapa = new MapaDeRuta();
		mapa.setIdMapaDeRuta(m.getIdMapaDeRuta());
		encomienda.setFechaEstimadaEntrega(mapa.calcularFechaEstimadaDeEntrega());
					
	//	EntityManager em = getEntityFactoryInstace();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();	
		
		Manifiesto dtoM = this.getManifiesto();

		ManifiestoE manifiestoE = new ManifiestoE();
		manifiestoE.setEncomienda(encomienda);
		manifiestoE.setFecha(new Date());		
		manifiestoE.setEncomienda(encomienda);
	
		List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
		for(ItemManifiesto item:dtoM.getItemsManifiesto()){
			if(item!=null){
				ItemManifiestoE im = new ItemManifiestoE();
				im.setCantidad(item.getCantidad());
				im.setDescripcion(item.getDescripcion());
				
				//TODO: tiene que tener productos??????? No es para las empresas los productos
				if(item.getProducto() != null) {	
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getIdProducto());
					im.setProducto(prod);
				}
				
				im.setManifiesto(manifiestoE);
				itemsManifiesto.add(im);
			}
		}
		manifiestoE.setItemsManifiesto(itemsManifiesto);
		
		encomienda.setManifiesto(manifiestoE);

		/*
		DTO_Remito dtoR = this.getRemito();
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
		}*/

		/*Deberia persistir en cascada*/
		
		EncomiendaDao.getInstancia().persist(encomienda);

//		tx.commit();
		this.manifiesto.setIdManifiesto(manifiestoE.getIdManifiesto());
		this.idEncomienda = encomienda.getIdEncomienda();
		return encomienda.getIdEncomienda();
	}

	private EntityManager getEntityFactoryInstace() {
		return EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
	}

	
	
}
