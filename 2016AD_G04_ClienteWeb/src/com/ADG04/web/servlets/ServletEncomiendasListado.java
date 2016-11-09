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
public class ServletEncomiendasListado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendasListado() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//String postcode = request.getParameter("type") ;
		//if(postcode == null || postcode.trim().length() == 0) postcode = "BS21 7RH";
		//System.out.println("Type: " + postcode);
			  
		List<EncomiendaWeb> encomiendas = new ArrayList<EncomiendaWeb>();
			 
		int totalNumberOfPages = 1;
		int currentPageNumber = 1;
		int totalNumberOfRecords = 8; // All in there are 8 records in our dummy data object
			 
		JqGridData<EncomiendaWeb> gridData = new JqGridData<EncomiendaWeb>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, encomiendas);
		gridData.addItem(new EncomiendaWeb(1, 1, true));
		gridData.addItem(new EncomiendaWeb(2, 2, false));
		gridData.addItem(new EncomiendaWeb(3, 3, true));
		System.out.println("Grid Data: " + gridData.getJsonString());
		response.getWriter().write(gridData.getJsonString());

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
