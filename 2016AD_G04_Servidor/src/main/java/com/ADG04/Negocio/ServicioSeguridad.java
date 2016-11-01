package com.ADG04.Negocio;

import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;

public class ServicioSeguridad implements java.io.Serializable{

	private int idServicioSeguridad;
    private String descripcion;
    private float tarifa;
	private Proveedor proveedor;

    public ServicioSeguridad() {
            
    }
    

    public ServicioSeguridad(String descripcion, float tarifa,
			Proveedor proveedor) {
		super();
		this.descripcion = descripcion;
		this.tarifa = tarifa;
		this.proveedor = proveedor;
	}



	public ServicioSeguridad(int idServicioSeguridad, String descripcion,
			float tarifa, Proveedor proveedor) {
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
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