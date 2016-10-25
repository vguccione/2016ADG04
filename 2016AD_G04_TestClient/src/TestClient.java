import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class TestClient {

	public static void main(String[] args) throws Exception {
		
/*		AltaEncomiendaParticular();
		System.out.println("Para finalizar escriba Exit, si no escriba Continuar.");
		
		while(getStringFromConsole("") != "Continuar"){
			
			AltaEncomiendaParticular();
		}
	*/	
		//AltaEncomiendaParticular();
		//TestBusinesDelegate();
		//TestVehiculo();
		
		String ok = getStringFromConsole("Agregar Plan de Mantenimiento (si/no)?");
		if(ok.equals("si")){
			TestCrearPlanesYTareasYVehiculos();	
			ok = getStringFromConsole("Agregar otro Plan de Mantenimiento (si/no)?");
			
			while(ok.equals("si")){
				TestCrearPlanesYTareasYVehiculos();
				ok = getStringFromConsole("Agregar otro Plan de Mantenimiento (si/no)?");
			}
		}
		BusinessDelegate bDelegate = new BusinessDelegate();
		ok = getStringFromConsole("Buscar tareas vencidas (si/no)?");
		while(ok.equals("si")){
			
			int idVehiculo = getIntFromConsole("Id Vehiculo: ");
			List<DTO_TareaMantenimiento> tareasVencidas= bDelegate.getTareasVencidas(idVehiculo);
			if(tareasVencidas == null || tareasVencidas.isEmpty()) { System.out.println("No hay tareas vencidas."); }
			
			for(DTO_TareaMantenimiento t:tareasVencidas){
				System.out.println("La tarea : " + t.getTarea() + " ("+t.getId()+") está vencida.");
			}
			
			ok = getStringFromConsole("Buscar tareas vencidas de otro vehículo (si/no)?");
		}
		

	}

	
	public static void TestVehiculos() throws Exception{
		
		BusinessDelegate bd = new BusinessDelegate();
		
		String ok = getStringFromConsole("Agregar Plan de Mantenimiento (si/no)?");
		if(ok.equals("si")){
			TestCrearPlanesYTareasYVehiculos();	
			ok = getStringFromConsole("Agregar otro Plan de Mantenimiento (si/no)?");
			
			while(ok.equals("si")){
				TestCrearPlanesYTareasYVehiculos();
				ok = getStringFromConsole("Agregar otro Plan de Mantenimiento (si/no)?");
			}
		}
		
		ok = getStringFromConsole("Buscar tareas vencidas (si/no)?");
		while(ok.equals("si")){
			
			int idVehiculo = getIntFromConsole("Id Vehiculo: ");
			List<DTO_TareaMantenimiento> tareasVencidas = bd.getTareasVencidas(idVehiculo);
			if(tareasVencidas == null || tareasVencidas.isEmpty()) { System.out.println("No hay tareas vencidas."); }
			else{
				
				for(DTO_TareaMantenimiento t:tareasVencidas){
					System.out.println("La tarea : " + t.getTarea() + " ("+t.getId()+") está vencida.");
				}
			
			}
			ok = getStringFromConsole("Buscar tareas vencidas de otro vehículo (si/no)?");
		}
		/*
		List<Vehiculo> vhs = VehiculoDao.getInstancia().getAll();
		for(Vehiculo veh:vhs){
			TestGetPlanes(veh.getIdVehiculo());	
		}
		*/
	}

	 private static void TestCrearPlanesYTareasYVehiculos() throws Exception{
	    	
	    	String ok = getStringFromConsole("Agregar vehículo(si/no)?");
	    	
	    	if(ok.equals("si")){
		    	//System.out.println("Agregar vehículo con este plan");
		    	String marca = getStringFromConsole("Marca: ");
		    	String modelo = getStringFromConsole("Modelo: ");
		    	String anio = getStringFromConsole("Anio: ");
		    	String patente = getStringFromConsole("Patente: ");
		    	int idVeh1 = generarVehiculoTest(marca, modelo, anio, patente);   	
		    	System.out.println("Vehiculo generado: " + idVeh1);
		    	System.out.println("Agregar plan");
		    	
		    	String plan = getStringFromConsole("Plan descripcion: ");
		    	String tareaKm = getStringFromConsole("Tarea por Km: ");
		    	int frecKm = getIntFromConsole("Frecuencia tarea por Km: ");
		    	String tareaTiempo = getStringFromConsole("Tarea por Tiempo: ");
		    	int frecTiempo = getIntFromConsole("Frecuencia tarea por Tiempo: ");
		    	
		    	int idPm1 = TestAddPlanMantenimiento(plan, idVeh1);
		    	TestAddTareasToPlan(tareaTiempo, frecKm, tareaTiempo, frecTiempo,idPm1, idVeh1);
		    	System.out.println("Plan generado. Id plan: " + idPm1);
		    	
	    	}
	    	
	    	
	    }
	    

	
	/*
    private static void TestCrearPlanesYTareasYVehiculos() throws IOException, NotBoundException{

    	BusinessDelegate bDelegate = new BusinessDelegate();
    	
    	String plan = getStringFromConsole("Plan descripcion: ");
    	String tareaKm = getStringFromConsole("Tarea por Km: ");
    	int frecKm = getIntFromConsole("Frecuencia tarea por Km: ");
    	String tareaTiempo = getStringFromConsole("Tarea por Tiempo: ");
    	int frecTiempo = getIntFromConsole("Frecuencia tarea por Tiempo: ");
    	
    	int idPm1 = TestAddPlanMantenimiento(plan);
    	TestAddTareasToPlan(tareaTiempo, frecKm, tareaTiempo, frecTiempo,idPm1);
    	System.out.println("Plan generado. Id plan: " + idPm1);
    	
    	String ok = getStringFromConsole("Agregar vehículo con este plan(si/no)?");
    	
    	if(ok.equals("si")){
	    	System.out.println("Agregar vehículo con este plan");
	    	String marca = getStringFromConsole("Marca: ");
	    	String modelo = getStringFromConsole("Modelo: ");
	    	String anio = getStringFromConsole("Anio: ");
	    	String patente = getStringFromConsole("Patente: ");
	    	int idVeh1 = generarVehiculoTest(marca, modelo, anio, patente,idPm1);   	
	    	System.out.println("Vehiculo generado: " + idVeh1);
	    	ok = getStringFromConsole("Agregar otro vehículo (si/no)?");
	    	
	    	while(ok.equals("si")){
	    	
	    		System.out.println("Agregar vehículo con este plan");
	        	marca = getStringFromConsole("Marca: ");
	        	modelo = getStringFromConsole("Modelo: ");
	        	anio = getStringFromConsole("Anio: ");
	        	patente = getStringFromConsole("Patente: ");
	        	idVeh1 = generarVehiculoTest(marca, modelo, anio, patente,idPm1);   	
	        	System.out.println("Vehiculo generado: " + idVeh1);
	        	ok = getStringFromConsole("Agregar otro vehículo (si/no)?");
	    	}
    	}
    }
*/
    private static int TestAddPlanMantenimiento(String descPlan, int idVehiculo) throws Exception {
	
    	BusinessDelegate bDelegate = new BusinessDelegate();
    	
    	DTO_PlanMantenimiento pm = new DTO_PlanMantenimiento();
    	pm.setComentarios("Comentarios: " + descPlan);
    	pm.setDescripcion(descPlan);
    	pm.setTolerancia(123);
    	
    	Integer idPm = bDelegate.altaPlanMantenimiento(pm, idVehiculo);
    	System.out.println("Plan nro " + idPm + " creado.");
    	return idPm;
	}
    
    private static void TestAddTareasToPlan(String tareaKm, float kms, String tareaTiempo, int dias, int idPlanMantenimiento, Integer idVehiculo) throws Exception{

    	BusinessDelegate bDelegate = new BusinessDelegate();
    	DTO_TareasPorKilometro tareaXKM = new DTO_TareasPorKilometro();
    	tareaXKM.setCantidadKilometros(kms);
    	tareaXKM.setIdPlanMantenimiento(idPlanMantenimiento);
    	tareaXKM.setTarea(tareaKm);
    	
    	bDelegate.altaTareaMantenimiento(tareaXKM, idVehiculo);
    	
    	DTO_TareasPorTiempo tareaXTiempo = new DTO_TareasPorTiempo();
    	tareaXTiempo.setCantidadDias(dias);
    	tareaXTiempo.setIdPlanMantenimiento(idPlanMantenimiento);
    	tareaXTiempo.setTarea(tareaTiempo);
    	
    	Integer idTarea = bDelegate.altaTareaMantenimiento(tareaXTiempo, idVehiculo);
    }


	
	private static void TestVehiculo() throws IOException, NotBoundException{
		System.out.println("Agregar vehículo con este plan");
		String marca = getStringFromConsole("Marca: ");
		String modelo = getStringFromConsole("Modelo: ");
		String anio = getStringFromConsole("Anio: ");
		String patente = getStringFromConsole("Patente: ");
		int idVeh1 = generarVehiculoTest(marca, modelo, anio, patente);   	
		System.out.println("Vehiculo generado: " + idVeh1);
		String ok = getStringFromConsole("Agregar otro vehículo (si/no)?");
		
		while(ok.equals("si")){
		
			System.out.println("Agregar vehículo con este plan");
	    	marca = getStringFromConsole("Marca: ");
	    	modelo = getStringFromConsole("Modelo: ");
	    	anio = getStringFromConsole("Anio: ");
	    	patente = getStringFromConsole("Patente: ");
	    	idVeh1 = generarVehiculoTest(marca, modelo, anio, patente);   	
	    	System.out.println("Vehiculo generado: " + idVeh1);
	    	ok = getStringFromConsole("Agregar otro vehículo (si/no)?");
		}
	}
	

	public static int generarVehiculoTest(String marca, String modelo, String anio, String patente) throws MalformedURLException, RemoteException, NotBoundException{
		
		//buscar el plan
			
		//Creo vehiculo
		DTO_Vehiculo v = new DTO_Vehiculo();
		v.setAlto(100f);
		v.setAncho(100f);
		v.setAnio(anio);
		v.setEstado(null);
		v.setKmsRecorridos(13400);
		v.setLargo(1000f);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setPatente(patente);
		v.setPeso(560f);
		v.setTara(20);	
		v.setRefrigerado(false);
		v.setVolumen(3333f);
		Date date = new Date();
		date.setYear(2016);
		date.setMonth(01);
		date.setDate(1);
		v.setFechaIngreso(new Date("01/01/2016"));
		
		DTO_Sucursal su  = new DTO_Sucursal();
		su.setId(1);
		v.setSucursal(su);
		
		BusinessDelegate bDelegate = new BusinessDelegate();
		return bDelegate.altaVehiculo(v);
		
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
	
	private static void AltaEncomiendaParticular() throws IOException{

		System.out.println("------------Test AltaEncomiendaParticular --------------------------");
		
		try {
			
			System.out.print("Dni Cliente: ");
			BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
			String dniCliente = buffer.readLine();
			
			System.out.print("Sucursal de origen: ");
			buffer=new BufferedReader(new InputStreamReader(System.in));
			int idSucOrigen = Integer.parseInt(buffer.readLine());
			
			System.out.print("Sucursal de destino: ");
			buffer=new BufferedReader(new InputStreamReader(System.in));
			int idSucDestino = Integer.parseInt(buffer.readLine());
					
			float largo = getFloatFromConsole("Largo: ");
			float ancho = getFloatFromConsole("Ancho: ");
			float alto = getFloatFromConsole("Alto: ");
			float peso = getFloatFromConsole("Peso: ");
			float volumen = getFloatFromConsole("Volumen: ");
			
			//(1,2,1,100,100f,430f,100f,0f,0);

			BusinessDelegate bDelegate = new BusinessDelegate();
			System.out.println("Nueva encomienda particular");
			int idEncomienda = bDelegate.nuevaEncomiedaParticular(dniCliente, 1, 2, idSucOrigen, idSucDestino, largo, ancho, alto, peso, volumen, 
					"", false, (short) 0, false, "", "", "", "", "", "", 0f, "");
			
			System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
			Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
			if(idenvio != null){
				System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
			}
			else
			{
				System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
				System.out.println("Info del envío: ");
				DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
				System.out.println("Vehiculo: "+envio.getIdVehiculo());
				System.out.println("Estado envío: "+envio.getEstado());
				
				System.out.println(envio.toString());
			}
			//System.out.println("Encomienda con 70% del peso del vehiculo 1 que esta disponible");
			/*System.out.println("Peso del Vehiculo: " + (envio.get().getPeso() - envio.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc.getEstado());
			System.out.println(envio.toString());
			System.out.println("------------------------------------");
			System.out.println();*/
			
			System.out.println();
					
			System.out.print("Test finished...");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------Fin Test AltaEncomiendaParticular --------------------------");
	}
	
	public static void TestBusinesDelegate(){
		
		try {
			
			BusinessDelegate bDelegate = new BusinessDelegate();
			
			System.out.println("Test get Cliente:");
			DTO_ClienteParticular cliente;
			
			cliente = bDelegate.getClienteParticularByDni("1234578");
			System.out.println(cliente.getDni());
			System.out.println(cliente.getNombre());
			System.out.println(cliente.getApellido());
			System.out.print("Test finished...");
			
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println();
			
			System.out.println("Test get Usuario:");
			DTO_Usuario usuario;
			
			usuario = bDelegate.getUsuario("32437264");
			System.out.println(usuario.getDni());
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getApellido());
			System.out.print("Test finished...");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
