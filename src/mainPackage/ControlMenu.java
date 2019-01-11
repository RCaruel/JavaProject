package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlMenu implements ActionListener {

    //private Plateau plateau;
    private Fenetre fenetre;

    //* Constantes



    public ControlMenu(Fenetre f){
        //this.plateau = p;
        this.fenetre = f; 
        this.fenetre.setControlMenu(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quitter")){
            System.out.println("A Bientot");
            
            
        }
        if (e.getActionCommand().equals("Afficher les règles")) {
        	
        }
        
        if (e.getActionCommand().equals("Nouvelle partie")) {
        	System.out.println("okkkkkkkkkkkkkkkk");
        	fenetre.switchFrame(1);
        	fenetre.setVisible(true);
        	
        }
        if (e.getActionCommand().equals("Commencer la partie")) {
        	System.out.println("okkkk");
        	
        }

    }
}
