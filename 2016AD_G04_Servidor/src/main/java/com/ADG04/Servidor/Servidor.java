package com.ADG04.Servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.Servidor.rmi.DistribucionPaquetesRMI;


public class Servidor extends Thread {
	 InterfazRemotaDistribucionPaquetes objetoRemoto;
     
     //Constructor del servidor
     public Servidor() {
    	 iniciar();
     }
     
     //Main del servidor
     public static void main(String[] args)
     {
             new Servidor();
     }
     
      public void iniciar() {
             try {
                 LocateRegistry.createRegistry(1099);    
                 objetoRemoto = new DistribucionPaquetesRMI();
                 System.setProperty("java.rmi.server.hostname","192.168.1.105");
                 //Vincula el objeto con un nombre en el registry
                 Naming.rebind (InterfazRemotaDistribucionPaquetes.url, objetoRemoto);
                 System.out.println("Servidor inicializado correctamente...");
                 System.out.println(InterfazRemotaDistribucionPaquetes.url);
                 System.out.println("Puerto 1099");
                     } catch (Exception e) {
                             e.printStackTrace();
                     }
      }
}