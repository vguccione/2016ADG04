package com.ADG04.Servidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.ADG04.Negocio.GestionAdministracion;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.TipoClienteDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.TipoCliente;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Usuario;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
 //   	TestPaisDao();
    	TestUsuario();
    }
    
    public static void TestClienteDao(){
    	EntityManagerFactory factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
    	EntityManager em = factory.createEntityManager();
    	ClienteDao dao = new ClienteDao(em);
        Cliente cliente = dao.getById(1);
        System.out.println(cliente.getApellido());    
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
    
    public static void TestPaisDao(){
    	EntityManagerFactory factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
    	EntityManager em = factory.createEntityManager();
    	PaisDao dao = new PaisDao(em);
         
         Pais p =new Pais("Argentina");
        
         
         dao.persist(p);
         
         EntityManagerProvider.getInstance().close();
    }
}
