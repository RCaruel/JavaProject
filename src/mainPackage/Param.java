package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Param extends JPanel{
	
	
	//Le nom
    JPanel panNom = new JPanel();
    private Image imgBg;
    private Image imgHeader;
    private JButton buttonLancePartie;
    private Composant composant;
    private JTextField j1TF, j2TF, j3TF, j4TF;
    private JCheckBox j1CB, j2CB, j3CB, j4CB;
    private ParamJoueur[] j = new ParamJoueur[4];

    public Param(Image img, Composant composant){
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
                for (int i = 0; i < composant.getNombreJoueurs(); i++){

                    composant.getListJoueurs()[i] = new Joueurs();
                    composant.getListJoueurs()[i].setPseudo(((ParamJoueur)j[i]).getPseudo().getText());
                    if (((ParamJoueur)j[i]).getIA().isSelected()){
                        composant.getListJoueurs()[i].setStatut("IA");
                    }else{
                        composant.getListJoueurs()[i].setStatut("HUMAN");
                    }
                    System.out.println(String.valueOf(((ParamJoueur)j[i]).getCouleur()));
                    composant.getListJoueurs()[i].setCouleur(String.valueOf(((ParamJoueur)j[i]).getCouleur()));
                }

                composant.setNombreDominos(48 - 12 * (4 - composant.getNombreJoueurs()));
                composant.setDominos();
            }
        });
        add(b);

    }

    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

}
