package com.ADG04.Servidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sound.sampled.Clip;

import com.ADG04.Negocio.GestionAdministracion;
import com.ADG04.Negocio.GestionCliente;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.TipoClienteDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.TipoCliente;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	TestAltaCliente();
    	
 //   	TestPaisDao();
    //	TestUsuario();
    }
    
    private static void TestAltaCliente() {

    	//Para probar uso una direccion que existe
    	DTO_Direccion direccion = new DTO_Direccion();
    	direccion.setIdDireccion(1);
    	    	
    	DTO_ClienteParticular cliParticular = new DTO_ClienteParticular();
    	
    	cliParticular.setApellido("Guccione");
    	cliParticular.setDni("32437264");
		cliParticular.setEmail("vguccione@gmail.com");
		cliParticular.setEstado(true);
		cliParticular.setNombre("Vanesa");
		cliParticular.setTelefono("1556932544");
		cliParticular.setDireccion(direccion);
		
		GestionCliente.getInstancia().altaCliente(cliParticular);
    }

	public static void TestUsuario(){
    	DTO_Usuario usuario = new DTO_Usuario();
    	usuario.setApellido("Pepe");
    	usuario.setDni("212328");
    	usuario.setFechaCreacion(new Date());
    	usuario.setNombre("pepepe");
    	usuario.setPassword("xxxxxx");
    	usuario.setUltimoAcceso(new Date());
    	
    	DTO_RolUsuario rol = new DTO_RolUsuario();
    	rol.setdescripcion("Rol1");
    	
    	usuario.setRolUsuario(rol);
    	
    	GestionAdministracion.getInstancia().altaUsuario(usuario);
    }
    
    
}
