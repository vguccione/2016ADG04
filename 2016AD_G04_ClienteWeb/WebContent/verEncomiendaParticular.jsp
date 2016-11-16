<%@page import="com.ADG04.bean.Cliente.DTO_ItemFactura"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>

<!-- Declaraciones -->
<%
    String encomienda;
    String destinos;
    String estado;
	
	encomienda = "0";
	destinos = "";
	encomienda = (String)request.getAttribute("idEncomienda");
	destinos = (String)request.getAttribute("destinos");
//	sucursalNombre = (String)request.getAttribute("sucursalNombre");
	estado = (String)request.getAttribute("estado");
%>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	  
  	  var encomienda = <%= '"' + encomienda + '"'%>
  	  var estado = <%= '"' + estado + '"'%>

	  $("#diasEntrega").datepicker();
	  $("#fechaRecepcion").datepicker();
	  $("#fechaMaxima" ).datepicker();
	  $("#fechaRetiro" ).datepicker();
	  $("#fechaEstimada" ).datepicker();
	  $("#fechaRetiropartic" ).datepicker();
	   
}); //document ready


</script>
<!-- Timepicker -->
<script>

$(document).ready(function() {

// 	var idEncomienda = 67;//
//     $.get('servletBuscarEncomienda?action=byId', {
//     		idEncomienda : idEncomienda
//     	}, 
//     	function(responseText) {
//     		if(responseText == "noExiste"){
//     			alert('La encomienda no existe');
//     		}
//     		else{
//         		//$("#dniParticular").val(dniParticular);
//         		//$("#razonSocialTxt").val(responseText);
//         		//$("#altaEncomiendaForm").css("display", "block");
//         		/*
// 		    	$("#dniParticular").val(dniParticular);
// 				$("#idSucursalOrigen").val(idSucursalOrigen);
// 				$("#idSucursalDestino").val(idSucursalDestino);
// 				$("#fechaRecepcion").val(fechaRecepcion);
// 			 	$("#largo").val(largo);
// 			    $("#alto").val(alto);
// 			    $("#ancho").val(ancho);
// 			 	$("#peso").val(peso);
// 			    $("#tratamiento").val(tratamiento);
// 				$("#Apilable").val(Apilable);
// 			 	$("#cantApilable").val(cantApilable);
// 				$("#Refrigerado").val(Refrigerado);
// 				$("#condicionTransporte").val(condicionTransporte);
// 				$("#indicacionesManipulacion").val(indicacionesManipulacion);
// 				$("#fragilidad").val(fragilidad);
// 				$("#tercerizado").val(tercerizado);
// 			    $("#dniReceptor").val(dniReceptor);
// 				$("#nombreReceptor").val(nombreReceptor);
// 				$("#apellidoReceptor").val(apellidoReceptor);
// 				*/
//         		alert(responseText);
//         		console.log(responseText);
//     		}
//     	}
//     );

});

	$(function() {
    	$('#horaMinima').timepicker();
		$('#horaMaxima').timepicker();
	 	$("#horaMinimaPartic" ).datepicker();
	 	$("#horaMaximaPartic" ).datepicker();
	});
</script>
 
<!-- Cuerpo -->
<body>
<div class="container" style="background-color: #E6E6E6;">>
    <div class="content">

<h2>Encomienda Particular:</h2>

  <label>Datos del Cliente</label>
	<!--Sólo se ve si es Particular --> 
    
    <ul>
	<li><label>Dni:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" readonly="readonly" value='<%=request.getAttribute("dniCliente")%>' /></li><br/>
	
    <li><label>Código Sucursal de origen:</label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value='<%=request.getAttribute("idSucursalOrigen")%>'/></li><br/>
	<li><label>Código Sucursal de destino:</label><input name="idSucursalDestino" type="text" readonly="readonly" class="input-field" id="idSucursalDestino" value='<%=request.getAttribute("idSucursalDestino")%>' /></li><br/>
	
 	<br/>
 	
	<li><label>Fecha de recepci&oacute;n:</label><input type="date" id="fechaRecepcion" class="datepicker" readonly="readonly" value='<%=request.getAttribute("fechaCreacion")%>' ></li><br/>
 	<li><label>Ancho (cm):</label><input class="input-field" name="largo" type="text" id="largo" size="18" readonly="readonly" value='<%=request.getAttribute("largo")%>' /></li><br/>
    <li><label>Alto (cm):</label><input class="input-field" name="alto" type="text" id="alto" size="18" readonly="readonly" value='<%=request.getAttribute("alto")%>' /></li><br/>
    <li><label>Profundidad (cm):</label><input class="input-field" name="ancho" type="text" id="ancho" size="18" readonly="readonly" value='<%=request.getAttribute("ancho")%>' /></li><br/>
 	<li><label>Peso (kg):</label><input class="input-field" name="peso" type="text" id="peso" size="18" readonly="readonly" value='<%=request.getAttribute("peso")%>' /></li><br/>
    <li><label>Tratamiento:</label><input class="input-field" name="tratamiento" type="text" id="tratamiento" value="" maxlength="50" readonly="readonly" value='<%=request.getAttribute("tratamiento")%>' /></li><br/>
 	<li><label>Apilable:</label> <input class="input-field" name="apilable" type="text" id="apilable" value="" maxlength="50" readonly="readonly" value='<%=request.getAttribute("apilable")%>' /></li><br/>
    <br/><li><label>Cantidad Apilable:</label><input class="input-field" name="cantApilable" type="text" id="cantApilable" size="10" readonly="readonly" value='<%=request.getAttribute("cantApilable")%>' /></li>
 	<br/><li><label>Refrigerado:</label><input class="input-field" name="refrigerado" type="text" id="cantApilable" size="10" readonly="readonly" value='<%=request.getAttribute("refrigerado")%>' />
	<br/><li><label>Condición de transporte</label><input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" readonly="readonly" value='<%=request.getAttribute("condicionTransporte")%>'  /></li>
<br/>	<li><label>Indicaciones de manipulaci&oacute;n:</label><input class="input-field" name="" type="text" id="indicacionesManipulacion" maxlength="400" readonly="readonly" value='<%=request.getAttribute("indicacionesManipulacion")%>' /></li>      
	<br/><li><label>Fragilidad:</label><input class="input-field" name="" type="text" id="fragilidad" maxlength="20" readonly="readonly" value='<%=request.getAttribute("fragilidad")%>' /></li>
	<br/><li><label>Tercerizado:</label><input class="input-field" name="" type="text" id="tercerizado" maxlength="20" readonly="readonly" value='<%=request.getAttribute("tercerizado")%>' /></li>    
</ul>
<br/><br/>
<label>Datos del Receptor</label>
<!--Sólo se ve si es Particular --> 
    <fieldset><ul>
		<li><label>DNI:</label><input class="input-field" name="dniReceptor" type="text" id="dniReceptor" maxlength="10" readonly="readonly" value='<%=request.getAttribute("dniReceptor")%>' /></li>
		<li><label>Nombre:</label><input class="input-field" name="nombreReceptor" type="text" id="nombreReceptor" maxlength="50" readonly="readonly" value='<%=request.getAttribute("nombreReceptor")%>' /></li>
		<li><label>Apellido:</label><input class="input-field" name="apellidoReceptor" type="text" id="apellidoReceptor" maxlength="50" readonly="readonly" value='<%=request.getAttribute("apellidoReceptor")%>' /></li>
    </ul></fieldset>
    
	<li><label>Envío Asignado:</label><input class="input-field" name="envioAsignado" type="text" id="envioAsignado" readonly="readonly" value='<%=request.getAttribute("envioAsignado")%>' /></li>
	<li><label>Id Envío:</label><input class="input-field" name="idEnvio" type="text" id="idEnvio" readonly="readonly" value='<%=request.getAttribute("idEnvio")%>' /></li>
</table>
		<% 
			List<DTO_ItemFactura> rows = (List<DTO_ItemFactura>)request.getAttribute("itemsFactura");
			for (int i = 0; i < rows.size(); i++) { 
				DTO_ItemFactura rowObj = rows.get(i);
        %>
        <tr>

            <% for (int j = 0; j < 7; j++) {
               // This RHS made up due to not knowing the class of objects
               // in your map, use something equivalent
               String cell = rowObj.getDescripcion(); 
            %>
            <td>
                <center>
                   <%=cell.toString()%>
                </center>
            </td>
            <% } %>
        </tr>
        <% } %>
<table>

<!-- 
itemsFactura
for(DTO_ItemFactura item:factura.getItems()){
					items += item.getDescripcion() +  "-" + item.getCantidad() + "-" + item.getValor() + "---";
				} -->

<!--       <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div>-->

      </div>
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
