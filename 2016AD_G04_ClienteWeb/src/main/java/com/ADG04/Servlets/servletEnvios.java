package com.ADG04.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Controller.BusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/servletEnvios" })
public class servletEnvios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public servletEnvios() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 	
			String action = request.getParameter("action");
			String jspPage = "mostrarMensaje.jsp";
				
			if ((action==null) || (action.length() < 1) )
			{
				action = "default";
			}
			else
			{
				if ("ingresarEncomiendaStockEnvio".equals(action)) {

					Integer idStock = Integer.parseInt(request.getParameter("idStock"));
					Integer idEnvio = Integer.parseInt(request.getParameter("idEnvio"));

					jspPage = "mostrarMensaje.jsp";
					
					//boolean flag = BusinessDelegate.getInstancia().ingresarEncomiendaStockEnvio(idEnvio, idStock);
					
					//if (flag)
						//request.setAttribute("mensaje", "Se ha ingresado las encomiendas del envio: " + idEnvio);	
					//else
						//request.setAttribute("mensaje", "Hubo un problema al ingresar las encomiendas del envio: " + idEnvio);	

				} else if ("egresarEncomiendaStockEnvio".equals(action)){
					
					Integer idStock = Integer.parseInt(request.getParameter("idStock"));
					Integer idEnvio = Integer.parseInt(request.getParameter("idEnvio"));

					jspPage = "mostrarMensaje.jsp";
					/*
					boolean flag = BusinessDelegate.getInstancia().egresarEncomiendaStockEnvio(idEnvio, idStock);
					
					if (flag)
						request.setAttribute("mensaje", "Se ha egresado las encomiendas del envio: " + idEnvio);	
					else
						request.setAttribute("mensaje", "Hubo un problema al egresar las encomiendas del envio: " + idEnvio);*/
				}
				else
				{
					if ("XXXX".equals(action)) {
						HttpSession sesionIniciada = request.getSession();
						sesionIniciada.setAttribute("usuario", "");					
					}
				}
			}
	
		
			dispatch(jspPage, request, response);
		
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
