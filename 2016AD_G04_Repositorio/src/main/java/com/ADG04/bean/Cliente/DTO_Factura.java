package com.ADG04.bean.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Encomienda.DTO_Encomienda;


public class DTO_Factura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;	//A-B-C
	private Date fecha;
	private Date fechaVencimiento;
	//private float total; - TODO: necesitamos el total o podemos calcularlo sumando los items directamente??
	private List<DTO_ItemFactura> detalle;
	//TODO: private List<DTO_DetalleReciboPago> detalleRecibo;
	private boolean pagado;
	private Integer idCuentaCorriente;
	private Integer idEncomienda;
	
	public DTO_Factura(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void fechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public boolean estaVencida(){
		//Si está impaga y la fecha de vencimiento ya paso, return true,
		if(fechaVencimiento.before(new Date()))
			return true;
		
		return false;
	}

	
	public List<DTO_ItemFactura> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DTO_ItemFactura> detalle) {
		this.detalle = detalle;
	}

	
	public Integer getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public List<DTO_ItemFactura> getItems() {
		return detalle;
	}

	public void setItems(List<DTO_ItemFactura> item) {
		this.detalle = item;
	}

	public void agregaItem(DTO_ItemFactura item){
		if(this.detalle == null)
			this.detalle = new ArrayList<DTO_ItemFactura>();
		
		this.detalle.add(item);
	}

/*    public List<DTO_DetalleReciboPago> getDetalleRecibo() {
            return detalleRecibo;
    }

    public void setDetalleRecibo(List<DTO_DetalleReciboPago> detalleRecibo) {
            this.detalleRecibo = detalleRecibo;
    }*/

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Integer getIdCuentaCorriente() {
		return idCuentaCorriente;
	}

	public void setIdCuentaCorriente(Integer idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}

	public void addItem(DTO_ItemFactura item) {
		if(this.detalle == null)
			this.detalle = new ArrayList<DTO_ItemFactura>();
		
		this.detalle.add(item);
	}

}
