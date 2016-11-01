<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Nueva Encomienda</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="jquery/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.timepicker.css" rel="stylesheet" type="text/css">

<script src="jquery/jquery-2.1.1.js" type="text/javascript"></script>
<script src="jquery/jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript" src="jquery/jquery.timepicker.js"></script>

<script type="text/javascript">
$(document).ready(function() {

 $("#diasEntrega").datepicker();
 $("#fechaRecepcion").datepicker();
 $("#fechaMaxima" ).datepicker();
 $("#fechaRetiro" ).datepicker();
 $("#fechaEstimada" ).datepicker();
 $("#fechaRetiropartic" ).datepicker();

 
	$('.cla_cliente').magnificPopup({
		type: 'inline',
		preloader: false,
		focus: '#name',

		// When elemened is focused, some mobile browsers in some cases zoom in
		// It looks not nice, so we disable it:
		callbacks: {
			beforeOpen: function() {
				if($(window).width() < 700) {
					this.st.focus = false;
				} else {
					this.st.focus = '#name';
				}
			}
		}
	});
});//document
</script>	
<!-- Timepicker -->
<script>
                $(function() {
                    $('#horaMinima').timepicker();
					$('#horaMaxima').timepicker();
					 $("#horaMinimaPartic" ).datepicker();
					 $("#horaMaximaPartic" ).datepicker();
                });
</script>
	
    
</head>

<body>

<div class="container">
  <div class="content">
<h2>Encomienda:</h2>
<form action="" method="post" name="frm_idEncomienda" class="form-style-2">
<ul>
	<li><label>Nro. de Encomienda:</label><input class="input-field" name="idEncomienda" type="text" value="Esta la levanta automática?" /></li>
	<li><label>Sucursal de origen:</label><input name="idSucursalOrigen" type="text" class="input-field" id="idSucursalOrigen" value="Esta la levanta automática?" /></li>
	<li><label>Destino:</label><input class="input-field" name="idDestino" type="text" value="" /></li>
	<li><label>Sucursal actual</label><input name="" type="text" class="input-field" id="idSucursalActual" value="Esta la levanta automática?" /></li>
	<li><label>Fecha de recepci&oacute;n:</label><input type="date" id="fechaRecepcion" class="datepicker"></li>
 	<li><label>Fecha de m&aacute;xima:</label><input type="date" id="fechaMaxima" class="datepicker"></li>
 	<li><label>Estado:</label><input class="input-field" name="" type="text" id="estado" maxlength="20" /></li>
 	<li><label>Aseguradora:</label>
   		<select name="idAseguradora" class="select-field" id="idAseguradora" style="line-height:15px" title="Aseguradora">
     	<option>Seleccionar Aseguradora</option>
     	<option>Aseguradora 1</option>
   		</select>
 	</li>
 	<li>
 	  <label>Ancho:</label><input class="input-field" name="largo" type="text" id="largo" size="18" /> 
      <label>Alto:</label><input class="input-field" name="alto" type="text" id="alto" size="18" />
      <label>Profundidad:</label><input class="input-field" name="ancho" type="text" id="ancho" size="18" /></li>
 	<li><label>Peso:</label><input class="input-field" name="Peso" type="text" id="peso" size="18" />
    	<label>Volumen(cm&sup3;):</label><input class="input-field" name="" type="text" id="volumen" size="18" />
        <label>Tratamiento:</label><input class="input-field" name="" type="text" id="tratamiento" value="" maxlength="50" />
 	</li>
 	<li><label>Apilable:</label>
     			<label class="input-radio-field"><input type="radio" name="Apilable" value="radio" id="Apilable_0" />Sí</label>
       			<label class="input-radio-field"><input type="radio" name="Apilable" value="radio" id="Apilable_1" />No</label></li>
 	<li><label>Cantidad Apilable:</label><input class="input-field" name="Cantidad Apilable" type="text" id="cantApilable" size="10" /></li>
 	<li><label>Refrigerado:</label>
    			<label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_0" />Sí</label>
           		<label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_1" />No</label></li>
	<li><label>Condición de transporte</label><input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" /></li>
	<li><label>Indicaciones de manipulaci&oacute;n:</label><input class="input-field" name="" type="text" id="indicacionesManipulacion" maxlength="400" /></li>      
	<li><label>Coordenadas GPS:</label><input class="input-field" name="" type="text" id="coordenadaGPS" maxlength="20" /></li>       
	<li><label>Fragilidad:</label><input class="input-field" name="" type="text" id="fragilidad" maxlength="20" /></li>
	<li><label>Tercerizado:</label><br />
				<label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_0" />Sí</label>
       			<label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_1" />No</label></li>
	<li><label>Kil&oacute;metros Recorridos:</label><input class="input-field" name="kilometrosRecorridos" type="text" id="kilometrosRecorridos" /></li>
	<li><label>Facturado:</label>
    			<label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_0" />Sí</label>
       			<label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_1" />No</label></li>
	<li><label>Valor estimado:</label><input class="input-field" name="valorEstimado" type="text" id="valorEstimado" /></li>
	<li><label>Distancia estimada (KM):</label><input class="input-field" name="distanciaEstimadaKM" type="text" id="distanciaEstimadaKM" /></li>
	<li><label>Distancia real (KM):</label><input class="input-field" name="distanciaRealKM" type="text" id="distanciaRealKM" /></li>
</ul>


<!--Ahora se separa segun tipo de cliente --> 
  
<label>
    <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_0" />Empresa</label><br />
	<!--Sólo se ve si es Empresa --> 
    	<fieldset><ul>
    			<li><label>Cliente existente:</label><input class="input-field" name="idCliente" type="text" id="idCliente" />
     			<!--Si no está ingresada --><a class="cla_cliente" href="#nuevo_cliente.jsp">Igresar nuevo cliente</a>
    			</li>
    			<li><label>Direcci&oacute;n de entrega:</label><input class="input-field" name="idDireccionEntrega" type="text" id="idDireccionEntrega" />
  			 	<!--Si no está ingresada --><a class="" href="#">Igresar nueva direcci&oacute;n</a></li>
      		  	<li><label>A retirar:</label>
        		 	<label class="input-radio-field" ><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
             		<label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
				</li>
    <!--Sólo si se retira la carga en otro lugar -->
   			 <fieldset><ul>
             	<li><label>Lugar de retiro:</label><input class="input-field" name="lugarRetiro" type="text" id="lugarRetiro" maxlength="100" /></li>
    			<li><label>Fecha de retiro:</label><input type="date" id="fechaRetiro" class="datepicker"></li>
   				<li><label>Hora m&iacute;nima de retiro:</label><input class="input-field" name="horaMinima" type="text" value="hh:mm" size="8" maxlength="5" /></li>
    			<li><label>Hora m&aacute;xima de retiro:</label><input class="input-field" name="horaMaxima" type="text" value="hh:mm" size="8" maxlength="5" /></li>
             </ul></fieldset>
       	</ul></fieldset>

<label>
    <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_1" />
    A granel</label>
 <!--Sólo se ve si es A granel --> 
    <fieldset><ul>
   		 <li><label>Unidad granel:</label><input class="input-field" name="unidadGranel" type="text" id="unidadGranel" maxlength="100" /></li>
   		 <li><label>Carga granel:</label><input class="input-field" name="cargaGranel" type="text" id="cargaGranel" maxlength="100" /></li>
    </ul></fieldset> 

  <label>
    <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_2" />
    Particular</label>
<!--Sólo se ve si es Particular --> 
    <fieldset><ul>
				<li><label>DNI de particular:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li>
				<li><label>Nombre del particular:</label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
 				<li><label>Apellido del particular:</label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>
   				<li><label>Direcci&oacute;n de destino:</label><input class="input-field" name="direccionDestino" type="text" id="direccionDestino" maxlength="100" /></li>
    			<li><label>C&oacute;digo postal de destino:</label><input class="input-field" name="codigoPostalDestino" type="text" id="codigoPostalDestino" maxlength="10" /></li>
   				<li><label>Localidad destino:</label><input class="input-field" name="localidadDestino" type="text" id="localidadDestino" maxlength="50" /></li>
   				<li><label>Provincia destino:</label><input class="input-field" name="provinciaDestino" type="text" id="provinciaDestino" maxlength="50" /></li>
    			<li><label>Pa&iacute;s destino:</label><input class="input-field" name="paisDestino" type="text" id="paisDestino" maxlength="50" /></li>
     			<li><label>A retirar:</label>
          			<label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
					<label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
    			</li>
    <!--Sólo si se retira la carga en otro lugar -->
    			<li><fieldset>
                <ul>
                	<li><label>Lugar de retiro:</label><input class="input-field" name="lugarRetiro" type="text" id="lugarRetiro" maxlength="100" /></li>
    				<li><label>Fecha de retiro:</label><input type="date" id="fechaRetiro" class="datepicker"></li>
    				<li><label>Hora m&iacute;nima de retiro:</label><input class="input-field" name="horaMinima" type="text" value="hh:mm" size="8" maxlength="5" /></li>
    				<li><label>Hora m&aacute;xima de retiro:</label><input class="input-field" name="horaMaxima" type="text" value="hh:mm" size="8" maxlength="5" /></li>
    			</ul>
    			</fieldset></li>
    </ul></fieldset>
<li><label>Nro. factura cliente:</label><input class="input-field" name="idFacturaCliente" type="text" id="idFacturaCliente" /></li></ul>
<div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div></form>
   <h2>Encomiendas:</h2>
        <form action="" method="post" name="frm_idEncomienda" class="form-style-2">
        <ul>
            <li><label>Nro. de Encomienda:</label><input class="input-field" name="idEncomienda" type="text" value="Esta la levanta automática?" /></li>
            <li><label>Sucursal de origen:</label><input name="idSucursalOrigen" type="text" class="input-field" id="idSucursalOrigen" value="Esta la levanta automática?" /></li>
            <li><label>Destino:</label><input class="input-field" name="idDestino" type="text" value="automatico" /></li>
<!--   ---------------------FALTA SI ES NACIONAL O INTERNACIONAL---------------------------- -->
            <li><label>Sucursal actual</label><input name="" type="text" class="input-field" id="idSucursalActual" value="Esta la levanta automática?" /></li>
            <li><label>Fecha de ingreso:</label><input type="date" class="datepicker" id="fechaRecepcion" value="automática?"></li>
            <li><label>Estado:</label><input class="input-field" name="" type="text" id="estado" maxlength="20" value="automático:despachado, etc?" /></li>
          
          <!--Ahora se separa segun tipo de cliente --> 
  <div><h3 style="margin-top:20px;">Datos del envío</h3></div>         
        <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_0" />Empresa</label>
            <!--Sólo se ve si es Empresa --> 
                <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">Cliente existente:</label><select name="idCliente" class="select-field"  id="idCliente" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Cliente</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="cla_cliente" href="#nuevo_cliente.jsp"> >> Igresar nuevo cliente</a></div>
                        </li>
                        <li><label  style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de entrega:</label><select name="idDireccionEntrega" class="select-field"  id="idDireccionEntrega" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Dirección</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field" ><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                     <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;width: 180px;">Lugar de retiro:</label><select name="lugarRetiro" class="select-field"  id="lugarRetiro" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Lugar de retiro</option></select><!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px;width:180px;">Fecha de retiro:</label><input type="date" id="fechaRetiro" class="datepicker"></li>
                        <ul><li><label style="text-align:left; margin-bottom:10px; width:180px; ">Hora m&iacute;nima de retiro:</label><input type="text" id="horaMinima" class="time" /></li>
                        <li><label style="text-align:right; margin-bottom:10px; width:auto;margin-left:90px;">Hora m&aacute;xima de retiro:</label><input type="text" id="horaMaxima" class="time" /></li></ul>
                     </ul></fieldset>
                     <li><label style="text-align:left; margin-bottom:10px; width:auto;">Facturado:</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_1" />No</label></li>
                </ul></fieldset>
        
        <label style="text-align:left; font-size:16px; font-weight:bold;"><input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_1" />
            A granel</label>
         <!--Sólo se ve si es A granel --> 
            <fieldset><ul>
                 <li><label style="text-align:left; margin-bottom:10px;">Unidad granel:</label><input class="input-field" name="unidadGranel" type="text" id="unidadGranel" maxlength="100" /></li>
                 <li><label style="text-align:left; margin-bottom:10px;">Carga granel:</label><input class="input-field" name="cargaGranel" type="text" id="cargaGranel" maxlength="100" /></li>
            </ul></fieldset> 
        
          <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_2" />
            Particular</label>
        <!--Sólo se ve si es Particular --> 
          		<fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">DNI de particular:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Nombre del particular:</label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Apellido del particular:</label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>
                        <li><label  style="text-align:left; margin-bottom:10px; width:auto;">Pa&iacute;s destino:</label><select name="paisDestino" class="select-field"  id="paisDestino" style="margin-right:400px; margin-bottom:10px;width:200px;" >
                         	 <option>Seleccionar Pa&iacute;s</option></select></li>
                     	 <li><label style="text-align:left; margin-bottom:10px; width:auto;">Provincia destino:</label><select name="provinciaDestino" id="provinciaDestino" class="select-field"  style="margin-right:400px; margin-bottom:10px;width:200px;" >
                      		  <option>Seleccionar Provincia</option></select></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Localidad destino:</label><input class="input-field" name="localidadDestino" type="text" id="localidadDestino" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de destino:</label><input class="input-field" name="direccionDestino" type="text" id="direccionDestino" maxlength="100" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">C&oacute;digo postal de destino:</label><input class="input-field" name="codigoPostalDestino" type="text" id="codigoPostalDestino" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                        <li><fieldset>
                        <ul>
                            <li><label style="text-align:left; margin-bottom:10px;">Lugar de retiro:</label><input class="input-field" name="lugarRetiro" type="text" id="lugarRetiro" maxlength="100" /></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Fecha de retiro:</label><input type="date" id="fechaRetiropartic" class="datepicker"></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&iacute;nima de retiro:<input type="text" id="horaMinimaPartic" class="time" /></label>
                            <label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&aacute;xima de retiro:<input type="text" id="horaMaximaPartic" class="time" /></label></li>
                        </ul></fieldset></li>
                        <!-----------------Datos de la carga------------------------ -->         
           
            <fieldset><ul>
            	<li style="margin-top:10px; width:500px;margin-bottom:25px;">Datos de la carga</li> 
            	<li><label style="margin-bottom:10px; width:100px; ">Ancho:</label><input class="input-field-corto" name="largo" type="text" id="largo" size="18" style=" width : 100px;"/></li>
             	<li><label class="label-corto">Alto:</label><input class="input-field-corto" name="alto" type="text" id="alto" size="18" style=" width : 100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Profundidad:</label><input class="input-field-corto" name="ancho" type="text" id="ancho" size="18"  style=" width : 100px;"/>
            	<li><label class="label-corto">Peso:</label><input class="input-field-corto" name="Peso" type="text" id="peso" size="18" style=" width : 100px;"/></li>
               <li> <label style="margin-bottom:10px; width:100px; ">Volumen(cm&sup3;):</label><input class="input-field-corto" name="" type="text" id="volumen" size="18" style=" width : 100px;" /></li>
               <li> <label  class="label-corto">Tratamiento:</label><select name="tratamiento" class="select-field"  id="tratamiento" style="margin-bottom:10px; width : 152px;" >
                         	 <option>Extremadamente peligroso</option><option>Peligroso</option><option>Inocuo</option></select></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Apilable:</label>
                        <label class="input-radio-field"><input type="radio" name="Apilable" value="radio" id="Apilable_0" />Sí</label>
                        <label class="input-radio-field" style="padding-right:5px;width:60px;"><input type="radio" name="Apilable" value="radio" id="Apilable_1" />No</label>
            	<label style="width:auto;">Cantidad Apilable:</label><input class="input-field" name="Cantidad Apilable" type="text" id="cantApilable" size="10" style=" width:100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Refrigerado:</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_1" />No</label></li>
            	<li><label style="text-align:left; margin-bottom:10px;">Condición de transporte</label><textarea class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" cols="72" rows="4" style="margin-bottom:20px;"  /></li>
           		<li><label style="text-align:left; margin-bottom:10px; width:250px;">Indicaciones de manipulaci&oacute;n:</label><textarea class="input-field" type="text" id="indicacionesManipulacion" cols="72" rows="4" style="margin-bottom:20px;" /></li>      
            	<li><label style="text-align:left; margin-bottom:10px;">Fragilidad:</label><select name="fragilidad" class="select-field"  id="fragilidad" style="margin-bottom:10px;width:600px;" >
                         	 <option>Fragilidad Normal</option><option>Resistente</option><option>Frágil</option><option>Extremadamente frágil</option></select></li>
                </ul></fieldset></li>         	            
            <!-- <li><label>Coordenadas GPS:</label><input class="input-field" name="" type="text" id="coordenadaGPS" maxlength="20" /></li>        -->
           <!--  <li><label>Kil&oacute;metros Recorridos:</label><input class="input-field" name="kilometrosRecorridos" type="text" id="kilometrosRecorridos" /></li>
           
            <li><label>Distancia estimada (KM):</label><input class="input-field" name="distanciaEstimadaKM" type="text" id="distanciaEstimadaKM" /></li>
            <li><label>Distancia real (KM):</label><input class="input-field" name="distanciaRealKM" type="text" id="distanciaRealKM" /></li> -->
                        
                        <li><label style="text-align:left; margin-bottom:10px;">Archivo de manifiesto:</label><input class="input-field" name="pathManifiesto" type="text" id="pathManifiesto" maxlength="100" /></li>
            </ul></fieldset>
          
 
        
        
        
  <!-----------------Definiciones------------------------ -->          
  <li><h3 style="margin-top:20px;">Detalles del envío</h3></li> 
       <ul>        
          <li><label>Fecha de entrega estimada:</label><input type="date" class="datepicker" id="fechaEstimada" value="automática?"></li>
          <li><label>Fecha m&aacute;xima:</label><input type="date" class="datepicker" id="fechaMaxima" value="automática?"></li>
                  
          <li><label>Tercerizado:</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_1" />No</label></li>
             <!-- <li><label style="margin-right:700px; margin-bottom: 15px;">Extras</label>
             	<ul>
	   			 <li><input type="checkbox" name="Extras" value="checkbox" id="Extras_0" />Seguro<select name="idAseguradora" class="select-field" id="idAseguradora" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Aseguradora</option>
               		 <option>Aseguradora 1</option>
               		 </select></label></li>
	  			  <li><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_1" />Envío directo</label></li>
	  				<li style="display:inline; float:left;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_2" />Seguimiento Satelital</label></li>
	  				<li style="display:block; float:left; width:700px;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_3" />Seguridad<select name="idSeguridad" class="select-field" id="idSeguridad" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Seguridad</option>
               		 <option>Seguridad X</option>
               		 </select></label></li>
				</ul>
             </li>    -->        
                        
                           
            </li>
         <li><label>Valor estimado:</label><input class="input-field" name="valorEstimado" type="text" id="valorEstimado" /></li>
        <li><label>Nro. factura cliente:</label><input class="input-field" name="idFacturaCliente" type="text" id="idFacturaCliente" value="automatico" /></li></ul>
        <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div></form>
   <h2>Encomiendas:</h2>
        <form action="" method="post" name="frm_idEncomienda" class="form-style-2">
        <ul>
            <li><label>Nro. de Encomienda:</label><input class="input-field" name="idEncomienda" type="text" value="Esta la levanta automática?" /></li>
            <li><label>Sucursal de origen:</label><input name="idSucursalOrigen" type="text" class="input-field" id="idSucursalOrigen" value="Esta la levanta automática?" /></li>
            <li><label>Destino:</label><input class="input-field" name="idDestino" type="text" value="automatico" /></li>
<!--   ---------------------FALTA SI ES NACIONAL O INTERNACIONAL---------------------------- -->
            <li><label>Sucursal actual</label><input name="" type="text" class="input-field" id="idSucursalActual" value="Esta la levanta automática?" /></li>
            <li><label>Fecha de ingreso:</label><input type="date" class="datepicker" id="fechaRecepcion" value="automática?"></li>
            <li><label>Estado:</label><input class="input-field" name="" type="text" id="estado" maxlength="20" value="automático:despachado, etc?" /></li>
          
          <!--Ahora se separa segun tipo de cliente --> 
  <div><h3 style="margin-top:20px;">Datos del envío</h3></div>         
        <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_0" />Empresa</label>
            <!--Sólo se ve si es Empresa --> 
                <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">Cliente existente:</label><select name="idCliente" class="select-field"  id="idCliente" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Cliente</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="cla_cliente" href="#nuevo_cliente.jsp"> >> Igresar nuevo cliente</a></div>
                        </li>
                        <li><label  style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de entrega:</label><select name="idDireccionEntrega" class="select-field"  id="idDireccionEntrega" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Dirección</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field" ><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                     <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;width: 180px;">Lugar de retiro:</label><select name="lugarRetiro" class="select-field"  id="lugarRetiro" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Lugar de retiro</option></select><!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px;width:180px;">Fecha de retiro:</label><input type="date" id="fechaRetiro" class="datepicker"></li>
                        <ul><li><label style="text-align:left; margin-bottom:10px; width:180px; ">Hora m&iacute;nima de retiro:</label><input type="text" id="horaMinima" class="time" /></li>
                        <li><label style="text-align:right; margin-bottom:10px; width:auto;margin-left:90px;">Hora m&aacute;xima de retiro:</label><input type="text" id="horaMaxima" class="time" /></li></ul>
                     </ul></fieldset>
                     <li><label style="text-align:left; margin-bottom:10px; width:auto;">Facturado:</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_1" />No</label></li>
                </ul></fieldset>
        
        <label style="text-align:left; font-size:16px; font-weight:bold;"><input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_1" />
            A granel</label>
         <!--Sólo se ve si es A granel --> 
            <fieldset><ul>
                 <li><label style="text-align:left; margin-bottom:10px;">Unidad granel:</label><input class="input-field" name="unidadGranel" type="text" id="unidadGranel" maxlength="100" /></li>
                 <li><label style="text-align:left; margin-bottom:10px;">Carga granel:</label><input class="input-field" name="cargaGranel" type="text" id="cargaGranel" maxlength="100" /></li>
            </ul></fieldset> 
        
          <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_2" />
            Particular</label>
        <!--Sólo se ve si es Particular --> 
          		<fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">DNI de particular:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Nombre del particular:</label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Apellido del particular:</label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>
                        <li><label  style="text-align:left; margin-bottom:10px; width:auto;">Pa&iacute;s destino:</label><select name="paisDestino" class="select-field"  id="paisDestino" style="margin-right:400px; margin-bottom:10px;width:200px;" >
                         	 <option>Seleccionar Pa&iacute;s</option></select></li>
                     	 <li><label style="text-align:left; margin-bottom:10px; width:auto;">Provincia destino:</label><select name="provinciaDestino" id="provinciaDestino" class="select-field"  style="margin-right:400px; margin-bottom:10px;width:200px;" >
                      		  <option>Seleccionar Provincia</option></select></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Localidad destino:</label><input class="input-field" name="localidadDestino" type="text" id="localidadDestino" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de destino:</label><input class="input-field" name="direccionDestino" type="text" id="direccionDestino" maxlength="100" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">C&oacute;digo postal de destino:</label><input class="input-field" name="codigoPostalDestino" type="text" id="codigoPostalDestino" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                        <li><fieldset>
                        <ul>
                            <li><label style="text-align:left; margin-bottom:10px;">Lugar de retiro:</label><input class="input-field" name="lugarRetiro" type="text" id="lugarRetiro" maxlength="100" /></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Fecha de retiro:</label><input type="date" id="fechaRetiropartic" class="datepicker"></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&iacute;nima de retiro:<input type="text" id="horaMinimaPartic" class="time" /></label>
                            <label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&aacute;xima de retiro:<input type="text" id="horaMaximaPartic" class="time" /></label></li>
                        </ul></fieldset></li>
                        <!-----------------Datos de la carga------------------------ -->         
           
            <fieldset><ul>
            	<li style="margin-top:10px; width:500px;margin-bottom:25px;">Datos de la carga</li> 
            	<li><label style="margin-bottom:10px; width:100px; ">Ancho:</label><input class="input-field-corto" name="largo" type="text" id="largo" size="18" style=" width : 100px;"/></li>
             	<li><label class="label-corto">Alto:</label><input class="input-field-corto" name="alto" type="text" id="alto" size="18" style=" width : 100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Profundidad:</label><input class="input-field-corto" name="ancho" type="text" id="ancho" size="18"  style=" width : 100px;"/>
            	<li><label class="label-corto">Peso:</label><input class="input-field-corto" name="Peso" type="text" id="peso" size="18" style=" width : 100px;"/></li>
               <li> <label style="margin-bottom:10px; width:100px; ">Volumen(cm&sup3;):</label><input class="input-field-corto" name="" type="text" id="volumen" size="18" style=" width : 100px;" /></li>
               <li> <label  class="label-corto">Tratamiento:</label><select name="tratamiento" class="select-field"  id="tratamiento" style="margin-bottom:10px; width : 152px;" >
                         	 <option>Extremadamente peligroso</option><option>Peligroso</option><option>Inocuo</option></select></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Apilable:</label>
                        <label class="input-radio-field"><input type="radio" name="Apilable" value="radio" id="Apilable_0" />Sí</label>
                        <label class="input-radio-field" style="padding-right:5px;width:60px;"><input type="radio" name="Apilable" value="radio" id="Apilable_1" />No</label>
            	<label style="width:auto;">Cantidad Apilable:</label><input class="input-field" name="Cantidad Apilable" type="text" id="cantApilable" size="10" style=" width:100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Refrigerado:</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_1" />No</label></li>
            	<li><label style="text-align:left; margin-bottom:10px;">Condición de transporte</label><textarea class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" cols="72" rows="4" style="margin-bottom:20px;"  /></li>
           		<li><label style="text-align:left; margin-bottom:10px; width:250px;">Indicaciones de manipulaci&oacute;n:</label><textarea class="input-field" type="text" id="indicacionesManipulacion" cols="72" rows="4" style="margin-bottom:20px;" /></li>      
            	<li><label style="text-align:left; margin-bottom:10px;">Fragilidad:</label><select name="fragilidad" class="select-field"  id="fragilidad" style="margin-bottom:10px;width:600px;" >
                         	 <option>Fragilidad Normal</option><option>Resistente</option><option>Frágil</option><option>Extremadamente frágil</option></select></li>
                </ul></fieldset></li>         	            
            <!-- <li><label>Coordenadas GPS:</label><input class="input-field" name="" type="text" id="coordenadaGPS" maxlength="20" /></li>        -->
           <!--  <li><label>Kil&oacute;metros Recorridos:</label><input class="input-field" name="kilometrosRecorridos" type="text" id="kilometrosRecorridos" /></li>
           
            <li><label>Distancia estimada (KM):</label><input class="input-field" name="distanciaEstimadaKM" type="text" id="distanciaEstimadaKM" /></li>
            <li><label>Distancia real (KM):</label><input class="input-field" name="distanciaRealKM" type="text" id="distanciaRealKM" /></li> -->
                        
                        <li><label style="text-align:left; margin-bottom:10px;">Archivo de manifiesto:</label><input class="input-field" name="pathManifiesto" type="text" id="pathManifiesto" maxlength="100" /></li>
            </ul></fieldset>
          
 
        
        
        
  <!-----------------Definiciones------------------------ -->          
  <li><h3 style="margin-top:20px;">Detalles del envío</h3></li> 
       <ul>        
          <li><label>Fecha de entrega estimada:</label><input type="date" class="datepicker" id="fechaEstimada" value="automática?"></li>
          <li><label>Fecha m&aacute;xima:</label><input type="date" class="datepicker" id="fechaMaxima" value="automática?"></li>
                  
          <li><label>Tercerizado:</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_1" />No</label></li>
             <!-- <li><label style="margin-right:700px; margin-bottom: 15px;">Extras</label>
             	<ul>
	   			 <li><input type="checkbox" name="Extras" value="checkbox" id="Extras_0" />Seguro<select name="idAseguradora" class="select-field" id="idAseguradora" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Aseguradora</option>
               		 <option>Aseguradora 1</option>
               		 </select></label></li>
	  			  <li><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_1" />Envío directo</label></li>
	  				<li style="display:inline; float:left;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_2" />Seguimiento Satelital</label></li>
	  				<li style="display:block; float:left; width:700px;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_3" />Seguridad<select name="idSeguridad" class="select-field" id="idSeguridad" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Seguridad</option>
               		 <option>Seguridad X</option>
               		 </select></label></li>
				</ul>
             </li>    -->        
                        
                           
            </li>
         <li><label>Valor estimado:</label><input class="input-field" name="valorEstimado" type="text" id="valorEstimado" /></li>
        <li><label>Nro. factura cliente:</label><input class="input-field" name="idFacturaCliente" type="text" id="idFacturaCliente" value="automatico" /></li></ul>
        <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div></form>
   <h2>Encomiendas:</h2>
        <form action="" method="post" name="frm_idEncomienda" class="form-style-2">
        <ul>
            <li><label>Nro. de Encomienda:</label><input class="input-field" name="idEncomienda" type="text" value="Esta la levanta automática?" /></li>
            <li><label>Sucursal de origen:</label><input name="idSucursalOrigen" type="text" class="input-field" id="idSucursalOrigen" value="Esta la levanta automática?" /></li>
            <li><label>Destino:</label><input class="input-field" name="idDestino" type="text" value="automatico" /></li>
<!--   ---------------------FALTA SI ES NACIONAL O INTERNACIONAL---------------------------- -->
            <li><label>Sucursal actual</label><input name="" type="text" class="input-field" id="idSucursalActual" value="Esta la levanta automática?" /></li>
            <li><label>Fecha de ingreso:</label><input type="date" class="datepicker" id="fechaRecepcion" value="automática?"></li>
            <li><label>Estado:</label><input class="input-field" name="" type="text" id="estado" maxlength="20" value="automático:despachado, etc?" /></li>
          
          <!--Ahora se separa segun tipo de cliente --> 
  <div><h3 style="margin-top:20px;">Datos del envío</h3></div>         
        <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_0" />Empresa</label>
            <!--Sólo se ve si es Empresa --> 
                <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">Cliente existente:</label><select name="idCliente" class="select-field"  id="idCliente" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Cliente</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="cla_cliente" href="#nuevo_cliente.jsp"> >> Igresar nuevo cliente</a></div>
                        </li>
                        <li><label  style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de entrega:</label><select name="idDireccionEntrega" class="select-field"  id="idDireccionEntrega" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Dirección</option></select>
                        <!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field" ><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                     <fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;width: 180px;">Lugar de retiro:</label><select name="lugarRetiro" class="select-field"  id="lugarRetiro" style="margin-bottom:10px;width:425px;" >
                         	 <option>Seleccionar Lugar de retiro</option></select><!--Si no está ingresada --><div style="display:block; font-size: 13px; float:left; margin-top:-15px;margin-bottom:20px;"><a class="" href="#"> >> Igresar nueva direcci&oacute;n</a></div></li>
                        <li><label style="text-align:left; margin-bottom:10px;width:180px;">Fecha de retiro:</label><input type="date" id="fechaRetiro" class="datepicker"></li>
                        <ul><li><label style="text-align:left; margin-bottom:10px; width:180px; ">Hora m&iacute;nima de retiro:</label><input type="text" id="horaMinima" class="time" /></li>
                        <li><label style="text-align:right; margin-bottom:10px; width:auto;margin-left:90px;">Hora m&aacute;xima de retiro:</label><input type="text" id="horaMaxima" class="time" /></li></ul>
                     </ul></fieldset>
                     <li><label style="text-align:left; margin-bottom:10px; width:auto;">Facturado:</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="facturado" value="radio" id="facturado_1" />No</label></li>
                </ul></fieldset>
        
        <label style="text-align:left; font-size:16px; font-weight:bold;"><input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_1" />
            A granel</label>
         <!--Sólo se ve si es A granel --> 
            <fieldset><ul>
                 <li><label style="text-align:left; margin-bottom:10px;">Unidad granel:</label><input class="input-field" name="unidadGranel" type="text" id="unidadGranel" maxlength="100" /></li>
                 <li><label style="text-align:left; margin-bottom:10px;">Carga granel:</label><input class="input-field" name="cargaGranel" type="text" id="cargaGranel" maxlength="100" /></li>
            </ul></fieldset> 
        
          <label style="text-align:left; font-size:16px; font-weight:bold;">
            <input type="radio" name="Tipo cliente" value="radio" id="Tipocliente_2" />
            Particular</label>
        <!--Sólo se ve si es Particular --> 
          		<fieldset><ul>
                        <li><label style="text-align:left; margin-bottom:10px;">DNI de particular:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Nombre del particular:</label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Apellido del particular:</label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>
                        <li><label  style="text-align:left; margin-bottom:10px; width:auto;">Pa&iacute;s destino:</label><select name="paisDestino" class="select-field"  id="paisDestino" style="margin-right:400px; margin-bottom:10px;width:200px;" >
                         	 <option>Seleccionar Pa&iacute;s</option></select></li>
                     	 <li><label style="text-align:left; margin-bottom:10px; width:auto;">Provincia destino:</label><select name="provinciaDestino" id="provinciaDestino" class="select-field"  style="margin-right:400px; margin-bottom:10px;width:200px;" >
                      		  <option>Seleccionar Provincia</option></select></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Localidad destino:</label><input class="input-field" name="localidadDestino" type="text" id="localidadDestino" maxlength="50" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">Direcci&oacute;n de destino:</label><input class="input-field" name="direccionDestino" type="text" id="direccionDestino" maxlength="100" /></li>
                        <li><label style="text-align:left; margin-bottom:10px;">C&oacute;digo postal de destino:</label><input class="input-field" name="codigoPostalDestino" type="text" id="codigoPostalDestino" maxlength="10" /></li>
                        <li><label style="text-align:left; margin-bottom:10px; width:auto;">A retirar:</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_0" />Sí</label>
                            <label class="input-radio-field"><input type="radio" name="aRetirar" value="radio" id="aRetirar_1" />No</label>
                        </li>
            <!--Sólo si se retira la carga en otro lugar -->
                        <li><fieldset>
                        <ul>
                            <li><label style="text-align:left; margin-bottom:10px;">Lugar de retiro:</label><input class="input-field" name="lugarRetiro" type="text" id="lugarRetiro" maxlength="100" /></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Fecha de retiro:</label><input type="date" id="fechaRetiropartic" class="datepicker"></li>
                            <li><label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&iacute;nima de retiro:<input type="text" id="horaMinimaPartic" class="time" /></label>
                            <label style="text-align:left; margin-bottom:10px; width:auto;">Hora m&aacute;xima de retiro:<input type="text" id="horaMaximaPartic" class="time" /></label></li>
                        </ul></fieldset></li>
                        <!-----------------Datos de la carga------------------------ -->         
           
            <fieldset><ul>
            	<li style="margin-top:10px; width:500px;margin-bottom:25px;">Datos de la carga</li> 
            	<li><label style="margin-bottom:10px; width:100px; ">Ancho:</label><input class="input-field-corto" name="largo" type="text" id="largo" size="18" style=" width : 100px;"/></li>
             	<li><label class="label-corto">Alto:</label><input class="input-field-corto" name="alto" type="text" id="alto" size="18" style=" width : 100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Profundidad:</label><input class="input-field-corto" name="ancho" type="text" id="ancho" size="18"  style=" width : 100px;"/>
            	<li><label class="label-corto">Peso:</label><input class="input-field-corto" name="Peso" type="text" id="peso" size="18" style=" width : 100px;"/></li>
               <li> <label style="margin-bottom:10px; width:100px; ">Volumen(cm&sup3;):</label><input class="input-field-corto" name="" type="text" id="volumen" size="18" style=" width : 100px;" /></li>
               <li> <label  class="label-corto">Tratamiento:</label><select name="tratamiento" class="select-field"  id="tratamiento" style="margin-bottom:10px; width : 152px;" >
                         	 <option>Extremadamente peligroso</option><option>Peligroso</option><option>Inocuo</option></select></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Apilable:</label>
                        <label class="input-radio-field"><input type="radio" name="Apilable" value="radio" id="Apilable_0" />Sí</label>
                        <label class="input-radio-field" style="padding-right:5px;width:60px;"><input type="radio" name="Apilable" value="radio" id="Apilable_1" />No</label>
            	<label style="width:auto;">Cantidad Apilable:</label><input class="input-field" name="Cantidad Apilable" type="text" id="cantApilable" size="10" style=" width:100px;"/></li>
            	<li><label style="margin-bottom:10px; width:100px; ">Refrigerado:</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="Refrigerado" value="radio" id="refrigerado_1" />No</label></li>
            	<li><label style="text-align:left; margin-bottom:10px;">Condición de transporte</label><textarea class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" cols="72" rows="4" style="margin-bottom:20px;"  /></li>
           		<li><label style="text-align:left; margin-bottom:10px; width:250px;">Indicaciones de manipulaci&oacute;n:</label><textarea class="input-field" type="text" id="indicacionesManipulacion" cols="72" rows="4" style="margin-bottom:20px;" /></li>      
            	<li><label style="text-align:left; margin-bottom:10px;">Fragilidad:</label><select name="fragilidad" class="select-field"  id="fragilidad" style="margin-bottom:10px;width:600px;" >
                         	 <option>Fragilidad Normal</option><option>Resistente</option><option>Frágil</option><option>Extremadamente frágil</option></select></li>
                </ul></fieldset></li>         	            
            <!-- <li><label>Coordenadas GPS:</label><input class="input-field" name="" type="text" id="coordenadaGPS" maxlength="20" /></li>        -->
           <!--  <li><label>Kil&oacute;metros Recorridos:</label><input class="input-field" name="kilometrosRecorridos" type="text" id="kilometrosRecorridos" /></li>
           
            <li><label>Distancia estimada (KM):</label><input class="input-field" name="distanciaEstimadaKM" type="text" id="distanciaEstimadaKM" /></li>
            <li><label>Distancia real (KM):</label><input class="input-field" name="distanciaRealKM" type="text" id="distanciaRealKM" /></li> -->
                        
                        <li><label style="text-align:left; margin-bottom:10px;">Archivo de manifiesto:</label><input class="input-field" name="pathManifiesto" type="text" id="pathManifiesto" maxlength="100" /></li>
            </ul></fieldset>
          
 
        
        
        
  <!-----------------Definiciones------------------------ -->          
  <li><h3 style="margin-top:20px;">Detalles del envío</h3></li> 
       <ul>        
          <li><label>Fecha de entrega estimada:</label><input type="date" class="datepicker" id="fechaEstimada" value="automática?"></li>
          <li><label>Fecha m&aacute;xima:</label><input type="date" class="datepicker" id="fechaMaxima" value="automática?"></li>
                  
          <li><label>Tercerizado:</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_0" />Sí</label>
                        <label class="input-radio-field"><input type="radio" name="tercerizado" value="radio" id="tercerizado_1" />No</label></li>
             <!-- <li><label style="margin-right:700px; margin-bottom: 15px;">Extras</label>
             	<ul>
	   			 <li><input type="checkbox" name="Extras" value="checkbox" id="Extras_0" />Seguro<select name="idAseguradora" class="select-field" id="idAseguradora" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Aseguradora</option>
               		 <option>Aseguradora 1</option>
               		 </select></label></li>
	  			  <li><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_1" />Envío directo</label></li>
	  				<li style="display:inline; float:left;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_2" />Seguimiento Satelital</label></li>
	  				<li style="display:block; float:left; width:700px;"><label><input type="checkbox" name="Extras" value="checkbox" id="Extras_3" />Seguridad<select name="idSeguridad" class="select-field" id="idSeguridad" style="line-height:15px; width:600px;margin-bottom: 20px;" title="Aseguradora">
                	<option>Seleccionar Seguridad</option>
               		 <option>Seguridad X</option>
               		 </select></label></li>
				</ul>
             </li>    -->        
                        
                           
            </li>
         <li><label>Valor estimado:</label><input class="input-field" name="valorEstimado" type="text" id="valorEstimado" /></li>
        <li><label>Nro. factura cliente:</label><input class="input-field" name="idFacturaCliente" type="text" id="idFacturaCliente" value="automatico" /></li></ul>
        <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div></form>
 
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>