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
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
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
public class ListadoTareasRealizadas extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;

	private JTextField txtBusqueda;


	public  ListadoTareasRealizadas() {
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
				jLabelTitulo.setText("Listado Tareas Matenimiento Realizadas");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 500, 36);
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
				info.setText("Ingrese patente del Vehiculo. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_TareaMantenimientoRealizada> listaDTO = null;
						if(txtBusqueda.getText()!=null){
							listaDTO = Controlador.getInstancia().buscarTareasMantenimientoRealizadasPorVehiculo(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							listaDTO = Controlador.getInstancia().listarTareaMantenimientoRealizada();
						}
						
						if(listaDTO!=null){
							for (DTO_TareaMantenimientoRealizada item :listaDTO){
								String proveedor = "";
								if(item.getIdProveedor() != null){
									DTO_Proveedor p = Controlador.getInstancia().getProveedor(item.getIdProveedor());
									if(p != null)
										proveedor = p.getRazonSocial();
								}
								DTO_Vehiculo vehiculo = Controlador.getInstancia().getVehiculoById(item.getIdVehiculo());
								String tarea="";
								if(item.getIdTareaMantenimiento()!=null){
									DTO_TareaMantenimiento tm = Controlador.getInstancia().getTareaMantenimiento(item.getIdTareaMantenimiento());
									if(tm!=null)
										tarea = tm.getTarea();
								}
								
								jTableListadoModel.addRow(new Object[] { vehiculo.getPatente(),
																			proveedor, 
																			item.getFecha().toString(),
																			Float.toString(item.getCantidadKilometros()),
																			tarea	
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
				jScrollPaneListadoVehiculos.setBounds(12, 83, 799, 305);
				{
					
					List<DTO_TareaMantenimientoRealizada> listaDTO = Controlador.getInstancia().listarTareaMantenimientoRealizada();
			
					jTableListadoModel.addColumn("Patente Vehiculo");
					jTableListadoModel.addColumn("Proveedor");
					jTableListadoModel.addColumn("Fecha");
					jTableListadoModel.addColumn("Cantidad Kilometros");
					jTableListadoModel.addColumn("Tarea");

	
					if(listaDTO!=null){
					for (DTO_TareaMantenimientoRealizada item :listaDTO){
						String proveedor = "";
						if(item.getIdProveedor() != null){
							DTO_Proveedor p = Controlador.getInstancia().getProveedor(item.getIdProveedor());
							if(p != null)
								proveedor = p.getRazonSocial();
						}
						DTO_Vehiculo vehiculo = Controlador.getInstancia().getVehiculoById(item.getIdVehiculo());
						String tarea="";
						if(item.getIdTareaMantenimiento()!=null){
							DTO_TareaMantenimiento tm = Controlador.getInstancia().getTareaMantenimiento(item.getIdTareaMantenimiento());
							if(tm!=null)
								tarea = tm.getTarea();
						}
						
						jTableListadoModel.addRow(new Object[] { vehiculo.getPatente(),
																	proveedor, 
																	item.getFecha().toString(),
																	Float.toString(item.getCantidadKilometros()),
																	tarea	
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
