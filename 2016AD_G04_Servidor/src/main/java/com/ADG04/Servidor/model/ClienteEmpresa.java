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
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

@Entity
@DiscriminatorValue("e")  
public class ClienteEmpresa extends Cliente implements java.io.Serializable {

	@Column(name = "RazonSocial", length = 50)
	private String razonSocial;
	
	@Column(name = "Cuit", length = 50)
	private String cuit;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <Producto> productos;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <CuentaCorriente> cuentaCorrientes;
	
	public ClienteEmpresa() {
		super();
	}

	

	public ClienteEmpresa(String razonSocial, String cuit) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}



	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getCuit() {
		return cuit;
	}



	public void setCuit(String cuit) {
		this.cuit = cuit;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public List<CuentaCorriente> getCuentaCorrientes() {
		return cuentaCorrientes;
	}



	public void setCuentaCorrientes(List<CuentaCorriente> cuentaCorrientes) {
		this.cuentaCorrientes = cuentaCorrientes;
	}



	public DTO_ClienteEmpresa toDTO(){
		DTO_ClienteEmpresa cli = new DTO_ClienteEmpresa();
		cli.setRazonSocial(this.razonSocial);
		cli.setCuit(this.cuit);
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());
		
		return cli;
	}
}
