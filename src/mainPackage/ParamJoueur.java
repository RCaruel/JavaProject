package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParamJoueur extends JPanel{
    private JCheckBox IA;
    private JTextField pseudo;
    private JButton color;
    private Color[] couleurs = new Color[]{Color.blue, Color.green, Color.red, Color.yellow};
    private String[] Scouleurs = new String[]{"bleu", "vert", "rouge", "jaune"};
    private String couleur;

    ParamJoueur(Param param, final int i){

        this.pseudo = new JTextField("joueur" + String.valueOf(i));
        this.pseudo.setSize(new Dimension(150,30));
        this.pseudo.setLocation(100,150 + 150*(i-1));
        param.add(this.pseudo);

        this.IA = new JCheckBox("IA");
        this.IA.setSize(new Dimension(50,50));
        this.IA.setLocation(290,140 + 150*(i-1));
        param.add(this.IA);

        this.color = new JButton();
        this.color.setText("Couleur");
        this.color.setSize(new Dimension(150,30));
        this.color.setLocation(350,150 + 150*(i-1));
        this.color.setBackground(couleurs[i-1]);
        this.couleur = Scouleurs[i-1];
        this.color.addActionListener(new ActionListener() {
            int j = i;
            public void actionPerformed(ActionEvent e) {
                j++;
                color.setBackground(couleurs[j-1]);
                setCouleur(Scouleurs[j-1]);
                j %= 4;
            }
        });
        param.add(this.color);


    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public JCheckBox getIA() {
        return IA;
    }

    public JTextField getPseudo() {
        return pseudo;
    }
}
