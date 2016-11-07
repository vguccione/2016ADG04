package com.ADG04.Vista.Clientes;

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
import com.ADG04.Vista.Administrativos.AltaSucursal;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BusquedaCliente extends javax.swing.JFrame{

	private JFrame frame;
	private JFormattedTextField id;
	
	private DTO_ClienteParticular clienteDTO;
	private DTO_ClienteEmpresa clienteDTOE;
	private JLabel cliente;
	private JButton btnBuscar;
	private JButton button;
	private JButton button_1;
	private char tipo;


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public BusquedaCliente() {
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
		
		
		JLabel titulo = new JLabel("Busqueda Cliente");
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
				
				clienteDTO = Controlador.getInstancia().getClienteById((Integer) id.getValue());
				tipo = 'P';
				if(clienteDTO==null){
					clienteDTOE=Controlador.getInstancia().getEmpresaById((Integer) id.getValue());
					tipo = 'E';
				}
				if (clienteDTO != null){
					cliente.setText(clienteDTO.getNombre() + " " + clienteDTO.getApellido());
					btnBuscar.setEnabled(false);
					id.setEnabled(false);
					button_1.setVisible(true);
					button.setVisible(true);
				} else if (clienteDTOE!=null) {
					cliente.setText(clienteDTOE.getRazonSocial());
					btnBuscar.setEnabled(false);
					id.setEnabled(false);
					button_1.setVisible(true);
					button.setVisible(true);
				}
				else{
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
				if(clienteDTO!=null || clienteDTOE!=null){
					if(tipo=='P'){
						AltaClienteParticular inst2 = new AltaClienteParticular(clienteDTO);
						//inst2.setLocationRelativeTo(null);
						inst2.setVisible(true);
					}
					else{
						AltaClienteEmpresa inst2 = new AltaClienteEmpresa(clienteDTOE);
						//inst2.setLocationRelativeTo(null);
						inst2.setVisible(true);
					}
					
					
					setVisible(false);
				}
			}
		});
		frame.getContentPane().add(button_1);
	}
}
