package com.ADG04.Servidor.util;

// TODO: definir los estados de la encomienda!!!!!!!!!
public enum EncomiendaEstado {

	Ingresada,	//Cuando se le da de alta, todavía no le asignamos un envio
	EnSucursalOrigen,	//Esta en sucursal de origen
	EnViaje,		//esta en viaje
	EnSucursalDestino,	//llego a la sucursal de destino
	Entregada,			//entregada al receptor
	Cancelada
}
