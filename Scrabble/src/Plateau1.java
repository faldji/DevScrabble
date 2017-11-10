

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Plateau1 extends JFrame {
	private javax.swing.JPanel Tabcases;
	javax.swing.GroupLayout jPanel1Layout;
	Color panel = new Color(0,89,85);
	Color bg = new Color(0,149,145);
	public javax.swing.JLabel nom;
	public void initialiseTableau() {
		//setup control panel
		nom = new JLabel();
		nom.setFont(new java.awt.Font("Tahoma", 8, 68)); // NOI18N
		nom.setForeground(new java.awt.Color(255, 255, 255));
		
		nom.setText("SCRABBLE");
		Tabcases = new JPanel();
		Case tc = new Case();
		//tc.setVisible(true);
		//Tabcases.add(tc);
		tc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		Tabcases.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		Tabcases.setPreferredSize(new java.awt.Dimension(1080, 1080));
		Tabcases.setBackground(panel);
		//définit un titre
		this.setTitle("Plateau de scrabble");
		//rend visible la fenêtre
		this.setVisible(true);
		//définit la taille
		this.setSize(1080, 1080);
		this.setPreferredSize(new java.awt.Dimension(1080, 1080));
		//positionne au centre
		this.setLocationRelativeTo(null);
		//ferme la fenêtre avec la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajoute les carrés de la classe case
		this.add(nom);
		this.add(Tabcases);
		this.add(tc);

		this.setBackground(bg);
      JPanel  jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel2.setBackground(bg);
        jPanel2.setPreferredSize(new java.awt.Dimension(836, 736));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(tc);
        tc.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            //.addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            //.addGap(0, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
               
                .addComponent(tc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                //.addContainerGap()
                .addComponent(tc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(0,0)
                )
        );


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(Tabcases);
        Tabcases.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                //.addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addContainerGap(245, Short.MAX_VALUE)
                )
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 400)
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 100)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tabcases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tabcases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
	
	public Plateau1(){
	initialiseTableau();	
		
		
	}    
	      
}
