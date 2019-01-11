package mainPackage;


import java.util.Scanner;


public class Main{

    static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {

        Composant composant = new Composant();
        byte choix;

        do {

            afficheMenu();

            choix = lectureDuChoix();

            switch (choix){
                case 0:
                    test();
                    break;
                case 1: 
                    lanceLeJeu(composant);
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

    public static void lanceLeJeu(Composant composant){
        Jouer.play(composant, scanner);
    }

    public static void afficheLeTutoriel(){
        Tutoriel.play(scanner);
    }

    public static void test(){
	     Controleur c = new Controleur(); //* Création du controleur
    }

    static void quitter(){
    	
    }

}
