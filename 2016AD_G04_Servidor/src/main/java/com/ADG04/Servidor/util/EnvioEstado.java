package com.ADG04.Servidor.util;

// TODO: definir los estados de los envios
public enum EnvioEstado {

	Pendiente,	//por salir en viaje
	EnViaje,	//esta en viaje
	Desviado,   //el vehiculo asignado al envio no esta siguiendo la ruta acordada
	Alerta,     //el vehiculo asignado hace 10 minutos que esta en otra ruta
	Demorado,   //el envio llego mas tarde de lo pautado
	Concluido   //llego a destino
}
