package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Set;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;

import ejemplo_1.bean.Alumno;
import ejemplo_1.interfaz.TDAManejoDatos;

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


}
