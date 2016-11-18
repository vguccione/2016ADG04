<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>Untitled Document</title>
 <link href="css/style.css" rel="stylesheet" type="text/css" />
 <script src="jquery/jquery-2.1.1.js" type="text/javascript"></script>
 
<!--  ID que se van a completar manual en form:
- razonSocial
- cuit
- telefono
- email
- estado
- paisDestino
- provinciaDestino
- localidad
- direccion
- codigoPostal
- idCuentaCorriente


ID automáticos que levanta:
-idCliente -->
 
</head>

<body>
<!-- Variables -->
<input type = "hidden" readonly="readonly"  id="txtMensaje" value="<%=(String) request.getAttribute("mensaje") %>"/> 

<!-- Scripts -->
<script type="text/javascript">

</script>

<div class="container">
  <div class="content">
<h2>Ingreso de nuevos clientes:</h2>

<form action="servletCliente?action=altaCliente" method="post" name="frmAltaCliente" class="form-style-2" >
 <ul>
  <li><label>Nro. de Cliente: </label><input readonly class="input-trae" name="idCliente" type="text" value="" /></li>
  <li><label>Raz&oacute;n social: </label><input class="input-field" name="" type="text" id="razonSocial" maxlength="50" /></li>
  <li><label>Nro. de CUIT: </label><input class="input-field" name="" type="text" id="cuit" maxlength="50" /></li>
   <li><label>Teléfono: </label><input class="input-field" name="" type="text" id="telefono" maxlength="50" /></li>
    <li><label>Email: </label><input class="input-field" name="" type="text" id="email" maxlength="50" /></li>
  <li><label>Estado:</label>
   <input type="radio" name="estado" value="True" id="estado"/>Activo
    <input type="radio" name="estado" value="False" id="estado"  style="margin-left:35px;"/>Inactivo
 </li>
  <li><label>Pa&iacute;s destino:</label><select name="paisDestino" class="select-field"  id="paisDestino" style="margin-right:400px; margin-bottom:10px;width:200px;" >
                         	 <option>Seleccionar Pa&iacute;s</option></select></li>
  <li><label>Provincia destino:</label><select name="provinciaDestino" id="provinciaDestino" class="select-field"  style="margin-right:400px; margin-bottom:10px;width:200px;" >
                      		  <option>Seleccionar Provincia</option></select></li>
  <li><label>Localidad: </label><input class="input-field" name="" type="text" id="localidad" maxlength="50" /></li>
  <li><label>Direcci&oacute;n: </label><input class="input-field" name="" type="text" id="direccion" maxlength="50" /></li>
  <li><label>C&oacute;digo postal: </label><input class="input-field" name="" type="text" id="codigoPostal" maxlength="50" /></li>
  <li><label>Cuenta Corriente: </label><input class="input-field" name="" type="text" id="idCuentaCorriente" maxlength="2" /></li>
  </ul>
<div class="btn_centrado"><input name="Ingresar" type="submit" id="btnCliente" value="Enviar" /></div>
</form>


  
</div>
</div>
</body>
</html>

