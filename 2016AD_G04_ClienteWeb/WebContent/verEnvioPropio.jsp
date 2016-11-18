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
		colNames:['Nro Encomienda','Nro Cliente', 'Envio asignado', 'Estado','Ver Encomienda'],
		colModel:[
        	{name:'idEncomienda',index:'idEncomienda', width:100},
            {name:'idCliente',index:'idCliente', width:100},
            {name:'envioAsignado',index:'envioAsignado', width:100},
			{name:'estado',index:'estado', width:100},
			{name:'verEncomienda',index:'verEncomienda', width:100}
        ],

		rowNum:20,
		//Â Â Â rowList:[20,60,100],
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
	
	showHideByTipoEnvio();

});

function showHideByTipoEnvio(){
	
	var tipoEnvio  = '<%=request.getAttribute("tipoEnvio")%>';
	
	if(tipoEnvio == "Propio"){
		$("#idVehiculo").css("display", "inline");
		$("#fechaYHoraSalida").css("display", "inline");
		$("#fechaYHoraLlegada").css("display", "inline");
		$("#labelFHLlegada").css("display", "inline");
		$("#labelFHSalida").css("display", "inline");
		$("#labelVehiculo").css("display", "inline");
	}
	else {
		$("#idVehiculo").css("display", "none");
		$("#fechaYHoraSalida").css("display", "none");
		$("#fechaYHoraLlegada").css("display", "none");
		$("#labelFHLlegada").css("display", "none");
		$("#labelFHSalida").css("display", "none");
		$("#labelVehiculo").css("display", "none");
	}
	
}

function showCambiarEstado(){
	$("#cambiarEstado").css("display", "inline");
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
			
			if(responseText == ""){
				alert('Ha ocurrido un error al intentar cambiar el estado.');
			}
			else{
				alert('Se ha modificado el estado a ' + estadoSelected);
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

				<li><label id="labelVehiculo">Nro de vehiculo: </label><input name="idVehiculo" type="text" readonly="readonly" class="input-field" id="idVehiculo" value='<%=request.getAttribute("idVehiculo")%>'/></li><br/>
				<li><label id="labelFHSalida">Fecha y Hora de Salida: </label><input name="fechaYHoraSalida" type="text" readonly="readonly" class="input-field" id="fechaYHoraSalida" value='<%=request.getAttribute("fechaYHoraSalida")%>'/></li><br/>
				<li><label id="labelFHLlegada">Fecha y Hora de Llegada: </label><input name="fechaYHoraLlegada" type="text" readonly="readonly" class="input-field" id="fechaYHoraLlegada" value='<%=request.getAttribute("fechaYHoraLlegada")%>' /></li><br/>
				<li><label>CÃ³digo Sucursal de origen: </label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value='<%=request.getAttribute("idSucursalOrigen")%>'/></li><br/>
				<li><label>CÃ³digo Sucursal de destino: </label><input name="idSucursalDestino" type="text" readonly="readonly" class="input-field" id="idSucursalDestino" value='<%=request.getAttribute("idSucursalDestino")%>' /></li><br/>
				
				<br/><li><label>Coordenadas actuales: </label> <%=request.getAttribute("coordenadasActuales")%></li><br/>
					<br/>			
				<li><label>Estado: </label><input name="estadoEnvio" type="text" readonly="readonly" class="input-field" id="estadoEnvio" value='<%=request.getAttribute("estadoEnvio")%>' /></li>
				
				<input type="button" value="Cambiar estado" id="btnCambiarEstado" onclick="showCambiarEstado();" />
				<div id="cambiarEstado" style="display:none;">
					<fieldset>
						Pendiente:<input type="radio" name="rbnEstadoEnvio" value="Pendiente" id="rbnPendiente" /> <!--por salir en viaje-->
						Vehiculo Completo:<input type="radio" name="rbnEstadoEnvio" value="VehiculoCompleto" id="rbnVehiculoCompleto" /> <!--//se lleno la capacidad del vehiculo-->
						En viaje:<input type="radio" name="rbnEstadoEnvio" value="EnViaje" id="rbnEnViaje"  /> 	<!--esta en viaje-->
						Desviado:<input type="radio" name="rbnEstadoEnvio" value="Desviado" id="rbnDesviado"  />   <!--el vehiculo asignado al envio no esta siguiendo la ruta acordada-->
						Alerta:<input type="radio" name="rbnEstadoEnvio" value="Alerta" id="rbnAlerta"  />     <!--el vehiculo asignado hace 10 minutos que esta en otra ruta-->
						Demorado:<input type="radio" name="rbnEstadoEnvio" value="Demorado" id="rbnDemorado"  />   <!--el envio llego mas tarde de lo pautado-->
						Concluido:<input type="radio" name="rbnEstadoEnvio" value="Concluido" id="rbnConcluido"  />   <!--llego a destino-->				
					</fieldset>
					<input type="button" value="Guardar estado" id="btnGuardarEstado" onclick="guardarEstadoEnvio();" />
				</div>		
				
				<br /><br />
				<div style="float: left;">
				Encomiendas:
					<table id="projectTable"></table>
					<div id="pagingDiv"></div>
				</div>
			</ul>
			<br />
		</div><!-- end .content -->
	</div><!-- end .container -->
</body>
</html>
