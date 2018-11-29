package mainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tutoriel {

    public static void play(Scanner scanner){
        byte choix = 0;
        System.out.println("//--------------------------------------------------------------//\n" +
                "//--------------------------------------------------------------//\n");
        do {
            try {
                System.out.println("Veuillez faire un choix :\n" +
                        "   1. Premier tour\n" +
                        "   2. Suite du déroulement de la partie\n" +
                        "   3. Fin de la partie\n" +
                        "   4. Retourner au menu");
                switch (choix = scanner.nextByte()) {
                    case 1:
                        premierTour();
                        break;
                    case 2:
                        SuitePartie();
                        break;
                    case 3:
                        FinPartie();
                        break;
                }
            }catch (InputMismatchException e){}
        }while(choix != 4);
    }

    public static void premierTour(){
        System.out.println("//--------------------------------------------------------------//\n" +
                "Lors du premier tour :\n" +
                "4 dominos seront tirés au hasard dans la pioche puis ils seront placés par ordre croissant puis retournés.\n" +
                "Ensuite chaque roi seront tirés aussi au hasard.\n" +
                "Le premier roi tiré peut choisir en premier la carte qu'il souhaite prendre, le 2e en 2e etc.\n" +
                "Une fois que tous les joueurs ont choisi leur carte, la partie peut commencer\n" +
                "voir la partie sur la suite du déroulement de la partie pour en savoir plus.\n" +
                "//--------------------------------------------------------------//\n");
    }

    public static void SuitePartie(){
        System.out.println("//--------------------------------------------------------------//\n" +
                "Une fois que la partie est initialisée, tous les tours vont se dérouler de la même manière\n" +
                "jusqu'à épuisement des cartes dans la pioche.\n" +
                "Des nouveaux dominos vont être tirées de la pioche puis placés dans l'ordre et enfin retournés.\n" +
                "Ensuite le roi sur la carte avec le plus petit indice commence par choisir une nouvelle carte.\n" +
                "Puis chaque roi en montant dans les indices.\n" +
                "Une fois que vous placez votre roi, prenez votre domino et placez le sur votre terrain.\n" +
                "Celui-ci ne peut pas être en dehors d'un royaume de taille 5x5.\n" +
                "voir la partie sur la fin de la partie pour en savoir plus.\n" +
                "//--------------------------------------------------------------//\n");
    }

    public static void FinPartie(){
        System.out.println("//--------------------------------------------------------------//\n" +
                "Une fois que tous les dominos ont été placés, le jeu va calculer votre score en fonction de :\n" +
                "   du nombre de couronnes sur un bloc de terrain d'un type.\n" +
                "   de la taille d'un bloc de terrain du même type.\n" +
                "Le joueur avec le score le plus élevé gagne la partie.\n" +
                "//--------------------------------------------------------------//\n");
    }

}
