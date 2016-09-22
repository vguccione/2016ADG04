package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;

@Entity
@Table(name="ServicioSeguridad")
@PrimaryKeyJoinColumn(name="idProveedor") 
public class ServicioSeguridad extends Proveedor implements java.io.Serializable{

	@Column(name="Descripcion")
    private String descripcion;
	
	@Column(name="Tarifa")
    private float tarifa;

    public ServicioSeguridad() {
            
    }

    public String getDescripcion() {
            return descripcion;
    }

    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }

    public float getTarifa() {
            return tarifa;
    }

    public void setTarifa(float tarifa) {
            this.tarifa = tarifa;
    }

    public DTO_ServicioSeguridad toDTO() {
        DTO_ServicioSeguridad ss = new DTO_ServicioSeguridad();
        ss.setIdProveedor(this.getIdProveedor());
        ss.setDescripcion(this.getDescripcion());
        ss.setTarifa(this.getTarifa());
        return ss;
    }
}