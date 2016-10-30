package com.ADG04.Controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_CuentaCorriente;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
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
	

	public Integer login(String usuario, String password) {
		try {
			 DTO_Usuario user = bd.login(usuario, password);
			 if(user!=null)
				 return user.getId();
			 else
				 return null;
		}
		catch (RemoteException e) {
     	 System.out.println(e);
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
	       	 System.out.println(e);
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

	public List<DTO_Encomienda> listarEncomiendasParticulares() {
		try{
			return  bd.listarEncomiendasParticulares();
		}
		catch(Exception e){
			System.out.println("Error al buscar encomiendas particulares");
		}
		return null;
	}

	public List<DTO_Encomienda> listarEncomiendasEmpresa() {
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

	public boolean altaSucursal(String text, String text2, String string,
			String text3, String text4, String text5, DTO_Usuario gerente) {
		// TODO Auto-generated method stub
		return false;
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

	public void altaCliente(String razonSocial, String cuit, boolean activa, String calle,
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

	public boolean altaVehiculo(String tipo, String patente, String marca,
			String modelo, Float km, Float ancho, Float alto,
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
				v.setVolumen(volumen);
				v.setFechaIngreso(fechaIngreso);
			/*	v.setUltimoMantenimiento(fechaUltMant);
				v.setUltimoUso(fechaUltUso);
				v.setVencimientoGarantia(vencimientoGarantia); */
				v.setSucursal(this.getSucursal(idSucursal));
				//v.setIdSucursalActual(idSucursalActual);
				//v.setTemperaturaMin(temperaturaMin);
				//v.setTemperaturaMax(temperaturaMax);
				v.setPlanMantenimiento(this.getPlanMantenimiento(idPlan));
					
				bd.altaVehiculo(v);
				return true;
			 } catch (RemoteException e) {
				 System.out.println(e);
				 System.out.println("Error al crear vehiculo");
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
	
	
}
