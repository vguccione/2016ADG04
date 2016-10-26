package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Proveedor.DTO_TallerMecanico;



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
public class ListadoTalleres extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoProveedores;
	private JTable jTableListado;
	
	
	
	public ListadoTalleres() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Listado Talleres");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 242, 37);
			}
			{
				jScrollPaneListadoProveedores = new JScrollPane();
				getContentPane().add(jScrollPaneListadoProveedores);
				jScrollPaneListadoProveedores.setBounds(12, 55, 799, 310);
				{
					
					List<DTO_TallerMecanico> proveedorDTO = Controlador.getInstancia().listarTalleres();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("ID");
					jTableListadoModel.addColumn("Estado");
					jTableListadoModel.addColumn("CUIT");
					jTableListadoModel.addColumn("Razon Social");
					jTableListadoModel.addColumn("Categoria");
					jTableListadoModel.addColumn("Direccion");
					jTableListadoModel.addColumn("Codigo Postal");
					jTableListadoModel.addColumn("Localidad");
					jTableListadoModel.addColumn("Provincia");
					jTableListadoModel.addColumn("Pais");
					jTableListadoModel.addColumn("Email");
					jTableListadoModel.addColumn("Telefono");
					jTableListadoModel.addColumn("Metodo de Pago");
					jTableListadoModel.addColumn("Tipo");
					jTableListadoModel.addColumn("Taller Oficial");
					jTableListadoModel.addColumn("Especialidad");

					
					for (DTO_TallerMecanico p :proveedorDTO){
						
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
																	p.getMetodoPago(),
																	p.getTipo(),
																	p.getTallerOficial(),
																	p.getEspecialidad()
						});
																
						
						
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
