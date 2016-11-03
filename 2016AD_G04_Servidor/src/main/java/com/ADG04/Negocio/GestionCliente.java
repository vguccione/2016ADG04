package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.List;








import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.CuentaCorrienteDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.CuentaCorrienteE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.FacturaE;
import com.ADG04.Servidor.model.ItemFacturaE;
import com.ADG04.Servidor.model.ProductoE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Cliente.DTO_Producto;


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
	
	public void eliminarCliente(Integer idCliente){
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ClienteE c = ClienteDao.getInstancia().getById(idCliente);
		
		if (c != null)
			ClienteDao.getInstancia().remove(c); 
		
		tx.commit();
	}
	
	public List<DTO_Cliente> getClientes(){
		List<ClienteE> clientes = ClienteDao.getInstancia().getAll();
		List<DTO_Cliente> clientesDTO = new ArrayList<DTO_Cliente>();
		for(ClienteE cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
	}
	
	public List<DTO_ClienteParticular> getClientesParticular(){
		List<ClienteParticularE> clientes = ClienteParticularDao.getInstancia().listarClientes();
		List<DTO_ClienteParticular> clientesDTO = new ArrayList<DTO_ClienteParticular>();
		for(ClienteParticularE cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
	}
	
	public List<DTO_ClienteEmpresa> getClientesEmpresa(){
		List<ClienteEmpresaE> clientes = ClienteEmpresaDao.getInstancia().listarClientes();
		List<DTO_ClienteEmpresa> clientesDTO = new ArrayList<DTO_ClienteEmpresa>();
		for(ClienteEmpresaE cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
	}
	
	
	public DTO_ClienteParticular getClienteParticularByDni(String dniCliente) {
		return ClienteParticularDao.getInstancia().getByDni(dniCliente).toDTO();
	}
	
	
	public DTO_ClienteParticular getClienteParticularById(Integer idCliente){
		return ClienteParticularDao.getInstancia().getById(idCliente).toDTO();
	}
	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente){
		return ClienteEmpresaDao.getInstancia().getById(idCliente).toDTO();
	}
	
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit){
		return ClienteEmpresaDao.getInstancia().getByCuit(cuit).toDTO();
	}
	
	public void altaProducto(DTO_Producto producto){

		ProductoE p = new ProductoE();
		
		p.setCliente(ClienteDao.getInstancia().getById(producto.getIdCliente()));
		p.setCodigoProducto(producto.getCodigo());
		p.setDescripcion(producto.getDescripcion());
		p.setUnidad(producto.getUnidad());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProductoDao.getInstancia().persist(p);
		
		tx.commit();
	}
	
	public void modificarProducto(DTO_Producto producto){
		ProductoE p = new ProductoE();
		
		p.setCliente(ClienteDao.getInstancia().getById(producto.getIdCliente()));
		p.setCodigoProducto(producto.getCodigo());
		p.setDescripcion(producto.getDescripcion());
		p.setUnidad(producto.getUnidad());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProductoDao.getInstancia().saveOrUpdate(p);
		
		tx.commit();
	}
	public void eliminarProducto(Integer idProducto){
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ProductoE p = ProductoDao.getInstancia().getById(idProducto);
		
		if (p != null)
			ProductoDao.getInstancia().remove(p); 
		
		tx.commit();
	}
	
	public void eliminarProducto(Integer idCliente, String codigoProducto){
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		DTO_Producto prod= ProductoDao.getInstancia().getByClienteCodigo(idCliente, codigoProducto).toDTO();
		
		ProductoE p = ProductoDao.getInstancia().getById(prod.getId());
		
		if (p != null)
			ProductoDao.getInstancia().remove(p); 
		
		tx.commit();
	}
	
	public DTO_Producto getProducto(Integer idProducto){
		return ProductoDao.getInstancia().getById(idProducto).toDTO();
		
	}
	
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto){
		return ProductoDao.getInstancia().getByClienteCodigo(idCliente, codigoProducto).toDTO();
		
	}
	
	
	/*Factura*/
	public void altaFactura(DTO_Factura factura){
		CuentaCorrienteE cc  = CuentaCorrienteDao.getInstancia().getById(factura.getIdCuentaCorriente());
		FacturaE fc = new FacturaE();

		List<ItemFacturaE> detalleFactura = new ArrayList<ItemFacturaE>();
		for(DTO_ItemFactura it: factura.getItems()){
			ItemFacturaE item = new ItemFacturaE();
			item.setCantidad(it.getCantidad());
			item.setDescripcion(it.getDescripcion());
			item.setValor(it.getValor());
			
			detalleFactura.add(item);
		}
		fc.setItemsFactura(detalleFactura);
		
		fc.setCuentaCorriente(cc);
		fc.setFecha(factura.getFecha());
		fc.setFechaVencimiento(factura.getFechaVencimiento());
		fc.setPagada(false);
		fc.setTipoFactura(factura.getTipo());
		
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		FacturaDao.getInstancia().persist(fc);
		tx.commit();
	}
	public void modificarFacturaCliente(DTO_Factura factura){
		CuentaCorrienteE cc  = CuentaCorrienteDao.getInstancia().getById(factura.getIdCuentaCorriente());
		FacturaE fc = new FacturaE();

		List<ItemFacturaE> detalleFactura = new ArrayList<ItemFacturaE>();
		for(DTO_ItemFactura it: factura.getItems()){
			ItemFacturaE item = new ItemFacturaE();
			item.setCantidad(it.getCantidad());
			item.setDescripcion(it.getDescripcion());
			item.setValor(it.getValor());
			
			detalleFactura.add(item);
		}
		fc.setItemsFactura(detalleFactura);
		
		fc.setIdFactura(factura.getId());
		fc.setCuentaCorriente(cc);
		fc.setFecha(factura.getFecha());
		fc.setFechaVencimiento(factura.getFechaVencimiento());
		fc.setPagada(false);
		fc.setTipoFactura(factura.getTipo());
		
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		FacturaDao.getInstancia().saveOrUpdate(fc);
		tx.commit();
	}
	
	public DTO_Factura getFacturaCliente(Integer idCliente){
		return FacturaDao.getInstancia().getFacturaCliente(idCliente).toDTO();
	}
	
	public List<DTO_Factura> listarFacturas(){
		List<FacturaE> facturas = FacturaDao.getInstancia().getAll();
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(FacturaE factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}
	
	public List<DTO_Factura> listarFacturasClientePendientes(Integer idCliente){
		List<FacturaE> facturas = FacturaDao.getInstancia().listarFacturasClientePendientes(idCliente);
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(FacturaE factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}
	
	public List<DTO_Factura> listarFacturasCliente(Integer idCliente){
		List<FacturaE> facturas = FacturaDao.getInstancia().listarFacturasCliente(idCliente);
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(FacturaE factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}

	
}
