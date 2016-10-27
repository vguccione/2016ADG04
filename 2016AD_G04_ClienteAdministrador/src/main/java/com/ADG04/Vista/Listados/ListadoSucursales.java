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

	public ListadoSucursales() {
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
				jLabelTitulo.setText("Listado Sucursales");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 243, 39);
			}
			{
				jScrollPaneListadoProveedores = new JScrollPane();
				getContentPane().add(jScrollPaneListadoProveedores);
				jScrollPaneListadoProveedores.setBounds(12, 57, 799, 308);
				{

					List<DTO_Sucursal> sucursalDTO = Controlador.getInstancia().listarSucursales();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
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
