package com.ADG04.Vista.Administrativos;
import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


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
public class AltaEmpleado extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JDateChooser jDateChooserFecha;
	private JLabel jLabel4;
	private JLabel jLabelSucursal;
	private JLabel jLabelSuperior;
	private JButton jButton2;
	private JButton jButton1;
	private JFormattedTextField jFormattedTextFieldIdSucursal;
	private JFormattedTextField jFormattedTextFieldIdSuperior;
	private JTextField jTextFieldApellido;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldNombre;
	private JLabel jLabel11;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;
	private DTO_Sucursal sucursal;
	private DTO_Usuario superior;

	public AltaEmpleado() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/box.png")).getImage());
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
					jLabelTitulo.setText("Alta Empleado");
					jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
					jLabelTitulo.setBounds(10, 11, 372, 26);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(59, Short.MAX_VALUE));
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
			jLabelAlumnos.setText("Nombre");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 27, 73, 15);
		}
		return jLabelAlumnos;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Apellido");
			jLabel2.setFont(new java.awt.Font("Verdana",0,11));
			jLabel2.setLayout(null);
			jLabel2.setBounds(6, 53, 78, 14);
		}
		return jLabel2;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Fecha Ingreso");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(6, 78, 81, 19);
		}
		return jLabel3;
	}

	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Sucursal");
			jLabel11.setFont(new java.awt.Font("Verdana",0,11));
			jLabel11.setLayout(null);
			jLabel11.setBounds(6, 107, 80, 16);
		}
		return jLabel11;
	}
	
	private JTextField getJTextField1() {
		if(jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(94, 25, 354, 20);
		}
		return jTextFieldNombre;
	}

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(400, 244, 74, 23);
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
			jButtonAceptar.setBounds(316, 243, 70, 24);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {	  
						boolean flag = Controlador.getInstancia().altaEmpleado(jTextFieldNombre.getText(), jTextFieldApellido.getText(), jDateChooserFecha.getDate(), sucursal, superior);
						if(flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta al empleado: " + jTextFieldNombre.getText() + " " + jTextFieldApellido.getText(), "Alta empleado realizado", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta al proveedor.", "Error", JOptionPane.ERROR_MESSAGE);	
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
			jPanel1.setBounds(10, 48, 464, 179);
			jPanel1.add(getJLabelAlumnos());
			jPanel1.add(getJTextField1());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJLabel3());
			jPanel1.add(getJLabel11());
			jPanel1.add(getJTextField1x());
			jPanel1.add(getJDateChooserFecha());
			jPanel1.add(getJLabel4());
			jPanel1.add(getJFormattedTextFieldPrecio());
			jPanel1.add(getJFormattedTextField1());
			jPanel1.add(getJButton1());
			jPanel1.add(getJButton2());
			jPanel1.add(getJLabel5());
			jPanel1.add(getJLabel6());

		}
		return jPanel1;
	}

	public boolean validacion(){
		
		if (jTextFieldNombre.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el nombre del empleado", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jTextFieldNombre.requestFocus();
			return false;
		} else if(jTextFieldApellido.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el apellido del empleado.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jTextFieldApellido.requestFocus();
			return false;
		} else if(jDateChooserFecha.getDate().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la fecha de ingreso.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jDateChooserFecha.requestFocus();
			return false;
		} else if(jLabelSucursal.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la sucursal donde trabaja.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal.requestFocus();
			return false;
		} else if(jLabelSuperior.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el superior.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSuperior.requestFocus();
			return false;
		} 
		return true;

	}
	
	
	private JTextField getJTextField1x() {
		if(jTextFieldApellido == null) {
			jTextFieldApellido = new JTextField();
			jTextFieldApellido.setBounds(94, 51, 354, 20);
		}
		return jTextFieldApellido;
	}
	
	private JDateChooser getJDateChooserFecha() {
		if(jDateChooserFecha == null) {
			jDateChooserFecha = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserFecha.setBounds(94, 77, 89, 21);
		}
		return jDateChooserFecha;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Superior");
			jLabel4.setFont(new java.awt.Font("Verdana",0,11));
			jLabel4.setLayout(null);
			jLabel4.setBounds(6, 134, 77, 16);
		}
		return jLabel4;
	}

	private JFormattedTextField getJFormattedTextFieldPrecio() {
		if(jFormattedTextFieldIdSuperior == null) {
			jFormattedTextFieldIdSuperior = new JFormattedTextField();
			jFormattedTextFieldIdSuperior.setValue(new Integer(0));
			jFormattedTextFieldIdSuperior.setBounds(94, 133, 49, 20);
		}
		return jFormattedTextFieldIdSuperior;
	}
	
	private JFormattedTextField getJFormattedTextField1() {
		if(jFormattedTextFieldIdSucursal == null) {
			jFormattedTextFieldIdSucursal = new JFormattedTextField();
			jFormattedTextFieldIdSucursal.setValue(new Integer(0));
			jFormattedTextFieldIdSucursal.setBounds(94, 105, 48, 20);
		}
		return jFormattedTextFieldIdSucursal;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar");
			jButton1.setBounds(148, 104, 65, 21);
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
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Buscar");
			jButton2.setBounds(149, 133, 65, 21);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					superior = Controlador.getInstancia().getEmpleado((Integer) jFormattedTextFieldIdSuperior.getValue());
					if(superior != null){
						jFormattedTextFieldIdSuperior.setEnabled(false);
						jButton2.setEnabled(false);
						jLabelSuperior.setText(superior.getNombre() + " " + superior.getApellido());
					} else {
						JOptionPane.showMessageDialog(null,"No se ha encontrado el supeior.", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
			});
		}
		return jButton2;
	}
	
	private JLabel getJLabel5() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("");
			jLabelSucursal.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursal.setLayout(null);
			jLabelSucursal.setBounds(217, 105, 231, 16);
		}
		return jLabelSucursal;
	}
	
	private JLabel getJLabel6() {
		if(jLabelSuperior == null) {
			jLabelSuperior = new JLabel();
			jLabelSuperior.setText("");
			jLabelSuperior.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSuperior.setLayout(null);
			jLabelSuperior.setBounds(218, 136, 234, 14);
		}
		return jLabelSuperior;
	}

}
