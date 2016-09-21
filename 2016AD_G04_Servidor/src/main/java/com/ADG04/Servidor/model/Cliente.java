package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

@Entity
@Table(name = "Cliente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TipoCliente",discriminatorType=DiscriminatorType.CHAR) 
@DiscriminatorValue("c")
public class Cliente implements java.io.Serializable {

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
	private List <Encomienda> encomiendas;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="IdDireccion")
	private Direccion direccion;

	public Cliente() {
	}



	public Cliente(int idCliente, boolean estado, String email, String telefono) {
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

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
				

}
