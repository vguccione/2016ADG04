package com.ADG04.Vista.Listados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

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
public class ListadoVehiculos extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;

	private JTextField txtBusqueda;

	public  ListadoVehiculos() {
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
				jLabelTitulo.setText("Listado Vehiculos");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 247, 36);
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
				info.setText("Ingrese modelo, marca o patente. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Vehiculo> vehiculoDTO = null;
						if(txtBusqueda.getText()!=null){
							vehiculoDTO = Controlador.getInstancia().buscarVehiculoByModeloMarcaOPatente(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							vehiculoDTO = Controlador.getInstancia().listarVehiculos();
						}
						
						if(vehiculoDTO!=null){
							for (DTO_Vehiculo v :vehiculoDTO){
								DTO_Sucursal suc = null;
								String sucursal = "";
								if(v.getSucursal()!= null){
									suc = v.getSucursal();
									if (suc != null)
										sucursal = suc.getDescripcion();
								}
								
								jTableListadoModel.addRow(new Object[] { v.getId(), 
																			v.getPatente(),
																			v.getMarca(),
																			v.getModelo(),
																			v.getKmsRecorridos(),
																			v.getVolumen(),
																		    v.getFechaIngreso(),
																			sucursal																	
								});	
							}
						jTableListadoModel.fireTableDataChanged();
						}
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoVehiculos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoVehiculos);
				jScrollPaneListadoVehiculos.setBounds(12, 83, 799, 311);
				{
					
					List<DTO_Vehiculo> vehiculoDTO = Controlador.getInstancia().listarVehiculos();
								
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Patente");
					jTableListadoModel.addColumn("Marca");
					jTableListadoModel.addColumn("Modelo");
					jTableListadoModel.addColumn("Kilometros");
					jTableListadoModel.addColumn("Volumen");
					jTableListadoModel.addColumn("Fecha Ingreso");
					jTableListadoModel.addColumn("Sucursal");
	
					if(vehiculoDTO!=null){
					for (DTO_Vehiculo v :vehiculoDTO){
						DTO_Sucursal suc = null;
						String sucursal = "";
						if(v.getSucursal()!= null){
							suc = v.getSucursal();
							if (suc != null)
								sucursal = suc.getDescripcion();
						}
						
						jTableListadoModel.addRow(new Object[] { v.getId(), 
																	v.getPatente(),
																	v.getMarca(),
																	v.getModelo(),
																	v.getKmsRecorridos(),
																	v.getVolumen(),
																    v.getFechaIngreso(),
																	sucursal																	
						});	
					}
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoVehiculos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoVehiculos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoVehiculos.setViewportView(jTableListado);
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
