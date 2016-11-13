package com.ADG04.web.servlets;

import java.io.IOException;
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
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/servletEncomiendasListado" })
public class ServletVerEncomiendasParticular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletVerEncomiendasParticular() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			List<EncomiendaParticularWeb> encomiendas = new ArrayList<EncomiendaParticularWeb>();
				 
			int totalNumberOfPages = 1;
			int currentPageNumber = 1;
			int totalNumberOfRecords = 8; // All in there are 8 records in our dummy data object
			//TODO: tomar de parámetro
			int idEncomienda = 67;
			DTO_EncomiendaParticular e = WebBusinessDelegate.getInstancia().getEncomiendaParticular(idEncomienda);
			
			boolean envioAsignado = false;
			if(e.getEnvio() != null)
				envioAsignado = true;
			
			EncomiendaParticularWeb enc = new EncomiendaParticularWeb(e.getCliente().getId(), e.getIdEncomienda(), 
					e.getSucursalDestino().getId(), e.getSucursalOrigen().getId(), 
					e.getSucursalActual().getId(), e.getFechaCreacion(), e.getFechaEstimadaEntrega(), e.getEstado(), 
					e.isTercerizada(), e.getLargo(), e.getAlto(), e.getAncho(), e.getPeso(), e.getVolumen(), 
					e.getTratamiento(), e.getApilable(), e.getCantApilable(), e.getRefrigerado(), 
					e.getCondicionTransporte(), 
					e.getIndicacionesManipulacion(), e.getFragilidad(),
					e.getNombreReceptor(), e.getApellidoReceptor(), e.getDniReceptor(), 
					e.getVolumenGranel(), e.getUnidadGranel(), e.getCargaGranel(),  
					envioAsignado);
			
			response.getWriter().write(enc.getJsonString());
		}
		catch(BusinessException cEx){
			//jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", cEx.getMessage());	
		}
		catch (Exception e) {
			e.printStackTrace();
			//jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", "Ha ocurrido un error");
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
