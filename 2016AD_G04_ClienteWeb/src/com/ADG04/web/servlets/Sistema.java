package com.ADG04.web.servlets;

import java.io.IOException;
//import java.io.PrintWriter;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.web.controller.*;

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
					DTO_Usuario usu = WebBusinessDelegate.getInstancia().validarUsuario(request.getParameter("txtUsuario"),request.getParameter("txtPassword"));
					//DTO_Sucursal suc = BusinessDelegate.getInstancia().obtenerSucursalEmpleado(usu.getIdEmpleado());
					//Para error de logueo
					//usu = null;
					
					if (usu != null){
						Integer sucrusal = WebBusinessDelegate.getInstancia().obtenerSucursalEmpleado(usu.getId());
						
						HttpSession sesionIniciada = request.getSession();
						sesionIniciada.setAttribute("usuario", usu.getUsuario());
						sesionIniciada.setAttribute("sucursal", Integer.toString(sucrusal));
						sesionIniciada.setAttribute("sucursalNombre", WebBusinessDelegate.getInstancia().getSucursalNombre(sucrusal));
						
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
						jspPage="login.jsp";
						HttpSession sesionIniciada = request.getSession();
						sesionIniciada.setAttribute("usuario", "");					
					}
				}
			}
	
		
			dispatch(jspPage, request, response);
		
		}
		 catch (BusinessException e) {
				
				e.printStackTrace();
				
				request.setAttribute("mensaje",e.getMessage());
				dispatch("mostrarMensaje.jsp", request, response);
			}catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("mensaje",e.toString() + " - " + e.getStackTrace().toString() + " - " + e.getCause());
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
