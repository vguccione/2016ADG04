package com.ADG04.Negocio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.bean.Cliente.DTO_Producto;

public class Producto implements java.io.Serializable {

	private int idProducto;
	private Cliente cliente;
	private int codigoProducto;
	private String categoria;
	private String descripcion;
	private char unidad;
	private List<ProductoEncomienda> productoEncomiendas;
	private List<ItemManifiesto> manifiestos;
	private List<ItemRemito> remitos;

	public Producto() {
	}

	public Producto(Cliente cliente, int codigoProducto,
			String descripcion, char unidad) {
		this.cliente = cliente;
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.unidad = unidad;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public char getUnidad() {
		return this.unidad;
	}

	public void setUnidad(char unidad) {
		this.unidad = unidad;
	}

	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<ItemManifiesto> getManifiestos() {
		return manifiestos;
	}

	public void setManifiestos(List<ItemManifiesto> manifiestos) {
		this.manifiestos = manifiestos;
	}

	public List<ItemRemito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<ItemRemito> remitos) {
		this.remitos = remitos;
	}

	public DTO_Producto toDTO(){
		DTO_Producto prod = new DTO_Producto();
		prod.setCategoria(this.categoria);
		prod.setUnidad(this.unidad);
		prod.setCodigo(this.codigoProducto);
		prod.setDescripcion(this.descripcion);
		prod.setId(this.idProducto);
		
		return prod;
	}
}
