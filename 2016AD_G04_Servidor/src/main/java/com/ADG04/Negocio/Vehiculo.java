package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

















import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.model.TareaMantenimientoE;
import com.ADG04.Servidor.model.TareaMantenimientoPorKmE;
import com.ADG04.Servidor.model.TareaMantenimientoPorTiempoE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class Vehiculo{

	private int idVehiculo;
	private PlanMantenimiento planMantenimiento;
	private String estado;
	private float largo;
	private float alto;
	private float ancho;
	private float peso;
	private float volumen;
	private Boolean refrigerado;
	private String condicionTransporte;
	private float kmRecorridos;
	private String marca;
	private String modelo;
	private String patente;
	private Float temperaturaMin;
	private Float temperaturaMax;
	private String anio;
	private float tara;
	private String tipo;
	private Sucursal sucursal;
	private List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas;
	private List<CondicionesEspecialesVehiculo> condicionesEspecialesVehiculos;
	private Date FechaIngreso;

	public Vehiculo() {
	}

  	public Vehiculo(String estado, float largo, float alto, float ancho,
			float peso, float volumen, Boolean refrigerado,
			String condicionTransporte, float kmRecorridos, String marca,
			String modelo, String patente, Float temperaturaMin,
			Float temperaturaMax, String anio, float tara, String tipo,
			Date fechaIngreso) {
		super();
		this.estado = estado;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.volumen = volumen;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.kmRecorridos = kmRecorridos;
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
		this.temperaturaMin = temperaturaMin;
		this.temperaturaMax = temperaturaMax;
		this.anio = anio;
		this.tara = tara;
		this.tipo = tipo;
		FechaIngreso = fechaIngreso;
	}




	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}	
	
	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}


	public PlanMantenimiento getPlanMantenimiento() {
		return this.planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}


	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public Boolean getRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(Boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public String getCondicionTransporte() {
		return condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public float getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public float getTara() {
		return tara;
	}

	public void setTara(float tara) {
		this.tara = tara;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<TareaMantenimientoRealizada> getTareasMantenimientoRealizadas() {
		return tareasMantenimientoRealizadas;
	}

	public void setTareasMantenimientoRealizadas(
			List<TareaMantenimientoRealizada> tareasMantenimientoRealizadas) {
		this.tareasMantenimientoRealizadas = tareasMantenimientoRealizadas;
	}

	public List<CondicionesEspecialesVehiculo> getCondicionesEspecialesVehiculos() {
		return condicionesEspecialesVehiculos;
	}

	public void setCondicionesEspecialesVehiculos(
			List<CondicionesEspecialesVehiculo> condicionesEspecialesVehiculos) {
		this.condicionesEspecialesVehiculos = condicionesEspecialesVehiculos;
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	public Float getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(Float temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	public Float getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(Float temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public DTO_Vehiculo toDTO() {
		DTO_Vehiculo v = new DTO_Vehiculo();
		v.setEstado(this.estado);
		if(this.getSucursal()!=null)
			v.setSucursal(this.getSucursal().toDTO());
		v.setId(this.getIdVehiculo());
		v.setAlto(alto);
		v.setAncho(ancho);
		v.setKmsRecorridos(this.getKmRecorridos());
		v.setLargo(largo);
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setPatente(patente);
		v.setPeso(peso);
		v.setTipo(tipo);
		v.setAnio(anio);
		v.setTemperaturaMax(temperaturaMax);
		v.setTemperaturaMin(temperaturaMin);
		if(refrigerado==null)
			refrigerado = false;
		else
			refrigerado=true;
		v.setRefrigerado(refrigerado);
		v.setTara(tara);
		v.setVolumen(volumen);
		v.setFechaIngreso(this.getFechaIngreso());
		PlanMantenimiento pm =  this.getPlanMantenimiento();
		if(pm!=null)
			v.setPlanMantenimiento(pm.toDTO());

		return v;
	}

	public Vehiculo fromDTO(DTO_Vehiculo dto) {
		if(dto!=null){
			Vehiculo veh = new Vehiculo();
			veh.setAlto(dto.getAlto());
			veh.setAncho(dto.getAncho());
			veh.setAnio(dto.getAnio());
			veh.setCondicionTransporte(dto.getCondicionTransporte());
			veh.setEstado(dto.getEstado());
			veh.setFechaIngreso(dto.getFechaIngreso());
			if(dto.getId()!=null)
				veh.setIdVehiculo(dto.getId());
			veh.setKmRecorridos(dto.getKmsRecorridos());
			veh.setLargo(dto.getLargo());
			veh.setMarca(dto.getMarca());
			veh.setModelo(dto.getModelo());
			veh.setPatente(dto.getPatente());
			veh.setPeso(dto.getPeso());
			veh.setPlanMantenimiento(new PlanMantenimiento().fromDTO(dto.getPlanMantenimiento()));
			veh.setRefrigerado(dto.getRefrigerado());
			veh.setSucursal(new Sucursal().fromDTO(dto.getSucursal()));
			veh.setTara(dto.getTara());
			veh.setTemperaturaMax(dto.getTemperaturaMax());
			veh.setTemperaturaMin(dto.getTemperaturaMin());
			veh.setTipo(dto.getTipo());
			veh.setVolumen(dto.getVolumen());
			return veh;
		}
		else
			return null;
	}

	public VehiculoE toEntity() {
		VehiculoE veh = new VehiculoE();
		veh.setAlto(alto);
		veh.setAncho(ancho);
		veh.setAnio(anio);
		veh.setCondicionTransporte(this.condicionTransporte);
		veh.setEstado(estado);
		veh.setFechaIngreso(this.FechaIngreso);
		veh.setIdVehiculo(this.idVehiculo);
		veh.setKmRecorridos(this.kmRecorridos);
		veh.setLargo(this.largo);
		veh.setMarca(this.getMarca());
		veh.setModelo(this.getModelo());
		veh.setPatente(this.getPatente());
		veh.setPeso(this.getPeso());
		veh.setPlanMantenimiento(this.planMantenimiento.toEntity());
		veh.setRefrigerado(this.getRefrigerado());
		veh.setSucursal(SucursalDao.getInstancia().getById(sucursal.getIdSucursal()));
		veh.setTara(this.getTara());
		veh.setTemperaturaMax(this.getTemperaturaMax());
		veh.setTemperaturaMin(this.getTemperaturaMin());
		veh.setTipo(this.getTipo());
		veh.setVolumen(this.getVolumen());
		veh.setIdVehiculo(idVehiculo);
		return veh;
	}

	public Vehiculo fromEntity(VehiculoE vehiculo) {
		if(vehiculo!=null){
			Vehiculo veh = new Vehiculo();
			veh.setIdVehiculo(vehiculo.getIdVehiculo());
			veh.setAlto(vehiculo.getAlto());
			veh.setAncho(vehiculo.getAncho());
			veh.setAnio(vehiculo.getAnio());
			veh.setCondicionTransporte(vehiculo.getCondicionTransporte());
			veh.setEstado(vehiculo.getEstado());
			veh.setFechaIngreso(vehiculo.getFechaIngreso());
			veh.setIdVehiculo(vehiculo.getIdVehiculo());
			veh.setKmRecorridos(vehiculo.getKmRecorridos());
			veh.setLargo(vehiculo.getLargo());
			veh.setMarca(vehiculo.getMarca());
			veh.setModelo(vehiculo.getModelo());
			veh.setPatente(vehiculo.getPatente());
			veh.setPeso(vehiculo.getPeso());
			veh.setPlanMantenimiento(new PlanMantenimiento().fromEntity(vehiculo.getPlanMantenimiento()));
			veh.setRefrigerado(vehiculo.getRefrigerado());
			veh.setSucursal(new Sucursal().fromEntity(vehiculo.getSucursal()));
			veh.setTara(vehiculo.getTara());
			veh.setTemperaturaMax(vehiculo.getTemperaturaMax());
			veh.setTemperaturaMin(vehiculo.getTemperaturaMin());
			veh.setTipo(vehiculo.getTipo());
			veh.setVolumen(vehiculo.getVolumen());
			return veh;
		}
		else
			return null;
	}

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		VehiculoDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();	
	}

	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		VehiculoDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();	
	}
	
	public boolean tieneTareasVencidas() {
		
		List<TareaMantenimientoE> tareas = new ArrayList<TareaMantenimientoE>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.getIdVehiculo()));
	
		if(tareas.size()!=0)
			return true;
		else
			return false;
	}

	
	public boolean estaUtilizable() {

		if(this.getEstado() == EnvioEstado.Pendiente.toString() || this.getEstado() == "" ||  
				this.getEstado() == null)
			return true;
		else
			return false;
	}

	public boolean estaAsignado() {
		
		long asignado = VehiculoDao.getInstancia().getEstadoAsignacion(this.toEntity());
		if(asignado == 0)
			return false;
		else
			return true;	
	}

	public List<TareaMantenimientoE> getTareasVencidas() {
		
		List<TareaMantenimientoE> tareas = new ArrayList<TareaMantenimientoE>(); 
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.getIdVehiculo()));
		tareas.addAll(PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.getIdVehiculo()));
		
		return tareas;
	}
	
	public List<DTO_TareaMantenimiento> getTareasVencidas2() {
		
		List<DTO_TareaMantenimiento> tareas = new ArrayList<DTO_TareaMantenimiento>();
		
		List<TareaMantenimientoPorKmE> tKms = PlanMantenimientoDao.getInstancia().getTareasVencidasPorKm(this.getIdVehiculo());
		List<TareaMantenimientoPorTiempoE> tTiempos = PlanMantenimientoDao.getInstancia().getTareasVencidasPorTiempo(this.getIdVehiculo());
				
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

}
