package mainPackage;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class PlateauJeuGraphic extends JPanel {
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imgBg;
	  private Image imgBg2;
	  //private Plateau p;
	  //private JButton button;
	  //private Image imgHeader;


	    public PlateauJeuGraphic(){
	    	
	     // imgBg = img;
	        ImageIcon imgTmp = new ImageIcon("parchemin.jpg"); 
	        imgBg = resizePicture(imgTmp, 990,990).getImage();
	        
	        ImageIcon imgTmp2 = new ImageIcon("header.jpg");
	        imgBg2 = resizePicture(imgTmp2, 800,200).getImage();
	        
	        

	    }
	    
	    protected void paintComponent(Graphics g){
	    	 
	        super.paintComponent(g);
	        //* optimisation 2d
	        Graphics2D g2 = (Graphics2D) g;

	       g2.drawImage(imgBg, 0,0,null);
	       g2.drawImage(imgBg2,50,700,null);
	       
	        
	    }

	    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }

}
