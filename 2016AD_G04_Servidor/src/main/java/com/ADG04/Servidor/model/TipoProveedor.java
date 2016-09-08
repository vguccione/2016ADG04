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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TipoProveedor")
public class TipoProveedor implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdTipoProveedor", unique = true, nullable = false)
	private int idTipoProveedor;

	@Column(name = "Descripcion", nullable = false, length = 100)
	private String descripcion;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoProveedor")
	private List<Proveedor> proveedores;

	public TipoProveedor() {
	}

	public TipoProveedor(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public int getIdTipoProveedor() {
		return this.idTipoProveedor;
	}

	public void setIdTipoProveedor(int idTipoProveedor) {
		this.idTipoProveedor = idTipoProveedor;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

}
