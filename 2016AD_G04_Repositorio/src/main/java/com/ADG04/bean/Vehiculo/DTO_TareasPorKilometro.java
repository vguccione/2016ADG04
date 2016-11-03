package com.ADG04.bean.Vehiculo;

import java.io.Serializable;


public class DTO_TareasPorKilometro extends DTO_TareaMantenimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private float cantidadKilometros;

	public DTO_TareasPorKilometro(){
		
	}

	public float getCantidadKilometros() {
		return cantidadKilometros;
	}

	public void setCantidadKilometros(float cantidadKilometros) {
		this.cantidadKilometros = cantidadKilometros;
	}


}
