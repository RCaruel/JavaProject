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
		  this.setTitle("Tutoriel des r�gles");
		  this.setLocationRelativeTo(null);
		  //this.setModal(true);
		  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 

		  pt = new JTextArea();
		  pt.setText("Lors du premier tour 4 dominos seront tir�s au hasard dans la pioche"
		  		+ " puis ils seront plac�s par ordre croissant puis retournais. Ensuite chaque"
		  		+ " roi seront tirais aussi au hasard. Le premier roi tir� peut choisir en premier"
		  		+ " la carte qu'il souhaite prendre, le 2e en 2e etc. Une fois que tous les joueurs"
		  		+ " ont choisi leur carte, le deuxi�me tour peut commencer.");
		  pt.setEditable(false);
		  pt.setFont(new Font("Serif", Font.BOLD, 16));
		  pt.setLineWrap(true);
		  pt.setWrapStyleWord(true);
		 
		  
		  
		  sp = new JTextArea();
		  sp.setText("A partir du deuxi�me tour tous les tours vont se d�rouler de la m�me mani�re"
		  		+ " jusqu'�  �puisement des cartes dans la pioche. Des nouveaux dominos vont �tre "
		  		+ "tir�es de la pioche puis plac�s dans l'ordre croissant et retourn�s. Ensuite,"
		  		+ " le roi sur la carte avec le plus petit indice commence par choisir une nouvelle carte. "
		  		+ "Puis chaque roi en montant dans les indices. Une fois que vous placez votre roi, prenez "
		  		+ "le domino sur lequel �tait plac� votre roi et placez le sur votre terrain. Le terrain est"
		  		+ " de taille 5x5 dominos et comporte en son centre un ch�teau. Tous les dominos doivent �tre "
		  		+ "plac�s de sorte � ce qu�il soit en contacte avec au moins un autre dominos "
		  		+ "(ou avec le ch�teau) sans rien recouvrir et en �tant totalement dans le terrain.");
		  sp.setEditable(false);
		  sp.setLineWrap(true);
		  sp.setFont(new Font("Serif", Font.BOLD, 16));
		  sp.setWrapStyleWord(true); 
		  
		  fp = new JTextArea();
		  fp.setText(" Une fois que tous les dominos ont �t� plac�s, le jeu va calculer votre score en fonction de : \r\n" + 
		  		"- du nombre de couronnes sur un bloc de terrain d'un type.\r\n" + 
		  		"- de la taille d'un bloc de terrain du m�me type.\r\n" + 
		  		"Le joueur avec le score le plus �lev� gagne la partie.");
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
