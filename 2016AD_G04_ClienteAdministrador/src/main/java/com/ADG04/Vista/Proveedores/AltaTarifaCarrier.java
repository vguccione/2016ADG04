package com.ADG04.Vista.Proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;


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
public class AltaTarifaCarrier extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTextField jTextFieldPrioridad;
	private JFormattedTextField jFormattedTextFieldKMExtra;
	private JLabel jLabel3;
	private JFormattedTextField jFormattedTextFieldPrecio;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField jTextFieldCiudad;
	private JLabel jLabelCiudad;
	private JLabel jLabelPais;
	private JComboBox jComboBoxPaises;
	private DTO_Sucursal sucursal;
	private JLabel jLabelRazonSocial;

	private DTO_Proveedor proveedor;
	private DTO_TarifasCarrier dto;
	
	public AltaTarifaCarrier(DTO_TarifasCarrier DTO) {
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
					if(dto==null)
						jLabelTitulo.setText("Alta Tarifas Carrier");
					else
						jLabelTitulo.setText("Modificar Tarifas Carrier");
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
	
	
	private JLabel getJLabelPais() {
		if(jLabelPais == null) {
			jLabelPais = new JLabel();
			jLabelPais.setText("Pais");
			jLabelPais.setFont(new java.awt.Font("Verdana",0,11));
			jLabelPais.setLayout(null);
			jLabelPais.setBounds(6, 73, 56, 16);
		}
		return jLabelPais;
	}

	private JComboBox getJComboBoxPaises() {
		if(jComboBoxPaises == null) {
			Vector<DTO_Pais> lista = Controlador.getInstancia().listarPaises();
			ComboBoxModel jComboBoxPaisesModel = 
					new DefaultComboBoxModel(lista);
			jComboBoxPaises = new JComboBox();
			jComboBoxPaises.setModel(jComboBoxPaisesModel);
			jComboBoxPaises.setBounds(94, 70, 320, 20);
			if(dto!=null){
				for(int i=0;i<lista.size();i++){
					if(jComboBoxPaises.getItemAt(i).toString().contains(dto.getPais().getDescripcion()))
						jComboBoxPaises.setSelectedIndex(i);
				}
			}
		}
		return jComboBoxPaises;
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
			jLabel4.setBounds(6, 100, 84, 13);
			jLabel4.setVisible(true);
		}
		return jLabel4;
	}

	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Comentarios");
			jLabel8.setFont(new java.awt.Font("Verdana",0,11));
			jLabel8.setLayout(null);
			jLabel8.setBounds(4, 170, 76, 14);
			jLabel8.setVisible(true);
		}
		return jLabel8;
	}

	private JTextField getJTextField2() {
		if(jTextFieldCuit == null) {
			jTextFieldCuit = new JTextField();
			jTextFieldCuit.setBounds(92, 27, 80, 20);
			if(dto!=null)
				jTextFieldCuit.setText(Controlador.getInstancia().getProveedor(dto.getIdProveedor()).getCuit());
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
						DTO_Pais pais = Controlador.getInstancia().getPaisByNombre(jComboBoxPaises.getSelectedItem().toString());
						DTO_Sucursal sucursal = Controlador.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal.getValue());
						
						if(dto==null){
							boolean flag = Controlador.getInstancia().altaTarifaCarrier(proveedor.getId(),jTextFieldCiudad.getText(), jTextAreaComentarios.getText(), jTextFieldPrioridad.getText(), (Float)jFormattedTextFieldKMExtra.getValue(), (Float)jFormattedTextFieldPrecio.getValue(),  pais, sucursal);
								if(flag){
									JOptionPane.showMessageDialog(null,"Se ha dado la tarifa del carrier del proveedor: " + proveedor.getRazonSocial(), "Alta tarifas carrier realizada", JOptionPane.INFORMATION_MESSAGE);
									setVisible(false);
								}	 
								else {
								JOptionPane.showMessageDialog(null,"No se ha podido dar de alta la tarifa de carrier.", "Error", JOptionPane.ERROR_MESSAGE);	
								}
						}
						else{
							boolean flag = Controlador.getInstancia().modificarTarifaCarrier(dto.getId(),proveedor.getId(),jTextFieldCiudad.getText(), jTextAreaComentarios.getText(), jTextFieldPrioridad.getText(), (Float)jFormattedTextFieldKMExtra.getValue(), (Float)jFormattedTextFieldPrecio.getValue(),  pais, sucursal);
							if(flag){
								JOptionPane.showMessageDialog(null,"Se ha modificado la tarifa del carrier del proveedor: " + proveedor.getRazonSocial(), "Modificacion tarifa carrier realizada", JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
							}	 
							else {
							JOptionPane.showMessageDialog(null,"No se ha podido modificar la tarifa de carrier.", "Error", JOptionPane.ERROR_MESSAGE);	
							}
						
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
			jPanel2.setBorder(BorderFactory.createTitledBorder("Ingrese datos de Tarifas Carrier"));
			jPanel2.setBounds(10, 117, 430, 229);
			jPanel2.setLayout(null);

			jPanel2.add(getJLabel4());
			jPanel2.add(getJLabel8());
			jPanel2.add(getJFormattedTextFieldMonto());
			jPanel2.add(getJLabel3());
			jPanel2.add(getJFormattedTextField1());
			jPanel2.add(getJLabel5());
			jPanel2.add(getJTextField1x());
			jPanel2.add(getJLabel7());
			jPanel2.add(getJFormattedTextFieldIdSucursal());
			jPanel2.add(getJButton1x());
			jPanel2.add(getJLabelSucursal());
			jPanel2.add(getJScrollPane1());
			jPanel2.add(getJTextFieldCiudad());
			jPanel2.add(getJLabelCiudad());
			jPanel2.add(getJLabelPais());
			jPanel2.add(getJComboBoxPaises());
			jPanel2.setVisible(true);
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
		
		if (jLabelRazonSocial.toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el proveedor", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldCuit.requestFocus();
			return false;
		} else if (jLabelSucursal.toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la sucursal de origen", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal.requestFocus();
			return false;
		} else if(jFormattedTextFieldPrecio.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldPrecio.requestFocus();
			return false;
		} else if(jFormattedTextFieldKMExtra.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio del km extra.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldKMExtra.requestFocus();
			return false;
		} else if(jTextFieldPrioridad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la prioridad", "Atencion", JOptionPane.WARNING_MESSAGE);
			jTextFieldPrioridad.requestFocus();
			return false;
		} 
		return true;

	}

	private JFormattedTextField getJFormattedTextFieldMonto() {
		if(jFormattedTextFieldPrecio == null) {
			jFormattedTextFieldPrecio = new JFormattedTextField(new Float(0));
			jFormattedTextFieldPrecio.setValue(new Float(0));
			jFormattedTextFieldPrecio.setBounds(94, 96, 319, 21);
			if(dto!=null)
				jFormattedTextFieldPrecio.setValue(dto.getTarifa());
			jFormattedTextFieldPrecio.setVisible(true);
		}
		return jFormattedTextFieldPrecio;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Km. Extra");
			jLabel3.setFont(new java.awt.Font("Verdana",0,11));
			jLabel3.setLayout(null);
			jLabel3.setBounds(4, 125, 81, 15);
			jLabel3.setVisible(true);
		}
		return jLabel3;
	}
	
	private JFormattedTextField getJFormattedTextField1() {
		if(jFormattedTextFieldKMExtra == null) {
			jFormattedTextFieldKMExtra = new JFormattedTextField();
			jFormattedTextFieldKMExtra.setValue(new Float(0));
			jFormattedTextFieldKMExtra.setBounds(94, 123, 319, 19);
			if(dto!=null)
				jFormattedTextFieldKMExtra.setValue(dto.getPrecioKMExtra());
			jFormattedTextFieldKMExtra.setVisible(true);
		}
		return jFormattedTextFieldKMExtra;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Prioridad");
			jLabel5.setFont(new java.awt.Font("Verdana",0,11));
			jLabel5.setLayout(null);
			jLabel5.setBounds(4, 148, 76, 14);
			jLabel5.setVisible(true);
		}
		return jLabel5;
	}
	
	private JLabel getJLabelCiudad(){
		if(jLabelCiudad == null) {
			jLabelCiudad = new JLabel();
			jLabelCiudad.setText("Ciudad");
			jLabelCiudad.setFont(new java.awt.Font("Verdana",0,11));
			jLabelCiudad.setLayout(null);
			jLabelCiudad.setBounds(6, 51, 75, 15);
			jLabelCiudad.setVisible(true);
		}
		return jLabelCiudad;
		
	}
	
	private JTextField getJTextField1x() {
		if(jTextFieldPrioridad == null) {
			jTextFieldPrioridad = new JTextField();
			jTextFieldPrioridad.setBounds(95, 148, 154, 19);
			if(dto!=null)
				jTextFieldPrioridad.setText(dto.getPrioridad());
			jTextFieldPrioridad.setVisible(true);
		}
		return jTextFieldPrioridad;
	}
	
	private JTextField getJTextFieldCiudad(){
		if(jTextFieldCiudad == null){
			jTextFieldCiudad = new JTextField();
			jTextFieldCiudad.setBounds(94, 46, 154, 19);
			if(dto!=null)
				jTextFieldCiudad.setText(dto.getCiudad());
			jTextFieldCiudad.setVisible(true);
		}
		return jTextFieldCiudad;
	}
	
	//setBounds(260, 46, 154, 19);
	
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
			if(dto!=null)
				jFormattedTextFieldIdSucursal.setValue(dto.getOrigen().getId());
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
					
					sucursal = Controlador.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal.getValue());
					if(sucursal != null){
						jFormattedTextFieldIdSucursal.setEnabled(false);
						jButton1.setEnabled(false);
						jLabelSucursal.setText(sucursal.getDescripcion());
						jFormattedTextFieldPrecio.setVisible(true);
						jFormattedTextFieldKMExtra.setVisible(true);
						jTextFieldPrioridad.setVisible(true);
						jScrollPane1.setVisible(true);
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
			jScrollPane1.setBounds(95, 170, 317, 57);
			jScrollPane1.setViewportView(getJTextArea1());
			jScrollPane1.setVisible(true);
		}
		return jScrollPane1;
	}
	
	private JTextArea getJTextArea1() {
		if(jTextAreaComentarios == null) {
			jTextAreaComentarios = new JTextArea();
			if(dto!=null)
				jTextAreaComentarios.setText(dto.getComentarios());
		}
		return jTextAreaComentarios;
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
