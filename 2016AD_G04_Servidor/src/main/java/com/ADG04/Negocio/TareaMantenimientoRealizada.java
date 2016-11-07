package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
















import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.TareaMantenimientoRealizadaDao;
import com.ADG04.Servidor.model.TareaMantenimientoRealizadaE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;

public class TareaMantenimientoRealizada{
	
	private int idTareaMantenimientoRealizada;
	private TareaMantenimiento tareaMantenimiento;
	private Proveedor proveedor;
	private Vehiculo vehiculo;
	private Date fechaRealizada;
	private Float cantidadKilometros;

	public TareaMantenimientoRealizada() {
	}

	public TareaMantenimientoRealizada(TareaMantenimiento tareaMantenimiento, Proveedor proveedor,
			Vehiculo vehiculo, Date fechaRealizada, float cantidadKilometros) {
		this.tareaMantenimiento = tareaMantenimiento;
		this.proveedor = proveedor;
		this.vehiculo = vehiculo;
		this.fechaRealizada = fechaRealizada;
		this.cantidadKilometros = cantidadKilometros;
	}
	

	public int getIdTareaMantenimientoRealizada() {
		return this.idTareaMantenimientoRealizada;
	}

	public void setIdTareaMantenimientoRealizada(
			int idTareaMantenimientoRealizada) {
		this.idTareaMantenimientoRealizada = idTareaMantenimientoRealizada;
	}


	public TareaMantenimiento getTareaMantenimiento() {
		return this.tareaMantenimiento;
	}

	public void setTareaMantenimiento(TareaMantenimiento tareaMantenimiento) {
		this.tareaMantenimiento = tareaMantenimiento;
	}


	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaRealizada() {
		return this.fechaRealizada;
	}

	public void setFechaRealizada(Date fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}
	public float getCantidadKilometros() {
		if(this.cantidadKilometros==null){
			return 0;
		}
		else
			return this.cantidadKilometros;
	}

	public void setCantidadKilometros(float cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}

	public DTO_TareaMantenimientoRealizada toDTO() {
		DTO_TareaMantenimientoRealizada dto = new DTO_TareaMantenimientoRealizada();
		dto.setCantidadKilometros(this.getCantidadKilometros());
		dto.setFecha(this.getFechaRealizada());
		dto.setId(this.getIdTareaMantenimientoRealizada());
		dto.setIdProveedor(this.getProveedor().getIdProveedor());
		dto.setIdVehiculo(this.getVehiculo().getIdVehiculo());
		dto.setIdTareaMantenimiento(this.getTareaMantenimiento().getIdTareaMantenimiento());
		return dto;
	}

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		TareaMantenimientoRealizadaDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();	
		}

	private TareaMantenimientoRealizadaE toEntity() {
		TareaMantenimientoRealizadaE tm = new TareaMantenimientoRealizadaE();
		tm.setCantidadKilometros(cantidadKilometros);
		tm.setFechaRealizada(fechaRealizada);
		tm.setIdTareaMantenimientoRealizada(idTareaMantenimientoRealizada);
		tm.setProveedor(proveedor.toEntity());
		tm.setTareaMantenimiento(tareaMantenimiento.toEntity());
		tm.setVehiculo(vehiculo.toEntity());
		return tm;
	}

	public TareaMantenimientoRealizada fromEntity(TareaMantenimientoRealizadaE tarea) {
		if(tarea!=null){
			TareaMantenimientoRealizada tr = new TareaMantenimientoRealizada();
			tr.setCantidadKilometros(tarea.getCantidadKilometros());
			tr.setFechaRealizada(tarea.getFechaRealizada());
			tr.setIdTareaMantenimientoRealizada(tarea.getIdTareaMantenimientoRealizada());
			tr.setProveedor(new Proveedor().fromEntity(tarea.getProveedor()));
			tr.setVehiculo(new Vehiculo().fromEntity(tarea.getVehiculo()));
			tr.setTareaMantenimiento(new TareaMantenimiento().fromEntity(tarea.getTareaMantenimiento()));
			return tr;
		}
		else
			return null;
	}

}
