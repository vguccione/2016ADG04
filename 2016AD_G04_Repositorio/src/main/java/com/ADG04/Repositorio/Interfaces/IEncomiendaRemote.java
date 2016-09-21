package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Remito;

public interface IEncomiendaRemote {

	public void nuevaEncomiedaParticular(
			String dniCliente, 
			DTO_Direccion direccionOrigen, 
			DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String tratamiento, boolean apilable, short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion, 
			String fragilidad, String nombreReceptor, String apellidoReceptor,String dniReceptor,
			Double volumenGranel, String unidadGranel, String cargaGranel) 
					throws RemoteException;

	public void nuevaEncomiedaParticular(
			String dniCliente, 
			DTO_Direccion direccionOrigen, 
			DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String nombreReceptor, String apellidoReceptor,String dniReceptor) 
					throws RemoteException;


	public void nuevaEncomiedaParticular(DTO_EncomiendaParticular encomiendaParticular) throws RemoteException;
	
	public void nuevaEncomiedaParticular(
			String dniCliente, 
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String nombreReceptor, String apellidoReceptor,String dniReceptor) 
					throws RemoteException;
	
	
	public void nuevaEncomiedaEmpresa(
			String dniCliente, 
			DTO_Direccion direccionOrigen, 
			DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String tratamiento, boolean apilable, short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion, 
			String fragilidad, String nombreReceptor, String apellidoReceptor,String dniReceptor,
			Double volumenGranel, String unidadGranel, String cargaGranel) 
					throws RemoteException;
	
	public void setFechaEstimadaEntrega(int idEncomienda, Date fechaEstimadaDeEntrega) throws RemoteException;
	
	public void agregarRemito(int idEncomienda, DTO_Remito remito) throws RemoteException;
	
	public void agregarProducto(DTO_Producto producto, int idEncomienda) throws RemoteException;
	public void eliminarProducto(int idProducto, int idEncomienda) throws RemoteException;

}
