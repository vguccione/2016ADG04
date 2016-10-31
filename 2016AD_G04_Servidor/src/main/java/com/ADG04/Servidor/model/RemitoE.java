package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Remito;


@Entity
@Table(name = "Remito")
public class RemitoE implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "IdRemito", unique = true, nullable = false)
	private int idRemito;
	
	@Column(name = "NombreReceptor", nullable = false, length = 100)
	private String nombreReceptor;

	@Column(name = "ApellidoReceptor", nullable = false, length = 100)
	private String apellidoReceptor;
	
	@Column(name = "DniReceptor", nullable = false, length = 8)
	private String dniReceptor;

	@Column(name = "Conformado", nullable = false)
	private boolean conformado;

	@Column(name = "FechaConformado", nullable = false)
	private Date fechaConformado;
	
	@Column(name="FechaEstimadaEntrega")
	private Date fechaEstimadaEntrega;
	
	@Column(name="CondicionTransporte")
	private String condicionTransporte;
	
	@Column(name="IndicacionesManipulacion")
	private String indicacionesManipulacion;
	
	@OneToOne
	@JoinColumn(name="IdEncomienda")
	private EncomiendaE encomienda;		
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "remito", cascade = CascadeType.ALL)
	private List<ItemRemitoE> itemsRemito;

	public RemitoE() {
	}

	public RemitoE(EncomiendaE encomienda, String nombreReceptor,
			String apellidoReceptor, String dniReceptor, boolean conformado,
			Date fechaConformado) {
		this.encomienda = encomienda;
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.conformado = conformado;
		this.fechaConformado = fechaConformado;
	}

	
	public int getIdRemito() {
		return this.idRemito;
	}

	public void setIdRemito(int idRemito) {
		this.idRemito = idRemito;
	}


	public EncomiendaE getEncomienda() {
		return this.encomienda;
	}

	public void setEncomienda(EncomiendaE encomienda) {
		this.encomienda = encomienda;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public boolean isConformado() {
		return this.conformado;
	}

	public void setConformado(boolean conformado) {
		this.conformado = conformado;
	}

	

	
	public Date getFechaConformado() {
		return fechaConformado;
	}

	public void setFechaConformado(Date fechaConformado) {
		this.fechaConformado = fechaConformado;
	}

	public List<ItemRemitoE> getItemsRemito() {
		return itemsRemito;
	}

	public void setItemsRemito(List<ItemRemitoE> itemsRemito) {
		this.itemsRemito = itemsRemito;
	}
	
	

	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getCondicionTransporte() {
		return condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public String getIndicacionesManipulacion() {
		return indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}
	
	

	public DTO_Remito toDTO(){
		DTO_Remito r = new DTO_Remito();
    	r.setConformado(this.conformado);
		r.setFecha(this.fechaConformado);
		r.setId(this.idRemito);
		r.setApellidoReceptor(apellidoReceptor);
		r.setDniReceptor(dniReceptor);
		r.setNombreReceptor(nombreReceptor);
    	
    	List<DTO_ItemRemito> list = new ArrayList<DTO_ItemRemito>();
    	for(ItemRemitoE item : this.itemsRemito){
    		list.add(item.toDTO());
    	}    	
    	r.setDetalle(list);
    	
    	return r;
    }

}
