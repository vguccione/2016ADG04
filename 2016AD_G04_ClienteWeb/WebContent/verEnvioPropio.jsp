<%@page import="com.ADG04.bean.Encomienda.DTO_EnvioPropio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>

<!-- Declaraciones -->

<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	  
	$("#projectTable").jqGrid({

		url: "servletEncomiendasListadoByEnvio?idEnvio="+<%= request.getParameter("idEnvio") %>,
		datatype: "json",
		jsonReader: {repeatitems: false, id: "ref"},
		colNames:['Nro Encomienda','Nro Cliente', 'Envio asignado'],
		
		colModel:[
			{name:'idEncomienda',index:'idEncomienda', width:100},
			{name:'idCliente',index:'idCliente', width:100},
			{name:'verEncomienda',index:'verEncomienda', width:100}
		],
		rowNum:20,
		//   rowList:[20,60,100],
		height:500,
		pager: "#pagingDiv",
		viewrecords: true,
		caption: ""
	});
	
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


});

function showCambiarEstado(){
	$("#cambiarEstado").css("display", "block");
	$("#btnCambiarEstado").css("display", "none");	
}

function hideCambiarEstado(){
	$("#cambiarEstado").css("display", "none");
	$("#btnCambiarEstado").css("display", "block");	
}

function guardarEstadoEnvio(){

	var estadoSelected = '';
	
	if (document.getElementById('rbnPendiente').checked) { estadoSelected = 'Pendiente'; }
	if (document.getElementById('rbnVehiculoCompleto').checked) { estadoSelected = 'VehiculoCompleto'; }
	if (document.getElementById('rbnEnViaje').checked) { estadoSelected = 'EnViaje' }
	if (document.getElementById('rbnDesviado').checked) { estadoSelected = 'Desviado'; }
	if (document.getElementById('rbnAlerta').checked) { estadoSelected = document.getElementById('Alerta').value; }
	if (document.getElementById('rbnDemorado').checked) { estadoSelected = document.getElementById('Demorado').value; }
	if (document.getElementById('rbnConcluido').checked) { estadoSelected = document.getElementById('Concluido').value; }
	
	if(estadoSelected == ''){
		alert('Debe elegir un estado');
		return;
	}
	
	$.get('servletGuardarEstadoEnvio', {
			idEnvio : <%= request.getParameter("idEnvio") %>,
			estado : estadoSelected
		}, 
		function(responseText) {
			
			if(responseText == "error"){
				alert('Ha ocurrido un error');
			}
			else{
				$("#estadoEnvio").val(responseText);
				hideCambiarEstado();
			}
		}
	);	
}

$(function() {
	$('#horaMinima').timepicker();
	$('#horaMaxima').timepicker();
	$("#horaMinimaPartic" ).datepicker();
	$("#horaMaximaPartic" ).datepicker();
});
</script>
 
<!-- Cuerpo -->
<body>
	<div class="container" style="background-color: #E6E6E6;">
		<div class="content" style="height:800px">

			<h2>Envio:</h2>
			<ul>
				<li><label>Nro envio: </label><input class="input-field" name="idEnvio" type="text" id="idEnvio" readonly="readonly" value='<%=request.getAttribute("idEnvio")%>' /></li><br/>
				
				<li><label>Nro de vehiculo: </label><input name="idVehiculo" type="text" readonly="readonly" class="input-field" id="idVehiculo" value='<%=request.getAttribute("idVehiculo")%>'/></li><br/>
				<li><label>Fecha y Hora de Salida: </label><input name="fechaYHoraSalida" type="text" readonly="readonly" class="input-field" id="fechaYHoraSalida" value='<%=request.getAttribute("fechaYHoraSalida")%>'/></li><br/>
				<li><label>Fecha y Hora de Llegada: </label><input name="fechaYHoraLlegada" type="text" readonly="readonly" class="input-field" id="fechaYHoraLlegada" value='<%=request.getAttribute("fechaYHoraLlegada")%>' /></li><br/>
				<li><label>Código Sucursal de origen: </label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value='<%=request.getAttribute("idSucursalOrigen")%>'/></li><br/>
				<li><label>Código Sucursal de destino: </label><input name="idSucursalDestino" type="text" readonly="readonly" class="input-field" id="idSucursalDestino" value='<%=request.getAttribute("idSucursalDestino")%>' /></li><br/>
				
				<li><label>Estado: </label><input name="estadoEnvio" type="text" readonly="readonly" class="input-field" id="estadoEnvio" value='<%=request.getAttribute("estadoEnvio")%>' /></li><br/>
				<li><label>Coordenadas actuales: </label><input name="coordenadasActuales" type="text" readonly="readonly" class="input-field" id="coordenadasActuales" value='<%=request.getAttribute("coordenadasActuales")%>' /></li><br/>

				<input type="button" value="Cambiar estado" id="btnCambiarEstado" onclick="showCambiarEstado();" />
				<div id="cambiarEstado" style="display:none;">
					<fieldset>
						<input type="radio" name="rbnEstadoEnvio" value="Pendiente" id="rbnPendiente" /> <!--por salir en viaje-->
						<input type="radio" name="rbnEstadoEnvio" value="VehiculoCompleto" id="rbnVehiculoCompleto" /> <!--//se lleno la capacidad del vehiculo-->
						<input type="radio" name="rbnEstadoEnvio" value="EnViaje" id="rbnEnViaje"  /> 	<!--esta en viaje-->
						<input type="radio" name="rbnEstadoEnvio" value="Desviado" id="rbnDesviado"  />   <!--el vehiculo asignado al envio no esta siguiendo la ruta acordada-->
						<input type="radio" name="rbnEstadoEnvio" value="Alerta" id="rbnAlerta"  />     <!--el vehiculo asignado hace 10 minutos que esta en otra ruta-->
						<input type="radio" name="rbnEstadoEnvio" value="Demorado" id="rbnDemorado"  />   <!--el envio llego mas tarde de lo pautado-->
						<input type="radio" name="rbnEstadoEnvio" value="Concluido" id="rbnConcluido"  />   <!--llego a destino-->				
					</fieldset>
					<input type="button" value="Guardar estado" id="btnGuardarEstado" onclick="guardarEstadoEnvio();" />
				</div>		
				<br/>

				<div style="float: left;">
					<table id="projectTable"></table>
					<div id="pagingDiv"></div>
				</div>
			</ul>
			<br />
		</div><!-- end .content -->
	</div><!-- end .container -->
</body>
</html>
