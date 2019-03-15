package mainPackage;

import javax.swing.*;
import java.awt.*;


/**
 * Class qui permet de définir les paramètres d'execution du jeu.
 */
public class Param extends JPanel{

    private Image imgBg;
    private Image imgHeader;
    private Composant composant;
    private ParamJoueur[] j = new ParamJoueur[4];

    Param(Image img, Composant composant, Fenetre f){
        this.composant = composant;
        imgBg = img;
        ImageIcon imgTmp = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));
        imgHeader = resizePicture(imgTmp).getImage();

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
        b.addActionListener(e -> {
            if (verif(j)) {
                Parametre parametre = new Parametre();
                parametre.parametre(composant, j, f);
            }
        });
        add(b);

    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0,0,null);
        g2.drawImage(imgHeader, 0,0,null);
    }

    private ImageIcon resizePicture(ImageIcon imageIcon){
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(1000, 300,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    private boolean verif(ParamJoueur[] p){
        for (int i = 0; i < composant.getNombreJoueurs(); i++){
            for (int j = i+1; j < composant.getNombreJoueurs(); j++){
                if ((p[i]).getCouleur().equals((p[j]).getCouleur())){
                    JOptionPane.showMessageDialog(this, "Deux joueurs ont la même couleur", "Paramétrage de la partie", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

}
