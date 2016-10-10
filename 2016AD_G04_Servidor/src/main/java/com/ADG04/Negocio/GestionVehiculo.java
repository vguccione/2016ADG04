package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.TareaMantenimientoDao;
import com.ADG04.Servidor.dao.TareaMantenimientoRealizadaDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.CondicionesEspecialesVehiculo;
import com.ADG04.Servidor.model.PlanMantenimiento;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.TareaMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimientoPorKm;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempo;
import com.ADG04.Servidor.model.TareaMantenimientoRealizada;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class GestionVehiculo {

	private static GestionVehiculo instancia;
	
	private EntityManagerFactory factory;
	
	private GestionVehiculo(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionVehiculo getInstancia(){
		if(instancia == null){
			instancia = new GestionVehiculo();
		} 
		return instancia;
	}
	
	public int altaPlanMantenimiento(DTO_PlanMantenimiento planMantenimiento) {
		
		PlanMantenimiento pm = new PlanMantenimiento();
		pm.setDescripcion(planMantenimiento.getDescripcion());
		//pm.setTolerancia(planMantenimiento.getTolerancia());
		pm.setComentarios(planMantenimiento.getComentarios());
	
		PlanMantenimientoDao.getInstancia().persist(pm);
		
		return pm.getIdPlanMantenimiento();
	}

	/*public void modificarPlanMantenimiento(DTO_PlanMantenimiento planMantenimiento) {
		
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(planMantenimiento.getId());
		
		pm.setDescripcion(planMantenimiento.getDescripcion());
		//pm.setTolerancia(planMantenimiento.getTolerancia());
		pm.setComentarios(planMantenimiento.getComentarios());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		for(DTO_TareaMantenimiento tarea:planMantenimiento.getTareasMantenimiento()){
			TareaMantenimiento t = new TareaMantenimiento();
			//t.setCantidadDias(123.0);
			//t.setCantidadKilometros(1233.0);
			t.setPlanMantenimiento(pm);
			t.setTarea("Cambiar las ruedas");
			
			TareaMantenimientoDao.getInstancia().persist(t);
		}
				
		PlanMantenimientoDao.getInstancia().persist(pm);
		
		tx.commit();
	}*/

	public void bajaPlanMantenimiento(Integer idPlanMantenimiento) {
		PlanMantenimientoDao.getInstancia().removeById(idPlanMantenimiento);
	}
	
	public DTO_PlanMantenimiento getPlanMantenimiento(Integer idPlanMantenimiento){
		
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(idPlanMantenimiento);
		
		DTO_PlanMantenimiento pmDTO = new DTO_PlanMantenimiento();
		pmDTO.setComentarios(pm.getComentarios());
		pmDTO.setDescripcion(pm.getDescripcion());
			/*	
		for(TareaMantenimiento tarea:pm.getTareaMantenimientos()){
			DTO_TareaMantenimiento t = new DTO_TareaMantenimiento();
			t.setId(t.getId());
			t.setIdPlanMantenimiento(pm.getIdPlanMantenimiento());
			t.setTarea(t.getTarea());
			t.setTipo(t.getTipo());
		}
		*/
		
		return pmDTO;
	}
	
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tarea) {
		
		PlanMantenimiento p =  PlanMantenimientoDao.getInstancia().getById(tarea.getIdPlanMantenimiento());
		
		TareaMantenimientoPorKm tm = new TareaMantenimientoPorKm();
		tm.setTarea(tarea.getTarea());
		tm.setCantidadKilometros(tarea.getCantidadKilometros());
		tm.setPlanMantenimiento(p);
		
		TareaMantenimientoDao.getInstancia().persist(tm);
	}
	
	public int altaTareaMantenimiento(DTO_TareasPorTiempo tarea) {
		
		PlanMantenimiento p =  PlanMantenimientoDao.getInstancia().getById(tarea.getIdPlanMantenimiento());
		
		TareaMantenimientoPorTiempo tm = new TareaMantenimientoPorTiempo();
		tm.setTarea(tarea.getTarea());
		tm.setCantidadDias(tarea.getCantidadDias());
		tm.setPlanMantenimiento(p);
		
		TareaMantenimientoDao.getInstancia().persist(tm);
		
		return tm.getIdTareaMantenimiento();
	}

	public void realizarTareaMantenimiento(DTO_TareaMantenimientoRealizada tareaMantenimientoRealizada) {
		
		//Verifico que la tarea pertenezca al vehiculo.
		//TODO: Ver que hacemos con estas validaciones. Exception???????
		//if(!this.tareaPerteneceAVehiculo(tareaMantenimientoRealizada.getIdTareaMantenimiento(), tareaMantenimientoRealizada.getIdVehiculo()))
			//return;
			//throw new Exception("La Tarea " + tareaMantenimientoRealizada.getIdTareaMantenimiento() + " no se corresponde con el plan de Mantenimiento del Vehiculo " + tareaMantenimientoRealizada.getIdVehiculo());
		
		TareaMantenimientoRealizada tmr = new TareaMantenimientoRealizada();
		TareaMantenimiento tareaMantenimiento = TareaMantenimientoDao.getInstancia().getById(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		tmr.setTareaMantenimiento(tareaMantenimiento);

		Vehiculo v = VehiculoDao.getInstancia().getById(tareaMantenimientoRealizada.getIdVehiculo());
		tmr.setVehiculo(v);
		
		tmr.setFechaRealizada(tareaMantenimientoRealizada.getFecha());
		tmr.setCantidadKilometros(tareaMantenimientoRealizada.getCantidadKilometros());
		
		int idProveedor = tareaMantenimientoRealizada.getIdProveedor();
		Proveedor p = ProveedorDao.getInstancia().getById(idProveedor);
		tmr.setProveedor(p);
		
		TareaMantenimientoRealizadaDao.getInstancia().persist(tmr);
		
	}

	public DTO_PlanMantenimiento getPlanByVehiculo(int idVehiculo){
		
		PlanMantenimiento plan = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(idVehiculo);
		
		//List<DTO_PlanMantenimiento> planes = new ArrayList<DTO_PlanMantenimiento>();
		//for(PlanMantenimiento plan: planesEntity){
			
			DTO_PlanMantenimiento planDTO = new DTO_PlanMantenimiento();
			planDTO.setComentarios(plan.getComentarios());
			planDTO.setDescripcion(plan.getDescripcion());
			planDTO.setId(plan.getIdPlanMantenimiento());
			
			List<TareaMantenimiento> tareas = plan.getTareaMantenimientos();
			System.out.println("Cantidad de tareas del plan: "+tareas.size());
			for(TareaMantenimiento t:tareas){
				if(t.getClass().equals(TareaMantenimientoPorKm.class)){
					DTO_TareasPorKilometro dtokm = new DTO_TareasPorKilometro();
					TareaMantenimientoPorKm tk = (TareaMantenimientoPorKm)t;
					dtokm.setCantidadKilometros(tk.getCantidadKilometros());
					dtokm.setId(tk.getIdTareaMantenimiento());
					dtokm.setIdPlanMantenimiento(plan.getIdPlanMantenimiento());
					dtokm.setTarea(tk.getTarea());

					planDTO.addTarea(dtokm);
				}
				else{
					DTO_TareasPorTiempo dtokm = new DTO_TareasPorTiempo();
					TareaMantenimientoPorTiempo tk = (TareaMantenimientoPorTiempo)t;
					dtokm.setCantidadDias(tk.getCantidadDias());
					dtokm.setId(tk.getIdTareaMantenimiento());
					dtokm.setIdPlanMantenimiento(plan.getIdPlanMantenimiento());
					dtokm.setTarea(tk.getTarea());
					
					planDTO.addTarea(dtokm);
				}
			}
			
			//planes.add(planDTO);
	//	}
		
		return planDTO;
	}

/*
	public void modificarTareaMantenimientoKilometro(DTO_TareasPorKilometro tarea) {
		PlanMantenimiento p =  VehiculoDao.getInstancia().getPlanMantenimiento(tarea.getIdPlanMantenimiento());
		TareaMantenimientoKilometro tm = new TareaMantenimientoKilometro();
		tm.setId(tarea.getId());
		tm.setTarea(tarea.getTarea());
		tm.setCantidadKilometros(tarea.getCantidadKilometros());
		tm.setPlanMantenimiento(p);
		VehiculoDao.getInstancia().modificarTareaMantenimientoKilometro(tm);
	}

	public void bajaTareaMantenimientoKilometro(Integer idTareaMantenimientoKilometro) {
		TareaMantenimientoKilometro t = VehiculoDao.getInstancia().getTareaMantenimientoKilometro(idTareaMantenimientoKilometro);
		if (t != null)
			VehiculoDao.getInstancia().bajaTareaMantenimientoKilometro(t);
	}
	public DTO_TareasPorKilometro getTareaMantenimientoKilometro(Integer idTareaMantenimientoKilometro){
		return (DTO_TareasPorKilometro) VehiculoDao.getInstancia().getTareaMantenimientoKilometro(idTareaMantenimientoKilometro).toDTO();
	}

	public void modificarTareaMantenimientoTiempo(DTO_TareasPorTiempo tarea) {
		PlanMantenimiento p =  VehiculoDao.getInstancia().getPlanMantenimiento(tarea.getIdPlanMantenimiento());
		TareaMantenimientoTiempo tm = new TareaMantenimientoTiempo();
		tm.setId(tarea.getId());
		tm.setTarea(tarea.getTarea());
		tm.setCantidadDias(tarea.getCantidadDias());
		tm.setPlanMantenimiento(p);
		VehiculoDao.getInstancia().altaTareaMantenimientoTiempo(tm);
	}

	public void bajaTareaMantenimientoTiempo(Integer idTareaMantenimientoTiempo) {
		TareaMantenimientoTiempo t = VehiculoDao.getInstancia().getTareaMantenimientoTiempo(idTareaMantenimientoTiempo);
		if (t != null)
			VehiculoDao.getInstancia().bajaTareaMantenimientoTiempo(t);
	}
	public DTO_TareasPorTiempo getTareaMantenimientoTiempo(Integer idTareaMantenimientoTiempo){
		return (DTO_TareasPorTiempo) VehiculoDao.getInstancia().getTareaMantenimientoTiempo(idTareaMantenimientoTiempo).toDTO();
	}*/
	
		
	public void altaVehiculo(DTO_Vehiculo vehiculo) {
	
		Vehiculo v = new Vehiculo();
		v.setAnio(vehiculo.getAnio());
		v.setPatente(vehiculo.getPatente());
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setKmRecorridos(vehiculo.getKmsRecorridos());
		v.setAncho(vehiculo.getAncho());
		v.setAlto(vehiculo.getAlto());
		v.setLargo(vehiculo.getLargo());
		v.setPeso(vehiculo.getPeso());
		v.setTara(vehiculo.getTara());
		v.setVolumen(vehiculo.getVolumen());
		v.setEstado(vehiculo.getEstado());
		v.setFechaIngreso(vehiculo.getFechaIngreso());
		//v.setco(vehiculo.getCostoKM());
		//v.setFechaIngreso(vehiculo.getFechaIngreso());
		//v.setUltimoMantenimiento(vehiculo.getUltimoMantenimiento());
		//v.setUltimoUso(vehiculo.getUltimoUso());
		//v.setVencimientoGarantia(vehiculo.getVencimientoGarantia());
		
		Sucursal s = SucursalDao.getInstancia().getById(vehiculo.getSucursalActual().getId());
		v.setSucursal(s);
		
		//Sucursal actual???????
		//Entity_Sucursal sa = AdministracionDAO.getInstancia().getSucursal(vehiculo.getIdSucursalActual());
		//v.setSucursal(sa);
			
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(vehiculo.getPlanMantenimiento().getId());
		v.setPlanMantenimiento(pm);
				
		VehiculoDao.getInstancia().persist(v);
	}
/*
	public void modificarVehiculo(DTO_Vehiculo vehiculo) {
		Vehiculo v = new Vehiculo();
		v.setId(vehiculo.getId());
		v.setTipo(vehiculo.getTipo());
		v.setPatente(vehiculo.getPatente());
		v.setMarca(vehiculo.getMarca());
		v.setModelo(vehiculo.getModelo());
		v.setKilometros(vehiculo.getKilometros());
		v.setAncho(vehiculo.getAncho());
		v.setAlto(vehiculo.getAlto());
		v.setLargo(vehiculo.getLargo());
		v.setPeso(vehiculo.getPeso());
		v.setTara(vehiculo.getTara());
		v.setVolumen(vehiculo.getVolumen());
		v.setCostoKM(vehiculo.getCostoKM());
		v.setFechaIngreso(vehiculo.getFechaIngreso());
		v.setUltimoMantenimiento(vehiculo.getUltimoMantenimiento());
		v.setUltimoUso(vehiculo.getUltimoUso());
		v.setVencimientoGarantia(vehiculo.getVencimientoGarantia());
		
		Entity_Sucursal s = AdministracionDAO.getInstancia().getSucursal(vehiculo.getIdSucursal());
		v.setSucursal(s);
		
		Entity_Sucursal sa = AdministracionDAO.getInstancia().getSucursal(vehiculo.getIdSucursalActual());
		v.setSucursalActual(sa);
		
		v.setTemperaturaMin(vehiculo.getTemperaturaMin());
		v.setTemperaturaMax(vehiculo.getTemperaturaMax());
		
		PlanMantenimiento pm = VehiculoDao.getInstancia().getPlanMantenimiento(vehiculo.getIdPlanMantenimiento());
		v.setPlan(pm);

		
		VehiculoDao.getInstancia().modificarVehiculo(v);
	}

	public void bajaVehiculo(Integer idVehiculo) {
		Vehiculo v = VehiculoDao.getInstancia().getVehiculo(idVehiculo);
		if (v != null)
			VehiculoDao.getInstancia().bajaVehiculo(v);
	}
	
	public DTO_Vehiculo buscarVehiculo(String patente) {
		return VehiculoDao.getInstancia().buscarVehiculo(patente).toDTO();
	}
	public void modificarTareaMantenimientoRealizada(DTO_TareaMantenimientoRealizada tareaMantenimientoRealizada) {
		TareaMantenimientoRealizada tmr = new TareaMantenimientoRealizada();
		tmr.setId(tareaMantenimientoRealizada.getId());
		TareaMantenimientoKilometro tk = VehiculoDao.getInstancia().getTareaMantenimientoKilometro(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		TareaMantenimientoTiempo tt = VehiculoDao.getInstancia().getTareaMantenimientoTiempo(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		
		if (tk != null)
			tmr.setTareaMantenimiento(tk);
		if (tt != null)
			tmr.setTareaMantenimiento(tk);

		tmr.setFecha(tareaMantenimientoRealizada.getFecha());
		tmr.setCantidadKilometros(tareaMantenimientoRealizada.getCantidadKilometros());
		Entity_Proveedor p = ProveedorDAO.getInstancia().getProveedor(tareaMantenimientoRealizada.getIdProveedor());
		
		tmr.setProveedor(p);
		
		VehiculoDao.getInstancia().altaTareaMantenimientoRealizada(tmr);
	}
	
	public DTO_TareaMantenimientoRealizada getTareaMantenimientoRealizada(Integer idTareaMantenimientoRealizada){
		return VehiculoDao.getInstancia().getTareaMantenimientoRealizada(idTareaMantenimientoRealizada).toDTO();
	}

	public List<DTO_PlanMantenimiento> listarPlanMantenimiento() {
		List<PlanMantenimiento> lista =	VehiculoDao.getInstancia().listarPlanMantenimiento();
		if(lista != null){
			List<DTO_PlanMantenimiento>  listaDTO = new ArrayList<DTO_PlanMantenimiento>();
			for(PlanMantenimiento p : lista)
				listaDTO.add(p.toDTO());
			return listaDTO;
		}
		return null;
	}

	public List<DTO_TareaMantenimiento> listarTareasMantenimiento(Integer idPlanMantenimiento) {
		List<TareaMantenimiento> lista =	VehiculoDao.getInstancia().listarTareasMantenimiento(idPlanMantenimiento);
		if(lista != null){
			List<DTO_TareaMantenimiento>  listaDTO = new ArrayList<DTO_TareaMantenimiento>();
			for(TareaMantenimiento t : lista)
				listaDTO.add(t.toDTO());
			return listaDTO;
		}
		return null;
	}

	public List<DTO_Vehiculo> listarVehiculos() {
		List<Vehiculo> lista =	VehiculoDao.getInstancia().listarVehiculos();
		if(lista != null){
			List<DTO_Vehiculo>  listaDTO = new ArrayList<DTO_Vehiculo>();
			for(Vehiculo v : lista)
				listaDTO.add(v.toDTO());
			return listaDTO;
		}
		return null;
	}

	public List<DTO_Vehiculo> listarVehiculos(Integer idSucursal) {
		List<Vehiculo> lista =	VehiculoDao.getInstancia().listarVehiculos(idSucursal);
		if(lista != null){
			List<DTO_Vehiculo>  listaDTO = new ArrayList<DTO_Vehiculo>();
			for(Vehiculo v : lista)
				listaDTO.add(v.toDTO());
			return listaDTO;
		}
		return null;
	}

	public List<DTO_Vehiculo> listarVehiculosMantenimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO_Vehiculo> listarVehiculosMantenimiento(Integer idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada() {
		List<TareaMantenimientoRealizada> lista =	VehiculoDao.getInstancia().listarTareasMantenimientoRealizada();
		if(lista != null){
			List<DTO_TareaMantenimientoRealizada>  listaDTO = new ArrayList<DTO_TareaMantenimientoRealizada>();
			for(TareaMantenimientoRealizada t : lista)
				listaDTO.add(t.toDTO());
			return listaDTO;
		}
		return null;
	}
	
	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada(Integer idVehiculo) {
		List<TareaMantenimientoRealizada> lista =	VehiculoDao.getInstancia().listarTareasMentenimientoRealizada(idVehiculo);
		if(lista != null){
			List<DTO_TareaMantenimientoRealizada>  listaDTO = new ArrayList<DTO_TareaMantenimientoRealizada>();
			for(TareaMantenimientoRealizada t : lista)
				listaDTO.add(t.toDTO());
			return listaDTO;
		}
		return null;
	}

	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizadaProveedor(Integer idProveedor) {
		List<TareaMantenimientoRealizada> lista =	VehiculoDao.getInstancia().listarTareaMantenimientoRealizadaProveedor(idProveedor);
		if(lista != null){
			List<DTO_TareaMantenimientoRealizada>  listaDTO = new ArrayList<DTO_TareaMantenimientoRealizada>();
			for(TareaMantenimientoRealizada t : lista)
				listaDTO.add(t.toDTO());
			return listaDTO;
		}
		return null;
	}

*/

	
	public List<Vehiculo>  buscarVehiculoConCondicion(List<Vehiculo> vehiculos, String condicion){
		List<Vehiculo> vecs = new ArrayList<Vehiculo>();
		for(Vehiculo v: vehiculos){
			for(CondicionesEspecialesVehiculo ce: v.getCondicionesEspecialesVehiculos()){
				if(ce.getDescripcion()==condicion){
					vecs.add(v);
				}
			}
		}
		return vecs;
	}
}
