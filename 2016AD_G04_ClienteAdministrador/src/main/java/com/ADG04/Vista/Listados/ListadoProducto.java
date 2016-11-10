package com.ADG04.Vista.Listados;
import java.util.List;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_Producto;

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
public class ListadoProducto extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoProductos;
	private JTable jTableListado;
	private JTextField txtBusqueda;

	public  ListadoProducto() {
		super();
		initGUI();
	}
	
	public JLabel getJLabelTitulo(){
		return this.jLabelTitulo;
	}
	
	
	
	public JLabel getjLabelTitulo() {
		return jLabelTitulo;
	}

	public void setjLabelTitulo(JLabel jLabelTitulo) {
		this.jLabelTitulo = jLabelTitulo;
	}

	public JScrollPane getjScrollPaneListadoProductos() {
		return jScrollPaneListadoProductos;
	}

	public void setjScrollPaneListadoProductos(
			JScrollPane jScrollPaneListadoProductos) {
		this.jScrollPaneListadoProductos = jScrollPaneListadoProductos;
	}

	public JTable getjTableListado() {
		return jTableListado;
	}

	public void setjTableListado(JTable jTableListado) {
		this.jTableListado = jTableListado;
	}

	public JTextField getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(JTextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
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
				jLabelTitulo.setText("Listado Productos");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 400, 36);
			}

			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Buscar por Cliente:");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,12));
				jLabelTitulo.setBounds(12, 42, 245, 35);
				txtBusqueda = new JTextField();
				txtBusqueda.setBounds(180, 48, 324, 20);
				getContentPane().add(txtBusqueda);
				txtBusqueda.setColumns(10);
				JButton buscar = new JButton("Buscar");
				buscar.setBounds(540, 45, 89, 23);
				JLabel info = new JLabel();
				getContentPane().add(info);
				info.setText("Ingrese Razon Social. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(180, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Producto> listaDTO = null;
						if(!txtBusqueda.getText().isEmpty()){
							listaDTO = Controlador.getInstancia().buscarProductosByRazonSocialCliente(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							listaDTO = Controlador.getInstancia().listarProductos();
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						
						if(listaDTO!=null){
							for (DTO_Producto item :listaDTO){
								DTO_ClienteEmpresa cli = null;
								if(item.getIdCliente()!=null)					
									cli = Controlador.getInstancia().getEmpresaById(item.getIdCliente());
								
								String cliente="";
								if(cli!=null)
									cliente=cli.getRazonSocial();
								jTableListadoModel.addRow(new Object[] { item.getId(),
										cliente,
										item.getCategoria(),
										item.getDescripcion(),
										item.getUnidad(),
										item.getCodigo()																
								});
							}										
							}	
						jTableListadoModel.fireTableDataChanged();
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoProductos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoProductos);
				jScrollPaneListadoProductos.setBounds(12, 83, 799, 305);
				{
					
					List<DTO_Producto> listaDTO = Controlador.getInstancia().listarProductos();
					
			
					jTableListadoModel.addColumn("Id");
					jTableListadoModel.addColumn("Cliente");
					jTableListadoModel.addColumn("Categoria");
					jTableListadoModel.addColumn("Descripcion");
					jTableListadoModel.addColumn("Unidad");
					jTableListadoModel.addColumn("Codigo Producto");
	
					
					if(listaDTO!=null){
					for (DTO_Producto item :listaDTO){
						DTO_ClienteEmpresa cli = Controlador.getInstancia().getEmpresaById(item.getIdCliente());
						String cliente="";
						if(cli!=null)
							 cliente = cli.getRazonSocial();
						
						jTableListadoModel.addRow(new Object[] { item.getId(),
																	cliente,
																	item.getCategoria(),
																	item.getDescripcion(),
																	item.getUnidad(),
																	item.getCodigo()																
						});
																
					}	
						
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoProductos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoProductos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoProductos.setViewportView(jTableListado);
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
