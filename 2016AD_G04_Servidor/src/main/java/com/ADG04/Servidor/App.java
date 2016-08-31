package com.ADG04.Servidor;

import java.util.ArrayList;
import java.util.List;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.util.EntityManagerProvider;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ClienteDao dao = new ClienteDao(EntityManagerProvider.getInstance().getEntityManager());
         
         Cliente juan =new Cliente("Juan");
        
         
         dao.persist(juan);
         
         EntityManagerProvider.getInstance().close();
    }
}
