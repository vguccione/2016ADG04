package com.ADG04.Vista.Proveedores;
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
import javax.swing.border.TitledBorder;

import com.ADG04.Controller.Controlador;
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
public class AltaServicioSeguridad extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JTextField jTextFieldDescripcion;
	private JButton Buscar;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldCuit;
	private JLabel jLabel4;
	private JLabel jLabelRazonSocial;
	private JFormattedTextField jFormattedTextFieldMonto;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;

	private DTO_Proveedor proveedor;

	
	public AltaServicioSeguridad() {
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
			{
				jPanel = new JPanel();
				jPanel.setLayout(null);
				jPanel.add(getJButtonAceptar());
				jPanel.add(getJButtonCancelar());
				jPanel.add(getJLabel1());
				{
					jLabelTitulo = new JLabel();
					jPanel.add(jLabelTitulo);
					jPanel.add(getJPanel1());
					jPanel.add(getJPanel2());
					jLabelTitulo.setText("Alta Servicio Seguridad");
					jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
					jLabelTitulo.setBounds(10, 11, 372, 26);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel, 0, 372, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, 0, 429, Short.MAX_VALUE));
			pack();
			this.setSize(445, 432);
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
			jLabelAlumnos.setText("Descripcion");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 27, 71, 13);
		}
		return jLabelAlumnos;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("CUIT");
			jLabel2.setFont(new java.awt.Font("Verdana",0,11));
			jLabel2.setLayout(null);
			jLabel2.setBounds(10, 27, 78, 14);
		}
		return jLabel2;
	}

	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Precio");
			jLabel4.setFont(new java.awt.Font("Verdana",0,11));
			jLabel4.setLayout(null);
			jLabel4.setBounds(6, 54, 55, 12);
		}
		return jLabel4;
	}

	private JTextField getJTextField2() {
		if(jTextFieldCuit == null) {
			jTextFieldCuit = new JTextField();
			jTextFieldCuit.setBounds(92, 27, 80, 20);
		}
		return jTextFieldCuit;
	}

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(328, 318, 75, 23);
			jButtonCancelar.setVisible(false);
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
			jButtonAceptar.setBounds(247, 318, 71, 23);
			jButtonAceptar.setVisible(false);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAceptarActionPerformed(evt);
					if(validacion()){
						boolean flag = Controlador.getInstancia().altaServicioSeguridad(proveedor.getId(),jTextFieldDescripcion.getText(), (Float)jFormattedTextFieldMonto.getValue());
						if(flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta el servicio de seguridad", "Alta servicio seguridad realizada", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta el servicio de seguridad.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
				}
			});
		}
		return jButtonAceptar;
	}
	
	private void jButtonAceptarActionPerformed(ActionEvent evt) {
		System.out.println("jButtonAceptar.actionPerformed, event="+evt);
		//Alta Factura
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder("Seleccione el proveedor de seguridad"));
			jPanel1.setBounds(10, 48, 393, 64);
			jPanel1.add(getJLabel2());
			jPanel1.add(getJTextField2());
			jPanel1.add(getJButton1());
			jPanel1.add(getJLabelRazonSocial());
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(10, 123, 393, 98);
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Ingrese datos del servicio de seguridad", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			jPanel2.add(getJLabel4());
			jPanel2.add(getJLabelAlumnos());
			jPanel2.add(getJFormattedTextFieldMonto());
			jPanel2.add(getJTextField2x());
			jPanel2.setVisible(false);
		}
		return jPanel2;
	}
	
	private JButton getJButton1() {
		if(Buscar == null) {
			Buscar = new JButton();
			Buscar.setText("Buscar");
			Buscar.setBounds(182, 27, 69, 20);
			Buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAceptarActionPerformed(evt);

					proveedor = Controlador.getInstancia().buscarProveedorByCuit(jTextFieldCuit.getText());
					
					if(proveedor == null){
						//No encontro el proveedor entonces notifico que no lo encontro
						JOptionPane.showMessageDialog(null,"No se ha encontrado un proveedor con el numero de cuit:" + jTextFieldCuit.getText(), "Error", JOptionPane.ERROR_MESSAGE);
						jTextFieldCuit.setText("");
					} else {
						jTextFieldCuit.setEnabled(false);
						jLabelRazonSocial.setText(proveedor.getRazonSocial());
						Buscar.setEnabled(false);
						
						jButtonAceptar.setVisible(true);
						jButtonCancelar.setVisible(true);
						jPanel2.setVisible(true);
					}
				}
			});
		}
		return Buscar;
	}
	

public boolean validacion(){
		
		if (jTextFieldDescripcion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la descripcion del servicio de seguridad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldDescripcion.requestFocus();
			return false;
		} else if(jFormattedTextFieldMonto.getValue().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio del servicio de seguridad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldMonto.requestFocus();
			return false;
		}
		return true;

	}

	private JFormattedTextField getJFormattedTextFieldMonto() {
		if(jFormattedTextFieldMonto == null) {
			jFormattedTextFieldMonto = new JFormattedTextField(new Float(0));
			jFormattedTextFieldMonto.setBounds(94, 50, 272, 20);
		}
		return jFormattedTextFieldMonto;
	}

	private JTextField getJTextField2x() {
		if(jTextFieldDescripcion == null) {
			jTextFieldDescripcion = new JTextField();
			jTextFieldDescripcion.setBounds(94, 25, 272, 20);
		}
		return jTextFieldDescripcion;
	}
	
	private JLabel getJLabelRazonSocial() {
		if(jLabelRazonSocial == null) {
			jLabelRazonSocial = new JLabel();
			jLabelRazonSocial.setText("");
			jLabelRazonSocial.setFont(new java.awt.Font("Verdana",0,11));
			jLabelRazonSocial.setLayout(null);
			jLabelRazonSocial.setBounds(255, 30, 127, 15);
		}
		return jLabelRazonSocial;
	}

}
