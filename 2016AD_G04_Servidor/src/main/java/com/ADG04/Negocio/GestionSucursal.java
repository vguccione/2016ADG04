package com.ADG04.Negocio;

import java.util.List;










import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.UsuarioE;
import com.ADG04.Servidor.model.VehiculoE;

public class GestionSucursal {
	private int idSucursal;
	private String descripcion;
	private String telefono;
	private UsuarioE gerente;
	private DireccionE direccion;
	private List<EnvioE> enviosSucursalDestino;
	private List<EnvioE> enviosSucursalOrigen;
	private List<EncomiendaE> encomiendasSucursalDestino;
	private List<EncomiendaE> encomiendasSucursalOrigen;
	private List<EncomiendaE> encomiendasSucursalActual;
	private List<UsuarioE> usuarios; 
	private List<VehiculoE> vehiculos;
	private CoordenadaE coordenadas;
	
	
}