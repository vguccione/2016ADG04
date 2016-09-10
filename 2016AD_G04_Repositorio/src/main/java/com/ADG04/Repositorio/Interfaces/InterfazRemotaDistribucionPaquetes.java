package com.ADG04.Repositorio.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ADG94.bean.ClienteDTO;


public interface InterfazRemotaDistribucionPaquetes extends Remote{
	public static final String url = "localhost/DistribucionPaquetesRMI";
	
	//Empleado
	/*public void altaEmpleado(DTO_Empleado empleado) throws RemoteException;
	public void modificarEmpleado(DTO_Empleado empleado) throws RemoteException;
	public void bajaEmpleado(Integer idEmpleado) throws RemoteException;
	*/
	
	//Clientes
	public ClienteDTO getCliente(String cuit) throws RemoteException;
	
}
