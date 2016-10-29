package com.ADG04.Vista.Listados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;


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
public class ListadoSeguros extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoVehiculos;
	private JTable jTableListado;
	private JTextField txtBusqueda;

	public  ListadoSeguros() {
		super();
		initGUI();
	}
	
	
	
	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}



	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}



	public JLabel getjLabelTitulo() {
		return jLabelTitulo;
	}



	public void setjLabelTitulo(JLabel jLabelTitulo) {
		this.jLabelTitulo = jLabelTitulo;
	}



	public JScrollPane getjScrollPaneListadoVehiculos() {
		if (jScrollPaneListadoVehiculos == null) {
			jScrollPaneListadoVehiculos = new JScrollPane();
			jScrollPaneListadoVehiculos.setBounds(12, 83, 799, 305);
		}
		return jScrollPaneListadoVehiculos;
	}



	public void setjScrollPaneListadoVehiculos(
			JScrollPane jScrollPaneListadoVehiculos) {
		this.jScrollPaneListadoVehiculos = jScrollPaneListadoVehiculos;
	}



	public JTable getjTableListado() {
		return jTableListado;
	}



	public void setjTableListado(JTable jTableListado) {
		this.jTableListado = jTableListado;
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
				jLabelTitulo.setText("Listado Seguros");
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
				info.setText("Ingrese Razon Social del Proveedor. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Seguro> listaDTO = null;
						if(txtBusqueda.getText()!=null){
							listaDTO = Controlador.getInstancia().buscarSegurosPorProveedor(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							listaDTO = Controlador.getInstancia().listarSeguros();
						}
						
						if(listaDTO!=null){
							for (DTO_Seguro item :listaDTO){
								
								String text = "";
								if(item.getIdProveedor() != null){
									DTO_Proveedor p = Controlador.getInstancia().getProveedor(item.getIdProveedor());
									if(p!=null)
										text = p.getRazonSocial();
								}
								
								jTableListadoModel.addRow(new Object[] { text,
																		item.getTipoSeguro(),
																		item.getDescripcion(),
																		Float.toString(item.getTarifa())				
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
					
					List<DTO_Seguro> listaDTO = Controlador.getInstancia().listarSeguros();
					
					jTableListadoModel.addColumn("Proveedor");
					jTableListadoModel.addColumn("Tipo");
					jTableListadoModel.addColumn("Descripcion");
					jTableListadoModel.addColumn("Tarifa");
	
					if(listaDTO!=null){
					for (DTO_Seguro item :listaDTO){
						
						String text = "";
						if(item.getIdProveedor() != null){
							DTO_Proveedor p = Controlador.getInstancia().getProveedor(item.getIdProveedor());
							if(p!=null)
								text = p.getRazonSocial();
						}
						
						jTableListadoModel.addRow(new Object[] { text,
																item.getTipoSeguro(),
																item.getDescripcion(),
																Float.toString(item.getTarifa())				
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



	private void initComponents() {
		setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(null);
		add(getjLabelTitulo());
		add(getTxtBusqueda());
		add(getjScrollPaneListadoVehiculos());
		setSize(747, 240);
	}

}
