package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Set;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG94.bean.ClienteDTO;


public class BusinessDelegate
{
 
  private InterfazRemotaDistribucionPaquetes businessService;
  
  
  /* da de alta empleado */ 
  /*public void altaEmpleado(DTO_Empleado empleado) throws RemoteException{
   		businessService.altaEmpleado(empleado);
	}
	 
	public void modificarEmpleado(DTO_Empleado empleado) throws RemoteException{
		businessService.modificarEmplead(empleado);
	}
	
	public void bajaEmpleado(Integer idEmpleado) throws RemoteException{
		businessSernvice.bajaEmpleado(idEmpleado)
	}
*/
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

	public ClienteDTO getCliente(String cuit) throws RemoteException{
		return this.businessService.getCliente(cuit);
	}

}
