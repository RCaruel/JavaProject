package mainPackage;

import java.util.HashMap;
import java.util.Map;

//type database, variable final

/**
 * C'est la boite du jeu contenant les joueurs avec leur terrain et les dominos
 */

class Composant {

    private int nombreDominos;
    private int nombreJoueurs;
    private Joueurs[] listJoueurs = new Joueurs[4];
    private Map<String , String[]> dominos = new HashMap<>();

	int getNombreDominos() {
        return this.nombreDominos;
    }

    int getNombreJoueurs() {
        return this.nombreJoueurs;
    }

    Map<String, String[]> getDominos() {
        return this.dominos;
    }

    Joueurs[] getListJoueurs() {
        return listJoueurs;
    }

    /**
     * Fonction d'initialisation de la map des dominos
     */
    void setDominos() {
		String stringDominos = "0,Champs,0,Champs,1\n" +
				"0,Champs,0,Champs,2\n" +
				"0,Foret,0,Foret,3\n" +
				"0,Foret,0,Foret,4\n" +
				"0,Foret,0,Foret,5\n" +
				"0,Foret,0,Foret,6\n" +
				"0,Mer,0,Mer,7\n" +
				"0,Mer,0,Mer,8\n" +
				"0,Mer,0,Mer,9\n" +
				"0,Prairie,0,Prairie,10\n" +
				"0,Prairie,0,Prairie,11\n" +
				"0,Mine,0,Mine,12\n" +
				"0,Champs,0,Foret,13\n" +
				"0,Champs,0,Mer,14\n" +
				"0,Champs,0,Prairie,15\n" +
				"0,Champs,0,Mine,16\n" +
				"0,Foret,0,Mer,17\n" +
				"0,Foret,0,Prairie,18\n" +
				"1,Champs,0,Foret,19\n" +
				"1,Champs,0,Mer,20\n" +
				"1,Champs,0,Prairie,21\n" +
				"1,Champs,0,Mine,22\n" +
				"1,Champs,0,Montagne,23\n" +
				"1,Foret,0,Champs,24\n" +
				"1,Foret,0,Champs,25\n" +
				"1,Foret,0,Champs,26\n" +
				"1,Foret,0,Champs,27\n" +
				"1,Foret,0,Mer,28\n" +
				"1,Foret,0,Prairie,29\n" +
				"1,Mer,0,Champs,30\n" +
				"1,Mer,0,Champs,31\n" +
				"1,Mer,0,Foret,32\n" +
				"1,Mer,0,Foret,33\n" +
				"1,Mer,0,Foret,34\n" +
				"1,Mer,0,Foret,35\n" +
				"0,Champs,1,Prairie,36\n" +
				"0,Mer,1,Prairie,37\n" +
				"0,Champs,1,Mine,38\n" +
				"0,Prairie,1,Mine,39\n" +
				"1,Montagne,0,Champs,40\n" +
				"0,Champs,2,Prairie,41\n" +
				"0,Mer,2,Prairie,42\n" +
				"0,Champs,2,Mine,43\n" +
				"0,Prairie,2,Mine,44\n" +
				"2,Montagne,0,Champs,45\n" +
				"0,Mine,2,Montagne,46\n" +
				"0,Mine,2,Montagne,47\n" +
				"0,Champs,3,Montagne,48";
		String[] cartesbcl = stringDominos.split("\n");
    	String[][] cartes = new String[48][5];

		for (int i = 0; i < cartesbcl.length; i++) {
			cartes[i] = cartesbcl[i].split(",");
		}

		System.out.print("[");
		for (String[] carte : cartes) {
			System.out.print("[ ");
			for (String aCarte : carte) {
				System.out.print(aCarte + ", ");
			}
			System.out.print("]");
		}
		System.out.println("]");

		for (String[] carte : cartes) {
			System.out.println(carte[4] + "1" + " : " + carte[0] + ", " + carte[1]);
			dominos.put(carte[4] + "1", new String[]{carte[0], carte[1]});
			dominos.put(carte[4] + "2", new String[]{carte[2], carte[3]});
		}
		dominos.put("500", new String[]{"0", "0"});
		dominos.put("0", new String[]{"0", "0"});
		}
    
    void setNombreDominos(int nombreDominos) {
        this.nombreDominos = nombreDominos;
    }

    void setNombreJoueurs(int nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
        this.listJoueurs = new Joueurs[nombreJoueurs];
    }
}
