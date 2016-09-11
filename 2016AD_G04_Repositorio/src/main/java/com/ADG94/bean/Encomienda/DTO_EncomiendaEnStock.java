package com.ADG94.bean.Encomienda;

import java.io.Serializable;

public class DTO_EncomiendaEnStock implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idEncomienda;
	private int pasillo;
	private int estante;
	private String ubicacion;
	private Integer idStock;
	
	public DTO_EncomiendaEnStock(){
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEncomienda() {
		return idEncomienda;
	}

	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public int getPasillo() {
		return pasillo;
	}

	public void setPasillo(int pasillo) {
		this.pasillo = pasillo;
	}

	public int getEstante() {
		return estante;
	}

	public void setEstante(int estante) {
		this.estante = estante;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getIdStock() {
		return idStock;
	}

	public void setIdStock(Integer idStock) {
		this.idStock = idStock;
	}
	
}
