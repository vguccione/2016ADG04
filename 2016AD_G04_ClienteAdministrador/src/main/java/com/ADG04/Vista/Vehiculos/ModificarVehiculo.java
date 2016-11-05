package com.ADG04.Vista.Vehiculos;
import com.toedter.calendar.JDateChooser;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



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
public class ModificarVehiculo extends javax.swing.JFrame {
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
	private JButton buscarSucursalActualButton;
	private JButton jButton2;
	private JButton jButton1;
	private JButton buscarSucursalButton;
	private JRadioButton CamionetaRadioButton;
	private JRadioButton TractorRadioButton;
	private JRadioButton CamionConCajaRadioButton;
	private JRadioButton CamionTanqueRadioButton;
	private JTextField tempMaximaField;
	private JLabel tempMaximaLabel;
	private JTextField tempMinimaTextField;
	private JTextField sucursalActualTextField;
	private JLabel sucursalActualLabel;
	private JTextField sucursalTextField;
	private JLabel sucursalLabel;
	private JDateChooser jDateChooserFechaIngreso;
	private JLabel vencimientoGarantiaLabel;
	private JDateChooser jDateChooserUUso;
	private JDateChooser jDateChooserVGarantia;
	private JLabel uUsoLabel;
	private JDateChooser jDateChooserUMAntenimiento;
	private JLabel uMantenimientoLabel;
	private JLabel fIngresoLabel;
	private JTextField volumenTextField;
	private JTextField costoKMTextField;
	private JLabel costoKMLabel;
	private JLabel volumenLabel;
	private JTextField taraTextField;
	private JLabel taraLabel;
	private JTextField largoTextField;
	private JTextField altoTextField;
	private JLabel altoLabel;
	private JTextField Ancho;
	private JPanel jPanel2;
	private JTextField kmTextField;
	private JLabel kmLabel;
	private JTextField modeloTextField;
	private JTextField marcaTextField;
	private JLabel marcaLabel;
	private JLabel tipoLabel;
	private JTextField patenteTextField;
	private JButton buscarVehiculoButton;
	private JLabel patenteLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaVehiculo inst = new AltaVehiculo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
			}
		});
	}
	
	public ModificarVehiculo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/box.png")).getImage());
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Modificar Veh�culo");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(10, 0, 231, 40);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				getContentPane().add(getJPanel2());
				{
					patenteTextField = new JTextField();
					getContentPane().add(patenteTextField);
					patenteTextField.setBounds(122, 52, 240, 21);
				}
				{
					patenteLabel = new JLabel();
					getContentPane().add(patenteLabel);
					getContentPane().add(getBuscarVehiculoButton());
					patenteLabel.setText("Patente");
					patenteLabel.setFont(new java.awt.Font("Verdana",0,11));
					patenteLabel.setBounds(12, 54, 96, 15);
				}
				jPanel1.setLayout(null);
				jPanel1.setBounds(12, 128, 374, 145);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Datos del veh�culo"
						+ ""));
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
					tipoLabel.setText("Tipo");
					tipoLabel.setBounds(10, 25, 75, 36);
					tipoLabel.setFont(new java.awt.Font("Verdana",0,11));
				}
			}
			pack();
			this.setSize(409, 720);
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
			marcaLabel.setBounds(10, 80, 43, 14);
		}
		return marcaLabel;
	}
	
	private JTextField getMarcaTextField() {
		if(marcaTextField == null) {
			marcaTextField = new JTextField();
			marcaTextField.setBounds(85, 77, 243, 21);
		}
		return marcaTextField;
	}
	
	private JLabel getModeloLabel() {
		if(modeloLabel == null) {
			modeloLabel = new JLabel();
			modeloLabel.setText("Modelo");
			modeloLabel.setFont(new java.awt.Font("Verdana",0,11));
			modeloLabel.setBounds(10, 112, 66, 14);
		}
		return modeloLabel;
	}
	
	private JTextField getModeloTextField() {
		if(modeloTextField == null) {
			modeloTextField = new JTextField();
			modeloTextField.setBounds(85, 109, 59, 21);
		}
		return modeloTextField;
	}
	
	private JLabel getKmLabel() {
		if(kmLabel == null) {
			kmLabel = new JLabel();
			kmLabel.setText("Kil�metros");
			kmLabel.setFont(new java.awt.Font("Verdana",0,11));
			kmLabel.setBounds(192, 112, 66, 14);
		}
		return kmLabel;
	}
	
	private JTextField getKmTextField() {
		if(kmTextField == null) {
			kmTextField = new JTextField();
			kmTextField.setBounds(264, 109, 63, 21);
		}
		return kmTextField;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createTitledBorder("Caracter�sticas del Veh�culo"));
			jPanel2.setBounds(17, 287, 372, 333);
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
			jPanel2.add(getCostoKMLabel());
			jPanel2.add(getCostoKMTextField());
			jPanel2.add(getjDateChooserFechaIngreso());
			jPanel2.add(getFIngresoLabel());
			jPanel2.add(getUMantenimientoLabel());
			jPanel2.add(getjDateChooserUMAntenimiento());
			jPanel2.add(getUUsoLabel());
			jPanel2.add(getjDateChooserUUso());
			jPanel2.add(getjDateChooserVGarantia());
			jPanel2.add(getVencimientoGarantiaLabel());
			jPanel2.add(getSucursalLabel());
			jPanel2.add(getSucursalTextField());
			jPanel2.add(getSucursalActualLabel());
			jPanel2.add(getSucursalActualTextField());
			jPanel2.add(getTempMinimaLabel());
			jPanel2.add(getTempMinimaTextField());
			jPanel2.add(getTempMaximaLabel());
			jPanel2.add(getTempMaximaField());
			jPanel2.add(getBuscarSucursalButton());
			jPanel2.add(getJButton1());
			jPanel2.add(getJButton2());
			jPanel2.add(getBuscarSucursalActualButton());
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
	
	private JTextField getAncho() {
		if(Ancho == null) {
			Ancho = new JTextField();
			Ancho.setBounds(106, 21, 57, 21);
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
	
	private JTextField getAltoTextField() {
		if(altoTextField == null) {
			altoTextField = new JTextField();
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
	
	private JTextField getLargoTextField() {
		if(largoTextField == null) {
			largoTextField = new JTextField();
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
	
	private JTextField getTaraTextField() {
		if(taraTextField == null) {
			taraTextField = new JTextField();
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
	
	private JTextField getVolumenTextField() {
		if(volumenTextField == null) {
			volumenTextField = new JTextField();
			volumenTextField.setBounds(106, 73, 57, 21);
		}
		return volumenTextField;
	}
	
	private JLabel getCostoKMLabel() {
		if(costoKMLabel == null) {
			costoKMLabel = new JLabel();
			costoKMLabel.setText("Costo KM [$]");
			costoKMLabel.setFont(new java.awt.Font("Verdana",0,11));
			costoKMLabel.setBounds(181, 75, 86, 14);
		}
		return costoKMLabel;
	}
	
	private JTextField getCostoKMTextField() {
		if(costoKMTextField == null) {
			costoKMTextField = new JTextField();
			costoKMTextField.setBounds(274, 73, 62, 21);
		}
		return costoKMTextField;
	}
	
	private JDateChooser getjDateChooserFechaIngreso() {
		if(jDateChooserFechaIngreso == null) {
			jDateChooserFechaIngreso = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserFechaIngreso.setDateFormatString("dd/MM/yyyy");
			jDateChooserFechaIngreso.setBounds(175, 159, 87, 23);
		}
		return jDateChooserFechaIngreso;
	}
	
	private JLabel getFIngresoLabel() {
		if(fIngresoLabel == null) {
			fIngresoLabel = new JLabel();
			fIngresoLabel.setText("Fecha Ingreso");
			fIngresoLabel.setFont(new java.awt.Font("Verdana",0,11));
			fIngresoLabel.setBounds(14, 159, 135, 23);
		}
		return fIngresoLabel;
	}
	
	private JLabel getUMantenimientoLabel() {
		if(uMantenimientoLabel == null) {
			uMantenimientoLabel = new JLabel();
			uMantenimientoLabel.setText("�ltimo Mantenimiento");
			uMantenimientoLabel.setFont(new java.awt.Font("Verdana",0,11));
			uMantenimientoLabel.setBounds(14, 188, 130, 23);
		}
		return uMantenimientoLabel;
	}
	
	private JDateChooser getjDateChooserUMAntenimiento() {
		if(jDateChooserUMAntenimiento == null) {
			jDateChooserUMAntenimiento = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserUMAntenimiento.setDateFormatString("dd/MM/yyyy");
			jDateChooserUMAntenimiento.setBounds(175, 188, 87, 23);
		}
		return jDateChooserUMAntenimiento;
	}
	
	private JLabel getUUsoLabel() {
		if(uUsoLabel == null) {
			uUsoLabel = new JLabel();
			uUsoLabel.setText("�ltimo Uso");
			uUsoLabel.setFont(new java.awt.Font("Verdana",0,11));
			uUsoLabel.setBounds(14, 217, 123, 23);
		}
		return uUsoLabel;
	}
	
	private JDateChooser getjDateChooserVGarantia() {
		if(jDateChooserVGarantia == null) {
			jDateChooserVGarantia = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserVGarantia.setDateFormatString("dd/MM/yyyy");
			jDateChooserVGarantia.setBounds(175, 243, 87, 23);
		}
		return jDateChooserVGarantia;
	}
	
	private JDateChooser getjDateChooserUUso() {
		if(jDateChooserUUso == null) {
			jDateChooserUUso = new JDateChooser("dd/MM/yyyy","##-##-####",'-');
			jDateChooserUUso.setDateFormatString("dd/MM/yyyy");
			jDateChooserUUso.setBounds(175, 217, 87, 23);
		}
		return jDateChooserUUso;
	}
	
	private JLabel getVencimientoGarantiaLabel() {
		if(vencimientoGarantiaLabel == null) {
			vencimientoGarantiaLabel = new JLabel();
			vencimientoGarantiaLabel.setText("Vencimiento Garant�a");
			vencimientoGarantiaLabel.setBounds(14, 246, 123, 23);
			vencimientoGarantiaLabel.setFont(new java.awt.Font("Verdana",0,11));
		}
		return vencimientoGarantiaLabel;
	}
	
	private JLabel getSucursalLabel() {
		if(sucursalLabel == null) {
			sucursalLabel = new JLabel();
			sucursalLabel.setText("Sucursal");
			sucursalLabel.setFont(new java.awt.Font("Verdana",0,11));
			sucursalLabel.setBounds(8, 280, 77, 14);
		}
		return sucursalLabel;
	}
	
	private JTextField getSucursalTextField() {
		if(sucursalTextField == null) {
			sucursalTextField = new JTextField();
			sucursalTextField.setBounds(127, 278, 125, 20);
		}
		return sucursalTextField;
	}
	
	private JLabel getSucursalActualLabel() {
		if(sucursalActualLabel == null) {
			sucursalActualLabel = new JLabel();
			sucursalActualLabel.setText("Sucursal Actual");
			sucursalActualLabel.setFont(new java.awt.Font("Verdana",0,11));
			sucursalActualLabel.setBounds(8, 306, 101, 14);
		}
		return sucursalActualLabel;
	}
	
	private JTextField getSucursalActualTextField() {
		if(sucursalActualTextField == null) {
			sucursalActualTextField = new JTextField();
			sucursalActualTextField.setBounds(127, 304, 125, 21);
		}
		return sucursalActualTextField;
	}
	
	private JLabel getTempMinimaLabel() {
		if(tempMinimaLabel == null) {
			tempMinimaLabel = new JLabel();
			tempMinimaLabel.setText("Temperatura M�nima [�C]");
			tempMinimaLabel.setFont(new java.awt.Font("Verdana",0,11));
			tempMinimaLabel.setBounds(5, 101, 158, 18);
		}
		return tempMinimaLabel;
	}
	
	private JTextField getTempMinimaTextField() {
		if(tempMinimaTextField == null) {
			tempMinimaTextField = new JTextField();
			tempMinimaTextField.setBounds(175, 98, 81, 21);
		}
		return tempMinimaTextField;
	}
	
	private JLabel getTempMaximaLabel() {
		if(tempMaximaLabel == null) {
			tempMaximaLabel = new JLabel();
			tempMaximaLabel.setText("Temperatura M�xima [�C]");
			tempMaximaLabel.setFont(new java.awt.Font("Verdana",0,11));
			tempMaximaLabel.setBounds(5, 129, 152, 18);
		}
		return tempMaximaLabel;
	}
	
	private JTextField getTempMaximaField() {
		if(tempMaximaField == null) {
			tempMaximaField = new JTextField();
			tempMaximaField.setBounds(175, 126, 81, 21);
		}
		return tempMaximaField;
	}
	
	private JRadioButton getCamionTanqueRadioButton() {
		if(CamionTanqueRadioButton == null) {
			CamionTanqueRadioButton = new JRadioButton();
			CamionTanqueRadioButton.setText("Cami�n Tanque");
			CamionTanqueRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionTanqueRadioButton.setBounds(88, 45, 126, 23);
		}
		return CamionTanqueRadioButton;
	}
	
	private JRadioButton getCamionConCajaRadioButton() {
		if(CamionConCajaRadioButton == null) {
			CamionConCajaRadioButton = new JRadioButton();
			CamionConCajaRadioButton.setText("Cami�n C/Caja");
			CamionConCajaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionConCajaRadioButton.setBounds(225, 21, 128, 23);
		}
		return CamionConCajaRadioButton;
	}
	
	private JRadioButton getTractorRadioButton() {
		if(TractorRadioButton == null) {
			TractorRadioButton = new JRadioButton();
			TractorRadioButton.setText("Tractor");
			TractorRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			TractorRadioButton.setBounds(88, 21, 99, 23);
		}
		return TractorRadioButton;
	}
	
	private JRadioButton getCamionetaRadioButton() {
		if(CamionetaRadioButton == null) {
			CamionetaRadioButton = new JRadioButton();
			CamionetaRadioButton.setText("Camioneta");
			CamionetaRadioButton.setSelected(true);
			CamionetaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
			CamionetaRadioButton.setBounds(225, 45, 128, 23);
		}
		return CamionetaRadioButton;
	}
	
	private JButton getBuscarSucursalButton() {
		if(buscarSucursalButton == null) {
			buscarSucursalButton = new JButton();
			buscarSucursalButton.setText("Buscar");
			buscarSucursalButton.setBounds(264, 278, 55, 21);
		}
		return buscarSucursalButton;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Buscar");
			jButton1.setBounds(264, 278, 55, 21);
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Buscar");
			jButton2.setBounds(264, 278, 55, 21);
		}
		return jButton2;
	}
	
	private JButton getBuscarSucursalActualButton() {
		if(buscarSucursalActualButton == null) {
			buscarSucursalActualButton = new JButton();
			buscarSucursalActualButton.setText("Buscar");
			buscarSucursalActualButton.setBounds(264, 304, 55, 21);
		}
		return buscarSucursalActualButton;
	}
	
	private JButton getBuscarVehiculoButton() {
		if(buscarVehiculoButton == null) {
			buscarVehiculoButton = new JButton();
			buscarVehiculoButton.setText("Buscar Veh�culo");
			buscarVehiculoButton.setBounds(192, 79, 163, 27);
			buscarVehiculoButton.setFont(new java.awt.Font("Verdana",0,11));
		}
		return buscarVehiculoButton;
	}

}
