package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

















import com.ADG04.Servidor.model.ItemManifiestoE;
import com.ADG04.Servidor.model.ManifiestoE;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;


public class Manifiesto{
	
	private int idManifiesto;
	private Encomienda encomienda;
	private Date fecha;
	private List<ItemManifiesto> itemsManifiesto;

	public Manifiesto() {
	}

	
	public Manifiesto(int idManifiesto, Date fecha) {
		super();
		this.idManifiesto = idManifiesto;
		this.fecha = fecha;
		this.itemsManifiesto = new ArrayList<ItemManifiesto>();
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
    	if(this.getEncomienda()!=null)
    		m.setIdEncomienda(this.getEncomienda().getIdEncomienda());
    	
    	List<DTO_ItemManifiesto> list = new ArrayList<DTO_ItemManifiesto>();
    	for(ItemManifiesto item : this.itemsManifiesto){
    		list.add(item.toDTO());
    	}
    	
    	m.setDetalle(list);
    	
    	m.setIdEncomienda(this.getEncomienda().getIdEncomienda());
    	return m;
    }


	public void addItem(ItemManifiesto itemManifiesto) {
		if(this.itemsManifiesto == null){
			this.itemsManifiesto = new ArrayList<ItemManifiesto>();
		}
		
		this.itemsManifiesto.add(itemManifiesto);		
	}


	public Manifiesto fromEntity(ManifiestoE manifiesto) {
		Manifiesto m = new Manifiesto();
		m.setFecha(manifiesto.getFecha());
		m.setIdManifiesto(manifiesto.getIdManifiesto());
		
		if(manifiesto.getItemsManifiesto()!=null){
			List<ItemManifiesto> list = new ArrayList<ItemManifiesto>();
	    	for(ItemManifiestoE item : manifiesto.getItemsManifiesto()){
	    		ItemManifiesto itm = new ItemManifiesto().fromEntity(item);
	    		list.add(itm);
	    	}
			m.setItemsManifiesto(list);
		}
		
		Encomienda e = new Encomienda();
		e.setIdEncomienda(manifiesto.getEncomienda().getIdEncomienda());
		
		m.setEncomienda(e);
		
		return m;
	}

}
