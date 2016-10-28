package com.ADG04.Vista.Listados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

import javax.swing.JPanel;
import javax.swing.JButton;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class ListadoCliente extends javax.swing.JFrame {
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoClientes;
	private JTable jTableListado;
	private JTextField txtBusqueda;

	
	public ListadoCliente() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			final DefaultTableModel jTableListadoModel = new DefaultTableModel();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Clientes");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 245, 35);
			}
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Buscar:");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,12));
				jLabelTitulo.setBounds(12, 42, 245, 35);
				txtBusqueda = new JTextField();
				txtBusqueda.setBounds(80, 48, 324, 20);
				getContentPane().add(txtBusqueda);
				txtBusqueda.setColumns(10);
				JButton buscar = new JButton("Buscar");
				buscar.setBounds(440, 45, 89, 23);
				JLabel info = new JLabel();
				getContentPane().add(info);
				info.setText("Ingrese nombre, apellido o dni. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_ClienteParticular> clienteDTO = null;
						if(txtBusqueda.getText()!=null){
							clienteDTO = Controlador.getInstancia().buscarClientesByNombreApellidoDni(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							clienteDTO = Controlador.getInstancia().listarClientes();
						}
						
						
						if(clienteDTO!=null){
							for (DTO_ClienteParticular c :clienteDTO){
								
								String estado=null;
								if (c.isEstado())
									estado = "Activo";
								else
									estado = "Inactivo";
								
								DTO_Direccion direccion = c.getDireccion();
								jTableListadoModel.addRow(new Object[] { c.getId(), 
																		c.getNombre(),
																		c.getApellido(),
																		c.getDni(),
																		estado,
																		direccion.getCalle(),
																		direccion.getCodigoPostal(), 
																		direccion.getProvincia().getDescripcion(),
																		direccion.getPais().getDescripcion(),
																		c.getEmail(),
																		c.getTelefono()});
							}
						}
						jTableListadoModel.fireTableDataChanged();
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoClientes = new JScrollPane();
				getContentPane().add(jScrollPaneListadoClientes);
				jScrollPaneListadoClientes.setBounds(12, 83, 799, 311);
				{
					
					List<DTO_ClienteParticular> clienteDTO = Controlador.getInstancia().listarClientes();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Nombre");
					jTableListadoModel.addColumn("Apellido");
					jTableListadoModel.addColumn("DNI");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("Direccion");
					jTableListadoModel.addColumn("Codigo Postal");
					jTableListadoModel.addColumn("Provincia");
					jTableListadoModel.addColumn("Pais");
					jTableListadoModel.addColumn("Email");
					jTableListadoModel.addColumn("Telefono");
					
					if(clienteDTO!=null){
					for (DTO_ClienteParticular c :clienteDTO){
						
						String estado=null;
						if (c.isEstado())
							estado = "Activo";
						else
							estado = "Inactivo";
						
						DTO_Direccion direccion = c.getDireccion();
						jTableListadoModel.addRow(new Object[] { c.getId(), 
																c.getNombre(),
																c.getApellido(),
																c.getDni(),
																estado,
																direccion.getCalle(),
																direccion.getCodigoPostal(), 
																direccion.getProvincia().getDescripcion(),
																direccion.getPais().getDescripcion(),
																c.getEmail(),
																c.getTelefono()});
						
						
					}
					jTableListado = new JTable(jTableListadoModel);
				
					
					jScrollPaneListadoClientes.setViewportView(jTableListado);
					jTableListado.setModel(jTableListadoModel);
					}
				}
			}
			pack();
			this.setSize(839, 415);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
