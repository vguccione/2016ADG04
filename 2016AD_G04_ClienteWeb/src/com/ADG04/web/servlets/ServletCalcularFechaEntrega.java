package com.ADG04.web.servlets;

import java.io.IOException;
import java.util.Date;

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

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletCalcularFechaEntrega" })
public class ServletCalcularFechaEntrega extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletCalcularFechaEntrega() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sucursalOrigen = request.getParameter("idSucursalOrigen").trim();
		String sucursalDestino = request.getParameter("idSucursalDestino").trim();
		Date fecha = new Date();
		if(sucursalOrigen != null && !sucursalOrigen.isEmpty() && sucursalDestino != null && !sucursalDestino.isEmpty()){
			try {
				fecha = WebBusinessDelegate.getInstancia().calcularFechaEstimadaEntrega(sucursalOrigen, sucursalDestino);
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
								
		response.setContentType("text/plain");
		response.getWriter().write(fecha.toString());
		
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
