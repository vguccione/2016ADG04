<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<!-- Fin Cabecera -->
<!-- Declaraciones -->
<%
 //Preguntamos si es sesion nueva o no esta logueado
 if(session.isNew() || session.getAttribute("sInt_Logueado")==null || session.getAttribute("sInt_Logueado")=="0"){
  session.setAttribute("sInt_Logueado","0");
  session.setAttribute("sStr_User","Invitado");
  };

 int    pInt_Logueado = Integer.parseInt((String) session.getAttribute("sInt_Logueado"));
 String pStr_User =  (String) session.getAttribute("sStr_User");
%>
<input id="iInt_Logueado" type="hidden" value ="<%=pInt_Logueado%>"/>
<input id="iStr_User"     type="hidden" value ="<%=pStr_User%>"/>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	var qInt_Logueado = $("#iInt_Logueado").val();
	var qStr_User = $("#iStr_User").val();
	
	$("#paginaClientes").load("altaCliente.jsp");
	
	console.log("Pagina cargada...");
	console.log("Flag logueado..."+ qInt_Logueado +" Usuario: "+ qStr_User);
	
     if (qInt_Logueado==1) {
    	$("#liUsuario").show();
    	$("#liInvitado").hide();
    	//$("#nombreUsuario").text("Hola "+qStr_User);
    	$("#nombreUsuario").val("prueba");
    	$("#nombreUsuario").html("prueba");
    	$("#nombreUsuario").text("prueba");
    	console.log("User logueado: "+qStr_User);
      } 
      else {
    	$("#liInvitado").show();
    	$("#liUsuario").hide();
    	$("#nombreUsuario").text("Hola Anonimo");
    	$("#divLogin").load("login.jsp");
    	console.log("login.jsp cargado...");
       }
     
     $("#lIniciarSesion").click(function(){
   	  $("#divLogin").load("login.jsp");
     });
     
     $("#lCerrarSesion").click(function() {
    	 $.post( "Sistema", JSON.stringify({action: "desloguearUsuario",fStr_Usuario : qStr_User }))
    	 .done(function( responseText ) {
    		    console.log(reponseText)
    		    $("#nombreUsuario").text("Hola Anonimo");
    	    	$("#liUsuario").hide();
    	    	$("#liInvitado").show();
    	    	$("#divLogin").load("login.jsp");    	
    	    	
    	 });
   	  	
   	});
	
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
                         <span id="#nombreUsuario">Hola Anonimo</span>               
                        </li>
                        <li id="liUsuario" class="desloguear" style="width:227px;color:#fff; font-size:14px;" >| <a class="link" id="lCerrarSesion"> Cerrar Sesión</> </li>
                        <li id="liInvitado" class="desloguear" style="width:227px;color:#fff; font-size:14px;" >| <a class="link" id="lIniciarSesion"> Inicie Sesión</> </li>           	
         			    </ul>
                    <a id="menu-toggle" class="button dark" href="#"></a>
        			<nav id="navigation">
        				<ul id="main-menu">
        					<li class="current-menu-item"><a href="main.jsp">HOME</a></li>
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
                            <li class="parent" style="text-align:left;display: inline-block;">
        						<a href=" ">COBROS/PAGOS</a>
        						<ul class="sub-menu">
        							<li><a href=" ">Cuentas Corrientes</a></li>
                                	<li class="parent">
                           			<a class="parent" href="#">Pagos</a>
        								<!-- <ul class="sub-menu">
        									<li><a href=" ">Transportes</a></li>
        									<li><a href=" ">Carries</a></li>
        									<li><a href=" ">Seguros</a></li>
        									<li><a href=" ">M&oacute;viles de seguridad</a></li>
        								</ul> -->
                                     </li>
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
  
    <!-- Pagina principal -->
    <div class="amarillo"></div>
  	<div class="page" style="background: #FFF; padding: 25px 50px;">
      <div id="divLogin">
      </div>
      <div id="divAltaCliente">
      </div>
      <div id="divAltaEncomienda">
      </div>
      <div id="paginaClientes">
      </div>
    </div>
    <!-- Fin Pagina principal -->   
    <div class="amarillo"></div>
    </div>
   <!-- Capa de desarrollo -->
    <div style="font-size: small;" id="logDebug" style="max-height:200px;overflow-y:auto;overflow-x:auto;white-space:pre;">
    
    </div>
    <br />
  </div>
</body>
</html>
