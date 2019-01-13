package mainPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	JTextField j1;




	public PlateauGraphic(Image img){
		imgBg = img;
	    ImageIcon imgTmp = new ImageIcon("header.png");
	    imgHeader = resizePicture(imgTmp, 400,200).getImage();
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


	@Override
	protected void paintComponent(Graphics g){

		super.paintComponent(g);
		//* optimisation 2d
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(imgBg, 0,0,null);
		g2.drawImage(imgHeader, 200,0,null);
	        
		Image img2;
		try {
			img2 = ImageIO.read(new File("header.jpg"));
			g.drawImage(img2, 0, 0, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){
	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }

	    public JButton getButton() {
	        return button;
	    }

	    public void setButton(JButton button) {
	        this.button = button;
	    }

	    public JTextField getJ1() {
	        return j1;
	    }
	    
	}
