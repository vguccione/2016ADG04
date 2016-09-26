package com.ADG04.bean.Administracion;

import java.io.Serializable;

public class DTO_Pais  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descripcion;

	public DTO_Pais(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
