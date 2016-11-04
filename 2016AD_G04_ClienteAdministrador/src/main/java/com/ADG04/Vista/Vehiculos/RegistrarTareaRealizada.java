package com.ADG04.Vista.Vehiculos;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class RegistrarTareaRealizada {

	private JFrame frame;
	
	private DTO_Vehiculo vehiculoDTO;
	private DTO_PlanMantenimiento planDTO;
	private DTO_Proveedor proveedorDTO;
	private JLabel cliente;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JLabel lblProveedor_1;
	private JLabel label_1;
	private JLabel lblPlan;
	private JTextField plan;
	@SuppressWarnings("rawtypes")
	private JComboBox tarea;
	private JButton button;
	private JButton button_1;
	private JTextField patente;
	private JFormattedTextField idProveedor;
	private List<DTO_TareaMantenimiento> tareas;
	
	private JButton button_2;

	private JLabel lblProveedor;

	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public RegistrarTareaRealizada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 325);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		JLabel titulo = new JLabel("Registrar Tarea de Mantenimiento");
		titulo.setBounds(10, 11, 419, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el vehiculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("Patente");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				vehiculoDTO = Controlador.getInstancia().buscarVehiculo(patente.getText());
				if (vehiculoDTO != null){
					cliente.setText(vehiculoDTO.getTipo() + " " + vehiculoDTO.getMarca());

					planDTO = Controlador.getInstancia().getPlanMantenimiento(vehiculoDTO.getId());
					if(planDTO != null){
						plan.setEnabled(false);
						plan.setText(planDTO.getDescripcion());
						
						tareas = Controlador.getInstancia().listarTareasMantenimiento(planDTO.getId());
						
						if(tareas != null){
							int i = 0;
							String lista[] = new String[tareas.size()];
							for(DTO_TareaMantenimiento t:tareas ){
								lista[i] = t.getTarea();
								i++;
							}
							ComboBoxModel jComboBoxTareasModel = 
									new DefaultComboBoxModel(
											lista);
							tarea.setModel(jComboBoxTareasModel);
						}
					}
					btnBuscar.setEnabled(false);
					patente.setEnabled(false);
					panel_1.setVisible(true);
					button_1.setVisible(true);
					button.setVisible(true);
				} else {
					//No encontro el proveedor entonces notifico que no lo encontro
					JOptionPane.showMessageDialog(null,"No se ha encontrado el vehiculo.", "Error", JOptionPane.ERROR_MESSAGE);
					patente.setText("");
				}
				
				
				
			}
		});
		btnBuscar.setBounds(160, 26, 100, 23);
		panel.add(btnBuscar);
		
		cliente = new JLabel("");
		cliente.setBounds(289, 30, 215, 14);
		panel.add(cliente);
		
		patente = new JTextField();
		patente.setBounds(93, 27, 57, 20);
		panel.add(patente);
		patente.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createTitledBorder("Tarea de Mantenimiento realizada"));
		panel_1.setBounds(10, 122, 464, 125);
		panel_1.setVisible(false);
		frame.getContentPane().add(panel_1);
		
		lblProveedor_1 = new JLabel();
		lblProveedor_1.setText("Proveedor");
		lblProveedor_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblProveedor_1.setBounds(6, 84, 100, 15);
		panel_1.add(lblProveedor_1);
		
		label_1 = new JLabel();
		label_1.setText("Tarea");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_1.setBounds(6, 54, 100, 15);
		panel_1.add(label_1);
		
		lblPlan = new JLabel();
		lblPlan.setText("Plan");
		lblPlan.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPlan.setBounds(7, 23, 100, 15);
		panel_1.add(lblPlan);
		
		plan = new JTextField();
		plan.setBounds(94, 21, 350, 20);
		panel_1.add(plan);
		
		
		tarea = new JComboBox();
		
		tarea.setBounds(94, 52, 350, 20);
		panel_1.add(tarea);
		
		button_2 = new JButton("Buscar");
		button_2.setBounds(161, 81, 100, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				proveedorDTO = Controlador.getInstancia().getProveedor((Integer) idProveedor.getValue());
				if(proveedorDTO != null){
					lblProveedor.setText(proveedorDTO.getRazonSocial());
					button_2.setEnabled(false);
					idProveedor.setEnabled(false);
				}
			}
		});
		panel_1.add(button_2);
		
		lblProveedor = new JLabel("");
		lblProveedor.setBounds(279, 85, 215, 14);
		panel_1.add(lblProveedor);
		
		idProveedor = new JFormattedTextField();
		idProveedor.setBounds(94, 82, 57, 20);
		idProveedor.setValue(new Integer(0));
		panel_1.add(idProveedor);
		
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		button.setText("Cancelar");
		button.setBounds(399, 258, 100, 23);
		button.setVisible(false);
		frame.getContentPane().add(button);
		
		button_1 = new JButton();
		button_1.setText("Aceptar");
		button_1.setBounds(288, 258, 100, 23);
		button_1.setVisible(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int pos = tarea.getSelectedIndex();
				boolean flag=false;
				if(pos!=0){
					DTO_TareaMantenimiento t = tareas.get(pos);
					
					flag = Controlador.getInstancia().altaTareaMantenimientoRealizada(t.getId(), vehiculoDTO.getId(), new Date(), vehiculoDTO.getKmsRecorridos(), proveedorDTO.getId());
				}
				if(flag){
					JOptionPane.showMessageDialog(null,"Se ha dado de alta tarea mantenimiento realizada", "Alta tarea mantenimiento realizada", JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null,"No se ha podido dar de alta tarea mantenimiento realizada.", "Error", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		frame.getContentPane().add(button_1);
	}
}
