<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	 <title>Der groe Verteiler - Distribuci&oacute;n y env&iacute;os</title>

	 <script src="jquery/jquery-2.1.1.js" type="text/javascript"></script>
	 <script type="text/javascript" src="js/mainmenu.js"></script>
	 <script src="jquery/jquery-ui.js" type="text/javascript"></script>
	 <script type="text/javascript" src="jquery/jquery.timepicker.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script type='text/javascript' src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
	 
	 <!-- Hojas de estilo -->
    <link rel="stylesheet" type="text/css" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
	<link href="jquery/jquery-ui.css" rel="stylesheet" type="text/css" />

	 <link href="css/jquery.timepicker.css" rel="stylesheet" type="text/css">
	 
	 <!-- Fonts -->
	 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
	 <link href="css/font-awesome.css" rel="stylesheet" type="text/css" >
	 
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

<script type="text/javascript">
$(document).ready(function() {
	console.log("js document ready begin");
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
		$("#nombreUsuario").text("Hola " + usuario + " ("+sucursalNom+")" );
		$("#lCerrarSesion").text("Cerrar Sesion");
		$("#cerrarSesion").load("logout.jsp");
	}
		  	  
	console.log("complete document ready");;	   
	}); //document ready

</script>

	
	 
			<div class="inner relative">
				<ul style="width:227px;">
					<li style="width:230px;">
						<a class="logo" href="main.jsp">
							<img src="images/logo_web_dgv_02.jpg" alt="Der grobe Verteiler" border="0">
							</a>
						</li>
						<li class="logueado" style="width:227px; margin-top:10px;font-size:18px; line-height:25px; color:#f0af1e;">
							<span id="nombreUsuario"> </span>               
						</li>
						<div id="cerrarSesion" style="width:227px;color:#fff; font-size:14px;" > </div>           	
					</ul>
					<%if(usuario!="") { %>
					<a id="menu-toggle" class="button dark" href="#"/>
					<nav id="navigation">
						<ul id="main-menu">
							<li class="current-menu-item">
								<a href="">HOME</a>
							</li>
							<li class="parent">
								<a class="parent" href="#"> ENCOMIENDA</a>
								<ul class="sub-menu">
									<li>
										<a id="menu_ver_encom_particular" href="encomiendasListado.jsp">Ver Encomiendas Particulares</a>
									</li>								
									<li>
										<a id="menu_new_encom_particular" href="altaEncomiendaParticular.jsp">Nueva Encomienda Particular</a>
									</li>
									<li>
										<a id="menu_ver_encom_empresa" href="encomiendasListadoEmpresa.jsp">Ver Encomiendas Empresas</a>
									</li>									
									<li>
										<a id="menu_new_encom_empresa" href="altaEncomiendaEmpresa.jsp">Nueva Encomienda Empresa</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a class="parent" href="#"> ENV&Iacute;OS</a>
								<ul class="sub-menu">
									<li>
										<a href=" "> Recepci&oacute;n</a>
									</li>
									<li>
										<a href=" ">Env&iacute;os propios</a>
									</li>
									<li>
										<a href=" ">Env&iacute;os tercerizados</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a href=" ">CLIENTES</a>
								<ul class="sub-menu">
									<li>
										<a id="menu_nuevo_cliente">Nuevo Clientes</a>
									</li>
									<li>
										<a id="mClientes">Buscar Clientes</a>
									</li>
									<li>
										<a href=" ">Cuentas corrientes</a>
									</li>
								</ul>
							</li>   
							<li class="parent">
								<a href=" ">VIAJES</a>
								<ul class="sub-menu">
									<li>
										<a href=" ">Control de viajes</a>
									</li>
									<li>
										<a href=" ">Contrataci&oacute;n de viajes</a>
									</li>
								</ul>
							</li>
							<!--<li class="parent" style="text-align:left;display: inline-block;">
								<a href=" ">COBROS/PAGOS</a>
								<ul class="sub-menu">
									<li>
										<a id="menu_pagar_fact_particular">Pagar Factura Particular</a>
									</li>
									<li>
										<a id="menu_pagar_fact_empresa">Pagar Factura Empresa</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a class="parent" href="#">VEH&Iacute;CULOS</a>
								<ul class="sub-menu">
									<li>
										<a href=" ">Veh&iacute;culos propios</a>
									</li>
									<li>
										<a href=" ">Mantenimiento</a>
									</li>
									<li>
										<a href=" ">Veh&iacute;culos contratados</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a class="parent" href="#">ADMINISTRACI&Oacute;N</a>
								<ul class="sub-menu">
									<li>
										<a href=" "> Empleados</a>
									</li>
									<li>
										<a href=" "> Veh&iacute;culos</a>
									</li>
									<li>
										<a href=" "> Proveedores</a>
									</li>
									<li>
										<a href=" "> Precios transportes y carriers</a>
									</li>
									<li>
										<a href=" "> Seguros</a>
									</li>
									<li>
										<a href=" "> Maps de rutas</a>
									</li>
								</ul>
							</li>
							<li class="parent">
								<a class="parent" href="#">SUCURSALES</a>
								<ul class="sub-menu">
									<li>
										<a href=" "> Sucursales</a>
									</li>
									<li>
										<a href=" "> Novedades de caminos</a>
									</li>    
								</ul>    
							</li>       -->
						</ul>            
					</nav><%} %>
					<div class="clear"/>
				</div>

			</head>
		</html>