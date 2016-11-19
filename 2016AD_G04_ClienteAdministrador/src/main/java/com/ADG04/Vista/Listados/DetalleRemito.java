package com.ADG04.Vista.Listados;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Encomienda.DTO_Remito;

public class DetalleRemito extends javax.swing.JFrame {

	private JLabel jLabelFecha;
	private JLabel jLabelFechaM;
	private JLabel jLabelEncomienda;
	private JLabel jLabelEncomiendaM;
	private JLabel jLabelDetalle;
	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JLabel jLabelFechaEstimada;
	private JLabel jLabelEstaConformado;
	private JLabel jLabelCondiciones;
	private JLabel jLabelIndManipulacion;
	private JLabel jLabelReceptor;

	private JLabel jLabelFechaEstimadaT;
	private JLabel jLabelEstaConformadoT;
	private JLabel jLabelCondicionesT;
	private JLabel jLabelIndManipulacionT;
	private JLabel jLabelReceptorT;
	private JButton jButtonCancelar;
	private JLabel jLabel1;
	private JPanel jPanel1;
    private TableModel model;
	private DTO_Remito dto;
    private JTable table;
	private Vector<Vector<String>> data =  new Vector();
    private Vector<String> dataRemito= new Vector();
    private Vector<String> nombresColumnas = new Vector<String>();;
    

	private JLabel getJLabelEncomienda() {
		if (jLabelEncomienda == null) {
			jLabelEncomienda = new JLabel();
			jLabelEncomienda.setText("Encomienda:");
			jLabelEncomienda.setBounds(6, 27, 100, 15);
		}
		return jLabelEncomienda;
	}
	
	private JLabel getJLabelEncomiendaM() {
		if(jLabelEncomiendaM == null) {
			jLabelEncomiendaM = new JLabel();
			jLabelEncomiendaM.setText(String.valueOf(dto.getIdEncomienda()));
			jLabelEncomiendaM.setFont(new java.awt.Font("Verdana",0,11));
			jLabelEncomiendaM.setLayout(null);
			jLabelEncomiendaM.setBounds(124, 25, 48, 20);
		}
		return jLabelEncomiendaM;
	}
	

	private JLabel getJLabelFecha() {
		if (jLabelFecha == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setText("Fecha Creacion:");
			jLabelFecha.setBounds(6, 53, 133, 15);
		}
		return jLabelFecha;
	}
	
	private JLabel getJLabelFechaM() {
		if(jLabelFechaM == null) {
			jLabelFechaM = new JLabel();
			jLabelFechaM.setText(dto.getFecha().toString());
			jLabelFechaM.setFont(new java.awt.Font("Verdana",0,11));
			jLabelFechaM.setLayout(null);
			jLabelFechaM.setBounds(134, 51, 200, 20);		
		}
		return jLabelFechaM;
	}
	
	private JLabel getJLabelFechaEstimadaT() {
		if (jLabelFechaEstimadaT == null) {
			jLabelFechaEstimadaT = new JLabel();
			jLabelFechaEstimadaT.setText("Fecha Estimada Entrega: ");
			jLabelFechaEstimadaT.setBounds(6, 73, 250, 15);
		}
		return jLabelFechaEstimadaT;
	}

	private JLabel getJLabelFechaEstimadaEntrega() {
		if (jLabelFechaEstimada == null) {
			jLabelFechaEstimada = new JLabel();
			//jLabelFechaEstimada.setText(dto.getFechaEstimadaEntrega().toString());
			jLabelFechaEstimada.setText("");
			jLabelFechaEstimada.setFont(new java.awt.Font("Verdana",0,11));
			jLabelFechaEstimada.setBounds(204, 73, 353, 15);
		}
		return jLabelFechaEstimada;
	}
	
	
	private JLabel getJLabelEstaConformado() {
		if (jLabelEstaConformado == null) {
			jLabelEstaConformado = new JLabel();
			if(dto.isConformado())
				jLabelEstaConformado.setText("Conformado");
			else
				jLabelEstaConformado.setText("No Conformado");
			jLabelEstaConformado.setBounds(6, 93, 233, 15);
		}
		return jLabelEstaConformado;
	}
	
	private JLabel getJLabelCondicionesT() {
		if (jLabelCondicionesT == null) {
			jLabelCondicionesT = new JLabel();
			jLabelCondicionesT.setText("Condicion Transporte: ");
			jLabelCondicionesT.setBounds(6, 113, 220, 15);
		}
		return jLabelCondicionesT;
	}
	
	private JLabel getJLabelCondiciones() {
		if (jLabelCondiciones == null) {
			jLabelCondiciones = new JLabel();
			jLabelCondiciones.setText(dto.getCondicionTransporte());
			jLabelCondiciones.setFont(new java.awt.Font("Verdana",0,11));
			jLabelCondiciones.setBounds(184, 113, 253, 15);
		}
		return jLabelCondiciones;
	}
	
	
	private JLabel getJLabelIndManipulacionT() {
		if (jLabelIndManipulacionT == null) {
			jLabelIndManipulacionT = new JLabel();
			jLabelIndManipulacionT.setText("Indicaciones: ");
			jLabelIndManipulacionT.setBounds(6, 133, 120, 15);
		}
		return jLabelIndManipulacionT;
	}
	
	private JLabel getJLabelIndManipulacion() {
		if (jLabelIndManipulacion == null) {
			jLabelIndManipulacion = new JLabel();
			jLabelIndManipulacion.setText(dto.getIndicacionesManipulacion());
			jLabelIndManipulacion.setFont(new java.awt.Font("Verdana",0,11));
			jLabelIndManipulacion.setBounds(134, 133, 333, 15);
		}
		return jLabelIndManipulacion;
	}
	
	private JLabel getJLabelReceptorT() {
		if (jLabelReceptorT == null) {
			jLabelReceptorT = new JLabel();
			jLabelReceptorT.setText("Receptor: ");
			jLabelReceptorT.setBounds(6, 153, 100, 15);
		}
		return jLabelReceptorT;
	}	
	
	private JLabel getJLabelReceptor() {
		if (jLabelReceptor == null) {
			jLabelReceptor = new JLabel();
			jLabelReceptor.setText(dto.getNombreReceptor() + " " + dto.getApellidoReceptor() + " (DNI: " + 
			dto.getDniReceptor() + ")");
			jLabelReceptor.setFont(new java.awt.Font("Verdana",0,11));
			jLabelReceptor.setBounds(134, 153, 353, 15);
		}
		return jLabelReceptor;
	}
	
	private JLabel getJLabelDetalle() {
		if (jLabelDetalle == null) {
			jLabelDetalle = new JLabel();
			jLabelDetalle.setText("Detalle");
			jLabelDetalle.setBounds(170, 170, 73, 15);
		}
		return jLabelDetalle;
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


	public DetalleRemito(DTO_Remito DTO) {
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
				jPanel.add(getJButtonCancelar());	
				jPanel.add(getJLabel1());
				{
					jLabelTitulo = new JLabel();
					jPanel.add(jLabelTitulo);
					jPanel.add(getJPanel1());
					jLabelTitulo.setText("Remito");
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
			this.setSize(504, 393);

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder("General"));
			jPanel1.setBounds(10, 48, 464, 305);
			jPanel1.add(getJLabelFecha());
			jPanel1.add(getJLabelEncomienda());
			jPanel1.add(getJLabelDetalle());
			jPanel1.add(getJTabla());
			jPanel1.add(getJLabelEncomiendaM());
			jPanel1.add(getJLabelFechaM());
			jPanel1.add(getJLabelIndManipulacion());
			jPanel1.add(getJLabelReceptor());
			jPanel1.add(getJLabelCondiciones());
			jPanel1.add(getJLabelFechaEstimadaEntrega());
			jPanel1.add(getJLabelEstaConformado());

			jPanel1.add(getJLabelIndManipulacionT());
			jPanel1.add(getJLabelReceptorT());
			jPanel1.add(getJLabelCondicionesT());
			jPanel1.add(getJLabelFechaEstimadaT());
			jPanel1.add(getJLabelEstaConformado());

		}
		return jPanel1;
	}
	
	
	
	private JScrollPane getJTabla(){
	    
	    nombresColumnas.add("Producto");
	    nombresColumnas.add("Cantidad");
	    nombresColumnas.add("Descripcion");

	    if(dto!=null){
	    	if(dto.getDetalle()!=null){
	    		
		    	for(DTO_ItemRemito item: dto.getDetalle()){
		    		String codigo = "";
		    		if(item.getProducto()!=null)
		    			codigo = item.getProducto().getCodigo();
		    		dataRemito = new Vector<String>();
		    		dataRemito.add(codigo);
		    		dataRemito.add(String.valueOf(item.getCantidad()));
		    		dataRemito.add(item.getDescripcion());
		    		data.add(dataRemito);
		    	}
	    	}
        }
        model = new DefaultTableModel(data, nombresColumnas);
	    table = new JTable(model);
	    table.setFillsViewportHeight(true);
	    table.setBounds(0, 20, 343, 78);
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    for (int c = 0; c < table.getColumnCount(); c++)
	    {
	        Class<?> col_class = table.getColumnClass(c);
	        table.setDefaultEditor(col_class, null);        // remove editor
	    }
	    JScrollPane jScrollPane = new JScrollPane(table);
	    jScrollPane.setBounds(10, 195, table.getWidth(), table.getHeight());
	    getContentPane().add(jScrollPane);
	    
	    ListSelectionModel listSelectionModel = table.getSelectionModel();
	  
	    return jScrollPane;
	}
	
	
	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(350, 420, 99, 20);
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			});
		}
		return jButtonCancelar;
	}
	

}
