package com.ADG04.Vista.Listados;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Rol;
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
@SuppressWarnings("serial")
public class ListadoUsuarios extends javax.swing.JFrame {
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoClientes;
	private JTable jTableListado;
	private DTO_Usuario empleado;
	private String txt;
	private String roles;
	private String ultimoAcceso;

	
	
	public ListadoUsuarios() {
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
				jLabelTitulo.setText("Listado Usuarios");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 245, 35);
			}
			{
				jScrollPaneListadoClientes = new JScrollPane();
				getContentPane().add(jScrollPaneListadoClientes);
				jScrollPaneListadoClientes.setBounds(12, 53, 799, 311);
				{
					
					List<DTO_Usuario> usuarioDTO = Controlador.getInstancia().listarUsuarios();
					
					DefaultTableModel jTableListadoModel = new DefaultTableModel();
			
					jTableListadoModel.addColumn("Id Usuario");
					jTableListadoModel.addColumn("Empleado");
					jTableListadoModel.addColumn("Dni");
					jTableListadoModel.addColumn("usuario");
					jTableListadoModel.addColumn("Roles");
					jTableListadoModel.addColumn("Ultimo Acceso");

					if(usuarioDTO!=null){
					for (DTO_Usuario u :usuarioDTO){
						
						roles = "";
						List<DTO_Rol> listaRoles = u.getRoles();
						for (DTO_Rol r : listaRoles){
							roles = roles  + r.getdescripcion() + " ";
						}
						
						if(u.getUltimoAcceso() != null)
							ultimoAcceso = u.getUltimoAcceso().toString();
						else
							ultimoAcceso = "";
						
						
						
						jTableListadoModel.addRow(new Object[] { u.getIdUsuario(), 
																u.getNombre() + ' ' +u.getApellido() ,
																u.getDni(),
																u.getUsuario(),
																roles,
																ultimoAcceso
																});
						
						
					}
					jTableListado = new JTable(jTableListadoModel);
				
					
					jScrollPaneListadoClientes.setViewportView(jTableListado);
					jTableListado.setModel(jTableListadoModel);
					}
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
