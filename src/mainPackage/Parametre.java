package mainPackage;

import java.util.Scanner;

// demande aux joueuers les paramétres de la partie
public class Parametre {

    Composant composant = new Composant(); 

    public Composant parametrage(Scanner scanner){

        System.out.println("Veuillez saisir le nombres de joueurs présent sur le terrain:");
        composant.setNombreJoueurs(scanner.nextInt());
        scanner.nextLine();

        for (int i = 0; i < composant.getNombreJoueurs(); i++){

            composant.listJoueurs[i] = new Joueurs();
            System.out.println("Veuillez saisir le pseudo du joueur " + i);
            composant.listJoueurs[i].setPseudo(scanner.nextLine());
            System.out.println("Est-ce une IA ? Oui / Non.");
            if (scanner.nextLine().equals("Oui")){
                composant.listJoueurs[i].setStatut("IA");
            }else{
                composant.listJoueurs[i].setStatut("HUMAN");
            }
            System.out.println("Veuillez saisir sa couleur : BLEU / ROUGE / VERT");
            composant.listJoueurs[i].setCouleur(scanner.nextLine());
        }

        composant.setNombreDominos(48 - 12 * (4 - composant.getNombreJoueurs()));
        composant.setDominos();
        return composant;
    }

}
