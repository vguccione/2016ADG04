package com.ADG04.bean.Cliente;

import java.io.Serializable;

import com.ADG04.bean.Administracion.DTO_Direccion;

public class DTO_ClienteEmpresa extends DTO_Cliente  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String razonSocial;
	private String cuit;

	private DTO_CuentaCorriente cuentaCorriente;
	
	public DTO_ClienteEmpresa(){
		
	}

	public DTO_ClienteEmpresa(Integer id, DTO_Direccion direccion, String email,String telefono, boolean estado, 
			String razonSocial, String cuit) {
		super(id, direccion, email, telefono, estado);
		this.cuit=cuit;
		this.razonSocial=razonSocial;
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


	public DTO_CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(DTO_CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

}
