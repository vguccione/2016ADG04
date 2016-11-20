package com.ADG04.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.sistemadistribucion.controlador.BusinessDelegate;
//import dto.Cliente.*;
//import com.fasterxml.jackson.databind.ObjectMapper;

 
@WebServlet(asyncSupported = true, urlPatterns = { "/servletPagarFactura" })
public class ServletPagarFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletPagarFactura() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action").toString();
		
		if(action.equals("getFactura")){
			getFactura(request, response);
		}
		else if(action.equals("pagarFactura")){
			pagarFactura(request, response);							
		}
	}

	private void pagarFactura(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int idEncomienda = Integer.parseInt(request.getParameter("idEncomienda"));
		String responseText = "";
		try{
			WebBusinessDelegate.getInstancia().pagarFactura(idEncomienda);
		}
		catch(Exception e){
			e.printStackTrace();
			responseText = e.getMessage();
		}
		
		response.setContentType("text/plain");
		response.getWriter().write(responseText);
	}

	private void getFactura(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			getFactura(request);
			dispatch("verFactura.jsp", request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(jsp != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
	private void getFactura(HttpServletRequest request) throws RemoteException, Exception {
		
		int idEncomienda = Integer.parseInt(request.getParameter("idEncomienda"));
		DTO_Encomienda e = null;
		e = WebBusinessDelegate.getInstancia().getEncomiendaParticular(idEncomienda);
		
		if(e != null)
		{
			e = (DTO_EncomiendaParticular)e;
			request.setAttribute("nroEncomienda", idEncomienda );
			request.setAttribute("estadoEncomienda", e.getEstado());
					
			DTO_ClienteParticular cli = WebBusinessDelegate.getInstancia().getClienteParticularById(e.getCliente().getId());
			
			request.setAttribute("dniCliente", cli.getDni() );
			request.setAttribute("idSucursalOrigen",e.getSucursalOrigen().getId().toString());
			request.setAttribute("idSucursalDestino",e.getSucursalDestino().getId().toString());
			request.setAttribute("idSucursalActual", "");
			if(e.getSucursalActual() != null)
				request.setAttribute("idSucursalActual", e.getSucursalActual().getId().toString());
			
			request.setAttribute("fechaCreacion",e.getFechaEstimadaEntrega().toString());
			request.setAttribute("estado", (String) e.getEstado());
					
			//Ver factura
			DTO_Factura factura = WebBusinessDelegate.getInstancia().getFacturaById(e.getFactura().getId());
			if(factura != null){
				request.setAttribute("idFactura",factura.getId().toString());
				if(factura.estaVencida())
					request.setAttribute("facturaVencida","Si");
				else
					request.setAttribute("facturaVencida","No");
				
				if(factura.isPagado())
					request.setAttribute("pagado","Si");
				else
					request.setAttribute("pagado","No");
								
				request.setAttribute("fechaVencimiento",factura.getFechaVencimiento().toString());
				
				Float total = getTotal(factura.getItems());
				request.setAttribute("totalFactura", total.toString());
				
				if(factura.getItems() != null){
					request.setAttribute("itemsFactura",factura.getItems());
				}
				else{
					request.setAttribute("itemsFactura",new ArrayList<DTO_ItemFactura>());
				}
							
			}
		}
		else{

			e = WebBusinessDelegate.getInstancia().getEncomiendaEmpresa(idEncomienda);
			
			if(e != null)
			{
				e = (DTO_EncomiendaEmpresa)e;
				request.setAttribute("nroEncomienda", idEncomienda );
				request.setAttribute("estadoEncomienda", e.getEstado());
						
				DTO_ClienteEmpresa cli = WebBusinessDelegate.getInstancia().getClienteEmpresaById(e.getCliente().getId());
				
				request.setAttribute("dniCliente", cli.getCuit() );
				request.setAttribute("idSucursalOrigen",e.getSucursalOrigen().getId().toString());
				request.setAttribute("idSucursalDestino",e.getSucursalDestino().getId().toString());
				request.setAttribute("idSucursalActual", "");
				if(e.getSucursalActual() != null)
					request.setAttribute("idSucursalActual", e.getSucursalActual().getId().toString());
				
				request.setAttribute("fechaCreacion",e.getFechaEstimadaEntrega().toString());
				request.setAttribute("estado", (String) e.getEstado());
						
				//Ver factura
				DTO_Factura factura = WebBusinessDelegate.getInstancia().getFacturaById(e.getFactura().getId());
				if(factura != null){
					request.setAttribute("idFactura",factura.getId().toString());
					if(factura.estaVencida())
						request.setAttribute("facturaVencida","Si");
					else
						request.setAttribute("facturaVencida","No");
					
					if(factura.isPagado())
						request.setAttribute("pagado","Si");
					else
						request.setAttribute("pagado","No");
									
					request.setAttribute("fechaVencimiento",factura.getFechaVencimiento().toString());
					
					Float total = getTotal(factura.getItems());
					request.setAttribute("totalFactura", total.toString());		
					if(factura.getItems() != null){
						request.setAttribute("itemsFactura",factura.getItems());
					}
					else{
						request.setAttribute("itemsFactura",new ArrayList<DTO_ItemFactura>());
					}
					
				}
			}

		}
	}


	private Float getTotal(List<DTO_ItemFactura> items) {
		
		Float total = 0f;
		if(items != null){
			for(DTO_ItemFactura item:items){
				total += item.getValor()* ((Integer)item.getCantidad()).floatValue();
			}
		}
		
		return total;
	}

}
