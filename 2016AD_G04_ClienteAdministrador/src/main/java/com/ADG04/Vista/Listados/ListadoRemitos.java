package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Encomienda.DTO_Remito;



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
public class ListadoRemitos extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoRemitos;
	private JTable jTableListado;

	public  ListadoRemitos() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Remitos");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 500, 36);
			}
			{
				jScrollPaneListadoRemitos = new JScrollPane();
				getContentPane().add(jScrollPaneListadoRemitos);
				jScrollPaneListadoRemitos.setBounds(12, 60, 799, 305);
				{
					
					List<DTO_Remito> listadto = Controlador.getInstancia().listarRemitos();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Fecha");
					jTableListadoModel.addColumn("Encomienda");
					jTableListadoModel.addColumn("Receptor");
					jTableListadoModel.addColumn("Fecha Estimada Entrega");
					jTableListadoModel.addColumn("Condiciones Transporte");
					jTableListadoModel.addColumn("Indicaciones Manipulacion");
	
					
					if(listadto!=null){
					for (DTO_Remito r :listadto){
						String fecha="";
						if(r.getFechaEstimadaEntrega()!=null)
							fecha = r.getFechaEstimadaEntrega().toString();
						
						jTableListadoModel.addRow(new Object[] { r.getId(),
								r.getFecha().toString(),
								r.getIdEncomienda(),
								r.getNombreReceptor() + " " + r.getApellidoReceptor() + " (DNI:" + r.getDniReceptor() + ")",
								fecha,
								r.getCondicionTransporte(),
								r.getIndicacionesManipulacion()
						});
																
						
					}
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoRemitos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoRemitos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoRemitos.setViewportView(jTableListado);
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
