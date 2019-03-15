package mainPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlateauGraphic extends JPanel { 
	  /**
	 * MENU DU JEU AVEC IMAGE DE FOND, BOUTON POUR DEMARRER LA PARTIE ET 
	 * UN JTEXTFIELD POUR RENTRER LE NOMBRE DE JOUEURS 
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Image imgBg;
	private JButton button;
	private Image imgHeader;
	private JTextField j1;




	PlateauGraphic(Image img){
		imgBg = img;
		System.out.println(this.getClass().getResource("ressources/header.jpg"));
	    ImageIcon imgTmp = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));
	    new ImageIcon(this.getClass().getPackageName() + ".jpg");
	    imgHeader = resizePicture(imgTmp, 1000,300).getImage();
	    JButton b = new JButton("Commencer la partie");
	    this.j1 = new JTextField("Nombre de joueurs");

	    setLayout(null);
	        
	    this.j1.setSize(new Dimension(150,30));
	    this.j1.setLocation(425,450);
	    b.setSize(new Dimension(200,40));
	    b.setLocation(400,500);
	    this.button = b;
	    add(j1);
	    //add(j2);
		add(b);
	}

	protected void paintComponent(Graphics g){

		super.paintComponent(g);
		//* optimisation 2d
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(imgBg, 0,0,null);
		g2.drawImage(imgHeader, 0,0,null);

	}
	private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){
		Image img = imageIcon.getImage();
		Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
		imageIcon=new ImageIcon(imgResize);
		return imageIcon;
	}

	JButton getButton() {
		return button;
	}

	JTextField getJ1() {
	        return j1;
	    }
	    
	}
