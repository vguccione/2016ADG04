<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consultar Encomiendas</title>
 
 <script src="jquery/jquery-2.1.1.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/mainmenu.js"></script>
<script src="jquery/jquery-ui.js" type="text/javascript"></script>
 <script type="text/javascript" src="jquery/jquery.timepicker.js"></script>
 
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
 
 <!-- Hojas de estilo -->
 <link href="css/style.css" rel="stylesheet" type="text/css" />
 <link href="jquery/jquery-ui.css" rel="stylesheet" type="text/css" />
 <link href="css/jquery.timepicker.css" rel="stylesheet" type="text/css">
 <!-- Fonts -->
 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
 <link href="css/font-awesome.css" rel="stylesheet" type="text/css" >
 
</head>
<!-- Fin Cabecera -->
<!-- Declaraciones -->
<%
	String usuario;
    String sucursal;
    String encomienda;
    String destinos;
    String estado;
    String sucursalNombre;
	
	usuario = "";
	sucursal = "0";
	encomienda = "0";
	destinos = "";
	sucursalNombre = "";
	
	HttpSession sesionIntento = request.getSession();
	if(sesionIntento.getAttribute("usuario") != null){
		usuario = (String)sesionIntento.getAttribute("usuario");
		sucursal = (String)sesionIntento.getAttribute("sucursal");
	}   
	encomienda = (String)request.getAttribute("idEncomienda");
	destinos = (String)request.getAttribute("destinos");
	sucursalNombre = (String)request.getAttribute("sucursalNombre");
	estado = (String)request.getAttribute("estado");
%>
<input id="iInt_Logueado" type="hidden" value =""/>
<input id="iStr_User"     type="hidden" value =""/>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">
/*
   $(window).load(function(){
	    var data = [[48803, "DSK1", "", "02200220", "OPEN1"], [48769, "APPR", "", "77733337", "ENTERED1"]];
	     
	    $("#grid").jqGrid({
	        datatype: "local",
	        height: 250,
	        colNames: ['Inv No', 'Thingy', 'Blank', 'Number', 'Status'],
	        colModel: [{
	            name: 'id',
	            index: 'id',
	            width: 60,
	            sorttype: "int"},
	        {
	            name: 'thingy',
	            index: 'thingy',
	            width: 90,
	            sorttype: "date"},
	        {
	            name: 'blank',
	            index: 'blank',
	            width: 30},
	        {
	            name: 'number',
	            index: 'number',
	            width: 80,
	            sorttype: "float"},
	        {
	            name: 'status',
	            index: 'status',
	            width: 80,
	            sorttype: "float"}
	        ],
	        caption: "Static Data Example",
	        // ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}
	    });
	     
	    var names = ["id", "thingy", "blank", "number", "status"];
	    var mydata = [];
	     
	    for (var i = 0; i < data.length; i++) {
	        mydata[i] = {};
	        for (var j = 0; j < data[i].length; j++) {
	            mydata[i][names[j]] = data[i][j];
	        }
	    }
	    
	    for (var i = 0; i <= mydata.length; i++) {
	        $("#grid").jqGrid('addRowData', i + 1, mydata[i]);
	    }
	  */  
	    /*
	    $("#grid").jqGrid('setGridParam', {onSelectRow: function(rowid,iRow,iCol,e){alert('row clicked');}});
	    */
	/*    $("#grid").jqGrid('setGridParam', {ondblClickRow: function(rowid,iRow,iCol,e){alert('double clicked');}});
	     
	   });*/



$(document).ready(function() {	
	
	
	  	  var usuario = <%= '"' + usuario + '"'%>
	  	  var sucursal = <%= '"' + sucursal + '"'%>
	  	  var sucursalNombre = <%= '"' + sucursalNombre + '"'%>
	  	  var encomienda = <%= '"' + encomienda + '"'%>
	  	  var estado = <%= '"' + estado + '"'%>
 	  

		  if(usuario == "")	
		  {	  
	  		$("#nombreUsuario").text("");
	 		$("#divLogin").load("login.jsp");
	 		$("#lCerrarSesion").text("");
	 		
		  }
		  else
		  {
	  		$("#nombreUsuario").text("Hola " + usuario + "("+sucursal+")" );
	  		$("#lCerrarSesion").text("Cerrar Sesion");
	  		$("#cerrarSesion").load("logout.jsp");

	  		

	  		$("#menu_nuevo_cliente").on("click",function(){
	  			$("#divTodo").load("altaCliente.jsp");
	  		});
	  		
	  		/*$("#menu_new_encom_particular").on("click",function(){
	  			$("#divTodo").load("altaEncomiendaParticular_ok.jsp");
	  		});*/
	  		
	  		$("#menu_new_encom_empresa").on("click",function(){
	  			$("#divTodo").load("altaEncomiendaEmpresa.jsp");
	  		});
	  		

	  		$("#menu_pagar_fact_particular").on("click",function(){
	  			$("#divTodo").load("pagarFacturaParticular.jsp");
	  		});

	  		$("#menu_egresar_encom_stock_empresa").on("click",function(){
	  			$("#divTodo").load("egresarEncomiendaEnStock.jsp");
	  		});

	   	  }

             $("#projectTable").jqGrid({
                  url: "servletEncomiendasListado",//?type=BS21 7RH",
                  datatype: "json",
                  jsonReader: {repeatitems: false, id: "ref"},
                  colNames:['Nro Encomienda','Nro Cliente', 'Envio asignado', 'Ver Encomienda'],
                  colModel:[
                      {name:'idEncomienda',index:'idEncomienda', width:100},
                      {name:'idCliente',index:'idCliente', width:100},
                      {name:'envioAsignado',index:'envioAsignado', width:100},
 					  {name:'verEncomienda',index:'verEncomienda', width:100}
                  ],
                  rowNum:20,
               //   rowList:[20,60,100],
                  height:500,
                  pager: "#pagingDiv",
                  viewrecords: true,
                  caption: "Json Example"
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

		  
			  	   
//}); //document ready

</script>

<!-- Cuerpo -->
<body>
<div class="container">
    <div class="content">
        <div id="wrap">
        	<header>
        		<div class="inner relative">
                      <ul style="width:227px;">
        				<li style="width:230px;"><a class="logo" href="main.jsp"><img src="images/logo_web_dgv_02.jpg" alt="Der grobe Verteiler" border="0"></a></li>
                     	<li class="logueado" style="width:227px; margin-top:10px;font-size:18px; line-height:25px; color:#f0af1e;">
                         <span id="nombreUsuario"> </span>               
                        </li>
                        <div id="cerrarSesion" style="width:227px;color:#fff; font-size:14px;" > </div>           	
         			    </ul>
                    <a id="menu-toggle" class="button dark" href="#"></a>
        			<nav id="navigation">
        				<ul id="main-menu">
        					<li class="current-menu-item"><a href="">HOME</a></li>
        					<li class="parent">
        						<a class="parent" href="#"> ENCOMIENDA</a>
        							<ul class="sub-menu">
        									<li><a id="menu_new_encom_particular">Nueva Encomienda Particular</a></li>
        									<li><a id="menu_new_encom_empresa">Nueva Encomienda Empresa</a></li>
									</ul>
        					</li>
        					<li class="parent">
        						<a class="parent" href="#"> ENV&Iacute;OS</a>
        							<ul class="sub-menu">
        									<li><a href=" "> Recepci&oacute;n</a></li>
        									<li><a href=" ">Env&iacute;os propios</a></li>
        									<li><a href=" ">Env&iacute;os tercerizados</a></li>
        							</ul>
        					</li>
        					<li class="parent">
                            	<a href=" ">CLIENTES</a>
                                <ul class="sub-menu">
                                    <li><a id="menu_nuevo_cliente">Nuevo Clientes</a></li>
        							<li><a id="mClientes">Buscar Clientes</a></li>
        							<li><a href=" ">Cuentas corrientes</a></li>
                                </ul></li>   
        					<li class="parent">
        						<a href=" ">VIAJES</a>
        						<ul class="sub-menu">
        							<li><a href=" ">Control de viajes</a></li>
        							<li><a href=" ">Contrataci&oacute;n de viajes</a></li>
        						</ul>
        					</li>
                            <li class="parent" style="text-align:left;display: inline-block;">
        						<a href=" ">COBROS/PAGOS</a>
        						<ul class="sub-menu">
        							<li><a id="menu_pagar_fact_particular">Pagar Factura Particular</a></li>
                                	<li><a id="menu_pagar_fact_empresa">Pagar Factura Empresa</a></li>
                                </ul>
                            </li>
                            <li class="parent">
        						<a class="parent" href="#">VEH&Iacute;CULOS</a>
        							<ul class="sub-menu">
                                    	<li><a href=" ">Veh&iacute;culos propios</a></li>
        								<li><a href=" ">Mantenimiento</a></li>
        								<li><a href=" ">Veh&iacute;culos contratados</a></li>
                                    </ul>
                             </li>
                             <li class="parent">
        						<a class="parent" href="#">ADMINISTRACI&Oacute;N</a>
        							<ul class="sub-menu">
                                    	<li><a href=" "> Empleados</a></li>
        								<li><a href=" "> Veh&iacute;culos</a></li>
        								<li><a href=" "> Proveedores</a></li>
                                        <li><a href=" "> Precios transportes y carriers</a></li>
        								<li><a href=" "> Seguros</a></li>
                                        <li><a href=" "> Maps de rutas</a></li>
                                    </ul>
                             </li>
                             <li class="parent">
        						<a class="parent" href="#">SUCURSALES</a>
        							<ul class="sub-menu">
                                    	<li><a href=" "> Sucursales</a></li>
        								<li><a href=" "> Novedades de caminos</a></li>    
                                 </ul>    
                             </li>       
                        </ul>            
        		    </nav>
        			<div class="clear"></div>
          		</div>
        	</header>
        </div>	
     <div class="amarillo"></div>
  	<div class="page" style="background: #FFF; padding: 25px 50px;">
		<div id="divLogin">

<!-- 	  <table id="grid"></table>-->
		  <div>
	         <div class="borderBottom" style="height:5em;">
	             <div class="floatLeftDiv borderRight">
	                 <div class="padding">
	                     <label>Postcode:</label>
	                     <select id="pcSelect">
	                         <option>Con envio asignado</option>
	                         <option>Sin envio asignado</option>
	                     </select>
	                 </div>
	             </div>
	         </div>
	         <div>
	          <div style="float: left;">
	              <table id="projectTable"></table>
	              <div id="pagingDiv"></div>
	          </div>
	         </div>
		  </div>
			

		</div>
	</div>
	</div>
	<br />
	<!-- end .content --></div>
	<!-- end .container --></div>
</body>
</html>
