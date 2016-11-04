package com.ADG04.Vista.Vehiculos;
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
public class ModificarPlanMantenimiento extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JLabel idPlanMantenimientoLabel;
	private JButton buscarPlanMantenimientoButton;
	private JPanel jPanel1;
	private JRadioButton CamionetaRadioButton;
	private JTextField toleranciaTextField;
	private JLabel descripcionLabel;
	private JLabel toleranciaLabel;
	private JTextField descripcionTextField;
	private JLabel tipoLabel;
	private JRadioButton TractorRadioButton;
	private JRadioButton CamionTanqueRadioButton;
	private JRadioButton CamionConCajaRadioButton;
	private JTextField idPlanMantenimientoTextField;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificarPlanMantenimiento inst = new ModificarPlanMantenimiento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarPlanMantenimiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(433, 387);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 10");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/box.png")).getImage());
			this.setResizable(false);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Modificar Plan de Mantenimiento");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 408, 40);
			}
			{
				idPlanMantenimientoLabel = new JLabel();
				getContentPane().add(idPlanMantenimientoLabel);
				idPlanMantenimientoLabel.setText("ID Plan Mantenimiento");
				idPlanMantenimientoLabel.setBounds(12, 58, 118, 14);
			}
			{
				idPlanMantenimientoTextField = new JTextField();
				getContentPane().add(idPlanMantenimientoTextField);
				idPlanMantenimientoTextField.setBounds(148, 55, 210, 21);
			}
			{
				buscarPlanMantenimientoButton = new JButton();
				getContentPane().add(buscarPlanMantenimientoButton);
				buscarPlanMantenimientoButton.setText("Buscar Plan Mantenimiento");
				buscarPlanMantenimientoButton.setBounds(160, 88, 198, 21);
				buscarPlanMantenimientoButton.setFont(new java.awt.Font("Verdana",0,11));
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Caracter�sticas del Plan de Mantenimiento"));
				jPanel1.setLayout(null);
				jPanel1.setBounds(24, 120, 396, 203);
				{
					CamionetaRadioButton = new JRadioButton();
					jPanel1.add(CamionetaRadioButton);
					CamionetaRadioButton.setText("Camioneta");
					CamionetaRadioButton.setSelected(true);
					CamionetaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					CamionetaRadioButton.setBounds(263, 54, 128, 23);
				}
				{
					CamionConCajaRadioButton = new JRadioButton();
					jPanel1.add(CamionConCajaRadioButton);
					CamionConCajaRadioButton.setText("Cami�n C/Caja");
					CamionConCajaRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					CamionConCajaRadioButton.setBounds(263, 31, 128, 23);
				}
				{
					CamionTanqueRadioButton = new JRadioButton();
					jPanel1.add(CamionTanqueRadioButton);
					CamionTanqueRadioButton.setText("Cami�n Tanque");
					CamionTanqueRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					CamionTanqueRadioButton.setBounds(124, 54, 134, 23);
				}
				{
					TractorRadioButton = new JRadioButton();
					jPanel1.add(TractorRadioButton);
					TractorRadioButton.setText("Tractor");
					TractorRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					TractorRadioButton.setBounds(124, 30, 99, 23);
				}
				{
					tipoLabel = new JLabel();
					jPanel1.add(tipoLabel);
					tipoLabel.setText("Tipo Veh�culo");
					tipoLabel.setFont(new java.awt.Font("Verdana",0,11));
					tipoLabel.setBounds(17, 30, 107, 36);
				}
				{
					descripcionLabel = new JLabel();
					jPanel1.add(descripcionLabel);
					descripcionLabel.setText("Descripci�n");
					descripcionLabel.setFont(new java.awt.Font("Verdana",0,11));
					descripcionLabel.setBounds(17, 103, 77, 14);
				}
				{
					descripcionTextField = new JTextField();
					jPanel1.add(descripcionTextField);
					descripcionTextField.setBounds(124, 100, 220, 47);
				}
				{
					toleranciaLabel = new JLabel();
					jPanel1.add(toleranciaLabel);
					toleranciaLabel.setText("Tolerancia");
					toleranciaLabel.setBounds(17, 161, 77, 14);
					toleranciaLabel.setFont(new java.awt.Font("Verdana",0,11));
				}
				{
					toleranciaTextField = new JTextField();
					jPanel1.add(toleranciaTextField);
					toleranciaTextField.setBounds(124, 158, 81, 21);
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
