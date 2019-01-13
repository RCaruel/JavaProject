package mainPackage;

public class Controleur {
	
	public Controleur() {
	    Composant composant = new Composant();
        Fenetre f = new Fenetre(composant);

        new ControlButton(f, composant);

        f.setVisible(true);
    }

}
