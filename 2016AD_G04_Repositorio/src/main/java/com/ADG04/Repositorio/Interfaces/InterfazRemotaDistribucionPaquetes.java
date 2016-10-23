package com.ADG04.Repositorio.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_RolUsuario;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_CuentaCorriente;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Encomienda.DTO_Envio;


public interface InterfazRemotaDistribucionPaquetes extends Remote, IAdministracionRemote, IClienteRemote, IFacturaRemote, IEncomiendaRemote{
	
	public static final String url = "localhost/DistribucionPaquetesRMI";

}
