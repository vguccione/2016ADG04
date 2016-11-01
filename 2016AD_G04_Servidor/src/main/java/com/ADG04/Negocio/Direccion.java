package com.ADG04.Negocio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.bean.Administracion.DTO_Direccion;

public class Direccion{

	private int idDireccion;
	private Pais pais;
	private Provincia provincia;
	private String calle;
	private int nro;
	private String localidad;
	private int codigoPostal;
	
	
	public Direccion() {
	}


	public Direccion(Pais pais, Provincia provincia,
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

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
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
