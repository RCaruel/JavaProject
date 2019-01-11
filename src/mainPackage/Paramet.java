package mainPackage;

import javax.swing.JOptionPane;

public class Paramet {
	
	
	
	 public static void main(String[] args) {
		 Composant composant = new Composant();
		 String[] Joueurs = { "2", "3", "4"};
		 JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		 String NbJoueurs = (String)JOptionPane.showInputDialog(null,
		      "Veuillez indiquer le nombre de joueurs!",
		      "KingDomino !",
		      JOptionPane.QUESTION_MESSAGE,
		      null,
		      Joueurs,
		      Joueurs[0]);
		 JOptionPane.showMessageDialog(null, "Le nombre de joueurs est " + NbJoueurs, "KingDomino", JOptionPane.INFORMATION_MESSAGE);
		    
		    int k = Integer.parseInt(NbJoueurs);
		    for (int i = 1; i<=k; i++) {
		        String[] type = {"IA", "HUMAN"};
		        JOptionPane jop21 = new JOptionPane();
		        int rang = JOptionPane.showOptionDialog(null, 
		          "Veuillez indiquer le type du joueur" + i,
		          "Joueurs " + i,
		          JOptionPane.YES_NO_CANCEL_OPTION,
		          JOptionPane.QUESTION_MESSAGE,
		          null,
		          type,
		          type[0]);
		        JOptionPane jop0 = new JOptionPane();
		        String [] couleurs = {"rouge", "bleu", "vert", "jaune"};
		        String color = (String)JOptionPane.showInputDialog(null, 
		  		      "Veuillez indiquer le nombre de joueurs!",
				      "KingDomino !",
				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      couleurs,
				      couleurs[0]);
		        String NomJoueurs = (String)JOptionPane.showInputDialog(null, "Indiquez le nom du joueur " +i , "Joueur " + i + "et sa couleur est " + color,JOptionPane.QUESTION_MESSAGE);
		        JOptionPane.showMessageDialog(null, "Le joueur " + i + "est de type " + type[rang] + " et s'apelle " + NomJoueurs + " et sa couleur est " + color , "Description du joueur", JOptionPane.INFORMATION_MESSAGE);
				composant.getListJoueurs()[i].setStatut(type[rang]);
				composant.getListJoueurs()[i].setPseudo(NomJoueurs);
				composant.getListJoueurs()[i].setCouleur(NomJoueurs);
		        
		    }		        
	}

}
