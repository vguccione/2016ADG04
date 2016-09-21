package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Set;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

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

	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException{
		return this.businessService.getClienteParticularById(idCliente);
	}
	
	public DTO_ClienteParticular getClienteParticularByDni(String dni) throws RemoteException{
		return this.businessService.getClienteParticularByDni(dni);
	}

	public DTO_Usuario getUsuario(String dni) throws RemoteException{
		return this.businessService.getUsuario(dni);
	}
}
