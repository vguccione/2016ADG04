package com.ADG04.Vista.Proveedores;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import com.ADG04.Controller.Controlador;
import com.ADG04.Vista.Vehiculos.AltaVehiculo;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BusquedaTarifasCarrier extends javax.swing.JFrame{

	private JFrame frame;
	private JFormattedTextField id;
	
	private DTO_TarifasCarrier DTO;
	private JLabel cliente;
	private JButton btnBuscar;
	private JButton button;
	private JButton button_1;


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public BusquedaTarifasCarrier() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 509, 197);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		JLabel titulo = new JLabel("Buscar Tarifas Carrier");
		titulo.setBounds(10, 11, 300, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione la Tarifa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DTO = Controlador.getInstancia().getTarifasCarrier(((Integer) id.getValue()));
				if (DTO != null){
					cliente.setText(String.valueOf(DTO.getId()));
					btnBuscar.setEnabled(false);
					id.setEnabled(false);
					button_1.setVisible(true);
					button.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"No se ha encontrado la tarifa carrier.", "Error", JOptionPane.ERROR_MESSAGE);
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

		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		button.setText("Cancelar");
		button.setBounds(399, 122, 75, 23);
		button.setVisible(false);
		frame.getContentPane().add(button);
		
		button_1 = new JButton();
		button_1.setText("Aceptar");
		button_1.setBounds(317, 122, 71, 23);
		button_1.setVisible(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(DTO!=null){
					AltaTarifaCarrier inst2 = new AltaTarifaCarrier(DTO);
					inst2.setLocationRelativeTo(null);
					inst2.setVisible(true);
					setVisible(false);
				}
			}
		});
		frame.getContentPane().add(button_1);
	}
}
