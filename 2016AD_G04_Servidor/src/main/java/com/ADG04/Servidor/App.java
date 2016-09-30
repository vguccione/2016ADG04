package com.ADG04.Servidor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ADG04.Negocio.GestionAdministracion;
import com.ADG04.Negocio.GestionCliente;
import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Negocio.GestionVehiculo;
import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.Provincia;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//TestPlanMantenimiento();
    	crearPaisesYProvincias();
    	testControlViajes();
//    	TestEncomienda();
    	//TestFacturaEncomiendaParticular();
    	//TestAltaCliente();
    	//TestSucursal("Sucursal Origen");
    	//TestSucursal("Sucursal Destino");
    	
 //   	TestPaisDao();
    //	TestUsuario();
    }
    
    private static void crearPaisesYProvincias(){
    	DTO_Pais pais = new DTO_Pais();
    	pais.setDescripcion("Argentina");
    	GestionAdministracion.getInstancia().altaPais(pais);
    	
    	DTO_Provincia prov = new DTO_Provincia();
    	prov.setDescripcion("Mendoza");
    	prov.setPais(PaisDao.getInstancia().getById(1).toDTO());
    	GestionAdministracion.getInstancia().altaProvincia(prov);
    	
    	prov.setDescripcion("Cordoba");
    	prov.setPais(PaisDao.getInstancia().getById(1).toDTO());
    	GestionAdministracion.getInstancia().altaProvincia(prov);
    	
    	pais.setDescripcion("Peru");
    	GestionAdministracion.getInstancia().altaPais(pais);
    }
    
    private static void TestPlanMantenimiento() {
		
    	DTO_PlanMantenimiento pm = new DTO_PlanMantenimiento();
    	pm.setComentarios("Mi primer plan");
    	pm.setDescripcion("Plan Toyota");
    	pm.setTolerancia(123);
    	
    	int idPm = GestionVehiculo.getInstancia().altaPlanMantenimiento(pm);
    	DTO_TareasPorKilometro tareaXKM = new DTO_TareasPorKilometro();
    	tareaXKM.setCantidadKilometros(123);
    	tareaXKM.setIdPlanMantenimiento(idPm);
    	tareaXKM.setTarea("Cambiar ruedas");
    	GestionVehiculo.getInstancia().altaTareaMantenimiento(tareaXKM);
    	
    	DTO_TareasPorTiempo tareaXTiempo = new DTO_TareasPorTiempo();
    	tareaXTiempo.setCantidadDias(656);
    	tareaXTiempo.setIdPlanMantenimiento(idPm);
    	tareaXTiempo.setTarea("Cambiar aceite");
    	int idTarea = GestionVehiculo.getInstancia().altaTareaMantenimiento(tareaXTiempo);
    	
    	DTO_TareaMantenimientoRealizada tRealizada = new DTO_TareaMantenimientoRealizada();
    	tRealizada.setFecha(new Date());
    	tRealizada.setIdProveedor(2);
    	tRealizada.setIdVehiculo(1);
    	tRealizada.setIdTareaMantenimiento(idTarea);
    	GestionVehiculo.getInstancia().realizarTareaMantenimiento(tRealizada);
	}

	private static void TestAltaCliente() {  	
    	DTO_Direccion dir = new DTO_Direccion();
    	
    	Pais pais = (Pais) PaisDao.getInstancia().getById(1);
    	Provincia prov = (Provincia) ProvinciaDao.getInstancia().getById(1);
    	
    	dir.setCalle("Una calle");
    	dir.setCodigoPostal(1234);
    	dir.setLocalidad("Capital Federal");
    	dir.setNro(123);
    	dir.setPais(pais.toDTO());
    	dir.setProvincia(prov.toDTO());
    	
    	DTO_ClienteParticular cliParticular = new DTO_ClienteParticular();
    	
    	cliParticular.setApellido("Guccione");
    	cliParticular.setDni("32437264");
		cliParticular.setEmail("vguccione@gmail.com");
		cliParticular.setEstado(true);
		cliParticular.setNombre("Vanesa");
		cliParticular.setTelefono("1556932544");
		cliParticular.setDireccion(dir);
		
		GestionCliente.getInstancia().altaClienteParticular(cliParticular);
    }

	public static void TestUsuario(){
    	DTO_Usuario usuario = new DTO_Usuario();
    	usuario.setApellido("Pepe");
    	usuario.setDni("212328");
    	usuario.setFechaCreacion(new Date());
    	usuario.setNombre("pepepe");
    	usuario.setPassword("xxxxxx");
    	usuario.setUltimoAcceso(new Date());
    	usuario.setIdSucursal(1);
    	usuario.setIdRolUsuario(1);
    	
    	GestionAdministracion.getInstancia().altaUsuario(usuario);
    }
    
	public static void TestSucursal(String descripcion){
		
		DTO_Direccion dir = new DTO_Direccion();
    	DTO_Sucursal sucursal = new DTO_Sucursal();
    	Pais pais = (Pais) PaisDao.getInstancia().getById(1);
    	Provincia prov = (Provincia) ProvinciaDao.getInstancia().getById(1);
    	
    	dir.setCalle("peperulo calle");
    	dir.setCodigoPostal(1234);
    	dir.setLocalidad("Capital Federal");
    	dir.setNro(123);
    	dir.setPais(pais.toDTO());
    	dir.setProvincia(prov.toDTO());
    	
    	sucursal.setDescripcion(descripcion);
    	sucursal.setTelefono("123456");
    	sucursal.setDireccion(dir);
    	    	
    	GestionAdministracion.getInstancia().altaSucursal(sucursal);
    }
		
	public static void TestFacturaEncomiendaParticular(){
		
		System.out.println("---------------TestFacturaEncomiendaParticular--------------------");
		
		GestionEncomienda.getInstancia().facturarEncomiendaParticular(1);

		System.out.println("Id de Factura generada:");
		int idFactura = GestionEncomienda.getInstancia().getFacturaParticularByIdEncomienda(1);
		System.out.println(idFactura);
		
		System.out.println("-------------------------------------------------------------------");
	}
	
	public static void TestEncomienda(){
		
		double nro = 123;
		DTO_ClienteParticular cli = new DTO_ClienteParticular();
		cli.setId(1);
    	DTO_Sucursal sucursalOrigen = new DTO_Sucursal();
    	DTO_Sucursal sucursalDestino = new DTO_Sucursal();
    	sucursalOrigen.setId(5);
    	sucursalDestino.setId(6);
    	
    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();

		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(sucursalOrigen);
		encomienda.setSucursalDestino(sucursalDestino);
		encomienda.setLargo(nro);
		encomienda.setAncho(nro);
		
		encomienda.setAlto(12.0);
		encomienda.setPeso(34.6);
		encomienda.setVolumen(44.5);
		//encomienda.setTratamiento("nada"); 
		encomienda.setApilable(true);
		encomienda.setCantApilable((short)2); 
		encomienda.setRefrigerado(false);
		//encomienda.setCondicionTransporte(condiciionTransporte); 
		//encomienda.setIndicacionesManipulacion(indicacionesManipulacion);
		//encomienda.setFragilidad(fragilidad); 
		encomienda.setNombreReceptor("Alfredo"); 
		encomienda.setApellidoReceptor("Receptor");
		encomienda.setDniReceptor("99876543"); 
		//encomienda.setVolumenGranel(volumenGranel); 
		//encomienda.setUnidadGranel(unidadGranel);
		//encomienda.setCargaGranel(cargaGranel);		
		   	    	    	
    	GestionEncomienda.getInstancia().altaEncomiendaParticular(encomienda);
    }
    
	
	public static void testControlViajes(){	
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Creo vehiculo
		tx.begin();
		Vehiculo v = new Vehiculo();
		v.setAlto(100d);
		v.setAncho(100d);
		v.setAnio("2016");
		v.setEstado("");
		v.setKmRecorridos(1000);
		v.setLargo(1000d);
		v.setMarca("Ford");
		v.setModelo("Ka");
		v.setPatente("ADJ000");
		v.setPeso(560d);
		v.setTara(20);	
		v.setRefrigerado(false);
		
		VehiculoDao.getInstancia().persist(v);	
		tx.commit();
		
		//Creo sucursal origen
		tx.begin();
		
		Direccion dirOrigen = new Direccion();
		dirOrigen.setCalle("Calle a");
		dirOrigen.setCodigoPostal(123);
		dirOrigen.setLocalidad("localidad");
		dirOrigen.setNro(123);
		dirOrigen.setPais(PaisDao.getInstancia().getById(1));
		dirOrigen.setProvincia(ProvinciaDao.getInstancia().getById(1));
		
		Sucursal so = new Sucursal();
		so.setDescripcion("A");
		so.setTelefono("767676767");
		so.setDireccion(dirOrigen);
		
		SucursalDao.getInstancia().persist(so);
		tx.commit();	
		
		//Creo Sucursal destino
		tx.begin();

		Direccion dirDestino = new Direccion();
		dirDestino.setCalle("Calle bbb");
		dirDestino.setCodigoPostal(123);
		dirDestino.setLocalidad("localidad");
		dirDestino.setNro(123);
		dirDestino.setPais(PaisDao.getInstancia().getById(1));
		dirDestino.setProvincia(ProvinciaDao.getInstancia().getById(2));
		
		Sucursal sd = new Sucursal();
		sd.setDescripcion("B");
		sd.setTelefono("34343");
		sd.setDireccion(dirDestino);
		
		SucursalDao.getInstancia().persist(sd);
		tx.commit();	
		
		//Creo lista de coordenadas para asociar a un mapa de rutas
		
		List<Coordenada> listaCoord = new ArrayList<Coordenada>();
		listaCoord.add(new Coordenada("34°35′59″S","58°22′55″O﻿"));
		listaCoord.add(new Coordenada("37°35′59″S","54°22′55″O﻿"));
		listaCoord.add(new Coordenada("14°25′59″S","28°22′55″O﻿"));
		listaCoord.add(new Coordenada("18°25′39″S","29°26′55″O﻿"));
		for(Coordenada c:listaCoord){
			tx.begin();
			Coordenada coord = new Coordenada();
			coord.setLatitud(c.getLatitud());
			coord.setLongitud(c.getLongitud());
			CoordenadaDao.getInstancia().persist(coord);
			tx.commit();
		}
		
		
		//Creo mapa de ruta
		tx.begin();

		MapaDeRuta mp = new MapaDeRuta();
		mp.setCantKm(150f);
		mp.setDuracion(8f);
		mp.setSucursalDestino(SucursalDao.getInstancia().getById(2));
		mp.setSucursalOrigen(SucursalDao.getInstancia().getById(1));
		mp.setCoordenadas(listaCoord);

		MapaDeRutaDao.getInstancia().persist(mp);
		tx.commit();	
		
		//Creo envio
		tx.begin();
		
		Envio e = new Envio();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		try {
			Date date = sdf.parse("2016-09-21T12:08:56.235-0700");
			e.setFechaYHoraLlegadaEstimada(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.setEstado(EnvioEstado.EnViaje.toString());
		e.setFechaYHoraSalida(new Date());
		e.setPropio(true);
		e.setMapaDeRuta(MapaDeRutaDao.getInstancia().getById(1));
		e.setSucursalDestino(SucursalDao.getInstancia().getById(2));
		e.setSucursalOrigen(SucursalDao.getInstancia().getById(1));
		e.setVehiculo(VehiculoDao.getInstancia().getById(1));
		
		Coordenada coordActual = new Coordenada();
		coordActual.setLatitud("34°35′59″S");
		coordActual.setLongitud("58°22′55″O﻿");
		
		e.setPosicionActual(coordActual);
		
		EnvioDao.getInstancia().persist(e);
		
		tx.commit();	
		
		/*Seguira en viaje*/
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(1, CoordenadaDao.getInstancia().getById(1));
		Envio envio = EnvioDao.getInstancia().getById(1);
		System.out.println(envio.getEstado());
		
		/*Se indicara desviado*/
		Coordenada coordAct = new Coordenada();
		coordAct.setLatitud("54°35′59″S");
		coordAct.setLongitud("48°22′55″O﻿");
		
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(1, coordAct);
		Envio envio2 = EnvioDao.getInstancia().getById(1);
		System.out.println(envio2.getEstado());	
		
		/*Se indicara demorado*/
		GestionControlViajes.getInstancia().estaEnvioDemorado(1);
		Envio envio3 = EnvioDao.getInstancia().getById(1);
		System.out.println(envio3.getEstado());	
	}
}
