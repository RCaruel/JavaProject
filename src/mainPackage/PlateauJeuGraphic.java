package mainPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PlateauJeuGraphic extends JPanel {
	
	  private Image imgBg;
	    private JButton button;
	    private Image imgHeader;
	    private ArrayList<Object> listDeSpriteTemporaire; //* listes des sprites à afficher
	    private ArrayList<Object> listDeSprite; //* listes des sprites temporaire à afficher



	    public PlateauJeuGraphic(){
	     // imgBg = img;
	        ImageIcon imgTmp = new ImageIcon("parchemin.jpg");
	        imgBg = resizePicture(imgTmp, 990,990).getImage();
	        listDeSprite = new ArrayList<Object>();
	        listDeSpriteTemporaire = new ArrayList<Object>();


	    }

	    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }

	    public void addSpritToDisplay(Object s){
	        listDeSprite.add(s);
	    }
	    public void clearAllSprite(){
	        listDeSprite.clear();
	    }

	    public void addTemporaireSpritToDisplay(Object s){
	        listDeSpriteTemporaire.add(s);
	    }
	    public void clearAllSpriteTemporaire(){
	        listDeSpriteTemporaire.clear();
	    }

}
