package com.ADG04.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;
import com.ADG04.web.controller.*;

@WebServlet(asyncSupported = true, urlPatterns = { "/ServeletEncomiendaEmpresa" })
public class ServletEncomiendaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendaEmpresa() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String jspPage = "mostrarMensaje.jsp";

		try { 	
			if("buscarCliente".equals(action)){
				String text = "some text";

			    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
			    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			    response.getWriter().write(text);       // Write response body.
				//doPost(request, response);
			}
			if ("altaEncomiendaEmpresa".equals(action)) {

				Integer idEncomienda = SaveEncomienda(request);
				
				jspPage = "mostrarMensaje.jsp";
				request.setAttribute("mensaje", "La encomienda se ha generado correctamente y con el numero: " + Integer.toString(idEncomienda));	

			}

		}
		catch(BusinessException cEx){
			cEx.printStackTrace();
			request.setAttribute("mensaje", cEx.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "Ha ocurrido un error");
		}
		finally{
			dispatch(jspPage, request, response);
		}
	}


	private Integer SaveEncomienda(HttpServletRequest request)
			throws RemoteException, BusinessException, Exception {
		DTO_EncomiendaEmpresa e = new DTO_EncomiendaEmpresa();
							
		//m.setDescripcion((String)request.getParameter("manifiesto"));
		
		//Integer idManifiesto = WebBusinessDelegate.getInstancia().altaManifiesto(m);
		
		//e.setIdManifiesto(idManifiesto);
//		String FechaRecepcion = (String)request.getParameter("fechaRecepcion");
//	FechaRecepcion = FechaRecepcion.split("/")[2]+"-"+FechaRecepcion.split("/")[0]+"-"+FechaRecepcion.split("/")[1];
//	String FechaMaxima = (String)request.getParameter("fechaMaxima");
//	FechaMaxima = FechaMaxima.split("/")[2]+"-"+FechaMaxima.split("/")[0]+"-"+FechaMaxima.split("/")[1];

		DTO_Sucursal sucOrigen= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
		DTO_Sucursal sucActual= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
		DTO_Sucursal sucDestino= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalDestino")));
		e.setSucursalOrigen(sucOrigen);
		e.setSucursalActual(sucOrigen);
		e.setSucursalDestino(sucDestino);
		e.setFechaCreacion(new Date());
		
		e.setLargo((float)Float.parseFloat((String)request.getParameter("largo")));
		e.setAlto((float)Float.parseFloat((String)request.getParameter("alto")));
		e.setAncho((float)Float.parseFloat((String)request.getParameter("ancho")));
		e.setPeso((float)Float.parseFloat((String)request.getParameter("peso")));
		e.setVolumen((float)Float.parseFloat((String)request.getParameter("ancho"))/100 * (float)Float.parseFloat((String)request.getParameter("largo"))/100 * (float)Float.parseFloat((String)request.getParameter("alto"))/100);
		e.setTratamiento((String)request.getParameter("tratamiento"));
		if(request.getParameter("Apilable").equals("true")){
			e.setApilable(true);
			e.setCantApilable(Short.parseShort((String)request.getParameter("cantApilable")));
		}
		else{
			e.setApilable(false);
		}
		
		if(request.getParameter("Refrigerado").equals("true"))
			e.setRefrigerado(true);
		else
			e.setRefrigerado(false);
		
		e.setCondicionTransporte((String)request.getParameter("condicionTransporte"));
		e.setIndicacionesManipulacion((String)request.getParameter("indicacionesManipulacion"));
		e.setFragilidad((String)request.getParameter("fragilidad"));
		
		DTO_ClienteEmpresa cliente = new DTO_ClienteEmpresa();
		cliente.setCuit(((String)request.getParameter("cuitEmpresa")));
		e.setCliente(cliente);
		
		//e.setIdDireccionEntrega(Integer.parseInt((String)request.getParameter("idDireccionEntrega")));
		/*
		if(request.getParameter("tercerizado").equals("true"))
			e.setTercerizada(true);
		else
			e.setTercerizada(false);*/
		
		//e.setKilometrosRecorridos(0);
		//e.setFacturado(false);
		//e.setValorEstimado((float)Float.parseFloat((String)request.getParameter("valorEstimado")));
		//e.setDistanciaEstimadaKM((float)Float.parseFloat((String)request.getParameter("distanciaEstimadaKM")));
		
		//Integer factura = WebBusinessDelegate.getInstancia().confirmarEncomiendaEmpresa(e);

		//No hay receptor en una encmienda empresa
		e.setDniReceptor((String)request.getParameter("dniReceptor"));
		e.setNombreReceptor((String)request.getParameter("nombreReceptor"));
		e.setApellidoReceptor((String)request.getParameter("apellidoReceptor"));
		
		DTO_Manifiesto m = new DTO_Manifiesto();
		
		//agrego los productos, y los productos al manifiesto.
		if(!request.getParameter("producto1").isEmpty() && !request.getParameter("producto1cantidad").isEmpty()){
			Integer prodId = Integer.parseInt(((String)request.getParameter("producto1")));
			Integer cantidad = Integer.parseInt(((String)request.getParameter("producto1cantidad")));
			e.addProducto(new DTO_ProductoEncomienda(cantidad, prodId));
			m.addItem(new DTO_ItemManifiesto("Proudcto " + prodId.toString() + " - Cantidad " + cantidad.toString(), prodId, cantidad));
		}
		if(!request.getParameter("producto2").isEmpty() && !request.getParameter("producto2cantidad").isEmpty()){
			Integer prodId = Integer.parseInt(((String)request.getParameter("producto2")));
			Integer cantidad = Integer.parseInt(((String)request.getParameter("producto2cantidad")));
			e.addProducto(new DTO_ProductoEncomienda(cantidad, prodId));
			m.addItem(new DTO_ItemManifiesto("Proudcto " + prodId.toString() + " - Cantidad " + cantidad.toString(), prodId, cantidad));
		}
		if(!request.getParameter("producto3").isEmpty() && !request.getParameter("producto3cantidad").isEmpty()){
			Integer prodId = Integer.parseInt(((String)request.getParameter("producto3")));
			Integer cantidad = Integer.parseInt(((String)request.getParameter("producto3cantidad")));
			e.addProducto(new DTO_ProductoEncomienda(cantidad, prodId));
			m.addItem(new DTO_ItemManifiesto("Proudcto " + prodId.toString() + " - Cantidad " + cantidad.toString(), prodId, cantidad));
		}
		if(!request.getParameter("producto4").isEmpty() && !request.getParameter("producto4cantidad").isEmpty()){
			Integer prodId = Integer.parseInt(((String)request.getParameter("producto4")));
			Integer cantidad = Integer.parseInt(((String)request.getParameter("producto4cantidad")));
			e.addProducto(new DTO_ProductoEncomienda(cantidad, prodId));
			m.addItem(new DTO_ItemManifiesto("Proudcto " + prodId.toString() + " - Cantidad " + cantidad.toString(), prodId, cantidad));
		}
		if(!request.getParameter("producto5").isEmpty() && !request.getParameter("producto5cantidad").isEmpty()){
			Integer prodId = Integer.parseInt(((String)request.getParameter("producto5")));
			Integer cantidad = Integer.parseInt(((String)request.getParameter("producto5cantidad")));
			e.addProducto(new DTO_ProductoEncomienda(cantidad, prodId));
			m.addItem(new DTO_ItemManifiesto("Proudcto " + prodId.toString() + " - Cantidad " + cantidad.toString(), prodId, cantidad));
		}
		
		if(e.getProductos().isEmpty())
			throw new BusinessException("Debe agregar los productos a enviar");
		
		e.setManifiesto(m);
		
		Integer idEncomienda = WebBusinessDelegate.getInstancia().nuevaEncomiedaEmpresa(e);
		return idEncomienda;
	}
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(jsp != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
}
