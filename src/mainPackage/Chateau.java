package mainPackage;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Chateau {
	
	 private String nomJoueur;
	    private List<Domino> listeDomino;
	    private Image img;
	    private int x;
	    private int y;
	    private final int  tailleX = 100;
	    private final int  tailleY = 100;


	    public Chateau(String nomJoueur, int x, int y) {
	        this.nomJoueur = nomJoueur;
	        listeDomino = new ArrayList<Domino>();
	        ImageIcon imgTmp = new ImageIcon("chateau.jpg");
	        img = resizePicture(imgTmp, 100,100).getImage();
	        this.x = x;
	        this.y = y;
	    }

	    public String getNomJoueur() {
	        return nomJoueur;
	    }

	    public void setNomJoueur(String nomJoueur) {
	        this.nomJoueur = nomJoueur;
	    }

	    public List<Domino> getListeDomino() {
	        return listeDomino;
	    }

	    public void setListeDomino(List<Domino> listeDomino) {
	        this.listeDomino = listeDomino;
	    }

	    public Image getImg() {
	        return img;
	    }

	    public void setImg(Image img) {
	        this.img = img;
	    }

	    public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }
	    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }

}
