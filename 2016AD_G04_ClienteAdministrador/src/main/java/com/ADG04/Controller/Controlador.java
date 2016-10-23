package com.ADG04.Controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;


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


}
