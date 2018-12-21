

//tour de jeux//


package mainPackage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

//import static sun.swing.MenuItemLayoutHelper.max;


class Jouer {
	
	private static Random rand = new Random();
	
	private static ArrayList<String> roi = new ArrayList<String>();
	private static String[] plateau = new String[4];
	private static int indicetuile;
	private static int compteurtour = 0;
	private static String[] newroi;
	private static int[] domi = new int[48];
	private static ArrayList<Integer> listedominos = new ArrayList<Integer>();
	private static ArrayList<Integer> listedominoscopy = new ArrayList<>();
	private static int[] choixtuile;
	
	static void play(Composant composant, Scanner scanner) {
		debutjeux(composant);
		tour(composant, scanner);
	}

    private static void debutjeux(Composant composant) {

		
	    // initialisation des plateaux
	    for (int i = 0; i < composant.getNombreJoueurs(); i++) {
	    	composant.getListJoueurs()[i].setMap(new String[5][5]);
	    	for (int x = 0; x < composant.getListJoueurs()[i].getMap().length; x++){
	    		for (int y = 0; y < composant.getListJoueurs()[i].getMap().length; y++ ){
	    			composant.getListJoueurs()[i].ajoutMap("0", x, y);
				}
			}
	    	composant.getListJoueurs()[i].ajoutMap("500", 2, 2);
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
	    	roi.add("rouge");
	    	roi.add("rouge");
	   		roi.add("bleu");
	   		roi.add("bleu");
	   	} else if (composant.getNombreJoueurs() == 3) {
	   		roi.add("rouge");
    		roi.add("bleu");	    		
    		roi.add("vert");
	   	} else {
	    	roi.add("rouge");
	    	roi.add("bleu");
	   		roi.add("vert");
	   		roi.add("jaune");
	   	}
	    	
	    // initialisation ordre de jeux
	   	for (int i = 0; i < roi.size(); i++) {
	   		int nb = rand.nextInt(roi.size()-i);
	   		String transition = roi.get(nb);
	   		roi.set(nb,roi.get(roi.size()-i-1));
    		roi.set(roi.size()-i-1, transition);
    	}
	    	
	    //initialisation du jeux de domino
	    	
	   	//creation d'une liste de dominos
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
	    
	    System.out.print("[ ");
	    for (int i = 0; i < composant.getNombreDominos(); i++) {
	    	System.out.print(domi[i] + " ");
	    }
	    System.out.print("]");
	    
	    System.out.println(" ");
	    System.out.println("Ordre de jeux");
	    System.out.println(roi + "\n");
	    
	    //Affichage plateau
	    for (int i = 0; i < composant.getNombreJoueurs(); i++) {
	    	affichageMap(i, composant);
	    	System.out.println();
	    	System.out.println();
	    }
	}

    private static void tiretuile() {
    	//tire nb de roi cartes
		listedominos = new ArrayList<>();
    	for (int i = 0; i < roi.size(); i++) {
    		listedominos.add(domi[i+roi.size()*compteurtour]);
    	}
    	Collections.sort(listedominos);
    }
    
    private static void choixdetuile(int i, Scanner scanner, Joueurs joueurs, Composant composant) {
    	
    	boolean bool = true;
	
    	// while pour vérifier qu'on ne choisie pas une tuile déja occupé
		while (bool) {
 
    		System.out.println("Tuile disponible : ");
    		System.out.print("[ ");

			for (Integer listedomino : listedominos) {
				System.out.print(listedomino + " ");
			}

    	    System.out.print("]");

			joueurs.ChoixTuile(convertisseur(listedominos), composant, scanner);

    		System.out.println("le joueur : " + joueurs.getPseudo() + " place son roi sur la tuile : " + listedominos.get(joueurs.getChoixTuile()));

    		//indicetuile = scanner.nextInt();
			indicetuile = joueurs.getChoixTuile();

    		newroi[i] = roi.get(i);

    		if (choixtuile[indicetuile] == listedominos.get(indicetuile)) {
    			System.out.print("Cette tuile a déja été choisie ! >Choisissez une autre tuile");
    		} else {
    			choixtuile[indicetuile] = listedominos.get(indicetuile);
    			bool =  false;
    		}

			listedominoscopy.add(indicetuile, listedominos.get(indicetuile));
			listedominos.remove(indicetuile);
		}
    }

    private static String[] convertisseur (ArrayList<Integer> liste){
		String[] listeConv = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++){
			listeConv[i] = String.valueOf(liste.get(i));
		}
		return listeConv;
	}
    
    private static void choixduplacement(int i, Scanner scanner, Composant composant) {
    	
    	System.out.println("le joueur : " + roi.get(i) + " place sa tuile.");
    	composant.getListJoueurs()[i].setPositions(scanner);
		
		for (int j = 0; j < roi.size(); j++) {
			if (roi.get(i).equals(plateau[j])) {
				composant.getListJoueurs()[i].ajoutMap(listedominoscopy.get(composant.getListJoueurs()[i].getChoixTuile()) + "1", composant.getListJoueurs()[i].getPositions()[0], composant.getListJoueurs()[i].getPositions()[1]);
				composant.getListJoueurs()[i].ajoutMap(listedominoscopy.get(composant.getListJoueurs()[i].getChoixTuile()) + "2", composant.getListJoueurs()[i].getPositions()[2], composant.getListJoueurs()[i].getPositions()[3]);
			}
		}	
    }
    
    private static void affichageMap(int i, Composant composant) {
    	for (int j = 0; j < 5; j++) {
	    	System.out.print("[ ");
	    	for (int k = 0; k < 5; k++) {
	   			System.out.print(composant.getListJoueurs()[i].getMap()[j][k] + " ");
	   		}
	   		System.out.print("]");
	   		System.out.println(" ");
    		System.out.println(" ");
	    	}
	    	System.out.println();
	    	System.out.println();
    }
    
    private static void tour(Composant composant, Scanner scanner){

    	choixtuile = new int[roi.size()];
    	newroi = new String[roi.size()];

    	while (roi.size()*compteurtour < composant.getNombreDominos()) {
    		
    		//on tire les tuiles
    		tiretuile();
	    	
    		//chaque roi choisie sa tuile
	    	for (int i = 0; i < roi.size(); i++) {
	    		
	    		boolean bo = true;
	    		
	    		while(bo) {
		    		try {
		    			choixdetuile(i, scanner, composant.getListJoueurs()[i], composant);
		    			bo = false;
		    		} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(composant.getListJoueurs()[0].getChoixTuile());
						System.out.println(composant.getListJoueurs()[1].getChoixTuile());
		    			System.out.println("Attention il faut choisir l'indice de la tuile !");
		    			System.out.println("Les indices commencent à 0 !");
		    			String[] args =new String[]{};
		    			Main.main(args);
		    		}
	    		}
	    	}
	    	
	    	//on redéfinie l'ordre de jeux en fonction du placement
	    	for (int i = 0; i < roi.size(); i++) {
	    		roi.set(i, newroi[i]);
	    	}
	    	
	    	//chaque roi place sa tuile
	    	for (int i = 0; i < roi.size(); i++) {
	    		
	    		boolean boo = true;
	    		
	    		while (boo) {
	    			try {
	    				choixduplacement(i, scanner, composant);
	    				boo = false;
	    			} catch (ArrayIndexOutOfBoundsException e) {
	    				System.out.println("La tuile doit étre placé dans la plateau de taille 5*5 !");
	    			}
	    		}
	    	}
	    	
	    	//on affiche les plateaux
	    	for (int i = 0; i < roi.size(); i++) {
	    	    affichageMap(i, composant);
	   	    }
	    	
	    	//on reeset les choix
	    	for (int i = 0; i < roi.size(); i++) {
	    		choixtuile[i] = 500;
	    	}
	    	
	    	compteurtour+=1;
    	}

    	int max = 0;
    	int winner = 0;
    	int score;

    	for (int i = 0; i < roi.size(); i++){
    		if ((score = CalcScore.play(composant.getListJoueurs()[i], composant)) > max){
    			max = score;
    			winner = i;
			}
		}
		System.out.println("Le joueur qui a gagné est : " + composant.getListJoueurs()[winner].getPseudo());
    }
}
