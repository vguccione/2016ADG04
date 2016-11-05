package com.ADG04.Negocio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.PaisE;
import com.ADG04.Servidor.model.ProvinciaE;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;

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
		dir.setPais(new Pais().fromEntity(PaisDao.getInstancia().getById(this.getPais().getIdPais())).toDTO());
		dir.setProvincia(new Provincia().fromEntity(ProvinciaDao.getInstancia().getById(this.getProvincia().getIdProvincia())).toDTO());
		return dir;
	}


	public DireccionE toEntity() {
		DireccionE dir = new DireccionE();
		dir.setCalle(this.getCalle());
		dir.setCodigoPostal(this.getCodigoPostal());
		dir.setLocalidad(this.getLocalidad());
		dir.setNro(this.getNro());
		
		ProvinciaDao provDao = ProvinciaDao.getInstancia();
		ProvinciaE prov = (ProvinciaE) provDao.getById(this.getProvincia().getIdProvincia());
		
		dir.setProvincia(prov);
		
		PaisDao paisDao = PaisDao.getInstancia();
		PaisE pais = (PaisE) paisDao.getById(this.getPais().getIdPais());
		
		dir.setPais(pais);
		
		return dir;
	}
	
	
	public Direccion fromDTO(DTO_Direccion direccion) {

		/*Crear Direccion*/
		Direccion dir = new Direccion();
		dir.setCalle(direccion.getCalle());
		dir.setCodigoPostal(direccion.getCodigoPostal());
		dir.setLocalidad(direccion.getLocalidad());
		dir.setNro(direccion.getNro());
		
		ProvinciaE prove =ProvinciaDao.getInstancia().getById(direccion.getProvincia().getId());
		Provincia prov = new Provincia().fromEntity(prove);
		
		PaisE pais = PaisDao.getInstancia().getById(direccion.getPais().getId());
		Pais p = new Pais().fromEntity(pais);
		
		
		dir.setProvincia(prov);
		dir.setPais(p);
		return dir;
	}


	public Direccion fromEntity(DireccionE direccion) {
		/*Crear Direccion*/
		Direccion dir = new Direccion();
		dir.setCalle(direccion.getCalle());
		dir.setCodigoPostal(direccion.getCodigoPostal());
		dir.setLocalidad(direccion.getLocalidad());
		dir.setNro(direccion.getNro());
		
		ProvinciaE prove = ProvinciaDao.getInstancia().getById(direccion.getProvincia().getIdProvincia());
		Provincia prov = new Provincia().fromEntity(prove);
		
		PaisE pais = PaisDao.getInstancia().getById(direccion.getPais().getIdPais());
		Pais p = new Pais().fromEntity(pais);
		
		
		dir.setProvincia(prov);
		dir.setPais(p);
		return dir;
	}

}
