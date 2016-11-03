package com.ADG04.bean.Administracion;

import java.io.Serializable;

public class DTO_Provincia  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descripcion;
	private DTO_Pais pais;
	
	public DTO_Provincia(){	
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

	public DTO_Pais getPais() {
		return pais;
	}

	public void setPais(DTO_Pais pais) {
		this.pais = pais;
	}

}
