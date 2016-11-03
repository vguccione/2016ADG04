package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.List;

import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public interface IVehiculo {
	
	public List<DTO_Vehiculo> listarVehiculos() throws RemoteException;;
	public Integer altaVehiculo(DTO_Vehiculo v) throws RemoteException;
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tareaXKM, Integer idVehiculo) throws RemoteException, Exception  ;
	public Integer altaPlanMantenimiento(DTO_PlanMantenimiento pm, Integer idVehiculo)	throws RemoteException, Exception;
	public Integer altaTareaMantenimiento(DTO_TareasPorTiempo tareaXTiempo, Integer idVehiculo) throws RemoteException, Exception  ;
	public List<DTO_TareaMantenimiento> getTareasVencidas(int idVehiculo)throws RemoteException  ;
	public List<DTO_PlanMantenimiento> listarPlanesMantenimiento() throws RemoteException;
	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada() throws RemoteException;
	public DTO_TareaMantenimiento getTareaMantenimiento(Integer idTareaMantenimiento) throws RemoteException;
	public List<DTO_Vehiculo> buscarVehiculoByModeloMarcaOPatente(String filtro) throws RemoteException;
	public DTO_Vehiculo buscarVehiculoById(Integer idVehiculo) throws RemoteException;
	public DTO_PlanMantenimiento getPlanMantenimiento(Integer id) throws RemoteException;
	public List<DTO_TareaMantenimientoRealizada> buscarTareasMantenimientoRealizadasPorVehiculo(String filtro) throws RemoteException;
	public void altaPlanMantenimiento(DTO_PlanMantenimiento pm) throws RemoteException;
	public void altaTareaMantenimiento(DTO_TareasPorKilometro tpk) throws RemoteException;
	public void altaTareaMantenimiento(DTO_TareasPorTiempo tpt) throws RemoteException;
	public void altaTareaMantenimientoRealizada(DTO_TareaMantenimientoRealizada tmr) throws RemoteException;
	public DTO_Vehiculo buscarVehiculoByPatente(String patente) throws RemoteException;
	public List<DTO_TareaMantenimiento> getTareaMantenimientoByPlan(Integer idPlan) throws RemoteException;
	
}
