package com.ADG04.Servidor.rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ADG04.Negocio.Cliente;
import com.ADG04.Negocio.ClienteEmpresa;
import com.ADG04.Negocio.ClienteParticular;
import com.ADG04.Negocio.CuentaCorriente;
import com.ADG04.Negocio.Direccion;
import com.ADG04.Negocio.Encomienda;
import com.ADG04.Negocio.EncomiendaParticular;
import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Negocio.GestionVehiculo;
import com.ADG04.Negocio.ItemManifiesto;
import com.ADG04.Negocio.Manifiesto;
import com.ADG04.Negocio.Pais;
import com.ADG04.Negocio.PlanMantenimiento;
import com.ADG04.Negocio.Producto;
import com.ADG04.Negocio.Proveedor;
import com.ADG04.Negocio.Provincia;
import com.ADG04.Negocio.Rol;
import com.ADG04.Negocio.Seguro;
import com.ADG04.Negocio.ServicioSeguridad;
import com.ADG04.Negocio.Sucursal;
import com.ADG04.Negocio.TareaMantenimiento;
import com.ADG04.Negocio.TareaMantenimientoPorKm;
import com.ADG04.Negocio.TareaMantenimientoPorTiempo;
import com.ADG04.Negocio.TareaMantenimientoRealizada;
import com.ADG04.Negocio.TarifasCarrier;
import com.ADG04.Negocio.Usuario;
import com.ADG04.Negocio.Vehiculo;
import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.Exceptions.SucursalNotFoundException;
import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.dao.RolDao;
import com.ADG04.Servidor.dao.TareaMantenimientoDao;
import com.ADG04.Servidor.dao.TareaMantenimientoRealizadaDao;
import com.ADG04.Servidor.dao.TarifasCarrierDao;
import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.CuentaCorrienteE;
import com.ADG04.Servidor.model.FacturaE;
import com.ADG04.Servidor.model.PaisE;
import com.ADG04.Servidor.model.PlanMantenimientoE;
import com.ADG04.Servidor.model.ProvinciaE;
import com.ADG04.Servidor.model.RolE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.model.TareaMantenimientoRealizadaE;
import com.ADG04.Servidor.model.TarifasCarrierE;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;


public class DistribucionPaquetesRMI  extends UnicastRemoteObject implements InterfazRemotaDistribucionPaquetes {

	private static final long serialVersionUID = 1L;

	public DistribucionPaquetesRMI() throws RemoteException {
		super();
	}
	

	public void altaUsuario(DTO_Usuario usuario) throws RemoteException {
		Usuario u=new Usuario().fromDTO(usuario);
		u.guardar();	
	}

	public void modificarUsuario(DTO_Usuario usuario) throws RemoteException {	
		Usuario u=new Usuario().fromDTO(usuario);
		u.modificar();
	}

	public void bajaUsuario(Integer idUsuario) throws RemoteException {
		UsuarioDao.getInstancia().removeById(idUsuario);
	}

	public DTO_Usuario getUsuario(Integer idUsuario) throws RemoteException {
		UsuarioE usu = UsuarioDao.getInstancia().getById(idUsuario);
		if(usu!=null){
			Usuario usuario = new Usuario().fromEntity(usu);
			return usuario.toDTO();
		}
		else 
			return null;
	}

	public DTO_Usuario getUsuario(String dni) throws RemoteException {
		UsuarioE usu = UsuarioDao.getInstancia().getByDni(dni);
		if(usu!=null){
			Usuario usuario = new Usuario().fromEntity(usu);
			return usuario.toDTO();
		}else
			return null;
	}
	
	public void altaSucursal(DTO_Sucursal sucursal) throws RemoteException {
		Sucursal suc = new Sucursal().fromDTO(sucursal);
		suc.guardar();
	}

	
	public void modificarSucursal(DTO_Sucursal sucursal) throws RemoteException {
		Sucursal suc = new Sucursal().fromDTO(sucursal);
		suc.modificar();
	}

	
	public void bajaSucursal(Integer idSucursal) throws RemoteException {
		SucursalDao.getInstancia().removeById(idSucursal);	
	}

	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		 SucursalE suc = SucursalDao.getInstancia().getById(idSucursal);
		 if(suc!=null){
			 Sucursal sucursal = new Sucursal().fromEntity(suc);
			 return sucursal.toDTO();
		 }
		 else
			 return null;
	}

	
	public void altaClienteParticular(DTO_ClienteParticular cliente) throws RemoteException {	
		Direccion dir = new Direccion().fromDTO(cliente.getDireccion());
		ClienteParticular cli = new ClienteParticular();
		cli.setApellido(cliente.getApellido());
		cli.setDireccion(dir);
		cli.setDni(cliente.getDni());
		cli.setEmail(cliente.getEmail());
		cli.setEstado(cliente.isEstado());
		cli.setNombre(cliente.getNombre());
		cli.setTelefono(cliente.getTelefono());
		cli.guardar();
	}

	
	public void modificarClienteParticular(DTO_ClienteParticular cliente) throws RemoteException {
		Direccion dir = new Direccion().fromDTO(cliente.getDireccion());
		ClienteParticular cli = new ClienteParticular();
		cli.setApellido(cliente.getApellido());
		cli.setDireccion(dir);
		cli.setDni(cliente.getDni());
		cli.setEmail(cliente.getEmail());
		cli.setEstado(cliente.isEstado());
		cli.setNombre(cliente.getNombre());
		cli.setTelefono(cliente.getTelefono());
		cli.setIdCliente(cliente.getId());
		cli.modificar();
	}

	
	public void bajaCliente(Integer idCliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ClienteParticularE getClienteByDni(String dniCliente) {		
		return ClienteParticularDao.getInstancia().getByDni(dniCliente);
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

	
	public List<DTO_ClienteEmpresa> getClientesEmpresa() throws RemoteException {
		List<ClienteEmpresaE> clientes = ClienteEmpresaDao.getInstancia().listarClientes();
		List<DTO_ClienteEmpresa> clientesDTO = new ArrayList<DTO_ClienteEmpresa>();
		for(ClienteEmpresaE cliente : clientes){
			ClienteEmpresa cli = new ClienteEmpresa().fromEntity(cliente);
			clientesDTO.add(cli.toDTO());
		}
		return clientesDTO;
	}

	
	public List<DTO_ClienteParticular> getClientesParticular() throws RemoteException {
		List<ClienteParticularE> clientes = ClienteParticularDao.getInstancia().listarClientes();
		List<DTO_ClienteParticular> clientesDTO = new ArrayList<DTO_ClienteParticular>();
		for(ClienteParticularE cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
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
	
	public DTO_ClienteParticular getClienteParticular(Integer idCliente)
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
		Producto prod = new Producto().fromDTO(producto);
		prod.guardar();
	}

	
	public void modificarProducto(DTO_Producto producto) throws RemoteException {
		Producto prod = new Producto().fromDTO(producto);
		prod.modificar();
	}

	
	public void eliminarProducto(Integer idProducto) throws RemoteException {
		ProductoDao.getInstancia().removeById(idProducto);
	}

	
	public DTO_Producto getProducto(Integer idProducto) throws RemoteException {
		Producto prod = new Producto().fromEntity(ProductoDao.getInstancia().getById(idProducto));
		return prod.toDTO();
	}

	
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer nuevaEncomiedaParticular(DTO_EncomiendaParticular encP) throws BusinessException {
		
		//Cuando creo la encomienda, la sucursal actual es la misma que la de origen
		Sucursal sucursalActual = new Sucursal();
		sucursalActual.setIdSucursal(encP.getSucursalOrigen().getId());
		
		Sucursal sucursalOrigen = new Sucursal();
		sucursalOrigen.setIdSucursal(encP.getSucursalOrigen().getId());
		
		Sucursal sucursalDestino = new Sucursal();
		sucursalDestino.setIdSucursal(encP.getSucursalDestino().getId());
		
		//Direccion direccionDestino = new Direccion();
		//direccionDestino.setIdDireccion(encP.getDireccionDestino().getIdDireccion());

		//Direccion direccionOrigen = new Direccion();
		//direccionOrigen.setIdDireccion(encP.getDireccionOrigen().getIdDireccion());

		ClienteParticularE cliE = (ClienteParticularE)ClienteDao.getInstancia().getByDni(encP.getCliente().getDni());
		
		if(sucursalActual == null)
			throw new SucursalNotFoundException(encP.getSucursalActual().getId());
		if(sucursalOrigen == null)
			throw new SucursalNotFoundException(encP.getSucursalOrigen().getId());
		if(sucursalDestino == null)
			throw new SucursalNotFoundException(encP.getSucursalDestino().getId());
		if(cliE == null)
			throw new ClientNotFoundException();
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(cliE.getIdCliente());
		cliente.setDni(cliE.getDni());
				
		ServicioSeguridad servicioSeg = new ServicioSeguridad();
		servicioSeg.setIdServicioSeguridad(encP.getIdServicioSeguridad());
		
		Manifiesto manifiesto = new Manifiesto(encP.getManifiesto().getId(), encP.getManifiesto().getFecha());
		
		for (DTO_ItemManifiesto item : encP.getManifiesto().getDetalle()) {
			Producto producto = null;
			
			if(item.getProducto() != null){
					producto = new Producto();
					producto.setIdProducto(item.getProducto().getId());
			}
			
			manifiesto.addItem(new ItemManifiesto(item.getDescripcion(), item.getCantidad(), producto)); 
		}
		
		EncomiendaParticular nuevaEncomienda = 		
		new EncomiendaParticular(null, sucursalDestino, sucursalOrigen, null, sucursalActual, cliente, 
				encP.getFechaCreacion(), encP.getFechaEstimadaEntrega(), encP.getEstado(), encP.isTercerizada(), 
				encP.getLargo(), encP.getAlto(), encP.getAncho(), encP.getPeso(), encP.getVolumen(), encP.getTratamiento(), 

				encP.getApilable(), encP.getCantApilable(), encP.getRefrigerado(), encP.getCondicionTransporte(), 
				encP.getIndicacionesManipulacion(), encP.getFragilidad(), encP.getNombreReceptor(), 
				encP.getApellidoReceptor(), encP.getDniReceptor(), encP.getVolumenGranel(), encP.getUnidadGranel(), 
				encP.getCargaGranel(), servicioSeg, manifiesto, encP.isInternacional());
		
		return nuevaEncomienda.saveOrUpdate();
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

	public DTO_ClienteParticular getClienteParticularByDni(String dni)throws RemoteException {
		return (DTO_ClienteParticular) ClienteDao.getInstancia().getByDni(dni).toDTO();
	}
	
	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException {
		return ClienteParticularDao.getInstancia().getById(idCliente).toDTO();
	}
	
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		ClienteDao.getInstancia().remove(ClienteDao.getInstancia().getById(idCliente));
	}

	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException{
		Direccion dir = new Direccion().fromDTO(empresa.getDireccion());
		ClienteEmpresa c = new ClienteEmpresa();
	
		c.setCuit(empresa.getCuit());
		c.setEmail(empresa.getEmail());
		c.setRazonSocial(empresa.getRazonSocial());
		c.setEstado(empresa.isEstado());
		c.setTelefono(empresa.getTelefono());
		c.setDireccion(dir);
		
		CuentaCorriente cc = new CuentaCorriente();
		cc.setLimiteCredito(empresa.getCuentaCorriente().getLimiteCredito());
		cc.setCredito(empresa.getCuentaCorriente().getCredito());
		cc.setFormaPago(empresa.getCuentaCorriente().getFormaPago());
		
		c.setCuentaCorrientes(cc);
		
		c.guardar();
	}
	
	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException{
		Direccion dir = new Direccion().fromDTO(empresa.getDireccion());
		ClienteEmpresa c = new ClienteEmpresa();
	
		c.setCuit(empresa.getCuit());
		c.setEmail(empresa.getEmail());
		c.setRazonSocial(empresa.getRazonSocial());
		c.setEstado(empresa.isEstado());
		c.setTelefono(empresa.getTelefono());
		c.setDireccion(dir);
		
		CuentaCorriente cc = new CuentaCorriente();
		cc.setLimiteCredito(empresa.getCuentaCorriente().getLimiteCredito());
		cc.setCredito(empresa.getCuentaCorriente().getCredito());
		cc.setFormaPago(empresa.getCuentaCorriente().getFormaPago());
		
		c.setCuentaCorrientes(cc);
		
		c.modificar();
	}
	
	public void altaProveedor(DTO_Proveedor prov) throws RemoteException {
		Direccion dir = new Direccion().fromDTO(prov.getDireccion());
		
		Proveedor proveedor = new Proveedor(dir, prov.getActivo(), prov.getCuit(),
				prov.getRazonSocial(), prov.getEmail(), prov.getTelefono(), prov.isTallerOficial(), prov.getTipo());
		
		proveedor.saveOrUpdate();
	}
	
	public void modificarProveedor(DTO_Proveedor prov) throws RemoteException {
		Direccion dir = new Direccion().fromDTO(prov.getDireccion());
		
		Proveedor proveedor = new Proveedor(prov.getId(), dir, prov.getActivo(), prov.getCuit(),
				prov.getRazonSocial(), prov.getEmail(), prov.getTelefono(), prov.isTallerOficial(), prov.getTipo());
		
		proveedor.saveOrUpdate();
	}
	
	public void altaSeguro(DTO_Seguro seguro) throws RemoteException {
		Seguro seg = new Seguro().fromDTO(seguro);
		seg.guardar();
	}
	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException{
		Seguro seg = new Seguro().fromDTO(seguro);
		seg.modificar();
	}
	
	public Integer gestionarEnvioEncomienda(int idEncomienda){		
		return GestionEncomienda.getInstancia().asignarEnvio(idEncomienda, null);		
	}
	
	public DTO_EnvioPropio getInfoEnvioPropio(int idEnvio){
		
		DTO_EnvioPropio envio = new DTO_EnvioPropio();
		
		//TODO: esto lo puedo hacer aca porque es un controlador.
		EnvioE env = EnvioDao.getInstancia().getById(idEnvio);
		
		envio.setEstado(env.getEstado());
		envio.setId(env.getIdEnvio());
		envio.setPosicionActual(new DTO_Coordenada(env.getPosicionActual().getIdCoordenada(),env.getPosicionActual().getLongitud(), env.getPosicionActual().getLatitud()));
		envio.setFechaYHoraLlegada(env.getFechaYHoraLlegadaEstimada());
		envio.setFechaYHoraSalida(env.getFechaYHoraSalida());
		envio.setIdDestino(env.getSucursalDestino().getIdSucursal());
		envio.setIdHojaDeRuta(env.getMapaDeRuta().getIdMapaDeRuta());
		envio.setIdVehiculo(env.getVehiculo().getIdVehiculo());
		
		return envio;
	}

	public void modificarCoordenadas(int idEnvio, DTO_Coordenada coordenadas) {
		
		CoordenadaE coor = CoordenadaDao.getInstancia().getById(coordenadas.getId());
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(idEnvio, coor);
		
	}

	public void marcarEnvioDemorado(int idEnvio) {

		GestionControlViajes.getInstancia().estaEnvioDemorado(idEnvio);
		
	}


	
	public Integer altaVehiculo(DTO_Vehiculo v) throws RemoteException {
		Vehiculo veh = new Vehiculo().fromDTO(v);
		veh.guardar();
		return 1;
	}
	
	@Override
	public void modificarVehiculo(DTO_Vehiculo v) throws RemoteException {	
		Vehiculo veh = new Vehiculo().fromDTO(v);
		veh.modificar();
	}

	@Override
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tareaXKM, Integer idVehiculo)
			throws RemoteException, Exception {
		try {
			new GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo))
			.altaTareaMantenimientoPorKm(tareaXKM.getTarea(), tareaXKM.getCantidadKilometros());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Integer altaPlanMantenimiento(DTO_PlanMantenimiento pm, Integer idVehiculo)	throws RemoteException, Exception {			
		GestionVehiculo v = new GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo));
		return v.altaPlanMantenimiento(pm.getDescripcion(), pm.getComentarios());
	}

	@Override
	public Integer altaTareaMantenimiento(DTO_TareasPorTiempo tareaXTiempo, Integer idVehiculo)
			throws RemoteException, Exception {
		return new GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).altaTareaMantenimientoPorTiempo(tareaXTiempo.getTarea(), tareaXTiempo.getCantidadDias());
	}

	@Override
	public List<DTO_TareaMantenimiento> getTareasVencidas(int idVehiculo)
			throws RemoteException {
		return new GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).getTareasVencidas2();
	}

	@Override
	public List<DTO_Vehiculo> listarVehiculos() throws RemoteException {
		List<VehiculoE> lista = VehiculoDao.getInstancia().getAll();
		List<DTO_Vehiculo> listadto = new ArrayList<DTO_Vehiculo>();
		for(VehiculoE v:lista){
			listadto.add(v.toDTO());
		}
		return listadto;
	}


	public List<DTO_Proveedor> getTalleresMecanicos(){
		
		List<ProveedorE> tallers = ProveedorDao.getInstancia().getByTipo('T');
		List<DTO_Proveedor> talleresDTO = new ArrayList<DTO_Proveedor>();
		for(ProveedorE taller : tallers){
			Proveedor prov = new Proveedor().fromEntity(taller);
			talleresDTO.add(prov.toDTO());
		}
		return talleresDTO;
	}

	@Override
	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad)
			throws RemoteException {
		ServicioSeguridad ss = new ServicioSeguridad().fromDTO(servicioSeguridad);
		ss.guardar();
	}

	@Override
	public void modificarServicioSeguridad(
			DTO_ServicioSeguridad servicioSeguridad) throws RemoteException {
		ServicioSeguridad ss = new ServicioSeguridad().fromDTO(servicioSeguridad);
		ss.modificar();
	}
	

	@Override
	public void altaTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		TarifasCarrier tc = new TarifasCarrier().fromDTO(tarifasCarrier);
		tc.guardar();
	}

	@Override
	public void modificarTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		TarifasCarrier tc = new TarifasCarrier().fromDTO(tarifasCarrier);
		tc.modificar();	
	}

	@Override
	public void bajaProveedor(Integer idProveedor) throws RemoteException {
		ProveedorDao.getInstancia().removeById(idProveedor);
	}

	@Override
	public List<DTO_Seguro> getSeguros() throws RemoteException {
		List<DTO_Seguro> listadto= new ArrayList<DTO_Seguro>();
		List<SeguroE> lista = SeguroDao.getInstancia().getAll();
		for(SeguroE seg: lista){
			Seguro seguro = new Seguro().fromEntity(seg);
			listadto.add(seguro.toDTO());
		}
		return listadto;
	}

	@Override
	public List<DTO_TarifasCarrier> getTarifasCarriers() throws RemoteException {
		List<DTO_TarifasCarrier> listadto= new ArrayList<DTO_TarifasCarrier>();
		List<TarifasCarrierE> lista = TarifasCarrierDao.getInstancia().getAll();
		for(TarifasCarrierE tc: lista){
			TarifasCarrier tar=new TarifasCarrier().fromEntity(tc);
			listadto.add(tar.toDTO());
		}
		return listadto;
	}

	@Override
	public List<DTO_ServicioSeguridad> getServicioSeguridad()
			throws RemoteException {
		List<DTO_ServicioSeguridad> listadto= new ArrayList<DTO_ServicioSeguridad>();
		List<ServicioSeguridadE> lista = ServicioSeguridadDao.getInstancia().getAll();
		for(ServicioSeguridadE ss: lista){
			ServicioSeguridad serv = new ServicioSeguridad().fromEntity(ss);
			listadto.add(serv.toDTO());
		}
		return listadto;
	}

	@Override
	public List<DTO_Proveedor> getAseguradoras() throws RemoteException {
		List<DTO_Proveedor> lista = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> listp = ProveedorDao.getInstancia().getByTipo('A');
		if(listp!=null){
			for(ProveedorE p: listp){
				Proveedor prov = new Proveedor().fromEntity(p);
				lista.add(prov.toDTO());
			}
			return lista;
		}
		else
			return null;
	}

	@Override
	public List<DTO_Proveedor> getEmpresasServiciosSeguridad()
			throws RemoteException {
		List<DTO_Proveedor> lista = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> listp = ProveedorDao.getInstancia().getByTipo('S');
		if(listp!=null){
			for(ProveedorE p: listp){
				Proveedor prov = new Proveedor().fromEntity(p);
				lista.add(prov.toDTO());
			}
			return lista;
		}
		else
			return null;
	}

	@Override
	public List<DTO_Proveedor> getCarriers() throws RemoteException {
		List<DTO_Proveedor> lista = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> listp = ProveedorDao.getInstancia().getByTipo('C');
		if(listp!=null){
			for(ProveedorE p: listp){
				Proveedor prov = new Proveedor().fromEntity(p);
				lista.add(prov.toDTO());
			}
			return lista;
		}
		else
			return null;
	}
	
	public List<DTO_Proveedor> getTalleres() throws RemoteException {
		List<DTO_Proveedor> lista = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> listp = ProveedorDao.getInstancia().getByTipo('T');
		if(listp!=null){
			for(ProveedorE p: listp){
				Proveedor prov = new Proveedor().fromEntity(p);
				lista.add(prov.toDTO());
			}
			return lista;
		}
		else
			return null;
	}

	@Override
	public List<DTO_Proveedor> getProveedores() throws RemoteException {
		List<DTO_Proveedor> lista = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> listp = ProveedorDao.getInstancia().getAll();
		if(listp!=null){
			for(ProveedorE p: listp){
				Proveedor prov = new Proveedor().fromEntity(p);
				lista.add(prov.toDTO());
			}
			return lista;
		}
		else
			return null;
	}

	@Override
	public DTO_Proveedor getProveedor(Integer idProveedor)
			throws RemoteException {
		ProveedorE prov = ProveedorDao.getInstancia().getById(idProveedor);
		if(prov!=null){
			return new Proveedor().fromEntity(prov).toDTO();
		}
		else
			return null;
	}

	@Override

	public List<DTO_Usuario> getUsuarios() throws RemoteException {
		List<DTO_Usuario> lista = new ArrayList<DTO_Usuario>();
		List<UsuarioE> listu = UsuarioDao.getInstancia().getAll();
		if(listu!=null){
			for(UsuarioE u: listu){
				Usuario usu = new Usuario().fromEntity(u);
				lista.add(usu.toDTO());
			}
			return lista;
		}
		else
			return null;
	}
	
	@Override
	public DTO_Usuario getUsuarioPorDni(String dni) {
		UsuarioE usuario = UsuarioDao.getInstancia().getByDni(dni);
		if(usuario!=null){
			Usuario usu = new Usuario().fromEntity(usuario);
			return usu.toDTO();
		}
		else
			return null;
	}
	
	 @Override
	 public DTO_Usuario login(String usuario, String password){
		 UsuarioE u = UsuarioDao.getInstancia().buscarUsuario(usuario);
		 Usuario usu = new Usuario().fromEntity(u);
		 if (u.getPassword().equals(password))
			 return usu.toDTO();
		 else
			 return null;
	 }
	 
	 @Override
	 public List<DTO_Rol> listarRoles(){
		 List<RolE> lista = RolDao.getInstancia().getAll();
		 List<DTO_Rol> listaDTO = new ArrayList<DTO_Rol>();
         for(RolE p: lista){
        	 Rol rol = new Rol().fromEntity(p);
        	 listaDTO.add(rol.toDTO());
         }
		 return listaDTO;
	 }
	 
	 @Override
	 public List<String> buscarRolesUsuario(int idUsuario){
		 List<RolE> roles = RolDao.getInstancia().buscarRolesByIdUsuario(idUsuario);
		 List<String> dtoRoles = new ArrayList<String>();
	    	for(RolE rol : roles){
	    		DTO_Rol dto = new DTO_Rol();
	    		dto.setId(rol.getIdRol());
	    		dto.setdescripcion(rol.getDescripcion());
	    		dtoRoles.add(dto.getdescripcion());	    		
	    	}
		return dtoRoles;
	 }


	@Override
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
	{
		ClienteEmpresaE e = ClienteEmpresaDao.getInstancia().getById(idCliente);
		if(e!=null){
			return new ClienteEmpresa().fromEntity(e).toDTO();
		}
		else
			return null;
		
	}
	
	public Integer cobrarEncomiendaParticular(Integer idFactura) throws RemoteException {

		return null;
	}

	@Override
	public List<DTO_PlanMantenimiento> listarPlanesMantenimiento()
			throws RemoteException {
		 List<DTO_PlanMantenimiento> listaDTO = new ArrayList<DTO_PlanMantenimiento>();
		 List<PlanMantenimientoE> lista = PlanMantenimientoDao.getInstancia().getAll();
         for(PlanMantenimientoE p: lista){
        	 PlanMantenimiento plan = new PlanMantenimiento().fromEntity(p);
        	 listaDTO.add(plan.toDTO());
         }
		 return listaDTO;
	}

	@Override
	public List<DTO_Sucursal> listarSucursales() throws RemoteException {
		List<DTO_Sucursal> listaDTO = new ArrayList<DTO_Sucursal>();
		List<SucursalE> lista = SucursalDao.getInstancia().getAll();
        for(SucursalE suc: lista){
        	Sucursal sucursal = new Sucursal().fromEntity(suc);
        	listaDTO.add(sucursal.toDTO());
        }
		 return listaDTO;
	}

	@Override
	public List<DTO_Factura> listarFacturasCliente() throws RemoteException {
		List<DTO_Factura> listaDTO = new ArrayList<DTO_Factura>();
		List<FacturaE> lista = FacturaDao.getInstancia().getAll();
        for(FacturaE fac: lista)
        	listaDTO.add(fac.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Factura> listarFacturasClientePendientes()
			throws RemoteException {
		List<DTO_Factura> listaDTO = new ArrayList<DTO_Factura>();
		List<FacturaE> lista = FacturaDao.getInstancia().listarFacturasClientePendientes();
        for(FacturaE fac: lista)
        	listaDTO.add(fac.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada()
			throws RemoteException {
		List<DTO_TareaMantenimientoRealizada> listaDTO = new ArrayList<DTO_TareaMantenimientoRealizada>();
		List<TareaMantenimientoRealizadaE> lista = TareaMantenimientoRealizadaDao.getInstancia().getAll();
        for(TareaMantenimientoRealizadaE tarea: lista){
        	TareaMantenimientoRealizada tr = new TareaMantenimientoRealizada().fromEntity(tarea);
        	listaDTO.add(tr.toDTO());
        }
        
		 return listaDTO;
	}

	@Override
	public DTO_TareaMantenimiento getTareaMantenimiento(
			Integer idTareaMantenimiento) throws RemoteException {

		return new TareaMantenimiento().fromEntity(TareaMantenimientoDao.getInstancia().getById(idTareaMantenimiento)).toDTO();
	}
	@Override
	public Integer facturarEncomiendaEmpresa(int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer cobrarEncomiendaEmpresa(Integer idFactura)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO_Usuario getEmpleado(Integer idEmpleado) throws RemoteException {
		return this.getUsuario(idEmpleado);
	}

	@Override
	public Integer facturarEncomiendaParticular(DTO_EncomiendaParticular enc)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;


	}
	
	@Override
	public List<DTO_ClienteParticular> buscarClientesByNombreApellidoDni (String filtro){
		List<DTO_ClienteParticular> listaDTO = new ArrayList<DTO_ClienteParticular>();
		List<ClienteE> lista = ClienteDao.getInstancia().getClientesByNombreApellidoDni(filtro);
        for(ClienteE cli: lista)
        	listaDTO.add((DTO_ClienteParticular) cli.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Sucursal> buscarSucursalesByNombre(String filtro)
			throws RemoteException {
		List<DTO_Sucursal> listaDTO = new ArrayList<DTO_Sucursal>();
		List<SucursalE> lista = SucursalDao.getInstancia().getSucursalesByNombre(filtro);
        for(SucursalE suc: lista){
        	Sucursal sucursal = new Sucursal().fromEntity(suc);
        	listaDTO.add((DTO_Sucursal) sucursal.toDTO());
        }
        
		 return listaDTO;
	}

	@Override
	public List<DTO_ClienteEmpresa> buscarClientesEmpresaByRazonSocial(
			String filtro) throws RemoteException {
		List<DTO_ClienteEmpresa> listaDTO = new ArrayList<DTO_ClienteEmpresa>();
		List<ClienteEmpresaE> lista = ClienteEmpresaDao.getInstancia().getEmpresaByRazonSocial(filtro);
        for(ClienteEmpresaE cli: lista)
        	listaDTO.add((DTO_ClienteEmpresa) cli.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Proveedor> buscarProveedorByRazonSocial(String filtro)
			throws RemoteException {
		List<DTO_Proveedor> listaDTO = new ArrayList<DTO_Proveedor>();
		List<ProveedorE> lista = ProveedorDao.getInstancia().getProveedorByRazonSocial(filtro);
        for(ProveedorE prov: lista){
        	Proveedor p = new Proveedor().fromEntity(prov);
			listaDTO.add(p.toDTO());
		}
		 return listaDTO;
	}

	@Override
	public List<DTO_Usuario> buscarUsuariosByNombreApellidoOUsuario(String filtro) throws RemoteException {
		List<DTO_Usuario> listaDTO = new ArrayList<DTO_Usuario>();
		List<UsuarioE> lista = UsuarioDao.getInstancia().getUsuariosByNombreApellidoOUsuario(filtro);
        for(UsuarioE usu: lista){
        	Usuario u = new Usuario().fromEntity(usu);
        	listaDTO.add(u.toDTO());
        }
		 return listaDTO;
	}

	@Override
	public List<DTO_Vehiculo> buscarVehiculoByModeloMarcaOPatente(String filtro)
			throws RemoteException {
		List<DTO_Vehiculo> listaDTO = new ArrayList<DTO_Vehiculo>();
		List<VehiculoE> lista = VehiculoDao.getInstancia().getVehiculosByModelMarcaPatente(filtro);
        for(VehiculoE veh: lista)
        	listaDTO.add( veh.toDTO());
        
		 return listaDTO;
	}

	@Override
	public DTO_Vehiculo buscarVehiculoById(Integer idVehiculo)
			throws RemoteException {
		return VehiculoDao.getInstancia().getById(idVehiculo).toDTO();
	}

	@Override
	public List<DTO_TareaMantenimientoRealizada> buscarTareasMantenimientoRealizadasPorVehiculo(String filtro) throws RemoteException {
		List<DTO_TareaMantenimientoRealizada> listaDTO = new ArrayList<DTO_TareaMantenimientoRealizada>();
		List<TareaMantenimientoRealizadaE> lista = TareaMantenimientoRealizadaDao.getInstancia().getByPatenteVehiculo(filtro);
        for(TareaMantenimientoRealizadaE tr: lista){
        	TareaMantenimientoRealizada tarea = new TareaMantenimientoRealizada().fromEntity(tr);
        	listaDTO.add( tarea.toDTO());
        }
		 return listaDTO;
		
	}

	@Override
	public List<DTO_Factura> buscarFacturasByDniCliente(String filtro)
			throws RemoteException {
		List<DTO_Factura> listaDTO = new ArrayList<DTO_Factura>();
		List<FacturaE> lista = FacturaDao.getInstancia().getFacturasByCliente(filtro,false);
        for(FacturaE fac: lista)
        	listaDTO.add( fac.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Seguro> buscarSegurosByProveedor(String filtro)
			throws RemoteException {
		List<DTO_Seguro> listaDTO = new ArrayList<DTO_Seguro>();
		List<SeguroE> lista = SeguroDao.getInstancia().getSegurosByProveedor(filtro);
        for(SeguroE sec: lista){
        	Seguro seguro = new Seguro().fromEntity(sec);
        	listaDTO.add(seguro.toDTO());
        }
        
		 return listaDTO;
	}

	@Override
	public List<DTO_ServicioSeguridad> buscarServicioSeguridadByProveedor(
			String filtro) throws RemoteException {
		List<DTO_ServicioSeguridad> listaDTO = new ArrayList<DTO_ServicioSeguridad>();
		List<ServicioSeguridadE> lista = ServicioSeguridadDao.getInstancia().getServiciosSeguridadByProveedor(filtro);
        for(ServicioSeguridadE seg: lista){
        	ServicioSeguridad serv = new ServicioSeguridad().fromEntity(seg);
        	listaDTO.add(serv.toDTO());
        }
        
		 return listaDTO;
	}

	@Override
	public List<DTO_TarifasCarrier> buscarTarifasCarrierByProveedor(
			String filtro) throws RemoteException {
		List<DTO_TarifasCarrier> listaDTO = new ArrayList<DTO_TarifasCarrier>();
		List<TarifasCarrierE> lista = TarifasCarrierDao.getInstancia().getTarifasCarrierByProveedor(filtro);
        for(TarifasCarrierE tc: lista){
        	TarifasCarrier tar=new TarifasCarrier().fromEntity(tc);
        	listaDTO.add(tar.toDTO());
		}
		 return listaDTO;
	}

	@Override
	public List<DTO_Factura> buscarFacturasPendientesByDniCliente(String filtro)
			throws RemoteException {
		List<DTO_Factura> listaDTO = new ArrayList<DTO_Factura>();
		List<FacturaE> lista = FacturaDao.getInstancia().getFacturasByCliente(filtro,true);
        for(FacturaE fac: lista)
        	listaDTO.add( fac.toDTO());
        
		 return listaDTO;
	}

	@Override
	public DTO_Encomienda getEncomiendaParticular(Integer id)
			throws RemoteException {
		DTO_Encomienda enc = EncomiendaDao.getInstancia().getById(id).toDTO();
		if(enc.getTipoEncomienda().contains("P"))
			return enc;
		else
			return null;
	}

	@Override
	public DTO_Encomienda getEncomiendaEmpresa(Integer id)
			throws RemoteException {
		DTO_Encomienda enc = EncomiendaDao.getInstancia().getById(id).toDTO();
		if(enc.getTipoEncomienda().contains("E"))
			return enc;
		else
			return null;
	}

	@Override
	public List<DTO_Encomienda> listarEncomiendasParticulares()
			throws RemoteException {
		List<DTO_Encomienda> listaDTO = new ArrayList<DTO_Encomienda>();
		List<EncomiendaE> lista = EncomiendaDao.getInstancia().getAllParticulares();
        for(EncomiendaE enc: lista)
        	listaDTO.add( enc.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Encomienda> listarEncomiendasEmpresas()
			throws RemoteException {
		List<DTO_Encomienda> listaDTO = new ArrayList<DTO_Encomienda>();
		List<EncomiendaE> lista = EncomiendaDao.getInstancia().getAllEmpresas();
        for(EncomiendaE enc: lista)
        	listaDTO.add( enc.toDTO());
        
		 return listaDTO;
	}

	@Override
	public DTO_Coordenada getCoordenadasById(int id) throws RemoteException {
		return CoordenadaDao.getInstancia().getById(id).toDTO();
	}

	@Override
	public List<DTO_EnvioPropio> listarEnviosPropios() throws RemoteException {
		List<DTO_EnvioPropio> listaDTO = new ArrayList<DTO_EnvioPropio>();
		List<EnvioE> lista = EnvioDao.getInstancia().getEnviosPropios();
        for(EnvioE env: lista)
        	listaDTO.add( (DTO_EnvioPropio) env.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_EnvioTercerizado> listarEnviosTercerizados()
			throws RemoteException {
		List<DTO_EnvioTercerizado> listaDTO = new ArrayList<DTO_EnvioTercerizado>();
		List<EnvioE> lista = EnvioDao.getInstancia().getEnviosTercerizados();
        for(EnvioE env: lista)
        	listaDTO.add( (DTO_EnvioTercerizado) env.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_EnvioTercerizado> buscarEnviosByEstado(String filtro)
			throws RemoteException {
		List<DTO_EnvioTercerizado> listaDTO = new ArrayList<DTO_EnvioTercerizado>();
		List<EnvioE> lista = EnvioDao.getInstancia().getEnviosTercerizadosByEstado(filtro);
        for(EnvioE env: lista)
        	listaDTO.add( (DTO_EnvioTercerizado) env.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_EnvioPropio> buscarEnviosPropiosByEstado(String filtro)
			throws RemoteException {
		List<DTO_EnvioPropio> listaDTO = new ArrayList<DTO_EnvioPropio>();
		List<EnvioE> lista = EnvioDao.getInstancia().getEnviosPropiosByEstado(filtro);
        for(EnvioE env: lista)
        	listaDTO.add( (DTO_EnvioPropio) env.toDTO());
        
		 return listaDTO;
	}

	@Override
	public List<DTO_Provincia> listarProvinciasByPais(String pais)
			throws RemoteException {
		List<DTO_Provincia> listaDTO = new ArrayList<DTO_Provincia>();
		List<ProvinciaE> lista = ProvinciaDao.getInstancia().getByPais(pais);
        for(ProvinciaE pr: lista){
        	Provincia prov = new Provincia().fromEntity(pr);
        	listaDTO.add( (DTO_Provincia) prov.toDTO());
        }
		 return listaDTO;
	}

	@Override
	public DTO_Provincia buscarProvinciaByNombre(String prov)
			throws RemoteException {
		return new Provincia().fromEntity(ProvinciaDao.getInstancia().getByNombre(prov)).toDTO();
	}

	public List<DTO_Pais> listarPaises(){
		List<PaisE> paises = PaisDao.getInstancia().getAll();
		List<DTO_Pais> paisesDTO = new ArrayList<DTO_Pais>();
	    for(PaisE pais : paises){
	    	Pais p = new Pais().fromEntity(pais);
	    	paisesDTO.add(p.toDTO());	    		
	    }
		return paisesDTO;
	}
	
	public List<DTO_Provincia> listarProvincias(int idPais){
		List<ProvinciaE> provincias = ProvinciaDao.getInstancia().getByPais(idPais);
		List<DTO_Provincia> provinciasDTO = new ArrayList<DTO_Provincia>();
	    for(ProvinciaE prov : provincias){
	    	Provincia p = new Provincia().fromEntity(prov);
	    	provinciasDTO.add(p.toDTO());	    		
	    }
		return provinciasDTO;
	}

	@Override
	public DTO_PlanMantenimiento getPlanMantenimiento(Integer id)
			throws RemoteException {
		return new PlanMantenimiento().fromEntity(PlanMantenimientoDao.getInstancia().getById(id)).toDTO();
	}

	@Override
	public DTO_Pais getPaisByNombre(String pais) throws RemoteException {
		return new Pais().fromEntity(PaisDao.getInstancia().getByNombre(pais)).toDTO();
	}

	@Override
	public DTO_Provincia getProvByNombre(String prov) throws RemoteException {
		return new Provincia().fromEntity(ProvinciaDao.getInstancia().getByNombre(prov)).toDTO();
	}

	@Override
	public void altaPlanMantenimiento(DTO_PlanMantenimiento pm)
			throws RemoteException {
		PlanMantenimiento plm = new PlanMantenimiento(pm.getDescripcion(), pm.getComentarios());
		
		plm.guardar();
	}

	@Override
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tpk)
			throws RemoteException {
		PlanMantenimiento pm = new PlanMantenimiento().fromEntity(PlanMantenimientoDao.getInstancia().getById(tpk.getIdPlanMantenimiento()));
		TareaMantenimientoPorKm tarea = new TareaMantenimientoPorKm(pm, tpk.getTarea(), tpk.getCantidadKilometros());
	}

	@Override
	public void altaTareaMantenimiento(DTO_TareasPorTiempo tpt)
			throws RemoteException {
		PlanMantenimiento pm = new PlanMantenimiento().fromEntity(PlanMantenimientoDao.getInstancia().getById(tpt.getIdPlanMantenimiento()));
		TareaMantenimientoPorTiempo tarea = new TareaMantenimientoPorTiempo(pm, tpt.getTarea(), tpt.getCantidadDias());
	}

	@Override
	public void altaTareaMantenimientoRealizada(
			DTO_TareaMantenimientoRealizada tmr) throws RemoteException {		
		TareaMantenimiento t = new TareaMantenimiento().fromEntity(TareaMantenimientoDao.getInstancia().getById(tmr.getIdTareaMantenimiento()));
		Proveedor prov = new Proveedor().fromEntity(ProveedorDao.getInstancia().getById(tmr.getIdProveedor()));
		Vehiculo veh = new Vehiculo().fromDTO(VehiculoDao.getInstancia().getById(tmr.getIdVehiculo()).toDTO());
		TareaMantenimientoRealizada tr = new TareaMantenimientoRealizada(t,prov,veh,tmr.getFecha(),tmr.getCantidadKilometros());
		tr.guardar();
	}

	@Override

	public DTO_Vehiculo buscarVehiculoByPatente(String patente) throws RemoteException {
		return new Vehiculo().fromEntity(VehiculoDao.getInstancia().getByPatente(patente)).toDTO();
	}

	@Override

	public List<DTO_TareaMantenimiento> getTareaMantenimientoByPlan(Integer idPlan)	throws RemoteException {
		List<TareaMantenimientoE> tareas = TareaMantenimientoDao.getInstancia().getByPlan(idPlan);
		List<DTO_TareaMantenimiento> tareasDto = new ArrayList<DTO_TareaMantenimiento>();
	    for(TareaMantenimientoE t : tareas){
	    	TareaMantenimiento ta = new TareaMantenimiento().fromEntity(t);
	    	tareasDto.add(ta.toDTO());	    		
	    }
		return tareasDto;
		
	}
	
	@Override
	public boolean cambiarPassword(String usuario, String oldPassword,
			String newPassword) throws RemoteException {
		try{
			UsuarioE u = UsuarioDao.getInstancia().buscarUsuario(usuario);
			u.setPassword(newPassword);	
			Usuario usu = new Usuario().fromEntity(u);
			usu.modificar();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}


	 @Override
	 public List<DTO_Usuario> listarEmpleados(){
		 List<UsuarioE> empleados = UsuarioDao.getInstancia().getAll();
		 List<DTO_Usuario> empleadosDTO = new ArrayList<DTO_Usuario>();
	    for(UsuarioE empleado : empleados){
	    	Usuario u = new Usuario().fromEntity(empleado);
	    	empleadosDTO.add(u.toDTO());	    		
	    }
		return empleadosDTO;
	 }
	 
	 @Override
	 public List<DTO_Usuario> listarEmpleados(Integer idSucursal){
		 List<UsuarioE> empleados = UsuarioDao.getInstancia().listarEmpleados(idSucursal);
		 List<DTO_Usuario> empleadosDTO = new ArrayList<DTO_Usuario>();
	    for(UsuarioE empleado : empleados){
	    	Usuario u = new Usuario().fromEntity(empleado);
	    	empleadosDTO.add(u.toDTO());	    		    		
	    }
		return empleadosDTO;
	 }


	@Override
	public DTO_Usuario existeUsuario(String usuario) throws RemoteException {
		UsuarioE usu = UsuarioDao.getInstancia().buscarUsuario(usuario);
		if(usu!=null){
			return new Usuario().fromEntity(usu).toDTO();
		}
		else
			return null;
	}


	@Override
	public void eliminarProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public DTO_Proveedor buscarProveedorByCuit(String cuit)
			throws RemoteException {
		Proveedor prov = new Proveedor().fromEntity(ProveedorDao.getInstancia().getByCuit(cuit));
		return prov.toDTO();
	}


	@Override
	public void bajaPlanMantenimiento(Integer id) throws RemoteException {
		PlanMantenimientoDao.getInstancia().removeById(id);
	}


	@Override
	public void bajaServicioSeguridad(Integer id) throws RemoteException {
		ServicioSeguridadDao.getInstancia().removeById(id);
	}


	@Override
	public void bajaMapaDeRuta(Integer id) throws RemoteException {
		MapaDeRutaDao.getInstancia().removeById(id);
	}


	@Override
	public void bajaSeguro(Integer id) throws RemoteException {
		SeguroDao.getInstancia().removeById(id);	
	}


	@Override
	public void bajaTarifasCarrier(Integer id) throws RemoteException {
		TarifasCarrierDao.getInstancia().removeById(id);
	}


	@Override
	public DTO_ServicioSeguridad getServicioSeguridad(Integer id)
			throws RemoteException {
		return new ServicioSeguridad().fromEntity(ServicioSeguridadDao.getInstancia().getById(id)).toDTO();
	}


	@Override
	public DTO_TarifasCarrier getTarifasCarrier(Integer id)
			throws RemoteException {
		return new TarifasCarrier().fromEntity(TarifasCarrierDao.getInstancia().getById(id)).toDTO();
	}


	@Override
	public DTO_Seguro getSeguro(Integer id) throws RemoteException {
		return new Seguro().fromEntity(SeguroDao.getInstancia().getById(id)).toDTO();
	}


	@Override
	public boolean sucursalTieneEncomiendas(Integer id) throws RemoteException {
		return SucursalDao.getInstancia().tieneEncomiendas(id);
	}


	@Override
	public boolean clienteTieneEncomiendas(Integer id) throws RemoteException {
		return ClienteDao.getInstancia().tieneEncomiendas(id);
	}


	@Override
	public boolean estaProductoAsociado(Integer id) throws RemoteException {
		return ProductoDao.getInstancia().estaAsociado(id);
	}


	@Override
	public boolean vehiculoAsociadoAEnvio(Integer id) throws RemoteException {
		return VehiculoDao.getInstancia().estaAsociado(id);
	}


	@Override
	public void bajaVehiculo(Integer id) throws RemoteException {
		VehiculoDao.getInstancia().removeById(id);
	}


	@Override
	public boolean tareaEstaRealizada(Integer id) throws RemoteException {
		return TareaMantenimientoDao.getInstancia().estaRealizada(id);
	}


	@Override
	public void bajaTareaMantenimiento(Integer id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
