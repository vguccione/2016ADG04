package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG94.bean.Cliente.DTO_Cliente;

public interface IClienteRemote {


	/************************ Cliente ******************************************/
	public void altaCliente(DTO_Cliente cliente) throws RemoteException;
	public void modificarCliente(DTO_Cliente cliente) throws RemoteException;
	public void bajaCliente(Integer idCliente) throws RemoteException;
	public DTO_Cliente getCliente(Integer idCliente) throws RemoteException;
	public DTO_Cliente getClienteByCuit(String cuit) throws RemoteException;
	public DTO_Cliente getClienteByDni(String dni) throws RemoteException;
	public List<DTO_Cliente> getClientesEmpresa() throws RemoteException;
	public List<DTO_Cliente> getClientesParticular() throws RemoteException;
	
	
}
