package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_Encomienda;


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
public class ListadoEncomiendasEmpresa extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoEncomiendas;
	private JTable jTableListado;

	public  ListadoEncomiendasEmpresa() {
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
				jLabelTitulo.setText("Listado Encomienda Particular");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 500, 36);
			}
			{
				jScrollPaneListadoEncomiendas = new JScrollPane();
				getContentPane().add(jScrollPaneListadoEncomiendas);
				jScrollPaneListadoEncomiendas.setBounds(12, 60, 799, 305);
				{
					
					List<DTO_Encomienda> listadto = Controlador.getInstancia().listarEncomiendasEmpresa();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("Cliente");
					jTableListadoModel.addColumn("Alto");
					jTableListadoModel.addColumn("Ancho");
					jTableListadoModel.addColumn("Largo");
					jTableListadoModel.addColumn("Volumen");
					jTableListadoModel.addColumn("Peso");
					jTableListadoModel.addColumn("Dni Receptor");
					jTableListadoModel.addColumn("Nombre Completo Receptor");
					jTableListadoModel.addColumn("Sucursal Origen");
					jTableListadoModel.addColumn("Sucursal Destino");
	
					
					if(listadto!=null){
					for (DTO_Encomienda enc :listadto){
						String cliente = "";
						DTO_ClienteEmpresa cli = Controlador.getInstancia().getEmpresaById(enc.getCliente().getId());
						if(cli.getRazonSocial()!=null){
							cliente = cli.getRazonSocial();
						}
						
						jTableListadoModel.addRow(new Object[] { enc.getIdEncomienda(),
								enc.getEstado(),
								cliente,
								enc.getAlto(),
								enc.getAncho(),
								enc.getLargo(),
								enc.getVolumen(),
								enc.getPeso(),
								enc.getDniReceptor(),
								enc.getNombreReceptor() + ' ' + enc.getApellidoReceptor(),
								enc.getSucursalOrigen().getDescripcion(),
								enc.getSucursalDestino().getDescripcion()
						});
																
						
					}
					}
					jTableListado = new JTable(jTableListadoModel);
					jScrollPaneListadoEncomiendas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoEncomiendas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jScrollPaneListadoEncomiendas.setViewportView(jTableListado);
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

