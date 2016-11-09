package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public interface IAdministracionRemote {

	/***************** Usuario (Empleado) *************************************/
	public void altaUsuario(DTO_Usuario Usuario) throws RemoteException;
	public void modificarUsuario(DTO_Usuario Usuario) throws RemoteException;
	public void bajaUsuario(Integer idUsuario) throws RemoteException;
	public DTO_Usuario getUsuario(Integer idUsuario) throws RemoteException;
	public DTO_Usuario getUsuario(String dni) throws RemoteException;
	public DTO_Usuario login(String usuario, String password) throws RemoteException;
	public DTO_Usuario getUsuarioPorDni(String dni) throws RemoteException;
	public List<DTO_Usuario> listarEmpleados() throws RemoteException;
	public List<DTO_Rol> listarRoles() throws RemoteException;
	public List<DTO_Usuario> listarEmpleados(Integer idSucursal) throws RemoteException;
	public List<DTO_Usuario> getUsuarios() throws RemoteException;
	public List<String> buscarRolesUsuario(int usuario) throws RemoteException;
	public List<DTO_Usuario> buscarUsuariosByNombreApellidoOUsuario(String filtro) throws RemoteException;
	public DTO_Usuario existeUsuario(String usuario) throws RemoteException;
	
	/*************************** Sucursal *************************************/
	public void altaSucursal(DTO_Sucursal sucursal) throws RemoteException;
	public void modificarSucursal(DTO_Sucursal sucursal) throws RemoteException;
	public void bajaSucursal(Integer idSucursal) throws RemoteException;
	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException;
	public List<DTO_Sucursal> listarSucursales() throws RemoteException;
	public List<DTO_Sucursal> buscarSucursalesByNombre(String filtro) throws RemoteException;
	public boolean sucursalTieneEncomiendas(Integer id) throws RemoteException;
	
	
	/*************************** Proveedores *************************************/
	public void altaProveedor(DTO_Proveedor prov) throws RemoteException;
	public void altaSeguro(DTO_Seguro seguro) throws RemoteException;
	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException;
	public void altaTarifasCarrier(DTO_TarifasCarrier tarifasCarrier) throws RemoteException;
	public void modificarTarifasCarrier(DTO_TarifasCarrier tarifasCarrier) throws RemoteException;
	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad) throws RemoteException;
	public void modificarServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad) throws RemoteException;
	public void bajaProveedor(Integer idProveedor) throws RemoteException;
	public DTO_Proveedor getProveedor(Integer idProveedor) throws RemoteException;
	public List<DTO_Seguro> getSeguros() throws RemoteException;
	public List<DTO_TarifasCarrier> getTarifasCarriers() throws RemoteException;
	public List<DTO_ServicioSeguridad> getServicioSeguridad() throws RemoteException;
	public List<DTO_Proveedor> getTalleresMecanicos() throws RemoteException;
	public List<DTO_Proveedor> getAseguradoras() throws RemoteException;
	public List<DTO_Proveedor> getEmpresasServiciosSeguridad() throws RemoteException;
	public List<DTO_Proveedor> getCarriers() throws RemoteException;
	public List<DTO_Proveedor> getProveedores() throws RemoteException;
	public List<DTO_Proveedor> buscarProveedorByRazonSocial(String filtro)  throws RemoteException;
	public List<DTO_Seguro> buscarSegurosByProveedor(String filtro) throws RemoteException;
	public List<DTO_ServicioSeguridad> buscarServicioSeguridadByProveedor(String filtro) throws RemoteException;
	public List<DTO_TarifasCarrier> buscarTarifasCarrierByProveedor(String filtro) throws RemoteException;
	public DTO_Proveedor buscarProveedorByCuit(String cuit) throws RemoteException;
	public void bajaServicioSeguridad(Integer id) throws RemoteException;
	public void bajaMapaDeRuta(Integer id) throws RemoteException;
	public void bajaSeguro(Integer id) throws RemoteException;
	public void bajaTarifasCarrier(Integer id) throws RemoteException;
	public DTO_ServicioSeguridad getServicioSeguridad(Integer id) throws RemoteException;
	public DTO_TarifasCarrier getTarifasCarrier(Integer id) throws RemoteException;
	public DTO_Seguro getSeguro(Integer id) throws RemoteException;
	public void modificarProveedor(DTO_Proveedor prov) throws RemoteException;

	/*************************** Otros *************************************/
	public List<DTO_Provincia> listarProvinciasByPais(String pais) throws RemoteException;
	public DTO_Provincia buscarProvinciaByNombre(String prov) throws RemoteException;
	public List<DTO_Pais> listarPaises() throws RemoteException;
	public DTO_Pais getPaisByNombre(String pais) throws RemoteException;
	public DTO_Provincia getProvByNombre(String prov) throws RemoteException;
	public boolean cambiarPassword(String usuario, String oldPassword,String newPassword) throws RemoteException;
	public void altaMapaDeRuta(DTO_MapaDeRuta mapa) throws RemoteException, BusinessException;
	public DTO_MapaDeRuta getMapaDeRuta(Integer id) throws RemoteException;
	public void modificarMapaDeRuta(DTO_MapaDeRuta mapa) throws RemoteException, BusinessException;
}
