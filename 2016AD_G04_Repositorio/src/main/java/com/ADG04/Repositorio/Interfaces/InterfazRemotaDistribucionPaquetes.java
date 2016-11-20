package com.ADG04.Repositorio.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_CuentaCorriente;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public interface InterfazRemotaDistribucionPaquetes extends Remote, IAdministracionRemote, IClienteRemote, IFacturaRemote, IEncomiendaRemote, IVehiculo{
	
	public static final String url = "localhost/DistribucionPaquetesRMI";

	//Metodos agregados desde la interfaz web
	Integer cobrarEncomiendaParticular(Integer idFactura) throws RemoteException;

	Integer facturarEncomiendaEmpresa(int idEncomienda)throws RemoteException;

	Integer cobrarEncomiendaEmpresa(Integer idFactura)throws RemoteException;

	DTO_Usuario getEmpleado(Integer idEmpleado)throws RemoteException;

	Integer facturarEncomiendaParticular(DTO_EncomiendaParticular enc)throws RemoteException;




	

	

	

	

	

}
