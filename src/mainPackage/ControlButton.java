package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ControlButton implements ActionListener {
	
    private Fenetre f;
    private final Composant composant;

    public ControlButton(Fenetre f, final Composant composant) {
        
        this.f = f;
        this.f.setControlButton(this);
        this.composant = composant;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// LE JEU COMMENCE QUAND ON APPUIE SUR LE BOUTON "COMMNCER LA PARTIE"
        if (Integer.valueOf(((PlateauGraphic)f.getImageMenu()).getJ1().getText()) > 1 ) {
            System.out.println("D�but de la partie");
            composant.setNombreJoueurs(Integer.valueOf(((PlateauGraphic) f.getImageMenu()).getJ1().getText()));
            System.out.println(composant.getNombreJoueurs());
            f.switchFrame(1,new Joueurs(),new ArrayList<Integer>(), composant,0,0,0,0,0);
        }else{
            JOptionPane.showMessageDialog(f, "le nombre minimum de joueur est de 2.", "Param�trage de la partie", JOptionPane.WARNING_MESSAGE);
        }
		
	}

}
