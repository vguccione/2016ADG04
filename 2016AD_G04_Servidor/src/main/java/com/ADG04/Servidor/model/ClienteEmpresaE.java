package com.ADG04.Servidor.model;
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

import com.ADG04.Negocio.Direccion;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;


@Entity
@DiscriminatorValue("e")  
public class ClienteEmpresaE extends ClienteE implements java.io.Serializable {

	@Column(name = "RazonSocial", length = 50)
	private String razonSocial;
	
	@Column(name = "Cuit", length = 50)
	private String cuit;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List <ProductoE> productos;


	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="IdCuentaCorriente")
	private CuentaCorrienteE cuentaCorrientes;
	
	public ClienteEmpresaE() {
		super();
	}

	

	public ClienteEmpresaE(String razonSocial, String cuit) {
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



	public List<ProductoE> getProductos() {
		return productos;
	}



	public void setProductos(List<ProductoE> productos) {
		this.productos = productos;
	}



	public CuentaCorrienteE getCuentaCorrientes() {
		return cuentaCorrientes;
	}



	public void setCuentaCorrientes(CuentaCorrienteE cuentaCorrientes) {
		this.cuentaCorrientes = cuentaCorrientes;
	}

}
