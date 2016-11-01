package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class Factura{
		
	private int idFactura;
	
	private CuentaCorriente cuentaCorriente;
	
	private String tipoFactura;
	
	private Date fecha;
	
	private boolean pagada;
	
	private Date fechaVencimiento;
	
	private Date vencimiento;
	
	private Encomienda encomienda;	
	
	private List<ItemFactura> itemsFactura;

	public Factura() {
	}

	public Factura(int idFactura, String tipoFactura, Date fecha, boolean pagada,
			Date vencimiento) {
		this.idFactura = idFactura;
		this.tipoFactura = tipoFactura;
		this.fecha = fecha;
		this.pagada = pagada;
		this.vencimiento = vencimiento;
	}
	
	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	public CuentaCorriente getCuentaCorriente() {
		return this.cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean isPagada() {
		return this.pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	public Date getVencimiento() {
		return this.vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public List<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	

	public Encomienda getEncomienda() {
		return encomienda;
	}

	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}

	public DTO_Factura toDTO(){
		DTO_Factura f = new DTO_Factura();
		f.setId(this.getIdFactura());
		f.setIdEncomienda(this.getEncomienda().getIdEncomienda());
    	f.setFecha(this.fecha);
    	f.setIdCuentaCorriente(this.cuentaCorriente.getIdCtaCte());
    	f.setPagado(this.pagada);
    	f.setTipo(this.tipoFactura);
    	
    	List<DTO_ItemFactura> list = new ArrayList<DTO_ItemFactura>();
    	for(ItemFactura item : this.itemsFactura){
    		list.add(item.toDTO());
    	}
    	
    	f.setItems(list);
    	
    	return f;
    }

}
