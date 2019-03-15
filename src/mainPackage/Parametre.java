package mainPackage;


// demande aux joueuers les param�tres de la partie
class Parametre {

    /**
     * Fonction qui d�finis les param�trages de d�part en fonction de ce qui a �t� choisi.
     * @param composant boite de jeu
     * @param j cr�� le joueur en fonction de ses parametres
     * @param f fenetre actuellement active
     */

    void parametre(Composant composant, ParamJoueur[] j, Fenetre f){

        for (int i = 0; i < composant.getNombreJoueurs(); i++) {

            composant.getListJoueurs()[i] = new Joueurs();
            composant.getListJoueurs()[i].setPseudo(j[i].getPseudo().getText());
            if (j[i].getIA().isSelected()) {
                composant.getListJoueurs()[i].setStatut("IA");
            } else {
                composant.getListJoueurs()[i].setStatut("HUMAN");
            }
            System.out.println(String.valueOf(j[i].getCouleur()));
            composant.getListJoueurs()[i].setCouleur(String.valueOf(j[i].getCouleur()));
        }

        composant.setNombreDominos(48 - 12 * (4 - composant.getNombreJoueurs()));
        composant.setDominos();
        Jouer.play(composant, f);
    }

}
