package mainPackage;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        byte choix;

        do {

            afficheMenu();

            choix = lectureDuChoix();

            switch (choix){
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

}
