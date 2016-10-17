package com.ADG04.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.rmi.DistribucionPaquetesRMI;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;

public class EncomiendasTest {

	public static void TestCrearEncomiendaYAsignaleElEnvio() throws IOException{

		String ok = getStringFromConsole("Agregar encomiendas (si/no)?");
		while(ok.equals("si")){
			AltaEncomiendaParticular();
			ok = getStringFromConsole("Agregar otra encomienda (si/no)?");
			
			while(ok.equals("si")){
				AltaEncomiendaParticular();
				ok = getStringFromConsole("Agregar otra encomienda (si/no)?");
			}
		}
		
		System.out.println("----------------------------------------------");
		ok = getStringFromConsole("Buscar encomiendas pendientes, que no hayan sido asignadas a ningún envío (si/no)?");
		
		if(ok.equals("si")){
			int idSucursal = getIntFromConsole("Buscar encomiendas pendientes (que no hayan sido asignadas a ningún envío). Ingrese id sucursal:  ");
		
			//busco encomiendas pendientes y las asigno a envios
	
	    	List<Encomienda> es = EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
	    	for(Encomienda e:es){
	    		System.out.println(e.getIdEncomienda());
	    	}
		}
    	
		ok = getStringFromConsole("Asignar envíos a encomiendas? (si/no)?");
		while(ok.equals("si")){
    		int idSucursal = getIntFromConsole("Ingrese Id sucursal donde está la encomienda: ");
			int idEncomienda = getIntFromConsole("Ingrese Id encomienda para asignar envio: ");
    		asignarEnvios(idSucursal, idEncomienda);
    		ok = getStringFromConsole("Asignar envío a otra encomienda (si/no)?");
    	}
				
		ok = getStringFromConsole("Listar envios? (si/no)?");
		if(ok.equals("si")){

			List<Envio> envios = EnvioDao.getInstancia().getAll();
			for(Envio e:envios){
				System.out.println(e.toString());
			}
		}
		/*
		ok = getStringFromConsole("Actualizar estado de envios? (si/no)?");
		if(ok.equals("si")){

			int idEnvio = getIntFromConsole("Id Envio");
			int idCoordenada = getIntFromConsole("Id coordenada: ");
			GestionControlViajes.getInstancia()
		}**/
		
		ok = getStringFromConsole("Actualizar ruta de envio? (si/no)?");
		while(ok.equals("si")){
		
			int idEnvio = getIntFromConsole("Id Envio");
			int idCoordenada = getIntFromConsole("Id coordenada: ");
			GestionControlViajes.getInstancia().actualizarEstadoVehiculo(idEnvio, CoordenadaDao.getInstancia().getById(idCoordenada));
			
			Envio envio = EnvioDao.getInstancia().getById(idEnvio);
			System.out.println(envio.toString());
			
			ok = getStringFromConsole("Actualizar ruta de otro envio? (si/no)?");
		}
		
		ok = getStringFromConsole("Revisar estado de envios? (si/no)?");
		while(ok.equals("si")){
		
			int idEnvio = getIntFromConsole("Id Envio");
			//int idCoordenada = getIntFromConsole("Id coordenada: ");
			GestionControlViajes.getInstancia().estaEnvioDemorado(idEnvio);
			
			Envio envio = EnvioDao.getInstancia().getById(idEnvio);
			System.out.println(envio.toString());
			
			ok = getStringFromConsole("Revisar estado de otro envio? (si/no)?");
		}
		
		/*ok = getStringFromConsole("Revisar estado de envios? (si/no)?");
		while(ok.equals("si")){
		
			int idEnvio = getIntFromConsole("Id Envio");
			//int idCoordenada = getIntFromConsole("Id coordenada: ");
			GestionEncomienda.getInstancia().cambiarEstadoEnvio(idEnvio, estado);
			
			Envio envio = EnvioDao.getInstancia().getById(idEnvio);
			System.out.println(envio.toString());
			
			ok = getStringFromConsole("Revisar estado de otro envio? (si/no)?");
		}*/
		
		
    	System.out.println("----------------------------------------------");
		//ponerEnViajeEncomiendasPorVencer();
		//Armar los envios
		/*
		testControlViajes();
		
		System.out.println("Para finalizar escriba Exit, si no escriba Continuar.");
		
		while(getStringFromConsole("") != "Continuar"){
			
			AltaEncomiendaParticular();
			testControlViajes();
		}*/
		
		return;
		
	}
	

	private static void asignarEnvios(int idSucursal, int idEncomienda) throws RemoteException {

		DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
		
		System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
		Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
		if(idenvio == null){
			System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
		}
		else
		{
			System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
			System.out.println("Info del envío: ");
			DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
			System.out.println("Id envio: "+envio.getId());
			System.out.println("Fecha y  hora de llegada: "+ envio.getFechaYHoraLlegada());
			System.out.println("Vehiculo: "+envio.getIdVehiculo());
			System.out.println("Estado envío: "+envio.getEstado());
			
			System.out.println(envio.toString());
		}
		
		
	}

	private static String getStringFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		String line = buffer.readLine();
		return line;
	}
	
	private static float getFloatFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		float line = Float.parseFloat(buffer.readLine());
		return line;
	}
	
	private static int getIntFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(buffer.readLine());
		return line;
	}
	
	private static void ponerEnViajeEncomiendasPorVencer(){
		
		GestionEncomienda.getInstancia().ponerEnViajeEncomiendasPorVencer();
				
	}
	
	private static void asignarEnvios() throws IOException{

		
		DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
		
		int idEncomienda = getIntFromConsole("Id encomienda: ");
		
		System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
		Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
		if(idenvio == null){
			System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
		}
		else
		{
			System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
			System.out.println("Info del envío: ");
			DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
			System.out.println("Id envio: "+envio.getId());
			System.out.println("Fecha y  hora de llegada: "+ envio.getFechaYHoraLlegada());
			System.out.println("Vehiculo: "+envio.getIdVehiculo());
			System.out.println("Estado envío: "+envio.getEstado());
			
			System.out.println(envio.toString());
		}
		
		System.out.println();
				
		System.out.print("Test finished...");

	}
	
	private static void AltaEncomiendaParticular() throws IOException {

			String dniCliente = getStringFromConsole("dni cliente particular: ");
			
			int idSucOrigen = getIntFromConsole("Sucursal origen: ");
			int idSucDestino = getIntFromConsole("Sucursal destino: ");
			float largo = getFloatFromConsole("Largo: ");
			float ancho = getFloatFromConsole("Ancho: ");
			float alto = getFloatFromConsole("Alto: ");
			float peso = getFloatFromConsole("Peso: ");
			float volumen = getFloatFromConsole("Volumen: ");
			
			//(1,2,1,100,100f,430f,100f,0f,0);

			DistribucionPaquetesRMI bDelegate = new DistribucionPaquetesRMI();
			System.out.println("Nueva encomienda particular");
			int idEncomienda = bDelegate.nuevaEncomiedaParticular(dniCliente, 1, 2, idSucOrigen, idSucDestino, largo, ancho, alto, peso, volumen, 
					"", false, (short) 0, false, "", "", "", "", "", "", 0f, "");
				
		
	}
	
	
	private static void testMarcarEnvio(){
		
	}
}
