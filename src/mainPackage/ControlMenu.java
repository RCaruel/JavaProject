package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlMenu implements ActionListener {

    private Plateau plateau;
    private Fenetre fenetre;

    //* Constantes



    public ControlMenu(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlMenu(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quitter")){
            System.out.println("A Bientot");
            System.exit(0);
            //fenetre.switchFrame();
        }

    }
}
