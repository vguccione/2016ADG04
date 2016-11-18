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

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletGuardarEstadoEnvio" })
public class ServletGuardarEstadoEnvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletGuardarEstadoEnvio() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 		
		String responseText = "";
		
		Integer idEnvio = Integer.parseInt(request.getParameter("idEnvio"));
		String estado = request.getParameter("estado");
		
		try{
			WebBusinessDelegate.getInstancia().actualizarEstadoEnvio(idEnvio, estado);
			responseText = estado;
		}
		catch(BusinessException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
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
