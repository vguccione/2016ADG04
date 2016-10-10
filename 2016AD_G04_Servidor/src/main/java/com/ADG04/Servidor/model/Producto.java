package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ADG04.bean.Cliente.DTO_Producto;

@Entity
@Table(name = "Producto")
public class Producto implements java.io.Serializable {


	@Id
	@GeneratedValue
	@Column(name = "IdProducto", unique = true, nullable = false)
	private int idProducto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCliente", nullable = false)
	private Cliente cliente;

	@Column(name = "CodigoProducto", nullable = false)
	private int codigoProducto;
	
	@Column(name = "Categoria")
	private String categoria;

	@Column(name = "Descripcion", nullable = false, length = 100)
	private String descripcion;

	@Column(name = "Unidad", nullable = false, length = 1)
	private char unidad;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private List<ProductoEncomienda> productoEncomiendas;
	
	@OneToMany(mappedBy="producto")
	private List<ItemManifiesto> manifiestos;
	
	@OneToMany(mappedBy="producto")
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
