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
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.ClienteEmpresa;
import com.ADG04.Servidor.model.ClienteParticular;
import com.ADG04.Servidor.model.CuentaCorriente;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Factura;
import com.ADG04.Servidor.model.ItemFactura;
import com.ADG04.Servidor.model.Producto;
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
	
	public void altaClienteParticular(DTO_ClienteParticular clienteParticular) 
	{
		ClienteParticular c = new ClienteParticular();
		
		c.setNombre(clienteParticular.getNombre());
		c.setApellido(clienteParticular.getApellido());
		c.setDni(clienteParticular.getDni());
		c.setEmail(clienteParticular.getEmail());
		c.setEstado(true);
		c.setTelefono(clienteParticular.getTelefono());
	
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(clienteParticular.getDireccion());
		c.setDireccion(dir);
		ClienteDao.getInstancia().persist(c);
		
		tx.commit();
		
	}
	
	public void modificarClienteParticular(DTO_ClienteParticular clienteParticular) {
		ClienteParticular c = new ClienteParticular();
		
		c.setIdCliente(clienteParticular.getId());
		c.setNombre(clienteParticular.getNombre());
		c.setApellido(clienteParticular.getApellido());
		c.setDni(clienteParticular.getDni());
		c.setEmail(clienteParticular.getEmail());
		c.setEstado(true);
		c.setTelefono(clienteParticular.getTelefono());
	
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(clienteParticular.getDireccion());
		c.setDireccion(dir);
		ClienteDao.getInstancia().saveOrUpdate(c);
		
		tx.commit();
	}
	
	public void altaClienteEmpresa(DTO_ClienteEmpresa clienteEmpresa) 
	{
		ClienteEmpresa c = new ClienteEmpresa();
		
		c.setCuit(clienteEmpresa.getCuit());
		c.setEmail(clienteEmpresa.getEmail());
		c.setRazonSocial(clienteEmpresa.getRazonSocial());
		c.setEstado(clienteEmpresa.isEstado());
		c.setTelefono(clienteEmpresa.getTelefono());
		
		CuentaCorriente cc = new CuentaCorriente();
		cc.setLimiteCredito(clienteEmpresa.getCuentaCorriente().getLimiteCredito());
		cc.setCredito(clienteEmpresa.getCuentaCorriente().getCredito());
		cc.setFormaPago(clienteEmpresa.getCuentaCorriente().getFormaPago());
		
		c.setCuentaCorrientes(cc);
		
		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(clienteEmpresa.getDireccion());
		c.setDireccion(dir);
		
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		ClienteDao.getInstancia().persist(c);
	
		tx.commit();
	
	}
	
	public void modificarClienteEmpresa(DTO_ClienteEmpresa clienteEmpresa) {
		ClienteEmpresa c = new ClienteEmpresa();
		
		c.setIdCliente(clienteEmpresa.getId());
		c.setCuit(clienteEmpresa.getCuit());
		c.setEmail(clienteEmpresa.getEmail());
		c.setRazonSocial(clienteEmpresa.getRazonSocial());
		c.setEstado(clienteEmpresa.isEstado());
		c.setTelefono(clienteEmpresa.getTelefono());
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Direccion dir = GestionAdministracion.getInstancia().crearDireccion(clienteEmpresa.getDireccion());
		c.setDireccion(dir);
		ClienteDao.getInstancia().saveOrUpdate(c);
		
		tx.commit();
	}
	
	public void eliminarCliente(Integer idCliente){
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Cliente c = ClienteDao.getInstancia().getById(idCliente);
		
		if (c != null)
			ClienteDao.getInstancia().remove(c); 
		
		tx.commit();
	}
	
	public List<DTO_Cliente> getClientes(){
		List<Cliente> clientes = ClienteDao.getInstancia().getAll();
		List<DTO_Cliente> clientesDTO = new ArrayList<DTO_Cliente>();
		for(Cliente cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
	}
	
	public List<DTO_ClienteParticular> getClientesParticular(){
		List<ClienteParticular> clientes = ClienteParticularDao.getInstancia().listarClientes();
		List<DTO_ClienteParticular> clientesDTO = new ArrayList<DTO_ClienteParticular>();
		for(ClienteParticular cliente : clientes){
			clientesDTO.add(cliente.toDTO());
		}
		return clientesDTO;
	}
	
	public List<DTO_ClienteEmpresa> getClientesEmpresa(){
		List<ClienteEmpresa> clientes = ClienteEmpresaDao.getInstancia().listarClientes();
		List<DTO_ClienteEmpresa> clientesDTO = new ArrayList<DTO_ClienteEmpresa>();
		for(ClienteEmpresa cliente : clientes){
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

		Producto p = new Producto();
		
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
		Producto p = new Producto();
		
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
		
		Producto p = ProductoDao.getInstancia().getById(idProducto);
		
		if (p != null)
			ProductoDao.getInstancia().remove(p); 
		
		tx.commit();
	}
	
	public void eliminarProducto(Integer idCliente, String codigoProducto){
		EntityManager em = factory.createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		DTO_Producto prod= ProductoDao.getInstancia().getByClienteCodigo(idCliente, codigoProducto).toDTO();
		
		Producto p = ProductoDao.getInstancia().getById(prod.getId());
		
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
		CuentaCorriente cc  = CuentaCorrienteDao.getInstancia().getById(factura.getIdCuentaCorriente());
		Factura fc = new Factura();

		List<ItemFactura> detalleFactura = new ArrayList<ItemFactura>();
		for(DTO_ItemFactura it: factura.getItems()){
			ItemFactura item = new ItemFactura();
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
		CuentaCorriente cc  = CuentaCorrienteDao.getInstancia().getById(factura.getIdCuentaCorriente());
		Factura fc = new Factura();

		List<ItemFactura> detalleFactura = new ArrayList<ItemFactura>();
		for(DTO_ItemFactura it: factura.getItems()){
			ItemFactura item = new ItemFactura();
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
		List<Factura> facturas = FacturaDao.getInstancia().getAll();
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(Factura factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}
	
	public List<DTO_Factura> listarFacturasClientePendientes(Integer idCliente){
		List<Factura> facturas = FacturaDao.getInstancia().listarFacturasClientePendientes(idCliente);
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(Factura factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}
	
	public List<DTO_Factura> listarFacturasCliente(Integer idCliente){
		List<Factura> facturas = FacturaDao.getInstancia().listarFacturasCliente(idCliente);
		List<DTO_Factura> facturasDTO = new ArrayList<DTO_Factura>();
		for(Factura factura : facturas){
			facturasDTO.add(factura.toDTO());
		}
		return facturasDTO;
	}

	
}
