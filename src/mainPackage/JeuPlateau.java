package mainPackage;

import javax.imageio.ImageIO;
import javax.swing .*;
import java.awt .*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Scanner;

public class JeuPlateau extends JPanel{

    private Image imgBg;
    private Image imgHeader;
    private JButton buttonLancePartie;
    private Composant composant;
    private Image[][] imagesDominos = new Image[4][2];
    private String[] indexDominos = new String[4];
    private Image pion;
    private int size;
    private int x;
    private int y;
    int i;
    private String tuileChoisie;

    JeuPlateau(Image img, Composant composant, ArrayList<Integer> listedominos, Joueurs joueurs, int x, int y, int i, Fenetre f) {
        this.composant = composant;
        this.size = listedominos.size();
        imgBg = img;
        this.x = x;
        this.y = y;
        this.i = i;

        pion = resizePicture(new ImageIcon("src/ressources/K" + joueurs.getCouleur() + ".png"), 75,150).getImage();
        Component soclePion = new Component() {};
        if (joueurs.getStatut().equals("HUMAN")) {
            soclePion.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Click");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Released");
                    int[] pos = autoPos(x + e.getX() - 37, y + e.getY() - 75);

                    f.switchFrame(2, joueurs, listedominos, composant, pos[0], pos[1], 0, 0, i);

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
        soclePion.setSize(new Dimension(75,150));
        soclePion.setLocation(x, y);
        add(soclePion);

        for (int j = 0; j < size; j++){
            imagesDominos[j][0] = resizePicture(new ImageIcon("DemiDominos/" + String.valueOf(listedominos.get(j)) + "1.JPG"), 100,100).getImage();
            imagesDominos[j][1] = resizePicture(new ImageIcon("DemiDominos/" + String.valueOf(listedominos.get(j)) + "2.JPG"), 100,100).getImage();
            indexDominos[j] = String.valueOf(listedominos.get(j));
        }

        setLayout(null);

        JButton b = new JButton("Valider");
        b.setSize(new Dimension(200, 40));
        b.setLocation(740, 770);
        this.buttonLancePartie = b;
        this.buttonLancePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (y != 600 || joueurs.getStatut().equals("IA")) {
                    Jouer.choixdetuile(i, new Scanner(System.in), joueurs, composant, f, indexDominos[(x+37 - 180)/200]);

                }
            }
        });
        add(b);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        //* optimisation 2d
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imgBg, 0, 0, null);
        g2.drawImage(imgHeader, 200, 0, null);

        for (int i = 0; i < size; i++){
            g2.drawImage(imagesDominos[i][0], 100 + 200*i, 300, null);
            g2.drawImage(imagesDominos[i][1], 180 + 200*i, 300, null);
            g2.drawString(indexDominos[i], 175 + 200 * i, 410);
        }

        g2.drawImage(pion, x, y, null);

        Image img2;
        try {
            img2 = ImageIO.read(new File("header.jpg"));
            g.drawImage(img2, 0, 0, this);
        } catch (IOException ignore) {}

    }

    private int[] autoPos(int x, int y){
        int posX = 450;
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
