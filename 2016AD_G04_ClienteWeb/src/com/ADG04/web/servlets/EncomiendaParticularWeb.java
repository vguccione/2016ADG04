package com.ADG04.web.servlets;

import java.util.Date;

import org.json.simple.JSONValue;

public class EncomiendaParticularWeb {

	private int idCliente;
	private int idEncomienda;
	private int idSucursalDestno;
	private int idSucursalOrigen;
	private int idSucursalActual;
	private Date fechaCreacion;
	private Date fechaEstimadaEntrega;
	private String estado;
	private boolean tercerizado;
	private float largo;
	private float alto;
	private float ancho;
	private float peso;
	private float volumen;
	private String tratamiento;
	private Boolean apilable;
	private Short cantApilable;
	private Boolean refrigerado;
	private String condicionTransporte;
	private String indicacionesManipulacion;
	private String fragilidad;
	private String nombreReceptor;
	private String apellidoReceptor;
	private String dniReceptor;
	private float volumenGranel;
	private String unidadGranel;
	private String cargaGranel;
	//private List<ProductoEncomiendaE> productoEncomiendas;
	private boolean terciarizado;
	//private ServicioSeguridadE servicioSeguridad;
	//private ManifiestoE manifiesto;
	//private FacturaE factura;
	//private RemitoE remito;
	//private boolean internacional;
	private Boolean envioAsignado;
	
	public EncomiendaParticularWeb(){
		
	}
	
	
	public EncomiendaParticularWeb(int idCliente, int idEncomienda,
			int idSucursalDestno, int idSucursalOrigen, int idSucursalActual,
			Date fechaCreacion, Date fechaEstimadaEntrega, String estado,
			boolean tercerizado, float largo, float alto, float ancho,
			float peso, float volumen, String tratamiento, 
			Boolean apilable, int cantApilable,
			Boolean refrigerado,
			String condicionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor,
			String dniReceptor, float volumenGranel, String unidadGranel,
			String cargaGranel, Boolean envioAsignado) {
		super();
		this.idCliente = idCliente;
		this.idEncomienda = idEncomienda;
		this.idSucursalDestno = idSucursalDestno;
		this.idSucursalOrigen = idSucursalOrigen;
		this.idSucursalActual = idSucursalActual;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		this.tercerizado = tercerizado;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.volumen = volumen;
		this.tratamiento = tratamiento;
		this.apilable = apilable;
		this.cantApilable = (short) cantApilable;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.indicacionesManipulacion = indicacionesManipulacion;
		this.fragilidad = fragilidad;
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.volumenGranel = volumenGranel;
		this.unidadGranel = unidadGranel;
		this.cargaGranel = cargaGranel;
		this.envioAsignado = envioAsignado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public int getIdSucursalDestno() {
		return idSucursalDestno;
	}

	public void setIdSucursalDestno(int idSucursalDestno) {
		this.idSucursalDestno = idSucursalDestno;
	}

	public int getIdSucursalOrigen() {
		return idSucursalOrigen;
	}

	public void setIdSucursalOrigen(int idSucursalOrigen) {
		this.idSucursalOrigen = idSucursalOrigen;
	}

	public int getIdSucursalActual() {
		return idSucursalActual;
	}

	public void setIdSucursalActual(int idSucursalActual) {
		this.idSucursalActual = idSucursalActual;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstimadaEntrega() {
		return fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isTercerizado() {
		return tercerizado;
	}

	public void setTercerizado(boolean tercerizado) {
		this.tercerizado = tercerizado;
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

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Boolean getApilable() {
		return apilable;
	}

	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}

	public Short getCantApilable() {
		return cantApilable;
	}

	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
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

	public String getIndicacionesManipulacion() {
		return indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}

	public String getFragilidad() {
		return fragilidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public String getNombreReceptor() {
		return nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public float getVolumenGranel() {
		return volumenGranel;
	}

	public void setVolumenGranel(float volumenGranel) {
		this.volumenGranel = volumenGranel;
	}

	public String getUnidadGranel() {
		return unidadGranel;
	}

	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}

	public String getCargaGranel() {
		return cargaGranel;
	}

	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}

	public boolean isTerciarizado() {
		return terciarizado;
	}

	public void setTerciarizado(boolean terciarizado) {
		this.terciarizado = terciarizado;
	}

	public Boolean getEnvioAsignado() {
		return envioAsignado;
	}

	public void setEnvioAsignado(Boolean envioAsignado) {
		this.envioAsignado = envioAsignado;
	}

	public String toString() {
		return "Encomienda [cliente=" + idCliente
				+ ", fechaCreacion=" + fechaCreacion
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", estado=" + estado + ", tercerizado=" + tercerizado
				+ ", largo=" + largo + ", alto=" + alto + ", ancho=" + ancho
				+ ", peso=" + peso + ", volumen=" + volumen + ", tratamiento="
				+ tratamiento + ", apilable=" + apilable + ", cantApilable="
				+ cantApilable + ", refrigerado=" + refrigerado
				+ ", condicionTransporte=" + condicionTransporte
				+ ", indicacionesManipulacion=" + indicacionesManipulacion
				+ ", fragilidad=" + fragilidad + ", nombreReceptor="
				+ nombreReceptor + ", apellidoReceptor=" + apellidoReceptor
				+ ", dniReceptor=" + dniReceptor + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel 
				//+ ", productoEncomiendas="	+ productoEncomiendas 
				+ ", terciarizado=" + terciarizado +"" 
				//+ " internacional +" + internacional 
				+ "]";
	}

	private String tieneEnvio(){
		if(envioAsignado)
			return "Si";
		else
			return "No";
	}


	public String getJsonString() {
		return JSONValue.toJSONString(this.toString());
	}

}
