package mainPackage;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Database database = new Database();

    public static void main(String[] args) {

        byte choix;


        initialisation();

        Database database = new Database();
        database.init();

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

    public static void initialisation(){
        database.init();
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
        Jouer.play();
    }

    public static void afficheLeTutoriel(){
        Tutoriel.play(scanner);
    }

}
