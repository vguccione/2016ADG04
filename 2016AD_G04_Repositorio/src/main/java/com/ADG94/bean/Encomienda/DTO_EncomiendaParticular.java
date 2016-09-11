package com.ADG94.bean.Encomienda;

public class DTO_EncomiendaParticular extends DTO_Encomienda{
	private static final long serialVersionUID = 1L;
	private String nombreParticular;
	private String apellidoParticular;
	private String dniParticular;
	private String direccionDestino;
	private String codigoPostalDestino;
	private String localidadDestino;
	private String provinciaDestino;
	private String paisDestino;
	private DTO_Manifiesto manifiesto;

	public DTO_EncomiendaParticular(){
		super();
	}

	public String getNombreParticular() {
		return nombreParticular;
	}

	public void setNombreParticular(String nombreParticular) {
		this.nombreParticular = nombreParticular;
	}

	public String getApellidoParticular() {
		return apellidoParticular;
	}

	public void setApellidoParticular(String apellidoParticular) {
		this.apellidoParticular = apellidoParticular;
	}

	public String getDniParticular() {
		return dniParticular;
	}

	public void setDniParticular(String dniParticular) {
		this.dniParticular = dniParticular;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public String getCodigoPostalDestino() {
		return codigoPostalDestino;
	}

	public void setCodigoPostalDestino(String codigoPostalDestino) {
		this.codigoPostalDestino = codigoPostalDestino;
	}

	public String getLocalidadDestino() {
		return localidadDestino;
	}

	public void setLocalidadDestino(String localidadDestino) {
		this.localidadDestino = localidadDestino;
	}

	public String getProvinciaDestino() {
		return provinciaDestino;
	}

	public void setProvinciaDestino(String provinciaDestino) {
		this.provinciaDestino = provinciaDestino;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	public DTO_Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(DTO_Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}



}
