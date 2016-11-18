package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
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
public class ListadoEnviosTercerizados extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;
	private JTextField txtBusqueda;

	public  ListadoEnviosTercerizados() {
		super();
		Controlador.getInstancia().actualizarEstadoEnvios();
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
				jLabelTitulo.setText("Listado Envios Tercerizados");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 320, 36);
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
				info.setText("Ingrese estado (EnViaje, Pendiente, Demorado, Desviado, Concluido, Alerta). Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_EnvioTercerizado> listadto = null;
						if(txtBusqueda.getText()!=null){
							listadto = Controlador.getInstancia().buscarEnviosByEstado(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							listadto = Controlador.getInstancia().listarEnviosTercerizados();
						}
						
						
						if(listadto!=null){
							for (DTO_EnvioTercerizado env :listadto){
								String proveedor="";
								if(env.getIdProveedor()!=null){
									DTO_Proveedor prov = Controlador.getInstancia().getProveedor(env.getIdProveedor());
									proveedor=prov.getRazonSocial();
								}
								DTO_Coordenada coord = Controlador.getInstancia().getCoordenadaById(env.getPosicionActual().getId());
								jTableListadoModel.addRow(new Object[] { 
										env.getId(),
										env.getEstado(),
										proveedor,
										env.getNumeroTracking(),
										coord.getLatitud() + ' ' + coord.getLongitud()
								});	
								}	
							}
						jTableListadoModel.fireTableDataChanged();
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoVehiculos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoVehiculos);
				jScrollPaneListadoVehiculos.setBounds(12, 83, 799, 305);
				{
					List<DTO_EnvioTercerizado> listadto = Controlador.getInstancia().listarEnviosTercerizados();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("Proveedor");
					jTableListadoModel.addColumn("Numero Tracking");
					jTableListadoModel.addColumn("Posicion Actual");
	
					if(listadto!=null){
					for (DTO_EnvioTercerizado env :listadto){
						String proveedor = "";
						if(env.getIdProveedor()!=null){
							DTO_Proveedor prov  = Controlador.getInstancia().getProveedor(env.getIdProveedor());
							proveedor= prov.getRazonSocial();
						}
						DTO_Coordenada coord = Controlador.getInstancia().getCoordenadaById(env.getPosicionActual().getId());
						jTableListadoModel.addRow(new Object[] { 
								env.getId(),
								env.getEstado(),
								proveedor,
								env.getNumeroTracking(),
								coord.getLatitud() + ' ' + coord.getLongitud()
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
