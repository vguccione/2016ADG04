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

import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;


@Entity
@Table(name = "Manifiesto")
public class Manifiesto implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "IdManifiesto", unique = true, nullable = false)
	private int idManifiesto;
	
	@OneToOne
	@JoinColumn(name="IdEncomienda")
	private Encomienda encomienda;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fecha", nullable = false, length = 23)
	private Date fecha;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manifiesto", cascade = CascadeType.ALL)
	private List<ItemManifiesto> itemsManifiesto;

	public Manifiesto() {
	}

	
	public Manifiesto(int idManifiesto, Date fecha) {
		super();
		this.idManifiesto = idManifiesto;
		this.fecha = fecha;
	}


	public int getIdManifiesto() {
		return idManifiesto;
	}


	public void setIdManifiesto(int idManifiesto) {
		this.idManifiesto = idManifiesto;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public List<ItemManifiesto> getItemsManifiesto() {
		return itemsManifiesto;
	}


	public void setItemsManifiesto(List<ItemManifiesto> itemsManifiesto) {
		this.itemsManifiesto = itemsManifiesto;
	}

	
    public Encomienda getEncomienda() {
		return encomienda;
	}


	public void setEncomienda(Encomienda encomienda) {
		this.encomienda = encomienda;
	}


	public DTO_Manifiesto toDTO(){
    	DTO_Manifiesto m = new DTO_Manifiesto();
    	m.setFecha(this.fecha);
    	m.setIdManifiesto(this.idManifiesto);
    	
    	List<DTO_ItemManifiesto> list = new ArrayList<DTO_ItemManifiesto>();
    	for(ItemManifiesto item : this.itemsManifiesto){
    		list.add(item.toDTO());
    	}
    	
    	m.setDetalle(list);
    	
    	return m;
    }

}
