package com.ADG04.Negocio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.ItemFactura;
import com.ADG04.Servidor.model.RolUsuario;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.Usuario;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
	
	public class GestionEncomienda {
	
	private static GestionEncomienda instancia;
		
	private EntityManagerFactory factory;
	
	private GestionEncomienda(){
		factory = EntityManagerProvider.getInstance().getEntityManagerFactory();
	}
	
	public static GestionEncomienda getInstancia(){
		if(instancia == null){
			instancia = new GestionEncomienda();
		} 
		return instancia;
	}

	public void altaEncomiendaParticular(DTO_ClienteParticular cliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String tratamiento, boolean apilable,
			short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor,
			String dniReceptor, Double volumenGranel, String unidadGranel,
			String cargaGranel) {
		
		//Validaciones??????????
		
		SucursalDao sucDao = SucursalDao.getInstancia();
		ClienteDao clieDao = ClienteDao.getInstancia();

		Encomienda encomienda = new Encomienda();
		encomienda.setCliente(clieDao.getByDni(cliente.getDni()));
		encomienda.setSucursalOrigen(sucDao.getById(sucursalOrigen.getId()));
		encomienda.setSucursalDestino(sucDao.getById(sucursalDestino.getId()));
		encomienda.setLargo(largo);
		encomienda.setAncho(ancho);
		
		encomienda.setAlto(alto);
		encomienda.setPeso(peso);
		encomienda.setVolumen(volumen);
		encomienda.setTratamiento(tratamiento); 
		encomienda.setApilable(apilable);
		encomienda.setCantApilable(cantApilable); 
		encomienda.setRefrigerado(refrigerado);
		encomienda.setCondicionTransporte(condiciionTransporte); 
		encomienda.setIndicacionesManipulacion(indicacionesManipulacion);
		encomienda.setFragilidad(fragilidad); 
		encomienda.setNombreReceptor(nombreReceptor); 
		encomienda.setApellidoReceptor(apellidoReceptor);
		encomienda.setDniReceptor(dniReceptor); 
		encomienda.setVolumenGranel(volumenGranel); 
		encomienda.setUnidadGranel(unidadGranel);
		encomienda.setCargaGranel(cargaGranel);		
		encomienda.setTipoEncomienda("P");
		
		encomienda.setTercerizado(this.esTercerizada(encomienda));
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		EncomiendaDao.getInstancia().persist(encomienda);
		
		// TODO
/*		DTO_Manifiesto dtoM = encomienda.getManifiesto();
		if(dtoM != null){
			Entity_Manifiesto m = new Entity_Manifiesto();
			m.setCategoria(dtoM.getCategoria());
			m.setOtro(dtoM.getOtro());
			m.setFecha(dtoM.getFecha());
			m.setDescripcion(dtoM.getDescripcion());
			m.setArchivo(dtoM.getArchivo());
			
			e.setManifiesto(m);
		}
	*/	
		
		tx.commit();
		
		
	}

	private boolean esTercerizada(Encomienda encomienda) {
		// TODO armar logica que determina si va por camion de tercero
		return false;
	}
}
