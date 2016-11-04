package com.ADG04.Repositorio.Exceptions;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable  {

	public BusinessException(String msg) {
		super(msg);
	}

}
