package mainPackage;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Plateau {
	
    private Chateau[] tabChateau;
    private List<Domino> listeDomino;
    private int tourJoueur = 1;

    public Plateau() {
        tabChateau = new Chateau[2];
        listeDomino = new ArrayList<Domino>();
    }

    public void initGame(String j1, String j2) { //Pour 2 joeurs pour l'instant
        tabChateau[0] = new Chateau(j1, 450,600);
        tabChateau[1] = new Chateau(j2,450,300);
        listeDomino.add(new Domino(resizePicture(new ImageIcon("mines.png"), 80,80), resizePicture(new ImageIcon("water.png"),80,80), new Piece(5),new Piece(3))); //numero des pieces a prendre de la bibliotheque
        listeDomino.add(new Domino(resizePicture(new ImageIcon("desert.png"), 80,80), resizePicture(new ImageIcon("grass.png"),80,80), new Piece(5),new Piece(3)));
        
    }

    public Chateau getChateau(int indice) {
        return tabChateau[indice];
    }

    public List<Domino> getListeDomino() {
        return listeDomino;
    }

    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public int getTourJoueur() {
        return tourJoueur;
    }

    public void setTourJoueur(int tourJoueur) {
        this.tourJoueur = tourJoueur;
    }

}
