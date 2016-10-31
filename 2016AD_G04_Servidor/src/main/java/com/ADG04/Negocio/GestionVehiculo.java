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
import com.ADG04.Servidor.model.CondicionesEspecialesVehiculoE;
import com.ADG04.Servidor.model.PlanMantenimientoE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.model.TareaMantenimientoPorKmE;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempoE;
import com.ADG04.Servidor.model.TareaMantenimientoRealizadaE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class GestionVehiculo {

	private PlanMantenimientoE planMantenimiento;
	private VehiculoE vehiculo;
	private List<TareaMantenimientoRealizadaE> tareasRealizadas = new ArrayList<TareaMantenimientoRealizadaE>();
	private EntityManagerFactory factory;
			
	public GestionVehiculo(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public GestionVehiculo(VehiculoE vehiculo){
		
		this.vehiculo = vehiculo;
		this.tareasRealizadas = new ArrayList<TareaMantenimientoRealizadaE>();
		this.planMantenimiento = new PlanMantenimientoE();
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
		
	}
	
	public int altaPlanMantenimiento(String desc, String comentarios) {

		this.planMantenimiento = new PlanMantenimientoE();
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
		
		PlanMantenimientoE pm = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.vehiculo.getIdVehiculo());
		
		DTO_PlanMantenimiento pmDTO = new DTO_PlanMantenimiento();
		pmDTO.setComentarios(pm.getComentarios());
		pmDTO.setDescripcion(pm.getDescripcion());
		return pmDTO;
	}
	
	public int altaTareaMantenimientoPorKm(String tarea, float frecuenciaKm) {
		
		TareaMantenimientoPorKmE tm = new TareaMantenimientoPorKmE();
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

		TareaMantenimientoPorTiempoE tm = new TareaMantenimientoPorTiempoE();
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
		
		
		
		TareaMantenimientoRealizadaE tmr = new TareaMantenimientoRealizadaE();
		TareaMantenimientoE tareaMantenimiento = TareaMantenimientoDao.getInstancia().getById(tareaMantenimientoRealizada.getIdTareaMantenimiento());
		tmr.setTareaMantenimiento(tareaMantenimiento);

		VehiculoE v = VehiculoDao.getInstancia().getById(this.vehiculo.getIdVehiculo());
		tmr.setVehiculo(v);
		
		tmr.setFechaRealizada(tareaMantenimientoRealizada.getFecha());
		tmr.setCantidadKilometros(v.getKmRecorridos());
		
		int idProveedor = tareaMantenimientoRealizada.getIdProveedor();
		ProveedorE p = ProveedorDao.getInstancia().getById(idProveedor);
		tmr.setProveedor(p);
		
		TareaMantenimientoRealizadaDao.getInstancia().persist(tmr);
		
	}

	public DTO_PlanMantenimiento getPlan() throws Exception{
		
		PlanMantenimientoE plan = PlanMantenimientoDao.getInstancia().getPlanByIdVehiculo(this.vehiculo.getIdVehiculo());
			DTO_PlanMantenimiento planDTO = new DTO_PlanMantenimiento();
			planDTO.setComentarios(plan.getComentarios());
			planDTO.setDescripcion(plan.getDescripcion());
			planDTO.setId(plan.getIdPlanMantenimiento());
			
			List<TareaMantenimientoE> tareas = plan.getTareaMantenimientos();
			System.out.println("Cantidad de tareas del plan: "+tareas.size());
			for(TareaMantenimientoE t:tareas){
				if(t.getClass().equals(TareaMantenimientoPorKmE.class)){
					DTO_TareasPorKilometro dtokm = new DTO_TareasPorKilometro();
					TareaMantenimientoPorKmE tk = (TareaMantenimientoPorKmE)t;
					dtokm.setCantidadKilometros(tk.getCantidadKilometros());
					dtokm.setId(tk.getIdTareaMantenimiento());
					dtokm.setIdPlanMantenimiento(plan.getIdPlanMantenimiento());
					dtokm.setTarea(tk.getTarea());

					planDTO.addTarea(dtokm);
				}
				else{
					DTO_TareasPorTiempo dtokm = new DTO_TareasPorTiempo();
					TareaMantenimientoPorTiempoE tk = (TareaMantenimientoPorTiempoE)t;
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
	
	public List<VehiculoE>  buscarVehiculoConCondicion(List<VehiculoE> vehiculos, String condicion){
		List<VehiculoE> vecs = new ArrayList<VehiculoE>();
		for(VehiculoE v: vehiculos){
			for(CondicionesEspecialesVehiculoE ce: v.getCondicionesEspecialesVehiculos()){
				if(ce.getDescripcion()==condicion){
					vecs.add(v);
				}
			}
		}
		return vecs;
	}

	public List<TareaMantenimientoE> getTareasVencidas() {
		
		List<TareaMantenimientoE> tareas = new ArrayList<TareaMantenimientoE>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo()));
		
		return tareas;
	}
	
	/*
	 * TODO: no tiene que devolver DTOs. Los "getTareasVencidas" hay que sacarlas de VehiculoDao.
	 * */
	public List<DTO_TareaMantenimiento> getTareasVencidas2() {
		
		List<DTO_TareaMantenimiento> tareas = new ArrayList<DTO_TareaMantenimiento>();
		
		List<TareaMantenimientoPorKmE> tKms = PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo());
		List<TareaMantenimientoPorTiempoE> tTiempos = PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo());
				
		List<TareaMantenimientoPorKmE> tareasVencidasKm = new ArrayList<TareaMantenimientoPorKmE>();
		List<TareaMantenimientoPorTiempoE> tareasVencidasTiempo = new ArrayList<TareaMantenimientoPorTiempoE>();
		
		tareasVencidasKm.addAll(tKms);
		tareasVencidasTiempo.addAll(tTiempos);
		
		for(TareaMantenimientoPorTiempoE tt:tTiempos){
			
			DTO_TareasPorTiempo tDto = new DTO_TareasPorTiempo();
			tDto.setCantidadDias(tt.getCantidadDias());
			tDto.setId(tt.getIdTareaMantenimiento());
			tDto.setIdPlanMantenimiento(tt.getPlanMantenimiento().getIdPlanMantenimiento());
			tDto.setTarea(tt.getTarea());
			
			tareas.add(tDto);
		}
		
		for(TareaMantenimientoPorKmE tt:tKms){
			
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
		
		List<TareaMantenimientoE> tareas = new ArrayList<TareaMantenimientoE>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.vehiculo.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.vehiculo.getIdVehiculo()));
	
		if(tareas.size()!=0)
			return true;
		else
			return false;
	}

	public void setSucursal(SucursalE sucursal) {
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

	public VehiculoE getVehiculo() {
		return this.vehiculo;
	}
}
