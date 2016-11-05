package com.ADG04.Servidor.model;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;

@Entity
@Table(name = "Proveedor")
public class ProveedorE implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "IdProveedor", unique = true, nullable = false)
	private int idProveedor;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "IdDireccion")
	private DireccionE direccion;

	@Column(name = "Activo", nullable = false, length = 1)
	private String activo;

	@Column(name = "Cuit", nullable = false, length = 10)
	private String cuit;

	@Column(name = "RazonSocial", nullable = false, length = 50)
	private String razonSocial;
	
	@Column(name = "Email", nullable = false, length = 50)
	private String email;

	@Column(name = "Telefono", nullable = false, length = 50)
	private String telefono;

	@Column(name="EsTallerOficial")
	private boolean tallerOficial;
	
	@Column(name="Tipo")
	private char tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
	private List<EnvioE> envios;
	
	public ProveedorE() {
	}

	
	public ProveedorE(DireccionE direccion, String activo, String cuit,
			String razonSocial, String email, String telefono,
			boolean tallerOficial, char tipo) {
		super();
		this.direccion = direccion;
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
		this.tallerOficial = tallerOficial;
		this.tipo = tipo;
	}

	

	public ProveedorE(int idProveedor, DireccionE direccion, String activo,
			String cuit, String razonSocial, String email, String telefono,
			boolean tallerOficial, char tipo) {
		super();
		this.idProveedor = idProveedor;
		this.direccion = direccion;
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
		this.tallerOficial = tallerOficial;
		this.tipo = tipo;
	}


	public ProveedorE(String activo, String cuit, String razonSocial, String email,
			String telefono) {
		this.activo = activo;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.email = email;
		this.telefono = telefono;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public DireccionE getDireccion() {
		return this.direccion;
	}

	public void setDireccion(DireccionE direccion) {
		this.direccion = direccion;
	}
	
	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCuit() {
		return this.cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EnvioE> getEnvios() {
		return envios;
	}

	public void setEnvios(List<EnvioE> envios) {
		this.envios = envios;
	}
	
	

	public boolean isTallerOficial() {
		return tallerOficial;
	}

	public void setTallerOficial(boolean tallerOficial) {
		this.tallerOficial = tallerOficial;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

}
