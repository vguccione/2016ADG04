package com.ADG04.Servidor.rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;


public class DistribucionPaquetesRMI  extends UnicastRemoteObject implements InterfazRemotaDistribucionPaquetes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DistribucionPaquetesRMI() throws RemoteException {
		super();
	}
	
}
