package mainPackage;

import javax.swing .*;
import java.awt .*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Class qui gère l'affichage pour le choix des tuiles
 */
public class JeuPlateau extends JPanel{

    private Image imgBg, imgPlateau, imgHeader;
    private Image[][] imagesPlateauDominos = new Image[5][5];
    private Image[][] imagesDominos = new Image[4][2];
    private String[] indexDominos = new String[4];
    private Image pion, imageIA;
    private int size;
    private int x;
    private int y;
    int i;
    private Joueurs joueurs;
    private Component soclePion = new Component() {};
    private Timer timer;

    JeuPlateau(Image img, final Composant composant, ArrayList<Integer> listedominos, Joueurs joueurs, int x, int y, int i, Fenetre f) {
        this.size = listedominos.size();
        imgBg = img;
        this.x = x;
        this.y = y;
        this.i = i;
        this.joueurs = joueurs;

        ImageIcon imgTmp = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));
        imgHeader = resizePicture(imgTmp, 1000,300).getImage();

        pion = resizePicture(new ImageIcon(this.getClass().getResource("ressources/K" + joueurs.getCouleur() + ".png")), 75,150).getImage();

        if (joueurs.getStatut().equals("IA")){
            imageIA = resizePicture(new ImageIcon(this.getClass().getResource("ressources/IA.png")), 75,150).getImage();
        }

        // Permet de pouvoir bouger une image
        if (joueurs.getStatut().equals("HUMAN")) {
            soclePion.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    System.out.println("Click");
                    timer = new Timer(100,e1 -> {
                        System.out.println("1");
                        setPos(new int[]{x + MouseInfo.getPointerInfo().getLocation().x - 37, y + MouseInfo.getPointerInfo().getLocation().y - 75});
                        refresh();
                    });
                    timer.start();
                }

                public void mouseReleased(MouseEvent e) {
                    System.out.println("Released");
                    timer.stop();
                    int[] pos = autoPos(x + e.getX() - 37, y + e.getY() - 75);

                    f.switchFrame(2, joueurs, listedominos, composant, pos[0], pos[1],0,0,0);
                }

                public void mouseEntered(MouseEvent e) {

                }

                public void mouseExited(MouseEvent e) {

                }
            });
        }

        soclePion.setSize(new Dimension(75,150));
        soclePion.setLocation(x, y);
        add(soclePion);

        imgPlateau = resizePicture(new ImageIcon(this.getClass().getResource("ressources/Plateau.png")),350,350).getImage();

        for (int pX = 0; pX < joueurs.getMap().length; pX++){
            for (int pY = 0; pY < joueurs.getMap().length; pY++){
                if(!joueurs.getMap()[pX][pY].equals("0")){
                    imagesPlateauDominos[pX][pY] = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + joueurs.getMap()[pX][pY] + ".JPG")), 70,70).getImage();
                }
            }
        }

        for (int j = 0; j < size; j++){
            imagesDominos[j][0] = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + String.valueOf(listedominos.get(j)) + "1.JPG")), 100,100).getImage();
            imagesDominos[j][1] = resizePicture(new ImageIcon(this.getClass().getResource("DemiDominos/" + String.valueOf(listedominos.get(j)) + "2.JPG")), 100,100).getImage();
            indexDominos[j] = String.valueOf(listedominos.get(j));
        }

        setLayout(null);

        JButton b = new JButton("Valider");
        b.setSize(new Dimension(200, 40));
        b.setLocation(740, 770);
        b.addActionListener(e -> {
            if (y != 600 || joueurs.getStatut().equals("IA")) {
                Jouer.choixtuile(i, joueurs, composant, f, indexDominos[(x+37 - 180)/200]);

            }
        });
        add(b);
    }

    private void setPos(int[] positions){
        this.x = positions[0];
        this.y = positions[1];
        soclePion.setLocation(x, y);
    }

    private void refresh(){
        revalidate();
        this.repaint();
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0, 0, null);
        g2.drawImage(imgHeader, 0, 0, null);

        for (int i = 0; i < size; i++){
            g2.drawImage(imagesDominos[i][0], 100 + 200*i, 300, null);
            g2.drawImage(imagesDominos[i][1], 180 + 200*i, 300, null);
            g2.drawString(indexDominos[i], 175 + 200 * i, 410);
        }

        g2.drawImage(imgPlateau,100,450,null);

        for (int pX = 0; pX < 5; pX++){
            for (int pY = 0; pY < 5; pY++){
                if(!joueurs.getMap()[pX][pY].equals("0")){
                    g2.drawImage(imagesPlateauDominos[pX][pY],100+70*pX, 450+70*pY, null);
                }
            }
        }

        g2.drawImage(pion, x, y, null);

        if (joueurs.getStatut().equals("IA")){
            g2.drawImage(imageIA, x,y,null);
        }

    }

    private int[] autoPos(int x, int y){
        int posX = 600;
        int distmin = 100;
        int posY = 600;
        if (y < 350 && y > 250){
            posY = 250;
            for (int i = 0; i < size; i++){
                if (abs((180+200 * i) - x) < distmin){
                    distmin = abs(x - (180+200 * i));
                    posX = 180 + 200 * i - 37;
                }
            }
        }
        if (posX == 450){
            posY = 600;
        }

        return new int[]{posX, posY};
    }

    private int abs(int x){
        if (x < 0){
            return -x;
        }else return x;
    }

    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(imgResize);

        return imageIcon;
    }

}
