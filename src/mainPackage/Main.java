package mainPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        byte choix;

        Database database = new Database();
        database.init();

        do {

            System.out.println("Que voulez-vous faire?\n" +
                    "1. Jouer\n" +
                    "2. Quitter");

            choix = scanner.nextByte();

            switch (choix){
                case 1:
                    Jouer.play(database, scanner);
            }

        }while(choix != 2);

    }
}
