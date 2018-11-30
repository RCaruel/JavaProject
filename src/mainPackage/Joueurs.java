package mainPackage;
//type database
public class Joueurs {
    String pseudoJoueur;
    String couleurJoueur;
    int scoreJoueur;

    public int getScoreJoueur() {
        return scoreJoueur;
    }

    public String getCouleurJoueur() {
        return couleurJoueur;
    }

    public String getPseudoJoueur() {
        return pseudoJoueur;
    }

    public void setCouleurJoueur(String couleurJoueur) {
        this.couleurJoueur = couleurJoueur;
    }

    public void setPseudoJoueur(String pseudoJoueur) {
        this.pseudoJoueur = pseudoJoueur;
    }

    public void setScoreJoueur(int scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }
}
