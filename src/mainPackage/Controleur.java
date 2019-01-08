package mainPackage;

public class Controleur {
	
	public Controleur() {
        Fenetre f = new Fenetre();
        //new ControlMouse(p,f);
        new ControlMenu(f);
        new ControlButton(f);
       // f.setContentPane(new MoveComponents());
        f.setVisible(true);
    }

}
