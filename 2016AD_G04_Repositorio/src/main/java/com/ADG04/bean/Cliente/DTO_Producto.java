package com.ADG04.bean.Cliente;

import java.io.Serializable;

public class DTO_Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idProducto;
	private String codigo;
	private String descripcion;
	private String categoria;
	private String unidad;
	private Integer idCliente;
	
	public DTO_Producto(){
	}
	
	public Integer getId() {
		return idProducto;
	}

	public void setId(Integer id) {
		this.idProducto = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
