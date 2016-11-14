package com.ADG04.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.ADG04.Negocio._GestionVehiculo;
import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.Servidor.dao.TareaMantenimientoDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class VehiculosTest {

	public static void TestVehiculos() throws Exception{
		
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
			VehiculoE vehiculo = VehiculoDao.getInstancia().getById(idVehiculo);
			List<TareaMantenimientoE> tareasVencidas= new _GestionVehiculo(vehiculo).getTareasVencidas();
			if(tareasVencidas == null || tareasVencidas.isEmpty()) { System.out.println("No hay tareas vencidas."); }
			ok = getStringFromConsole("Buscar tareas vencidas de otro vehículo (si/no)?");
		}
		
		ok = getStringFromConsole("Agregar Tareas realizadas (si/no)?");
		if(ok.equals("si")){
			
			System.out.println("Lista de vehículos:");
			List<VehiculoE> vhs = VehiculoDao.getInstancia().getAll();
			for(VehiculoE veh:vhs){
				System.out.println(veh.getIdVehiculo());	
			}
			
			
			int idVehiculo = getIntFromConsole("Ingrese id vehiculo");
			TestGetPlanes(idVehiculo);
			int idTareaARealizar = getIntFromConsole("Ingrese id tarea");
			
			String esPorTiempo = getStringFromConsole("Es tarea por tiempo (si/no)?");
			if(esPorTiempo.equals("si")){
				String date = getStringFromConsole("Ingrese fecha de realización: ('aaaa/mm/dd')");
				TestRealizarTareaPorTiempo(idVehiculo, 1, idTareaARealizar, new Date(date));
			}else{
				TestRealizarTareaPorKm(idVehiculo, 1, idTareaARealizar);	
			}
		}
		
		/*
		List<Vehiculo> vhs = VehiculoDao.getInstancia().getAll();
		for(Vehiculo veh:vhs){
			TestGetPlanes(veh.getIdVehiculo());	
		}
		*/
	}

	private static void TestTareasVencidas(int idVehiculo){
    	
		List<TareaMantenimientoE> tareas = new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).getTareasVencidas(); 
		System.out.println("\n----------------Tareas que deben realizarse:-----------------------------");		    	
    	for(TareaMantenimientoE t :tareas){
    		System.out.println(t.getTarea());
    	}
    	System.out.println("---------------------------------------------------\n");
    }
    

	public static int generarVehiculoTest(String marca, String modelo, String anio, String patente) throws RemoteException, MalformedURLException, NotBoundException{
		
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
		
		BusinessDelegate bd = new BusinessDelegate();
		return bd.altaVehiculo(v);
		//le paso el DTO vehiculo
		//return new GestionVehiculo().altaVehiculo(v);
		
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
    
    
    private static void TestGetPlanes(int idVehiculo) throws Exception {
   	
    	System.out.println("---------------------------Planes de mantenimiento - Vehiculo: " + idVehiculo + "---------------------");
    	
    	DTO_PlanMantenimiento planDTO = new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).getPlan();
    	System.out.println(planDTO.getDescripcion());
    	System.out.println("------------------------------------------------------------");
    	System.out.println("Plan de mantenimiento del vehiculo " + idVehiculo);
    	System.out.print(planDTO.getDescripcion() + "-" + planDTO.getId() );
 	
    	System.out.println("------------------Tareas por KMs:-------------------------------");
    	for(DTO_TareasPorKilometro t:planDTO.getTareasPorKM()){
    		System.out.println(t.getTarea() + "-" + t.getCantidadKilometros()+ "-" + t.getId());
    	}
    	
    	System.out.println("------------Tareas por Tiempo---------------:");
    	for(DTO_TareasPorTiempo t:planDTO.getTareasPorTiempo()){
    		System.out.println(t.getTarea() + "-" + t.getCantidadDias()+ "-" + t.getId());
    	}
    	
    	System.out.println("------------------------------------------------------------");
	}
    /**
     * Alta de 1 plan de mantenimiento, con una tarea de km y una por tiempo.
     * @throws Exception 
     */
    private static int TestAddPlanMantenimiento(String descPlan, int idVehiculo) throws Exception {
		
    	DTO_PlanMantenimiento pm = new DTO_PlanMantenimiento();
    	pm.setComentarios("Comentarios: " + descPlan);
    	pm.setDescripcion(descPlan);
    	pm.setTolerancia(123);
    	
    	int idPm = new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).altaPlanMantenimiento(pm.getDescripcion(), pm.getComentarios());
    	System.out.println("Plan nro " + idPm + " creado.");
    	return idPm;
	}
    
    private static void TestAddTareasToPlan(String tareaKm, float kms, String tareaTiempo, int dias, int idPlanMantenimiento, int idVehiculo) throws Exception{

    	DTO_TareasPorKilometro tareaXKM = new DTO_TareasPorKilometro();
    	tareaXKM.setCantidadKilometros(kms);
    	tareaXKM.setIdPlanMantenimiento(idPlanMantenimiento);
    	tareaXKM.setTarea(tareaKm);
    	
    	_GestionVehiculo gestion = new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo));
    	gestion.altaTareaMantenimientoPorKm(tareaXKM.getTarea(), tareaXKM.getCantidadKilometros());
    	
    	DTO_TareasPorTiempo tareaXTiempo = new DTO_TareasPorTiempo();
    	tareaXTiempo.setCantidadDias(dias);
    	tareaXTiempo.setIdPlanMantenimiento(idPlanMantenimiento);
    	tareaXTiempo.setTarea(tareaTiempo);
    	gestion.altaTareaMantenimientoPorTiempo(tareaXTiempo.getTarea(), tareaXTiempo.getCantidadDias());
    }

    private static void TestRealizarTareaPorKm(int idVehiculo, int idProveedor, int idTarea) throws Exception{
    	
    	DTO_TareaMantenimientoRealizada tRealizada = new DTO_TareaMantenimientoRealizada();
    	tRealizada.setFecha(new Date());
    	tRealizada.setIdProveedor(idProveedor);
    	tRealizada.setIdVehiculo(idVehiculo);
    	tRealizada.setIdTareaMantenimiento(idTarea);
    	new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).realizarTareaMantenimiento(tRealizada);
    }
    
    private static void TestRealizarTareaPorTiempo(int idVehiculo, int idProveedor, int idTarea, Date fechaRealizada) throws Exception{

    	DTO_TareaMantenimientoRealizada tRealizada = new DTO_TareaMantenimientoRealizada();
    	tRealizada.setFecha(fechaRealizada);
    	tRealizada.setIdProveedor(idProveedor);
    	tRealizada.setIdVehiculo(idVehiculo);
    	tRealizada.setIdTareaMantenimiento(idTarea);
    	new _GestionVehiculo(VehiculoDao.getInstancia().getById(idVehiculo)).realizarTareaMantenimiento(tRealizada);
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
	
}
