package com.ADG04.Vista.Administrativos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;
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
public class CambiarContrasena extends javax.swing.JFrame {

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
	private JPasswordField NuevaContrasena;
	private JLabel jLabel5;
	private JPasswordField Contrasena;
	private JPasswordField ReNuevaContrasena;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public CambiarContrasena() {
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
					jPanel.add(getJLabel4());
					jLabelTitulo.setText("Cambiar Password");
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
			this.setSize(505, 328);
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

	
	

	
	private JLabel getJLabelAlumnos() {
		if(jLabelAlumnos == null) {
			jLabelAlumnos = new JLabel();
			jLabelAlumnos.setText("Usuario");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 27, 73, 15);
		}
		return jLabelAlumnos;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Password");
			jLabel2.setFont(new java.awt.Font("Verdana",0,11));
			jLabel2.setLayout(null);
			jLabel2.setBounds(6, 53, 78, 14);
		}
		return jLabel2;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Confirme Password");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(6, 101, 113, 23);
		}
		return jLabel3;
	}

	private JTextField getJTextField1() {
		if(jTextFieldUsuario == null) {
			jTextFieldUsuario = new JTextField();
			jTextFieldUsuario.setBounds(129, 25, 319, 20);
		}
		return jTextFieldUsuario;
	}

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(405, 255, 74, 23);
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
			jButtonAceptar.setBounds(325, 254, 70, 24);
			jButtonAceptar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						Integer u = Controlador.getInstancia().login(jTextFieldUsuario.getText(), Contrasena.getText());
						if(u != null){
							boolean flag = Controlador.getInstancia().cambiarPassword(jTextFieldUsuario.getText(), Contrasena.getText(), NuevaContrasena.getText());
							if(flag){
								JOptionPane.showMessageDialog(null,"Se ha cambiado la password del usuario: " + jTextFieldUsuario.getText(), "Cambio passowrd realizadao", JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null,"No se ha podido cambiar la password del usuario.", "Error", JOptionPane.ERROR_MESSAGE);	
							}
						} else {
							jLabel4.setVisible(true);
						}
						
					}
				}
			});
		}
		return jButtonAceptar;
	}
	

	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder("General"));
			jPanel1.setBounds(10, 48, 464, 142);
			jPanel1.add(getJLabelAlumnos());
			jPanel1.add(getJTextField1());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJLabel3());
			jPanel1.add(getContrasena());
			jPanel1.add(getNuevaContrasena());
			jPanel1.add(getJLabel5());
			jPanel1.add(getJPasswordField1());

		}
		return jPanel1;
	}

	private boolean checkPassword(){
		char password[] = NuevaContrasena.getPassword();
		char repassword[] = ReNuevaContrasena.getPassword();
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
		} else if(Contrasena.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el password.", "Atencion", JOptionPane.WARNING_MESSAGE);
			Contrasena.requestFocus();
			return false;
		} else if(NuevaContrasena.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el nuevo password.", "Atencion", JOptionPane.WARNING_MESSAGE);
			NuevaContrasena.requestFocus();
			return false;
		} else if(ReNuevaContrasena.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la confirmacion del nuevo password.", "Atencion", JOptionPane.WARNING_MESSAGE);
			NuevaContrasena.requestFocus();
			return false;
		} else if(!checkPassword()){
			JOptionPane.showMessageDialog(null,"La nueva password ingresadas no coinciden.", "Atencion", JOptionPane.ERROR_MESSAGE);
			NuevaContrasena.requestFocus();
			return false;
		}
		return true;
	}

	private JPasswordField getContrasena() {
		if(Contrasena == null) {
			Contrasena = new JPasswordField();
			Contrasena.setBounds(129, 51, 319, 20);
		}
		return Contrasena;
	}
	
	private JPasswordField getNuevaContrasena() {
		if(NuevaContrasena == null) {
			NuevaContrasena = new JPasswordField();
			NuevaContrasena.setBounds(129, 77, 320, 20);
		}
		return NuevaContrasena;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Nueva Password");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(6, 79, 113, 16);
		}
		return jLabel5;
	}
	
	private JPasswordField getJPasswordField1() {
		if(ReNuevaContrasena == null) {
			ReNuevaContrasena = new JPasswordField();
			ReNuevaContrasena.setBounds(129, 103, 319, 22);
		}
		return ReNuevaContrasena;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("El usuario y/o contrase�a no es v�lido");
			jLabel4.setFont(new java.awt.Font("Tahoma",1,11));
			jLabel4.setVisible(false);
			jLabel4.setForeground(Color.RED);
			jLabel4.setLayout(null);
			jLabel4.setBounds(10, 189, 460, 32);
		}
		return jLabel4;
	}

}
