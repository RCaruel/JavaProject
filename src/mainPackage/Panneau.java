package mainPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panneau extends JPanel { 
	
	 private Image imgBg1;
	 private Image imgBg2;
	 private JButton button1;
	 private JButton button2;
	 private Image imgPlateau;
	 private JTextField j1, j2;
	 private JLabel label = new JLabel();
	 
	 JButton b = new JButton("Commencer la partie");
    JButton c = new JButton("Quitter la partie");

 public void paintComponent(Graphics g){//Methode qui remplace le constructeur 
	
	 
   try {
   	super.paintComponent(g);
   	
   	Graphics g2 = (Graphics2D)g;//Amelioration du rendu 2d
   	
   	Image img1 = ImageIO.read(new File("parchemin.jpg"));
   	Image img2 = ImageIO.read(new File("header.jpg"));
   	g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);//Image de fond
   	g.drawImage(img2, 0, 0, this);
   	imgBg1 = img1 ;
   	imgBg2 = img2;
       ImageIcon imgTmp1 = new ImageIcon("parchemin.jpg");
       imgPlateau = resizePicture(imgTmp1, 400,400).getImage();
       ImageIcon imgTmp2 = new ImageIcon("header.jpg");
       imgPlateau = resizePicture(imgTmp2, 400,400).getImage();
       JTextField j1 = new JTextField("Joueur 1");
       JTextField j2 = new JTextField("Joueur 2");
       //JTextField j1 = new JTextField("Joueur 3"); A RAJOUTER AVEC LE SCAN
       //JTextField j2 = new JTextField("Joueur 4");

       setLayout(null);
       j1.setSize(new Dimension(150,60));
       j2.setSize(new Dimension(150,60));
       j1.setLocation(200,350);
       j2.setLocation(450,350);
       b.setSize(new Dimension(200,40));
       b.setLocation(350,450);
       c.setSize(new Dimension(200,40));
       c.setLocation(750,900);
       this.button1  = b;
       this.button2 = c;
       this.j1 = j1;
       this.j2 = j2;
       add(j1);
       add(j2);
       add(b);
       add(c);
       JPanel panel = new JPanel();
       panel.setLayout(new FlowLayout());
   }catch(IOException e) {//Necessite try/catch car action suceptible de mal s'executer
   	e.printStackTrace();
   }
   
 }
 
 public void actionPerformed(ActionEvent arg0) {
		//Object source = e.getSource();

		if(arg0.getSource() == button1){
			System.out.println("Vous avez cliqué ici.");

		}if(arg0.getSource() == button2){
			System.out.println("Vous avez cliqué là.");	
		}
	}
 
 public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


     Image img = imageIcon.getImage();
     Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
     imageIcon=new ImageIcon(imgResize);
     this.setVisible(true);

     return imageIcon;
 }
}
