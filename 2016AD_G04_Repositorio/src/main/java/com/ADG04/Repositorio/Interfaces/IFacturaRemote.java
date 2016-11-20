package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.bean.Cliente.DTO_Factura;

public interface IFacturaRemote {

	
	public void pagarFactura(int idEncomienda)throws RemoteException;
	
	public DTO_Factura getFacturaById(Integer id) throws RemoteException;
	
	/************************** Cta Cte *****************************************/
	//agregar credito
	public void agregarCreditoCtaCteByCuit(String clienteCuit, float credito) throws RemoteException;
	public void agregarCreditoCtaCteByIdCliente(int idCliente, float credito) throws RemoteException;

	//Descontar credito
	public void descontarCreditoCtaCteByCuit(String clienteCuit, float credito) throws RemoteException;
	public void descontarCreditoCtaCteByIdCliente(int idCliente, float credito) throws RemoteException;	
	
	//Actualizar limite de credito
	public void setLimiteCreditoByCuit(String clienteCuit, float limiteCredito) throws RemoteException;
	public void setLimiteCreditoByIdCliente(int idCliente, float limiteCredito) throws RemoteException;
	
	/************************** Facturas Cliente **************************************/

	public DTO_Factura getFacturaClienteByCuit(String cuitCliente) throws RemoteException;
	public DTO_Factura getFacturaClienteByDni(String dni) throws RemoteException;
	public List<DTO_Factura> buscarFacturasByDniCliente(String filtro)  throws RemoteException;
	public List<DTO_Factura> listarFacturasCliente() throws RemoteException;
	public List<DTO_Factura> listarFacturasClientePendientes() throws RemoteException;
	public List<DTO_Factura> buscarFacturasPendientesByDniCliente(String filtro) throws RemoteException;	

	public void addItem(int idFactura, int cantidad, float valor, String descripcion) throws RemoteException;
	public void deleteItem(int idFactura, int idItem) throws RemoteException;
	
	public List<DTO_Factura> getFacturasPendientesByCuit(String cuit) throws RemoteException;
	public List<DTO_Factura> getFacturasPendientesByDni(String dni) throws RemoteException;
	public List<DTO_Factura> getFacturasByCuit(String cuit) throws RemoteException;
	public List<DTO_Factura> getFacturasByDni(String dni) throws RemoteException;

}
