package com.ADG04.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ADG04.Controller.BusinessDelegate;

//import dto.*;

@WebServlet(asyncSupported = true, urlPatterns = { "/ServletEncomienda" })
public class ServletEncomienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEncomienda() {
        super();

    }
 
	public void init(ServletConfig config) throws ServletException {

	}
 
	public void destroy() {

	}
 
	public ServletConfig getServletConfig() {

		return null;
	}
 
	public String getServletInfo() {

		return null; 
	}
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
				if ("altaEncomiendaEmpresaEnStock".equals(action)) {
//					<!-- ID que se van a completar manual en form:
//						- idStock
//						-idEncomienda
//						-tipoEncomienda
//						-pasillo
//						-estante
//						-ubicacion
//
//						ID autom�ticos que levanta:
//						-idEncomiendaEnStock -->

/*
					dto.Encomienda.DTO_EncomiendaEnStock ees = new dto.Encomienda.DTO_EncomiendaEnStock();
					
					ees.setIdStock(Integer.parseInt((String)request.getAttribute("idStock")));
					ees.setId(Integer.parseInt((String)request.getAttribute("idEncomienda")));  
					ees.setEstante(Integer.parseInt((String)request.getAttribute("estante")));       
					ees.setPasillo(Integer.parseInt((String)request.getAttribute("pasillo")));       
					ees.setUbicacion(    (String) request.getAttribute("ubicacion"));
					
					
					int nroRecibo = BusinessDelegate.getInstancia().ingresarEncomiendaEmpresaAStock(ees);
					
					jspPage = "mostrarMensaje.jsp";
					if (nroRecibo != 0) {
						request.setAttribute("mensaje", "Se dio de alta en stock la encomienda "+request.getAttribute("idEncomienda")+".\n"
								+ "Numero de recibo:" + String.valueOf(nroRecibo));
					}else
					{
						request.setAttribute("mensaje", "No se pudo dar de alta la encomienda en stock");	
					}*/
				}else
				{
					jspPage = "mostrarMensaje.jsp";
					request.setAttribute("mensaje", "Ha ocurrido un error con la encomienda");	
				}
			}
				
			dispatch(jspPage, request, response);
		
			} catch (Exception e) {				
				request.setAttribute("mensaje", "Error: \n Descripcion:"+e.toString());
			}
	}


	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(jsp != null){
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		}
	}

 
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}

 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}

 
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}
 
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}
 
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}

}
