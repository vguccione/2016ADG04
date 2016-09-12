package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG94.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG94.bean.Cliente.DTO_ClienteParticular;
import com.ADG94.bean.Cliente.DTO_Producto;

public interface IClienteRemote {


	/************************ Cliente ******************************************/
	public void altaCliente(DTO_ClienteParticular cliente) throws RemoteException;
	public void modificarCliente(DTO_ClienteParticular cliente) throws RemoteException;
	public void bajaCliente(Integer idCliente) throws RemoteException;
	
	public DTO_ClienteParticular getClienteParticular(Integer idCliente) throws RemoteException;
	public DTO_ClienteParticular getClienteParticular(String dni) throws RemoteException;
		
	public List<DTO_ClienteParticular> getClientesEmpresa() throws RemoteException;
	public List<DTO_ClienteParticular> getClientesParticular() throws RemoteException;
	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente) throws RemoteException;
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit) throws RemoteException;
	
	/************************ Producto ***********************************/
	public void altaProducto(DTO_Producto producto) throws RemoteException;
	public void modificarProducto(DTO_Producto producto) throws RemoteException;
	public void eliminarProducto(Integer idProducto) throws RemoteException;
	public void eliminarProducto(Integer idCliente, String codigoProducto) throws RemoteException;
	
	public DTO_Producto getProducto(Integer idProducto) throws RemoteException;
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto) throws RemoteException;

}
