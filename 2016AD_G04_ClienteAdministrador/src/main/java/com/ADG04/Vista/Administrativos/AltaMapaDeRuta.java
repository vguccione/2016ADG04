package com.ADG04.Vista.Administrativos;

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
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;

public class AltaMapaDeRuta extends javax.swing.JFrame {

	private JLabel jLabelSucursalOrigen;
	private JLabel jLabelSucursalDestino;
	private JLabel jLabelDuracion;
	private JLabel jLabelCantKm;
	private JLabel jLabelCosto;
	private JPanel jPanel;
	private JLabel jLabelTitulo;
	private JButton jButtonAceptar;
	private JButton jButtonCancelar;
	private JButton btnEliminar;
	private JLabel jLabel1;
	private JPanel jPanel1;
    private TableModel model;
	private DTO_MapaDeRuta dto;
	private JLabel jLabelLatitud;
	private JLabel jLabelLongitud;
	private JTextField jTextFieldLatitud;
	private JTextField jTextFieldLongitud;
    private JTable table;
	private Vector<Vector<String>> data =  new Vector();
    private Vector<String> dataCoordenadas = new Vector();
    private Vector<String> nombresColumnas = new Vector<String>();;
    private JButton jButton1;
    private JFormattedTextField jFormattedTextFieldIdSucursal;
    private JButton jButton2;
    private JFormattedTextField jFormattedTextFieldIdSucursal2;
    private JFormattedTextField jFormattedTextFieldDuracion;
    private JFormattedTextField jFormattedTextFieldCantKm;
    private JFormattedTextField jFormattedTextFieldCosto;
    private DTO_Sucursal sucursalOrigen;
    private DTO_Sucursal sucursalDestino;
    private JLabel jLabelSucursalO;
    private JLabel jLabelSucursalD;
    

	private JLabel getJLabelSucursalOrigen() {
		if (jLabelSucursalOrigen == null) {
			jLabelSucursalOrigen = new JLabel();
			jLabelSucursalOrigen.setText("Sucursal Origen");
			jLabelSucursalOrigen.setBounds(6, 27, 113, 15);
		}
		return jLabelSucursalOrigen;
	}
	
	private JLabel getJLabelSucO() {
		if(jLabelSucursalO == null) {
			jLabelSucursalO = new JLabel();
			jLabelSucursalO.setText("");
			jLabelSucursalO.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursalO.setLayout(null);
			jLabelSucursalO.setBounds(347, 27, 231, 16);
			if(dto!=null){
				jLabelSucursalO.setText(Controlador.getInstancia().getSucursal(dto.getIdSucursalOrigen()).getDescripcion());
				sucursalOrigen = Controlador.getInstancia().getSucursal(dto.getIdSucursalOrigen());
			}
		}
		return jLabelSucursalO;
	}
	
	private JFormattedTextField getJFormattedTextField1() {
		if(jFormattedTextFieldIdSucursal == null) {
			jFormattedTextFieldIdSucursal = new JFormattedTextField();
			jFormattedTextFieldIdSucursal.setValue(new Integer(0));
			jFormattedTextFieldIdSucursal.setBounds(134, 27, 48, 20);
			if(dto!=null)
				jFormattedTextFieldIdSucursal.setValue(dto.getIdSucursalOrigen());
		}
		return jFormattedTextFieldIdSucursal;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar");
			jButton1.setBounds(218, 27, 100, 21);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
						sucursalOrigen = Controlador.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal.getValue());
						if(sucursalOrigen != null){
							jFormattedTextFieldIdSucursal.setEnabled(false);
							jButton1.setEnabled(false);
							jLabelSucursalO.setText(sucursalOrigen.getDescripcion());
						} else {
							JOptionPane.showMessageDialog(null,"No se ha encontrado la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
				}
			});
		}
		return jButton1;
	}
	
	private JLabel getJLabelSucursalDestino() {
		if (jLabelSucursalDestino == null) {
			jLabelSucursalDestino = new JLabel();
			jLabelSucursalDestino.setText("Sucursal Destino");
			jLabelSucursalDestino.setBounds(6, 53, 133, 15);
		}
		return jLabelSucursalDestino;
	}
	
	private JLabel getJLabelSucD() {
		if(jLabelSucursalD == null) {
			jLabelSucursalD = new JLabel();
			jLabelSucursalD.setText("");
			jLabelSucursalD.setFont(new java.awt.Font("Verdana",0,11));
			jLabelSucursalD.setLayout(null);
			jLabelSucursalD.setBounds(347, 53, 231, 16);
			if(dto!=null){
				jLabelSucursalD.setText(Controlador.getInstancia().getSucursal(dto.getIdSucursalDestino()).getDescripcion());
				sucursalDestino = Controlador.getInstancia().getSucursal(dto.getIdSucursalDestino());
			}
		
		}
		return jLabelSucursalD;
	}
	
	private JFormattedTextField getJFormattedTextField2() {
		if(jFormattedTextFieldIdSucursal2 == null) {
			jFormattedTextFieldIdSucursal2 = new JFormattedTextField();
			jFormattedTextFieldIdSucursal2.setValue(new Integer(0));
			jFormattedTextFieldIdSucursal2.setBounds(134, 53, 48, 20);
			if(dto!=null)
				jFormattedTextFieldIdSucursal2.setValue(dto.getIdSucursalDestino());
		}
		return jFormattedTextFieldIdSucursal2;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Buscar");
			jButton2.setBounds(218, 53, 100, 21);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
						sucursalDestino = Controlador.getInstancia().getSucursal((Integer) jFormattedTextFieldIdSucursal2.getValue());
						if(sucursalDestino != null){
							jFormattedTextFieldIdSucursal2.setEnabled(false);
							jButton2.setEnabled(false);
							jLabelSucursalD.setText(sucursalDestino.getDescripcion());
						} else {
							JOptionPane.showMessageDialog(null,"No se ha encontrado la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
				}
			});
		}
		return jButton2;
	}
	
	
	private JLabel getJLabelCantKm() {
		if (jLabelCantKm == null) {
			jLabelCantKm = new JLabel();
			jLabelCantKm.setText("Cant. Km");
			jLabelCantKm.setBounds(6, 83, 73, 15);
		}
		return jLabelCantKm;
	}
	
	private JFormattedTextField getJFormattedTextFieldCantKm() {
		if(jFormattedTextFieldCantKm == null) {
			jFormattedTextFieldCantKm = new JFormattedTextField();
			jFormattedTextFieldCantKm.setValue(new Float(0));
			jFormattedTextFieldCantKm.setBounds(124, 83, 48, 20);
			if(dto!=null)
				jFormattedTextFieldCantKm.setValue(dto.getCantKm());
		}
		return jFormattedTextFieldCantKm;
	}
	
	private JLabel getJLabelCosto() {
		if (jLabelCosto == null) {
			jLabelCosto = new JLabel();
			jLabelCosto.setText("Costo");
			jLabelCosto.setBounds(6, 113, 73, 15);
		}
		return jLabelCosto;
	}
	
	
	private JFormattedTextField getJFormattedTextFieldCosto() {
		if(jFormattedTextFieldCosto == null) {
			jFormattedTextFieldCosto = new JFormattedTextField();
			jFormattedTextFieldCosto.setValue(new Float(0));
			jFormattedTextFieldCosto.setBounds(124, 113, 48, 20);
			if(dto!=null)
				jFormattedTextFieldCosto.setValue(dto.getCosto());
		}
		return jFormattedTextFieldCosto;
	}
	
	private JLabel getJLabelDuracion() {
		if (jLabelDuracion == null) {
			jLabelDuracion = new JLabel();
			jLabelDuracion.setText("Duracion (en minutos)");
			jLabelDuracion.setBounds(6, 143, 140, 15);
		}
		return jLabelDuracion;
	}
	
	private JFormattedTextField getJFormattedTextFieldDuracion() {
		if(jFormattedTextFieldDuracion == null) {
			jFormattedTextFieldDuracion = new JFormattedTextField();
			jFormattedTextFieldDuracion.setValue(new Float(0));
			jFormattedTextFieldDuracion.setBounds(154, 143, 48, 20);
			if(dto!=null)
				jFormattedTextFieldDuracion.setValue(dto.getDuracion());
		}
		return jFormattedTextFieldDuracion;
	}
	
	
	JLabel getJLabelLatitud() {
		if (jLabelLatitud == null) {
			jLabelLatitud = new JLabel();
			jLabelLatitud.setText("Latitud");
			jLabelLatitud.setBounds(6, 173, 73, 15);
		}
		return jLabelLatitud;
	}
	
	private JTextField getJTextFieldLongitud() {
		if(jTextFieldLongitud == null) {
			jTextFieldLongitud = new JTextField();
			jTextFieldLongitud.setBounds(94, 173, 54, 18);
			
		}
		return jTextFieldLongitud;
	}
	
	private JLabel getJLabelLongitud() {
		if (jLabelLongitud == null) {
			jLabelLongitud = new JLabel();
			jLabelLongitud.setText("Longitud");
			jLabelLongitud.setBounds(170, 173, 73, 15);
		}
		return jLabelLongitud;
	}
	
	private JTextField getJTextFieldLatitud() {
		if(jTextFieldLatitud == null) {
			jTextFieldLatitud = new JTextField();
			jTextFieldLatitud.setBounds(240, 173, 54, 18);
			
		}
		return jTextFieldLatitud;
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


	public AltaMapaDeRuta(DTO_MapaDeRuta DTO) {
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
				jPanel.add(getJButtonAceptar());
				jPanel.add(getJButtonCancelar());
				jPanel.add(getJBtnEliminar());
				jPanel.add(getJLabel1());
				{
					jLabelTitulo = new JLabel();
					jPanel.add(jLabelTitulo);
					jPanel.add(getJPanel1());
					if(dto==null)
						jLabelTitulo.setText("Alta Mapa de Ruta");
					else
						jLabelTitulo.setText("Modificar Mapa de Ruta");
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
			this.setSize(504, 493);

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
			jPanel1.setBounds(10, 48, 464, 503);
			jPanel1.add(getJLabelCantKm());
			jPanel1.add(getJLabelCosto());
			jPanel1.add(getJLabelDuracion());
			jPanel1.add(getJLabelSucursalDestino());
			jPanel1.add(getJLabelSucursalOrigen());
			jPanel1.add(getJLabelLatitud());
			jPanel1.add(getJLabelLongitud());
			jPanel1.add(getJTextFieldLatitud());
			jPanel1.add(getJTextFieldLongitud());
			jPanel1.add(getJBtnAgregar());
			jPanel1.add(getJTabla());
			jPanel1.add(getJFormattedTextField1());
			jPanel1.add(getJFormattedTextField2());
			jPanel1.add(getJFormattedTextFieldCantKm());
			jPanel1.add(getJFormattedTextFieldCosto());
			jPanel1.add(getJFormattedTextFieldDuracion());
			jPanel1.add(getJButton1());
			jPanel1.add(getJButton2());
			jPanel1.add(getJLabelSucD());
			jPanel1.add(getJLabelSucO());

		}
		return jPanel1;
	}
	
	
	private JButton getJBtnAgregar(){

	   //Agregar productos a la tabla
	    JButton btnAgregar = new JButton("+");	    
	    btnAgregar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if(dto!=null){
	        		if(dto.getCoordenadas()!=null){
	        			data.removeAllElements();
	    		    	for(DTO_Coordenada coord: dto.getCoordenadas()){
	    		    		dataCoordenadas = new Vector<String>();
	    		    		dataCoordenadas.add(coord.getLatitud());
	    		    		dataCoordenadas.add(coord.getLongitud());
	    		    		data.add(dataCoordenadas);
	    		    	}
	    		    dataCoordenadas = new Vector<String>();
	    	    	}
	        	}
	            dataCoordenadas.add(jTextFieldLatitud.getText());
	            dataCoordenadas.add(jTextFieldLongitud.getText());
	            data.add(dataCoordenadas);
	            dataCoordenadas = new Vector<String>();
	            model = new DefaultTableModel(data, nombresColumnas);
	            TableModelEvent tableModelEvent = new TableModelEvent(model);
	            table.tableChanged(tableModelEvent);
	        }
	    });
	    
	    btnAgregar.setBounds(312, 170, 41, 23);
	    return btnAgregar;
	}
	
	private JScrollPane getJTabla(){
	    
	    nombresColumnas.add("Latitud");
	    nombresColumnas.add("Longitud");

	    if(dto!=null){
	    	if(dto.getCoordenadas()!=null){
	    		 
		    	for(DTO_Coordenada coord: dto.getCoordenadas()){
		    		dataCoordenadas = new Vector<String>();
		    		dataCoordenadas.add(coord.getLatitud());
		    		dataCoordenadas.add(coord.getLongitud());
		    		data.add(dataCoordenadas);
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
	    jScrollPane.setBounds(10, 194, table.getWidth(), table.getHeight());
	    getContentPane().add(jScrollPane);
	    
	    ListSelectionModel listSelectionModel = table.getSelectionModel();
	    listSelectionModel.addListSelectionListener(new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent e) {
	            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
	            btnEliminar.setEnabled(!lsm.isSelectionEmpty());
	        }
	    });
	    return jScrollPane;
	}
	
	private JButton getJButtonAceptar() {
		if(jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.setBounds(98, 420, 99, 20);
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						try{
							if(dto==null){
								Map<String, String> mapLatLong = new HashMap();
			               
				                for (int i = 0; i < data.size(); i++) {
				                	mapLatLong.put(data.elementAt(i).elementAt(0), data.elementAt(i).elementAt(1));
				                }
						
				                Controlador.getInstancia().altaMapaDeRuta(sucursalOrigen,sucursalDestino,(Float) jFormattedTextFieldCantKm.getValue(),
				                						(Float)jFormattedTextFieldCosto.getValue(),(Float) jFormattedTextFieldDuracion.getValue(),mapLatLong );
							}
							else{
								Map<String, String> mapLatLong = new HashMap();
					               
				                for (int i = 0; i < data.size(); i++) {
				                	mapLatLong.put(data.elementAt(i).elementAt(0), data.elementAt(i).elementAt(1));
				                }
						
				                Controlador.getInstancia().modificarMapaDeRuta(dto.getId(),sucursalOrigen,sucursalDestino,(Float) jFormattedTextFieldCantKm.getValue(),
				                						(Float)jFormattedTextFieldCosto.getValue(),(Float) jFormattedTextFieldDuracion.getValue(),mapLatLong );
							}
				            setVisible(false);
						}
						catch(Exception e){
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta el mapa de ruta.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		return jButtonAceptar;
	}
	
	private JButton getJBtnEliminar(){
	    btnEliminar = new JButton("Eliminar");
	    btnEliminar.setBounds(210,420,120,23);
	    btnEliminar.setEnabled(false);
	    btnEliminar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	DefaultTableModel modelo = (DefaultTableModel)table.getModel(); 
	        	modelo.removeRow(table.getSelectedRow()); 
	        }
	    });
	    return btnEliminar;
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
	
public boolean validacion(){
		
		if ((Float)jFormattedTextFieldCantKm.getValue()==0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el Costo Km", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldCantKm.requestFocus();
			return false;
		} else if ((Float)jFormattedTextFieldDuracion.getValue()==0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la duracion.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldDuracion.requestFocus();
			return false;		
		} else if ((Float)jFormattedTextFieldCosto.getValue()==0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el Costo.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldCosto.requestFocus();
			return false;
		} else if ((Integer)jFormattedTextFieldIdSucursal.getValue()==0){
			JOptionPane.showMessageDialog(null,"Por favor, indique la sucursal origen.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal.requestFocus();
			return false;
		}   else if ((Integer)jFormattedTextFieldIdSucursal2.getValue()==0){
			JOptionPane.showMessageDialog(null,"Por favor, indique la sucursal destino.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal2.requestFocus();
			return false;
		}  else if ((Integer)jFormattedTextFieldIdSucursal2.getValue()==(Integer)jFormattedTextFieldIdSucursal.getValue()){
			JOptionPane.showMessageDialog(null,"La sucursal origen debe ser distinta a la destino.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jFormattedTextFieldIdSucursal2.requestFocus();
			return false;
			
		} 
		return true;
	}

}
