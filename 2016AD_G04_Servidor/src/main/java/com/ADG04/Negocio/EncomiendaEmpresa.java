package com.ADG04.Negocio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.hibernate.property.Getter;

import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.bean.Encomienda.DTO_Encomienda;


public class EncomiendaEmpresa extends Encomienda{

	private List<ProductoEncomienda> productoEncomiendas;
	
	public EncomiendaEmpresa() {
	}

	public EncomiendaEmpresa(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
			Sucursal sucursalOrigen, Cliente cliente,
			Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			
	{
		super(sucursalDestino, sucursalOrigen, cliente, fechaCreacion, fechaEstimadaEntrega, estado);
	}
	
	
	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
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
				+ ", cargaGranel=" + cargaGranel + ", productoEncomiendas="
				+ productoEncomiendas + ", terciarizado=" + isTercerizado() +""
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
		dto.setTipoEncomienda("E");
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

	
	
}
