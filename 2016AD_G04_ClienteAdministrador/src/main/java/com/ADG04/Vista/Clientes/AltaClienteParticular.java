package com.ADG04.Vista.Clientes;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.ADG04.Controller.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaClienteParticular extends javax.swing.JFrame{

	private JFrame frmAplicacionesDistribuidas;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtLocalidad;
	private JTextField txtDireccion;
	private JTextField txtPostal;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDni;
	private JFormattedTextField txtLimiteCredito;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxProvincia;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxFormaPago;

	public AltaClienteParticular() {
		super();
		initialize();
	}

	public JFrame getFrmAplicacionesDistribuidas() {
		return frmAplicacionesDistribuidas;
	}

	public void setFrmAplicacionesDistribuidas(JFrame frmAplicacionesDistribuidas) {
		this.frmAplicacionesDistribuidas = frmAplicacionesDistribuidas;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmAplicacionesDistribuidas = new JFrame();
		frmAplicacionesDistribuidas.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		frmAplicacionesDistribuidas.setBounds(100, 100, 450, 469);
		frmAplicacionesDistribuidas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAplicacionesDistribuidas.getContentPane().setLayout(null);
		
		JPanel General = new JPanel();
		General.setBounds(10, 42, 414, 89);
		General.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmAplicacionesDistribuidas.getContentPane().add(General);
		General.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 30, 73, 14);
		General.add(lblNombre);
		
		JLabel lblApellido = new JLabel("CUIT");
		lblApellido.setBounds(10, 55, 46, 14);
		General.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 27, 324, 20);
		General.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(80, 55, 324, 20);
		General.add(txtApellido);
		txtApellido.setColumns(10);
		
		JPanel Contacto = new JPanel();
		Contacto.setBounds(10, 132, 414, 153);
		Contacto.setBorder(new TitledBorder(null, "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmAplicacionesDistribuidas.getContentPane().add(Contacto);
		Contacto.setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 23, 46, 14);
		Contacto.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 48, 46, 14);
		Contacto.add(lblLocalidad);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 73, 46, 14);
		Contacto.add(lblDireccion);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal");
		lblCdigoPostal.setBounds(10, 98, 71, 14);
		Contacto.add(lblCdigoPostal);
		
		JLabel lblTlefono = new JLabel("T\u00E9lefono");
		lblTlefono.setBounds(225, 98, 46, 14);
		Contacto.add(lblTlefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 123, 46, 14);
		Contacto.add(lblEmail);
		
		ComboBoxModel ProvinciasModel = new DefaultComboBoxModel(Controlador.getInstancia().armarComboProvincias("Argentina"));
		cbxProvincia = new JComboBox();
		cbxProvincia.setBounds(83, 20, 117, 20);
		cbxProvincia.setModel(ProvinciasModel);
		Contacto.add(cbxProvincia);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(83, 45, 321, 20);
		Contacto.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(83, 70, 321, 20);
		Contacto.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtPostal = new JTextField();
		txtPostal.setBounds(83, 95, 117, 20);
		Contacto.add(txtPostal);
		txtPostal.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(273, 95, 131, 20);
		Contacto.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(83, 120, 321, 20);
		Contacto.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 130, 46, 14);
		General.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(83, 130, 321, 20);
		Contacto.add(txtDni);
		txtDni.setColumns(10);
		
		
		JLabel titulo = new JLabel("Alta Cliente");
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		titulo.setBounds(10, 11, 182, 20);
		frmAplicacionesDistribuidas.getContentPane().add(titulo);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAplicacionesDistribuidas.setVisible(false);
			}
		});
		cancelar.setBounds(335, 389, 89, 23);
		frmAplicacionesDistribuidas.getContentPane().add(cancelar);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setBounds(240, 389, 89, 23);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validacion()) {
					try{
						Controlador.getInstancia().altaClienteParticular(txtNombre.getText(), 
																				txtApellido.getText(), 
																				true,
																				txtDireccion.getText(),
																				txtPostal.getText(),
																				txtLocalidad.getText(),
																				cbxProvincia.getSelectedItem().toString(),
																				"Argentina",
																				txtEmail.getText(),
																				txtTelefono.getText(),
																				txtDni.getText());
					
						JOptionPane.showMessageDialog(null,"Se ha dado de alta al proveedor:" + txtNombre.getText(), "Alta proveedor realizada", JOptionPane.INFORMATION_MESSAGE);
						frmAplicacionesDistribuidas.setVisible(false);
						} 
					catch(Exception e)
					{
						e.printStackTrace();
						JOptionPane.showMessageDialog(null,"No se ha podido dar de alta al proveedor.", "Error", JOptionPane.ERROR_MESSAGE);	
					}
				}
			}
		});

		frmAplicacionesDistribuidas.getContentPane().add(aceptar);
		
	}
	
public boolean validacion(){
		
		if (txtNombre.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el nombre", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtNombre.requestFocus();
			return false;
		} else if(txtApellido.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el apellido.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtApellido.requestFocus();
			return false;
		} else if(cbxProvincia.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la provincia.", "Atencion", JOptionPane.WARNING_MESSAGE);
			cbxProvincia.requestFocus();
			return false;
			
		} else if(txtLocalidad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la localidad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtLocalidad.requestFocus();
			return false;
			
		} else if(txtDireccion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la direccion.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtDireccion.requestFocus();
			return false;
			
		} else if(txtPostal.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el codigo postal.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtPostal.requestFocus();
			return false;
			
		} else if(txtTelefono.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el telefono.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtTelefono.requestFocus();
			return false;
			
		} else if(txtEmail.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el email.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtEmail.requestFocus();
			return false;
		} else if(txtLimiteCredito.getValue().toString() == ""){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el limite de crediito.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtEmail.requestFocus();
			return false;
		} else if(cbxFormaPago.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione la forma de pago.", "Atencion", JOptionPane.WARNING_MESSAGE);
			txtEmail.requestFocus();
			return false;
		}
		
		return true;

	}
}
