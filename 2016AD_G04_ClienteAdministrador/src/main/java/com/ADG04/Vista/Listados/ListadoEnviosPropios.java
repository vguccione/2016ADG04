package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controlador.controladorAdmin;
import dto.Vehiculo.DTO_Vehiculo;


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
public class ListadoEnviosPropios extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;

	public  ListadoEnviosPropios() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/box.png")).getImage());
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Vehiculos");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 247, 36);
			}
			{
				jScrollPaneListadoVehiculos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoVehiculos);
				jScrollPaneListadoVehiculos.setBounds(12, 60, 799, 305);
				{
					
					List<DTO_Vehiculo> vehiculoDTO = controladorAdmin.getInstancia().listarVehiculos();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Tipo");
					jTableListadoModel.addColumn("Patente");
					jTableListadoModel.addColumn("Marca");
					jTableListadoModel.addColumn("Modelo");
					jTableListadoModel.addColumn("Kilometros");
					jTableListadoModel.addColumn("Volumen");
					jTableListadoModel.addColumn("Costo KM");
					jTableListadoModel.addColumn("Fecha Ingreso");
					jTableListadoModel.addColumn("Ultimo Movimiento");
					jTableListadoModel.addColumn("Ultimo Uso");
					jTableListadoModel.addColumn("Sucursal Actual");
	
					
					for (DTO_Vehiculo v :vehiculoDTO){
						
//						String estado=null;
//						if (p.getActivo())
//							estado = "Activo";
//						else
//							estado = "Inactivo";
						
						jTableListadoModel.addRow(new Object[] { v.getId(), 
																	v.getTipo(),
																	v.getPatente(),
																	v.getMarca(),
																	v.getKilometros(),
																	v.getVolumen(),
																	v.getCostoKM(),
																	v.getFechaIngreso(),
																	v.getUltimoMantenimiento(),
																	v.getUltimoUso(),
																	v.getIdSucursalActual()
																						
																
						});
																
						
						
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
