package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Producto;

public interface IClienteRemote {


	/************************ Cliente ******************************************/
	public void altaClienteParticular(DTO_ClienteParticular cliente) throws RemoteException;
	public void modificarClienteParticular(DTO_ClienteParticular cliente) throws RemoteException;
	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException;
	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException;
	public void eliminarCliente(Integer idCliente) throws RemoteException;
	
	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException;
	public DTO_ClienteParticular getClienteParticularByDni(String dni) throws RemoteException;
		
	public List<DTO_ClienteEmpresa> getClientesEmpresa() throws RemoteException;
	public List<DTO_ClienteParticular> getClientesParticular() throws RemoteException;
	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente) throws RemoteException;
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit) throws RemoteException;
	
	public List<DTO_ClienteParticular> buscarClientesByNombreApellidoDni (String filtro) throws RemoteException;
	public List<DTO_ClienteEmpresa> buscarClientesEmpresaByRazonSocial(String filtro) throws RemoteException;
	public boolean clienteTieneEncomiendas(Integer id) throws RemoteException;
	
	/************************ Producto ***********************************/
	public void altaProducto(DTO_Producto producto) throws RemoteException;
	public void modificarProducto(DTO_Producto producto) throws RemoteException;
	public void eliminarProducto(Integer idProducto) throws RemoteException;
	public void eliminarProducto(Integer idCliente, String codigoProducto) throws RemoteException;
	
	public DTO_Producto getProducto(Integer idProducto) throws RemoteException;
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto) throws RemoteException;
	public boolean estaProductoAsociado(Integer id) throws RemoteException;

}
