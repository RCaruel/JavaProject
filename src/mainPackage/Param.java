package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Param extends JPanel{

    private Image imgBg;
    private Image imgHeader;
    private JButton buttonLancePartie;
    private Composant composant;
    private ParamJoueur[] j = new ParamJoueur[4];

    Param(Image img, Composant composant, Fenetre f){
        this.composant = composant;
        imgBg = img;
        ImageIcon imgTmp = new ImageIcon("header.png");
        imgHeader = resizePicture(imgTmp, 400,200).getImage();

        j[0] = new ParamJoueur(this, 1);

        j[1] = new ParamJoueur(this, 2);

        if (composant.getNombreJoueurs() >= 3){
            j[2] = new ParamJoueur(this, 3);
        }

        if (composant.getNombreJoueurs() >= 4){
            j[3] = new ParamJoueur(this, 4);
        }
        setLayout(null);

        JButton b = new JButton("Lancer la partie");
        b.setSize(new Dimension(200,40));
        b.setLocation(740,770);
        this.buttonLancePartie = b;
        this.buttonLancePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verif(j)) {
                    Parametre parametre = new Parametre();
                    parametre.param(composant, j, f);
                }
            }
        });
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
        } catch (IOException ignore) {}

    }

    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    private boolean verif(ParamJoueur[] p){
        for (int i = 0; i < composant.getNombreJoueurs(); i++){
            for (int j = i+1; j < composant.getNombreJoueurs(); j++){
                if (((ParamJoueur)p[i]).getCouleur().equals(((ParamJoueur)p[j]).getCouleur())){
                    JOptionPane.showMessageDialog(this, "Deux joueurs ont la même couleur", "Paramétrage de la partie", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

}
