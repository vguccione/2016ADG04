package com.ADG04.Vista;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
//import javax.swing.SwingUtilities;


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
@SuppressWarnings("serial")
public class VistaAcercaDe extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jLabelSubtitulo2;
	private JLabel jLabelLogo;
	private JLabel jLabelAlumnos;
	private JLabel jLabelSubtitulo;
	private JLabel jLabelTitulo;
	private JLabel jLabelAlumno5;
	private JLabel jLabelAlumno4;
	private JLabel jLabelAlumno3;
	private JLabel jLabelAlumno2;
	private JLabel jLabelAlumno1;


	/*public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AcercaDe inst = new AcercaDe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public VistaAcercaDe() {
		super();
		initGUI();
	}
	

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/box.png")).getImage());
			this.setResizable(false);
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("Aplicaciones Distribuidas 2016- TPO Grupo: 04");
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					jLabelAlumno1 = new JLabel();
					jLabelAlumno1.setText("Corvetto, Dana - LU: 1052130");
					jLabelAlumno1.setLayout(null);
				}
				{
					jLabelAlumno2 = new JLabel();
					jLabelAlumno2.setText("Guccione, Vanesa - LU: 1014369");
					jLabelAlumno2.setLayout(null);
				}
				{
					jLabelAlumno3 = new JLabel();
					jLabelAlumno3.setText("Roncoroni, Veronica - LU: 124832");
					jLabelAlumno3.setLayout(null);
				}
				
				{
					jLabelTitulo = new JLabel();
					jLabelTitulo.setText("Aplicaciones Distribuidas");
					jLabelTitulo.setLayout(null);
					jLabelTitulo.setFont(new java.awt.Font("Tahoma",1,16));
				}
				{
					jLabelSubtitulo2 = new JLabel();
					jLabelSubtitulo2.setText("2016 2do Cuatrimestre");
					jLabelSubtitulo2.setLayout(null);
					jLabelSubtitulo2.setFont(new java.awt.Font("Tahoma",1,12));
				}
				{
					jLabelLogo = new JLabel();
					jLabelLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("com/ADG04/Images/logoUade.jpg")));
					jLabelLogo.setLayout(null);
				}
				{
					jLabelSubtitulo = new JLabel();
					jLabelSubtitulo.setText("Trabajo Practico Obligatorio");
					jLabelSubtitulo.setLayout(null);
					jLabelSubtitulo.setFont(new java.awt.Font("Tahoma",1,14));
				}
				{
					jLabelAlumnos = new JLabel();
					jLabelAlumnos.setText("Alumnos");
					jLabelAlumnos.setLayout(null);
					jLabelAlumnos.setFont(new java.awt.Font("Tahoma",1,11));
				}
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelSubtitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelSubtitulo2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jLabelAlumnos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jLabelAlumno3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED));
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(jLabelSubtitulo2, GroupLayout.Alignment.LEADING, 0, 482, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumnos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					        .addGap(16)
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(jLabelTitulo, GroupLayout.Alignment.LEADING, 0, 261, Short.MAX_VALUE)
					            .addComponent(jLabelSubtitulo, GroupLayout.Alignment.LEADING, 0, 261, Short.MAX_VALUE)
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addGap(32)
					                .addComponent(jLabelLogo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 29, Short.MAX_VALUE)))
					        .addGap(54))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 170, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 181, Short.MAX_VALUE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabelAlumno3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 195, Short.MAX_VALUE)))
					.addContainerGap());
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel1, 0, 343, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addComponent(jPanel1, 0, 402, Short.MAX_VALUE));
		//	pack();
			this.setSize(408, 271);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
}