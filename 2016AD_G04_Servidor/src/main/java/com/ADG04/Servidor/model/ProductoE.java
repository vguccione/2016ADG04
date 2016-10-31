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
public class ProductoE implements java.io.Serializable {


	@Id
	@GeneratedValue
	@Column(name = "IdProducto", unique = true, nullable = false)
	private int idProducto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdCliente", nullable = false)
	private ClienteE cliente;

	@Column(name = "CodigoProducto", nullable = false)
	private int codigoProducto;
	
	@Column(name = "Categoria")
	private String categoria;

	@Column(name = "Descripcion", nullable = false, length = 100)
	private String descripcion;

	@Column(name = "Unidad", nullable = false, length = 1)
	private char unidad;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private List<ProductoEncomiendaE> productoEncomiendas;
	
	@OneToMany(mappedBy="producto")
	private List<ItemManifiestoE> manifiestos;
	
	@OneToMany(mappedBy="producto")
	private List<ItemRemitoE> remitos;

	public ProductoE() {
	}

	public ProductoE(ClienteE cliente, int codigoProducto,
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

	public ClienteE getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteE cliente) {
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

	public List<ProductoEncomiendaE> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomiendaE> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<ItemManifiestoE> getManifiestos() {
		return manifiestos;
	}

	public void setManifiestos(List<ItemManifiestoE> manifiestos) {
		this.manifiestos = manifiestos;
	}

	public List<ItemRemitoE> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<ItemRemitoE> remitos) {
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
