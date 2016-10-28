package com.ADG04.Vista.Listados;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;

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
public class ListadoSucursales extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoProveedores;
	private JTable jTableListado;
	private String txtGerente;	
	private String txtdeposito;
	private String txtpedidos;
	private JTextField txtBusqueda;

	public ListadoSucursales() {
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
				jLabelTitulo.setText("Listado Sucursales");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 243, 39);
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
				info.setText("Ingrese nombre. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Sucursal> sucursalDTO = null;
						if(txtBusqueda.getText()!=null){
							sucursalDTO = Controlador.getInstancia().buscarSucursalByNombre(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							sucursalDTO = Controlador.getInstancia().listarSucursales();
						}
						
						
						if(sucursalDTO!=null){
							for (DTO_Sucursal s :sucursalDTO){
								DTO_Direccion direccion = s.getDireccion();
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
								String sgerente = "";
								if(s.getIdGerente()!=null){
									DTO_Usuario gerente = Controlador.getInstancia().getUsuarioById(s.getIdGerente());
									sgerente = gerente.getNombre() + ' ' + gerente.getApellido();
								}
								
								jTableListadoModel.addRow(new Object[] { s.getId(),
																			s.getDescripcion(),
																			calle,
																			loc,
																			prov,
																			codPostal,
																			s.getTelefono(),
																			sgerente
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

					List<DTO_Sucursal> sucursalDTO = Controlador.getInstancia().listarSucursales();
					
					
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Descripcion");
					jTableListadoModel.addColumn("Direccion");
					jTableListadoModel.addColumn("Localidad");
					jTableListadoModel.addColumn("Provincia");
					jTableListadoModel.addColumn("Codigo Postal");
					jTableListadoModel.addColumn("Telefono");
					jTableListadoModel.addColumn("Gerente");
			
					if(sucursalDTO!=null){
					for (DTO_Sucursal s :sucursalDTO){
						DTO_Direccion direccion = s.getDireccion();
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
						String sgerente = "";
						if(s.getIdGerente()!=null){
							DTO_Usuario gerente = Controlador.getInstancia().getUsuarioById(s.getIdGerente());
							sgerente = gerente.getNombre() + ' ' + gerente.getApellido();
						}
						
						jTableListadoModel.addRow(new Object[] { s.getId(),
																	s.getDescripcion(),
																	calle,
																	loc,
																	prov,
																	codPostal,
																	s.getTelefono(),
																	sgerente
						});
																
						
					}
						
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoProveedores.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//					jScrollPaneListadoProveedores.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoProveedores.setViewportView(jTableListado);
					jTableListado.setModel(jTableListadoModel);
		//			jTableListado.getColumn(1).setPreferredWidth(50);
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
