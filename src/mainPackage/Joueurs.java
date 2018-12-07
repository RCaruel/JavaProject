package mainPackage;

import java.util.Scanner;

//type database
class Joueurs {
    private int choixTuile;
    private String pseudo;
    private String couleur;
    private int score;
    private String[][] map;
    private String statut;

    int getScore() {
        return score;
    }

    String getCouleur() {
        return couleur;
    }

    String getPseudo() {
        return pseudo;
    }

    int getChoixTuile() {
        return choixTuile;
    }

    String getStatut() {
        return statut;
    }

    String[][] getMap() {
        return map;
    }

    void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    void setScore(int score) {
        this.score = score;
    }

    void setChoixTuile(int choixTuile) {
        this.choixTuile = choixTuile;
    }

    void setMap(String[][] map) {
        this.map = map;
    }

    void ajoutMap(String value, int x, int y){
        this.map[x][y] = value;
    }

    void setStatut(String statut) {
        this.statut = statut;
    }

    void Joue(Scanner scanner, int[] listcartes){
        if (this.statut == "IA"){
            //IA.choose(listcartes, this);
        }else{
            System.out.println("Veuillez saisir les coordonnées:");
        }
    }
}
