package com.ADG04.Vista.Clientes;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;

public class AltaProductoCliente {

	private JFrame frame;
	private JFormattedTextField id;
	
	private JLabel cliente;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JLabel lblDescripcin;
	private JLabel lblCodigo;
	private JTextField descripcion;
	private JTextField codigo;
	private JLabel lblDiasEntrega;
	private JLabel lblHorario;
	private JTextField categoria;
	private JButton button;
	private JButton button_1;
	DTO_ClienteEmpresa clienteDTO;
	@SuppressWarnings("rawtypes")
	private JComboBox unidad;

	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public AltaProductoCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 421);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		
		JLabel titulo = new JLabel("Alta Producto Cliente");
		titulo.setBounds(10, 11, 300, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clienteDTO = Controlador.getInstancia().getEmpresaById((Integer) id.getValue());
				if (clienteDTO != null){
					cliente.setText(clienteDTO.getRazonSocial());
					btnBuscar.setEnabled(false);
					id.setEnabled(false);
					panel_1.setVisible(true);
					button_1.setVisible(true);
					button.setVisible(true);
				} else {
					//No encontro el proveedor entonces notifico que no lo encontro
					JOptionPane.showMessageDialog(null,"No se ha encontrado el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
					id.setText("");
				}
				
				
				
			}
		});
		btnBuscar.setBounds(149, 26, 86, 23);
		panel.add(btnBuscar);
		
		id = new JFormattedTextField();
		id.setBounds(77, 27, 59, 20);
		id.setValue(new Integer(0));
		panel.add(id);
		
		cliente = new JLabel("");
		cliente.setBounds(239, 30, 215, 14);
		panel.add(cliente);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("General"));
		panel_1.setBounds(10, 122, 464, 145);
		panel_1.setVisible(false);
		frame.getContentPane().add(panel_1);
		
		lblDescripcin = new JLabel();
		lblDescripcin.setText("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDescripcin.setBounds(6, 52, 78, 15);
		panel_1.add(lblDescripcin);
		
		lblCodigo = new JLabel();
		lblCodigo.setText("Codigo");
		lblCodigo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCodigo.setBounds(6, 26, 53, 15);
		panel_1.add(lblCodigo);
		
		descripcion = new JTextField();
		descripcion.setBounds(94, 51, 350, 18);
		panel_1.add(descripcion);
		
		codigo = new JTextField();
		codigo.setBounds(94, 24, 350, 20);
		panel_1.add(codigo);
		
		lblDiasEntrega = new JLabel();
		lblDiasEntrega.setText("Categor\u00EDa");
		lblDiasEntrega.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDiasEntrega.setBounds(6, 78, 78, 15);
		panel_1.add(lblDiasEntrega);
		
		lblHorario = new JLabel();
		lblHorario.setText("Unidad");
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblHorario.setBounds(6, 104, 49, 15);
		panel_1.add(lblHorario);
		
		categoria = new JTextField();
		categoria.setBounds(94, 76, 350, 20);
		panel_1.add(categoria);
		
		unidad = new JComboBox();
		unidad.setModel(new DefaultComboBoxModel(new String[] {"Pieza", "Tonelada", "Kg", "m", "m2", "m3"}));
		unidad.setBounds(94, 102, 106, 20);
		panel_1.add(unidad);
		
		
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		button.setText("Cancelar");
		button.setBounds(399, 278, 75, 23);
		button.setVisible(false);
		frame.getContentPane().add(button);
		
		button_1 = new JButton();
		button_1.setText("Aceptar");
		button_1.setBounds(318, 278, 71, 23);
		button_1.setVisible(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (validacion()) {
					boolean flag = Controlador.getInstancia().altaProductoCliente(codigo.getText(), descripcion.getText(), categoria.getText(), unidad.getSelectedItem().toString(), clienteDTO.getId());
						if(flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta el producto.", "Alta producto realizada", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta el productor.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
				}
			}
		});
		frame.getContentPane().add(button_1);
	}
public boolean validacion(){
		
		if(codigo.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el codigo.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			descripcion.requestFocus();
			return false;
			
		} else if(descripcion.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la descripcion.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			categoria.requestFocus();
			return false;
				
		} else if(categoria.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la categoria.", "Atenci�n", JOptionPane.WARNING_MESSAGE);
			categoria.requestFocus();
			return false;
			
		} 
		
		return true;

}
}
