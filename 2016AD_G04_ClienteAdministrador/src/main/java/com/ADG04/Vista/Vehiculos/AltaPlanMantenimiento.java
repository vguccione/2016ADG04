package com.ADG04.Vista.Vehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.ADG04.Controller.Controlador;


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
public class AltaPlanMantenimiento extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JPanel jPanel1;
	private JButton cancelarButton;
	private JLabel descripcionLabel;
	private JTextArea comentariosTextArea;
	private JTextArea descripcionTextArea;
	private JLabel comentariosLabel;
	private JButton aceptarButton;
	private JFormattedTextField toleranciaTextField;
	private JLabel toleranciaLabel;


	public AltaPlanMantenimiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Aplicaciones Distribuidas - TPO Grupo: 04");
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Alta Plan de Mantenimiento");
				jLabelTitulo.setFont(new java.awt.Font("Verdana",1,20));
				jLabelTitulo.setBounds(19, 12, 380, 40);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setLayout(null);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Caracteristicas del Plan de Mantenimiento"));
				jPanel1.setBounds(19, 58, 373, 205);
				{
					descripcionLabel = new JLabel();
					jPanel1.add(descripcionLabel);
					descripcionLabel.setText("Descripcion");
					descripcionLabel.setBounds(17, 32, 77, 14);
					descripcionLabel.setFont(new java.awt.Font("Verdana",0,11));
				}

				{
					comentariosLabel = new JLabel();
					jPanel1.add(comentariosLabel);
					comentariosLabel.setText("Comentarios");
					comentariosLabel.setBounds(17, 122, 90, 14);
					comentariosLabel.setFont(new java.awt.Font("Verdana",0,11));
				}
				{
					descripcionTextArea = new JTextArea();
					jPanel1.add(descripcionTextArea);
					descripcionTextArea.setBounds(124, 31, 218, 50);
					descripcionTextArea.setBorder(null);
				}
				{
					comentariosTextArea = new JTextArea();
					jPanel1.add(comentariosTextArea);
					comentariosTextArea.setBounds(125, 121, 217, 47);
				}
			}
			{
				aceptarButton = new JButton();
				getContentPane().add(aceptarButton);
				aceptarButton.setText("Aceptar");
				aceptarButton.setBounds(169, 275, 100, 21);
				aceptarButton.setFont(new java.awt.Font("Verdana",0,11));
				aceptarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (validacion()) {
							boolean flag = Controlador.getInstancia().altaPlanMantenimiento(descripcionTextArea.getText(), comentariosTextArea.getText());
							if(flag){
								JOptionPane.showMessageDialog(null,"Se ha dado de alta al Plan de Mantenimiento:" + descripcionTextArea.getText(), "Alta plan de mantenimiento realizada", JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null,"No se ha podido dar de alta al plan de mantenimiento.", "Error", JOptionPane.ERROR_MESSAGE);	
							}
						}
					}
				});
				}
			{
				cancelarButton = new JButton();
				getContentPane().add(cancelarButton);
				cancelarButton.setText("Cancelar");
				cancelarButton.setFont(new java.awt.Font("Verdana",0,11));
				cancelarButton.setBounds(285, 275, 97, 21);
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						setVisible(false);
					}
				});
			}
			pack();
			this.setSize(412, 346);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public boolean validacion(){
	
		if(descripcionTextArea.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese la descripcion.", "Atencion", JOptionPane.WARNING_MESSAGE);
			descripcionTextArea.requestFocus();
			return false;
		}
		else if(comentariosTextArea.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Por favor, ingrese los comentarios.", "Atencion", JOptionPane.WARNING_MESSAGE);
			comentariosTextArea.requestFocus();
			return false;
		}
		return true;
	}

}
