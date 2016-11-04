package com.ADG04.Repositorio.Exceptions;

import java.io.Serializable;

public class SucursalNotFoundException  extends BusinessException implements Serializable {

	public SucursalNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public SucursalNotFoundException(int idSucursal){
		super("La sucursal " + idSucursal + " no existe");
	}
}
