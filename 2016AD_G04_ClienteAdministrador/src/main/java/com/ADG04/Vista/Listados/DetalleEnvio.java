package com.ADG04.Vista.Listados;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
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
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioHistorico;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class DetalleEnvio extends javax.swing.JFrame {

	private JLabel jLabelFecha;
	private JLabel jLabelFechaM;
	private JLabel jLabelDetalle;
	private JLabel jLabelEncomiendas;
	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JLabel jEstado;
	private JLabel jEstadoT;
	private JLabel jFechaActualizacion;
	private JLabel jLabelPosT;
	private JLabel jLabelPos;
	private JLabel jLabelHistorico;
	private JLabel jLabelVehT;
	private JLabel jLabelVeh;
	private JLabel jLabelSucT;
	private JLabel jLabelSuc;
	
	private JButton jButtonCancelar;
	private JLabel jLabel1;
	private JPanel jPanel1;
    private TableModel model;
    private TableModel modelH;
	private DTO_Envio dto;
    private JTable table;
    private JTable tableH;
    private DTO_EnvioPropio  envioPropio;
	private Vector<Vector<String>> data =  new Vector();
    private Vector<String> dataEncomienda= new Vector();
    private Vector<String> nombresColumnas = new Vector<String>();;
    private Vector<Vector<String>> dataH =  new Vector();
    private Vector<String> dataHistorico= new Vector();
    private Vector<String> nombresColumnasH = new Vector<String>();;

	private JLabel getJLabelFecha() {
		if (jLabelFecha == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setText("Fecha Ultima actualizacion:");
			jLabelFecha.setBounds(6, 27, 220, 15);
		}
		return jLabelFecha;
	}
	
	private JLabel getJLabelFechaM() {
		if(jLabelFechaM == null) {
			jLabelFechaM = new JLabel();
			jLabelFechaM.setText(String.valueOf(dto.getFechaActualizacion().toString()));
			jLabelFechaM.setFont(new java.awt.Font("Verdana",0,11));
			jLabelFechaM.setLayout(null);
			jLabelFechaM.setBounds(220, 25, 200, 20);
		}
		return jLabelFechaM;
	}
	

	private JLabel getJLabelEstadoT() {
		if (jEstadoT == null) {
			jEstadoT = new JLabel();
			jEstadoT.setText("Estado: ");
			jEstadoT.setBounds(6, 53, 133, 15);
		}
		return jEstadoT;
	}
	
	private JLabel getJLabelEstado() {
		if(jEstado == null) {
			jEstado = new JLabel();
			jEstado.setText(dto.getEstado());
			jEstado.setFont(new java.awt.Font("Verdana",0,11));
			jEstado.setLayout(null);
			jEstado.setBounds(135, 51, 200, 20);		
		}
		return jEstado;
	}
	
	private JLabel getJLabelPosT() {
		if (jLabelPosT == null) {
			jLabelPosT = new JLabel();
			jLabelPosT.setText("Posicion Actual: ");
			jLabelPosT.setBounds(6, 73, 130, 15);
		}
		return jLabelPosT;
	}

	private JLabel getJLabelPos() {
		if (jLabelPos == null) {
			jLabelPos = new JLabel();
			jLabelPos.setText(dto.getPosicionActual().getLatitud() + " / "+ dto.getPosicionActual().getLongitud());
			jLabelPos.setFont(new java.awt.Font("Verdana",0,11));
			jLabelPos.setBounds(135, 73, 353, 15);
		}
		return jLabelPos;
	}
	
	private JLabel getJLabelVehT() {
		if (jLabelVehT == null) {
			jLabelVehT = new JLabel();
			jLabelVehT.setText("Vehiculo: ");
			jLabelVehT.setBounds(6, 100, 130, 15);
		}
		return jLabelVehT;
	}

	private JLabel getJLabelVeh() {
		if (jLabelVeh == null) {
			jLabelVeh = new JLabel();
			DTO_Vehiculo veh = Controlador.getInstancia().getVehiculoById(envioPropio.getIdVehiculo()); 
			jLabelVeh.setText(veh.getPatente() + " | Peso: " + (veh.getPeso()-veh.getTara())  + " | Volumen: " + veh.getVolumen());
			jLabelVeh.setFont(new java.awt.Font("Verdana",0,11));
			jLabelVeh.setBounds(135, 100, 353, 15);
		}
		return jLabelVeh;
		
	}
	
	private JLabel getJLabelSucursalesT() {
		if (jLabelSucT == null) {
			jLabelSucT = new JLabel();
			jLabelSucT.setText("Sucursales: ");
			jLabelSucT.setBounds(6, 130, 130, 15);
		}
		return jLabelSucT;
	}

	private JLabel getJLabelSucursales() {
		if (jLabelSuc == null) {
			jLabelSuc = new JLabel(); 
			jLabelSuc.setText("Origen: "+ envioPropio.getSucursalOrigen().getDescripcion()+" - Destino: "+ envioPropio.getSucursalDestino().getDescripcion() );
			jLabelSuc.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSuc.setBounds(135, 130, 353, 15);
		}
		return jLabelSuc;
		
	}
		
	private JLabel getJLabelDetalle() {
		if (jLabelDetalle == null) {
			jLabelDetalle = new JLabel();
			jLabelDetalle.setText("Encomiendas");
			if(envioPropio==null)
				jLabelDetalle.setBounds(170, 93, 120, 15);
			else
				jLabelDetalle.setBounds(170, 153, 120, 15);
		}
		return jLabelDetalle;
	}
	
	private JLabel getJLabelHistorico() {
		if (jLabelHistorico == null) {
			jLabelHistorico = new JLabel();
			jLabelHistorico.setText("Historico");
			if(envioPropio==null)
				jLabelHistorico.setBounds(170, 200, 120, 15);
			else
				jLabelHistorico.setBounds(170, 280, 120, 15);
		}
		return jLabelHistorico;
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


	public DetalleEnvio(DTO_Envio DTO) {
		super();
		dto = DTO;
		envioPropio = Controlador.getInstancia().getEnvioPropio(dto.getId());
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
					jLabelTitulo.setText("Envio");
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
			this.setSize(504, 593);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder("General"));
			jPanel1.setBounds(10, 48, 464, 500);
			jPanel1.add(getJLabelFecha());
			jPanel1.add(getJLabelDetalle());
			jPanel1.add(getJTabla());
			jPanel1.add(getJTablaH());
			jPanel1.add(getJLabelFechaM());
			jPanel1.add(getJLabelEstado());
			jPanel1.add(getJLabelEstadoT());
			jPanel1.add(getJLabelPos());
			jPanel1.add(getJLabelPosT());
			jPanel1.add(getJLabelHistorico());
			if(envioPropio!=null){
				jPanel1.add(getJLabelVeh());
				jPanel1.add(getJLabelVehT());
				jPanel1.add(getJLabelSucursales());
				jPanel1.add(getJLabelSucursalesT());
			}
		}
		return jPanel1;
	}
	
	
	
	private JScrollPane getJTabla(){
	    
	    nombresColumnas.add("Id Encomienda");
	    nombresColumnas.add("Cliente");
	    nombresColumnas.add("Peso");
	    nombresColumnas.add("Volumen");

	    if(dto!=null){
	    	if(dto.getEncomiendas()!=null){
	    		 
		    	for(DTO_Encomienda item: dto.getEncomiendas()){
		    		dataEncomienda = new Vector<String>();
		    		dataEncomienda.add(String.valueOf(item.getIdEncomienda()));
		    		dataEncomienda.add(String.valueOf(item.getCliente().getId()));
		    		dataEncomienda.add(String.valueOf(item.getPeso()));
		    		dataEncomienda.add(String.valueOf(item.getVolumen()));
		    		data.add(dataEncomienda);
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
	    if(envioPropio==null)
	    	jScrollPane.setBounds(10, 120, table.getWidth(), table.getHeight());
	    else
	    	jScrollPane.setBounds(10, 170, table.getWidth(), table.getHeight());
	    getContentPane().add(jScrollPane);
	    
	    ListSelectionModel listSelectionModel = table.getSelectionModel();
	  
	    return jScrollPane;
	}
	
	private JScrollPane getJTablaH(){
	    
	    nombresColumnasH.add("Fecha");
	    nombresColumnasH.add("Estado");

	    if(dto!=null){
	    	List<DTO_EnvioHistorico> detalle =Controlador.getInstancia().getHistorico(dto.getId()); 
	    	if(detalle!=null){
	    		 
		    	for(DTO_EnvioHistorico item: Controlador.getInstancia().getHistorico(dto.getId())){
		    		dataHistorico = new Vector<String>();
		    		dataHistorico.add(item.getFecha().toString());
		    		dataHistorico.add(item.getEstado());
		    		dataH.add(dataHistorico);
		    	}
	    	}
        }
        modelH = new DefaultTableModel(dataH, nombresColumnasH);
	    tableH = new JTable(modelH);
	    tableH.setFillsViewportHeight(true);
	    tableH.setBounds(0, 20, 343, 78);
	    tableH.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    for (int c = 0; c < tableH.getColumnCount(); c++)
	    {
	        Class<?> col_class = tableH.getColumnClass(c);
	        tableH.setDefaultEditor(col_class, null);        // remove editor
	    }
	    JScrollPane jScrollPane = new JScrollPane(tableH);
	    if(envioPropio==null)
	    	jScrollPane.setBounds(10, 220, tableH.getWidth(), tableH.getHeight());
	    else
	    	jScrollPane.setBounds(10, 300, tableH.getWidth(), tableH.getHeight());
	    getContentPane().add(jScrollPane);
	    
	    ListSelectionModel listSelectionModel = tableH.getSelectionModel();
	  
	    return jScrollPane;
	}
	
	
	private JButton getJButtonCancelar() {
		if(jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.setBounds(350, 520, 99, 20);
			jButtonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			});
		}
		return jButtonCancelar;
	}
	

}
