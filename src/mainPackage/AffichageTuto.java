package mainPackage;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class AffichageTuto extends JDialog {
	private JEditorPane pt, sp, fp;
	private JTabbedPane onglet = new JTabbedPane();
	
	public AffichageTuto() {
		  this.setSize(550, 350);
		  this.setTitle("Tutoriel des règles");
		  this.setLocationRelativeTo(null);
		  //this.setModal(true);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 

		  pt = new JEditorPane();
		  pt.setText("Lors du premier tour 4 dominos seront tirés au hasard dans la pioche"
		  		+ " puis ils seront placés par ordre croissant puis retournais. Ensuite chaque"
		  		+ " roi seront tirais aussi au hasard. Le premier roi tiré peut choisir en premier"
		  		+ " la carte qu'il souhaite prendre, le 2e en 2e etc. Une fois que tous les joueurs"
		  		+ " ont choisi leur carte, le deuxième tour peut commencer.");
		  pt.setEditable(false);
		  
		  
		  sp = new JEditorPane();
		  sp.setText("A partir du deuxième tour tous les tours vont se dérouler de la même manière"
		  		+ " jusqu'à  épuisement des cartes dans la pioche. Des nouveaux dominos vont être "
		  		+ "tirées de la pioche puis placés dans l'ordre croissant et retournés. Ensuite,"
		  		+ " le roi sur la carte avec le plus petit indice commence par choisir une nouvelle carte. "
		  		+ "Puis chaque roi en montant dans les indices. Une fois que vous placez votre roi, prenez "
		  		+ "le domino sur lequel était placé votre roi et placez le sur votre terrain. Le terrain est"
		  		+ " de taille 5x5 dominos et comporte en son centre un château. Tous les dominos doivent être "
		  		+ "placés de sorte à ce qu’il soit en contacte avec au moins un autre dominos "
		  		+ "(ou avec le château) sans rien recouvrir et en étant totalement dans le terrain.\r\n" + 
		  		" ");
		  sp.setEditable(false);
		  
		  fp = new JEditorPane();
		  fp.setText(" Une fois que tous les dominos ont été placés, le jeu va calculer votre score en fonction de : \r\n" + 
		  		"- du nombre de couronnes sur un bloc de terrain d'un type.\r\n" + 
		  		" -de la taille d'un bloc de terrain du même type.\r\n" + 
		  		"");
		  fp.setEditable(false); 
		    
		  onglet.addTab("Premier Tour", new JScrollPane(pt));
		  onglet.addTab("Suite Partie", new JScrollPane(sp));
		  onglet.addTab("Fin Partie", new JScrollPane(fp));
		    
		  this.getContentPane().add(onglet, BorderLayout.CENTER);
		  this.setVisible(true);
		}
	
	

}
