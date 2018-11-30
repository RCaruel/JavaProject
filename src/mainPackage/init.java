package mainPackage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class init {
	
	static ArrayList<String> roi = new ArrayList<String>();
	static ArrayList<String> ordreroi = new ArrayList<String>();
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	
    //static String[][] mapPlayer1 = new String[5][5];
    //static String[][] mapPlayer2 = new String[5][5];
    //static String[][] mapPlayer3 = new String[5][5];
    //static String[][] mapPlayer4 = new String[5][5];
    
    static String[][][] mapPlayer = new String[4][5][5];
	
    static int nbDominos;
	
	public static void jeux() {

		System.out.println("choisir le nombre de joueurs :");
		int nbJoueurs = scan.nextInt();
		
	    // initialisation des plateaux
	    for (int i = 0; i < nbJoueurs; i++) {
	    	mapPlayer[i][2][2] = "500";  //créer mapPlayer dans database
	    }
	    	
	    // initialisation des rois
	    if (nbJoueurs == 2) {
	    	roi.add("rouge");
	    	roi.add("rouge");
	   		roi.add("bleu");
	   		roi.add("bleu");
	   	} else if (nbJoueurs == 3) {
	   		roi.add("rouge");
    		roi.add("bleu");	    		
    		roi.add("vert");
	   	} else {
	    	roi.add("rouge");
	    	roi.add("bleu");
	   		roi.add("vert");
	   		roi.add("jaune");
	   	}
	    	
	    // initialisation odre de jeux
	   	for (int i = 0; i < roi.size(); i++) {
	   		int nb = rand.nextInt(roi.size()-i);
	   		String transition = roi.get(nb);
	   		roi.set(nb,roi.get(roi.size()-i-1));
    		roi.set(roi.size()-i-1, transition);
    	}
	    	
	    //initialisation du jeux de domino
	    	
	   	//creation d'une liste de dominos
	    int[] domi = new int[48];
	   	for (int i = 1; i <= 48; i++) {
	   		domi[i-1] = i;
	   	}
	    	
	    //mélange de la liste
	    for (int i = 0; i < 48; i++) {
	   		int nb = rand.nextInt(48-i);
	   		int transition = domi[nb];
	   		domi[nb] = domi[48-i-1];
	   		domi[48-i-1] = transition;
    	}
	    
	    nbDominos = 48 - 12*(4-nbJoueurs);
	    
	    int[] dominos = new int[nbDominos];
	    for ( int i = 0; i < nbDominos; i++) {
	    	dominos[i] = domi[i];
	    }
	    
	    
	    for (int i = 0; i < nbDominos; i++) {
	    	System.out.print(dominos[i] + " , ");
	    }
	    
	    System.out.println("ordre de jeux");
	    System.out.println(roi);
	    
	    //Affichage plateau
	    for (int i = 0; i < 4; i++) {
	    	for (int j = 0; j < 5; j++) {
	    		for (int k = 0; k < 5; k++) {
	    			System.out.print(mapPlayer[i][j][k] + " ");
	    		}
	    		System.out.println();
	    	}
	    	System.out.println();
	    	System.out.println();
	    }       
	}
}


