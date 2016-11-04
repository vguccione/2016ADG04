package com.ADG04.Repositorio.Exceptions;

import java.io.Serializable;

public class ClientNotFoundException extends BusinessException implements Serializable {

	public ClientNotFoundException(){
		super("El Cliente no existe");
	}
	
	public ClientNotFoundException(String msg) {
		super(msg);
		
	}

	
}
