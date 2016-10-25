package com.ADG04.Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.bean.*;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;

public class BusinessDelegate {
	
	InterfazRemotaDistribucionPaquetes objetoRemoto;
	private static BusinessDelegate instancia;
	
	private BusinessDelegate(){
		getStub();
	}
	
	public static BusinessDelegate getInstancia(){
		if(instancia==null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	public boolean getStub(){
		try {
			objetoRemoto = (InterfazRemotaDistribucionPaquetes) 
					Naming.lookup(InterfazRemotaDistribucionPaquetes.url);
			
			//System.setProperty("java.security.policy", "./conf.txt");
//			if (System.getSecurityManager() == null) {
//			            System.setSecurityManager(new SecurityManager());
//			        }
			
			System.out.println("Servicio Obtenido de la interfaz remota: "					+ InterfazRemotaDistribucionPaquetes.url);
			
		return true;
			
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (NotBoundException e) {

			e.printStackTrace();
		}
		
		return false;
	}

	
	//Usuarios-----------------------------------------------------------------
	
	// TODO Completar el metodo validarUsuario
	public DTO_Usuario validarUsuario(String usuario, String contrasena) throws RemoteException{		
		DTO_Usuario usu = objetoRemoto.validarUsuario(usuario,contrasena);
		//List<DTO_Rol> roles = objetoRemoto.buscarRolesUsuario(usu.getUsuario());
		//usu.setRoles(roles);
		return usu;
		
	}


	//@SuppressWarnings("null")
	public Integer pagarFacturaClientePaticular(Integer idFactura){
		return  objetoRemoto.cobrarEncomiendaParticular(idFactura);
		
	}
	
	//@SuppressWarnings("null")
		public Integer pagarFacturaClienteEmpresa(Integer idFactura){
			List<Integer> lista = new ArrayList<Integer>();
			lista.add(idFactura);
			return  objetoRemoto.cobrarEncomiendaEmpresa(lista);
			
		}
	
	
	

	//@SuppressWarnings("null")
	public Integer obtenerSucursalEmpleado(Integer idEmpleado){
		//llamo por RMI a una funcion que con el numero de idEmpleado me da el idSucursal
		try {
			return  objetoRemoto.getUsuario(idEmpleado).getIdSucursal();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//@SuppressWarnings("null")
	public Integer nuevaEncomienda(Integer idSucursal){
		//llamo por RMI a una funcion que con el numero de idEmpleado me da el idSucursal
	
		return  objetoRemoto.nuevaEncomiendaParticular(idSucursal);
		
	}	
	
	//@SuppressWarnings("null")
		public Integer nuevaEncomiendaEmpresa(Integer idSucursal) throws RemoteException{
			//llamo por RMI a una funcion que con el numero de idEmpleado me da el idSucursal
		
			return  objetoRemoto.nuevaEncomiendaEmpresa(idSucursal);
			
		}	

	public Integer confirmarEncomiendaParticular(DTO_EncomiendaParticular enc){
		
		return objetoRemoto.confirmarEncomiendaParticular(enc);
		//return objetoRemoto.facturarEncomiendaParticular(enc.getId());
	}	
	
	public Integer confirmarEncomiendaEmpresa(DTO_EncomiendaEmpresa enc) throws RemoteException{
		
		return objetoRemoto.confirmarEncomiendaEmpresa(enc);
		//return objetoRemoto.facturarEncomiendaEmpresa(enc.getIdEncomienda());
	}
/*
	public Integer ingresarEncomiendaParticularAStock(DTO_EncomiendaEnStock es){
		
		try {
			return objetoRemoto.ingresarEncomiendaParticularAStock(es);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
	
	public Integer ingresarEncomiendaEmpresaAStock(DTO_EncomiendaEnStock es){
		
		try {
			return objetoRemoto.ingresarEncomiendaEmpresaAStock(es);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
	
	
	
	public Integer egresarEncomiendaParticularDeStock(Integer idStock, Integer idEncomienda){
		
		try {
			return objetoRemoto.egresarEncomiendaParticularDeStock(idStock,idEncomienda);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
		
	
	public Integer egresarEncomiendaEmpresaDeStock(Integer idStock, Integer idEncomienda){
		
		try {
			return objetoRemoto.egresarEncomiendaEmpresaDeStock(idStock,idEncomienda);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
	
	*/
	public String getSucursalNombre(Integer id){
		
		try {
			DTO_Sucursal suc = objetoRemoto.getSucursal(id);
			return suc.getDescripcion();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/*
	public List<DTO_Destino> listarDestinoNacional(Integer id){
		
		List<DTO_Destino> destinos = null; 
		
		try {
			destinos = objetoRemoto.listarDestinoNacional(id);
			return destinos;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinos;
	}	
	*/
	
	public Integer altaManifiesto(DTO_Manifiesto m){
		
		Integer idManifiesto;
		
		//llamo por RMI a una funcion que crea el manifiesto y me da el id
		//idManifiesto = altaManifiesto(m);
		
		idManifiesto = 70;
		
		return idManifiesto;
	}		
	/*
	public boolean ingresarEncomiendaEnvio(Integer idEnvio){
		objetoRemoto.ingresarEncomiendaEnvio(idEnvio);
		return true;
	}
	
	public boolean egresarEncomiendaEnvio(Integer idEnvio){
		objetoRemoto.egresarEncomiendaEnvio(idEnvio);
		return true;
	}*/

	
	
	//Clientes-----------------------------------------------------------------
	// TODO Completar el metodo	altaCliente
	/*public boolean altaCliente(dto.Cliente.DTO_Cliente cliente){
		boolean resp = false;
		return true;
	}
	
	// TODO Completar el metodo	agregarDireccionEntrega
	public boolean agregarDireccionEntrega(int idCliente, dto.Cliente.DTO_DireccionEntrega direccionEntrega){
		boolean resp = false;
		return true;
	}*/
	
	//Encomiendas--------------------------------------------------------------


	public Integer asignarEnvio(Integer idEncomienda) throws RemoteException {
		return objetoRemoto.asignarEnvio(idEncomienda);
	}

	
	
}
