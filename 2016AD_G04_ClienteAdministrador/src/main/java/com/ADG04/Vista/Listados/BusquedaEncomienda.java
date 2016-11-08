package com.ADG04.Vista.Listados;


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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Encomienda.DTO_Encomienda;

public class BusquedaEncomienda extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFormattedTextField id;
	
	private DTO_Encomienda encoPart;
	private DTO_Encomienda encoEmp;
	private JButton btnBuscar;
	private JPanel General;
	private JLabel lblOrigen;
	private JLabel lblEstado;
	private JLabel lblTipo;
	private JLabel lblDiasEntrega;
	private JLabel lblDestino;
	private JLabel lblHorario;
	private JPanel Facturacion;
	private JLabel estadoEncomienda;
	private JLabel origenEncomienda;
	private JLabel volumenEncomienda;
	private JLabel tipoEncomienda;
	private JLabel pesoEncomienda;
	private JLabel refrigeradoEncomienda;
	private JLabel apilableEncomienda;
	private JLabel condicionesEncomienda;
	private JLabel indicacionesEncomienda;
	private JLabel facturado;
	private JLabel estadoFactura;
	private JLabel factura;

	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public BusquedaEncomienda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 504);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
		
		
		JLabel titulo = new JLabel("Encomienda");
		titulo.setBounds(10, 11, 300, 26);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		frame.getContentPane().add(titulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione la Encomienda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 48, 464, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 30, 73, 14);
		panel.add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encoPart = Controlador.getInstancia().getEncomiendaParticular((Integer) id.getValue());
				if(encoPart != null){
					estadoEncomienda.setText(encoPart.getEstado());
					origenEncomienda.setText(encoPart.getSucursalOrigen().getDescripcion());
					volumenEncomienda.setText(Float.toString(encoPart.getVolumen()));
					tipoEncomienda.setText("Particular");
					pesoEncomienda.setText(Float.toString(encoPart.getPeso()));
					if(encoPart.getRefrigerado()){
						refrigeradoEncomienda.setText("Si");
					}  else {
						refrigeradoEncomienda.setText("No");
					}
					
					if(encoPart.getApilable()){
						apilableEncomienda.setText("Si - Cantidad: " + Integer.toString(encoPart.getCantApilable()));
					} else {
						apilableEncomienda.setText("No");
					}
					
					condicionesEncomienda.setText(encoPart.getCondicionTransporte());
					indicacionesEncomienda.setText(encoPart.getIndicacionesManipulacion());
					
					if(encoPart.getFactura()!=null){
						facturado.setText("Si");
						factura.setText(Integer.toString(encoPart.getFactura().getId()));
						
						DTO_Factura f = encoPart.getFactura();
						if(f != null){
							if(f.isPagado())
								estadoFactura.setText("Pago");
							else
								estadoFactura.setText("Pendiente Pago");
						} else {
							estadoFactura.setText("");
						}

					} else {
						facturado.setText("No");
						factura.setText("");
						estadoFactura.setText("");
					}

					
					Facturacion.setVisible(true);
					General.setVisible(true);
				} else {
					encoEmp = Controlador.getInstancia().getEncomiendaEmpresa((Integer) id.getValue());
					if(encoEmp != null){
						estadoEncomienda.setText(encoEmp.getEstado());
						origenEncomienda.setText(encoEmp.getSucursalOrigen().getDescripcion());
						volumenEncomienda.setText(Float.toString(encoEmp.getVolumen()));
						tipoEncomienda.setText("Empresa");
						pesoEncomienda.setText(Float.toString(encoEmp.getPeso()));
						if(encoEmp.getRefrigerado()){
							refrigeradoEncomienda.setText("Si");
						}  else {
							refrigeradoEncomienda.setText("No");
						}
						
						if(encoEmp.getApilable()){
							apilableEncomienda.setText("Si - Cantidad: " + Integer.toString(encoEmp.getCantApilable()));
						} else {
							apilableEncomienda.setText("No");
						}
						
						condicionesEncomienda.setText(encoEmp.getCondicionTransporte());
						indicacionesEncomienda.setText(encoEmp.getIndicacionesManipulacion());
						
						if(encoEmp.getFactura()!=null){
							facturado.setText("Si");
							factura.setText(Integer.toString(encoPart.getFactura().getId()));
							DTO_Factura f = encoPart.getFactura();
							if(f != null){
								if(f.isPagado())
									estadoFactura.setText("Pago");
								else
									estadoFactura.setText("Pendiente Pago");
							} else {
								estadoFactura.setText("");
							}
						} else {
							facturado.setText("No");
							factura.setText("");
							estadoFactura.setText("");
						}
						
						
						Facturacion.setVisible(true);
						General.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"No se ha encontrado la encomienda.", "Error", JOptionPane.ERROR_MESSAGE);
						id.setText("");
						Facturacion.setVisible(false);
						General.setVisible(false);
					}
				}
				
			}
		});
		btnBuscar.setBounds(368, 26, 86, 23);
		panel.add(btnBuscar);
		
		id = new JFormattedTextField();
		id.setBounds(115, 27, 243, 20);
		id.setValue(new Integer(0));
		panel.add(id);
		
		General = new JPanel();
		General.setLayout(null);
		General.setBorder(BorderFactory.createTitledBorder("General"));
		General.setBounds(10, 122, 464, 185);
		General.setVisible(false);
		frame.getContentPane().add(General);
		
		lblOrigen = new JLabel();
		lblOrigen.setText("Origen");
		lblOrigen.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblOrigen.setBounds(10, 55, 53, 15);
		General.add(lblOrigen);
		
		lblEstado = new JLabel();
		lblEstado.setText("Estado");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEstado.setBounds(10, 27, 53, 15);
		General.add(lblEstado);
		
		lblTipo = new JLabel();
		lblTipo.setText("Tipo");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblTipo.setBounds(244, 55, 52, 15);
		General.add(lblTipo);
		
		lblDiasEntrega = new JLabel();
		lblDiasEntrega.setText("Peso");
		lblDiasEntrega.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDiasEntrega.setBounds(244, 81, 42, 15);
		General.add(lblDiasEntrega);
		
		lblDestino = new JLabel();
		lblDestino.setText("Volumen");
		lblDestino.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDestino.setBounds(10, 81, 61, 14);
		General.add(lblDestino);
		
		lblHorario = new JLabel();
		lblHorario.setText("Apilable");
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblHorario.setBounds(10, 106, 49, 15);
		General.add(lblHorario);
		
		JLabel lblRefrigerado = new JLabel();
		lblRefrigerado.setText("Refrigerado");
		lblRefrigerado.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblRefrigerado.setBounds(244, 107, 74, 15);
		General.add(lblRefrigerado);
		
		JLabel lblCTransporte = new JLabel();
		lblCTransporte.setText("C. Transporte");
		lblCTransporte.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCTransporte.setBounds(10, 132, 87, 15);
		General.add(lblCTransporte);
		
		JLabel lblIndicaciones = new JLabel();
		lblIndicaciones.setText("Indicaciones");
		lblIndicaciones.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblIndicaciones.setBounds(10, 158, 87, 15);
		General.add(lblIndicaciones);
		
		estadoEncomienda = new JLabel();
		estadoEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		estadoEncomienda.setBounds(102, 28, 229, 15);
		General.add(estadoEncomienda);
		
		origenEncomienda = new JLabel();
		origenEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		origenEncomienda.setBounds(102, 56, 115, 15);
		General.add(origenEncomienda);
		
		volumenEncomienda = new JLabel();
		volumenEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		volumenEncomienda.setBounds(102, 82, 115, 15);
		General.add(volumenEncomienda);
		
		tipoEncomienda = new JLabel();
		tipoEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		tipoEncomienda.setBounds(339, 56, 115, 15);
		General.add(tipoEncomienda);
		
		pesoEncomienda = new JLabel();
		pesoEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		pesoEncomienda.setBounds(339, 82, 115, 15);
		General.add(pesoEncomienda);
		
		refrigeradoEncomienda = new JLabel();
		refrigeradoEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		refrigeradoEncomienda.setBounds(339, 107, 115, 15);
		General.add(refrigeradoEncomienda);
		
		apilableEncomienda = new JLabel();
		apilableEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		apilableEncomienda.setBounds(102, 107, 115, 15);
		General.add(apilableEncomienda);
		
		condicionesEncomienda = new JLabel();
		condicionesEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		condicionesEncomienda.setBounds(102, 133, 352, 15);
		General.add(condicionesEncomienda);
		
		indicacionesEncomienda = new JLabel();
		indicacionesEncomienda.setFont(new Font("Verdana", Font.PLAIN, 11));
		indicacionesEncomienda.setBounds(102, 158, 352, 15);
		General.add(indicacionesEncomienda);

		Facturacion = new JPanel();
		Facturacion.setBorder(new TitledBorder(null, "Facturacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Facturacion.setBounds(10, 318, 464, 75);
		frame.getContentPane().add(Facturacion);
		Facturacion.setLayout(null);
		Facturacion.setVisible(false);
		
		JLabel lblFacturado = new JLabel();
		lblFacturado.setText("Facturado");
		lblFacturado.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFacturado.setBounds(10, 22, 62, 15);
		Facturacion.add(lblFacturado);
		
		JLabel lblNroFactura = new JLabel();
		lblNroFactura.setText("Nro Factura");
		lblNroFactura.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNroFactura.setBounds(242, 23, 79, 15);
		Facturacion.add(lblNroFactura);
		
		JLabel lblEstado_1 = new JLabel();
		lblEstado_1.setText("Estado");
		lblEstado_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblEstado_1.setBounds(10, 48, 62, 15);
		Facturacion.add(lblEstado_1);
		
		facturado = new JLabel();
		facturado.setFont(new Font("Verdana", Font.PLAIN, 11));
		facturado.setBounds(105, 23, 115, 15);
		Facturacion.add(facturado);
		
		estadoFactura = new JLabel();
		estadoFactura.setFont(new Font("Verdana", Font.PLAIN, 11));
		estadoFactura.setBounds(105, 49, 115, 15);
		Facturacion.add(estadoFactura);
		
		factura = new JLabel();
		factura.setFont(new Font("Verdana", Font.PLAIN, 11));
		factura.setBounds(339, 23, 115, 15);
		Facturacion.add(factura);
		
	}
}
