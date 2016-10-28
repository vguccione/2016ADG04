package com.ADG04.Vista.Listados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Proveedor.DTO_Proveedor;


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
public class ListadoProveedores extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoProveedores;
	private JTable jTableListado;
	private JTextField txtBusqueda;
	
	public ListadoProveedores() {
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
				jLabelTitulo.setText("Listado Proveedores");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 242, 37);
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
				info.setText("Ingrese Razon Social. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Proveedor> proveedorDTO = null;
						if(txtBusqueda.getText()!=null){
							proveedorDTO = Controlador.getInstancia().buscarProveedorByRazonSocial(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							proveedorDTO = Controlador.getInstancia().listarProveedores();
						}
						
						if(proveedorDTO!=null){
							for (DTO_Proveedor p :proveedorDTO){
								
								DTO_Direccion direccion = p.getDireccion();
								String calle = "";
								int codPostal=0;
								String loc="";
								String prov="";
								String pais="";
								if(direccion!=null){
									calle = direccion.getCalle();
									codPostal=direccion.getCodigoPostal();
									loc=direccion.getLocalidad();
									prov=direccion.getProvincia().getDescripcion();
									pais=direccion.getPais().getDescripcion();
								}
								
								jTableListadoModel.addRow(new Object[] { p.getId(), 
																			p.getActivo(),
																			p.getCuit(),
																			p.getRazonSocial(),
																			calle,
																			codPostal,
																			loc,
																			prov,
																			pais,
																			p.getEmail(),
																			p.getTelefono(),
																			p.getTipo(),
																			p.isTallerOficial()
								});
																		
							}
						jTableListadoModel.fireTableDataChanged();
						}
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoProveedores = new JScrollPane();
				getContentPane().add(jScrollPaneListadoProveedores);
				jScrollPaneListadoProveedores.setBounds(12, 83, 799, 311);
				{
					
					List<DTO_Proveedor> proveedorDTO = Controlador.getInstancia().listarProveedores();
					
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("CUIT");
					jTableListadoModel.addColumn("Razon Social");
					jTableListadoModel.addColumn("Direccion");
					jTableListadoModel.addColumn("Codigo Postal");
					jTableListadoModel.addColumn("Localidad");
					jTableListadoModel.addColumn("Provincia");
					jTableListadoModel.addColumn("Pais");
					jTableListadoModel.addColumn("Email");
					jTableListadoModel.addColumn("Telefono");
					jTableListadoModel.addColumn("Tipo");
					jTableListadoModel.addColumn("Taller Oficial");
					
					if(proveedorDTO!=null){
					for (DTO_Proveedor p :proveedorDTO){
						
						DTO_Direccion direccion = p.getDireccion();
						String calle = "";
						int codPostal=0;
						String loc="";
						String prov="";
						String pais="";
						if(direccion!=null){
							calle = direccion.getCalle();
							codPostal=direccion.getCodigoPostal();
							loc=direccion.getLocalidad();
							prov=direccion.getProvincia().getDescripcion();
							pais=direccion.getPais().getDescripcion();
						}
						
						jTableListadoModel.addRow(new Object[] { p.getId(), 
																	p.getActivo(),
																	p.getCuit(),
																	p.getRazonSocial(),
																	calle,
																	codPostal,
																	loc,
																	prov,
																	pais,
																	p.getEmail(),
																	p.getTelefono(),
																	p.getTipo(),
																	p.isTallerOficial()
						});
																
					}
						
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoProveedores.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoProveedores.setViewportView(jTableListado);
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
