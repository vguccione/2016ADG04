package com.ADG04.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.sistemadistribucion.controlador.BusinessDelegate;
//import dto.Cliente.*;
//import com.fasterxml.jackson.databind.ObjectMapper;

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletBuscarCliente" })
public class ServletBuscarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletBuscarCliente() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String action = request.getParameter("action");
		
		if(action.equals("byCuit")){
			String cuit = request.getParameter("cuit").trim();
			String razonSocial = "El cuit ingresado es incorrecto";
			if(cuit != null && !cuit.isEmpty()){
				try {
					DTO_ClienteEmpresa cli = WebBusinessDelegate.getInstancia().getClienteEmpresaByCuit(cuit);
			
					if(cli != null){
						razonSocial = cli.getRazonSocial();
					}
					else{
						razonSocial="noExiste";
					}
				} catch (Exception e) {
					e.printStackTrace();
					razonSocial = "Ha ocurrido un error." + e.getMessage();
				}
			}
									
			response.setContentType("text/plain");
			response.getWriter().write(razonSocial);
		}
		else if(action.equals("byDni")){
			String dni = request.getParameter("dni").trim();
			String nombre = "El dni ingresado es incorrecto";
			if(dni != null && !dni.isEmpty()){
				try {
					DTO_ClienteParticular cli = WebBusinessDelegate.getInstancia().getClienteParticularByDni(dni);
			
					if(cli != null){
						nombre = cli.getNombre() + " " + cli.getApellido();
					}
					else{
						nombre="noExiste";
					}
				} catch (Exception e) {
					e.printStackTrace();
					nombre = "Ha ocurrido un error." + e.getMessage();
				}
			}
									
			response.setContentType("text/plain");
			response.getWriter().write(nombre);	}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
