package com.ADG04.Vista.Listados;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Usuario;
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
@SuppressWarnings("serial")
public class ListadoUsuarios extends javax.swing.JFrame {
	private JLabel jLabelTitulo;
	private JScrollPane jScrollPaneListadoClientes;
	private JTable jTableListado;
	private DTO_Usuario empleado;
	private String txt;
	private String roles;
	private String ultimoAcceso;
	private JTextField txtBusqueda;

	
	
	public ListadoUsuarios() {
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
				jLabelTitulo.setText("Listado Usuarios");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 245, 35);
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
				info.setText("Ingrese nombre, apellido o usuario. Vacio indica todos");
				info.setFont(new java.awt.Font("Verdana",1,8));
				info.setBounds(80, 60, 500, 23);
				
				buscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						List<DTO_Usuario> usuarioDTO = null;
						if(txtBusqueda.getText()!=null){
							usuarioDTO = Controlador.getInstancia().buscarUsuariosByNombreApellidoOUsuario(txtBusqueda.getText());
							int j = jTableListadoModel.getRowCount();
							if(jTableListadoModel.getRowCount()>0){
								for(int i=0;i<j;i++){
									jTableListadoModel.removeRow(0);
								}
							}
						}
						else{
							usuarioDTO = Controlador.getInstancia().listarUsuarios();
						}
						
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
						jTableListadoModel.fireTableDataChanged();
						}
					}
					
				});
				
				getContentPane().add(buscar);
			}
			{
				jScrollPaneListadoClientes = new JScrollPane();
				getContentPane().add(jScrollPaneListadoClientes);
				jScrollPaneListadoClientes.setBounds(12, 83, 799, 311);
				{
					
					List<DTO_Usuario> usuarioDTO = Controlador.getInstancia().listarUsuarios();
					
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
