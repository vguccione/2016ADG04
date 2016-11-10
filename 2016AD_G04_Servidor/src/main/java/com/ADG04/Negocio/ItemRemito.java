package com.ADG04.Negocio;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.ADG04.Servidor.model.ItemRemitoE;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;

public class ItemRemito{
	
	private int idItemRemito;
	private Remito remito;
	private String descripcion;
	private int cantidad;
	private Producto producto;

	public ItemRemito() {
	}


	public ItemRemito(int idItemRemito,String descripcion,
			int cantidad) {
		super();
		this.idItemRemito = idItemRemito;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
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


	public int getIdItemRemito() {
		return idItemRemito;
	}


	public void setIdItemRemito(int idItemRemito) {
		this.idItemRemito = idItemRemito;
	}


	public Remito getRemito() {
		return remito;
	}


	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public DTO_ItemRemito toDTO() {
		DTO_ItemRemito item= new DTO_ItemRemito();
    	item.setCantidad(this.cantidad);
    	item.setDescripcion(this.descripcion);
    	item.setId(this.idItemRemito);
    	return item;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public ItemRemito fromEntity(ItemRemitoE item) {
		ItemRemito ir = new ItemRemito();
		ir.setCantidad(item.getCantidad());
		ir.setDescripcion(item.getDescripcion());
		ir.setIdItemRemito(item.getIdItemRemito());
		ir.setProducto(new Producto().fromEntity(item.getProducto()));
		return ir;
	}
	
	
}
