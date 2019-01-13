package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PlateauVictory extends JPanel{

    private static final long serialVersionUID = 1L;
    private Image imgBg;
    private JButton button;
    private Image imgHeader;
    private Image imgVictory, imgPion;

    PlateauVictory(Image img, Joueurs joueurs, Fenetre f){

        imgBg = img;
        ImageIcon imgTmp = new ImageIcon("header.png");
        imgHeader = resizePicture(imgTmp, 400,200).getImage();

        imgPion = resizePicture(new ImageIcon("src/ressources/K" + joueurs.getCouleur() + ".png"), 150, 300).getImage();
        imgVictory = resizePicture(new ImageIcon("Laurier.png"), 500, 500).getImage();

        JOptionPane.showMessageDialog(this, "Le vainqueur est " + joueurs.getPseudo() + " avec un score de " + joueurs.getScore(), "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);

        JButton b = new JButton("Retour au menu");

        setLayout(null);

        b.setSize(new Dimension(200,40));
        b.setLocation(400,800);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Main_bis.main(new String[]{});
            }
        });
        this.button = b;
        //add(j2);
        add(b);
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0,0,null);
        g2.drawImage(imgVictory, 250, 250, null);
        g2.drawImage(imgPion, 425, 275, null);

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
}
