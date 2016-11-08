package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ADG04.Negocio.Direccion;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;


@Entity
@Table(name = "Cliente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TipoCliente",discriminatorType=DiscriminatorType.CHAR) 
@DiscriminatorValue("c")
public class ClienteE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdCliente", unique = true, nullable = false)
	private int idCliente;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTipoCliente", nullable = false)
	private TipoCliente tipoCliente;
	*/
	
	@Column(name = "Estado", nullable = false)
	private boolean estado;
	
	@Column(name = "Email", nullable = false, length = 50)
	private String email;

	@Column(name = "Telefono", nullable = false, length = 50)
	private String telefono;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <EncomiendaE> encomiendas;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="IdDireccion")
	private DireccionE direccion;

	public ClienteE() {
	}

	public ClienteE(int idCliente, boolean estado, String email, String telefono) {
		super();
		this.idCliente = idCliente;
		this.estado = estado;
		this.email = email;
		this.telefono = telefono;
	}
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public boolean getEstado(){
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EncomiendaE> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<EncomiendaE> encomiendas) {
		this.encomiendas = encomiendas;
	}

	public DireccionE getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionE direccion) {
		this.direccion = direccion;
	}

	

}
