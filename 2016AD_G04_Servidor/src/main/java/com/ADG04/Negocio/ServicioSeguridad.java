package com.ADG04.Negocio;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.util.EntityManagerProvider;
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


	public ServicioSeguridad fromDTO(DTO_ServicioSeguridad serv) {
		ServicioSeguridad ss = new ServicioSeguridad();
		ss.setDescripcion(serv.getDescripcion());
		if(serv.getId()!=null)
			ss.setIdServicioSeguridad(serv.getId());
		ss.setTarifa(serv.getTarifa());
		ss.setProveedor(new Proveedor().fromEntity(ProveedorDao.getInstancia().getById(serv.getIdProveedor())));
		return ss;
	}
	
	public ServicioSeguridad fromEntity(ServicioSeguridadE serv) {
		ServicioSeguridad ss = new ServicioSeguridad();
		ss.setDescripcion(serv.getDescripcion());
		ss.setIdServicioSeguridad(serv.getIdServicioSeguridad());
		ss.setTarifa(serv.getTarifa());
		ss.setProveedor(new Proveedor().fromEntity(serv.getProveedor()));
		return ss;
	}

	public ServicioSeguridadE toEntity() {
        ServicioSeguridadE ss = new ServicioSeguridadE();
        ss.setIdServicioSeguridad(this.getIdServicioSeguridad());
        ss.setProveedor(this.proveedor.toEntity());
        ss.setDescripcion(this.getDescripcion());
        ss.setTarifa(this.getTarifa());
        return ss;
    }

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ServicioSeguridadDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}


	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ServicioSeguridadDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}
}