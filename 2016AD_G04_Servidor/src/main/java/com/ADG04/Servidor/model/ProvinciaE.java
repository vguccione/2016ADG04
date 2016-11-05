package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;

@Entity
@Table(name = "Provincia")
public class ProvinciaE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdProvincia", unique = true, nullable = false)
	private int idProvincia;
	
	@Column(name = "Descripcion", nullable = false, length = 100)
	private String descripcion;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia")
	private List<DireccionE> direcciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPais", nullable = false)
	private PaisE pais;

	public ProvinciaE() {
	}

	public ProvinciaE(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DireccionE> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<DireccionE> direcciones) {
		this.direcciones = direcciones;
	}
	
	

	public PaisE getPais() {
		return pais;
	}

	public void setPais(PaisE pais) {
		this.pais = pais;
	}

}
