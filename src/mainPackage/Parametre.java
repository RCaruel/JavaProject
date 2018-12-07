package mainPackage;

import java.util.Scanner;

// demande aux joueuers les paramétres de la partie
class Parametre {

    private Composant composant = new Composant();

    Composant parametrage(Scanner scanner){

        String couleur;

        System.out.println("Veuillez saisir le nombre de joueurs présent sur le terrain:");
        composant.setNombreJoueurs(scanner.nextInt());

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
            do {
                System.out.println("Veuillez saisir sa couleur : BLEU / ROUGE / VERT / JAUNE");
                couleur = scanner.nextLine();
            }while(istake(couleur, i, composant) || isNormal(couleur));
            composant.getListJoueurs()[i].setCouleur(couleur);
        }

        composant.setNombreDominos(48 - 16 * (4 - composant.getNombreJoueurs()));
        composant.setDominos();
        return composant;
    }

    private boolean istake(String couleur, int max, Composant composant){
        for (int i = 0; i < max; i++){
            if (composant.getListJoueurs()[i].getCouleur().equals(couleur)){
                return true;
            }
        }
        return false;
    }

    private boolean isNormal(String couleur){
        return couleur.equals("BLEU") || couleur.equals("ROUGE") || couleur.equals("VERT") || couleur.equals("JAUNE");
    }

}
