package com.ADG04.Negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.TipoCliente;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

public class GestionCliente {

	private static GestionCliente instancia;
	
	private EntityManagerFactory factory;
	
	private GestionCliente(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionCliente getInstancia(){
		if(instancia == null){
			instancia = new GestionCliente();
		} 
		return instancia;
	}
	
	public void altaCliente(DTO_ClienteParticular clienteParticular) 
	{
		TipoCliente tipoCliente = this.getTipoClienteParticular();
		
		Cliente c = new Cliente();
		
		c.setNombre(clienteParticular.getNombre());
		c.setApellido(clienteParticular.getApellido());
		c.setDni(clienteParticular.getDni());
		c.setEmail(clienteParticular.getEmail());
		c.setEstado(true);
		c.setTelefono(clienteParticular.getTelefono());
		c.setTipoCliente(tipoCliente);
	
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		ClienteDao.getInstancia().persist(c);
		
		tx.commit();
		
	}
	
	private TipoCliente getTipoClienteParticular() {
		
		TipoCliente tipo = new TipoCliente();
		tipo.setIdTipoCliente(1);
		tipo.setDescripcion("Particular");
		//jjhjkh
		return tipo;
	}

	public DTO_ClienteParticular getClienteParticularByDni(String dniCliente) {
		return ClienteDao.getInstancia().getByDni(dniCliente).toDTOClienteParticualr();
	}
	
	
}
