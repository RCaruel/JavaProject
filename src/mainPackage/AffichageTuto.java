package mainPackage;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class AffichageTuto extends JDialog {
	JTextArea pt, sp, fp;
	private JTabbedPane onglet = new JTabbedPane();
	
	public AffichageTuto() {
		  this.setSize(550, 350);
		  this.setTitle("Tutoriel des règles");
		  this.setLocationRelativeTo(null);
		  //this.setModal(true);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 

		  pt = new JTextArea();
		  pt.setText("Lors du premier tour 4 dominos seront tirés au hasard dans la pioche"
		  		+ " puis ils seront placés par ordre croissant puis retournais. Ensuite chaque"
		  		+ " roi seront tirais aussi au hasard. Le premier roi tiré peut choisir en premier"
		  		+ " la carte qu'il souhaite prendre, le 2e en 2e etc. Une fois que tous les joueurs"
		  		+ " ont choisi leur carte, le deuxième tour peut commencer.");
		  pt.setEditable(false);
		  pt.setFont(new Font("Serif", Font.BOLD, 16));
		  pt.setLineWrap(true);
		  pt.setWrapStyleWord(true);
		 
		  
		  
		  sp = new JTextArea();
		  sp.setText("A partir du deuxième tour tous les tours vont se dérouler de la même manière"
		  		+ " jusqu'à  épuisement des cartes dans la pioche. Des nouveaux dominos vont être "
		  		+ "tirées de la pioche puis placés dans l'ordre croissant et retournés. Ensuite,"
		  		+ " le roi sur la carte avec le plus petit indice commence par choisir une nouvelle carte. "
		  		+ "Puis chaque roi en montant dans les indices. Une fois que vous placez votre roi, prenez "
		  		+ "le domino sur lequel était placé votre roi et placez le sur votre terrain. Le terrain est"
		  		+ " de taille 5x5 dominos et comporte en son centre un château. Tous les dominos doivent être "
		  		+ "placés de sorte à ce qu’il soit en contacte avec au moins un autre dominos "
		  		+ "(ou avec le château) sans rien recouvrir et en étant totalement dans le terrain.");
		  sp.setEditable(false);
		  sp.setLineWrap(true);
		  sp.setFont(new Font("Serif", Font.BOLD, 16));
		  sp.setWrapStyleWord(true); 
		  
		  fp = new JTextArea();
		  fp.setText(" Une fois que tous les dominos ont été placés, le jeu va calculer votre score en fonction de : \r\n" + 
		  		"- du nombre de couronnes sur un bloc de terrain d'un type.\r\n" + 
		  		"- de la taille d'un bloc de terrain du même type.\r\n" + 
		  		"Le joueur avec le score le plus élevé gagne la partie.");
		  fp.setEditable(false); 
		  fp.setLineWrap(true);
		  fp.setFont(new Font("Serif", Font.BOLD, 16));
		  fp.setWrapStyleWord(true);
		    
		  onglet.addTab("Premier Tour", new JScrollPane(pt));
		  onglet.addTab("Suite Partie", new JScrollPane(sp));
		  onglet.addTab("Fin Partie", new JScrollPane(fp));
		    
		  this.getContentPane().add(onglet, BorderLayout.CENTER);
		  this.setVisible(true);
		}
	
	

}
