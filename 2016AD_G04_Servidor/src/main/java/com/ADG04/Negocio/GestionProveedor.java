package com.ADG04.Negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.model.Proveedor;
import com.ADG04.bean.Proveedor.DTO_Proveedor;


public class GestionProveedor {

	private static GestionProveedor instancia;
	
	private EntityManagerFactory factory;
	
	private GestionProveedor(){
		
	}
	
	public static GestionProveedor getInstancia(){
		if(instancia == null){
			instancia = new GestionProveedor();
		} 
		return instancia;
	}

	
	public void altaProveedor(DTO_Proveedor proveedor) {
		Proveedor p = new Proveedor();
		p.setActivo(proveedor.getActivo());
		p.setRazonSocial(proveedor.getRazonSocial());
		p.setCuit(proveedor.getCuit());
		p.setEmail(proveedor.getEmail());
		p.setTelefono(proveedor.getTelefono());	
		
		/*if(p.getTipoProveedor().equals("T")){
			p.setTareaMantenimientoRealizadas(tareaMantenimientoRealizadas);
			p.setTipoTaller(tipoTaller);
		}*/
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProveedorDao.getInstancia().persist(p);
		tx.commit();
		
	}
	public void modificarProveedor(DTO_Proveedor proveedor){
		Proveedor p = new Proveedor();
		p.setActivo(proveedor.getActivo());
		p.setRazonSocial(proveedor.getRazonSocial());
		p.setCuit(proveedor.getCuit());
		p.setEmail(proveedor.getEmail());
		p.setTelefono(proveedor.getTelefono());	
		
		/*if(p.getTipoProveedor().equals("T")){
			p.setTareaMantenimientoRealizadas(tareaMantenimientoRealizadas);
			p.setTipoTaller(tipoTaller);
		}*/
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProveedorDao.getInstancia().saveOrUpdate(p);
		tx.commit();
	}

	public void bajaProveedor(Integer id) {
		Proveedor p = ProveedorDao.getInstancia().getById(id);
		if (p != null){
			ProveedorDao.getInstancia().remove(p);
		}
	}

	/*public DTO_Proveedor buscarProveedor(String cuit) {
		return ProveedorDao.getInstancia().buscarProveedor(cuit).toDTO();
	}
	
	public DTO_Proveedor getProveedor(Integer id) {
		return ProveedorDao.getInstancia().getById(id).toDTO();
	}*/
	

}
