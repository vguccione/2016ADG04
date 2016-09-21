package com.ADG04.bean.Vehiculo;

public class DTO_TareasPorTiempo extends DTO_TareaMantenimiento{
	private static final long serialVersionUID = 1L;
	private int cantidadDias;

	public DTO_TareasPorTiempo(){
		
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}


}
