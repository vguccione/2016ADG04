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
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

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
		return this.businessService.getSucursal(idSucursal);
	}


	public void altaSeguro(DTO_Seguro seguro) throws RemoteException {
		this.businessService.altaSeguro(seguro);
	}


	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException {
		this.businessService.modificarSeguro(seguro);
		
	}


	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad)
			throws RemoteException {
		this.businessService.altaServicioSeguridad(servicioSeguridad);
		
	}


	public void modificarServicioSeguridad(
			DTO_ServicioSeguridad servicioSeguridad) throws RemoteException {
		this.businessService.modificarServicioSeguridad(servicioSeguridad);
		
	}
	
	public void altaTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		this.businessService.altaTarifasCarrier(tarifasCarrier);
		
	}


	public void modificarTarifasCarrier(DTO_TarifasCarrier tarifasCarrier) throws RemoteException {
		this.businessService.modificarTarifasCarrier(tarifasCarrier);
		
	}


	public void bajaProveedor(Integer idProveedor) throws RemoteException {
		this.businessService.bajaProveedor(idProveedor);
		
	}


	public void altaClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		this.businessService.altaClienteParticular(cliente);
		
	}


	public void modificarClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		this.businessService.modificarClienteParticular(cliente);
		
	}


	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		this.businessService.altaClienteEmpresa(empresa);
		
	}


	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		this.businessService.modificarClienteEmpresa(empresa);
	}


	public void eliminarCliente(Integer idCliente) throws RemoteException {
		this.businessService.eliminarCliente(idCliente);
		
	}


	public List<DTO_ClienteEmpresa> getClientesEmpresa()
			throws RemoteException {
		return this.businessService.getClientesEmpresa();
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
		this.businessService.altaProducto(producto);
		
	}


	public void modificarProducto(DTO_Producto producto) throws RemoteException {
		this.businessService.modificarProducto(producto);
	}


	public void eliminarProducto(Integer idProducto) throws RemoteException {
		this.businessService.eliminarProducto(idProducto);
		
	}


	public void eliminarProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public DTO_Producto getProducto(Integer idProducto) throws RemoteException {
		return this.businessService.getProducto(idProducto);
	}


	public DTO_Producto getProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		return this.businessService.getProducto(idCliente, codigoProducto);
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
		return this.businessService.getFacturaClienteByCuit(cuitCliente);
	}


	public DTO_Factura getFacturaClienteByDni(String dni)
			throws RemoteException {

		return this.businessService.getFacturaClienteByDni(dni);
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
		return this.businessService.getFacturasPendientesByCuit(cuit);
	}


	public List<DTO_Factura> getFacturasPendientesByDni(String dni)
			throws RemoteException {
		return this.businessService.getFacturasPendientesByDni(dni);
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

	public void ingresarEncomiendaEnvio(Integer idEnvio) {
		// TODO Auto-generated method stub
		
	}

	public void egresarEncomiendaEnvio(Integer idEnvio) {
		// TODO Auto-generated method stub
		
	}

	public Integer asignarEnvio(Integer idEncomienda) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaEmpresa(List<Integer> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaParticular(Integer idFactura) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer confirmarEncomiendaEmpresa(DTO_EncomiendaEmpresa enc) throws RemoteException {
		// TODO Auto-generated method stub
		return this.businessService.confirmarEncomiendaEmpresa(enc);
	}

	public Integer confirmarEncomiendaParticular(DTO_EncomiendaParticular enc) throws RemoteException {
		return this.businessService.confirmarEncomiendaParticular(enc);
	}

	public Integer nuevaEncomiendaParticular(Integer idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer nuevaEncomiendaEmpresa(Integer idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	public DTO_Usuario validarUsuario(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer altaVehiculo(DTO_Vehiculo v) throws RemoteException {
		return this.businessService.altaVehiculo(v);
	}

	public void altaTareaMantenimiento(DTO_TareasPorKilometro tareaXKM, Integer idVehiculo) throws RemoteException, Exception  {
		this.businessService.altaTareaMantenimiento(tareaXKM, idVehiculo);		
	}

	public Integer altaPlanMantenimiento(DTO_PlanMantenimiento pm, Integer idVehiculo)throws RemoteException , Exception {
		return this.businessService.altaPlanMantenimiento(pm, idVehiculo);
	}

	public Integer altaTareaMantenimiento(DTO_TareasPorTiempo tareaXTiempo, Integer idVehiculo) throws RemoteException, Exception   {
		return this.businessService.altaTareaMantenimiento(tareaXTiempo, idVehiculo);
	}

	public List<com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento> getTareasVencidas(int idVehiculo) throws RemoteException   {
		return this.businessService.getTareasVencidas(idVehiculo);
	}

	public void altaProveedor(DTO_Proveedor prov) throws RemoteException {
		this.businessService.altaProveedor(prov);
		
	}

	public List<DTO_Seguro> getSeguros() throws RemoteException {
		return this.businessService.getSeguros();
	}

	public List<DTO_TarifasCarrier> getTarifasCarriers() throws RemoteException {
		return this.businessService.getTarifasCarriers();
	}

	public List<DTO_ServicioSeguridad> getServicioSeguridad()
			throws RemoteException {
		return this.businessService.getServicioSeguridad();
	}

	public List<DTO_Proveedor> getTalleresMecanicos()
			throws RemoteException {
		return this.businessService.getTalleresMecanicos();
	}
	
	public List<DTO_Proveedor> getAseguradoras()
			throws RemoteException {
		return this.businessService.getAseguradoras();
	}
	
	public List<DTO_Proveedor> getEmpresasServiciosSeguridad()
			throws RemoteException {
		return this.businessService.getEmpresasServiciosSeguridad();
	}

	public List<DTO_Proveedor> getCarriers()
			throws RemoteException {
		return this.businessService.getCarriers();
	}
	
	public List<DTO_Vehiculo> listarVehiculos() throws RemoteException {
		return null;
	}

	public void altaTallerMecanico(DTO_Proveedor taller) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void modificarTallerMecanico(DTO_Proveedor taller)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public List<DTO_Proveedor> getProveedores() throws RemoteException {
		// TODO Auto-generated method stub
		return this.businessService.getProveedores();
	}

	public DTO_Proveedor getProveedor(Integer idProveedor) throws RemoteException {
		return this.businessService.getProveedor(idProveedor);
		
	}

	public Integer facturarEncomiendaEmpresa(int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaEmpresa(Integer idFactura)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DTO_Usuario getEmpleado(Integer idEmpleado) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer facturarEncomiendaParticular(DTO_EncomiendaParticular enc)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
