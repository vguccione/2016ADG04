package com.ADG04.Servidor.rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import com.ADG04.Negocio.GestionCliente;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.TipoCliente;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Remito;

public class DistribucionPaquetesRMI  extends UnicastRemoteObject implements InterfazRemotaDistribucionPaquetes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DistribucionPaquetesRMI() throws RemoteException {
		super();
	}

	public void altaUsuario(DTO_Usuario Usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void modificarUsuario(DTO_Usuario Usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void bajaUsuario(Integer idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public DTO_Usuario getUsuario(Integer idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaSucursal(DTO_Sucursal sucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarSucursal(DTO_Sucursal sucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void bajaSucursal(Integer idSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaCliente(DTO_ClienteParticular cliente) throws RemoteException {
		
		GestionCliente gCliente = GestionCliente.getInstancia();
		gCliente.altaCliente(cliente);
		
	}

	
	public void modificarCliente(DTO_ClienteParticular cliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void bajaCliente(Integer idCliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	
	public DTO_ClienteParticular getClienteParticular(String dni) throws RemoteException {

		DTO_ClienteParticular cdto = new DTO_ClienteParticular();
		//ClienteDao dao = new ClienteDao(EntityManagerProvider.getInstance().getEntityManager());
		//Cliente cliente = dao.getCliente(cuit);
		
		cdto.setDni("12345678");
		cdto.setNombre("Peperulo");
		cdto.setApellido("Perez");
		
		return cdto;
	}

	
	public List<DTO_ClienteParticular> getClientesEmpresa() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_ClienteParticular> getClientesParticular() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void agregarCreditoCtaCteByCuit(String clienteCuit, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void agregarCreditoCtaCteByIdCliente(int idCliente, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void descontarCreditoCtaCteByCuit(String clienteCuit, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void descontarCreditoCtaCteByIdCliente(int idCliente, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void setLimiteCreditoByCuit(String clienteCuit, float limiteCredito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void setLimiteCreditoByIdCliente(int idCliente, float limiteCredito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_Factura getFacturaClienteByCuit(String cuitCliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_Factura getFacturaClienteByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addItem(int idFactura, int cantidad, float valor,
			String descripcion) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteItem(int idFactura, int idItem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public List<DTO_Factura> getFacturasPendientesByCuit(String cuit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Factura> getFacturasPendientesByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Factura> getFacturasByCuit(String cuit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Factura> getFacturasByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_Usuario getUsuario(String dni) throws RemoteException {

		//UsuarioDao dao = new UsuarioDao(entityManager);
		DTO_Usuario usuario = new DTO_Usuario();
		
		usuario.setNombre("Vanesa");
		usuario.setApellido("Guccione");
		usuario.setDni("32437264");
		
		return usuario;
	}

	
	public DTO_ClienteParticular getClienteParticular(Integer idCliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaProducto(DTO_Producto producto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarProducto(DTO_Producto producto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void eliminarProducto(Integer idProducto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void eliminarProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_Producto getProducto(Integer idProducto) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void nuevaEncomiedaParticular(String dniCliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String tratamiento, boolean apilable,
			short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor,
			String dniReceptor, Double volumenGranel, String unidadGranel,
			String cargaGranel) throws RemoteException {
		
		GestionEncomienda gEnc = GestionEncomienda.getInstancia();
	}
	
	
	public void nuevaEncomiedaParticular(DTO_EncomiendaParticular encomiendaParticular) {
		
		GestionEncomienda gEnc = GestionEncomienda.getInstancia();
		
		gEnc.altaEncomiendaParticular(encomiendaParticular);
	}
						
	
	public void nuevaEncomiedaParticular(
			String dniCliente, 
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String nombreReceptor, String apellidoReceptor,String dniReceptor){
	
	}
								

	
	public void nuevaEncomiedaEmpresa(String dniCliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String tratamiento, boolean apilable,
			short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor,
			String dniReceptor, Double volumenGranel, String unidadGranel,
			String cargaGranel) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void setFechaEstimadaEntrega(int idEncomienda,
			Date fechaEstimadaDeEntrega) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void agregarRemito(int idEncomienda, DTO_Remito remito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void agregarProducto(DTO_Producto producto, int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void eliminarProducto(int idProducto, int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void nuevaEncomiedaParticular(String dniCliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String nombreReceptor, String apellidoReceptor,
			String dniReceptor) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
