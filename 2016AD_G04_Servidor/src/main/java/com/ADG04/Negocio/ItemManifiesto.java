package com.ADG04.Negocio;

import com.ADG04.Servidor.model.ItemManifiestoE;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;

public class ItemManifiesto{

	private int idItemManifiesto;
	private String descripcion;
	private int cantidad;
	private Producto producto;

	public ItemManifiesto() {
	}

	

	public ItemManifiesto(String descripcion, int cantidad, Producto producto) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	

	public int getIdItemManifiesto() {
		return idItemManifiesto;
	}



	public void setIdItemManifiesto(int idItemManifiesto) {
		this.idItemManifiesto = idItemManifiesto;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DTO_ItemManifiesto toDTO(){
    	DTO_ItemManifiesto im = new DTO_ItemManifiesto();
    	im.setCantidad(this.cantidad);
    	im.setDescripcion(this.descripcion);
    	
    	if(this.getProducto() != null)
    		im.setProducto(this.getProducto().toDTO());
    	im.setIdManifiesto(this.idItemManifiesto);
    	return im;
    }



	public ItemManifiesto fromEntity(ItemManifiestoE itemE) {
		ItemManifiesto item = new ItemManifiesto();
		item.setCantidad(itemE.getCantidad());
		item.setDescripcion(itemE.getDescripcion());
		
		if(itemE.getProducto() != null)
			item.setProducto(new Producto().fromEntity(itemE.getProducto()));
		
		item.setIdItemManifiesto(itemE.getIdItemManifiesto());
		return item;
	}

}
