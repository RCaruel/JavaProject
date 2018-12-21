package mainPackage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener{
    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("mon bouton");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Le JLabel");
    //Compteur de clics
    private int compteur = 0;

    public Fenetre(){
        this.setTitle("MONSIEUR BOUCHAMA");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);

        //Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
        bouton.addActionListener(this);

        container.add(bouton, BorderLayout.SOUTH);

        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        //Lorsque l'on clique sur le bouton, on met à jour le JLabel
        this.compteur++;
        label.setText("Vous avez cliqué " + this.compteur + " fois");
        Main.lanceLeJeu();
    }
}



