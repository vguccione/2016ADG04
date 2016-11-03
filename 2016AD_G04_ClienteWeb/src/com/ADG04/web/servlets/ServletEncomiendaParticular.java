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

import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/serveletEncomiendaParticular" })
public class ServletEncomiendaParticular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendaParticular() {
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
				if ("altaEncomiendaParticular".equals(action)) {

					Integer idSucursal;
					String sucursalNombre;
					Integer idEncomienda;
					//idEncomienda = 0;
					String destinos = "";
					String destinoOtp = "";
					String estado = "";
					
					HttpSession sesionIntento = request.getSession();
					if(sesionIntento.getAttribute("sucursal") != null){
						
						idSucursal = Integer.parseInt((String)sesionIntento.getAttribute("sucursal"));
						sucursalNombre = WebBusinessDelegate.getInstancia().getSucursal(idSucursal).getDescripcion();
				
						DTO_EncomiendaParticular e = new DTO_EncomiendaParticular();

						DTO_Manifiesto m = new DTO_Manifiesto();
						m.addItem(new DTO_ItemManifiesto((String)request.getParameter("manifiesto")));
						e.setManifiesto(m);				
												
						DTO_Sucursal sucOrigen= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
						DTO_Sucursal sucActual= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
						DTO_Sucursal sucDestino= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalDestino")));
						//e.setId(Integer.parseInt((String)request.getParameter("idEncomienda")));
						e.setSucursalOrigen(sucOrigen);
						e.setSucursalActual(sucOrigen);
						e.setSucursalDestino(sucDestino);
						//e.setDestino(Integer.parseInt((String)request.getParameter("idDestino")));
						e.setSucursalActual(sucActual);
						e.setFechaCreacion(new Date());
						//e.setFecha(new Date());
						e.setLargo((float)Float.parseFloat((String)request.getParameter("largo")));
						e.setAlto((float)Float.parseFloat((String)request.getParameter("alto")));
						e.setAncho((float)Float.parseFloat((String)request.getParameter("ancho")));
						e.setPeso((float)Float.parseFloat((String)request.getParameter("peso")));
						e.setVolumen((float)Float.parseFloat((String)request.getParameter("ancho"))/100 * (float)Float.parseFloat((String)request.getParameter("largo"))/100 * (float)Float.parseFloat((String)request.getParameter("alto"))/100);
						e.setTratamiento((String)request.getParameter("tratamiento"));
						if(request.getParameter("Apilable").equals("true"))
							e.setApilable(true);
						else
							e.setApilable(false);

						e.setCantApilable(Short.parseShort((String)request.getParameter("cantApilable")));
						
						if(request.getParameter("Refrigerado").equals("true"))
							e.setRefrigerado(true);
						else
							e.setRefrigerado(false);

						e.setCondicionTransporte((String)request.getParameter("condicionTransporte"));
						e.setIndicacionesManipulacion((String)request.getParameter("indicacionesManipulacion"));
						e.setFragilidad((String)request.getParameter("fragilidad"));
												
						if(request.getParameter("tercerizado").equals("true"))
							e.setTercerizada(true);
						else
							e.setTercerizada(false);

						//e.setKilometrosRecorridos(0);
						//e.setFacturado(false);
						//e.setValorEstimado((float)Float.parseFloat((String)request.getParameter("valorEstimado")));
						//e.setDistanciaEstimadaKM((float)Float.parseFloat((String)request.getParameter("distanciaEstimadaKM")));

						DTO_ClienteParticular cliente = new DTO_ClienteParticular();
						
						cliente.setNombre((String)request.getParameter("nombreParticular"));
						cliente.setApellido((String)request.getParameter("apellidoParticular"));
						cliente.setDni((String)request.getParameter("dniParticular"));
						e.setCliente(cliente);
						/*e.setDireccionDestino((String)request.getParameter("direccionDestino"));
						e.setCodigoPostalDestino((String)request.getParameter("codigoPostalDestino"));
						e.setLocalidadDestino((String)request.getParameter("localidadDestino"));
						e.setProvinciaDestino((String)request.getParameter("provinciaDestino"));
						e.setPaisDestino((String)request.getParameter("paisDestino"));
						*/
						Integer factura = WebBusinessDelegate.getInstancia().nuevaEncomiedaParticular(e);

						jspPage = "mostrarMensaje.jsp";
						request.setAttribute("mensaje", "La encomienda se ha generado correctamente y se a factura con el numero: " + Integer.toString(factura));	
					
					}
					else
					{
						jspPage = "mostrarMensaje.jsp";
						request.setAttribute("mensaje", "Ha ocurrido un error con la sucursal");	
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
