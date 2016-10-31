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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.bean.Administracion.DTO_Direccion;

@Entity
@Table(name = "Direccion")
public class DireccionE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdDireccion", unique = true, nullable = false)
	private int idDireccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPais", nullable = false)
	private PaisE pais;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdProvincia", nullable = false)
	private ProvinciaE provincia;
	
	@Column(name = "Calle", nullable = false, length = 100)
	private String calle;
	
	@Column(name = "Nro", nullable = false)
	private int nro;

	@Column(name = "Localidad", nullable = false, length = 100)
	private String localidad;
	private int codigoPostal;
	
	
	public DireccionE() {
	}


	public DireccionE(PaisE pais, ProvinciaE provincia,
			String calle, int nro, String localidad, int codigoPostal) {
		super();
		this.pais = pais;
		this.provincia = provincia;
		this.calle = calle;
		this.nro = nro;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}



	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public PaisE getPais() {
		return this.pais;
	}

	public void setPais(PaisE pais) {
		this.pais = pais;
	}

	public ProvinciaE getProvincia() {
		return this.provincia;
	}

	public void setProvincia(ProvinciaE provincia) {
		this.provincia = provincia;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return this.nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name = "CodigoPostal", nullable = false)
	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}




	public DTO_Direccion toDTO(){
		DTO_Direccion dir = new DTO_Direccion();
		dir.setCalle(this.calle);
		dir.setCodigoPostal(this.codigoPostal);
		dir.setIdDireccion(this.idDireccion);
		dir.setLocalidad(this.localidad);
		dir.setNro(this.nro);
		dir.setPais(PaisDao.getInstancia().getById(this.getPais().getIdPais()).toDTO());
		dir.setProvincia(ProvinciaDao.getInstancia().getById(this.getProvincia().getIdProvincia()).toDTO());
		return dir;
	}

}
