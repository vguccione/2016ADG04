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
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/servletEnviosListado" })
public class ServletEnviosListado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEnviosListado() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
				  
			int idSucursalDestino = Integer.parseInt((request.getParameter("idSucursalDestino")));
			
			List<EnvioWeb> enviosWeb = new ArrayList<EnvioWeb>();
				 
			int totalNumberOfPages = 1;
			int currentPageNumber = 1;
				 
			List<DTO_Envio> dtoEnvios = WebBusinessDelegate.getInstancia().listarEnviosPendientesBySucursalDestino(idSucursalDestino);
			int totalNumberOfRecords = dtoEnvios.size(); 
			JqGridData<EnvioWeb> gridData = new JqGridData<EnvioWeb>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, enviosWeb);		
			
			for(DTO_Envio envioDTO:dtoEnvios){

				gridData.addItem(new EnvioWeb(envioDTO.getId(), envioDTO.getEstado(), envioDTO.getIdSucursalOrigen(), envioDTO.getIdSucursalDestino())	);
			}
			
			System.out.println("Grid Data: " + gridData.getJsonString());
			response.getWriter().write(gridData.getJsonString());
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
