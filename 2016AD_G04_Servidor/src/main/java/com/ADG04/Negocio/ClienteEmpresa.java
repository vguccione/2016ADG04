package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;


public class ClienteEmpresa extends Cliente implements java.io.Serializable {

	private String razonSocial;
	private String cuit;
	private List <Producto> productos;
	private CuentaCorriente cuentaCorrientes;
	
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



	public CuentaCorriente getCuentaCorrientes() {
		return cuentaCorrientes;
	}



	public void setCuentaCorrientes(CuentaCorriente cuentaCorrientes) {
		this.cuentaCorrientes = cuentaCorrientes;
	}



	public DTO_ClienteEmpresa toDTO(){
		DTO_ClienteEmpresa cli = new DTO_ClienteEmpresa();
		cli.setId(this.getIdCliente());
		cli.setRazonSocial(this.razonSocial);
		cli.setCuit(this.cuit);
		cli.setEmail(this.getEmail());	
		cli.setEstado(this.getEstado());
		cli.setTelefono(this.getTelefono());
			
		cli.setDireccion(this.getDireccion().toDTO());
		
		return cli;
	}
}
