package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class qui permet d'éditer les attributs d'un joueur.
 */

class ParamJoueur extends JPanel{
    private JCheckBox IA;
    private JTextField pseudo;
    private JButton color;
    private Color[] couleurs = new Color[]{Color.blue, Color.green, Color.red, Color.yellow};
    private String[] Scouleurs = new String[]{"bleu", "vert", "rouge", "jaune"};
    private String couleur;

    ParamJoueur(Param param, final int i){

        this.pseudo = new JTextField("joueur" + String.valueOf(i));
        this.pseudo.setSize(new Dimension(150,30));
        this.pseudo.setLocation(100,300 + 75*(i-1));
        param.add(this.pseudo);

        this.IA = new JCheckBox("IA");
        this.IA.setSize(new Dimension(40,20));
        this.IA.setLocation(280,305 + 75*(i-1));
        param.add(this.IA);

        this.color = new JButton();
        this.color.setText("Couleur");
        this.color.setSize(new Dimension(150,30));
        this.color.setLocation(350,300 + 75*(i-1));
        this.color.setBackground(couleurs[i-1]);
        this.couleur = Scouleurs[i-1];
        this.color.addActionListener(new ActionListener() {
            int y = i;
            public void actionPerformed(ActionEvent e) {
                y++;
                y %= 4;
                color.setBackground(couleurs[y]);
                setCouleur(Scouleurs[y]);
            }
        });
        param.add(this.color);


    }

    private void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    String getCouleur() {
        return couleur;
    }

    JCheckBox getIA() {
        return IA;
    }

    JTextField getPseudo() {
        return pseudo;
    }
}
