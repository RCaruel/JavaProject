package mainPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ControlMouse implements MouseListener {

    private Plateau plateau;
    private Fenetre fenetre;
    private int caseClicked;
    
    
    

    public ControlMouse(Plateau p, Fenetre f){
        this.plateau = p;
        this.fenetre = f;
        this.fenetre.setControlClick(this);

    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        //A FINIR
        }

    

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void initCasesPetitPlateau(){

    }


}
