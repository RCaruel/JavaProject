package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Class qui g�re la position des tuiles par les joueurs
 */

public class JeuTerrain extends JPanel{
    private Image imgBg, imgHeader;
    private Image imgPlateau;
    private Image[][] imagesDominos = new Image[5][5];
    private Image pion, imageIA;
    private int x1, x2;
    private int y1, y2;
    private Joueurs joueurs;
    private Image imgTuile1, imgTuile2;

    JeuTerrain(Image img, final Composant composant, ArrayList<Integer> listedominos, Joueurs joueurs, int x1, int y1, int x2, int y2, int rang, Fenetre f) {
        imgBg = img;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.joueurs = joueurs;

        Component socleTuile1 = new Component() {};
        // Permet de pouvoir bouger une image
        if (joueurs.getStatut().equals("HUMAN")) {
            socleTuile1.addMouseListener(new MouseListener() {

                public void mouseClicked(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    System.out.println("Click");
                }

                public void mouseReleased(MouseEvent e) {
                    System.out.println("Released");
                    int[] pos = autoPos(x1 + e.getX(), y1 + e.getY(), 700);
                    //int[] pos = new int[]{x1 + e.getX() - 50, y1 + e.getY() - 50};
                    f.switchFrame(3, joueurs, listedominos, composant, pos[0], pos[1], x2, y2, rang);

                }

                public void mouseEntered(MouseEvent e) {

                }

                public void mouseExited(MouseEvent e) {

                }
            });
        }
        socleTuile1.setSize(new Dimension(75,150));
        socleTuile1.setLocation(x1, y1);
        add(socleTuile1);

        Component socleTuile2 = new Component() {};

        // Permet de pouvoir bouger une image
        if (joueurs.getStatut().equals("HUMAN")) {
            socleTuile2.addMouseListener(new MouseListener() {

                public void mouseClicked(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    System.out.println("Click");
                }

                public void mouseReleased(MouseEvent e) {
                    System.out.println("Released");
                    int[] pos = autoPos(x2 + e.getX(), y2 + e.getY(), 800);
                    //int[] pos = new int[]{x2 + e.getX() - 50, y2 + e.getY() - 50};

                    f.switchFrame(3, joueurs, listedominos, composant, x1, y1, pos[0], pos[1], rang);

                }

                public void mouseEntered(MouseEvent e) {

                }

                public void mouseExited(MouseEvent e) {

                }
            });
        }

        socleTuile2.setSize(new Dimension(75,150));
        socleTuile2.setLocation(x2, y2);
        add(socleTuile2);

        if (joueurs.getStatut().equals("HUMAN")) {
            if (composant.getNombreJoueurs() > 2 || ((composant.getNombreJoueurs() == 2) && !joueurs.isChoixTuile1IsPlaced())) {
                System.out.println("test1");
                imgTuile1 = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getChoixTuile() + "1.JPG")), 100, 100).getImage();
                imgTuile2 = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getChoixTuile() + "2.JPG")), 100, 100).getImage();
            }else if(composant.getNombreJoueurs() == 2 && joueurs.isChoixTuile1IsPlaced()){
                System.out.println("test2");
                imgTuile1 = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getChoixTuile2() + "1.JPG")), 100, 100).getImage();
                imgTuile2 = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getChoixTuile2() + "2.JPG")), 100, 100).getImage();
            }
        }
        
        ImageIcon imgTmp = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));
	    imgHeader = resizePicture(imgTmp, 1000,300).getImage();

        imgPlateau = resizePicture(new ImageIcon(this.getClass().getResource("ressources/Plateau.png")),500,500).getImage();

        pion = resizePicture(new ImageIcon(this.getClass().getResource("ressources/K" + joueurs.getCouleur() + ".png")), 75,150).getImage();
        if (joueurs.getStatut().equals("IA")){
            imageIA = resizePicture(new ImageIcon(this.getClass().getResource("ressources/IA.png")), 75,150).getImage();
        }

        for (int pX = 0; pX < joueurs.getMap().length; pX++){
            for (int pY = 0; pY < joueurs.getMap().length; pY++){
                if(!joueurs.getMap()[pX][pY].equals("0")){
                    System.out.println("isInIF.constructor");
                    System.out.println(joueurs.getMap()[pX][pY]);
                    imagesDominos[pX][pY] = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getMap()[pX][pY] + ".JPG")), 100,100).getImage();
                }
            }
        }

        setLayout(null);

        JButton b = new JButton("Valider");
        b.setSize(new Dimension(200, 40));
        b.setLocation(740, 770);

        b.addActionListener(e -> {
            if (placementIsOk()){
                System.out.println("Placement est ok");
                Jouer.choixduplacement(rang, composant, (x1-100) / 100, (y1 - 300) / 100, (x2 - 100) / 100, (y2 - 300) / 100,f);
            }
        });

        add(b);
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0, 0, null);
        g2.drawImage(imgHeader, 0,0,null);
        g2.drawImage(imgPlateau, 100, 300, null);
        g2.drawImage(pion, 803, 610, null);
        if (joueurs.getStatut().equals("IA")){
            g2.drawImage(imageIA, 803,610,null);
        }

        for (int pX = 0; pX < 5; pX++){
            for (int pY = 0; pY < 5; pY++){
                if(!joueurs.getMap()[pX][pY].equals("0")){
                    g2.drawImage(imagesDominos[pX][pY],100+100*pX, 300+100*pY, null);
                }
            }
        }

        g2.drawImage(imgTuile1, x1, y1, null);
        g2.drawImage(imgTuile2, x2, y2, null);
    }

    private int[] autoPos(int x, int y, int initX){
        int posX = initX;
        int distmin = 10000;
        int posY = 500;

        if (y < 800 && y > 300 && x < 600 && x > 100){
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if(joueurs.getMap()[i][j].equals("0")){
                    	if ((abs((100 + 100*i) - x) * abs((100 + 100*i) - x) + abs((300 + 100*j) - y) * abs((300 + 100*j) - y)) < (distmin)) {
                            System.out.println("isInIF");
                            distmin = (abs((100 + 100*i) - x) * abs((100 + 100*i) - x) + abs((300 + 100*j) - y) * abs((300 + 100*j) - y));
                            posX = 100 + 100 * i;
                            posY = 300 + 100 * j;
                        }
                    }
                }
            }
        }
        return new int[]{posX, posY};
    }

    private int abs(int x){
        if (x < 0){
            return -x;
        }else return x;
    }

    private boolean placementIsOk(){
        if ((x1 - x2) * (x1 - x2) + (y1 - y2)*(y1 - y2) > 10000){
            return false;
        }
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) != 0;
    }

    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(imgResize);

        return imageIcon;
    }

}
