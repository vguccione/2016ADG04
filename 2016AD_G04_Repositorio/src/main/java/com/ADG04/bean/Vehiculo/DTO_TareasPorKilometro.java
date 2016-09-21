package com.ADG04.bean.Vehiculo;


public class DTO_TareasPorKilometro extends DTO_TareaMantenimiento {
	
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
