package com.ADG04.Servidor.util;

public enum EncomiendaEstado {

	Ingresada,	//Cuando se le da de alta, todavía no le asignamos un envio
	EnSucursalOrigen,	//Esta en sucursal de origen
	Colocada,
	EnViaje,		//esta en viaje
	EnSucursalDestino,	//llego a la sucursal de destino del envio
	EnEsperaAsignacion,		//esperando nueva asignacion a envio
	Entregada,			//entregada al receptor
	Cancelada
}
