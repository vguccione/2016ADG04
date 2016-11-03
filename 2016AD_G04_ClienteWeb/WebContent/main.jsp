<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>Der groe Verteiler - Distribuci&oacute;n y env&iacute;os</title>
 <!-- Scripts --> 
 <script type="text/javascript" src="jquery/jquery-2.1.1.js"></script>
 <!-- Hojas de estilo -->
 <link href="css/style.css" rel="stylesheet" type="text/css" />
 <!-- Fonts -->
 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
</head>
<!-- Fin Cabecera -->
<!-- Declaraciones -->
<%	
	String usuario = "";
	String sucursal = "0";
	String sucursalNombre = "";
	
	HttpSession sesionIntento = request.getSession();
	if(sesionIntento.getAttribute("usuario") != null){
		usuario = (String)sesionIntento.getAttribute("usuario");
		sucursal = (String)sesionIntento.getAttribute("sucursal");
		sucursalNombre =  (String)sesionIntento.getAttribute("sucursalNombre");
	}    
%>
<!-- Fin Declaraciones -->
 <!-- Scripts -->
<script type="text/javascript">
$(document).ready(function() {
	console.log("js begin");
	/* MAIN MENU */
	$('#main-menu > li:has(ul.sub-menu)').addClass('parent');
	$('ul.sub-menu > li:has(ul.sub-menu) > a').addClass('parent');

	$('#menu-toggle').click(function() {
		$('#main-menu').slideToggle(300);
		return false;
	});

	$(window).resize(function() {
		if ($(window).width() > 700) {
			$('#main-menu').removeAttr('style');
		}
	});

	  	  var usuario =  <%= '"' + usuario + '"'%>
	  	  var sucursal =  <%= '"' + sucursal + '"'%>
	  	  var sucursalNom =  <%= '"' + sucursalNombre + '"'%>
  	  

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
	  		
	  		$("#menu_new_encom_particular").on("click",function(){
				alert("pepe");
	  			$("#divTodo").load("altaEncomiendaParticular.jsp");
	  		});
	  		
	  		$("#menu_new_encom_empresa").on("click",function(){
	  			$("#divTodo").load("altaEncomiendaEmpresa_ok.jsp");
	  		});
	  		
	  		$("#menu_ingreso_encom_stock_empresa").on("click",function(){
	  			$("#divTodo").load("altaEncomiendaEnStock.jsp");
	  		});

	  		$("#menu_pagar_fact_particular").on("click",function(){
	  			$("#divTodo").load("pagarFacturaParticular.jsp");
	  		});

	  		$("#menu_pagar_fact_empresa").on("click",function(){
	  			$("#divTodo").load("pagarFacturaEmpresa.jsp");
	  		});
	  		
	  		$("#menu_egresar_encom_stock_empresa").on("click",function(){
	  			$("#divTodo").load("egresarEncomiendaEnStock.jsp");
	  		});

	  		$("#menu_egresar_encom_stock_envio").on("click",function(){
	  			$("#divTodo").load("egresarEncomiendaStockEnvio.jsp");
	  		});

	  		$("#menu_ingresar_encom_stock_envio").on("click",function(){
	  			$("#divTodo").load("ingresarEncomiendaStockEnvio.jsp");
	  		});

	   	  }
		  	  
console.log("js complete");;	   
}); //document ready

</script>
<!-- Fin Scripts -->
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
                            	<a href=" ">CLIENTES</a>
                                <ul class="sub-menu">
        							<li><a id="mClientes" href="menuClientes.jsp">Clientes</a></li>
        							<li><a href=" ">Cuentas corrientes</a></li>
                                </ul></li>   
        					<li class="parent">
        						<a href=" ">VIAJES</a>
        						<ul class="sub-menu">
        							<li><a href=" ">Control de viajes</a></li>
        							<li><a href=" ">Contrataci&oacute;n de viajes</a></li>
        						</ul>
        					</li>        					
        					<li class="parent">
        						<a class="parent" href="#"> ENCOMIENDA</a>
        							<ul class="sub-menu">
        									<li><a id="menu_new_encom_particular">Nuevaaaddddddddd Encomienda Particular</a></li>
        									<li><a id="menu_new_encom_empresa">Nueva Encomienda Empresa</a></li>
        									<li><a id="menu_ingreso_encom_stock_empresa">Ingresar Encomienda al stock</a>
        									<li><a id="menu_egresar_encom_stock_empresa">Egresar Encomienda del stock</a>
        							</li>
        							</ul>
        					</li>
        					<li class="parent">
        						<a class="parent" href="#"> ENV&Iacute;OS</a>
        							<ul class="sub-menu">
        									<li><a id="menu_egresar_encom_stock_envio">Egresar encomiendas del stock para envio</a></li>
        									<li><a id="menu_ingresar_encom_stock_envio">Ingresar encomiendas al stock del envio</a></li>
        							</ul>
        					</li>
                            <li class="parent" style="text-align:left;display: inline-block;">
        						<a href=" ">COBROS</a>
        						<ul class="sub-menu">
        							<li><a id="menu_pagar_fact_particular">Cobrar Factura Cliente Particular</a></li>
                                	<li><a id="menu_pagar_fact_empresa">Cobrar Factura Cliente Empresa</a></li>
                                </ul>
                            </li>     
                        </ul>            
        		    </nav>
        			<div class="clear"></div>
          		</div>
        	</header>
        </div>	
  
    <!-- Pagina principal -->
    <div class="amarillo"></div>
  	<div class="page" style="background: #FFF; padding: 25px 50px;">
      <div id="divLogin">
      </div>
      <div id="divTodo">
      </div>
      <div id="divAltaEncomienda">
      </div>
      <div id="paginaClientes">
      </div>
    </div>

    <!-- Fin Pagina principal -->   
    <div class="amarillo"></div>
    </div>
  </div>
</body>
</html>