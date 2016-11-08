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
public class FacturaE implements java.io.Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "IdFactura", unique = true, nullable = false)
	private int idFactura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCtaCte")
	private CuentaCorrienteE cuentaCorriente;
	
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
	private EncomiendaE encomienda;	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<ItemFacturaE> itemsFactura;

	public FacturaE() {
	}

	public FacturaE(int idFactura, String tipoFactura, Date fecha, boolean pagada,
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

	
	public CuentaCorrienteE getCuentaCorriente() {
		return this.cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorrienteE cuentaCorriente) {
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

	public List<ItemFacturaE> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(List<ItemFacturaE> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}
	

	public EncomiendaE getEncomienda() {
		return encomienda;
	}

	public void setEncomienda(EncomiendaE encomienda) {
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
    	for(ItemFacturaE item : this.itemsFactura){
    		list.add(item.toDTO());
    	}
    	
    	f.setItems(list);
    	
    	return f;
    }

}
