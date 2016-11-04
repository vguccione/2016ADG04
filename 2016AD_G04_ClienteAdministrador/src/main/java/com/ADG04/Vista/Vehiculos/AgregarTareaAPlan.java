package com.ADG04.Vista.Vehiculos;


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
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;

public class AgregarTareaAPlan {

	private JFrame frame;
	private JFormattedTextField id;
	
	private DTO_PlanMantenimiento clienteDTO;
	private JLabel cliente;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JLabel lblTipo;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField tarea;
	private JButton button;
	private JButton button_1;
	private JFormattedTextField cantidad;
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public AgregarTareaAPlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 329);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		
		JLabel titulo = new JLabel("Agregar Tarea Mantenimiento");
		titulo.setBounds(10, 11, 417, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el Plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				clienteDTO = Controlador.getInstancia().getPlanMantenimiento((Integer) id.getValue());
				if (clienteDTO != null){
					cliente.setText(clienteDTO.getDescripcion());
					btnBuscar.setEnabled(false);
					id.setEnabled(false);
					panel_1.setVisible(true);
					button_1.setVisible(true);
					button.setVisible(true);
				} else {
					//No encontro el proveedor entonces notifico que no lo encontro
					JOptionPane.showMessageDialog(null,"No se ha encontrado el plan.", "Error", JOptionPane.ERROR_MESSAGE);
					id.setText("");
				}
				
				
				
			}
		});
		btnBuscar.setBounds(149, 26, 86, 23);
		panel.add(btnBuscar);
		
		id = new JFormattedTextField();
		id.setBounds(87, 27, 59, 20);
		id.setValue(new Integer(0));
		panel.add(id);
		
		cliente = new JLabel("");
		cliente.setBounds(279, 30, 215, 14);
		panel.add(cliente);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Contacto"));
		panel_1.setBounds(10, 122, 464, 123);
		panel_1.setVisible(false);
		frame.getContentPane().add(panel_1);
		
		lblTipo = new JLabel();
		lblTipo.setText("Cantidad");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTipo.setBounds(6, 84, 78, 15);
		panel_1.add(lblTipo);
		
		label_1 = new JLabel();
		label_1.setText("Tarea");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_1.setBounds(6, 54, 53, 15);
		panel_1.add(label_1);
		
		label_2 = new JLabel();
		label_2.setText("Tipo");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_2.setBounds(7, 23, 52, 15);
		panel_1.add(label_2);
		
		tarea = new JTextField();
		tarea.setBounds(94, 52, 350, 20);
		panel_1.add(tarea);
		
		cantidad = new JFormattedTextField();
		cantidad.setBounds(94, 82, 109, 20);
		cantidad.setValue(0f);
		panel_1.add(cantidad);
		
		final
		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"Kilometros", "Tiempo"}));
		tipo.setBounds(94, 21, 109, 20);
		panel_1.add(tipo);
		
	
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		button.setText("Cancelar");
		button.setBounds(399, 256, 75, 23);
		button.setVisible(false);
		frame.getContentPane().add(button);
		
		button_1 = new JButton();
		button_1.setText("Aceptar");
		button_1.setBounds(318, 256, 71, 23);
		button_1.setVisible(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = false;
				if (validacion()) {
					if (tipo.getSelectedItem().toString().equals("Kilometros")){
						flag = Controlador.getInstancia().altaTareaMantenimientoKilometro(clienteDTO.getId(), tarea.getText(), (Float) cantidad.getValue());
					} else {
						flag = Controlador.getInstancia().altaTareaMantenimientoTiempo(clienteDTO.getId(),tarea.getText(), (Float)cantidad.getValue());
					}
						if(flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta la tarea:", "Alta tarea de mantenimiento", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta la tarea.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
				}
			}
		});
		frame.getContentPane().add(button_1);
	}
public boolean validacion(){
		
		if(tarea.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la tarea.", "Atencion", JOptionPane.WARNING_MESSAGE);
			tarea.requestFocus();
			return false;
			
		} else if(cantidad.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad.", "Atencion", JOptionPane.WARNING_MESSAGE);
			tarea.requestFocus();
			return false;
			
		} 
		
		
		return true;

}
}
