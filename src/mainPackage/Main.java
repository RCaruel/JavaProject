package mainPackage;

import javax.swing.*;
import java.util.Scanner;
import javax.swing.JPanel;

public class Main{

    static Scanner scanner = new Scanner(System.in);
    static Fenetre fenetre = new Fenetre();

    public static void main(String[] args) {

        byte choix;

        do {

            afficheMenu();

            choix = lectureDuChoix();

            switch (choix){
                case 0:
                    test();
                    break;
                case 1:
                    lanceLeJeu();
                    break;
                case 2:
                    afficheLeTutoriel();
                    break;
            }

        }while(choix != 3);

    }


    public static void afficheMenu(){
        System.out.println("Que voulez-vous faire?\n" +
                "0. test\n" +
                "1. Jouer\n" +
                "2. Tutoriel\n" +
                "3. Quitter");
    }

    public static byte lectureDuChoix(){
        return scanner.nextByte();
    }

    public static void lanceLeJeu(){
        Composant composant;
        Parametre parametre = new Parametre();
        composant = parametre.parametrage(scanner);
        Jouer.play(composant, scanner);
    }

    public static void afficheLeTutoriel(){
        Tutoriel.play(scanner);
    }

    public static void test(){
        fenetre.setVisible(true);
    }

    static void quitter(){
        fenetre.dispose();
    }

}
