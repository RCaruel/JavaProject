package mainPackage;


import java.util.Scanner;

//type database
public class Joueurs {
	
    private int choixTuile;
    private String pseudo;
    private String couleur;
    private String[][] map;
    private String statut = "UNDETERMINED";
    private int[] positions = new int[4];

    public String getCouleur() {
        return couleur;
    }

    int getChoixTuile() {
        return choixTuile;
    }

    String getPseudo() {
        return pseudo;
    }

    int ChoixTuile(String[] listdominos, Composant composant, Scanner scanner) {
        if (this.statut.equals("IA")){
            positions = ia.choixtuileia(this, listdominos, composant);
            return this.choixTuile;
        }else{
            this.choixTuile = scanner.nextInt();
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

    void setChoixTuile(int choixTuile) {
        this.choixTuile = choixTuile;
    }

    void setMap(String[][] map) {
        this.map = map;
    }

    void ajoutMap(String value, int x, int y){
        this.map[y][x] = value;
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
