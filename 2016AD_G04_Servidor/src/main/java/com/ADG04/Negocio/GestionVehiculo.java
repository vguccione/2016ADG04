package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.mapping.Array;

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
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class GestionVehiculo {

	private PlanMantenimiento planMantenimiento;
	private Vehiculo vehiculo;
	private List<TareaMantenimientoRealizada> tareasRealizadas = new ArrayList<TareaMantenimientoRealizada>();
	private EntityManagerFactory factory;
			
	public GestionVehiculo(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public GestionVehiculo(Vehiculo vehiculo){
		
		this.vehiculo = vehiculo;
		this.tareasRealizadas = new ArrayList<TareaMantenimientoRealizada>();
		this.planMantenimiento = new PlanMantenimiento();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		
	}
	
	public int altaPlanMantenimiento(String desc, String comentarios) {

		this.planMantenimiento = new PlanMantenimiento();
		this.planMantenimiento.setDescripcion(desc);
		this.planMantenimiento.setComentarios(comentarios);
	
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		PlanMantenimientoDao.getInstancia().saveOrUpdate(this.planMantenimiento);
		this.vehiculo.setPlanMantenimiento(this.planMantenimiento);
		VehiculoDao.getInstancia().saveOrUpdate(this.vehiculo);
		
		tx.commit();
		
		return this.planMantenimiento.getIdPlanMantenimiento();
	}

	/*
	public void bajaPlanMantenimiento(Integer idPlanMantenimiento) {
		PlanMantenimientoDao.getInstancia().removeById(idPlanMantenimiento);
	}*/

	public DTO_PlanMantenimiento getPlanMantenimiento() throws Exception{
		
		PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.vehiculo.getIdVehiculo());
		
		DTO_PlanMantenimiento pmDTO = new DTO_PlanMantenimiento();
		pmDTO.setComentarios(pm.getComentarios());
		pmDTO.setDescripcion(pm.getDescripcion());
		return pmDTO;
	}
	
	public int altaTareaMantenimientoPorKm(String tarea, float frecuenciaKm) {
		
		TareaMantenimientoPorKm tm = new TareaMantenimientoPorKm();
		tm.setTarea(tarea);
		tm.setCantidadKilometros(frecuenciaKm);
		if(this.planMantenimiento == null)
			this.planMantenimiento = PlanMantenimientoDao.getInstancia().getById(this.vehiculo.getIdVehiculo());
		
		tm.setPlanMantenimiento(this.planMantenimiento);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TareaMantenimientoDao.getInstancia().saveOrUpdate(tm);
		
		tx.commit();
		
		return tm.getIdTareaMantenimiento();
	}
	
	public int altaTareaMantenimientoPorTiempo(String tarea, int frecuenciaDias) {

		TareaMantenimientoPorTiempo tm = new TareaMantenimientoPorTiempo();
		tm.setTarea(tarea);
		tm.setCantidadDias(frecuenciaDias);
		if(this.planMantenimiento == null)
			this.planMantenimiento = PlanMantenimientoDao.getInstancia().getById(this.vehiculo.getIdVehiculo());
		
		tm.setPlanMantenimiento(this.planMantenimiento);
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		TareaMantenimientoDao.getInstancia().saveOrUpdate(tm);
		
		tx.commit();
		
		return tm.getIdTareaMantenimiento();
	}

	public void realizarTareaMantenimiento(DTO_TareaMantenimientoRealizada tareaMantenimientoRealizada) {
		
		
		
		TareaMantenimientoRealizada tmr = new TareaMantenimientoRealizada();
		TareaMantenimiento tareaMantenimiento = TareaMantenimientoDao.getInstancia().getById(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		tmr.setTareaMantenimiento(tareaMantenimiento);

		Vehiculo v = VehiculoDao.getInstancia().getById(this.vehiculo.getIdVehiculo());
		tmr.setVehiculo(v);
		
		tmr.setFechaRealizada(tareaMantenimientoRealizada.getFecha());
		tmr.setCantidadKilometros(v.getKmRecorridos());
		
		int idProveedor = tareaMantenimientoRealizada.getIdProveedor();
		Proveedor p = ProveedorDao.getInstancia().getById(idProveedor);
		tmr.setProveedor(p);
		
		TareaMantenimientoRealizadaDao.getInstancia().persist(tmr);
		
	}

	public DTO_PlanMantenimiento getPlan() throws Exception{
		
		PlanMantenimiento plan = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.vehiculo.getIdVehiculo());
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
	
	
	public int saveOrUpdate() {
	/*
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
		*/
		//Sucursal s = SucursalDao.getInstancia().getById(vehiculo.getSucursal().getId());
		//this.vehiculo.setSucursal(s);
		
		//PlanMantenimiento pm = PlanMantenimientoDao.getInstancia().getById(vehiculo.getPlanMantenimiento().getId());
		//this.vehiculo.setPlanMantenimiento(pm);
				
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		VehiculoDao.getInstancia().saveOrUpdate(this.vehiculo);
		
		tx.commit();
		
		//this.idSucursal = s.getIdSucursal();
		//this.idPlanMantenimiento = pm.getIdPlanMantenimiento();
	//	this.idVehiculo = v.getIdVehiculo();
		return this.vehiculo.getIdVehiculo();
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
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo()));
		
		return tareas;
	}
	
	/*
	 * TODO: no tiene que devolver DTOs. Los "getTareasVencidas" hay que sacarlas de VehiculoDao.
	 * */
	public List<DTO_TareaMantenimiento> getTareasVencidas2() {
		
		List<DTO_TareaMantenimiento> tareas = new ArrayList<DTO_TareaMantenimiento>();
		
		List<TareaMantenimientoPorKm> tKms = PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo());
		List<TareaMantenimientoPorTiempo> tTiempos = PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo());
				
		List<TareaMantenimientoPorKm> tareasVencidasKm = new ArrayList<TareaMantenimientoPorKm>();
		List<TareaMantenimientoPorTiempo> tareasVencidasTiempo = new ArrayList<TareaMantenimientoPorTiempo>();
		
		tareasVencidasKm.addAll(tKms);
		tareasVencidasTiempo.addAll(tTiempos);
		
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
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo()));
	
		if(tareas.size()!=0)
			return true;
		else
			return false;
	}

	public void setSucursal(Sucursal sucursal) {
		this.vehiculo.setSucursal(sucursal);
	}

	public boolean estaUtilizable() {

		if(this.vehiculo.getEstado() == EnvioEstado.Pendiente.toString() || this.vehiculo.getEstado() == "" ||  
				this.vehiculo.getEstado() == null)
			return true;
		else
			return false;
	}

	/*
	 * El vehículo está asigando a algun Envío?
	 * */
	public boolean estaAsignado() {
		
		long asignado = VehiculoDao.getInstancia().getEstadoAsignacion(this.vehiculo);
		if(asignado == 0)
			return false;
		else
			return true;	
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
}
