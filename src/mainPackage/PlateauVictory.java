package mainPackage;

import javax.swing.*;
import java.awt.*;

/**
 * Class qui gère la dernière fenêtre.
 */

public class PlateauVictory extends JPanel{

    private static final long serialVersionUID = 1L;
    private Image imgBg;
    private Image imgHeader;
    private Image imgVictory, imgPion;

    PlateauVictory(Image img, Joueurs joueurs, Fenetre f){

        imgBg = img;
        ImageIcon imgTmp = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));
        imgHeader = resizePicture(imgTmp, 1000,300).getImage();

        imgPion = resizePicture(new ImageIcon(this.getClass().getResource("ressources/K" + joueurs.getCouleur() + ".png")), 150, 300).getImage();
        imgVictory = resizePicture(new ImageIcon(this.getClass().getResource("ressources/Laurier.png")), 500, 500).getImage();

        JButton b = new JButton("Retour au menu");

        setLayout(null);

        b.setSize(new Dimension(200,40));
        b.setLocation(400,800);
        b.addActionListener(e -> {
            f.dispose();
            Main.main(new String[]{});
        });
        add(b);
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0,0,null);
        g2.drawImage(imgHeader, 0, 0, null);
        g2.drawImage(imgVictory, 250, 250, null);
        g2.drawImage(imgPion, 425, 275, null);
    }
    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }
}
