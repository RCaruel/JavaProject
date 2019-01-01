package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControlButton implements ActionListener {

    private Plateau p;
    private Fenetre f;

    public ControlButton(Plateau p, Fenetre f) {
        this.p = p;
        this.f = f;
        this.f.setControlButton(this);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// CODE POUR COMMENCER LE JEU QUAND ON APPUIE SUR LE BOUTON "COMMNCER LA PARTIE"
		
		System.out.println("Début de la partie");
        f.switchFrame();
        String j1 = ((PlateauGraphic)f.getImageMenu()).getJ1().getText();
        if (j1.length() == 0)
            j1 = "Joueur 1";
        String j2 = ((PlateauGraphic)f.getImageMenu()).getJ2().getText();
        if (j2.length() == 0)
            j2 = "Joueur 2";
        System.out.println("Le joueur 1 s'appele : " + j1 );
        System.out.println("Le joueur 2 s'appele : " + j2 );
        p.initGame(j1, j2);
        Chateau cht1 = p.getChateau(0);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(cht1);
        Domino domino = p.getListeDomino().get(1);
        ((PlateauJeuGraphic)f.getImagePlateau()).addSpritToDisplay(domino);
        ((PlateauJeuGraphic)f.getImagePlateau()).repaint();
    
        //SUITE A FAIRE 
        
		
	}

}
