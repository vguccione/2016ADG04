package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class DTO_EncomiendaEmpresa extends DTO_Encomienda implements Serializable{

	private static final long serialVersionUID = 1L;

	private DTO_ClienteEmpresa empresa;

	public DTO_EncomiendaEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_ClienteEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(DTO_ClienteEmpresa empresa) {
		this.empresa = empresa;
	}
	
	
}
