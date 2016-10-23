package com.ADG04.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.ADG04.Controller.BusinessDelegate;
//import dto.Cliente.*;
//import com.fasterxml.jackson.databind.ObjectMapper;

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletCliente" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletCliente() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 	
		String action = request.getParameter("action");
		@SuppressWarnings("unused")
		String jspPage = "main.jsp";		
			
		if ((action==null) || (action.length() < 1) )
		{
			action = "default";
		}
		
		if ("default".equals(action))
		{
			jspPage = "main.jsp";
		}			
		else if ("altaCliente".equals(action)) {
			System.out.println("Alta cliente");

			//TODO Hacer funcionar la clase cliente
//			DTO_Cliente cliente = new dto.Cliente.DTO_Cliente();
//			
//			cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")))      ;
//			
//			cliente.setCodigoPostal(request.getParameter("codigoPostal"));
//			cliente.setCuit(request.getParameter("cuit"))                ;
//			cliente.setDireccion(request.getParameter("direccion"))      ;			
//			cliente.setLocalidad(request.getParameter("localidad"))      ;
//			cliente.setPais(request.getParameter("pais"))                ;
//			cliente.setProvincia(request.getParameter("provincia"))      ;
//			cliente.setRazonSocial(request.getParameter("razonSocial"))  ;

//			TODO Alta de cliente WEB quedan datos por guardar:
//			request.getParameter("estado") (activo inactivo)     ;
//			request.getParameter("tipoCliente")                  ;
//			setTelefono(String)                                  ;
//			setEmail(String)                                     ;
//			setCuentaCorriente(DTO_CuentaCorriente)              ;
//			cliente.setDireccionesEntrega(List<DTO_DireccionEntrega>)    ;

			
			//Altacliente devuelve boolean, si fue ok, mensaje ok, sino otro.
			//String mensaje = (BusinessDelegate.getInstancia().altaCliente(cliente))?"Alta cliente satifactoria":"Error en alta de cliente";
			request.setAttribute("mensaje", "Cliente cargado con exito" );
			request.getRequestDispatcher("altaCliente.jsp").forward(request, response);			

		}

		
		System.out.println("Dispatch al main desde servletCliente");
		//dispatch(jspPage,request, response);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
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
