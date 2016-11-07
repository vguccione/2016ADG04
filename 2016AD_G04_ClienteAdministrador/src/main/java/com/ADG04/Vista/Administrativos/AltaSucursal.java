package com.ADG04.Vista.Administrativos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Provincia;
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
public class AltaSucursal extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JLabel jLabelGerente;
	private JButton jButton3;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel2;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBoxProvincias;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JButton jButtonCancelar;
	private JTextField jTextFieldTelefono;
	private JTextField jTextFieldLocalidad;
	private JLabel jLabel5;
	private JFormattedTextField jFormattedTextFieldIdGerente;
	private JLabel jLabel6;
	private JTextField jTextFieldCodigoPostal;
	private JTextField jTextFieldDireccion;
	private JTextField jTextFieldDescripcion;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabelDesc;
	private JLabel jLabel1;
	private JComboBox jComboBoxGerente;
	DTO_Sucursal dto;

	
	public AltaSucursal(DTO_Sucursal DTO) {
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
					if(dto==null)
						jLabelTitulo.setText("Alta Sucursal");
					else
						jLabelTitulo.setText("Modificar Sucursal");
					jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
					jLabelTitulo.setBounds(10, 11, 372, 26);
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jPanel, 0, 424, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel, 0, 502, Short.MAX_VALUE));
			pack();
			this.setSize(504, 493);
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

	
	

	
	private JLabel getjLabelDesc() {
		if(jLabelDesc == null) {
			jLabelDesc = new JLabel();
			jLabelDesc.setText("Descripcion");
			jLabelDesc.setFont(new java.awt.Font("Verdana",0,11));
			jLabelDesc.setLayout(null);
			jLabelDesc.setBounds(6, 27, 73, 15);
		}
		return jLabelDesc;
	}

	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Localidad");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(6, 109, 79, 14);
		}
		return jLabel3;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Domicilio");
			jLabel4.setFont(new java.awt.Font("Verdana",0,11));
			jLabel4.setLayout(null);
			jLabel4.setBounds(6, 53, 53, 15);
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Codigo Postal");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(6, 137, 80, 14);
		}
		return jLabel5;
	}
	
	

	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Provincia");
			jLabel7.setFont(new java.awt.Font("Verdana",0,11));
			jLabel7.setLayout(null);
			jLabel7.setBounds(6, 80, 58, 15);
		}
		return jLabel7;
	}

	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("Telefono");
			jLabel10.setFont(new java.awt.Font("Verdana",0,11));
			jLabel10.setLayout(null);
			jLabel10.setBounds(262, 135, 49, 19);
		}
		return jLabel10;
	}

	private JLabel getJLabelGerente() {
		if(jLabelGerente == null) {
			jLabelGerente = new JLabel();
			jLabelGerente.setText("Gerente");
			jLabelGerente.setFont(new java.awt.Font("Verdana",0,11));
			jLabelGerente.setLayout(null);
			jLabelGerente.setBounds(6, 157, 80, 14);
		}
		return jLabelGerente;
	}
	
	private JComboBox getJComboBoxGerente() {
		if(jComboBoxGerente == null) {
			List<DTO_Usuario> lista = Controlador.getInstancia().listarUsuarios();
			Vector v =new Vector();
			int i=0;
			for(DTO_Usuario u:lista){
				v.add(i,u.getDni());
				i++;
			}
			ComboBoxModel jComboBoxGerenteModel = new DefaultComboBoxModel(v);
			jComboBoxGerente = new JComboBox();
			jComboBoxGerente.setModel(jComboBoxGerenteModel);
			jComboBoxGerente.setBounds(94, 157, 154, 20);
			if(dto!=null){
				int j=0;
				for(DTO_Usuario u:lista){
					if(u.getId()==dto.getId()){
						jComboBoxGerente.setSelectedIndex(j);
						j++;
					}
				}
			}
		}
		return jComboBoxGerente;
	}
	
	private JTextField getJTextField1() {
		if(jTextFieldDescripcion == null) {
			jTextFieldDescripcion = new JTextField();
			jTextFieldDescripcion.setBounds(94, 25, 354, 20);
			if(dto!=null)
				jTextFieldDescripcion.setText(dto.getDescripcion());
		}
		return jTextFieldDescripcion;
	}

	private JTextField getJTextField4() {
		if(jTextFieldDireccion == null) {
			jTextFieldDireccion = new JTextField();
			jTextFieldDireccion.setBounds(94, 53, 354, 18);
			if(dto!=null)
				jTextFieldDireccion.setText(dto.getDireccion().getCalle());
		}
		return jTextFieldDireccion;
	}
	
	private JTextField getJTextField5() {
		if(jTextFieldCodigoPostal == null) {
			jTextFieldCodigoPostal = new JTextField();
			jTextFieldCodigoPostal.setBounds(96, 135, 120, 18);
		}
		if(dto!=null)
			jTextFieldCodigoPostal.setText(String.valueOf(dto.getDireccion().getCodigoPostal()));
		return jTextFieldCodigoPostal;
	}
	
	private JTextField getJTextField6() {
		if(jTextFieldLocalidad == null) {
			jTextFieldLocalidad = new JTextField();
			jTextFieldLocalidad.setBounds(94, 107, 354, 20);
			if(dto!=null)
				jTextFieldLocalidad.setText(dto.getDireccion().getLocalidad());
		}
		return jTextFieldLocalidad;
	}

	private JTextField getJTextField10() {
		if(jTextFieldTelefono == null) {
			jTextFieldTelefono = new JTextField();
			jTextFieldTelefono.setBounds(331, 135, 117, 18);
		}
		if(dto!=null)
			jTextFieldTelefono.setText(dto.getTelefono());
	
		return jTextFieldTelefono;
	}

	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(400, 420, 99, 20);
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
			jButtonAceptar.setBounds(280, 420, 99, 20);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						try{
						  if(dto==null){
							Controlador.getInstancia().altaSucursal(jTextFieldDescripcion.getText(), jTextFieldDireccion.getText(), jComboBoxProvincias.getSelectedItem().toString(), jTextFieldLocalidad.getText(), jTextFieldCodigoPostal.getText(), jTextFieldTelefono.getText(), jComboBoxGerente.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null,"Se ha dado de alta la sucursal:" + jTextFieldDescripcion.getText(), "Alta sucursal realizada", JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								Controlador.getInstancia().modificarSucursal(dto.getId(),jTextFieldDescripcion.getText(), jTextFieldDireccion.getText(), jComboBoxProvincias.getSelectedItem().toString(), jTextFieldLocalidad.getText(), jTextFieldCodigoPostal.getText(), jTextFieldTelefono.getText(), jComboBoxGerente.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null,"Se ha modificado la sucursal:" + jTextFieldDescripcion.getText(), "Modificacion sucursal realizada", JOptionPane.INFORMATION_MESSAGE);
							}
						setVisible(false);
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
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
			jPanel1.setBounds(10, 48, 464, 203);
			jPanel1.add(getjLabelDesc());
			jPanel1.add(getJTextField1());
			jPanel1.add(getJLabel3());
			jPanel1.add(getJLabel7());
			jPanel1.add(getJTextField4());
			jPanel1.add(getJLabel4());
			jPanel1.add(getJTextField6());
			jPanel1.add(getJLabel5());
			jPanel1.add(getJLabel10());
			jPanel1.add(getJComboBox1());
			jPanel1.add(getJTextField10());
			jPanel1.add(getJTextField5());
			jPanel1.add(getJLabelGerente());
			jPanel1.add(getJComboBoxGerente());

		}
		return jPanel1;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getJComboBox1() {
		Vector<DTO_Provincia> lista = Controlador.getInstancia().armarComboProvincias("Argentina");
		if(jComboBoxProvincias == null) {
			ComboBoxModel jComboBoxProvinciasModel = 
					new DefaultComboBoxModel(lista);
			jComboBoxProvincias = new JComboBox();
			jComboBoxProvincias.setModel(jComboBoxProvinciasModel);
			jComboBoxProvincias.setBounds(94, 79, 354, 20);
		}
		if(dto!=null){
			for(int i=0;i<lista.size();i++){
				if(jComboBoxProvincias.getItemAt(i).toString().contains(dto.getDireccion().getProvincia().getDescripcion()))
					jComboBoxProvincias.setSelectedIndex(i);
			}
		}
		return jComboBoxProvincias;
	}
	
	public boolean validacion(){
		
		if (jTextFieldDescripcion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la descripcion", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldDescripcion.requestFocus();
			return false;
		} else if(jTextFieldDireccion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el domicilio.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldDireccion.requestFocus();
			return false;		
		} else if(jComboBoxProvincias.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la provincia.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jComboBoxProvincias.requestFocus();
			return false;
		} else if(jTextFieldLocalidad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la localidad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldLocalidad.requestFocus();
			return false;
		}   else if(jTextFieldCodigoPostal.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el codigo postal.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldCodigoPostal.requestFocus();
			return false;
		}  else if(jTextFieldTelefono.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el telefono.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldTelefono.requestFocus();
			return false;
			
		} else if(jLabelGerente.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el Gerente.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdGerente.requestFocus();
			return false;
		} 
		return true;
	}

}
	

