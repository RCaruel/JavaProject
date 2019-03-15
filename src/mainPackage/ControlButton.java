package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ControlButton implements ActionListener {
	
    private Fenetre f;
    private final Composant composant;

    /**
     * Fonction qui controle le bouton du menu principal
     * @param f accès à la fenêtre
     * @param composant accès aux données du jeu
     */
    ControlButton(Fenetre f, final Composant composant) {
        
        this.f = f;
        this.f.setControlButton(this);
        this.composant = composant;
    }

	public void actionPerformed(ActionEvent arg0) {
		// LE JEU COMMENCE QUAND ON APPUIE SUR LE BOUTON "COMMNCER LA PARTIE"
        if (Integer.valueOf(((PlateauGraphic)f.getImageMenu()).getJ1().getText()) > 1 ) {
            System.out.println("Début de la partie");
            composant.setNombreJoueurs(Integer.valueOf(((PlateauGraphic) f.getImageMenu()).getJ1().getText()));
            if (composant.getNombreJoueurs() > 4){composant.setNombreJoueurs(4);}
            System.out.println(composant.getNombreJoueurs());
            f.switchFrame(1,new Joueurs(),new ArrayList<>(), composant,0,0,0,0,0);
        }else{
            JOptionPane.showMessageDialog(f, "le nombre minimum de joueur est de 2.", "Paramétrage de la partie", JOptionPane.WARNING_MESSAGE);
        }
		
	}

}
