package com.ADG04.Vista.Proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
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
public class AltaProveedor extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JLabel jLabel17;
	private JTextField jTextField3;
	private JLabel jLabel15;
	private JPanel jPanel3;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxProvincias;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxPaises;
	private JRadioButton Otro;
	private JRadioButton Taller;
	private JRadioButton jRadioButtonNo;
	private JRadioButton jRadioButtonSi;
	private ButtonGroup buttonGroup1;
	private JRadioButton Seguridad;
	private JRadioButton Carrier;
	private JRadioButton Aseguradora;
	private ButtonGroup buttonGroup;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldTelefono;
	private JTextField jTextFieldEmail;
	private JTextField jTextFieldLocalidad;
	private JLabel jLabel5;
	private JTextField jTextFieldCodigoPostal;
	private JTextField jTextFieldDireccion;
	private JTextField jTextFieldCuit;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabelAlumnos;
	private JLabel jLabel1;
	private DTO_Proveedor dto;

	public AltaProveedor(DTO_Proveedor DTO) {
		super();
		dto = DTO;
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
					jPanel.add(getJPanel3());
					jLabelTitulo.setText("Alta Proveedor");
					jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
					jLabelTitulo.setBounds(10, 11, 372, 26);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel, 0, 536, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, 0, 493, Short.MAX_VALUE)
				.addContainerGap(19, 19));
			pack();
			this.setSize(500, 587);
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
			jLabelAlumnos.setText("Razon Social");
			jLabelAlumnos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelAlumnos.setLayout(null);
			jLabelAlumnos.setBounds(6, 27, 103, 15);
		}
		return jLabelAlumnos;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("CUIT");
			jLabel2.setFont(new java.awt.Font("Verdana",0,11));
			jLabel2.setLayout(null);
			jLabel2.setBounds(6, 53, 100, 14);
		}
		return jLabel2;
	}
	
		
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Direccion");
			jLabel4.setFont(new java.awt.Font("Verdana",0,11));
			jLabel4.setLayout(null);
			jLabel4.setBounds(6, 84, 100, 15);
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Codigo Postal");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(6, 114, 100, 14);
		}
		return jLabel5;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Localidad");
			jLabel6.setFont(new java.awt.Font("Verdana",0,11));
			jLabel6.setLayout(null);
			jLabel6.setBounds(6, 54, 100, 15);
		}
		return jLabel6;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Provincia");
			jLabel7.setFont(new java.awt.Font("Verdana",0,11));
			jLabel7.setLayout(null);
			jLabel7.setBounds(257, 23, 100, 15);
		}
		return jLabel7;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Pais");
			jLabel8.setFont(new java.awt.Font("Verdana",0,11));
			jLabel8.setLayout(null);
			jLabel8.setBounds(6, 23, 100, 15);
		}
		return jLabel8;
	}
	
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("Telefono");
			jLabel10.setFont(new java.awt.Font("Verdana",0,11));
			jLabel10.setLayout(null);
			jLabel10.setBounds(257, 114, 100, 15);
		}
		return jLabel10;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Email");
			jLabel9.setFont(new java.awt.Font("Verdana",0,11));
			jLabel9.setLayout(null);
			jLabel9.setBounds(6, 143, 100, 15);
		}
		return jLabel9;
	}
	
	
	private JTextField getJTextField1() {
		if(jTextFieldRazonSocial == null) {
			jTextFieldRazonSocial = new JTextField();
			jTextFieldRazonSocial.setBounds(94, 25, 354, 20);
			if(dto!=null){
				jTextFieldRazonSocial.setText(dto.getRazonSocial());
			}
		}
		return jTextFieldRazonSocial;
	}
	
	private JTextField getJTextField2() {
		if(jTextFieldCuit == null) {
			jTextFieldCuit = new JTextField();
			jTextFieldCuit.setBounds(94, 51, 111, 20);
			if(dto!=null){
				jTextFieldCuit.setText(dto.getCuit());
			}
		}
		return jTextFieldCuit;
	}
	
	
	private JTextField getJTextField4() {
		if(jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.setBounds(94, 83, 350, 18);
			if(dto!=null){
				jTextFieldDireccion.setText(dto.getDireccion().getCalle());
			}
		}
		return jTextFieldDireccion;
	}
	
	private JTextField getJTextField5() {
		if(jTextFieldCodigoPostal == null) {
			jTextFieldCodigoPostal = new JTextField();
			jTextFieldCodigoPostal.setBounds(94, 112, 117, 20);
			if(dto!=null){
				jTextFieldCodigoPostal.setText(String.valueOf(dto.getDireccion().getCodigoPostal()));
			}
		}
		return jTextFieldCodigoPostal;
	}
	
	private JTextField getJTextField6() {
		if(jTextFieldLocalidad == null) {
			jTextFieldLocalidad = new JTextField();
			jTextFieldLocalidad.setBounds(94, 52, 350, 20);
			if(dto!=null){
				jTextFieldLocalidad.setText(dto.getDireccion().getLocalidad());
			}
		}
		return jTextFieldLocalidad;
	}

	private JTextField getJTextField9() {
		if(jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setBounds(94, 143, 350, 20);
			if(dto!=null){
				jTextFieldEmail.setText(dto.getEmail());
			}
		}
		return jTextFieldEmail;
	}
	
	private JTextField getJTextField10() {
		if(jTextFieldTelefono == null) {
			jTextFieldTelefono = new JTextField();
			jTextFieldTelefono.setBounds(327, 112, 117, 20);
			if(dto!=null){
				jTextFieldTelefono.setText(dto.getTelefono());
			}
		}
		return jTextFieldTelefono;
	}
	

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(350, 514, 100,23);
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
			jButtonAceptar.setBounds(200, 514, 100, 23);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						char tipo = ' ';
						String especialidad = "";
						int tallerOficial =0;
						
						if (Aseguradora.isSelected())
							tipo = 'A';
						else if (Carrier.isSelected())
							tipo = 'C';
						else if (Seguridad.isSelected())
							tipo = 'S';
						else if (Taller.isSelected()){
							tipo = 'T';
							if (jRadioButtonSi.isSelected())
								tallerOficial = 1;
							else
								tallerOficial = 0;
						} else if(Otro.isSelected())
							tipo ='O';
							
						try{
							DTO_Direccion dir = new DTO_Direccion();
							dir.setCalle(jTextFieldDireccion.getText());
							dir.setCodigoPostal(Integer.valueOf(jTextFieldCodigoPostal.getText()));
							dir.setLocalidad(jTextFieldLocalidad.getText());
							dir.setPais(Controlador.getInstancia().getPaisByNombre(jComboBoxPaises.getSelectedItem().toString()));
							dir.setProvincia(Controlador.getInstancia().getProvByNombre(jComboBoxProvincias.getSelectedItem().toString()));
							
							if(dto==null){
								Controlador.getInstancia().altaProveedor(dir, "1", jTextFieldCuit.getText(), jTextFieldRazonSocial.getText(), jTextFieldEmail.getText(), jTextFieldTelefono.getText(), tallerOficial, tipo);
								JOptionPane.showMessageDialog(null,"Se ha dado de alta al proveedor:" + jTextFieldRazonSocial.getText(), "Alta proveedor realizada", JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								Controlador.getInstancia().modificarProveedor(dto.getId(), dir, "1", jTextFieldCuit.getText(), jTextFieldRazonSocial.getText(), jTextFieldEmail.getText(), jTextFieldTelefono.getText(), tallerOficial, tipo);
								JOptionPane.showMessageDialog(null,"Se ha modificado el proveedor:" + jTextFieldRazonSocial.getText(), "Modificacion de Proveedor realizada", JOptionPane.INFORMATION_MESSAGE);
							}
						
							setVisible(false);
						} catch(Exception e) {
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
			jPanel1.setBounds(10, 48, 464, 168);
			jPanel1.add(getJLabelAlumnos());
			jPanel1.add(getJTextField1());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJTextField2());
			jPanel1.add(getJLabel12());
			jPanel1.add(getJLabel13());
			jPanel1.add(getAseguradora());
			jPanel1.add(getCarrier());
			jPanel1.add(getSeguridad());
			jPanel1.add(getTaller());
			jPanel1.add(getOtro());
	
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createTitledBorder("Datos del Contacto"));
			jPanel2.setBounds(10, 227, 464, 179);
			jPanel2.setLayout(null);
			getButtonGroup();
			jPanel2.add(getJLabel4());
			jPanel2.add(getJLabel6());
			jPanel2.add(getJLabel7());
			jPanel2.add(getJTextField4());
			jPanel2.add(getJTextField5());
			jPanel2.add(getJTextField6());
			jPanel2.add(getJLabel8());
			jPanel2.add(getJLabel5());
			jPanel2.add(getJLabel9());
			jPanel2.add(getJLabel10());
			jPanel2.add(getJTextField10());
			jPanel2.add(getJTextField9());
			jPanel2.add(getJComboBoxPaises());
			jPanel2.add(getJComboBox1());
		}
		return jPanel2;
	}
	
	private JLabel getJLabel12() {
		if(jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("CUIT");
			jLabel12.setFont(new java.awt.Font("Verdana",0,11));
			jLabel12.setLayout(null);
			jLabel12.setBounds(6, 53, 78, 14);
		}
		return jLabel12;
	}
	
	private JLabel getJLabel13() {
		if(jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("Tipo");
			jLabel13.setFont(new java.awt.Font("Verdana",0,11));
			jLabel13.setLayout(null);
			jLabel13.setBounds(6, 78, 78, 14);
		}
		return jLabel13;
	}
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getAseguradora());
			buttonGroup.add(getCarrier());
			buttonGroup.add(getSeguridad());
			buttonGroup.add(getTaller());
			buttonGroup.add(getOtro());
		}
		return buttonGroup;
	}
	
	private JRadioButton getAseguradora() {
		if(Aseguradora == null) {
			Aseguradora = new JRadioButton();
			Aseguradora.setText("Aseguradora");
			Aseguradora.setBounds(94, 75, 93, 23);
			if(dto!=null){
				if(dto.getTipo()=='A')
					Aseguradora.setSelected(true);
			}
			Aseguradora.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (Taller.isSelected()) 
						jPanel3.setVisible(true);
					else
						jPanel3.setVisible(false);
				}
			});
		}
		return Aseguradora;
	}
	
	private JRadioButton getCarrier() {
		if(Carrier == null) {
			Carrier = new JRadioButton();
			Carrier.setText("Carrier");
			Carrier.setBounds(189, 75, 59, 23);
			if(dto!=null){
				if(dto.getTipo()=='C')
					Aseguradora.setSelected(true);
			}
			Carrier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (Taller.isSelected()) 
						jPanel3.setVisible(true);
					else
						jPanel3.setVisible(false);
				}
			});
		}
		return Carrier;
	}
	
	private JRadioButton getSeguridad() {
		if(Seguridad == null) {
			Seguridad = new JRadioButton();
			Seguridad.setText("Seguridad");
			Seguridad.setBounds(254, 75, 73, 23);
			if(dto!=null){
				if(dto.getTipo()=='S')
					Aseguradora.setSelected(true);
			}
			Seguridad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (Taller.isSelected()) 
						jPanel3.setVisible(true);
					else
						jPanel3.setVisible(false);
				}
			});
		}
		return Seguridad;
	}
	
	private JRadioButton getTaller() {
		if(Taller == null) {
			Taller = new JRadioButton();
			Taller.setText("Taller");
			Taller.setBounds(334, 75, 60, 23);
			if(dto!=null){
				if(dto.getTipo()=='T')
					Aseguradora.setSelected(true);
			}
			Taller.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (Taller.isSelected()) 
						jPanel3.setVisible(true);
					else
						jPanel3.setVisible(false);
				}
			});
		}
		return Taller;
	}

	
	
	private JRadioButton getOtro() {
		if(Otro == null) {
			Otro = new JRadioButton();
			Otro.setText("Otro");
			Otro.setBounds(401, 75, 62, 23);
			Otro.setSelected(true);
			Otro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (Taller.isSelected()) 
						jPanel3.setVisible(true);
					else
						jPanel3.setVisible(false);
				}
			});
		}
		return Otro;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getJComboBoxPaises() {
		if(jComboBoxPaises == null) {
			Vector<DTO_Pais> lista = Controlador.getInstancia().listarPaises();
			ComboBoxModel jComboBoxPaisesModel = 
					new DefaultComboBoxModel(lista);
			jComboBoxPaises = new JComboBox();
			jComboBoxPaises.setModel(jComboBoxPaisesModel);
			jComboBoxPaises.setBounds(94, 21, 117, 20);
			jComboBoxPaises.setSelectedItem("Argentina");
			if(dto!=null){
				for(int i=0;i<lista.size();i++){
					if(jComboBoxPaises.getItemAt(i).toString().contains(dto.getDireccion().getPais().getDescripcion()))
						jComboBoxPaises.setSelectedIndex(i);
				}
			}
		}
		return jComboBoxPaises;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getJComboBox1() {
		if(jComboBoxProvincias == null) {
			Vector<DTO_Provincia> lista = Controlador.getInstancia().armarComboProvincias("Argentina");
			ComboBoxModel jComboBoxProvinciasModel =  new DefaultComboBoxModel(lista);
			jComboBoxProvincias = new JComboBox();
			jComboBoxProvincias.setModel(jComboBoxProvinciasModel);
			jComboBoxProvincias.setBounds(327, 21, 117, 20);
			if(dto!=null){
				for(int i=0;i<lista.size();i++){
					if(jComboBoxProvincias.getItemAt(i).toString().contains(dto.getDireccion().getProvincia().getDescripcion()))
						jComboBoxProvincias.setSelectedIndex(i);
				}
			}
		}
		return jComboBoxProvincias;
	}
	
	public boolean validacion(){
		
		if (jTextFieldRazonSocial.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la razon social", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldRazonSocial.requestFocus();
			return false;
		} else if(jTextFieldCuit.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el CUIT.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldCuit.requestFocus();
			return false;
		} else if (!Aseguradora.isSelected() && !Carrier.isSelected()  && !Seguridad.isSelected()  && !Taller.isSelected() && !Otro.isSelected() ){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el tipo.", "Atencion", JOptionPane.WARNING_MESSAGE);
			Otro.requestFocus();
			return false;
		} else if(jComboBoxPaises.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el pais.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jComboBoxPaises.requestFocus();
			return false;
		} else if(jComboBoxProvincias.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la provincia.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jComboBoxProvincias.requestFocus();
			return false;
			
		} else if(jTextFieldLocalidad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la localidad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldLocalidad.requestFocus();
			return false;
			
		} else if(jTextFieldDireccion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la direccion.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldDireccion.requestFocus();
			return false;
			
		} else if(jTextFieldCodigoPostal.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el codigo postal.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldCodigoPostal.requestFocus();
			return false;
			
		} else if(jTextFieldTelefono.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el telefono.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldTelefono.requestFocus();
			return false;
			
		} else if(jTextFieldEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el email.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldEmail.requestFocus();
			return false;
		}
		return true;

	}
	
	
	
	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(BorderFactory.createTitledBorder("Taller"));
			jPanel3.setBounds(10, 412, 464, 91);
			jPanel3.setLayout(null);
			getButtonGroup1();
			jPanel3.add(getJLabel17());
			jPanel3.add(getJRadioButtonSi());
			jPanel3.add(getJRadioButtonNo());
			jPanel3.setVisible(false);
			
		//	jPanel3.add(getJRadioButton1());
		}
		return jPanel3;
	}

	
	private JLabel getJLabel17() {
		if(jLabel17 == null) {
			jLabel17 = new JLabel();
			jLabel17.setText("Oficial");
			jLabel17.setFont(new java.awt.Font("Verdana",0,11));
			jLabel17.setLayout(null);
			jLabel17.setBounds(6, 24, 39, 14);
		}
		return jLabel17;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
			buttonGroup1.add(getJRadioButtonSi());
			buttonGroup1.add(getJRadioButtonNo());
		}
		return buttonGroup1;
	}
	
	private JRadioButton getJRadioButtonSi() {
		if(jRadioButtonSi == null) {
			jRadioButtonSi = new JRadioButton();
			jRadioButtonSi.setText("Si");
			jRadioButtonSi.setBounds(90, 23, 53, 19);
		}
		return jRadioButtonSi;
	}
	
	private JRadioButton getJRadioButtonNo() {
		if(jRadioButtonNo == null) {
			jRadioButtonNo = new JRadioButton();
			jRadioButtonNo.setText("No");
			jRadioButtonNo.setBounds(152, 21, 53, 22);
			jRadioButtonNo.setSelected(true);
		}
		return jRadioButtonNo;
	}

}
