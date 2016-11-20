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
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;

public class DetalleManifiesto extends javax.swing.JFrame {

	private JLabel jLabelFecha;
	private JLabel jLabelFechaM;
	private JLabel jLabelEncomienda;
	private JLabel jLabelEncomiendaM;
	private JLabel jLabelDetalle;
	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonCancelar;
	private JLabel jLabel1;
	private JPanel jPanel1;
    private TableModel model;
	private DTO_Manifiesto dto;
    private JTable table;
	private Vector<Vector<String>> data =  new Vector();
    private Vector<String> dataManifiesto= new Vector();
    private Vector<String> nombresColumnas = new Vector<String>();;
    

	private JLabel getJLabelEncomienda() {
		if (jLabelEncomienda == null) {
			jLabelEncomienda = new JLabel();
			jLabelEncomienda.setText("Encomienda");
			jLabelEncomienda.setBounds(6, 27, 113, 15);
		}
		return jLabelEncomienda;
	}
	
	private JLabel getJLabelEncomiendaM() {
		if(jLabelEncomiendaM == null) {
			jLabelEncomiendaM = new JLabel();
			jLabelEncomiendaM.setText(String.valueOf(dto.getIdEncomienda()));
			jLabelEncomiendaM.setFont(new java.awt.Font("Verdana",0,11));
			jLabelEncomiendaM.setLayout(null);
			jLabelEncomiendaM.setBounds(134, 27, 48, 20);
		}
		return jLabelEncomiendaM;
	}
	

	private JLabel getJLabelFecha() {
		if (jLabelFecha == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setText("Fecha");
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
			jLabelFechaM.setBounds(134, 53, 200, 20);		
		}
		return jLabelFechaM;
	}

	
	
	private JLabel getJLabelDetalle() {
		if (jLabelDetalle == null) {
			jLabelDetalle = new JLabel();
			jLabelDetalle.setText("Detalle");
			jLabelDetalle.setBounds(170, 70, 73, 15);
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


	public DetalleManifiesto(DTO_Manifiesto DTO) {
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
					jLabelTitulo.setText("Manifiesto");
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

		}
		return jPanel1;
	}
	
	
	
	private JScrollPane getJTabla(){
	    
	    nombresColumnas.add("Producto");
	    nombresColumnas.add("Cantidad");
	    nombresColumnas.add("Descripcion");

	    if(dto!=null){
	    	if(dto.getDetalle()!=null){
	    		 
		    	for(DTO_ItemManifiesto item: dto.getDetalle()){
		    		dataManifiesto = new Vector<String>();
		    		if(item.getProducto()!=null)
		    			dataManifiesto.add(item.getProducto().getCodigo());
		    		else
		    			dataManifiesto.add("");
		    		dataManifiesto.add(String.valueOf(item.getCantidad()));
		    		dataManifiesto.add(item.getDescripcion());
		    		data.add(dataManifiesto);
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
	    jScrollPane.setBounds(10, 85, table.getWidth(), table.getHeight());
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
