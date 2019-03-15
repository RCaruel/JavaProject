package mainPackage;

import javax.swing.*;
import java.awt.*;

class ImageGraphique extends JPanel {

    private Image[] point = new Image[4];
    private String[] color = new String[]{"rouge", "vert", "bleu", "jaune"};
    private int max;
    private int init;
    private Composant composant;

    ImageGraphique(Composant composant){
        this.max = maxi(composant);
        this.composant = composant;
        point[0] = resizePicture(new ImageIcon("resources/mainPackage/ressources/pointrouge.png")).getImage();
        point[1] = resizePicture(new ImageIcon("resources/mainPackage/ressources/pointvert.png")).getImage();
        point[2] = resizePicture(new ImageIcon("resources/mainPackage/ressources/pointbleu.png")).getImage();
        point[3] = resizePicture(new ImageIcon("resources/mainPackage/ressources/pointjaune.png")).getImage();
        add(new JButton("Bouton"));
        setLayout(null);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Joueurs joueur : composant.getListJoueurs()) {
            init = 800;
            for (int i = 0; i < 11000; i++) {
                g.drawImage(point[getIndexOf(color, joueur)], i / 10, function(i, joueur), null);
                if ((i + 1) % 1000 == 0) {
                    this.init = function(i, joueur);
                }
            }
        }
    }

    private ImageIcon resizePicture(ImageIcon imageIcon){
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(10, 10,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    private int maxi(Composant composant){
        int max = 0;
        for (Joueurs joueurs : composant.getListJoueurs()){
            if(joueurs.getEvolution()[11] > max){
                max = joueurs.getEvolution()[11];
            }
        }
        return max;
    }

    private int function(int i, Joueurs joueurs){

        int quot = (i - i%1000)/1000;
        int height = calcHeight(quot, joueurs);
        int nbCoups = 12;
        int width = 12000/ nbCoups;
        System.out.println(i + " : " + (init - (i-quot*1000) * height/width));

        return init - (i-quot*1000) * height/width;

    }

    private int calcHeight(int quot, Joueurs joueurs){
        return joueurs.getEvolution()[quot+1] * 700 / max - joueurs.getEvolution()[quot] * 700 / max;
    }

    private int getIndexOf(String[] color, Joueurs joueurs){
        for (int i = 0; i < composant.getListJoueurs().length; i++){
            if (color[i].equals(joueurs.getCouleur())){
                return i;
            }
        }
        return -1;
    }
}
