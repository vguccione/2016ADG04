package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;












import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.model.PaisE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Pais;

public class Pais{
 
	private int idPais;
	private String descripcion;
	private List<Direccion> direcciones;

	public Pais() {
	}

	public Pais(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdPais() {
		return this.idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	public DTO_Pais toDTO(){
		DTO_Pais p = new DTO_Pais();
		p.setDescripcion(this.descripcion);
		p.setId(this.idPais);
		return p;
	}

	public PaisE toEntity() {
		PaisE p = new PaisE();
		p.setDescripcion(this.descripcion);
		p.setIdPais(this.getIdPais());
		return p;
	}

	public Pais fromDTO(DTO_Pais pais) {
		Pais p = new Pais();
		p.setDescripcion(pais.getDescripcion());
		p.setIdPais(pais.getId());
		return p;
	}
	
	public void guardar(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		PaisDao.getInstancia().persist(this.toEntity());
		tx.commit();
	}
	

	
}
