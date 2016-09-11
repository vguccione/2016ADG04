package com.ADG94.bean.Vehiculo;

public class DTO_TareasPorTiempo extends DTO_TareaMantenimiento{
	private static final long serialVersionUID = 1L;
	private float cantidadDias;

	public DTO_TareasPorTiempo(){
		
	}

	public float getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(float cantidadDias) {
		this.cantidadDias = cantidadDias;
	}


}
