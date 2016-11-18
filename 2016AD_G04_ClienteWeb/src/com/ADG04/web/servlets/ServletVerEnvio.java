package com.ADG04.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/ServletVerEnvio" })
public class ServletVerEnvio extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletVerEnvio() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		String jspPage = "main.jsp";
		
		if ((action==null) || (action.length() < 1) )
		{
			action = "getEnvio";
		}
		
		try {
			if(action == "getEnvio") {
				getEnvio(request);
				jspPage = "verEnvioPropio.jsp";
			}
		}
		catch(BusinessException cEx){
			cEx.printStackTrace();
			jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", cEx.getMessage());	
		}
		catch (Exception e) {
			e.printStackTrace();
			jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", "Ha ocurrido un error");
		}
		finally{
			dispatch(jspPage, request, response);
		}
	}


	private void getEnvio(HttpServletRequest request)
			throws RemoteException, Exception {
		
		//TODO: tomar de parámetro
		Integer idEnvio = Integer.parseInt(request.getParameter("idEnvio"));
		DTO_Envio e = WebBusinessDelegate.getInstancia().getEnvio(idEnvio);
		
		if(e.getClass().equals(DTO_EnvioPropio.class))
		{
			DTO_EnvioPropio ep = (DTO_EnvioPropio)e;
			request.setAttribute("fechaYHoraSalida", ep.getFechaYHoraSalida().toString());
			if(ep.getFechaYHoraLlegada() != null)
				request.setAttribute("fechaYHoraLlegada", ep.getFechaYHoraLlegada().toString());
			else
				request.setAttribute("fechaYHoraLlegada", "");
			
			request.setAttribute("idVehiculo", ep.getIdVehiculo());
			request.setAttribute("tipoEnvio", "Propio");
		}
		else{
			request.setAttribute("idVehiculo", ((DTO_EnvioTercerizado)e).getIdProveedor());
			request.setAttribute("tipoEnvio", "Tercero");
		}
		request.setAttribute("idEnvio", idEnvio);
		
		request.setAttribute("idSucursalOrigen",e.getIdSucursalOrigen());
		request.setAttribute("idSucursalDestino",e.getIdSucursalDestino());
		request.setAttribute("estadoEnvio",e.getEstado());
		
		
		
		DTO_Coordenada coordenadas = e.getPosicionActual();
		String posicionAcutal = "Latitud: " + coordenadas.getLatitud() + " - Longitud: " + coordenadas.getLongitud();
		request.setAttribute("coordenadasActuales",posicionAcutal);

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
