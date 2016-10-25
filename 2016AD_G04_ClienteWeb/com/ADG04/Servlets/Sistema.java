package com.ADG04.Servlets;

import java.io.IOException;
//import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Controller.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_Usuario;


@WebServlet(asyncSupported = true, urlPatterns = { "/Sistema" })
public class Sistema extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public Sistema() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 	
			String action = request.getParameter("action");
			String jspPage = "main.jsp";
				
			if ((action==null) || (action.length() < 1) )
			{
				action = "default";
			}
			else
			{
				if ("iniciarSesion".equals(action)) {
					DTO_Usuario usu = BusinessDelegate.getInstancia().validarUsuario(request.getParameter("txtUsuario"),request.getParameter("txtPassword"));
					//DTO_Sucursal suc = BusinessDelegate.getInstancia().obtenerSucursalEmpleado(usu.getIdEmpleado());
					//Para error de logueo
					//usu = null;
					
					if (usu != null){
						Integer sucrusal = BusinessDelegate.getInstancia().obtenerSucursalEmpleado(usu.getIdUsuario());
						
						HttpSession sesionIniciada = request.getSession();
						sesionIniciada.setAttribute("usuario", usu.getUsuario());
						sesionIniciada.setAttribute("sucursal", Integer.toString(sucrusal));
					//	sesionIniciada.setAttribute("sucursalNombre", suc.getDescripcion());
						
					}
					else
					{
						jspPage = "mostrarMensaje.jsp";
						request.setAttribute("mensaje", "El usuario y/o contraseña no es valido.");		
					}
				}
				else
				{
					if ("cerrarSesion".equals(action)) {
						HttpSession sesionIniciada = request.getSession();
						sesionIniciada.setAttribute("usuario", "");					
					}
				}
			}
	
		
			dispatch(jspPage, request, response);
		
		} catch (Exception e) {			
			request.setAttribute("mensaje", "Error: \n Descripcion:"+e.toString());
			dispatch("mostrarMensaje.jsp", request, response);
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
