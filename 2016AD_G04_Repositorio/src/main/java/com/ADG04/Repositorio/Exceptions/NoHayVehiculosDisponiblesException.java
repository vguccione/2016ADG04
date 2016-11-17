package com.ADG04.Repositorio.Exceptions;

import java.io.Serializable;
import java.io.Serializable;

public class NoHayVehiculosDisponiblesException extends BusinessException implements Serializable  {

	public NoHayVehiculosDisponiblesException(String msg) {
		super(msg);
	}

	public NoHayVehiculosDisponiblesException(Integer idSucursal) {
		super("No hay vehiculos disponibles en la sucursal " + idSucursal);
	}
}