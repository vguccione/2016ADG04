package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

@Entity
@Table(name = "Factura")
public class Factura implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "IdFactura", unique = true, nullable = false)
	private int idFactura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCtaCte")
	private CuentaCorriente cuentaCorriente;
	
	@Column(name = "TipoFactura", nullable = false, length = 1)
	private String tipoFactura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fecha", nullable = false, length = 23)
	private Date fecha;
	
	@Column(name = "Pagada", nullable = false)
	private boolean pagada;
	
	@Column(name="FechaVencimiento")
	private Date fechaVencimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Vencimiento", nullable = false, length = 23)
	private Date vencimiento;
	
	@OneToOne
	@JoinColumn(name="IdEncomienda")
	private Encomienda encomienda;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval=true)
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
		f.setEncomienda(this.getEncomienda().toDTO());
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
