<%@page import="com.ADG04.bean.Encomienda.DTO_ProductoEncomienda"%>
<%@page import="com.ADG04.bean.Encomienda.DTO_ItemRemito"%>
<%@page import="com.ADG04.bean.Encomienda.DTO_ItemManifiesto"%>
<%@page import="com.ADG04.bean.Cliente.DTO_ItemFactura"%>
<%@page import="com.ADG04.bean.Cliente.DTO_Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>

<!-- Scripts -->
<script type="text/javascript">

function pagarFactura(){
	
	$.get('servletPagarFactura?action=pagarFactura&idEncomienda='+$("#nroEncomienda").val(), {
   		
   	}, 
   	function(responseText) {
   		if(responseText == "error"){
   			alert('Ha ocurrido un error.');
   		}	
   		else{
   			$("#lblPagada").text("Si");
   			$("#lblFacturaVencida").text("No");
   			$("#idPagarFactura").css("display","none");
   		}
	})
}

</script>
<!-- Timepicker -->
<script>

$(document).ready(function() {

});

</script>
 
<!-- Cuerpo -->
<body>
<div class="container" style="background-color: #E6E6E6;">
<div class="content" style="height:1300px">

<h2>Datos de la Factura:</h2>


	<div id="divFactura"> 
	
	<u><b><label style="font-style: italic;" >Factura:</label> </b></u><br/> <br/>
	
	Factura Vencida:<label id="lblFacturaVencida"><%= request.getAttribute("facturaVencida")%></label> <br/>
	<label>Fecha de Vencimiento:<%= request.getAttribute("fechaVencimiento")%></label>
	<br/>
	Pagada:<label id="lblPagada"><%= request.getAttribute("pagado")%></label> <br/> <br/>
	
	<% if(request.getAttribute("pagado").toString().equals("No")){ %>
		<input name="idPagarFactura" type="button" id="idPagarFactura" value="Pagar Factura" onclick="pagarFactura();"/><br/> <br/>		
	<%}%> 
		
	<table style="border-color: black !important; border-style: solid !important; border-width: thin !important;">
		<thead>
			<tr style="border-color: black !important; border-style: solid !important; border-width: thin !important;"> 
	            <td style="width: 100px;">Descripcion</td>
	            <td style="width: 10px;">Cantidad</td>
	            <td style="width: 10x;">Precio</td>
			</tr>
			<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10x;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DTO_ItemFactura> rows = (List<DTO_ItemFactura>)request.getAttribute("itemsFactura");
				for (int i = 0; i < rows.size(); i++) { 
					DTO_ItemFactura rowObj = rows.get(i);
	        %>
	        <tr>
	
	            <% 
	               String cantidad = ((Integer)rowObj.getCantidad()).toString(); 
	               String desc = rowObj.getDescripcion();
	               String valor = ((Float)rowObj.getValor()).toString();
	            %>
	            <td style="width: 150px;"><%=desc%></td>
	            <td style="width: 10px;"><%=cantidad%></td>
	            <td style="width: 10x;"><%=valor%></td>
	        </tr>
	        <% } %>
	    </tbody>
	    <tfoot>
	    	<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10x;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
	    	<tr style="padding-top:10px;">
	    		<td style="width: 150px;">Total:</td>
	            <td style="width: 10px;"></td>
	            <td style="width: 10x;"><%=request.getAttribute("totalFactura")%></td>
	    	</tr>
	    </tfoot>    
	</table>
</div> <!-- divFactura -->


	<li><label>Nro de encomienda: </label><input class="input-field" name="nroEncomienda" type="text" id="nroEncomienda" readonly="readonly" value='<%=request.getAttribute("nroEncomienda")%>' /></li><br/>

  <label>Datos del Cliente</label>
	<!--Sólo se ve si es Particular --> 
    
    <ul>
	<li><label>Dni: </label><input class="input-field" name="dniParticular" type="text" id="dniParticular" readonly="readonly" value='<%=request.getAttribute("dniCliente")%>' /></li><br/>
	
    <li><label>Código Sucursal de origen: </label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value='<%=request.getAttribute("idSucursalOrigen")%>'/></li><br/>
    <li><label>Código Sucursal actual: </label><input name="idSucursalActual" type="text" readonly="readonly" class="input-field" id="idSucursalActual" value='<%=request.getAttribute("idSucursalActual")%>'/></li><br/>
	<li><label>Código Sucursal de destino: </label><input name="idSucursalDestino" type="text" readonly="readonly" class="input-field" id="idSucursalDestino" value='<%=request.getAttribute("idSucursalDestino")%>' /></li><br/>

	<li><label>Estado: </label><input name="estadoEncomienda" type="text" readonly="readonly" class="input-field" id="estadoEncomienda" value='<%=request.getAttribute("estadoEncomienda")%>' /></li><br/>

 	<br/>
 	
	<li><label>Fecha de recepci&oacute;n: </label><input type="text" id="fechaRecepcion" class="input-field" readonly="readonly" value='<%=request.getAttribute("fechaCreacion")%>' ></li><br/>
    
</ul>
<br/>
       	
    <br />
   	
   	
   	
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
