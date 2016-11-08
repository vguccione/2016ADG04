package com.ADG04.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_ItemFactura;

public class DTO_EncomiendaEmpresa extends DTO_Encomienda implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<DTO_ProductoEncomienda> productos;
	
	private DTO_ClienteEmpresa empresa;

	public DTO_EncomiendaEmpresa() {
		super();
		this.productos = new ArrayList<DTO_ProductoEncomienda>();
	}

	public DTO_ClienteEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(DTO_ClienteEmpresa empresa) {
		this.empresa = empresa;
	}
	
	public void addProducto(DTO_ProductoEncomienda prod){
		this.productos.add(prod);
	}

	public List<DTO_ProductoEncomienda> getProductos() {
		return productos;
	}

	public void setProductos(List<DTO_ProductoEncomienda> productos) {
		this.productos = productos;
	}
	
}
