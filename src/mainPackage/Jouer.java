

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
	private static int compteurtour;
	private static String[] newroi;
	private static int[] domi = new int[48];
	private static ArrayList<Integer> listedominos = new ArrayList<>();
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

	    for (int i = 0; i < 4; i++){
	    	listedominoscopy.add(0,0);
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

    		System.out.println("le joueur : " + joueurs.getPseudo() + " place son roi sur la tuile : " + joueurs.getChoixTuile());

    		//indicetuile = scanner.nextInt();
			indicetuile = listedominos.indexOf(Integer.valueOf(joueurs.getChoixTuile()));

    		newroi[listedominoscopy.indexOf(Integer.valueOf(joueurs.getChoixTuile()))] = roi.get(i);

    		if (choixtuile[indicetuile] == listedominos.get(indicetuile)) {
    			System.out.print("Cette tuile a déja été choisie ! >Choisissez une autre tuile");
    		} else {
    			choixtuile[indicetuile] = listedominos.get(indicetuile);
    			bool =  false;
    		}
			System.out.println(listedominoscopy);
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
		getJoueur(composant.getListJoueurs(), roi.get(i)).setPositions(scanner);

		for (int j = 0; j < roi.size(); j++) {
			if (roi.get(i).equals(plateau[j]) && getJoueur(composant.getListJoueurs(), roi.get(i)).getStatut().equals("HUMAN")) {
				getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile() + "1", getJoueur(composant.getListJoueurs(), roi.get(i)).getPositions()[0], getJoueur(composant.getListJoueurs(), roi.get(i)).getPositions()[1]);
				getJoueur(composant.getListJoueurs(), roi.get(i)).ajoutMap(getJoueur(composant.getListJoueurs(), roi.get(i)).getChoixTuile() + "2", getJoueur(composant.getListJoueurs(), roi.get(i)).getPositions()[2], getJoueur(composant.getListJoueurs(), roi.get(i)).getPositions()[3]);

			}
		}
	}
    
    private static void affichageMap(int i, Composant composant) {
    	for (int j = 0; j < 5; j++) {
	    	System.out.print("[ ");
	    	for (int k = 0; k < 5; k++) {
	   			System.out.print(composant.getDominos().get(composant.getListJoueurs()[i].getMap()[j][k])[1] + "," + composant.getDominos().get(composant.getListJoueurs()[i].getMap()[j][k])[0] + " ");
	   		}
	   		System.out.print("]");
	   		System.out.println(" ");
    		System.out.println(" ");
	    	}
	    	System.out.println();
	    	System.out.println();
    }

    private static Joueurs getJoueur(Joueurs[] listjoueur, String couleur){
		for (int i = 0; i < listjoueur.length; i++){
			if (listjoueur[i].getCouleur().equals(couleur)){
				return listjoueur[i];
			}
		}
		return listjoueur[0];
	}
    
    private static void tour(Composant composant, Scanner scanner){

    	choixtuile = new int[roi.size()];
    	newroi = new String[roi.size()];
    	compteurtour = 0;


    	while (roi.size()*compteurtour < composant.getNombreDominos()) {
    		
    		//on tire les tuiles
    		tiretuile();

    		for (int i =0; i < listedominos.size(); i++) {
				listedominoscopy.set(i, listedominos.get(i));
			}

    		//chaque roi choisie sa tuile
	    	for (int i = 0; i < roi.size(); i++) {
	    		
	    		boolean bo = true;
	    		
	    		while(bo) {
		    		try {
		    			choixdetuile(i, scanner, getJoueur(composant.getListJoueurs(),roi.get(i)), composant);

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

			for (String aNewroi : newroi) {
				System.out.println(aNewroi);
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
	    	for (int i = 0; i < composant.getListJoueurs().length; i++) {
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

    	for (int i = 0; i < composant.getListJoueurs().length; i++){
    		if ((score = CalcScore.play(composant.getListJoueurs()[i], composant, true)) > max){
    			max = score;
    			winner = i;
			}
		}
		System.out.println("Le joueur qui a gagné est : " + composant.getListJoueurs()[winner].getPseudo() + " avec un score de " + max);
    }
}
