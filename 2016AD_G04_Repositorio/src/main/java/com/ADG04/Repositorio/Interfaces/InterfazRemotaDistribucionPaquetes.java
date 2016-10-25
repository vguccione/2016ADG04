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
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;


public interface InterfazRemotaDistribucionPaquetes extends Remote, IAdministracionRemote, IClienteRemote, IFacturaRemote, IEncomiendaRemote{
	
	public static final String url = "localhost/DistribucionPaquetesRMI";


//	void ingresarEncomiendaEnvio(Integer idEnvio);

//	void egresarEncomiendaEnvio(Integer idEnvio);

	//Integer asignarEnvio(Integer idEncomienda);
/*
	Integer cobrarEncomiendaEmpresa(List<Integer> lista);

	Integer cobrarEncomiendaParticular(Integer idFactura);

	Integer confirmarEncomiendaEmpresa(DTO_EncomiendaEmpresa enc);

	Integer confirmarEncomiendaParticular(DTO_EncomiendaParticular enc);

	Integer nuevaEncomiendaParticular(Integer idSucursal);

	Integer nuevaEncomiendaEmpresa(Integer idSucursal);
*/
	//DTO_Usuario validarUsuario(String usuario, String contrasena);


}
