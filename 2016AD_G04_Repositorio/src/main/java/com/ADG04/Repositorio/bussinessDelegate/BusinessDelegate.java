package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Set;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG94.bean.Cliente.DTO_Cliente;

public class BusinessDelegate
{
 	private InterfazRemotaDistribucionPaquetes businessService;
  
	public InterfazRemotaDistribucionPaquetes getBusinessService() {
		
		return businessService;
	}


	public BusinessDelegate() throws MalformedURLException, RemoteException, NotBoundException {
		super();
		try {
			this.businessService =(InterfazRemotaDistribucionPaquetes)Naming.lookup (InterfazRemotaDistribucionPaquetes.url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public DTO_Cliente getClienteByCuit(String cuit) throws RemoteException{
		return this.businessService.getClienteByCuit(cuit);
	}
	
	public DTO_Cliente getClienteByDni(String dni) throws RemoteException{
		return this.businessService.getClienteByDni(dni);
	}

}
