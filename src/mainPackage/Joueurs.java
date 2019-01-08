package mainPackage;


import java.util.Scanner;

//type database
public class Joueurs {
	
    private String choixTuile;
    private String pseudo;
    private String couleur;
    private String[][] map;
    private String statut = "UNDETERMINED";
    private int[] positions = new int[4];

    public String getCouleur() {
        return couleur;
    }

    String getChoixTuile() {
        return choixTuile;
    }

    String getPseudo() {
        return pseudo;
    }

    String getStatut(){ return statut; }

    String ChoixTuile(String[] listdominos, Composant composant, Scanner scanner) {
        if (this.statut.equals("IA")){
            this.positions = ia.choixtuileia(this, listdominos, composant);
            if (this.positions[0] != -1) {
                this.ajoutMap(this.choixTuile + "1", this.positions[0], this.positions[1]);
                this.ajoutMap(this.choixTuile + "1", this.positions[2], this.positions[3]);
            }
            return this.choixTuile;
        }else{
            this.choixTuile = scanner.nextLine();
            return this.choixTuile;
        }
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

    int[] getPositions() {
        return positions;
    }

    void setPositions(Scanner scanner) {
        if (statut.equals("HUMAN")){
            System.out.println("abscisse de la premiere demi tuile :");
            this.positions[0] = scanner.nextInt();
            System.out.println("ordonnee de la premiere demi tuile :");
            this.positions[1] = scanner.nextInt();
            System.out.println("abscisse de la deuxieme demi tuile :");
            this.positions[2] = scanner.nextInt();
            System.out.println("ordonnee de la deuxieme demi tuile :");
            this.positions[3] = scanner.nextInt();
        }
    }
}
