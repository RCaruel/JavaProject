package mainPackage;


//type database
public class Joueurs {
	
    private String choixTuile = "";
    private String choixTuile2;
    private boolean choixTuile1IsPlaced = true;
    private String pseudo;
    private String couleur;
    private String[][] map;
    private String statut = "UNDETERMINED";
    private int[] positions = new int[4];
    private int score;

    String getCouleur() {
        return couleur;
    }

    int[] getPositions() {
        return positions;
    }

    String getChoixTuile2(){
        return choixTuile2;
    }

    int getScore(){
        return score;
    }

    String getChoixTuile() {
        return choixTuile;
    }

    String getPseudo() {
        return pseudo;
    }

    String getStatut(){ return statut; }

    public boolean isChoixTuile1IsPlaced() {
        return choixTuile1IsPlaced;
    }

    void ChoixTuile(String[] listdominos, Composant composant, String indexDominos) {
        if (this.statut.equals("IA")){

            this.positions = ia.choixtuileia(this, listdominos, composant);

            if (this.positions[0] != -1) {
                this.ajoutMap(this.choixTuile + "1", this.positions[0], this.positions[1]);
                this.ajoutMap(this.choixTuile + "2", this.positions[2], this.positions[3]);
            }

        }else{
            if (this.choixTuile.equals("")) {
                this.choixTuile = indexDominos;
            }else {
                this.choixTuile2 = indexDominos;
                this.choixTuile1IsPlaced = false;
            }
        }
    }

    String[][] getMap() {
        return map;
    }

    String getMapId(int i, int j){
        return map[i][j];
    }

    public void setChoixTuile1IsPlaced(boolean choixTuile1IsPlaced) {
        choixTuile1IsPlaced = choixTuile1IsPlaced;
    }

    void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    void setChoixTuile(String choixTuile) {
        this.choixTuile = choixTuile;
    }

    void setMap(String[][] map) {
        this.map = map;
    }

    void ajoutMap(String value, int x, int y){
        //9
        this.map[x][y] = value;
    } 

    void setStatut(String statut) {
        this.statut = statut;
    }
    void setScore(int score){
        this.score = score;
    }

}
