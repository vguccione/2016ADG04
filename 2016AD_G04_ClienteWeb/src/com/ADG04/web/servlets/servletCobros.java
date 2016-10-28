package com.ADG04.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.web.controller.*;

@WebServlet(asyncSupported = true, urlPatterns = { "/servletCobros" })
public class servletCobros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public servletCobros() {
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
				if ("pagarFacturaParticular".equals(action)) {

					Integer numeroFac = Integer.parseInt(request.getParameter("txtFacturaNum"));
					Integer numeroRecibo;

					jspPage = "mostrarMensaje.jsp";
					
					numeroRecibo = BusinessDelegate.getInstancia().pagarFacturaClientePaticular(numeroFac);
					
					
					if (numeroRecibo != 0){
						request.setAttribute("mensaje", "La factura fue pagada. Se genero el Recibo de pago con el numero " + numeroRecibo);
					}
					else
					{
						request.setAttribute("mensaje", "Ha ocurrido un error con el pago de la factura");	
					}
				} else if ("pagarFacturaEmpresa".equals(action)){
					Integer numeroFac = Integer.parseInt(request.getParameter("txtFacturaNum"));
					Integer numeroRecibo;

					jspPage = "mostrarMensaje.jsp";
					
					numeroRecibo = BusinessDelegate.getInstancia().pagarFacturaClienteEmpresa(numeroFac);
					
					
					if (numeroRecibo != 0){
						request.setAttribute("mensaje", "La factura fue pagada. Se genero el Recibo de pago con el numero " + numeroRecibo);
					}
					else
					{
						request.setAttribute("mensaje", "Ha ocurrido un error con el pago de la factura");	
					}
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
