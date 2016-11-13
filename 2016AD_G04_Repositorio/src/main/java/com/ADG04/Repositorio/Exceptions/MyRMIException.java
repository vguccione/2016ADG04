package com.ADG04.Repositorio.Exceptions;

import java.io.Serializable;
import java.rmi.RemoteException;

public class MyRMIException extends Exception implements Serializable{

	public MyRMIException(){
		super();
	}
	
	public MyRMIException(String msg){
		super(msg);
	}
	
	public MyRMIException(String msg, Throwable cause){
		super(msg, cause);
	}
}
