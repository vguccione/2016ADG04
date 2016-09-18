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
@Table(name = "TipoCliente")
public class TipoCliente implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdTipoCliente", unique = true, nullable = false)
	private int idTipoCliente;

	@Column(name = "Descripcion", nullable = false, length = 100)
	private String descripcion;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCliente")
	private List<Cliente> clientes;
*/
	public TipoCliente() {
	}

	public TipoCliente(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public int getIdTipoCliente() {
		return this.idTipoCliente;
	}

	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

/*	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
*/

}
