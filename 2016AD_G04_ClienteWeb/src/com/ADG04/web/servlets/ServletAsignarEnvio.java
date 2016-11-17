package com.ADG04.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.sistemadistribucion.controlador.BusinessDelegate;
//import dto.Cliente.*;
//import com.fasterxml.jackson.databind.ObjectMapper;

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletAsignarEnvio" })
public class ServletAsignarEnvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletAsignarEnvio() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		
		String responseText = "";
		try{
			String action = request.getParameter("action");
			if(action.equals("asignarEnvio")){
			
				Integer idEncomienda = Integer.getInteger(request.getParameter("idEncomienda"));
				Integer idEnvio = WebBusinessDelegate.getInstancia().asignarEnvio(idEncomienda);
				responseText = "Se ha asignado el envio nro " + idEnvio.toString();
			}
		}
		catch(BusinessException ex){
			responseText = ex.getMessage();
		}
		catch(Exception ex){
			ex.printStackTrace();
			responseText = "Ha ocurrido un error al intentar asignar el envio.";
		}
		finally{
			response.setContentType("text/plain");
			response.getWriter().write(responseText);
		}
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
