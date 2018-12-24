package mainPackage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{

    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("mon bouton");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Le JLabel");
    //Compteur de clics
    private int compteur = 0;

    public Fenetre(){
    	this.setTitle("Welcome");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Panneau()); //Association du panneau a la fenetre
        
        this.setVisible(true);
    }
}



