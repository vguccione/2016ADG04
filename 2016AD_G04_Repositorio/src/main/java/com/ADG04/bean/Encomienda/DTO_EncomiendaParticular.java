package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public  class DTO_EncomiendaParticular extends DTO_Encomienda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DTO_ClienteParticular cliente;
	
	public DTO_EncomiendaParticular() {
		super();
	}

	public DTO_ClienteParticular getCliente() {
		return cliente;
	}

	public void setCliente(DTO_ClienteParticular cliente) {
		this.cliente = cliente;
	}


}
