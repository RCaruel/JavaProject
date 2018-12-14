package mainPackage;


//type database
public class Joueurs {
	
    int choixTuile;
    String pseudo;
    String couleur;
    int score;
    String[][] map;
    String statut = "UNDETERMINED";

    public int getScore() {
        return score;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getChoixTuile() {
        return choixTuile;
    }

    public String getStatut() {
        return statut;
    }

    public String[][] getMap() {
        return map;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setChoixTuile(int choixTuile) {
        this.choixTuile = choixTuile;
    }

    public void setMap(String[][] map) {
        this.map = map;

    }

    public void ajoutMap(String value, int x, int y){
        this.map[y][x] = value;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
}
