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

	PlanMantenimiento plane;
	private int idVehiculo;
	List<TareaMantenimientoRealizada> tareasRealizadas;
	private Vehiculo vehiculo;
	private EntityManagerFactory factory;

	private int idPlanMantenimiento;

	private int idSucursal;

	private List<TareaMantenimientoPorTiempo> tareasVencidasTiempo;

	private List<TareaMantenimientoPorKm> tareasVencidasKm;
			
	public GestionVehiculo(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();

		this.tareasVencidasKm = new ArrayList<TareaMantenimientoPorKm>();
		this.tareasVencidasTiempo = new ArrayList<TareaMantenimientoPorTiempo>();
		this.tareasRealizadas = new ArrayList<TareaMantenimientoRealizada>();
		this.plane = new PlanMantenimiento();
	}
	
	public GestionVehiculo(int idVehiculo){
		
		this.idVehiculo = idVehiculo;
		this.tareasVencidasKm = new ArrayList<TareaMantenimientoPorKm>();
		this.tareasVencidasTiempo = new ArrayList<TareaMantenimientoPorTiempo>();
		this.tareasRealizadas = new ArrayList<TareaMantenimientoRealizada>();
		this.plane = new PlanMantenimiento();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		
	}
	
	/**
	 * Debe existir el vehículo
	 * @param planMantenimiento
	 * @return
	 * @
	 */
	public int altaPlanMantenimiento(DTO_PlanMantenimiento planMantenimiento) {

		PlanMantenimiento pm = new PlanMantenimiento();
		pm.setDescripcion(planMantenimiento.getDescripcion());
		//pm.setTolerancia(planMantenimiento.getTolerancia());
		pm.setComentarios(planMantenimiento.getComentarios());
	
		PlanMantenimientoDao.getInstancia().persist(pm);
		
		Vehiculo v = VehiculoDao.getInstancia().getById(this.idVehiculo);
		v.setPlanMantenimiento(pm);
		VehiculoDao.getInstancia().persist(v);
		
		this.plane = pm;
		this.idPlanMantenimiento = pm.getIdPlanMantenimiento();
		
		return this.idPlanMantenimiento;
	}

	/*
	public void bajaPlanMantenimiento(Integer idPlanMantenimiento) {
		PlanMantenimientoDao.getInstancia().removeById(idPlanMantenimiento);
	}*/

	public DTO_PlanMantenimiento getPlanMantenimiento() throws Exception{
		
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.idVehiculo);
		
		DTO_PlanMantenimiento pmDTO = new DTO_PlanMantenimiento();
		pmDTO.setComentarios(pm.getComentarios());
		pmDTO.setDescripcion(pm.getDescripcion());
		return pmDTO;
	}
	
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tarea) {
		
		PlanMantenimiento p =  PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.idVehiculo);
		
		TareaMantenimientoPorKm tm = new TareaMantenimientoPorKm();
		tm.setTarea(tarea.getTarea());
		tm.setCantidadKilometros(tarea.getCantidadKilometros());
		tm.setPlanMantenimiento(p);
		
		TareaMantenimientoDao.getInstancia().persist(tm);
	}
	
	public int altaTareaMantenimiento(DTO_TareasPorTiempo tarea) {
		
		
		
		PlanMantenimiento p =  PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.idVehiculo);
		
		TareaMantenimientoPorTiempo tm = new TareaMantenimientoPorTiempo();
		tm.setTarea(tarea.getTarea());
		tm.setCantidadDias(tarea.getCantidadDias());
		tm.setPlanMantenimiento(p);
		
		TareaMantenimientoDao.getInstancia().persist(tm);
		
		return tm.getIdTareaMantenimiento();
	}

	public void realizarTareaMantenimiento(DTO_TareaMantenimientoRealizada tareaMantenimientoRealizada) {
		
		
		
		TareaMantenimientoRealizada tmr = new TareaMantenimientoRealizada();
		TareaMantenimiento tareaMantenimiento = TareaMantenimientoDao.getInstancia().getById(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		tmr.setTareaMantenimiento(tareaMantenimiento);

		Vehiculo v = VehiculoDao.getInstancia().getById(this.idVehiculo);
		tmr.setVehiculo(v);
		
		tmr.setFechaRealizada(tareaMantenimientoRealizada.getFecha());
		tmr.setCantidadKilometros(v.getKmRecorridos());
		
		int idProveedor = tareaMantenimientoRealizada.getIdProveedor();
		Proveedor p = ProveedorDao.getInstancia().getById(idProveedor);
		tmr.setProveedor(p);
		
		TareaMantenimientoRealizadaDao.getInstancia().persist(tmr);
		
	}

	public DTO_PlanMantenimiento getPlan() throws Exception{
		
		
		
		PlanMantenimiento plan = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.idVehiculo);
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
	
	
	public int altaVehiculo(DTO_Vehiculo vehiculo) {
	
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
		
		Sucursal s = SucursalDao.getInstancia().getById(vehiculo.getSucursal().getId());
		v.setSucursal(s);
		
		//Sucursal actual???????
		//Entity_Sucursal sa = AdministracionDAO.getInstancia().getSucursal(vehiculo.getIdSucursalActual());
		//v.setSucursal(sa);
			
		//PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(vehiculo.getPlanMantenimiento().getId());
		//v.setPlanMantenimiento(pm);
				
		VehiculoDao.getInstancia().persist(v);
		
		this.idSucursal = s.getIdSucursal();
		//this.idPlanMantenimiento = pm.getIdPlanMantenimiento();
		this.idVehiculo = v.getIdVehiculo();
		return this.idVehiculo;
	}
	
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

	public List<TareaMantenimiento> getTareasVencidas() {
		
		List<TareaMantenimiento> tareas = new ArrayList<TareaMantenimiento>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.idVehiculo));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.idVehiculo));
		
		return tareas;
	}
	
	public List<DTO_TareaMantenimiento> getTareasVencidas2() {
		
		List<DTO_TareaMantenimiento> tareas = new ArrayList<DTO_TareaMantenimiento>();
		
		List<TareaMantenimientoPorKm> tKms = PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.idVehiculo);
		List<TareaMantenimientoPorTiempo> tTiempos = PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.idVehiculo);
		
		this.tareasVencidasKm.addAll(tKms);
		this.tareasVencidasTiempo.addAll(tTiempos);
		
		for(TareaMantenimientoPorTiempo tt:tTiempos){
			
			DTO_TareasPorTiempo tDto = new DTO_TareasPorTiempo();
			tDto.setCantidadDias(tt.getCantidadDias());
			tDto.setId(tt.getIdTareaMantenimiento());
			tDto.setIdPlanMantenimiento(tt.getPlanMantenimiento().getIdPlanMantenimiento());
			tDto.setTarea(tt.getTarea());
			
			tareas.add(tDto);
		}
		
		for(TareaMantenimientoPorKm tt:tKms){
			
			DTO_TareasPorKilometro tDto = new DTO_TareasPorKilometro();
			tDto.setCantidadKilometros(tt.getCantidadKilometros());
			tDto.setId(tt.getIdTareaMantenimiento());
			tDto.setIdPlanMantenimiento(tt.getPlanMantenimiento().getIdPlanMantenimiento());
			tDto.setTarea(tt.getTarea());
			
			tareas.add(tDto);
		}
		
		return tareas;
	}
	
	public boolean tieneTareasVencidas() {
		
		List<TareaMantenimiento> tareas = new ArrayList<TareaMantenimiento>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.idVehiculo));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.idVehiculo));
	
		if(tareas.size()!=0)
			return true;
		else
			return false;
	}
}
