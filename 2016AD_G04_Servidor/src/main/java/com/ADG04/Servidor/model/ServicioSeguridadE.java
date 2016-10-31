package com.ADG04.Servidor.model;

import javax.persistence.*;

import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;

@Entity
@Table(name="ServicioSeguridad")
public class ServicioSeguridadE implements java.io.Serializable{

	@Id
	@GeneratedValue
	@Column(name="IdServicioSeguridad")
	private int idServicioSeguridad;
	
	@Column(name="Descripcion")
    private String descripcion;
	
	@Column(name="Tarifa")
    private float tarifa;
	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private ProveedorE proveedor;

    public ServicioSeguridadE() {
            
    }
    

    public ServicioSeguridadE(String descripcion, float tarifa,
			ProveedorE proveedor) {
		super();
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
	}



	public ServicioSeguridadE(int idServicioSeguridad, String descripcion,
			float tarifa, ProveedorE proveedor) {
		super();
		this.idServicioSeguridad = idServicioSeguridad;
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
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
    
    

    public int getIdServicioSeguridad() {
		return idServicioSeguridad;
	}

	public void setIdServicioSeguridad(int idServicioSeguridad) {
		this.idServicioSeguridad = idServicioSeguridad;
	}

	public ProveedorE getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorE proveedor) {
		this.proveedor = proveedor;
	}

	public DTO_ServicioSeguridad toDTO() {
        DTO_ServicioSeguridad ss = new DTO_ServicioSeguridad();
        ss.setId(this.getIdServicioSeguridad());
        ss.setIdProveedor(this.getProveedor().getIdProveedor());
        ss.setDescripcion(this.getDescripcion());
        ss.setTarifa(this.getTarifa());
        return ss;
    }
}