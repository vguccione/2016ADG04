package com.ADG04.Vista.Administrativos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.toedter.calendar.JDateChooser;


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
public class AltaUsuario extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldUsuario;
	private JLabel jLabel3;
	private JDateChooser jDateChooserFecha;
	private JTextField jTextFieldNombre;
	private JButton jButton1;
	private JFormattedTextField jFormattedTextFieldIdSucursal;
	private JFormattedTextField jFormattedTextFieldIdSuperior;
	private JTextField jTextFieldApellido;
	private JLabel jLabelSucursal;
	private JCheckBox jCheckBoxAdministracion;
	private JPasswordField ReContrasena;
	private JLabel jLabel5;
	private JPasswordField Contrasena;
	private JLabel jLabel4;
	private JLabel jLabelDni;
	private JTextField jTextFieldDni;
	private JCheckBox jCheckBoxStock;
	private JCheckBox jCheckBoxVehiculo;
	private JCheckBox jCheckBoxEnvio;
	private JLabel jLabelNombre;
	private JFormattedTextField jFormattedTextFieldIdEmpleado;
	private JCheckBox jCheckBoxEncomienda;
	private JCheckBox jCheckBoxCuentasCobrar;
	private JCheckBox jCheckBoxCuentasPagar;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;
	private JLabel jLabelApellido;
	private List<DTO_Rol> rolesExistentes;
	private DTO_Sucursal sucursal;

	public AltaUsuario() {
		super();
		initGUI();
	}
	

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			this.setResizable(false);
			this.setPreferredSize(new java.awt.Dimension(505, 328));
			{
				jPanel = new JPanel();
				jPanel.setLayout(null);
				jPanel.add(getJButtonAceptar());
				jPanel.add(getJLabel1());
				{
					jLabelTitulo = new JLabel();
					jPanel.add(jLabelTitulo);
					jPanel.add(getJPanel1());
					jPanel.add(getJButtonCancelar());
					jLabelTitulo.setText("Alta Usuario");
					jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
					jLabelTitulo.setBounds(10, 11, 372, 26);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, 0, 289, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, 0, 489, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(505, 500);
			rolesExistentes = Controlador.getInstancia().listarRoles();
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Casillas");
			jLabel1.setFont(new java.awt.Font("Verdana",0,11));
			jLabel1.setPreferredSize(new java.awt.Dimension(0, 0));
			jLabel1.setSize(150, 15);
			jLabel1.setVisible(false);
			jLabel1.setBounds(0, 0, 0, 0);
		}
		return jLabel1;
	}

	private JLabel getJLabelNombre() {
		if(jLabelNombre == null) {
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Nombre");
			jLabelNombre.setFont(new java.awt.Font("Verdana",0,11));
			jLabelNombre.setLayout(null);
			jLabelNombre.setBounds(6, 27, 73, 15);
		}
		return jLabelNombre;
	}
	
	private JLabel getJLabelApellido() {
		if(jLabelApellido == null) {
			jLabelApellido = new JLabel();
			jLabelApellido.setText("Apellido");
			jLabelApellido.setFont(new java.awt.Font("Verdana",0,11));
			jLabelApellido.setLayout(null);
			jLabelApellido.setBounds(6, 53, 78, 14);
		}
		return jLabelApellido;
	}
	
	private JLabel getJLabelDni() {
		if(jLabelDni == null) {
			jLabelDni = new JLabel();
			jLabelDni.setText("DNI");
			jLabelDni.setFont(new java.awt.Font("Verdana",0,11));
			jLabelDni.setLayout(null);
			jLabelDni.setBounds(6, 78, 78, 14);
		}
		return jLabelDni;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Fecha Ingreso");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(6, 107, 81, 19);
		}
		return jLabel3;
	}

	private JLabel getJLabelSucursal() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("Sucursal");
			jLabelSucursal.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursal.setLayout(null);
			jLabelSucursal.setBounds(6, 130, 80, 16);
		}
		return jLabelSucursal;
	}
	
	private JTextField getJTextField1() {
		if(jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(94, 27, 354, 20);
		}
		return jTextFieldNombre;
	}
	
	private JTextField getJTextFieldApellido() {
		if(jTextFieldApellido == null) {
			jTextFieldApellido = new JTextField();
			jTextFieldApellido.setBounds(94, 53, 354, 20);
		}
		return jTextFieldApellido;
	}
	
	private JTextField getJTextFieldDni()  {
		if(jTextFieldDni == null) {
			jTextFieldDni = new JTextField();
			jTextFieldDni.setBounds(94, 78, 354, 20);
		}
		return jTextFieldDni;
	}
	
	private JDateChooser getJDateChooserFecha() {
		if(jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserFecha.setBounds(94, 107, 89, 21);
		}
		return jDateChooserFecha;
	}
	
	private JLabel getJLabel5() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("Sucursal");
			jLabelSucursal.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursal.setLayout(null);
			jLabelSucursal.setBounds(217, 130, 231, 16);
		}
		return jLabelSucursal;
	}
	
	private JFormattedTextField getJFormattedTextField1() {
		if(jFormattedTextFieldIdSucursal == null) {
			jFormattedTextFieldIdSucursal = new JFormattedTextField();
			jFormattedTextFieldIdSucursal.setValue(new Integer(0));
			jFormattedTextFieldIdSucursal.setBounds(94, 130, 48, 20);
		}
		return jFormattedTextFieldIdSucursal;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar");
			jButton1.setBounds(148, 130, 100, 21);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
						sucursal = Controlador.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal.getValue());
						if(sucursal != null){
							jFormattedTextFieldIdSucursal.setEnabled(false);
							jButton1.setEnabled(false);
							jLabelSucursal.setText(sucursal.getDescripcion());
						} else {
							JOptionPane.showMessageDialog(null,"No se ha encontrado la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
				}
			});
		}
		return jButton1;
	}
	
	

	
	private JLabel getJLabelAlumnos() {
		if(jLabelAlumnos == null) {
			jLabelAlumnos = new JLabel();
			jLabelAlumnos.setText("Usuario");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 158, 73, 15);
		}
		return jLabelAlumnos;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Password");
			jLabel2.setFont(new java.awt.Font("Verdana",0,11));
			jLabel2.setLayout(null);
			jLabel2.setBounds(6, 188, 78, 14);
		}
		return jLabel2;
	}
	

	private JPasswordField getContrasena() {
		if(Contrasena == null) {
			Contrasena = new JPasswordField();
			Contrasena.setBounds(129, 188, 319, 20);
		}
		return Contrasena;
	}
	
	private JPasswordField getReContrasena() {
		if(ReContrasena == null) {
			ReContrasena = new JPasswordField();
			ReContrasena.setBounds(129, 220, 320, 20);
		}
		return ReContrasena;
	}
	
	private JLabel getJLabelPassword() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Confirme Password");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(6, 220, 173, 16);
		}
		return jLabel5;
	}
	
	private JTextField getJTextFieldUsuario() {
		if(jTextFieldUsuario == null) {
			jTextFieldUsuario = new JTextField();
			jTextFieldUsuario.setBounds(129, 158, 319, 20);
		}
		return jTextFieldUsuario;
	}

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(385, 450, 100, 23);
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			});
		}
		return jButtonCancelar;
	}
	
	private JButton getJButtonAceptar() {
		if(jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.setBounds(268, 450, 100, 24);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						@SuppressWarnings("deprecation")
						boolean flag = Controlador.getInstancia().altaUsuario(jTextFieldNombre.getText(), jTextFieldApellido.getText(), jTextFieldDni.getText(),
								jTextFieldUsuario.getText(), Contrasena.getText(), jDateChooserFecha.getDate(), sucursal, crearRoles());
						if(flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta al usuario: " + jTextFieldUsuario.getText(), "Alta Usuario realizada", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta al usuario.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
				}
			});
		}
		return jButtonAceptar;
	}
	
	private List<DTO_Rol> crearRoles(){
		List<DTO_Rol> roles = new ArrayList<DTO_Rol>();
		if(jCheckBoxAdministracion.isSelected()){
			roles.add(getRol("Administracion"));
		}
		if(jCheckBoxEncomienda.isSelected()){
			roles.add(getRol("Encomienda"));
		}
		if(jCheckBoxEnvio.isSelected()){
			roles.add(getRol("Envio"));
		}
		if(jCheckBoxVehiculo.isSelected()){
			roles.add(getRol("Vehiculos"));
		}
		return roles;
	}

	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder("General"));
			jPanel1.setBounds(10, 48, 464, 350);
			jPanel1.add(getJLabelNombre());
			jPanel1.add(getJLabelApellido());
			jPanel1.add(getJLabelSucursal());
			jPanel1.add(getJFormattedTextField1());
			jPanel1.add(getJTextFieldApellido());
			jPanel1.add(getJTextField1());
			jPanel1.add(getJLabel3());
			jPanel1.add(getJButton1());
			jPanel1.add(getJLabelPassword());			
			jPanel1.add(getJLabelAlumnos());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJTextFieldUsuario());
			jPanel1.add(getJDateChooserFecha());
			jPanel1.add(getJLabelDni());
			jPanel1.add(getJTextFieldDni());
			
			jPanel1.add(getJCheckBoxAdministracion());
			jPanel1.add(getJCheckBox1());
			jPanel1.add(getJCheckBoxEnvio());
			jPanel1.add(getJCheckBoxVehiculo());
			jPanel1.add(getJLabel4());
			jPanel1.add(getContrasena());
			jPanel1.add(getReContrasena());
			jPanel1.add(getJLabel5());
		}
		return jPanel1;
	}

	private boolean checkPassword(){
		char password[] = Contrasena.getPassword();
		char repassword[] = ReContrasena.getPassword();
		if (password.length != repassword.length)
			return false;
		for(int i= 0; i < password.length; i++){
			if(password[i] != repassword[i])
				return false;
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	private boolean validacion(){
		
		if (jTextFieldUsuario.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el usuario", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldUsuario.requestFocus();
			return false;
		}
		else if(Controlador.getInstancia().existeUsuario(jTextFieldUsuario.getText())){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese otro nombre de usuario, ya existe", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldUsuario.requestFocus();
			return false;
		} 
		else if(Contrasena.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el password.", "Atencion", JOptionPane.WARNING_MESSAGE);
			Contrasena.requestFocus();
			return false;
		} else if(ReContrasena.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la confirmacion password.", "Atencion", JOptionPane.WARNING_MESSAGE);
			ReContrasena.requestFocus();
			return false;
		}  else	if(!jCheckBoxAdministracion.isSelected() &&  !jCheckBoxEncomienda.isSelected() && !jCheckBoxEnvio.isSelected() && !jCheckBoxVehiculo.isSelected()){
			JOptionPane.showMessageDialog(null,"Debe de seleccionar al menos un rol.", "Atencion", JOptionPane.ERROR_MESSAGE);
			jCheckBoxAdministracion.requestFocus();
			return false;
		} else if(!checkPassword()){
			JOptionPane.showMessageDialog(null,"Las passwords ingresadas no coinciden.", "Atencion", JOptionPane.ERROR_MESSAGE);
			ReContrasena.requestFocus();
			return false;
		}
		return true;
	}
	

	private JCheckBox getJCheckBoxAdministracion() {
		if(jCheckBoxAdministracion == null) {
			jCheckBoxAdministracion = new JCheckBox();
			jCheckBoxAdministracion.setText("Administracion");
			jCheckBoxAdministracion.setBounds(94, 250, 130, 24);
		}
		return jCheckBoxAdministracion;
	}
	
	private JCheckBox getJCheckBoxVehiculo() {
		if(jCheckBoxVehiculo == null) {
			jCheckBoxVehiculo = new JCheckBox();
			jCheckBoxVehiculo.setText("Vehiculos");
			jCheckBoxVehiculo.setBounds(220, 250, 120, 20);
		}
		return jCheckBoxVehiculo;
	}
	

	private JCheckBox getJCheckBox1() {
		if(jCheckBoxEncomienda == null) {
			jCheckBoxEncomienda = new JCheckBox();
			jCheckBoxEncomienda.setText("Encomienda");
			jCheckBoxEncomienda.setBounds(94, 270, 120, 22);
		}
		return jCheckBoxEncomienda;
	}
	
	private JCheckBox getJCheckBoxEnvio() {
		if(jCheckBoxEnvio == null) {
			jCheckBoxEnvio = new JCheckBox();
			jCheckBoxEnvio.setText("Envio");
			jCheckBoxEnvio.setBounds(220, 270, 120, 21);
		}
		return jCheckBoxEnvio;
	}
	
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Rol");
			jLabel4.setFont(new java.awt.Font("Verdana",0,11));
			jLabel4.setLayout(null);
			jLabel4.setBounds(6, 250, 77, 18);
		}
		return jLabel4;
	}
	

	
	private DTO_Rol getRol(String descripcion){
		for(DTO_Rol rol : rolesExistentes)
			if (rol.getdescripcion().toLowerCase().equals(descripcion.toLowerCase()))
				return rol;
		return null;
	}

}
