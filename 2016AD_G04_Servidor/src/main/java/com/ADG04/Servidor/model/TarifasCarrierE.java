package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;

@Entity
@Table(name="TarifasCarrier")
public class TarifasCarrierE implements java.io.Serializable{	
	
	@Id
	@GeneratedValue
	@Column(name="IdTarifasCarrier")
	private int idTarifasCarrier;
	
	@Column(name="Comentarios")
	private String comentarios;
	
	@Column(name="Prioridad")
	private String prioridad;
	
	@Column(name="PrecioKMExtra")
	private float precioKMExtra;
	
	@Column(name="Tarifa")
	private float tarifa;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorE proveedor;

	@Column(name="Ciudad")
	private String ciudad;
	
	@ManyToOne
	@JoinColumn(name = "IdPais", nullable = true)
	private PaisE pais;
	
	@ManyToOne
	@JoinColumn(name="IdSucursal", nullable=true)
	private SucursalE origen;
	
	
	public TarifasCarrierE() {
		
	}
	
	public TarifasCarrierE(String comentarios, String prioridad,
			float precioKMExtra, float tarifa, ProveedorE proveedor, String ciudad, PaisE pais) {
		super();
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
		this.ciudad=ciudad;
		this.pais=pais;
	}

	public TarifasCarrierE(int idTarifasCarrier, String comentarios,
			String prioridad, float precioKMExtra, float tarifa,
			ProveedorE proveedor ,String ciudad, PaisE pais)  {
		super();
		this.idTarifasCarrier = idTarifasCarrier;
		this.comentarios = comentarios;
		this.prioridad = prioridad;
		this.precioKMExtra = precioKMExtra;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
		this.ciudad=ciudad;
		this.pais=pais;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public float getPrecioKMExtra() {
		return precioKMExtra;
	}

	public void setPrecioKMExtra(float precioKMExtra) {
		this.precioKMExtra = precioKMExtra;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
	

	public int getIdTarifasCarrier() {
		return idTarifasCarrier;
	}

	public void setIdTarifasCarrier(int idTarifasCarrier) {
		this.idTarifasCarrier = idTarifasCarrier;
	}

	public ProveedorE getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorE proveedor) {
		this.proveedor = proveedor;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public PaisE getPais() {
		return pais;
	}

	public void setPais(PaisE pais) {
		this.pais = pais;
	}

	public SucursalE getOrigen() {
		return origen;
	}

	public void setOrigen(SucursalE origen) {
		this.origen = origen;
	}
	
	
	

}