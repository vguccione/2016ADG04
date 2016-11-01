package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.Calendar;
import java.util.Date;
import java.util.List;














import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;


public class Sucursal{

	private int idSucursal;
	private String descripcion;
	private String telefono;
	private Usuario gerente;
	private Direccion direccion;
	private List<Envio> enviosSucursalDestino;
	private List<Envio> enviosSucursalOrigen;
	private List<Encomienda> encomiendasSucursalDestino;
	private List<Encomienda> encomiendasSucursalOrigen;
	private List<Encomienda> encomiendasSucursalActual;
	private List<Usuario> usuarios; 
	private List<Vehiculo> vehiculos;
	private Coordenada coordenadas;

	public Sucursal() {
	}
	
	public Sucursal(String descripcion, String telefono) {
		super();
		this.descripcion = descripcion;
		this.telefono = telefono;
	}




	public int getIdSucursal() {
		return this.idSucursal;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Envio> getEnviosSucursalDestino() {
		return enviosSucursalDestino;
	}

	public void setEnviosSucursalDestino(List<Envio> enviosSucursalDestino) {
		this.enviosSucursalDestino = enviosSucursalDestino;
	}

	public List<Envio> getEnviosSucursalOrigen() {
		return enviosSucursalOrigen;
	}

	public void setEnviosSucursalOrigen(List<Envio> enviosSucursalOrigen) {
		this.enviosSucursalOrigen = enviosSucursalOrigen;
	}

	public Usuario getGerente() {
		return gerente;
	}

	public void setGerente(Usuario gerente) {
		this.gerente = gerente;
	}

	public List<Encomienda> getEncomiendasSucursalDestino() {
		return encomiendasSucursalDestino;
	}

	public void setEncomiendasSucursalDestino(
			List<Encomienda> encomiendasSucursalDestino) {
		this.encomiendasSucursalDestino = encomiendasSucursalDestino;
	}

	public List<Encomienda> getEncomiendasSucursalOrigen() {
		return encomiendasSucursalOrigen;
	}

	public void setEncomiendasSucursalOrigen(
			List<Encomienda> encomiendasSucursalOrigen) {
		this.encomiendasSucursalOrigen = encomiendasSucursalOrigen;
	}

	public List<Encomienda> getEncomiendasSucursalActual() {
		return encomiendasSucursalActual;
	}

	public void setEncomiendasSucursalActual(
			List<Encomienda> encomiendasSucursalActual) {
		this.encomiendasSucursalActual = encomiendasSucursalActual;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	
	

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

	public DTO_Sucursal toDTO(){
		DTO_Sucursal s = new DTO_Sucursal();
		s.setId(this.idSucursal);
		s.setDescripcion(this.descripcion);
		s.setTelefono(this.telefono);
		s.setDireccion(this.getDireccion().toDTO());
		s.setIdGerente(this.getGerente().getIdUsuario());
		return s;
	}

}
