package mainPackage;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class PlateauJeuGraphic extends JPanel {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private Image img2;
	 


	    PlateauJeuGraphic(){
	    	
	     // imgBg = img;
	        ImageIcon image = new ImageIcon("parchemin.jpg"); 
	        img = resizePicture(image, 990,990).getImage();
	        
	        ImageIcon image2 = new ImageIcon("header.jpg");
	        img2 = resizePicture(image2, 800,200).getImage();
	        
	        

	    }
	    
	    protected void paintComponent(Graphics g){
	    	 
	        super.paintComponent(g);
	        //* optimisation 2d
	        Graphics2D g2 = (Graphics2D) g;

	       g2.drawImage(img, 0,0,null);
	       g2.drawImage(img2,50,700,null);
	       
	        
	    }

	    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }

}
