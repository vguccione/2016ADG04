package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG94.bean.Cliente.DTO_Factura;

public interface IFacturaRemote {

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
	//TODO: estos metodos, no van, las facturas se generan cuando se genera una nueva encomiendaa ???
	//No podemos dar de alta una factura si no hay una encmienda de por meido. ¿?¿?
	//public void altaFacturaCliente(DTO_Factura factura) throws RemoteException;
	//public void modificarFacturaCliente(DTO_Factura factura) throws RemoteException;
	public DTO_Factura getFacturaClienteByCuit(String cuitCliente) throws RemoteException;
	public DTO_Factura getFacturaClienteByDni(String dni) throws RemoteException;
	
	//Items de factura - una vez que tenes generada una factura, le podés agregar items ¡???
	//o solo se agrega a partir de la encomienda?????
	public void addItem(int idFactura, int cantidad, float valor, String descripcion) throws RemoteException;
	public void deleteItem(int idFactura, int idItem) throws RemoteException;
	
	public List<DTO_Factura> getFacturasPendientesByCuit(String cuit) throws RemoteException;
	public List<DTO_Factura> getFacturasPendientesByDni(String dni) throws RemoteException;
	public List<DTO_Factura> getFacturasByCuit(String cuit) throws RemoteException;
	public List<DTO_Factura> getFacturasByDni(String dni) throws RemoteException;

}
