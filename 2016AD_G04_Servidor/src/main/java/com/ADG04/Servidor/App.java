package com.ADG04.Servidor;

import java.util.ArrayList;
import java.util.List;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.util.EntityManagerProvider;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 PaisDao dao = new PaisDao(EntityManagerProvider.getInstance().getEntityManager());
         
         Pais p =new Pais("Argentina");
        
         
         dao.persist(p);
         
         EntityManagerProvider.getInstance().close();
    }
}
