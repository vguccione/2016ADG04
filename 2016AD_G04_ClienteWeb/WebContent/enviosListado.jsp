<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>
<%@ page import="com.ADG04.bean.Encomienda.DTO_Envio"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<%@ include file="header.jsp" %>

<!-- Fin Cabecera -->

<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">


$(document).ready(function() {	
	
	var idSucursal = 2;
	alert("p2p2");
             $("#enviosTerceros").jqGrid({
                  url: "servletEnviosListado",//?type=BS21 7RH",
 
                  datatype: "json",
                  jsonReader: {repeatitems: false, id: "ref"},
                  colNames:['Nro Envio','Estado', 'Sucursal Origen', 'Sucursal Destino'],
                  colModel:[
                      {name:'idEnvio',index:'idEncomienda', width:100},
                      {name:'estado',index:'estado', width:100},
                      {name:'idSucursalOrigen',index:'idSucursalOrigen', width:100},
 					  {name:'idSucursalDestino',index:'idSucursalDestino', width:100}
                  ],
                  rowNum:20,
               //   rowList:[20,60,100],
                  height:500,
                  pager: "#pagingDiv",
                  viewrecords: true,
                  caption: ""
              });
 
             $("#enviosPropios").jqGrid({
                  url: "servletEnviosListado",//?type=BS21 7RH",
 
                  datatype: "json",
                  jsonReader: {repeatitems: false, id: "ref"},
                  colNames:['Nro Envio','Estado', 'Sucursal Original', 'Sucursal Destino', 'Ver Envio'],
                  colModel:[
                      {name:'idEnvio',index:'idEncomienda', width:100},
                      {name:'estado',index:'estadi', width:100},
                      {name:'idSucursalOrigen',index:'idSucursalOrigen', width:100},
 					  {name:'idSucursalDestino',index:'idSucursalDestino', width:100},
					  {name:'verEnvio',index:'verEnvio', width:100}
                  ],
                  rowNum:20,
               //   rowList:[20,60,100],
                  height:500,
                  pager: "#pagingDiv",
                  viewrecords: true,
                  caption: ""
              }); 
               
              $("#pcSelect").change(function(){
                  var postcode = $("#pcSelect").val();
                  jQuery("#projectTable").jqGrid(
                          "setGridParam",{
                              url:"LoadJsonDataServlet?type="+ postcode,
                              page:1})
                          .trigger("reloadGrid");
              });
 
 	});

</script>

<!-- Cuerpo -->
<body>
	<div class="container">
		<div class="content">
			<div class="page" style="background: #ccc; padding: 25px 100px;height:3000px">
				<!--<div>
					<label>Filtrar:</label>
					<select id="pcSelect">
						<option>Con envio asignado</option>
						<option>Sin envio asignado</option>
					</select>
				</div>-->
				<div style="float: left;">
					<table id="enviosTerceros"></table>
					<div id="pagingDiv"></div>
				</div>
				<div style="float: left;">
					<table id="enviosPropios"></table>
					<div id="pagingDiv"></div>
				</div>
				
			</div>
		</div>

	</div>

</body>
</html>
