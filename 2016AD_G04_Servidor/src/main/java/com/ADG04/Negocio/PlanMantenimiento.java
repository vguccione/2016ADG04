package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.model.PlanMantenimientoE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;

public class PlanMantenimiento{
 
	private int idPlanMantenimiento;
	private String descripcion;
	private String comentarios;
	private List<Vehiculo> vehiculos;
	private List<TareaMantenimiento> tareaMantenimientos;

	public PlanMantenimiento() {
	}

	public PlanMantenimiento(String descripcion,String comentarios) {
		this.descripcion = descripcion;
		this.comentarios = comentarios;
	}


	public int getIdPlanMantenimiento() {
		return this.idPlanMantenimiento;
	}

	public void setIdPlanMantenimiento(int idPlanMantenimiento) {
		this.idPlanMantenimiento = idPlanMantenimiento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<TareaMantenimiento> getTareaMantenimientos() {
		return tareaMantenimientos;
	}

	public void setTareaMantenimientos(List<TareaMantenimiento> tareaMantenimientos) {
		this.tareaMantenimientos = tareaMantenimientos;
	}

	public void addTarea(TareaMantenimiento tarea){
		
		if(this.tareaMantenimientos == null)
			this.tareaMantenimientos = new ArrayList<TareaMantenimiento>();
		
		this.tareaMantenimientos.add(tarea);
	}

	public DTO_PlanMantenimiento toDTO() {
		DTO_PlanMantenimiento dto = new DTO_PlanMantenimiento();
		dto.setId(this.getIdPlanMantenimiento());
		dto.setComentarios(this.getComentarios());
		dto.setDescripcion(this.getDescripcion());
		return dto;
	}

	public PlanMantenimiento fromDTO(DTO_PlanMantenimiento dto) {
		PlanMantenimiento pm = new PlanMantenimiento();
		pm.setComentarios(dto.getComentarios());
		pm.setDescripcion(dto.getDescripcion());
		pm.setIdPlanMantenimiento(dto.getId());
		return pm;
	}

	
	public void guardar() {	
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		PlanMantenimientoDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}

	public PlanMantenimientoE toEntity() {
		PlanMantenimientoE pe = new PlanMantenimientoE();
		pe.setComentarios(this.comentarios);
		pe.setDescripcion(descripcion);
		pe.setIdPlanMantenimiento(this.idPlanMantenimiento);
		return pe;
	}

	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		PlanMantenimientoDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}

	public PlanMantenimiento fromEntity(PlanMantenimientoE p) {
		if(p!=null){
			PlanMantenimiento pm = new PlanMantenimiento();
			pm.setComentarios(p.getComentarios());
			pm.setDescripcion(p.getDescripcion());
			pm.setIdPlanMantenimiento(p.getIdPlanMantenimiento());
			return pm;
		}
		else 
			return null;
	}
}
