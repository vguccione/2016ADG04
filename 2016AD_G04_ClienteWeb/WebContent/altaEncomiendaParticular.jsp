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
	sucursalNombre = (String)request.getAttribute("sucursalNombre");
	estado = (String)request.getAttribute("estado");
%>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	  
	  	  var encomienda = <%= '"' + encomienda + '"'%>
	  	  var estado = <%= '"' + estado + '"'%>

		  $("#diasEntrega").datepicker();
		  $("#fechaMaxima" ).datepicker();
		  $("#fechaRetiro" ).datepicker();
		  $("#fechaEstimada" ).datepicker();
		  $("#fechaRetiropartic" ).datepicker();

		  $('#btnCalcularFecha').on("click",function(){
		    	var sucursalOrigen = $('#idSucursalOrigen').val();
		    	var sucursalDestino = $('#idSucursalDestino').val();
		    	if(sucursalDestino=="")
		        	alert("Por favor indique sucursal destino");
		    	else{
			        $.get('servletCalcularFechaEntrega', {
			        		idSucursalOrigen : sucursalOrigen,
			        		idSucursalDestino: sucursalDestino
			        	}, 
			        	function(responseText) {
				        	$("#fechaRecepcion").val(responseText);
			        	}
			        );
		    	}
			});
	   
}); //document ready

function findClient(){

	$.get("ServletBuscarCliente", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
        $("#divBuscarCliente").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
    });
}


</script>
 <script>
 function validar(){
	valido = true;
	if(document.getElementById("idSucursalDestino").value==""){
		alert("Por favor ingrese sucursal destino");
		valido=false;
	}
	if(isNaN(document.getElementById("idSucursalDestino").value)){
		alert("Sucursal destino debe ser un numero");
		valido=false;
	}
	if(document.getElementById("alto").value==""){
		alert("Por favor ingrese el alto del paquete");
		valido=false;
	}
	if(isNaN(document.getElementById("alto").value)){
		alert("Alto debe ser un numero");
		valido=false;
	}
	if(document.getElementById("ancho").value==""){
		alert("Por favor ingrese el ancho del paquete");
		valido=false;
	}
	if(isNaN(document.getElementById("ancho").value)){
		alert("Ancho debe ser un numero");
		valido=false;
	}
	if(document.getElementById("largo").value==""){
		alert("Por favor ingrese el largo del paquete");
		valido=false;
	}
	if(isNaN(document.getElementById("largo").value)){
		alert("Largo debe ser un numero");
		valido=false;
	}
	if(document.getElementById("peso").value==""){
		alert("Por favor ingrese el peso del paquete");
		valido=false;
	}
	if(isNaN(document.getElementById("peso").value)){
		alert("Peso debe ser un numero");
		valido=false;
	}
	if(document.getElementById("dniReceptor").value==""){
		alert("Por favor ingrese el dni del receptor");
		valido=false;
	}
	if(document.getElementById("nombreReceptor").value==""){
		alert("Por favor ingrese el nombre del receptor");
		valido=false;
	}
	if(document.getElementById("apellidoReceptor").value==""){
		alert("Por favor ingrese el apellido del receptor");
		valido=false;
	}

	
	var apilable = document.getElementsByName("Apilable");
	for(var i = 0; i < apilable.length; i++){
		if(apilable[i].checked && apilable[i].value==="true"){
			if(document.getElementById("cantApilable").value==""){
				alert("Por favor ingrese la cantidad apilable aceptada");
				valido=false;
			}
			if(isNaN(document.getElementById("cantApilable").value)){
				alert("Cantidad apilable aceptada debe ser un numero");
				valido=false;
			}
		}
	}
	return valido;
 }

 </script>
 
<!-- Cuerpo -->
<body>
<div class="container" style="background-color: #E6E6E6;">
 <div class="content" >
<h2>Encomienda Particular:</h2>
<form action="serveletEncomiendaParticular?action=altaEncomiendaParticular" method="post" name="frm_idEncomienda" onsubmit="return validar()"> <!-- class="form-style-2">-->


  <label>Datos del Cliente</label>
	<!--Sólo se ve si es Particular --> 
    
    <ul>
	<li><label>Dni:  </label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li><br/>
		<!-- <button id="btnBuscarCliente" onclick="findClient()">Buscar Cliente</button>
        				<div id="divBuscarCliente"></div> -->
		<!-- <li><label>Nombre del particular: </label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
		<li><label>Apellido del particular: </label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>-->
    
    <li><label>Código Sucursal de origen:  </label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value="<%=sucursal%>"/></li><br/>
	<li><label>Código Sucursal de destino:  </label><input name="idSucursalDestino" type="text" class="input-field" id="idSucursalDestino" /></li><br/>
	
 	<br/>
 	
	<li>
	<label>Fecha estimada de entrega:</label>
	<input type="text" id="fechaRecepcion" name="fechaRecepcion" class="input-field" readonly="readonly" ><button type="button" id="btnCalcularFecha">Calcular</button>
	</li><br/>
 	<li><label>Ancho (cm): </label><input class="input-field" name="largo" type="text" id="largo" size="18" /></li><br/>
    <li><label>Alto (cm): </label><input class="input-field" name="alto" type="text" id="alto" size="18" /></li><br/>
    <li><label>Profundidad (cm): </label><input class="input-field" name="ancho" type="text" id="ancho" size="18" /></li><br/>
 	<li><label>Peso (kg): </label><input class="input-field" name="peso" type="text" id="peso" size="18" /></li><br/>
    <li><label>Tratamiento: </label><input class="input-field" name="tratamiento" type="text" id="tratamiento" value="" maxlength="50" /></li><br/>
 	<li><label>Apilable:</label>
     			<label class="input-radio-field"><input type="radio" name="Apilable" value="true" id="Apilable" />Sí</label>
       			<label class="input-radio-field"><input type="radio" name="Apilable" value="false" id="Apilable" checked/>No</label></li>
 	<br/><li><label>Cantidad Apilable: </label><input class="input-field" name="cantApilable" type="text" id="cantApilable" size="10" /></li>
 	<br/><li><label>Refrigerado:</label>
    			<label class="input-radio-field"><input type="radio" name="Refrigerado" value="true" id="Refrigerado" />Sí</label>
           	<label class="input-radio-field"><input type="radio" name="Refrigerado" value="false" id="Refrigerado" checked/>No</label></li>
	<br/><li><label>Condición de transporte </label><input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" /></li>
<br/>	<li><label>Indicaciones de manipulaci&oacute;n: </label><input class="input-field" name="indicacionesManipulacion" type="text" id="indicacionesManipulacion" maxlength="400" /></li>      
	<br/><li><label>Fragilidad: </label><input class="input-field" name="fragilidad" type="text" id="fragilidad" maxlength="20" /></li>
	<br/><li><label>Tercerizado:</label>
				<label class="input-radio-field"><input type="radio" name="tercerizado" value="true" id="tercerizado" />Sí</label>
       			<label class="input-radio-field"><input type="radio" name="tercerizado" value="false" id="tercerizado" />No</label></li>
    
</ul>
<br/><br/>
<label>Datos del Receptor</label>
<!--Sólo se ve si es Particular --> 
    <fieldset><ul>
		<li><label>DNI: </label><input class="input-field" name="dniReceptor" type="text" id="dniReceptor" maxlength="10" /></li>
		<li><label>Nombre: </label><input class="input-field" name="nombreReceptor" type="text" id="nombreReceptor" maxlength="50" /></li>
		<li><label>Apellido: </label><input class="input-field" name="apellidoReceptor" type="text" id="apellidoReceptor" maxlength="50" /></li>
    </ul></fieldset>


      <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div>
      </form>

      </div>
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
