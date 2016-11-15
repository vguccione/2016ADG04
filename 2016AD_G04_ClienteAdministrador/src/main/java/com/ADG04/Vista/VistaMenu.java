package com.ADG04.Vista;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.*;

import com.ADG04.Controller.Controlador;
import com.ADG04.Vista.Administrativos.AltaMapaDeRuta;
import com.ADG04.Vista.Administrativos.AltaSucursal;
import com.ADG04.Vista.Administrativos.AltaUsuario;
import com.ADG04.Vista.Administrativos.BajaMapaDeRuta;
import com.ADG04.Vista.Administrativos.BajaSucursal;
import com.ADG04.Vista.Administrativos.BajaUsuario;
import com.ADG04.Vista.Administrativos.BusquedaMapaDeRuta;
import com.ADG04.Vista.Administrativos.BusquedaScursal;
import com.ADG04.Vista.Administrativos.CambiarContrasena;
import com.ADG04.Vista.Clientes.AltaClienteEmpresa;
import com.ADG04.Vista.Clientes.AltaClienteParticular;
import com.ADG04.Vista.Clientes.AltaProductoCliente;
import com.ADG04.Vista.Clientes.BajaCliente;
import com.ADG04.Vista.Clientes.BajaProductoCliente;
import com.ADG04.Vista.Clientes.BusquedaCliente;
import com.ADG04.Vista.Listados.BusquedaEncomienda;
import com.ADG04.Vista.Listados.BusquedaEnvio;
import com.ADG04.Vista.Listados.BusquedaManifiesto;
import com.ADG04.Vista.Listados.BusquedaRemito;
import com.ADG04.Vista.Listados.ListadoAseguradoras;
import com.ADG04.Vista.Listados.ListadoCarriers;
import com.ADG04.Vista.Listados.ListadoCliente;
import com.ADG04.Vista.Listados.ListadoEmpresa;
import com.ADG04.Vista.Listados.ListadoEmpresaSeguridad;
import com.ADG04.Vista.Listados.ListadoEncomiendasEmpresa;
import com.ADG04.Vista.Listados.ListadoEncomiendasParticular;
import com.ADG04.Vista.Listados.ListadoEnviosPropios;
import com.ADG04.Vista.Listados.ListadoEnviosTercerizados;
import com.ADG04.Vista.Listados.ListadoFacturasClientes;
import com.ADG04.Vista.Listados.ListadoFacturasClientesPendientes;
import com.ADG04.Vista.Listados.ListadoManifiestos;
import com.ADG04.Vista.Listados.ListadoMapasDeRuta;
import com.ADG04.Vista.Listados.ListadoPlanMantenimiento;
import com.ADG04.Vista.Listados.ListadoProducto;
import com.ADG04.Vista.Listados.ListadoProveedores;
import com.ADG04.Vista.Listados.ListadoRemitos;
import com.ADG04.Vista.Listados.ListadoSeguros;
import com.ADG04.Vista.Listados.ListadoServicioSeguridad;
import com.ADG04.Vista.Listados.ListadoSucursales;
import com.ADG04.Vista.Listados.ListadoTalleres;
import com.ADG04.Vista.Listados.ListadoTareasRealizadas;
import com.ADG04.Vista.Listados.ListadoTarifasCarriers;
import com.ADG04.Vista.Listados.ListadoUsuarios;
import com.ADG04.Vista.Listados.ListadoVehiculos;
import com.ADG04.Vista.Proveedores.AltaProveedor;
import com.ADG04.Vista.Proveedores.AltaSeguro;
import com.ADG04.Vista.Proveedores.AltaServicioSeguridad;
import com.ADG04.Vista.Proveedores.AltaTarifaCarrier;
import com.ADG04.Vista.Proveedores.BajaProveedor;
import com.ADG04.Vista.Proveedores.BajaSeguro;
import com.ADG04.Vista.Proveedores.BajaServicioSeguridad;
import com.ADG04.Vista.Proveedores.BajaTarifaCarrier;
import com.ADG04.Vista.Proveedores.BusquedaProveedor;
import com.ADG04.Vista.Proveedores.BusquedaSeguro;
import com.ADG04.Vista.Proveedores.BusquedaServicioSeguridad;
import com.ADG04.Vista.Proveedores.BusquedaTarifasCarrier;
import com.ADG04.Vista.Vehiculos.AgregarTareaAPlan;
import com.ADG04.Vista.Vehiculos.AltaPlanMantenimiento;
import com.ADG04.Vista.Vehiculos.AltaVehiculo;
import com.ADG04.Vista.Vehiculos.BajaPlanMantenimiento;
import com.ADG04.Vista.Vehiculos.BajaVehiculo;
import com.ADG04.Vista.Vehiculos.BusquedaVehiculo;
import com.ADG04.Vista.Vehiculos.RegistrarTareaRealizada;
import com.ADG04.bean.Administracion.DTO_Rol;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie 	, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VistaMenu extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
	/*	try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}

	//private JMenuItem helpVistaMenuItem;
	private JMenu JMenu5;
	private JMenu JMenu6;
	//private JSeparator jSeparatorAyuda;
	private JMenuItem JMenuItem1;
	private JMenuItem JMenuItem2;
	private JMenuItem JMenuItem3;
	private JMenuItem JMenuItem4;
	private JMenuItem JMenuItem5;
	private JMenuItem JMenuItem6;
	private JMenuItem JMenuItem8;
	private JMenuItem JMenuItemAltaVehiculo;
	private JMenuItem JMenuItem11;
	private JMenuItem JMenuItem12;
	private JMenuItem JMenuItem13;
	private JMenuItem JMenuItem14;
	private JMenuItem JMenuItem15;
	private JMenuItem JMenuItem16;
	private JMenu JMenuCliente;
	private JMenu JMenuSucursal;
	private JMenuItem JMenuItemRealizarMantenimiento;
	private JSeparator jSeparatorVehiculo1;
	private JMenuItem JMenuItemBajaPlanMantenimiento;
	private JMenuItem JMenuItemAltaPlanMantenimiento;
	private JMenu JMenuPlanMantenimiento;
	private JSeparator jSeparatorVehiculo;
	private JMenuItem JMenuItemBajaVehiculo;
	private JMenuItem JMenuItemModificarVehiculo;
	private JMenuItem JMenuItemModificarProveedor;
	private JMenu JMenuProductoCliente;
	private JMenuItem JMenuItemAltaProductoCliente	;
	private JMenuItem JMenuItemBajaProductoCliente;
	
	private JSeparator jSeparatorCliente;
	private JMenuItem JMenuItemBajaMDR;
	private JMenuItem JMenuItemModificarDestino;
	private JMenuItem JMenuItemAltaDestino;
	private JSeparator jSeparatorSucursal;
	private JMenuItem JMenuItemModificarSucursal;
	private JSeparator jSeparatorUsuario;
	private JMenuItem JMenuItemCambiarPassword;
	private JMenuItem JMenuItemBajaUsuario;
	private JMenuItem JMenuItemAltaUsuario;
	private JMenuItem JMenuItemBajaEmpleado;
	private JMenuItem JMenuItemAltaEmpleado;
	private JMenuItem JMenuItemBajaServicioSeguridad;
	private JMenuItem JMenuItemModificarServicioSeguridad;
	private JMenuItem JMenuItemAltaServicioSeguridad;
	private JMenuItem JMenuItemBajaSeguro;
	private JMenuItem JMenuItemModificarSeguro;
	private JMenuItem JMenuItemAltaSeguro;
	private JMenuItem JMenuItemBajaTarifasCarrier;
	private JMenu JMenuSeguridad;
	private JSeparator jSeparatorProveedor3;
	private JMenu JMenuSeguro;
	private JSeparator jSeparatorProveedor2;
	private JMenu JMenuUsuario;
	private JMenu JMenuEmpleado;
	private JMenu JMenuProveedor;
	private JMenu JMenuVehiculo;
	private JMenuItem JMenuItemAcercaDe;
	private JMenuItem JMenuItem31;
	private JSeparator jSeparator7;
	private JMenuItem JMenuItem30;
	private JMenuItem JMenuItem29;
	private JMenuItem JMenuItem28;
	private JMenuItem JMenuItem27;
	private JMenuItem JMenuItem26;
	private JMenu JMenu7;
	private JMenu JMenu2;
	private JSeparator jSeparator6;
	private JMenuItem JMenuItem25;
	private JMenuItem JMenuItem24;
	private JMenu JMenu1;
	private JSeparator jSeparator5;
	private JMenuItem JMenuItem21;
	private JMenuItem JMenuItem20;

	private JSeparator jSeparator3;
	private JSeparator jSeparator1;
	private JMenuItem JMenuItem18;
	private JMenuItem JMenuItem17;
	private JMenuItem JMenuItem10;
	private JMenuItem JMenuItem9;
	private JMenuItem jMenuItem24;
	private JMenuItem jMenuItem23;
	private JMenu JMenuProveedores;
	private JMenu JMenuConsultasClientes;
	private JMenu JMenuConsultasVehiculos;
	private JMenu JMenuConsultasUsuarios;
	private JMenu JMenuConsultasSucursales;
	private JMenu JMenuConsultasEmpleados;
	private JMenu JMenuMapaDeRuta;
	private JLabel jLabelTitulo;
	private JLabel jLabelLogo;
	private JPanel jPanel1;
	private JMenu JMenu4;
	private JMenuItem exitVistaMenuItem;
	private JSeparator jSeparator2;
	private JMenu JMenu3;
	private JMenuBar JMenuBar1;
	private JSeparator jSeparatorSucursal3;
	private JMenuItem JMenuItemAgregarTarea;
	private int codigoUsuario;
	private JMenu JMenuTarifasCarrier;
	private JMenuItem JMenuItemAltaTarifas;
	private JMenuItem JMenuItemModificarTarifasCarrier;
	
	
	public VistaMenu(int codigoUsuario){
		super();
		this.codigoUsuario = codigoUsuario;
		initGUI();
	}
		
	
	private  void initGUI() {
		Collection<String> roles = Controlador.getInstancia().buscarRolesUsuario(codigoUsuario);
		try {
			{
				this.setResizable(false);
				this.setTitle("Sistema de Administracion Der große Verteiler");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(502, 284));
				{
					jLabelLogo = new JLabel();
					jLabelLogo.setLayout(null);
				}
				{
					jLabelTitulo = new JLabel();
					jLabelTitulo.setText("Der große Verteiler");
					jLabelTitulo.setFont(new java.awt.Font("Tahoma",1,20));
					jLabelTitulo.setLayout(null);
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
				    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addGap(100)
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addGroup(jPanel1Layout.createSequentialGroup()
					                .addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 0, Short.MAX_VALUE))
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addGap(23)
					                .addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 20, Short.MAX_VALUE)))
					        .addGap(106)))
					.addGap(6));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE));
			}
			this.setSize(437, 344);
			{
				JMenuBar1 = new JMenuBar();
				setJMenuBar(JMenuBar1);
				{
					JMenu4 = new JMenu();
					JMenuBar1.add(JMenu4);
					JMenu4.setText("Administracion");
					{
						JMenuCliente = new JMenu();
						JMenu4.add(JMenuCliente);
						JMenuCliente.setLayout(null);
						JMenuCliente.setText("Cliente");
						JMenuCliente.setVisible(true);
						{
							JMenuItem5 = new JMenuItem();
							JMenuCliente.add(JMenuItem5);
							JMenuItem5.setLayout(null);
							JMenuItem5.setText("Alta Empresa");
							JMenuItem5.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaClienteEmpresa inst = new AltaClienteEmpresa(null);
									inst.getFrmAplicacionesDistribuidas().setVisible(true);
								}
							});
						}
						{
							JMenuItem5 = new JMenuItem();
							JMenuCliente.add(JMenuItem5);
							JMenuItem5.setLayout(null);
							JMenuItem5.setText("Alta Cliente Particular");
							JMenuItem5.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaClienteParticular inst = new AltaClienteParticular(null);
									inst.getFrmAplicacionesDistribuidas().setVisible(true);
								}
							});
						}
						{
							JMenuItem6 = new JMenuItem();
							JMenuCliente.add(JMenuItem6);
							JMenuItem6.setLayout(null);
							JMenuItem6.setText("Modificar Cliente");
							JMenuItem6.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaCliente inst = new BusquedaCliente();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						
						
					}
					{
						JMenuProveedor = new JMenu();
						JMenu4.add(JMenuProveedor);
						JMenuProveedor.setLayout(null);
						JMenuProveedor.setText("Proveedor");
						if (roles.contains("ADMINISTRACION")) {
							JMenuProveedor.setVisible(true);
						} else {
							JMenuProveedor.setVisible(false);
						}
						{
							JMenuItem1 = new JMenuItem();
							JMenuProveedor.add(JMenuItem1);
							JMenuItem1.setLayout(null);
							JMenuItem1.setText("Alta Proveedor");
							JMenuItem1.setBounds(93, -21, 119, 21);
							JMenuItem1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaProveedor inst = new AltaProveedor(null);
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItemModificarProveedor = new JMenuItem();
							JMenuProveedor.add(JMenuItemModificarProveedor);
							JMenuItemModificarProveedor.setText("Modificar Proveedor");
							JMenuItemModificarProveedor.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaProveedor inst = new BusquedaProveedor();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem2 = new JMenuItem();
							JMenuProveedor.add(JMenuItem2);
							JMenuItem2.setLayout(null);
							JMenuItem2.setText("Baja Proveedor");
							JMenuItem2.setBounds(93, 0, 119, 21);
							JMenuItem2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BajaProveedor inst = new BajaProveedor();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparatorProveedor2 = new JSeparator();
							JMenuProveedor.add(jSeparatorProveedor2);
							jSeparatorProveedor2.setBounds(93, 79, 119, 8);
						}
						{
							JMenuSeguro = new JMenu();
							JMenuProveedor.add(JMenuSeguro);
							JMenuSeguro.setText("Seguro");
							JMenuSeguro.setBounds(93, 87, 119, 21);
							{
								JMenuItemAltaSeguro = new JMenuItem();
								JMenuSeguro.add(JMenuItemAltaSeguro);
								JMenuItemAltaSeguro.setText("Alta Seguro");
								JMenuItemAltaSeguro.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AltaSeguro inst = new AltaSeguro(null);
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemModificarSeguro = new JMenuItem();
								JMenuSeguro.add(JMenuItemModificarSeguro);
								JMenuItemModificarSeguro.setText("Modificar Seguro");
								JMenuItemModificarSeguro.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BusquedaSeguro inst = new BusquedaSeguro();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemBajaSeguro = new JMenuItem();
								JMenuSeguro.add(JMenuItemBajaSeguro);
								JMenuItemBajaSeguro.setText("Baja Seguro");
								JMenuItemBajaSeguro.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BajaSeguro inst = new BajaSeguro();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
						}
						{
							jSeparatorProveedor3 = new JSeparator();
							JMenuProveedor.add(jSeparatorProveedor3);
							jSeparatorProveedor3.setBounds(93, 108, 119, 8);
						}
						{
							JMenuSeguridad = new JMenu();
							JMenuProveedor.add(JMenuSeguridad);
							JMenuSeguridad.setText("Servicio Seguridad");
							JMenuSeguridad.setBounds(93, 116, 119, 21);
							{
								JMenuItemAltaServicioSeguridad = new JMenuItem();
								JMenuSeguridad.add(JMenuItemAltaServicioSeguridad);
								JMenuItemAltaServicioSeguridad.setText("Alta Servicio Seguridad");
								JMenuItemAltaServicioSeguridad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AltaServicioSeguridad inst = new AltaServicioSeguridad(null);
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemModificarServicioSeguridad = new JMenuItem();
								JMenuSeguridad.add(JMenuItemModificarServicioSeguridad);
								JMenuItemModificarServicioSeguridad.setText("Modificar Servicio Seguridad");
								JMenuItemModificarServicioSeguridad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BusquedaServicioSeguridad inst = new BusquedaServicioSeguridad();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemBajaServicioSeguridad = new JMenuItem();
								JMenuSeguridad.add(JMenuItemBajaServicioSeguridad);
								JMenuItemBajaServicioSeguridad.setText("Baja Servicio Seguridad");
								JMenuItemBajaServicioSeguridad.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BajaServicioSeguridad inst = new BajaServicioSeguridad();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
						}
							{
								JMenuTarifasCarrier = new JMenu();
								JMenuProveedor.add(JMenuTarifasCarrier);
								JMenuTarifasCarrier.setText("Tarifas Carrier");
								JMenuTarifasCarrier.setBounds(93, 87, 119, 21);
								{
									JMenuItemAltaTarifas = new JMenuItem();
									JMenuTarifasCarrier.add(JMenuItemAltaTarifas);
									JMenuItemAltaTarifas.setText("Alta Tarifas Carrier");
									JMenuItemAltaTarifas.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											AltaTarifaCarrier inst = new AltaTarifaCarrier(null);
											inst.setLocationRelativeTo(null);
											inst.setVisible(true);
										}
									});
								}
								{
									JMenuItemModificarTarifasCarrier = new JMenuItem();
									JMenuTarifasCarrier.add(JMenuItemModificarTarifasCarrier);
									JMenuItemModificarTarifasCarrier.setText("Modificar Tarifas Carrier");
									JMenuItemModificarTarifasCarrier.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											BusquedaTarifasCarrier inst = new BusquedaTarifasCarrier();
											inst.setLocationRelativeTo(null);
											inst.setVisible(true);
										}
									});
								}
								{
									JMenuItemBajaTarifasCarrier = new JMenuItem();
									JMenuTarifasCarrier.add(JMenuItemBajaTarifasCarrier);
									JMenuItemBajaTarifasCarrier.setText("Baja Tarifas Carrier");
									JMenuItemBajaTarifasCarrier.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											BajaTarifaCarrier inst = new BajaTarifaCarrier();
											inst.setLocationRelativeTo(null);
											inst.setVisible(true);
										}
									});
								}
							
							}
						{
							JMenuItem8 = new JMenuItem();
							JMenuCliente.add(JMenuItem8);
							JMenuItem8.setLayout(null);
							JMenuItem8.setText("Baja Cliente");
							JMenuItem8.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BajaCliente inst = new BajaCliente();
									inst.getFrame().setLocationRelativeTo(null);
									inst.getFrame().setVisible(true);
								}
							});
						}
						{
							jSeparatorCliente = new JSeparator();
							JMenuCliente.add(jSeparatorCliente);
						}

						
						{
							JMenuProductoCliente = new JMenu();
							JMenuCliente.add(JMenuProductoCliente);
							JMenuProductoCliente.setText("Producto");
							{
								JMenuItemAltaProductoCliente = new JMenuItem();
								JMenuProductoCliente.add(JMenuItemAltaProductoCliente);
								JMenuItemAltaProductoCliente.setText("Alta Producto");
								JMenuItemAltaProductoCliente.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AltaProductoCliente inst = new AltaProductoCliente();
										inst.getFrame().setLocationRelativeTo(null);
										inst.getFrame().setVisible(true);
									}
								});
							}
							{
								JMenuItemBajaProductoCliente = new JMenuItem();
								JMenuProductoCliente.add(JMenuItemBajaProductoCliente);
								JMenuItemBajaProductoCliente.setText("Baja Producto");
								JMenuItemBajaProductoCliente.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BajaProductoCliente inst = new BajaProductoCliente();
										inst.getFrame().setLocationRelativeTo(null);
										inst.getFrame().setVisible(true);
									}
								});
							}
						}
						
					}
					{
						JMenuSucursal = new JMenu();
						JMenu4.add(JMenuSucursal);
						JMenuSucursal.setLayout(null);
						JMenuSucursal.setText("Sucursal");
						if (roles.contains("ADMINISTRACION")) {
							JMenuSucursal.setVisible(true);
						} else {
							JMenuSucursal.setVisible(false);
						}
						{
							JMenuItem3 = new JMenuItem();
							JMenuSucursal.add(JMenuItem3);
							JMenuItem3.setLayout(null);
							JMenuItem3.setText("Alta Sucursal");
							JMenuItem3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaSucursal inst = new AltaSucursal(null);
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItemModificarSucursal = new JMenuItem();
							JMenuSucursal.add(JMenuItemModificarSucursal);
							JMenuItemModificarSucursal.setText("Modificar Sucursal");
							JMenuItemModificarSucursal.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaScursal inst = new BusquedaScursal();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem4 = new JMenuItem();
							JMenuSucursal.add(JMenuItem4);
							JMenuItem4.setLayout(null);
							JMenuItem4.setText("Baja Sucursal");
							JMenuItem4.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BajaSucursal inst = new BajaSucursal();
									inst.getFrame().setLocationRelativeTo(null);
									inst.getFrame().setVisible(true);
								}
							});
						}
						{
							jSeparatorSucursal = new JSeparator();
							JMenuSucursal.add(jSeparatorSucursal);
						}
						
						{
							JMenuMapaDeRuta = new JMenu();
							JMenuSucursal.add(JMenuMapaDeRuta);
							JMenuMapaDeRuta.setText("Mapa de Ruta");
							{
								JMenuItemAltaDestino = new JMenuItem();
								JMenuMapaDeRuta.add(JMenuItemAltaDestino);
								JMenuItemAltaDestino.setText("Alta Mapa de Ruta");
								JMenuItemAltaDestino.setBounds(0, -63, 110, 21);
								JMenuItemAltaDestino.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AltaMapaDeRuta inst = new AltaMapaDeRuta(null);
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemModificarDestino = new JMenuItem();
								JMenuMapaDeRuta.add(JMenuItemModificarDestino);
								JMenuItemModificarDestino.setText("Modificar Mapa de Ruta");
								JMenuItemModificarDestino.setBounds(0, -42, 110, 21);
								JMenuItemModificarDestino.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BusquedaMapaDeRuta inst = new BusquedaMapaDeRuta();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemBajaMDR = new JMenuItem();
								JMenuMapaDeRuta.add(JMenuItemBajaMDR);
								JMenuItemBajaMDR.setText("Baja Mapa de Ruta");
								JMenuItemBajaMDR.setBounds(0, -21, 110, 21);
								JMenuItemBajaMDR.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BajaMapaDeRuta inst = new BajaMapaDeRuta();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
						}
					}
					{
						JMenuVehiculo = new JMenu();
						JMenu4.add(JMenuVehiculo);
						JMenuVehiculo.setLayout(null);
						JMenuVehiculo.setText("Vehiculo");
						if (roles.contains("VEHICULOS")) {
							JMenuVehiculo.setVisible(true);
						} else {
							JMenuVehiculo.setVisible(false);
						}
						{
							JMenuItemAltaVehiculo = new JMenuItem();
							JMenuVehiculo.add(JMenuItemAltaVehiculo);
							JMenuItemAltaVehiculo.setLayout(null);
							JMenuItemAltaVehiculo.setText("Alta Vehiculo");
							JMenuItemAltaVehiculo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaVehiculo inst = new AltaVehiculo(null);
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItemModificarVehiculo = new JMenuItem();
							JMenuVehiculo.add(JMenuItemModificarVehiculo);
							JMenuItemModificarVehiculo.setText("Modificar Vehiculo");
							JMenuItemModificarVehiculo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaVehiculo inst = new BusquedaVehiculo();
									inst.getFrame().setLocationRelativeTo(null);
									inst.getFrame().setVisible(true);
								}
							});
						}
						{
							JMenuItemBajaVehiculo = new JMenuItem();
							JMenuVehiculo.add(JMenuItemBajaVehiculo);
							JMenuItemBajaVehiculo.setText("Baja Vehiculo");
							JMenuItemBajaVehiculo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BajaVehiculo inst = new BajaVehiculo();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparatorVehiculo = new JSeparator();
							JMenuVehiculo.add(jSeparatorVehiculo);
						}
						{
							JMenuPlanMantenimiento = new JMenu();
							JMenuVehiculo.add(JMenuPlanMantenimiento);
							JMenuPlanMantenimiento.setText("Plan Mantenimiento");
							{
								JMenuItemAltaPlanMantenimiento = new JMenuItem();
								JMenuPlanMantenimiento.add(JMenuItemAltaPlanMantenimiento);
								JMenuItemAltaPlanMantenimiento.setText("Alta Plan Mantenimiento");
								JMenuItemAltaPlanMantenimiento.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AltaPlanMantenimiento inst = new AltaPlanMantenimiento();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{
								JMenuItemBajaPlanMantenimiento = new JMenuItem();
								JMenuPlanMantenimiento.add(JMenuItemBajaPlanMantenimiento);
								JMenuItemBajaPlanMantenimiento.setText("Baja Plan Mantenimiento");
								JMenuItemBajaPlanMantenimiento.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BajaPlanMantenimiento inst = new BajaPlanMantenimiento();
										inst.getFrame().setLocationRelativeTo(null);
										inst.getFrame().setVisible(true);
									}
								});
							}
							{
								jSeparatorSucursal3 = new JSeparator();
								JMenuPlanMantenimiento.add(jSeparatorSucursal3);
							}
							{
								JMenuItemAgregarTarea = new JMenuItem();
								JMenuPlanMantenimiento.add(JMenuItemAgregarTarea);
								JMenuItemAgregarTarea.setText("Agregar Tarea Mantenimiento");
								JMenuItemAgregarTarea.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										AgregarTareaAPlan inst = new AgregarTareaAPlan();
										inst.getFrame().setLocationRelativeTo(null);
										inst.getFrame().setVisible(true);
									}
								});
							}
						}
						{
							jSeparatorVehiculo1 = new JSeparator();
							JMenuVehiculo.add(jSeparatorVehiculo1);
						}
						{
							JMenuItemRealizarMantenimiento = new JMenuItem();
							JMenuVehiculo.add(JMenuItemRealizarMantenimiento);
							JMenuItemRealizarMantenimiento.setText("Realizar Mantenimiento");
							JMenuItemRealizarMantenimiento.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									RegistrarTareaRealizada inst = new RegistrarTareaRealizada();
									inst.getFrame().setLocationRelativeTo(null);
									inst.getFrame().setVisible(true);
								}
							});
						
						
						
							
						}
					}
					{
						JMenuUsuario = new JMenu();
						JMenu4.add(JMenuUsuario);
						JMenuUsuario.setText("Usuario");
						if (roles.contains("ADMINISTRACION")) {
							JMenuUsuario.setVisible(true);
						} else {
							JMenuUsuario.setVisible(false);
						}
						{
							JMenuItemAltaUsuario = new JMenuItem();
							JMenuUsuario.add(JMenuItemAltaUsuario);
							JMenuItemAltaUsuario.setText("Alta Usuario");
							JMenuItemAltaUsuario.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									AltaUsuario inst = new AltaUsuario();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItemBajaUsuario = new JMenuItem();
							JMenuUsuario.add(JMenuItemBajaUsuario);
							JMenuItemBajaUsuario.setText("Baja Usuario");
							JMenuItemBajaUsuario.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BajaUsuario inst = new BajaUsuario(codigoUsuario);
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparatorUsuario = new JSeparator();
							JMenuUsuario.add(jSeparatorUsuario);
						}
						{
							JMenuItemCambiarPassword = new JMenuItem();
							JMenuUsuario.add(JMenuItemCambiarPassword);
							JMenuItemCambiarPassword.setText("Cambiar Password");
							JMenuItemCambiarPassword.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									CambiarContrasena inst = new CambiarContrasena();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
				}
				{
					JMenu6 = new JMenu();
					JMenuBar1.add(JMenu6);
					JMenu6.setText("Consultas");
					{
						JMenu2 = new JMenu();
						JMenu6.add(JMenu2);
						JMenu2.setText("Encomiendas");
						JMenu2.setBounds(104, 0, 79, 19);
						if (roles.contains("ENCOMIENDA")) {
							JMenu2.setVisible(true);
						} else {
							JMenu2.setVisible(false);
						}
						{
							JMenuItem28 = new JMenuItem();
							JMenu2.add(JMenuItem28);
							JMenuItem28.setText("Busqueda");
							JMenuItem28.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaEncomienda inst = new BusquedaEncomienda();
									inst.getFrame().setLocationRelativeTo(null);
									inst.getFrame().setVisible(true);
								}
							});
						}
						{
							JMenuItem29 = new JMenuItem();
							JMenu2.add(JMenuItem29);
							JMenuItem29.setText("Particulares");
							JMenuItem29.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEncomiendasParticular inst = new ListadoEncomiendasParticular();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem29 = new JMenuItem();
							JMenu2.add(JMenuItem29);
							JMenuItem29.setText("Empresa");
							JMenuItem29.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEncomiendasEmpresa inst = new ListadoEncomiendasEmpresa();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenu7 = new JMenu();
						JMenu6.add(JMenu7);
						JMenu7.setText("Envios");
						JMenu7.setBounds(104, 0, 43, 19);
						if (roles.contains("ENVIO")) {
							JMenu7.setVisible(true);
						} else {
							JMenu7.setVisible(false);
						}
						{
							JMenuItem26 = new JMenuItem();
							JMenu7.add(JMenuItem26);
							JMenuItem26.setText("Buscar Envios");
							JMenuItem26.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaEnvio inst = new BusquedaEnvio();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem26 = new JMenuItem();
							JMenu7.add(JMenuItem26);
							JMenuItem26.setText("Propios");
							JMenuItem26.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEnviosPropios inst = new ListadoEnviosPropios();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem27 = new JMenuItem();
							JMenu7.add(JMenuItem27);
							JMenuItem27.setText("Tercerizados");
							JMenuItem27.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEnviosTercerizados inst = new ListadoEnviosTercerizados();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					
					{
						JMenuConsultasSucursales = new JMenu();
						JMenu6.add(JMenuConsultasSucursales);
						JMenuConsultasSucursales.setText("Sucursales");
						{
							JMenuItem12 = new JMenuItem();
							JMenuConsultasSucursales.add(JMenuItem12);
							JMenuItem12.setText("Sucursales");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem12.setVisible(true);
							} else {
								JMenuItem12.setVisible(false);
								JMenuItem12.setBounds(0, 21, 80, 21);
							}
							JMenuItem12.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoSucursales inst = new ListadoSucursales();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenuConsultasSucursales = new JMenu();
						JMenu6.add(JMenuConsultasSucursales);
						JMenuConsultasSucursales.setText("Mapas de Ruta");
						{
							JMenuItem12 = new JMenuItem();
							JMenuConsultasSucursales.add(JMenuItem12);
							JMenuItem12.setText("Mapas de Ruta");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem12.setVisible(true);
							} else {
								JMenuItem12.setVisible(false);
								JMenuItem12.setBounds(0, 21, 80, 21);
							}
							JMenuItem12.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoMapasDeRuta inst = new ListadoMapasDeRuta();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenuConsultasClientes = new JMenu();
						JMenu6.add(JMenuConsultasClientes);
						JMenuConsultasClientes.setText("Clientes");
						{
							JMenuItem13 = new JMenuItem();
							JMenuConsultasClientes.add(JMenuItem13);
							JMenuItem13.setText("Clientes Particulares");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem13.setVisible(true);
							} else {
								JMenuItem13.setVisible(false);
								JMenuItem13.setBounds(0, 21, 80, 21);
							}
							JMenuItem13.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoCliente inst = new ListadoCliente();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem13 = new JMenuItem();
							JMenuConsultasClientes.add(JMenuItem13);
							JMenuItem13.setText("Empresas");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem13.setVisible(true);
							} else {
								JMenuItem13.setVisible(false);
								JMenuItem13.setBounds(0, 21, 80, 21);
							}
							JMenuItem13.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEmpresa inst = new ListadoEmpresa();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparator5 = new JSeparator();
							JMenuConsultasClientes.add(jSeparator5);
						}
						{
							JMenu1 = new JMenu();
							JMenuConsultasClientes.add(JMenu1);
							JMenu1.setText("Facturas");		
							{
								jMenuItem23 = new JMenuItem();
								JMenu1.add(jMenuItem23);
								jMenuItem23.setText("Facturas");
								jMenuItem23.setBounds(0, -21, 70, 21);
								jMenuItem23.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										ListadoFacturasClientes inst = new ListadoFacturasClientes();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
								
							}
							{
								jMenuItem24 = new JMenuItem();
								JMenu1.add(jMenuItem24);
								jMenuItem24.setText("Facturas Pendientes");
								jMenuItem24.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										ListadoFacturasClientesPendientes inst = new ListadoFacturasClientesPendientes();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
						}
						{
							jSeparator6 = new JSeparator();
							JMenuConsultasClientes.add(jSeparator6);
						}
						{
							
							JMenu1 = new JMenu();
							JMenuConsultasClientes.add(JMenu1);
							JMenu1.setText("Remitos");								
							{
								JMenuItem25 = new JMenuItem();
								JMenu1.add(JMenuItem25);
								JMenuItem25.setText("Bisqueda Remitos");
								JMenuItem25.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										BusquedaRemito inst = new BusquedaRemito();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							{ 
								JMenuItem25 = new JMenuItem();
								JMenu1.add(JMenuItem25);
								JMenuItem25.setText("Listado Remitos");
								JMenuItem25.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										ListadoRemitos inst = new ListadoRemitos();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
							}
							
						}
						
						{
							jSeparator6 = new JSeparator();
							JMenuConsultasClientes.add(jSeparator6);
						}
						{
						
							JMenu1 = new JMenu();
							JMenuConsultasClientes.add(JMenu1);
							JMenu1.setText("Manifiestos");								
							{ 
							JMenuItem25 = new JMenuItem();
							JMenu1.add(JMenuItem25);
							JMenuItem25.setText("Busqueda Manifiestos");
							JMenuItem25.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									BusquedaManifiesto inst = new BusquedaManifiesto();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
							}
							{ 
								JMenuItem25 = new JMenuItem();
								JMenu1.add(JMenuItem25);
								JMenuItem25.setText("Listado Manifiestos");
								JMenuItem25.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										ListadoManifiestos inst = new ListadoManifiestos();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
								}
							
						}
						{
							jSeparator6 = new JSeparator();
							JMenuConsultasClientes.add(jSeparator6);
						}
						{
							JMenuItem25 = new JMenuItem();
							JMenuConsultasClientes.add(JMenuItem25);
							JMenuItem25.setText("Productos");
							JMenuItem25.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoProducto inst = new ListadoProducto();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenuProveedores = new JMenu();
						JMenu6.add(JMenuProveedores);
						JMenuProveedores.setText("Proveedores");
						{
							JMenuItem14 = new JMenuItem();
							JMenuProveedores.add(JMenuItem14);
							JMenuItem14.setText("Proveedores");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem14.setVisible(true);
							} else {
								JMenuItem14.setVisible(false);
								JMenuItem14.setBounds(0, 21, 87, 21);
							}
							JMenuItem14.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoProveedores inst = new ListadoProveedores();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparator1 = new JSeparator();
							JMenuProveedores.add(jSeparator1);
						}
						{
							JMenuItem10 = new JMenuItem();
							JMenuProveedores.add(JMenuItem10);
							JMenuItem10.setText("Aseguradoras");
							JMenuItem10.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoAseguradoras inst = new ListadoAseguradoras();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem18 = new JMenuItem();
							JMenuProveedores.add(JMenuItem18);
							JMenuItem18.setText("Carriers");
							JMenuItem18.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoCarriers inst = new ListadoCarriers();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem17 = new JMenuItem();
							JMenuProveedores.add(JMenuItem17);
							JMenuItem17.setText("Empresas Seguridad");
							JMenuItem17.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoEmpresaSeguridad inst = new ListadoEmpresaSeguridad();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem9 = new JMenuItem();
							JMenuProveedores.add(JMenuItem9);
							JMenuItem9.setText("Talleres");
							JMenuItem9.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoTalleres inst = new ListadoTalleres();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparator3 = new JSeparator();
							JMenuProveedores.add(jSeparator3);
						}
		

						{
							JMenuItem20 = new JMenuItem();
							JMenuProveedores.add(JMenuItem20);
							JMenuItem20.setText("Servicios Seguridad");
							JMenuItem20.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoServicioSeguridad inst = new ListadoServicioSeguridad();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem21 = new JMenuItem();
							JMenuProveedores.add(JMenuItem21);
							JMenuItem21.setText("Seguros");
							JMenuItem21.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoSeguros inst = new ListadoSeguros();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem21 = new JMenuItem();
							JMenuProveedores.add(JMenuItem21);
							JMenuItem21.setText("Tarifas Carriers");
							JMenuItem21.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoTarifasCarriers inst = new ListadoTarifasCarriers();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenuConsultasUsuarios = new JMenu();
						JMenu6.add(JMenuConsultasUsuarios);
						JMenuConsultasUsuarios.setText("Usuarios");
						{
							JMenuItem15 = new JMenuItem();
							JMenuConsultasUsuarios.add(JMenuItem15);
							JMenuItem15.setText("Usuarios");
							if (roles.contains("ADMINISTRACION")) {
								JMenuItem15.setVisible(true);
							} else {
								JMenuItem15.setVisible(false);
								JMenuItem15.setBounds(0, -21, 80, 21);
							}
							JMenuItem15.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoUsuarios inst = new ListadoUsuarios();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
					{
						JMenuConsultasVehiculos = new JMenu();
						JMenu6.add(JMenuConsultasVehiculos);
						JMenuConsultasVehiculos.setText("Vehiculos");
						{
							JMenuItem16 = new JMenuItem();
							JMenuConsultasVehiculos.add(JMenuItem16);
							JMenuItem16.setText("Vehiculos");
							JMenuVehiculo.setText("Vehiculo");
							if (roles.contains("VEHICULOS")) {
								JMenuItem16.setVisible(true);
							} else {
								JMenuItem16.setVisible(false);
								JMenuItem16.setBounds(0, -42, 80, 21);
							}
							JMenuItem16.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoVehiculos inst = new ListadoVehiculos();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							jSeparator7 = new JSeparator();
							JMenuConsultasVehiculos.add(jSeparator7);
						}
						{
							JMenuItem30 = new JMenuItem();
							JMenuConsultasVehiculos.add(JMenuItem30);
							JMenuItem30.setText("Plan Mantenimiento");
							JMenuItem30.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoPlanMantenimiento inst = new ListadoPlanMantenimiento();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
						{
							JMenuItem31 = new JMenuItem();
							JMenuConsultasVehiculos.add(JMenuItem31);
							JMenuItem31.setText("Tareas Realizadas");
							JMenuItem31.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									ListadoTareasRealizadas inst = new ListadoTareasRealizadas();
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
								}
							});
						}
					}
				}
				{
					JMenu3 = new JMenu();
					JMenuBar1.add(JMenu3);
					JMenu3.setText("Salir");
					{
						jSeparator2 = new JSeparator();
						JMenu3.add(jSeparator2);
					}
					{
						exitVistaMenuItem = new JMenuItem();
						JMenu3.add(exitVistaMenuItem);
						exitVistaMenuItem.setText("Salir");
						exitVistaMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) 
							{
								System.exit(0);
							}
						});
					}
				}
				{
					JMenu5 = new JMenu();
					JMenuBar1.add(JMenu5);
					JMenu5.setText("Ayuda");
					{
						JMenuItemAcercaDe = new JMenuItem();
						JMenu5.add(JMenuItemAcercaDe);
						JMenuItemAcercaDe.setLayout(null);
						JMenuItemAcercaDe.setText("Acerca de...");
						JMenuItemAcercaDe.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								VistaAcercaDe a = new VistaAcercaDe();
								a.setLocationRelativeTo(null);
								a.setVisible(true);
							}
						});
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
