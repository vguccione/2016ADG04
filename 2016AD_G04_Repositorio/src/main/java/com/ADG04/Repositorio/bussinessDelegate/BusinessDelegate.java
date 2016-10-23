package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Proveedor.DTO_Carrier;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TallerMecanico;

public class BusinessDelegate implements InterfazRemotaDistribucionPaquetes
{
 	private InterfazRemotaDistribucionPaquetes businessService;
  
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

	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException{
		return this.businessService.getClienteParticularById(idCliente);
	}
	
	public DTO_ClienteParticular getClienteParticularByDni(String dni) throws RemoteException{
		return this.businessService.getClienteParticularByDni(dni);
	}

	public DTO_Usuario getUsuario(String dni) throws RemoteException{
		return this.businessService.getUsuario(dni);
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


	public DTO_Usuario login(String usuario, String password)
			throws RemoteException {
		return this.businessService.login(usuario, password);
	}

	public List<String> buscarRolesUsuario(int usuario) throws RemoteException{
		return this.businessService.buscarRolesUsuario(usuario);
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


	public void altaSeguro(DTO_Seguro seguro) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarServicioSeguridad(
			DTO_ServicioSeguridad servicioSeguridad) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaTallerMecanico(DTO_TallerMecanico taller)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarTallerMecanico(DTO_TallerMecanico taller)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaCarrier(DTO_Carrier carrier) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarCarrier(DTO_Carrier carrier) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void bajaProveedor(Integer idProveedor) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void eliminarCliente(Integer idCliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public List<DTO_ClienteEmpresa> getClientesEmpresa()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<DTO_ClienteParticular> getClientesParticular()
			throws RemoteException {
		return this.businessService.getClientesParticular();
	}


	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
			throws RemoteException {
		return this.businessService.getClienteEmpresaById(idCliente);
	}


	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit)
			throws RemoteException {
		return this.businessService.getClienteEmpresaByCuit(cuit);
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
	


	public int nuevaEncomiedaParticular(String dniCliente,
			int idDireccionOrigen, int idDireccionDestino,
			int idSucursalOrigen, int idSucursalDestino, float largo,
			float ancho, float alto, float peso, float volumen,
			String tratamiento, boolean apilable, short cantApilable,
			boolean refrigerado, String condiciionTransporte,
			String indicacionesManipulacion, String fragilidad,
			String nombreReceptor, String apellidoReceptor, String dniReceptor,
			float volumenGranel, String unidadGranel) throws RemoteException {
		
		return this.businessService.nuevaEncomiedaParticular(dniCliente, idDireccionOrigen, idDireccionDestino, idSucursalOrigen, idSucursalDestino, 
				largo, ancho, alto, peso, volumen, tratamiento, apilable, cantApilable, refrigerado, condiciionTransporte, indicacionesManipulacion, 
				fragilidad, nombreReceptor, apellidoReceptor, dniReceptor, volumenGranel, unidadGranel);
		
	}
	
	public DTO_EnvioPropio getInfoEnvioPropio(int idEnvio) throws RemoteException{
		
		return this.businessService.getInfoEnvioPropio(idEnvio);
		
	}
	
	public Integer gestionarEnvioEncomienda(int idEncomienda) throws RemoteException{
		return this.businessService.gestionarEnvioEncomienda(idEncomienda);
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

		this.businessService.setFechaEstimadaEntrega(idEncomienda, fechaEstimadaDeEntrega);
		
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

	public void modificarCoordenadas(int idEnvio, DTO_Coordenada coordenadas)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
