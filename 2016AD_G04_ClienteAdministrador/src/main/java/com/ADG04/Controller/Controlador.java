package com.ADG04.Controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_CuentaCorriente;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;


public class Controlador {
	private BusinessDelegate bd;
	
	
	private static Controlador instancia = null;

	public Controlador() {
		try {
			bd = new BusinessDelegate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	

	public Integer login(String usuario, String password)  {
		try {
			 DTO_Usuario user = bd.login(usuario, password);
			 if(user!=null)
				 return user.getId();
			 else
				 return null;
		}
		catch(BusinessException bex){
			bex.printStackTrace();
	        System.out.println("Error al validar usuario");
		}
		catch (RemoteException e) {
     	 e.printStackTrace();
         System.out.println("Error al validar usuario");
		}  
		return null;
	}
	
	
	public List<String> buscarRolesUsuario(int codigo){
		try {
			 return bd.buscarRolesUsuario(codigo);
	    } catch (RemoteException e) {
	   	 	System.out.println(e);
	        System.out.println("Error al buscar roles de usuario");
	    }   
	    return null;
	 }

	public List<DTO_ClienteParticular> listarClientes() {
		try{
			return bd.getClientesParticular();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar clientes");
	        }   
	        return null;
	}

	public List<DTO_ClienteEmpresa> listarClientesEmpresa() {
		try{
			return bd.getClientesEmpresa();
		}
		catch(RemoteException e) {
	       	 e.printStackTrace();
	         System.out.println("Error al listar clientes");
	        }   
	        return null;
	}

	public List<DTO_Vehiculo> listarVehiculos() {
		try{
			return bd.listarVehiculos();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Vehiculos");
	        }   
	        return null;
	}

	public List<DTO_TarifasCarrier> listarTarifasCarriers() {
		try{
			return bd.getTarifasCarriers();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Carriers");
	        }   
	        return null;
	}
	
	public List<DTO_Proveedor> listarCarriers() {
		try{
			return bd.getCarriers();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Carriers");
	        }   
	        return null;
	}

	public List<DTO_Seguro> listarSeguros() {
		try{
			return bd.getSeguros();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Seguros");
	        }   
	        return null;
	}

	public List<DTO_ServicioSeguridad> listarServicioSeguridad() {
		try{
			return bd.getServicioSeguridad();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Servicios de Seguridad");
	        }   
	        return null;
	}

	public List<DTO_Proveedor> listarTalleres() {
		try{
			return bd.getTalleresMecanicos();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Talleres Mecanicos");
	        }   
	        return null;
	}

	public List<DTO_Proveedor> listarAseguradoras() {
		try{
			return bd.getAseguradoras();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Aseguradoras");
	        }   
	        return null;
	}

	public List<DTO_Proveedor> listarEmpresasSeguridad() {
		try{
			return bd.getEmpresasServiciosSeguridad();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Servicios de Seguridad");
	      }   
	    return null;
	}

	public List<DTO_Proveedor> listarProveedores() {
		try{
			return bd.getProveedores();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Proveedores");
	      }   
	    return null;
	}

	public DTO_Proveedor getProveedor(Integer idProveedor) {
		try{
			return bd.getProveedor(idProveedor);
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Proveedores");
	      }   
	    return null;
	}

	public List<DTO_Usuario> listarUsuarios() {
		try{
			return bd.getUsuarios();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Usuarios");
	      }   
	    return null;
	}

	public List<DTO_PlanMantenimiento> listarPlanMantenimiento() {
		try{
			return bd.listarPlanesMantenimiento();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Planes de Mantenimiento");
	      }   
	    return null;
	}

	public List<DTO_Sucursal> listarSucursales() {
		try{
			return bd.listarSucursales();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Sucursales");
	      }   
	    return null;
	}

	public DTO_Usuario getUsuarioById(Integer idGerente) {
		try{
			return bd.getUsuarioById(idGerente);
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al buscar Usuario");
	      }   
	    return null;
	}

	public List<DTO_Factura> listarFacturasCliente() {
		try{
			return bd.listarFacturasCliente();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Facturas");
	      }   
	    return null;
	}

	public List<DTO_Factura> listarFacturasClientePendientes() {
		try{
			return bd.listarFacturasClientePendientes();
		}
		catch(RemoteException e) {
	       	   e.printStackTrace();
	            System.out.println("Error al listar Facturas");
	      }   
	    return null;
	}

	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada() {
		try{
			return bd.listarTareaMantenimientoRealizada();
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar Tareas Realizadas");
	      }   
	    return null;
	}

	public DTO_TareaMantenimiento getTareaMantenimiento(
			Integer idTareaMantenimiento) {
		try{
			return bd.getTareaMantenimiento(idTareaMantenimiento);
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al buscar Tarea de Mantenimiento");
	      }   
	    return null;
	}

	public List<DTO_ClienteParticular> buscarClientesByNombreApellidoDni(String filtro) {
		try{
			return  bd.buscarClientesByNombreApellidoDni(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar clientes");
		}
		return null;
	}

	public List<DTO_Sucursal> buscarSucursalByNombre(String filtro) {
		try{
			return  bd.buscarSucursalesByNombre(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar sucursales");
		}
		return null;
	}

	public List<DTO_ClienteEmpresa> buscarClientesEmpresaByRazonSocial(String filtro) {
		try{
			return  bd.buscarClientesEmpresaByRazonSocial(filtro);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar clientes empresas");
		}
		return null;
	}

	public List<DTO_Proveedor> buscarProveedorByRazonSocial(String filtro) {
		try{
			return  bd.buscarProveedorByRazonSocial(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar proveedores");
		}
		return null;
	}

	public List<DTO_Usuario> buscarUsuariosByNombreApellidoOUsuario(String filtro) {
		try{
			return  bd.buscarUsuariosByNombreApellidoOUsuario(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar usuarios");
		}
		return null;
	}

	public List<DTO_Vehiculo> buscarVehiculoByModeloMarcaOPatente(String filtro) {
		try{
			return  bd.buscarVehiculoByModeloMarcaOPatente(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar vehiculos");
		}
		return null;
	}

	public DTO_Vehiculo getVehiculoById(Integer idVehiculo) {
		try{
			return  bd.buscarVehiculoById(idVehiculo);
		}
		catch(Exception e){
			System.out.println("Error al buscar vehiculo");
		}
		return null;
	}

	public List<DTO_TareaMantenimientoRealizada> buscarTareasMantenimientoRealizadasPorVehiculo(String filtro) {
		try{
			return  bd.buscarTareasMantenimientoRealizadasPorVehiculo(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar tareas realizadas por vehiculo");
		}
		return null;
	}

	public List<DTO_Factura> buscarFacturasByDniCliente(String filtro) {
		try{
			return  bd.buscarFacturasByDniCliente(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar facturas por cliente");
		}
		return null;
	}

	public DTO_ClienteParticular getClienteById(int idCliente) {
		try{
			return  bd.getClienteParticularById(idCliente);
		}
		catch(Exception e){
			System.out.println("Error al buscar cliente por id");
		}
		return null;
	}

	public List<DTO_Seguro> buscarSegurosPorProveedor(String filtro) {
		try{
			return  bd.buscarSegurosByProveedor(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar seguros por proveedor");
		}
		return null;
	}
	public List<DTO_ServicioSeguridad> buscarServiciosSeguridadPorProveedor(String filtro) {
		try{
			return  bd.buscarServicioSeguridadByProveedor(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar servicios seguridad por proveedor");
		}
		return null;
	}
	public List<DTO_TarifasCarrier> buscarTarifasCarrierPorProveedor(String filtro) {
		try{
			return  bd.buscarTarifasCarrierByProveedor(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar tarifas carrier por proveedor");
		}
		return null;
	}

	public List<DTO_Factura> buscarFacturasPendientesByDniCliente(String filtro) {
		try{
			return  bd.buscarFacturasPendientesByDniCliente(filtro);
		}
		catch(Exception e){
			System.out.println("Error al buscar facturas por cliente");
		}
		return null;
	}

	public DTO_Encomienda getEncomiendaParticular(Integer id) {
		try{
			return bd.getEncomiendaParticular(id);
		}
		catch(Exception e){
			System.out.println("Error al buscar encomienda");
		}
		return null;
	}


	public DTO_Encomienda getEncomiendaEmpresa(Integer id) {
		try{
			return bd.getEncomiendaEmpresa(id);
		}
		catch(Exception e){
			System.out.println("Error al buscar encomienda");
		}
		return null;
	}

	public List<DTO_EncomiendaParticular> listarEncomiendasParticulares() {
		try{
			return  bd.listarEncomiendasParticulares();
		}
		catch(Exception e){
			System.out.println("Error al buscar encomiendas particulares");
		}
		return null;
	}

	public List<DTO_EncomiendaEmpresa> listarEncomiendasEmpresa() {
		try{
			return  bd.listarEncomiendasEmpresas();
		}
		catch(Exception e){
			System.out.println("Error al buscar encomiendas empresa");
		}
		return null;
	}

	public DTO_ClienteEmpresa getEmpresaById(Integer id) {
		try{
			return  bd.getClienteEmpresaById(id);
		}
		catch(Exception e){
			System.out.println("Error al buscar cliente por id");
		}
		return null;
	}

	public List<DTO_EnvioPropio> listarEnviosPropios() {
		try{
			return  bd.listarEnviosPropios();
		}
		catch(Exception e){
			System.out.println("Error al listar envios");
		}
		return null;
	}

	public DTO_Coordenada getCoordenadaById(int id) {
		try{
			return  bd.getCoordenadasById(id);
		}
		catch(Exception e){
			System.out.println("Error al buscar coordenadas por id");
		}
		return null;
	}

	public List<DTO_EnvioTercerizado> listarEnviosTercerizados() {
		try{
			return  bd.listarEnviosTercerizados();
		}
		catch(Exception e){
			System.out.println("Error al listar envios");
		}
		return null;
	}

	public List<DTO_EnvioTercerizado> buscarEnviosByEstado(String filtro) {
		try{
			return  bd.buscarEnviosByEstado(filtro);
		}
		catch(Exception e){
			System.out.println("Error al listar envios");
		}
		return null;
	}
	
	public List<DTO_EnvioPropio> buscarEnviosPropiosByEstado(String filtro) {
		try{
			return  bd.buscarEnviosPropiosByEstado(filtro);
		}
		catch(Exception e){
			System.out.println("Error al listar envios");
		}
		return null;
	}


	public List<DTO_Provincia> listarProvincias(String pais) {
		try{
			return  bd.listarProvinciasByPais(pais);
		}
		catch(Exception e){
			System.out.println("Error al listar provincias");
		}
		return null;
	}

	public void altaSucursal(String desc, String calle, String prov,
			String loc, String codPostal, String telefono, String dniGerente) {
		try{
			DTO_Sucursal sucursal = new DTO_Sucursal();
			sucursal.setDescripcion(desc);
			sucursal.setTelefono(telefono);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			DTO_Usuario gerente =bd.getUsuarioPorDni(dniGerente);
			
			sucursal.setDireccion(dir);
			sucursal.setIdGerente(gerente.getId());
			
			bd.altaSucursal(sucursal);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta la sucursal");
		}}


	private DTO_Provincia buscarProvinciaByNombre(String prov) {
		try{
			return  bd.buscarProvinciaByNombre(prov);
		}
		catch(Exception e){
			System.out.println("Error al buscar provincia");
		}
		return null;
	}

	public Vector armarComboProvincias(String pais){
		List<DTO_Provincia> lista = listarProvincias(pais);
		Vector v =new Vector();
		int i=0;
		for(DTO_Provincia p:lista){
			v.add(i,p.getDescripcion());
			i++;
		}
		return v;
	}

	public void altaClienteEmpresa(String razonSocial, String cuit, boolean activa, String calle,
			String codPostal, String loc, String prov, String pais, String email,
			 String telefono, float limiteCredito, String formaPago) {
		try{
			DTO_ClienteEmpresa cliente = new DTO_ClienteEmpresa();
			cliente.setCuit(cuit);
			cliente.setRazonSocial(razonSocial);
			cliente.setTelefono(telefono);
			cliente.setEstado(activa);
			cliente.setEmail(email);
	
			DTO_CuentaCorriente cte = new DTO_CuentaCorriente();
			cte.setFormaPago(formaPago);
			cte.setLimiteCredito(limiteCredito);
			cliente.setCuentaCorriente(cte);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			cliente.setDireccion(dir);
			
			bd.altaClienteEmpresa(cliente);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al guardar cliente empresa");
		}
	}
	
	public void modificarClienteEmpresa(int id, String razonSocial, String cuit, boolean activa, String calle,
			String codPostal, String loc, String prov, String pais, String email,
			 String telefono, float limiteCredito, String formaPago) {
		try{
			DTO_ClienteEmpresa cliente = new DTO_ClienteEmpresa();
			cliente.setCuit(cuit);
			cliente.setRazonSocial(razonSocial);
			cliente.setTelefono(telefono);
			cliente.setEstado(activa);
			cliente.setEmail(email);
	
			DTO_CuentaCorriente cte = new DTO_CuentaCorriente();
			cte.setFormaPago(formaPago);
			cte.setLimiteCredito(limiteCredito);
			cliente.setCuentaCorriente(cte);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			cliente.setId(id);
			cliente.setDireccion(dir);
			
			bd.modificarClienteEmpresa(cliente);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar cliente empresa");
		}
	}

	public void altaClienteParticular(String nombre, String apellido, boolean activa, String calle,
			String codPostal, String loc, String prov, String pais, String email,
			 String telefono, String dni) {
		try{
			DTO_ClienteParticular cliente = new DTO_ClienteParticular();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setTelefono(telefono);
			cliente.setEstado(activa);
			cliente.setEmail(email);
			cliente.setDni(dni);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			cliente.setDireccion(dir);
			
			bd.altaClienteParticular(cliente);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al guardar cliente particular");
		}
		
	}
	
	public void modificarClienteParticular(int id,String nombre, String apellido, boolean activa, String calle,
			String codPostal, String loc, String prov, String pais, String email,
			 String telefono, String dni) {
		try{
			DTO_ClienteParticular cliente = new DTO_ClienteParticular();
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setTelefono(telefono);
			cliente.setEstado(activa);
			cliente.setEmail(email);
			cliente.setDni(dni);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			cliente.setId(id);
			cliente.setDireccion(dir);
			
			bd.modificarClienteParticular(cliente);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar cliente particular");
		}
		
	}
	
	public boolean altaVehiculo(String tipo, String patente, String marca,
			String modelo, Float km, String anio, Float ancho, Float alto,
			Float largo, Float peso, Float tara, Float volumen,
			Date fechaIngreso, Date fechaUltMant, Integer idSucursal,
			Integer idSucursalActual, float temperaturaMin,
			float temperaturaMax, Integer idPlan) {
		 try {
				DTO_Vehiculo v = new DTO_Vehiculo();
				v.setTipo(tipo);
				v.setPatente(patente);
				v.setMarca(marca);
				v.setModelo(modelo);
				v.setKmsRecorridos(km);
				v.setAncho(ancho);
				v.setAlto(alto);
				v.setLargo(largo);
				v.setPeso(peso);
				v.setTara(tara);
				v.setAnio(anio);
				v.setVolumen(volumen);
				v.setFechaIngreso(fechaIngreso);
			/*	v.setUltimoMantenimiento(fechaUltMant);
				v.setUltimoUso(fechaUltUso);
				v.setVencimientoGarantia(vencimientoGarantia); */
				v.setSucursal(this.getSucursal(idSucursal));
				//v.setIdSucursalActual(idSucursalActual);
				v.setTemperaturaMin(temperaturaMin);
				v.setTemperaturaMax(temperaturaMax);
				v.setPlanMantenimiento(this.getPlanMantenimiento(idPlan));
					
				bd.altaVehiculo(v);
				return true;
			 } catch (RemoteException e) {
				 e.printStackTrace();
				 System.out.println("Error al crear vehiculo");
			 }   
			 return false;
	}
	

	public boolean modificarVehiculo(int id, String tipo, String patente, String marca,
			String modelo, Float km, String anio, Float ancho, Float alto,
			Float largo, Float peso, Float tara, Float volumen,
			Date fechaIngreso, Date fechaUltMant, Integer idSucursal,
			Integer idSucursalActual, float temperaturaMin,
			float temperaturaMax, Integer idPlan) {
		 try {
				DTO_Vehiculo v = new DTO_Vehiculo();
				v.setTipo(tipo);
				v.setId(id);
				v.setPatente(patente);
				v.setMarca(marca);
				v.setModelo(modelo);
				v.setKmsRecorridos(km);
				v.setAncho(ancho);
				v.setAlto(alto);
				v.setLargo(largo);
				v.setPeso(peso);
				v.setTara(tara);
				v.setAnio(anio);
				v.setVolumen(volumen);
				v.setFechaIngreso(fechaIngreso);
			/*	v.setUltimoMantenimiento(fechaUltMant);
				v.setUltimoUso(fechaUltUso);
				v.setVencimientoGarantia(vencimientoGarantia); */
				v.setSucursal(this.getSucursal(idSucursal));
				//v.setIdSucursalActual(idSucursalActual);
				v.setTemperaturaMin(temperaturaMin);
				v.setTemperaturaMax(temperaturaMax);
				v.setPlanMantenimiento(this.getPlanMantenimiento(idPlan));
					
				bd.modificarVehiculo(v);
				return true;
			 } catch (Exception e) {
				 e.printStackTrace();
				 System.out.println("Error al modificar el vehiculo");
			 }   
			 return false;
	}

	public DTO_PlanMantenimiento getPlanMantenimiento(Integer id) {
		try{
			return  bd.getPlanMantenimiento(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar plan de mantenimiento");
		}
		return null;
	}

	public DTO_Sucursal getSucursal(Integer id) {
		try{
			return  bd.getSucursal(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar sucursal");
		}
		return null;
	}

	public void altaProveedor(DTO_Direccion direccion, String activo, String cuit,
			String razonSocial, String email, String telefono,
			int tallerOficial, char tipo) {
		try{
			DTO_Proveedor prov=new DTO_Proveedor();
			prov.setActivo(activo);
			prov.setCuit(cuit);
			prov.setRazonSocial(razonSocial);
			prov.setEmail(email);
			prov.setTelefono(telefono);
			if(tallerOficial==1)
				prov.setTallerOficial(true);
			else
				prov.setTallerOficial(false);
			
			prov.setTipo(tipo);
			prov.setDireccion(direccion);
			
			System.out.println(prov.toString());
			
			bd.altaProveedor(prov);
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al crear Proveedor");
		}
	}

	public DTO_Pais getPaisByNombre(String pais) {
		try{
			return bd.getPaisByNombre(pais);
		}catch(Exception e){
			System.out.println("Error al traer pais por nombre");
		}
		return null;
	}

	public DTO_Provincia getProvByNombre(String prov) {
		try{
			return bd.getProvByNombre(prov);
		}catch(Exception e){
			System.out.println("Error al traer provincia por nombre");
		}
		return null;
	}
	
	public List<DTO_Pais> listaPaises() {
		try{
			return  bd.listarPaises();
		}
		catch(Exception e){
			System.out.println("Error al listar paises");
		}
		return null;
	}

	public Vector listarPaises() {
		List<DTO_Pais> lista = listaPaises();
		Vector v =new Vector();
		int i=0;
		for(DTO_Pais p:lista){
			v.add(i,p.getDescripcion());
			i++;
		}
		return v;
	}

	public boolean altaPlanMantenimiento(String descripcion,  String comentario) {
		try{
			DTO_PlanMantenimiento pm = new DTO_PlanMantenimiento();
			pm.setDescripcion(descripcion);
			pm.setComentarios(comentario);
			
			bd.altaPlanMantenimiento(pm);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al crear plan de mantenimiento");
		}
		return false;
	}

	public boolean altaTareaMantenimientoKilometro(Integer plan, String tarea,
			float cantKm) {
		try{
			DTO_TareasPorKilometro tpk = new DTO_TareasPorKilometro();
			tpk.setIdPlanMantenimiento(plan);
			tpk.setTarea(tarea);
			tpk.setCantidadKilometros(cantKm);
			
			bd.altaTareaMantenimiento(tpk);
			return true;
		}
		catch(Exception e){
			
		}
		return false;
	}

	public boolean altaTareaMantenimientoTiempo(Integer plan, String tarea,
			Float  cant) {
		try{
			DTO_TareasPorTiempo tpt = new DTO_TareasPorTiempo();
			tpt.setCantidadDias(Math.round(cant));
			tpt.setIdPlanMantenimiento(plan);
			tpt.setTarea(tarea);
			
			bd.altaTareaMantenimiento(tpt);
			return true;
		}
		catch(Exception e){
			
		}
		return false;
	}

	public boolean altaTareaMantenimientoRealizada(Integer idTarea, Integer idVehiculo,
			Date fecha, float kmsRecorridos, Integer idProv) {
		try{
			DTO_TareaMantenimientoRealizada tmr = new DTO_TareaMantenimientoRealizada();
			tmr.setCantidadKilometros(kmsRecorridos);
			tmr.setFecha(fecha);
			tmr.setIdProveedor(idProv);
			tmr.setIdTareaMantenimiento(idTarea);
			tmr.setIdVehiculo(idVehiculo);
			
			bd.altaTareaMantenimientoRealizada(tmr);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("No se puede cargar tarea realizada");
		}
		return false;
	}

	public DTO_Vehiculo buscarVehiculo(String patente) {
		try{
			return  bd.buscarVehiculo(patente);
		}
		catch(Exception e){
			System.out.println("Error al buscar vehiculo");
		}
		return null;
	}

	public List<DTO_TareaMantenimiento> listarTareasMantenimiento(Integer idPlan) {
		try{
			return bd.getTareasMantenimiento(idPlan);
		}
		catch(RemoteException e) {
	       	 System.out.println(e);
	            System.out.println("Error al listar tareas por plan");
	        }   
	        return null;
	}

	public List<DTO_Rol> listarRoles() {
		try{
			return bd.listarRoles();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al listar roles");
		}
		return null;
	}

	public boolean altaUsuario(String nombre, String apellido, String dni, String usuario, String password, Date fecha, DTO_Sucursal suc, List<DTO_Rol> roles) {
		try{
			DTO_Usuario usu = new DTO_Usuario();
			usu.setApellido(apellido);
			usu.setIdSucursal(suc.getId());
			usu.setNombre(nombre);
			usu.setPassword(password);
			usu.setUsuario(usuario);
			usu.setFechaCreacion(fecha);
			usu.setRoles(roles);
			usu.setDni(dni);
			
			bd.altaUsuario(usu);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta un usuario");
		}
		return false;
	}

	public boolean cambiarPassword(String usuario, String oldPassword, String newPassword) {
		try{
			return bd.cambiarPassword(usuario, oldPassword, newPassword);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("No se ha podido cambiar la password");
		}
		return false;
	}

	public boolean existeUsuario(String usuario) {
		try {
			 DTO_Usuario user = bd.existeUsuario(usuario);
			 if(user!=null)
				 return true;
			 else
				 return false;
		}
		catch (RemoteException e) {
    	 e.printStackTrace();
        System.out.println("Error al verificar si existe el usuario");
		}  
		return false;
	}

	public boolean altaProductoCliente(String codigo, String descripcion, String categoria,
			String unidad, Integer idCliente) {
		try{
			DTO_Producto producto = new DTO_Producto();
			producto.setCategoria(categoria);
			producto.setDescripcion(descripcion);
			producto.setCodigo(codigo);
			producto.setUnidad(unidad);
			producto.setIdCliente(idCliente);
			
			bd.altaProducto(producto);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta un producto");
		}
		return false;
	}

	public boolean altaSeguro(Integer idProveedor, String tipo, String descripcion,Float monto) {
		try{
			DTO_Seguro seguro = new DTO_Seguro();
			seguro.setDescripcion(descripcion);
			seguro.setIdProveedor(idProveedor);
			seguro.setTarifa(monto);
			seguro.setTipoSeguro(tipo);
			bd.altaSeguro(seguro);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta Seguro");
		}
		return false;
	}

	public DTO_Proveedor buscarProveedorByCuit(String cuit) {
		try{
			return bd.buscarProveedorByCuit(cuit);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar Proveedor por cuit");
		}
		return null;
	}

	public boolean altaServicioSeguridad(Integer idProveedor, String descripcion, Float monto) {
		try{
			DTO_ServicioSeguridad ss = new DTO_ServicioSeguridad();
			ss.setDescripcion(descripcion);
			ss.setIdProveedor(idProveedor);
			ss.setTarifa(monto);
			bd.altaServicioSeguridad(ss);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta Servicio de Seguridad");
		}
		return false;
	}
	
	public boolean altaTarifaCarrier(int idProveedor, String ciudad, String comentarios, String prioridad, float precioKMExtra, float monto, DTO_Pais pais,
			DTO_Sucursal sucursal) {
		try{
			DTO_TarifasCarrier tc = new DTO_TarifasCarrier();
			tc.setComentarios(comentarios);
			tc.setIdProveedor(idProveedor);
			tc.setTarifa(monto);
			tc.setPrecioKMExtra(precioKMExtra);
			tc.setPrioridad(prioridad);
			tc.setCiudad(ciudad);
			tc.setPais(pais);
			tc.setOrigen(sucursal);
			bd.altaTarifasCarrier(tc);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al dar de alta Tarifas Carrier");
		}
		return false;
	}
	
	public boolean modificarTarifaCarrier(int id, int idProveedor, String ciudad, String comentarios, String prioridad, float precioKMExtra, float monto, DTO_Pais pais,
			DTO_Sucursal sucursal) {
		try{
			DTO_TarifasCarrier tc = new DTO_TarifasCarrier();
			tc.setComentarios(comentarios);
			tc.setIdProveedor(idProveedor);
			tc.setTarifa(monto);
			tc.setPrecioKMExtra(precioKMExtra);
			tc.setPrioridad(prioridad);
			tc.setCiudad(ciudad);
			tc.setPais(pais);
			tc.setOrigen(sucursal);
			tc.setId(id);
			bd.modificarTarifasCarrier(tc);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar la Tarifa Carrier");
		}
		return false;
	}

	public List<DTO_Direccion> listarDestinoNacionalSucursal(Integer id) {
		try {
       	 return bd.listarDestinoNacional(id);
        } catch (Exception e) {
       	 	e.printStackTrace();
            System.out.println("Error Listar Destino Nacional por Sucursal");
        }   
        return null;
	}

	public List<DTO_Direccion> listarDestinoInternacionalSucursal(Integer id) {
		try {
       	 return bd.listarDestinoInternacional(id);
        } catch (Exception e) {
       		e.printStackTrace();
            System.out.println("Error Listar Destino Internacional por Sucursal");
        }   
        return null;
	}

	
	public DTO_Vehiculo getVehiculoByPatente(String patente) {
		try{
			return bd.buscarVehiculoByPatente(patente);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar vehiculo por patente");
		}
		return null;
	}

	public boolean bajaSucursal(Integer id) {
		try{
			if(!bd.sucursalTieneEncomiendas(id)){
				bd.bajaSucursal(id);
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Sucursal");
		}
		return false;
	}

	public boolean bajaCliente(Integer id) {
		try{
			if(!bd.clienteTieneEncomiendas(id)){
				bd.eliminarCliente(id);
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Cliente");
		}
		return false;
	}

	public boolean bajaProductoCliente(Integer id) {
		try{
			//verificar no pertence a un manifiesto o remito
			if(!bd.estaProductoAsociado(id)){
				bd.eliminarProducto(id);
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Producto");
		}
		return false;
	}

	public DTO_Producto getProductoCliente(Integer id) {
		try{
			return bd.getProducto(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar Producto");
		}
		return null;
	}

	public boolean bajaPlanMantenimiento(Integer id) {
		try{
			bd.bajaPlanMantenimiento(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Plan de Mantenimiento");
		}
		return false;
	}

	public boolean bajaProveedor(Integer id) {
		try{
			bd.bajaProveedor(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar el Proveedor");
		}
		return false;
	}

	public boolean bajaUsuario(Integer id) {
		try{
			bd.bajaUsuario(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar el Usuario");
		}
		return false;
	}

	public DTO_Seguro getSeguro(Integer id) {
		try{
			return bd.getSeguro(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al traer Seguro");
		}
		return null;
	}

	public boolean bajaSeguro(Integer id) {
		try{
			bd.bajaSeguro(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar el Seguro");
		}
		return false;
	}

	public DTO_ServicioSeguridad getServicioSeguridad(Integer id) {
		try{
			return bd.getServicioSeguridad(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al traer Servicio de Seguridad");
		}
		return null;
		
	}

	public boolean bajaServicioSeguridad(Integer id) {
		try{
			bd.bajaServicioSeguridad(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar el Servicio de Seguridad");
		}
		return false;
	}

	public DTO_TarifasCarrier getTarifasCarrier(Integer id) {
		try{
			return bd.getTarifasCarrier(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al traer Tarifa de Carrier");
		}
		return null;
	}

	public boolean bajaTarifasCarrier(Integer id) {
		try{
			bd.bajaTarifasCarrier(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar la Tarfifa de Carrier");
		}
		return false;
	}

	public DTO_MapaDeRuta getMapaDeRuta(Integer id) {
		try{
			return bd.getMapaDeRuta(id);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al buscar Mapa de Ruta");
		}
		return null;
	}

	public boolean bajaMapaDeRuta(Integer id) {
		try{
			bd.bajaMapaDeRuta(id);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar el Mapa de Ruta");
		}
		return false;
	}

	public boolean bajaVehiculo(Integer id) {
		try{
			if(!bd.vehiculoAsociadoAEnvio(id)){
				bd.bajaVehiculo(id);
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Vehiculo");
		}
		return false;
	}

	public boolean bajaTareaMantenimiento(Integer id) {
		try{
			if(!bd.tareaEstaRealizada(id)){
				bd.bajaTareaMantenimiento(id);
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al borrar Tarea de Mantenimiento");
		}
		return false;
	}

	public void modificarSucursal(int id, String desc, String calle, String prov,
			String loc, String codPostal, String telefono, String dniGerente) {
		try{
			DTO_Sucursal sucursal = new DTO_Sucursal();
			sucursal.setDescripcion(desc);
			sucursal.setTelefono(telefono);
			
			DTO_Provincia provincia = buscarProvinciaByNombre(prov);
			
			DTO_Direccion dir = new DTO_Direccion();
			dir.setCalle(calle);
			dir.setCodigoPostal(Integer.valueOf(codPostal));
			dir.setLocalidad(loc);
			dir.setProvincia(provincia);
			dir.setPais(provincia.getPais());
			
			DTO_Usuario gerente =bd.getUsuarioPorDni(dniGerente);
			
			sucursal.setDireccion(dir);
			sucursal.setIdGerente(gerente.getId());
			sucursal.setId(id);
			bd.modificarSucursal(sucursal);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar sucursal");
		}
		
	}
	public void modificarProveedor(int id, DTO_Direccion direccion, String activo, String cuit,
			String razonSocial, String email, String telefono,
			int tallerOficial, char tipo) {
		try{
			DTO_Proveedor prov=new DTO_Proveedor();
			prov.setActivo(activo);
			prov.setCuit(cuit);
			prov.setRazonSocial(razonSocial);
			prov.setEmail(email);
			prov.setTelefono(telefono);
			if(tallerOficial==1)
				prov.setTallerOficial(true);
			else
				prov.setTallerOficial(false);
			
			prov.setTipo(tipo);
			prov.setDireccion(direccion);
			prov.setId(id);

			
			bd.modificarProveedor(prov);
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar Proveedor");
		}
	}


	public void altaMapaDeRuta(DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino, Float cantKm, Float costo,
			Float duracion, Map<String, String> mapLatLong) {
		
		try{
			DTO_MapaDeRuta mapa = new DTO_MapaDeRuta();
			mapa.setCantKm(cantKm);
			mapa.setCosto(costo);
			mapa.setDuracion(duracion);
			mapa.setIdSucursalDestino(sucursalDestino.getId());
			mapa.setIdSucursalOrigen(sucursalOrigen.getId());
			
			List<DTO_Coordenada> coordenadas = new ArrayList<DTO_Coordenada>();
			for (Map.Entry<String, String> item : mapLatLong.entrySet()) {
				DTO_Coordenada coord = new DTO_Coordenada();
				coord.setLatitud(item.getKey());
				coord.setLongitud(item.getValue());
				coordenadas.add(coord);
			}
			mapa.setCoordenadas(coordenadas);
			bd.altaMapaDeRuta(mapa);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al guardar mapa de ruta");
		}
		
	}

	public void modificarMapaDeRuta(int id, DTO_Sucursal sucursalOrigen,
					DTO_Sucursal sucursalDestino, Float cantKm, Float costo,
					Float duracion, Map<String, String> mapLatLong) {
				
				try{
					DTO_MapaDeRuta mapa = new DTO_MapaDeRuta();
					mapa.setId(id);
					mapa.setCantKm(cantKm);
					mapa.setCosto(costo);
					mapa.setDuracion(duracion);
					mapa.setIdSucursalDestino(sucursalDestino.getId());
					mapa.setIdSucursalOrigen(sucursalOrigen.getId());
					
					List<DTO_Coordenada> coordenadas = new ArrayList<DTO_Coordenada>();
					for (Map.Entry<String, String> item : mapLatLong.entrySet()) {
						DTO_Coordenada coord = new DTO_Coordenada();
						coord.setLatitud(item.getKey());
						coord.setLongitud(item.getValue());
						coordenadas.add(coord);
					}
					mapa.setCoordenadas(coordenadas);
					bd.modificarMapaDeRuta(mapa);
				}
				catch(Exception e){
					e.printStackTrace();
					System.out.println("Error al guardar mapa de ruta");
				}
				
			}
		
	
}
