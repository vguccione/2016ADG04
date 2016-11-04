package com.ADG04.Vista.Proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.controladorAdmin;
import dto.Administracion.DTO_Destino;
import dto.Administracion.DTO_Sucursal;
import dto.Proveedor.DTO_Proveedor;


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
public class AltaPrecioCarrier extends javax.swing.JFrame {

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
	private JFormattedTextField jFormattedTextFieldIdSucursal;
	private JRadioButton jRadioButtonInternacional;
	private JRadioButton jRadioButtonNacional;
	private ButtonGroup buttonGroupDestino;
	private JTextArea jTextAreaComentarios;
	private JScrollPane jScrollPane1;
	private JLabel jLabelSucursal;
	private JButton jButton1;
	private JLabel jLabel7;
	private JButton Buscar;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldCuit;
	private JLabel jLabel8;
	private JLabel jLabel4;
	private JLabel jLabel5;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxDestinos;
	private JTextField jTextFieldPrioridad;
	private JFormattedTextField jFormattedTextFieldKMExtra;
	private JLabel jLabel3;
	private JFormattedTextField jFormattedTextFieldPrecio;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;
	private DTO_Sucursal sucursal;
	private JLabel jLabelRazonSocial;

	private DTO_Proveedor proveedor;
	private List<DTO_Destino> destinos;
	
	public AltaPrecioCarrier() {
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
					jLabelTitulo.setText("Alta Precio Carrier");
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
			this.setSize(455, 481);
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
			jLabelAlumnos.setText("Destino");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 51, 75, 15);
			jLabelAlumnos.setVisible(false);
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
			jLabel4.setBounds(6, 73, 56, 16);
			jLabel4.setVisible(false);
		}
		return jLabel4;
	}

	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Comentarios");
			jLabel8.setFont(new java.awt.Font("Verdana",0,11));
			jLabel8.setLayout(null);
			jLabel8.setBounds(4, 151, 76, 14);
			jLabel8.setVisible(false);
		}
		return jLabel8;
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
			jButtonCancelar.setBounds(342, 408, 75, 23);
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
			jButtonAceptar.setBounds(252, 408, 78, 22);
			jButtonAceptar.setVisible(false);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if(validacion()){
						String tipo = "";
						if(jRadioButtonNacional.isSelected())
							tipo = "N";
						else 
							tipo = "I";
						DTO_Destino d = destinos.get(jComboBoxDestinos.getSelectedIndex());
						boolean flag = controladorAdmin.getInstancia().altaPrecioCarrier(tipo,  proveedor.getId(), d.getId(), jTextAreaComentarios.getText(), jTextFieldPrioridad.getText(), (float)jFormattedTextFieldKMExtra.getValue(), (float)jFormattedTextFieldPrecio.getValue());
							if(flag){
								JOptionPane.showMessageDialog(null,"Se ha dado el precio del carrier del proveedor: " + proveedor.getRazonSocial(), "Alta precio carrier realizada", JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null,"No se ha podido dar el precio del carrier.", "Error", JOptionPane.ERROR_MESSAGE);	
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
			jPanel1.setBorder(BorderFactory.createTitledBorder("Seleccione el Carrier\r\n"));
			jPanel1.setBounds(10, 48, 429, 63);
			jPanel1.add(getJLabel2());
			jPanel1.add(getJTextField2());
			jPanel1.add(getJButton1());
			jPanel1.add(getJLabel9());
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createTitledBorder("Ingrese datos del precio Carrier"));
			jPanel2.setBounds(10, 117, 430, 229);
			jPanel2.setLayout(null);
			
			jPanel2.add(getJRadioButtonNacional());
			jPanel2.add(getJRadioButtonInternacional());
			jPanel2.add(getJLabel4());
			jPanel2.add(getJLabel8());
			jPanel2.add(getJLabelAlumnos());
			jPanel2.add(getJFormattedTextFieldMonto());
			jPanel2.add(getJLabel3());
			jPanel2.add(getJFormattedTextField1());
			jPanel2.add(getJLabel5());
			jPanel2.add(getJTextField1x());
			jPanel2.add(getJComboBoxPaises());
			jPanel2.add(getJLabel7());
			jPanel2.add(getJFormattedTextFieldIdSucursal());
			jPanel2.add(getJButton1x());
			jPanel2.add(getJLabelSucursal());
			jPanel2.add(getJScrollPane1());
			jPanel2.setVisible(false);
			getButtonGroupDestino();
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
					proveedor = controladorAdmin.getInstancia().buscarProveedor(jTextFieldCuit.getText());
					
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
		
		if (jLabelRazonSocial.toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el proveedor", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jTextFieldCuit.requestFocus();
			return false;
		} else if (jLabelSucursal.toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la sucursal de origen", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal.requestFocus();
			return false;
		} else if (jComboBoxDestinos.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el destino", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jComboBoxDestinos.requestFocus();
			return false;
		} else if(jFormattedTextFieldPrecio.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldPrecio.requestFocus();
			return false;
		} else if(jFormattedTextFieldKMExtra.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio del km extra.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldKMExtra.requestFocus();
			return false;
		} else if(jTextFieldPrioridad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la prioridad", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			jTextFieldPrioridad.requestFocus();
			return false;
		} 
		return true;

	}

	private JFormattedTextField getJFormattedTextFieldMonto() {
		if(jFormattedTextFieldPrecio == null) {
			jFormattedTextFieldPrecio = new JFormattedTextField(new Float(0));
			jFormattedTextFieldPrecio.setValue(new Float(0));
			jFormattedTextFieldPrecio.setBounds(94, 70, 320, 20);
			jFormattedTextFieldPrecio.setVisible(false);
		}
		return jFormattedTextFieldPrecio;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Km. Extra");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(6, 100, 84, 13);
			jLabel3.setVisible(false);
		}
		return jLabel3;
	}
	
	private JFormattedTextField getJFormattedTextField1() {
		if(jFormattedTextFieldKMExtra == null) {
			jFormattedTextFieldKMExtra = new JFormattedTextField();
			jFormattedTextFieldKMExtra.setValue(new Float(0));
			jFormattedTextFieldKMExtra.setBounds(94, 96, 319, 21);
			jFormattedTextFieldKMExtra.setVisible(false);
		}
		return jFormattedTextFieldKMExtra;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Prioridad");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(4, 125, 81, 15);
			jLabel5.setVisible(false);
		}
		return jLabel5;
	}
	
	private JTextField getJTextField1x() {
		if(jTextFieldPrioridad == null) {
			jTextFieldPrioridad = new JTextField();
			jTextFieldPrioridad.setBounds(94, 123, 319, 19);
			jTextFieldPrioridad.setVisible(false);
		}
		return jTextFieldPrioridad;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private JComboBox getJComboBoxPaises() {
		if(jComboBoxDestinos == null) {
			jComboBoxDestinos = new JComboBox();
			jComboBoxDestinos.setBounds(260, 46, 154, 19);
			jComboBoxDestinos.setVisible(false);
		}
		return jComboBoxDestinos;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ComboBoxModel getItemsComboBox(){
		destinos = null;
		if(jRadioButtonNacional.isSelected()){
			destinos = controladorAdmin.getInstancia().listarDestinoNacionalSucursal(sucursal.getId());
		} else if (jRadioButtonInternacional.isSelected()){
			destinos = controladorAdmin.getInstancia().listarDestinoInternacionalSucursal(sucursal.getId());
		}
		if(destinos != null){
			String lista[] = new String[destinos.size()];
			for(int i=0; i<destinos.size(); i++){
				lista[i] = destinos.get(i).getCiudad();
			}
			ComboBoxModel jComboBoxModel = new DefaultComboBoxModel(lista);
		
			return jComboBoxModel;
		}
		return null;
	}

	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Origen");
			jLabel7.setFont(new java.awt.Font("Verdana",0,11));
			jLabel7.setLayout(null);
			jLabel7.setBounds(6, 27, 72, 13);
		}
		return jLabel7;
	}
	
	private JFormattedTextField getJFormattedTextFieldIdSucursal() {
		if(jFormattedTextFieldIdSucursal == null) {
			jFormattedTextFieldIdSucursal = new JFormattedTextField();
			jFormattedTextFieldIdSucursal.setValue(new Integer(0));
			jFormattedTextFieldIdSucursal.setBounds(94, 25, 37, 18);
		}
		return jFormattedTextFieldIdSucursal;
	}
	
	private JButton getJButton1x() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar");
			jButton1.setBounds(137, 24, 64, 19);
			jButton1.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent evt) {
					sucursal = controladorAdmin.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal.getValue());
					if(sucursal != null){
						jFormattedTextFieldIdSucursal.setEnabled(false);
						jButton1.setEnabled(false);
						jLabelSucursal.setText(sucursal.getDescripcion());
						jComboBoxDestinos.setModel(getItemsComboBox());
						jRadioButtonNacional.setVisible(true);
						jRadioButtonInternacional.setVisible(true);
						jComboBoxDestinos.setVisible(true);
						jFormattedTextFieldPrecio.setVisible(true);
						jFormattedTextFieldKMExtra.setVisible(true);
						jTextFieldPrioridad.setVisible(true);
						jScrollPane1.setVisible(true);
						jLabelAlumnos.setVisible(true);
						jLabel4.setVisible(true);
						jLabel3.setVisible(true);
						jLabel5.setVisible(true);
						jLabel8.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se ha encontrado la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
			});
		}
		return jButton1;
	}
	
	private JLabel getJLabelSucursal() {
		if(jLabelSucursal == null) {
			jLabelSucursal = new JLabel();
			jLabelSucursal.setText("");
			jLabelSucursal.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursal.setLayout(null);
			jLabelSucursal.setBounds(206, 27, 207, 15);
		}
		return jLabelSucursal;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(95, 148, 317, 57);
			jScrollPane1.setViewportView(getJTextArea1());
			jScrollPane1.setVisible(false);
		}
		return jScrollPane1;
	}
	
	private JTextArea getJTextArea1() {
		if(jTextAreaComentarios == null) {
			jTextAreaComentarios = new JTextArea();
		}
		return jTextAreaComentarios;
	}
	
	private ButtonGroup getButtonGroupDestino() {
		if(buttonGroupDestino == null) {
			buttonGroupDestino = new ButtonGroup();
			buttonGroupDestino.add(jRadioButtonNacional);
			buttonGroupDestino.add(jRadioButtonInternacional);
		}
		return buttonGroupDestino;
	}
	
	private JRadioButton getJRadioButtonNacional() {
		if(jRadioButtonNacional == null) {
			jRadioButtonNacional = new JRadioButton();
			jRadioButtonNacional.setText("Nacional");
			jRadioButtonNacional.setBounds(94, 47, 70, 21);
			jRadioButtonNacional.setSelected(true);
			jRadioButtonNacional.setVisible(false);
			jRadioButtonNacional.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent evt) {
					jComboBoxDestinos.setModel(getItemsComboBox());
				}
			});
		}
		return jRadioButtonNacional;
	}
	
	private JRadioButton getJRadioButtonInternacional() {
		if(jRadioButtonInternacional == null) {
			jRadioButtonInternacional = new JRadioButton();
			jRadioButtonInternacional.setText("Internacional");
			jRadioButtonInternacional.setBounds(166, 49, 93, 17);
			jRadioButtonInternacional.setVisible(false);
			jRadioButtonInternacional.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent evt) {
					jComboBoxDestinos.setModel(getItemsComboBox());
				}
			});
		}
		return jRadioButtonInternacional;
	}
	
	private JLabel getJLabel9() {
		if(jLabelRazonSocial == null) {
			jLabelRazonSocial = new JLabel();
			jLabelRazonSocial.setText("");
			jLabelRazonSocial.setFont(new java.awt.Font("Verdana",0,11));
			jLabelRazonSocial.setLayout(null);
			jLabelRazonSocial.setBounds(255, 30, 168, 15);
		}
		return jLabelRazonSocial;
	}

}
