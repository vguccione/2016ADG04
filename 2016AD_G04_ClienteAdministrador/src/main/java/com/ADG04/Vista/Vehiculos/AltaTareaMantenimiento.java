package com.ADG04.Vista.Vehiculos;
import javax.swing.BorderFactory;
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
public class AltaTareaMantenimiento extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JPanel jPanel1;
	private JTextField cantDiasTextField;
	private JLabel cantDiasLabel;
	private JLabel cantKMLabel;
	private JTextField porKMTextField;
	private JLabel tareaLabel;
	private JRadioButton PorKilometroRadioButton;
	private JRadioButton PorTiempoRadioButton;
	private JLabel tipoLabel;
	private JTextField patenteTextField;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AltaTareaMantenimiento inst = new AltaTareaMantenimiento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaTareaMantenimiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Alta Tarea Mantenimiento");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(12, 12, 353, 40);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Ingrese datos de la tarea de mantenimiento"));
				jPanel1.setLayout(null);
				jPanel1.setBounds(12, 58, 368, 159);
				{
					patenteTextField = new JTextField();
					jPanel1.add(patenteTextField);
					patenteTextField.setBounds(68, 25, 252, 21);
				}
				{
					tipoLabel = new JLabel();
					jPanel1.add(tipoLabel);
					tipoLabel.setText("Tipo");
					tipoLabel.setFont(new java.awt.Font("Verdana",0,11));
					tipoLabel.setBounds(5, 52, 75, 14);
				}
				{
					PorTiempoRadioButton = new JRadioButton();
					jPanel1.add(PorTiempoRadioButton);
					PorTiempoRadioButton.setText("Por Tiempo");
					PorTiempoRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					PorTiempoRadioButton.setBounds(53, 93, 112, 23);
				}
				{
					PorKilometroRadioButton = new JRadioButton();
					jPanel1.add(PorKilometroRadioButton);
					PorKilometroRadioButton.setText("Por Kilometro");
					PorKilometroRadioButton.setFont(new java.awt.Font("Verdana",0,11));
					PorKilometroRadioButton.setBounds(53, 64, 98, 16);
				}
				{
					tareaLabel = new JLabel();
					jPanel1.add(tareaLabel);
					tareaLabel.setText("Tarea");
					tareaLabel.setFont(new java.awt.Font("Verdana",0,11));
					tareaLabel.setBounds(5, 28, 63, 14);
				}
				{
					porKMTextField = new JTextField();
					jPanel1.add(porKMTextField);
					porKMTextField.setBounds(267, 62, 53, 21);
				}
				{
					cantKMLabel = new JLabel();
					jPanel1.add(cantKMLabel);
					cantKMLabel.setText("Cantidad KM:");
					cantKMLabel.setFont(new java.awt.Font("Verdana",0,11));
					cantKMLabel.setBounds(178, 65, 83, 14);
				}
				{
					cantDiasLabel = new JLabel();
					jPanel1.add(cantDiasLabel);
					cantDiasLabel.setText("Cantidad Dias:");
					cantDiasLabel.setFont(new java.awt.Font("Verdana",0,11));
					cantDiasLabel.setBounds(176, 98, 85, 14);
				}
				{
					cantDiasTextField = new JTextField();
					jPanel1.add(cantDiasTextField);
					cantDiasTextField.setBounds(267, 95, 53, 21);
				}
			}
			pack();
			this.setSize(400, 299);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
