<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<head>
 
</head>
<input id="iInt_Logueado" type="hidden" value =""/>
<input id="iStr_User"     type="hidden" value =""/>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

</script>
<!-- Fin Scripts -->
 
<!-- Cuerpo -->
<%@ include file="header.jsp" %>
<body>
<div class="container">
    <div class="content">
       		<div class="inner relative">
                      <ul style="width:227px;">
                     	<li class="logueado" style="width:227px; margin-top:10px;font-size:18px; line-height:25px; color:#f0af1e;">
                         <span id="nombreUsuario"> </span>               
                        </li>         	
         			    </ul>
                    <a id="menu-toggle" class="button dark" href="#"></a>
        			
        			<div class="clear"></div>
        </div>	
  
    <!-- Pagina principal -->
    <div class="amarillo"></div>
  	<div class="page" style="background: #CCC; padding: 25px 100px;">
      <div id="divLogin">
      
      </div>
      <div id="divTodo" >
      <span style=color:red> <%= (String)request.getAttribute("mensaje")%></span>
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
