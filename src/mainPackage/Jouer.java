

//tour de jeux//


package mainPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

class Jouer {

    private static Random rand = new Random();
    private static ArrayList<String> roi;
    private static String[] plateau = new String[4];
    private static int compteurtour;
    private static String[] newroi;
    private static int[] domi = new int[48];
    private static ArrayList<Integer> listedominos;
    private static ArrayList<Integer> listedominoscopy;
    private static int[] choixtuile;
    private static boolean reponse = false;

    static void play(Composant composant, Fenetre f) {
        compteurtour = 0;
        debutjeux(composant);
        tour(composant, f);
    }

    /**
     * Fonction d'initialisation du jeu
     * @param composant
     */

    private static void debutjeux(Composant composant) {

        roi = new ArrayList<>();
        listedominos = new ArrayList<>();
        listedominoscopy = new ArrayList<>();


        // initialisation des plateaux
        for (int i = 0; i < composant.getNombreJoueurs(); i++) {
            composant.getListJoueurs()[i].setMap(new String[5][5]);
            for (int x = 0; x < composant.getListJoueurs()[i].getMap().length; x++) {
                for (int y = 0; y < composant.getListJoueurs()[i].getMap().length; y++) {
                    composant.getListJoueurs()[i].ajoutMap("0", x, y);
                }
            }
            composant.getListJoueurs()[i].ajoutMap("500", 2, 2);
        }

        for (int i = 0; i < 4; i++) {
            listedominoscopy.add(0, 0);
        }

        //on attribut le plateau 0 au jouer rouge
        //                       1 au jouer bleu
        //                       2 au jouer vert
        //                       3 au jouer jaune
        plateau[0] = "rouge";
        plateau[1] = "bleu";
        plateau[2] = "vert";
        plateau[3] = "jaune";

        // initialisation des rois
        if (composant.getNombreJoueurs() == 2) {
            roi.add(composant.getListJoueurs()[0].getCouleur());
            roi.add(composant.getListJoueurs()[0].getCouleur());
            roi.add(composant.getListJoueurs()[1].getCouleur());
            roi.add(composant.getListJoueurs()[1].getCouleur());
        } else if (composant.getNombreJoueurs() == 3) {
            roi.add(composant.getListJoueurs()[0].getCouleur());
            roi.add(composant.getListJoueurs()[1].getCouleur());
            roi.add(composant.getListJoueurs()[2].getCouleur());
        } else {
            roi.add(composant.getListJoueurs()[0].getCouleur());
            roi.add(composant.getListJoueurs()[1].getCouleur());
            roi.add(composant.getListJoueurs()[2].getCouleur());
            roi.add(composant.getListJoueurs()[3].getCouleur());
        }

        // initialisation ordre de jeux
        for (int i = 0; i < roi.size(); i++) {
            int nb = rand.nextInt(roi.size() - i);
            String transition = roi.get(nb);
            roi.set(nb, roi.get(roi.size() - i - 1));
            roi.set(roi.size() - i - 1, transition);
        }

        //initialisation du jeux de domino

        //creation d'une liste de dominos
        for (int i = 1; i <= 48; i++) {
            domi[i - 1] = i;
        }

        //mélange de la liste
        for (int i = 0; i < 48; i++) {
            int nb = rand.nextInt(48 - i);
            int transition = domi[nb];
            domi[nb] = domi[48 - i - 1];
            domi[48 - i - 1] = transition;
        }

        System.out.print("[ ");
        for (int i = 0; i < composant.getNombreDominos(); i++) {
            System.out.print(domi[i] + " ");
        }
        System.out.print("]");

        System.out.println(" ");
        System.out.println("Ordre de jeux");
        System.out.println(roi + "\n");
        newroi = new String[roi.size()];
    }

    /**
     * fonction de tirage de tuile
     */
    private static void tiretuile() {
        //tire nb de roi cartes
        listedominos = new ArrayList<>();
        for (int i = 0; i < roi.size(); i++) {
            listedominos.add(domi[i + roi.size() * compteurtour]);
        }
        Collections.sort(listedominos);
    }

    /**
     * Fonction qui gère le choix des tuiles
     * @param i
     * @param joueurs
     * @param composant
     * @param f
     * @param indexTuile
     */
    static void choixtuile(int i, Joueurs joueurs, Composant composant, Fenetre f, String indexTuile) {

        int indicetuile = 0;
        joueurs.ChoixTuile(convertisseur(listedominos), composant, indexTuile);

        try {
            System.out.println("le joueur : " + joueurs.getPseudo() + " place son roi sur la tuile : " + joueurs.getChoixTuile());
            indicetuile = listedominos.indexOf(Integer.valueOf(joueurs.getChoixTuile()));
            newroi[listedominoscopy.indexOf(Integer.valueOf(joueurs.getChoixTuile()))] = roi.get(i);
            System.out.println(listedominoscopy);
            listedominos.remove(indicetuile);
        }catch (IndexOutOfBoundsException e){
            System.out.println("le joueur : " + joueurs.getPseudo() + " place son roi sur la tuile : " + joueurs.getChoixTuile2());
            indicetuile = listedominos.indexOf(Integer.valueOf(joueurs.getChoixTuile2()));
            newroi[listedominoscopy.indexOf(Integer.valueOf(joueurs.getChoixTuile2()))] = roi.get(i);
            System.out.println(listedominoscopy);
            listedominos.remove(indicetuile);
        }

        if (i + 1 < roi.size()) {
            i++;
            f.switchFrame(2, getJoueur(composant.getListJoueurs(), roi.get(i)), listedominos, composant, 600, 600, 0, 0, i);
        } else {
            f.switchFrame(3, getJoueur(composant.getListJoueurs(), roi.get(0)), listedominos, composant, 700, 500, 800, 500, 0);
        }

    }

    /**
     * Fonction de conversion array liste -> String[]
     * @param liste
     * @return
     */
    private static String[] convertisseur(ArrayList<Integer> liste) {
        String[] listeConv = new String[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            listeConv[i] = String.valueOf(liste.get(i));
        }
        return listeConv;
    }

    /**
     * Fonciton qui gère le placement des tuiles
     * @param i
     * @param composant
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param f
     */

    static void choixduplacement(int i, Composant composant, int x1, int y1, int x2, int y2, Fenetre f) {

        System.out.println("le joueur : " + roi.get(i) + " a place sa tuile.");

        for (int j = 0; j < roi.size(); j++) {
            if (roi.get(i).equals(plateau[j]) && getJoueur(composant.getListJoueurs(), roi.get(i)).getStatut().equals("HUMAN") && x1 != 800) {
                if (composant.getNombreJoueurs() > 2 || ((composant.getNombreJoueurs() == 2) && !getJoueur(composant.getListJoueurs(), roi.get(i)).isChoixTuile1IsPlaced())) {
                    getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile() + "1", x1, y1);
                    getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile() + "2", x2, y2);
                }else if(composant.getNombreJoueurs() == 2 && getJoueur(composant.getListJoueurs(), roi.get(i)).isChoixTuile1IsPlaced()) {
                    getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile2() + "1", x1, y1);
                    getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile2() + "2", x2, y2);
                }
            }
        }

        getJoueur(composant.getListJoueurs(), roi.get(i)).setChoixTuile1IsPlaced(!(getJoueur(composant.getListJoueurs(), roi.get(i)).isChoixTuile1IsPlaced()));

        if (i + 1 < roi.size()) {
            i++;
            f.switchFrame(3, getJoueur(composant.getListJoueurs(), roi.get(i)), listedominos, composant, 700, 500, 800, 500, i);
        } else {
            //on redéfinie l'ordre de jeux en fonction du placement
            for (int j = 0; j < roi.size(); j++) {
                roi.set(j, newroi[j]);
                getJoueur(composant.getListJoueurs(), roi.get(j)).setChoixTuile("");
            }
            tour(composant, f);
        }
    }

    /**
     * Fonction qui retourne un joueur parmi la liste des joueurs possibles
     * @param listjoueur
     * @param couleur
     * @return
     */
    private static Joueurs getJoueur(Joueurs[] listjoueur, String couleur) {
        for (Joueurs aListjoueur : listjoueur) {
            if (aListjoueur.getCouleur().equals(couleur)) {
                return aListjoueur;
            }
        }
        return listjoueur[0];
    }

    /**
     * Fonction du tour
     * @param composant
     * @param f
     */
    private static void tour(Composant composant, Fenetre f) {

        choixtuile = new int[roi.size()];

        if (roi.size() * compteurtour < composant.getNombreDominos()) {
            tiretuile();

            for (int i = 0; i < listedominos.size(); i++) {
                listedominoscopy.set(i, listedominos.get(i));
            }

            compteurtour++;


            f.switchFrame(2, getJoueur(composant.getListJoueurs(), roi.get(0)), listedominos, composant, 600, 600, 0, 0, 0);
        }else{
            int max = 0;
            int winner = 0;
            int score;

            for (int i = 0; i < composant.getListJoueurs().length; i++){
                if ((score = calculScore(composant.getListJoueurs()[i], composant)) > max){
                    max = score;
                    winner = i;
                }
                System.out.println("Le joueur " + composant.getListJoueurs()[i].getPseudo() + "a un score total de " + score);
            }
            System.out.println("Le joueur qui a gagné est : " + composant.getListJoueurs()[winner].getPseudo() + " avec un score de " + composant.getListJoueurs()[winner].getScore());
            f.affWinner(composant.getListJoueurs()[winner]);
            f.switchFrame(4, composant.getListJoueurs()[winner], listedominos, composant, 0,0,0,0,0);
        }
    }

    private static int calculScore(Joueurs joueurs, Composant composant) {
        joueurs.setScore(CalcScore.play(joueurs, composant, true));
        return ((joueurs.getScore() * 100) + CalcScore.scoreMap(joueurs.getMap())) * 100 + CalcScore.nbCouronnes(joueurs.getMap(), composant);
    }

}
