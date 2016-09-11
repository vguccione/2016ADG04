package com.ADG94.bean.Encomienda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_HojaDeRuta implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private List<DTO_Trayecto> trayectos;
	
	public DTO_HojaDeRuta(){
		trayectos = new ArrayList<DTO_Trayecto>();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<DTO_Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(List<DTO_Trayecto> trayectos) {
		this.trayectos = trayectos;
	}
	
}
