package mainPackage;

import java.util.Scanner;

// demande aux joueuers les paramétres de la partie
public class Parametre {

    Composant composant = new Composant(); 

    public Composant parametrage(Scanner scanner){

        //TODO faire la version graphique

        System.out.println("Veuillez saisir le nombres de joueurs présent sur le terrain:");
        composant.setNombreJoueurs(scanner.nextInt());
        scanner.nextLine();

        for (int i = 0; i < composant.getNombreJoueurs(); i++){

            composant.getListJoueurs()[i] = new Joueurs();
            System.out.println("Veuillez saisir le pseudo du joueur " + i);
            composant.getListJoueurs()[i].setPseudo(scanner.nextLine());
            System.out.println("Est-ce une IA ? Oui / Non.");
            if (scanner.nextLine().equals("Oui")){
                composant.getListJoueurs()[i].setStatut("IA");
            }else{
                composant.getListJoueurs()[i].setStatut("HUMAN");
            }
            System.out.println("Veuillez saisir sa couleur : bleu / rouge / vert / jaune");
            composant.getListJoueurs()[i].setCouleur(scanner.nextLine());
        }

        composant.setNombreDominos(48 - 12 * (4 - composant.getNombreJoueurs()));
        composant.setDominos();
        return composant;
    }

}
