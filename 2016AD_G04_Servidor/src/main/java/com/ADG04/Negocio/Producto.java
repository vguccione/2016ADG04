package com.ADG04.Negocio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ClienteEmpresaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.model.ProductoE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Cliente.DTO_Producto;

public class Producto{

	private int idProducto;
	private Cliente cliente;
	private String codigoProducto;
	private String categoria;
	private String descripcion;
	private String unidad;
	private List<ProductoEncomienda> productoEncomiendas;
	private List<ItemManifiesto> manifiestos;
	private List<ItemRemito> remitos;

	public Producto() {
	}

	public Producto(Cliente cliente, String codigoProducto,
			String descripcion, String unidad) {
		this.cliente = cliente;
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.unidad = unidad;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productoEncomiendas;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productoEncomiendas = productoEncomiendas;
	}
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<ItemManifiesto> getManifiestos() {
		return manifiestos;
	}

	public void setManifiestos(List<ItemManifiesto> manifiestos) {
		this.manifiestos = manifiestos;
	}

	public List<ItemRemito> getRemitos() {
		return remitos;
	}

	public void setRemitos(List<ItemRemito> remitos) {
		this.remitos = remitos;
	}

	public DTO_Producto toDTO(){
		DTO_Producto prod = new DTO_Producto();
		prod.setCategoria(this.categoria);
		prod.setUnidad(this.unidad);
		prod.setCodigo(this.codigoProducto);
		prod.setDescripcion(this.descripcion);
		prod.setId(this.idProducto);
		
		return prod;
	}

	public Producto fromDTO(DTO_Producto producto) {
		if(producto!=null){
			Producto prod  = new Producto();
			prod.setCategoria(producto.getCategoria());
			prod.setCliente(new ClienteEmpresa().fromEntity(ClienteEmpresaDao.getInstancia().getById(producto.getIdCliente())));
			prod.setCodigoProducto(producto.getCodigo());
			prod.setDescripcion(producto.getDescripcion());
			if(producto.getId()!=null)
				prod.setIdProducto(producto.getId());
			prod.setUnidad(producto.getUnidad());
			return prod;
		}
		else
			return null;
	}
	
	public ProductoE toEntity(){
		ProductoE prod = new ProductoE();
		prod.setCategoria(categoria);
		prod.setCliente(ClienteEmpresaDao.getInstancia().getById(cliente.getIdCliente()));
		prod.setCodigoProducto(codigoProducto);
		prod.setDescripcion(descripcion);
		prod.setUnidad(unidad);
		prod.setIdProducto(idProducto);
		return prod;
	}

	public void guardar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ProductoDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}
	
	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		ProductoDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}

	public Producto fromEntity(ProductoE producto) {
		if(producto!=null){
			Producto prod  = new Producto();
			prod.setCategoria(producto.getCategoria());
			prod.setCliente(new ClienteEmpresa().fromEntity(ClienteEmpresaDao.getInstancia().getById(producto.getCliente().getIdCliente())));
			prod.setCodigoProducto(producto.getCodigoProducto());
			prod.setDescripcion(producto.getDescripcion());
			prod.setIdProducto(producto.getIdProducto());
			producto.setUnidad(producto.getUnidad());
			return prod;
		}
		else
			return null;
	}
}
