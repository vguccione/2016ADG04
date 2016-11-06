package com.ADG04.Vista.Vehiculos;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class BusquedaVehiculo extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField patente;
	
	private JButton btnBuscar;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public BusquedaVehiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 204);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		
		JLabel titulo = new JLabel("Vehiculo");
		titulo.setBounds(10, 11, 300, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione la Patente a buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("Patente");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DTO_Vehiculo veh = Controlador.getInstancia().getVehiculoByPatente(patente.getText());
				if(veh!=null){
					AltaVehiculo inst2 = new AltaVehiculo(veh);
					inst2.setLocationRelativeTo(null);
					inst2.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnBuscar.setBounds(368, 26, 86, 23);
		panel.add(btnBuscar);
		
		patente = new JFormattedTextField();
		patente.setBounds(115, 27, 243, 20);
		patente.setText("");
		panel.add(patente);
		
		
		
	}
}
