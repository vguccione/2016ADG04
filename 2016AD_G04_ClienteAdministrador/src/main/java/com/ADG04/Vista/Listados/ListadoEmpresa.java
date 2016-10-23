package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;



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
public class ListadoEmpresa extends javax.swing.JFrame {
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoClientes;
	private JTable jTableListado;


	
	public ListadoEmpresa() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Clientes");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 245, 35);
			}
			{
				jScrollPaneListadoClientes = new JScrollPane();
				getContentPane().add(jScrollPaneListadoClientes);
				jScrollPaneListadoClientes.setBounds(12, 53, 799, 311);
				{
					
					List<DTO_ClienteEmpresa> clienteDTO = Controlador.getInstancia().listarClientesEmpresa();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Razon Social");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("Direccion");
					jTableListadoModel.addColumn("Codigo Postal");
					jTableListadoModel.addColumn("Provincia");
					jTableListadoModel.addColumn("Pais");
					jTableListadoModel.addColumn("Email");
					jTableListadoModel.addColumn("Telefono");
					
					
					for (DTO_ClienteEmpresa c :clienteDTO){
						
						String estado=null;
						if (c.isEstado())
							estado = "Activo";
						else
							estado = "Inactivo";
						
						DTO_Direccion direccion = c.getDireccion();
						jTableListadoModel.addRow(new Object[] { c.getId(), 
																c.getRazonSocial(),
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
			pack();
			this.setSize(839, 415);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
