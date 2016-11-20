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
	 var firstClick = true;       
	 $("#btnBuscarEnvios").click(function(){
			var idSucDestino = $("#idSucursalDestino").val();

			 if (!firstClick) {
	             $("#enviosTerceros").jqGrid('GridUnload'); 
	             $("#enviosPropios").jqGrid('GridUnload'); 
	         }
			 firstClick = false;
	         $("#enviosTerceros").jqGrid({
	                  url: "servletEnviosListado?action=enviosTerceros&idSucursalDestino="+idSucDestino,
	 
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
	                  height:200,
	                  pager: "#pagingDivTerceros",
	                  viewrecords: true,
	                  caption: "Envios Tercerizados"
	              });
	 
	             $("#enviosPropios").jqGrid({
	                  url: "servletEnviosListado?action=enviosPropios&idSucursalDestino="+idSucDestino,
	 
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
	                  height:200,
	                  pager: "#pagingDiv",
	                  viewrecords: true,
	                  caption: "Envios Propios"
	              }); 

		 
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


function findEnvios(){
	
}


</script>

<!-- Cuerpo -->
<body>
	<div class="container">
		<div class="content">
			<div class="page" style="background: #ccc; padding: 25px 100px;height:3000px">
			
			<label>Ingrese sucursal de destino: </label><input class="input-field" name="idSucursalDestino" width="100px" type="text" id="idSucursalDestino" />
			<br /><br/>
			<input type="button" value="Buscar Envios" id="btnBuscarEnvios" />
				<!--<div>
					<label>Filtrar:</label>
					<select id="pcSelect">
						<option>Con envio asignado</option>
						<option>Sin envio asignado</option>
					</select>
				</div>-->
				
				<div>
					<table id="enviosPropios" title="Envios Propios" ></table>
					<div id="pagingDiv"></div>
				</div>
				<div>
					<table id="enviosTerceros" title="Envios de terceros" ></table>
					<div id="pagingDivTerceros"></div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>
