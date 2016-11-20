<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="header.jsp" %> 
</head>

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
	  
	$('#agregarProd').on("click",function() {

		var ul = document.getElementById("productos");
		var items = ul.getElementsByTagName("li");
		var i =  parseInt(items.length) + 1;
		var elemento = "<li><div id='producto"+i+"''><label>Codigo Producto:  </label><input class='input-field' name='producto"+i+"' type='text' id='producto"+i+"' maxlength='10' /><label>Cantidad:  </label><input class='input-field' name='producto"+i+"cantidad' type='text' id='producto"+i+"cantidad' maxlength='4' /></div></li>";
	  	
	  	$('#productos').append(elemento);
	  	
	  	document.getElementById("cantProd").value=i;
	  	return false;
	 });
	
    $('#btnBuscarCliente').on("click",function(){
    	var cuitCliente = $('#cuitEmpresaBuscar').val();
        $.get('servletBuscarCliente?action=byCuit', {
        		cuit : cuitCliente
        	}, 
        	function(responseText) {
        		
        		if(responseText == "noExiste"){
        			alert('El Cliente no existe');
        			$("#cuitEmpresa").val("");
	        		$("#razonSocialTxt").val("");
        			$("#altaEncomiendaForm").css("display", "none");
        		}
        		else{
	        		//$("#divBuscarCliente").text(responseText);
	        		$("#cuitEmpresa").val(cuitCliente);
	        		$("#razonSocialTxt").val(responseText);
	        		$("#altaEncomiendaForm").css("display", "block");
        		}
        	}
        );
	});
	
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
	
	  	  var usuario = <%= '"' + usuario + '"'%>
	  	  var sucursal = <%= '"' + sucursal + '"'%>
	  	  var sucursalNombre = <%= '"' + sucursalNombre + '"'%>
	  	  var encomienda = <%= '"' + encomienda + '"'%>
	  	  var estado = <%= '"' + estado + '"'%>
 	  
		  $("#diasEntrega").datepicker();
		  $("#fechaMaxima" ).datepicker();
		  $("#fechaRetiro" ).datepicker();
		  $("#fechaEstimada" ).datepicker();
		  $("#fechaRetiropartic" ).datepicker();
		  	   
}); //document ready



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
    <div class="content">

     
<h2>Encomienda Empresa:</h2>


<ul><li>
<label>Buscar cliente por CUIT:</label>
<input class="input-field" name="cuitEmpresaBuscar" type="text" id="cuitEmpresaBuscar" maxlength="15" />
</li></ul>

<button id="btnBuscarCliente">Buscar Cliente</button>
<div id="divBuscarCliente"> </div>

<br/>
<div id="altaEncomiendaForm" style="display:none;">

<form action="ServeletEncomiendaEmpresa?action=altaEncomiendaEmpresa" method="post" name="frm_idEncomienda"  onsubmit="return validar()"> <!-- class="form-style-2"> -->
	<ul>
		<li>
			<label>CUIT cliente:</label>
			<input class="input-field" name="cuitEmpresa" type="text" readonly="readonly" id="cuitEmpresa" maxlength="15" />
			<label>Razón Social:</label>
			<input class="input-field" name="razonSocialTxt" readonly="readonly" type="text" id="razonSocialTxt" maxlength="15" />
		</li>
		<li>
			<label>Código Sucursal de origen:</label>
			<input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value="<%=sucursal%>"/></li>
					<li>
						<label>Código Sucursal de destino:</label>
						<input name="idSucursalDestino" type="text" class="input-field" id="idSucursalDestino" />
					</li>
					<br/>
					<li>
						<label>Fecha estimada de entrega:</label>
						<input type="text" id="fechaRecepcion" name="fechaRecepcion" class="input-field" readonly="readonly" ><button type="button" id="btnCalcularFecha">Calcular</button>
					</li>
					<br/>
					<li>
							<label>Largo (cm):</label>
							<input class="input-field" name="largo" type="text" id="largo" size="18" /> 
							<label>Alto (cm):</label>
							<input class="input-field" name="alto" type="text" id="alto" size="18" />
							<label>Ancho (cm):</label>
							<input class="input-field" name="ancho" type="text" id="ancho" size="18" />
					</li>
						<li>
							<label>Peso (kg):</label>
							<input class="input-field" name="peso" type="text" id="peso" size="18" />
						</li>
						<br/>
						<li>
							<label>Tratamiento:</label>
							<input class="input-field" name="" type="text" id="tratamiento" value="" maxlength="50" />
						</li>
						<br/>
						<li>
							<label>Apilable:</label>
							<label class="input-radio-field">
								<input type="radio" name="Apilable" value="true" id="Apilable" />Sí</label>
							<label class="input-radio-field">
								<input type="radio" name="Apilable" value="false" id="Apilable" checked />No</label>
						</li>
						<br/>
						<li>
							<label>Cantidad Apilable:</label>
							<input class="input-field" name="cantApilable" type="text" id="cantApilable" size="10" />
						</li>
						<br/>
						<li>
							<label>Refrigerado:</label>
							<label class="input-radio-field">
								<input type="radio" name="Refrigerado" value="true" id="Refrigerado" />Sí</label>
							<label class="input-radio-field">
								<input type="radio" name="Refrigerado" value="false" id="Refrigerado" checked />No</label>
						</li>
						<br/>
						<li>
							<label>Condición de transporte</label>
							<input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" />
						</li>
						<br/>
						<li>
							<label>Indicaciones de manipulaci&oacute;n:</label>
							<input class="input-field" name="indicacionesManipulacion" type="text" id="indicacionesManipulacion" maxlength="400" />
						</li>      
						<li>
							<label>Fragilidad:</label>
							<input class="input-field" name="fragilidad" type="text" id="fragilidad" maxlength="20" />
						</li>
						<br/>
						<label>Agregar productos</label><br/><button type="button" id="agregarProd" name="agregarProd" value="Agregar" )>Agregar Producto</button>
						
						<fieldset>
							<ul id="productos">
								<li>
									<div id="producto1">
										<label>Codigo Producto:  </label><input class="input-field" name="producto1" type="text" id="producto1" maxlength="10" />
										<label>Cantidad:  </label><input class="input-field" name="producto1cantidad" type="text" id="producto1cantidad" maxlength="4" />
									</div>
								</li>
								<input type=hidden name="cantProd" id="cantProd" value="1">
							</ul>
						</fieldset>
						
						<label>Datos del Receptor</label><br/>
						<!--Sólo se ve si es Particular --> 
						<fieldset>
							<ul>
								<li>
									<label>DNI:</label>
									<input class="input-field" name="dniReceptor" type="text" id="dniReceptor" maxlength="10" />
								</li>
								<li>
									<label>Nombre:</label>
									<input class="input-field" name="nombreReceptor" type="text" id="nombreReceptor" maxlength="50" />
								</li>
								<li>
									<label>Apellido:</label>
									<input class="input-field" name="apellidoReceptor" type="text" id="apellidoReceptor" maxlength="50" />
								</li>
							</ul>
						</fieldset>
					</ul>
					<div class="btn_centrado">
						<input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar"/>
					</div>

				</form>
</div> <!-- End altaEncomiendaForm -->

      </div>
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
