package com.ADG04.Vista.Vehiculos;
import com.ADG04.Controller.Controlador;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class AltaVehiculo extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JPanel jPanel1;
	private JLabel modeloLabel;
	private JLabel jLabel1;
	private JLabel anchoLabel;
	private JLabel largoLabel;
	private JLabel tempMinimaLabel;
	private JRadioButton CamionetaRadioButton;
	private JRadioButton TractorRadioButton;
	private JRadioButton CamionConCajaRadioButton;
	private JRadioButton CamionTanqueRadioButton;
	private JFormattedTextField tempMaximaField;
	private JLabel tempMaximaLabel;
	private JFormattedTextField tempMinimaTextField;
	private JFormattedTextField sucursalTextField;
	private JLabel sucursalLabel;
	private JDateChooser jDateChooserFechaIngreso;
	private JDateChooser jDateChooserUMAntenimiento;
	private JLabel uMantenimientoLabel;
	private JLabel fIngresoLabel;
	private JFormattedTextField volumenTextField;
	private JLabel volumenLabel;
	private JFormattedTextField taraTextField;
	private JLabel taraLabel;
	private JFormattedTextField largoTextField;
	private JFormattedTextField altoTextField;
	private JLabel altoLabel;
	private JFormattedTextField Ancho;
	private JPanel jPanel2;
	private JFormattedTextField kmTextField;
	private JLabel kmLabel;
	private JFormattedTextField modeloTextField;
	private JTextField marcaTextField;
	private JLabel marcaLabel;
	private JLabel tipoLabel;
	private JTextField patenteTextField;
	private JLabel pesoLabel;
	private JButton jButton2;
	private JFormattedTextField jFormattedTextField1;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton jButton1;
	private JButton cancelarButton;
	private JFormattedTextField pesoTextField;
	private JRadioButton otroRadioButton;
	private JButton jButtonAceptar;
	private JLabel patenteLabel;
	private DTO_Sucursal sucursal;
	private DTO_PlanMantenimiento plan;

	public AltaVehiculo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Alta Vehiculo");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(10, 0, 231, 40);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				getContentPane().add(getJPanel2());
				getContentPane().add(getJButtonAceptar());
				getContentPane().add(getCancelarButton());
				jPanel1.setLayout(null);
				jPanel1.setBounds(10, 39, 485, 181);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Ingrese datos del vehiculo"
						+ ""));
				{
					patenteLabel = new JLabel();
					jPanel1.add(patenteLabel);
					patenteLabel.setText("Patente");
					patenteLabel.setFont(new java.awt.Font("Verdana",0,11));
					patenteLabel.setBounds(5, 28, 96, 15);
				}
				{
					patenteTextField = new JTextField();
					jPanel1.add(patenteTextField);
					patenteTextField.setBounds(80, 25, 240, 21);
				}
				{
					tipoLabel = new JLabel();
					jPanel1.add(tipoLabel);
					jPanel1.add(getMarcaLabel());
					jPanel1.add(getMarcaTextField());
					jPanel1.add(getModeloLabel());
					jPanel1.add(getModeloTextField());
					jPanel1.add(getKmLabel());
					jPanel1.add(getKmTextField());
					jPanel1.add(getCamionTanqueRadioButton());
					jPanel1.add(getCamionConCajaRadioButton());
					jPanel1.add(getTractorRadioButton());
					jPanel1.add(getCamionetaRadioButton());
					jPanel1.add(getOtroRadioButton());
					tipoLabel.setText("Tipo");
					tipoLabel.setBounds(5, 55, 31, 36);
					tipoLabel.setFont(new java.awt.Font("Verdana",0,11));
				}
			}
			pack();
			this.setSize(516, 698);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	private JLabel getMarcaLabel() {
		if(marcaLabel == null) {
			marcaLabel = new JLabel();
			marcaLabel.setText("Marca");
			marcaLabel.setFont(new java.awt.Font("Verdana",0,11));
			marcaLabel.setBounds(5, 115, 43, 14);
		}
		return marcaLabel;
	}
	
	private JTextField getMarcaTextField() {
		if(marcaTextField == null) {
			marcaTextField = new JTextField();
			marcaTextField.setBounds(80, 112, 243, 21);
		}
		return marcaTextField;
	}
	
	private JLabel getModeloLabel() {
		if(modeloLabel == null) {
			modeloLabel = new JLabel();
			modeloLabel.setText("Modelo");
			modeloLabel.setFont(new java.awt.Font("Verdana",0,11));
			modeloLabel.setBounds(5, 147, 66, 14);
		}
		return modeloLabel;
	}
	
	private JFormattedTextField getModeloTextField() {
		if(modeloTextField == null) {
			modeloTextField = new JFormattedTextField();
			modeloTextField.setValue(new Integer(0));
			modeloTextField.setBounds(80, 144, 59, 21);
		}
		return modeloTextField;
	}
	
	private JLabel getKmLabel() {
		if(kmLabel == null) {
			kmLabel = new JLabel();
			kmLabel.setText("Kil�metros");
			kmLabel.setFont(new java.awt.Font("Verdana",0,11));
			kmLabel.setBounds(187, 147, 66, 14);
		}
		return kmLabel;
	}
	
	private JFormattedTextField getKmTextField() {
		if(kmTextField == null) {
			kmTextField = new JFormattedTextField();
			kmTextField.setBounds(259, 144, 63, 21);
			kmTextField.setValue(new Float(0));
		}
		return kmTextField;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createTitledBorder("Caracter�sticas del vehiculo"));
			jPanel2.setBounds(12, 238, 490, 380);
			jPanel2.add(getAnchoLabel());
			jPanel2.add(getJLabel1());
			jPanel2.add(getAncho());
			jPanel2.add(getAltoLabel());
			jPanel2.add(getAltoTextField());
			jPanel2.add(getLargoLabel());
			jPanel2.add(getLargoTextField());
			jPanel2.add(getTaraLabel());
			jPanel2.add(getTaraTextField());
			jPanel2.add(getVolumenLabel());
			jPanel2.add(getVolumenTextField());
			jPanel2.add(getjDateChooserFechaIngreso());
			jPanel2.add(getFIngresoLabel());
			jPanel2.add(getUMantenimientoLabel());
			jPanel2.add(getjDateChooserUMAntenimiento());
			jPanel2.add(getSucursalLabel());
			jPanel2.add(getSucursalTextField());
			jPanel2.add(getTempMinimaLabel());
			jPanel2.add(getTempMinimaTextField());
			jPanel2.add(getTempMaximaLabel());
			jPanel2.add(getTempMaximaField());
			jPanel2.add(getPesoLabel());
			jPanel2.add(getPesoTextField());
			jPanel2.add(getJButton1());
			jPanel2.add(getJLabel2());
			jPanel2.add(getJLabel3());
			jPanel2.add(getJLabel4());
			jPanel2.add(getJFormattedTextField1());
			jPanel2.add(getJButton2());
		}
		return jPanel2;
	}
	
	private JLabel getAnchoLabel() {
		if(anchoLabel == null) {
			anchoLabel = new JLabel();
			anchoLabel.setText("Ancho");
			anchoLabel.setFont(new java.awt.Font("Verdana",0,11));
			anchoLabel.setBounds(0, 0, 247, -50);
		}
		return anchoLabel;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Ancho [cm]");
			jLabel1.setFont(new java.awt.Font("Verdana",0,11));
			jLabel1.setBounds(5, 23, 67, 14);
		}
		return jLabel1;
	}
	
	private JFormattedTextField getAncho() {
		if(Ancho == null) {
			Ancho = new JFormattedTextField();
			Ancho.setBounds(106, 21, 57, 21);
			Ancho.setValue(new Float(0));
		}
		return Ancho;
	}
	
	private JLabel getAltoLabel() {
		if(altoLabel == null) {
			altoLabel = new JLabel();
			altoLabel.setText("Alto [cm]");
			altoLabel.setFont(new java.awt.Font("Verdana",0,11));
			altoLabel.setBounds(181, 23, 66, 14);
		}
		return altoLabel;
	}
	
	private JFormattedTextField getAltoTextField() {
		if(altoTextField == null) {
			altoTextField = new JFormattedTextField();
			altoTextField.setValue(new Float(0));
			altoTextField.setBounds(274, 21, 63, 21);
		}
		return altoTextField;
	}
	
	private JLabel getLargoLabel() {
		if(largoLabel == null) {
			largoLabel = new JLabel();
			largoLabel.setText("Largo [cm]");
			largoLabel.setFont(new java.awt.Font("Verdana",0,11));
			largoLabel.setBounds(5, 49, 67, 14);
		}
		return largoLabel;
	}
	
	private JFormattedTextField getLargoTextField() {
		if(largoTextField == null) {
			largoTextField = new JFormattedTextField();
			largoTextField.setValue(new Float(0));
			largoTextField.setBounds(106, 47, 57, 21);
		}
		return largoTextField;
	}
	
	private JLabel getTaraLabel() {
		if(taraLabel == null) {
			taraLabel = new JLabel();
			taraLabel.setText("Tara [kg]");
			taraLabel.setFont(new java.awt.Font("Verdana",0,11));
			taraLabel.setBounds(181, 49, 55, 14);
		}
		return taraLabel;
	}
	
	private JFormattedTextField getTaraTextField() {
		if(taraTextField == null) {
			taraTextField = new JFormattedTextField();
			taraTextField.setValue(new Float(0));
			taraTextField.setBounds(274, 47, 62, 21);
		}
		return taraTextField;
	}
	
	private JLabel getVolumenLabel() {
		if(volumenLabel == null) {
			volumenLabel = new JLabel();
			volumenLabel.setText("Volumen [m�]");
			volumenLabel.setFont(new java.awt.Font("Verdana",0,11));
			volumenLabel.setBounds(5, 75, 89, 14);
		}
		return volumenLabel;
	}
	
	private JFormattedTextField getVolumenTextField() {
		if(volumenTextField == null) {
			volumenTextField = new JFormattedTextField();
			volumenTextField.setValue(new Float(0));
			volumenTextField.setBounds(106, 73, 57, 21);
		}
		return volumenTextField;
	}
	
	private JDateChooser getjDateChooserFechaIngreso() {
		if(jDateChooserFechaIngreso == null) {
			jDateChooserFechaIngreso = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserFechaIngreso.setDateFormatString("dd/MM/yyyy");
			jDateChooserFechaIngreso.setBounds(178, 200, 149, 23);
		}
		return jDateChooserFechaIngreso;
	}
	
	private JLabel getFIngresoLabel() {
		if(fIngresoLabel == null) {
			fIngresoLabel = new JLabel();
			fIngresoLabel.setText("Fecha Ingreso");
			fIngresoLabel.setFont(new java.awt.Font("Verdana",0,11));
			fIngresoLabel.setBounds(5, 200, 136, 23);
		}
		return fIngresoLabel;
	}
	
	private JLabel getUMantenimientoLabel() {
		if(uMantenimientoLabel == null) {
			uMantenimientoLabel = new JLabel();
			uMantenimientoLabel.setText("�ltimo Mantenimiento");
			uMantenimientoLabel.setFont(new java.awt.Font("Verdana",0,11));
			uMantenimientoLabel.setBounds(5, 229, 130, 23);
		}
		return uMantenimientoLabel;
	}
	
	private JDateChooser getjDateChooserUMAntenimiento() {
		if(jDateChooserUMAntenimiento == null) {
			jDateChooserUMAntenimiento = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserUMAntenimiento.setDateFormatString("dd/MM/yyyy");
			jDateChooserUMAntenimiento.setBounds(178, 229, 149, 23);
		}
		return jDateChooserUMAntenimiento;
	}
	

	
	private JLabel getSucursalLabel() {
		if(sucursalLabel == null) {
			sucursalLabel = new JLabel();
			sucursalLabel.setText("Sucursal");
			sucursalLabel.setFont(new java.awt.Font("Verdana",0,11));
			sucursalLabel.setBounds(5, 321, 77, 14);
		}
		return sucursalLabel;
	}
	
	private JFormattedTextField getSucursalTextField() {
		if(sucursalTextField == null) {
			sucursalTextField = new JFormattedTextField();
			sucursalTextField.setBounds(130, 319, 36, 20);
			sucursalTextField.setValue(new Integer(0));
		}
		return sucursalTextField;
	}

	private JLabel getTempMinimaLabel() {
		if(tempMinimaLabel == null) {
			tempMinimaLabel = new JLabel();
			tempMinimaLabel.setText("Temperatura Minima [grados C]");
			tempMinimaLabel.setFont(new java.awt.Font("Verdana",0,11));
			tempMinimaLabel.setBounds(5, 140, 155, 19);
		}
		return tempMinimaLabel;
	}
	
	private JFormattedTextField getTempMinimaTextField() {
		if(tempMinimaTextField == null) {
			tempMinimaTextField = new JFormattedTextField();
			tempMinimaTextField.setBounds(178, 139, 81, 21);
			tempMinimaTextField.setValue(new Float(0));
		}
		return tempMinimaTextField;
	}
	
	private JLabel getTempMaximaLabel() {
		if(tempMaximaLabel == null) {
			tempMaximaLabel = new JLabel();
			tempMaximaLabel.setText("Temperatura Maxima [grados C]");
			tempMaximaLabel.setFont(new java.awt.Font("Verdana",0,11));
			tempMaximaLabel.setBounds(5, 168, 152, 19);
		}
		return tempMaximaLabel;
	}
	
	private JFormattedTextField getTempMaximaField() {
		if(tempMaximaField == null) {
			tempMaximaField = new JFormattedTextField();
			tempMaximaField.setBounds(178, 167, 81, 21);
			tempMaximaField.setValue(new Float(0));
		}
		return tempMaximaField;
	}
	
	private JRadioButton getCamionTanqueRadioButton() {
		if(CamionTanqueRadioButton == null) {
			CamionTanqueRadioButton = new JRadioButton();
			CamionTanqueRadioButton.setText("Camion Tanque");
			CamionTanqueRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionTanqueRadioButton.setBounds(80, 73, 144, 23);
		}
		return CamionTanqueRadioButton;
	}
	
	private JRadioButton getCamionConCajaRadioButton() {
		if(CamionConCajaRadioButton == null) {
			CamionConCajaRadioButton = new JRadioButton();
			CamionConCajaRadioButton.setText("Camion C/Caja");
			CamionConCajaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionConCajaRadioButton.setBounds(126, 51, 129, 23);
		}
		return CamionConCajaRadioButton;
	}
	
	private JRadioButton getTractorRadioButton() {
		if(TractorRadioButton == null) {
			TractorRadioButton = new JRadioButton();
			TractorRadioButton.setText("Tractor");
			TractorRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			TractorRadioButton.setBounds(48, 51, 79, 23);
		}
		return TractorRadioButton;
	}
	
	private JRadioButton getCamionetaRadioButton() {
		if(CamionetaRadioButton == null) {
			CamionetaRadioButton = new JRadioButton();
			CamionetaRadioButton.setText("Camioneta");
			CamionetaRadioButton.setSelected(true);
			CamionetaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionetaRadioButton.setBounds(259, 51, 130, 23);
		}
		return CamionetaRadioButton;
	}

	private JRadioButton getOtroRadioButton() {
		if(otroRadioButton == null) {
			otroRadioButton = new JRadioButton();
			otroRadioButton.setText("Otro");
			otroRadioButton.setBounds(224, 77, 115, 18);
			otroRadioButton.setFont(new java.awt.Font("Verdana",0,11));
		}
		return otroRadioButton;
	}

	private JButton getJButtonAceptar() {
		if(jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.setBounds(278, 624, 103, 24);
			jButtonAceptar.setFont(new java.awt.Font("Verdana",0,11));
			jButtonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validacion()) {
						String tipo = "";
						if (TractorRadioButton.isSelected())
							tipo = "Tractor";
						if (CamionConCajaRadioButton.isSelected())
							tipo = "Camion con Caja";
						if (CamionetaRadioButton.isSelected())
							tipo = "Camioneta";
						if (CamionTanqueRadioButton.isSelected())
							tipo = "Camion Tanque";
						if (otroRadioButton.isSelected())
							tipo = "Otro";
						
						boolean flag = Controlador.getInstancia().altaVehiculo(tipo, patenteTextField.getText(),
								marcaTextField.getText(),String.valueOf(modeloTextField.getValue()), (Float)kmTextField.getValue(),
								(Float)Ancho.getValue(), (Float)altoTextField.getValue(), (Float)largoTextField.getValue(),
								(Float)pesoTextField.getValue(), (Float)taraTextField.getValue(), (Float)volumenTextField.getValue(), 
								jDateChooserFechaIngreso.getDate(),
								jDateChooserUMAntenimiento.getDate(),(Integer)sucursalTextField.getValue(), (Integer)sucursalTextField.getValue(), (Float)tempMinimaTextField.getValue(), 
								(Float)tempMaximaField.getValue(), (Integer)jFormattedTextField1.getValue());
						
						if (flag){
							JOptionPane.showMessageDialog(null,"Se ha dado de alta al vehiculo:" + patenteTextField.getText(), "Alta vehiculo realizada", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null,"No se ha podido dar de alta al vehiculo.", "Error", JOptionPane.ERROR_MESSAGE);	
						}
					}
				}	
			});
		}
		return jButtonAceptar;
	}
	
public boolean validacion(){
		
		if (patenteTextField.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la patente", "Atencion", JOptionPane.WARNING_MESSAGE);
			patenteTextField.requestFocus();
			return false;
		} else if(marcaTextField.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la marca.", "Atencion", JOptionPane.WARNING_MESSAGE);
			marcaTextField.requestFocus();
			return false;
		} else if (!TractorRadioButton.isSelected() && !CamionConCajaRadioButton.isSelected()  && !CamionetaRadioButton.isSelected()  && !CamionTanqueRadioButton.isSelected() && !otroRadioButton.isSelected()){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione el tipo.", "Atencion", JOptionPane.WARNING_MESSAGE);
			otroRadioButton.requestFocus();
			return false;
		} else if((Integer)modeloTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el modelo.", "Atencion", JOptionPane.WARNING_MESSAGE);
			modeloTextField.requestFocus();
			return false;
		} else if((Float)kmTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese los kilometros.", "Atencion", JOptionPane.WARNING_MESSAGE);
			kmTextField.requestFocus();
			return false;
		} else if((Float)Ancho.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el tamanio de ancho.", "Atencion", JOptionPane.WARNING_MESSAGE);
			Ancho.requestFocus();
			return false;			
		} else if((Float)largoTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el largo.", "Atencion", JOptionPane.WARNING_MESSAGE);
			largoTextField.requestFocus();
			return false;
			
		} else if((Float)altoTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el alto.", "Atencion", JOptionPane.WARNING_MESSAGE);
			altoTextField.requestFocus();
			return false;
			
		} else if((Float)taraTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la tara.", "Atencion", JOptionPane.WARNING_MESSAGE);
			taraTextField.requestFocus();
			return false;
			
		} else if((Float)volumenTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el volumen.", "Atencion", JOptionPane.WARNING_MESSAGE);
			volumenTextField.requestFocus();
			return false;
			
		
		} else if((Float)pesoTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese el peso.", "Atencion", JOptionPane.WARNING_MESSAGE);
			pesoTextField.requestFocus();
			return false;
			
		} else if((Float)tempMinimaTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la temperatura minima.", "Atencion", JOptionPane.WARNING_MESSAGE);
			tempMinimaTextField.requestFocus();
			return false;
			
		} else if((Float)tempMaximaField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la temperatura maxima.", "Atencion", JOptionPane.WARNING_MESSAGE);
			tempMaximaField.requestFocus();
			return false;
		}
		else if(jDateChooserFechaIngreso.getDate() == null){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione una fecha de ingreso.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jDateChooserFechaIngreso.requestFocus();
			return false;
		}
		else if(jDateChooserUMAntenimiento.getDate() == null){
			JOptionPane.showMessageDialog(null,"Por favor, seleccione una fecha del Ultimo Mantenimiento.", "Atencion", JOptionPane.WARNING_MESSAGE);
			jDateChooserUMAntenimiento.requestFocus();
			return false;
		}
		else if((Integer)sucursalTextField.getValue() == 0){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese una sucursal.", "Atencion", JOptionPane.WARNING_MESSAGE);
			sucursalTextField.requestFocus();
			return false;
		}
		return true;
		

}

private JLabel getPesoLabel() {
	if(pesoLabel == null) {
		pesoLabel = new JLabel();
		pesoLabel.setText("Peso [kg]");
		pesoLabel.setBounds(5, 101, 83, 14);
		pesoLabel.setFont(new java.awt.Font("Verdana",0,11));
	}
	return pesoLabel;
}

private JFormattedTextField getPesoTextField() {
	if(pesoTextField == null) {
		pesoTextField = new JFormattedTextField();
		pesoTextField.setBounds(106, 100, 57, 21);
		pesoTextField.setValue(new Float(0));
	}
	return pesoTextField;
}

private JButton getCancelarButton() {
	if(cancelarButton == null) {
		cancelarButton = new JButton();
		cancelarButton.setText("Cancelar");
		cancelarButton.setFont(new java.awt.Font("Verdana",0,11));
		cancelarButton.setBounds(389, 624, 100, 23);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
			}
		});
	}
	return cancelarButton;
}

private JButton getJButton1() {
	if(jButton1 == null) {
		jButton1 = new JButton();
		jButton1.setText("Buscar");
		jButton1.setBounds(178, 319, 69, 22);
		jButton1.setFont(new java.awt.Font("Verdana",0,11));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sucursal = Controlador.getInstancia().getSucursal((Integer)sucursalTextField.getValue());
				if(sucursal != null){
					sucursalTextField.setEnabled(false);
					jButton1.setEnabled(false);
					jLabel2.setText(sucursal.getDescripcion());
				} else {
					JOptionPane.showMessageDialog(null,"No se ha encontrado la sucursal.", "Error", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
	}
	return jButton1;
}

private JLabel getJLabel2() {
	if(jLabel2 == null) {
		jLabel2 = new JLabel();
		jLabel2.setBounds(258, 323, 216, 17);
	}
	return jLabel2;
}

private JLabel getJLabel3() {
	if(jLabel3 == null) {
		jLabel3 = new JLabel();
		jLabel3.setBounds(257, 346, 216, 19);
	}
	return jLabel3;
}

private JLabel getJLabel4() {
	if(jLabel4 == null) {
		jLabel4 = new JLabel();
		jLabel4.setText("Plan Mantenimiento");
		jLabel4.setFont(new java.awt.Font("Verdana",0,11));
		jLabel4.setBounds(5, 347, 116, 16);
	}
	return jLabel4;
}

private JFormattedTextField getJFormattedTextField1() {
	if(jFormattedTextField1 == null) {
		jFormattedTextField1 = new JFormattedTextField();
		jFormattedTextField1.setValue(new Integer(0));
		jFormattedTextField1.setBounds(130, 345, 36, 23);
	}
	return jFormattedTextField1;
}

private JButton getJButton2() {
	if(jButton2 == null) {
		jButton2 = new JButton();
		jButton2.setText("Buscar");
		jButton2.setFont(new java.awt.Font("Verdana",0,11));
		jButton2.setBounds(178, 346, 68, 22);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				plan = Controlador.getInstancia().getPlanMantenimiento((Integer)jFormattedTextField1.getValue());
				if(plan != null){
					jFormattedTextField1.setEnabled(false);
					jButton2.setEnabled(false);
					jLabel3.setText(plan.getDescripcion());
				} else {
					JOptionPane.showMessageDialog(null,"No se ha encontrado el plan.", "Error", JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
	}
	return jButton2;
}
}
