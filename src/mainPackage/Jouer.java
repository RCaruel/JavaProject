

//tour de jeux//


package mainPackage;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

//import static sun.swing.MenuItemLayoutHelper.max;


public class Jouer {
	
	static Random rand = new Random();
	
	static ArrayList<String> roi = new ArrayList<String>();
	static String[] plateau = new String[4];
	static int indicetuile;
	static int compteurtour = 0;
	static String[] newroi;
	static int[] domi = new int[48];
	static ArrayList<Integer> listedominos = new ArrayList<Integer>();
	static int[] choixtuile;

	static int x = 0;
	static int y = 0;
	static int x1 = 0;
	static int y1 = 1;
	
	public static void play(Composant composant, Scanner scanner) {
		debutjeux(composant, scanner);
		tour(composant, scanner);
	}

    public static void debutjeux(Composant composant, Scanner scanner) {

		
	    // initialisation des plateaux
	    for (int i = 0; i < composant.getNombreJoueurs(); i++) {
	    	composant.getListJoueurs()[i].setMap(new String[5][5]);
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
	    System.out.println(roi);
	    System.out.println("");
	    
	    //Affichage plateau
	    for (int i = 0; i < composant.getNombreJoueurs(); i++) {
	    	affichageMap(i, composant);
	    	System.out.println();
	    	System.out.println();
	    }
	}

    public static void tiretuile() {
    	//tire nb de roi cartes
		listedominos = new ArrayList<>();
    	for (int i = 0; i < roi.size(); i++) {
    		listedominos.add(domi[i+roi.size()*compteurtour]);
    	}
    	Collections.sort(listedominos);
    }
    
    public static void choixdetuile(int i, Scanner scanner) {
    	
    	boolean bool = true;
	
    	// while pour vérifier qu'on ne choisie pas une tuile déja occupé
		while (bool) {
 
    		System.out.println("Tuile disponible : ");
    		System.out.print("[ ");
    	    for (int j = 0; j < roi.size(); j++) {
    	    	System.out.print(listedominos.get(j) + " ");
    	    }
    	    System.out.print("]");

    		System.out.println("le joueur : " + roi.get(i) + " place son roi sur une tuile.");

    		//indicetuile = scanner.nextInt();
			indicetuile = i;
			System.out.println(i);

    		newroi[indicetuile] = roi.get(i);

    		if (choixtuile[indicetuile] == listedominos.get(indicetuile)) {
    			System.out.print("Cette tuile a déja été choisie ! >Choisissez une autre tuile");
    		} else {
    			choixtuile[indicetuile] = listedominos.get(indicetuile);
    			bool =  false;
    		}
		}
    }
    
    public static void choixduplacement(int i, Scanner scanner, Composant composant) {
    	
    	System.out.println("le joueur : " + roi.get(i) + " place sa tuile.");
		
		System.out.println("abscisse de la premiére demi tuile :");
		//x = scanner.nextInt();
		System.out.println(x);
		System.out.println("ordonnée de la premiére demi tuile :");
		//y = scanner.nextInt();
		System.out.println(y);
		System.out.println("abscisse de la deuxiéme demi tuile :");
		//x1 = scanner.nextInt();
		System.out.println(x1);
		System.out.println("ordonnée de la deuxiéme demi tuile :");
		//y1 = scanner.nextInt();
		System.out.println(y1);

		y += 2;
		y1 += 2;
		if (y > 4){
			y = y - 5;
			x++;
		}
		if (y1 > 5){
			y1 = y1 - 5;
			x1++;
		}
		if (x > 4 || x1 > 4){
			x = 0;
			x1 = 0;
		}

		
		for (int j = 0; j < roi.size(); j++) {
			if (roi.get(i).equals(plateau[j])) {
				composant.getListJoueurs()[j].ajoutMap(choixtuile[j] + "1", x, y);
				composant.getListJoueurs()[j].ajoutMap(choixtuile[j] + "2", x1, y1);
			}
		}	
    }
    
    public static void affichageMap(int i, Composant composant) {
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
    
    public static void tour(Composant composant, Scanner scanner){

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
		    			choixdetuile(i, scanner);
		    			bo = false;
		    		} catch (ArrayIndexOutOfBoundsException e) {
		    			System.out.println("Attention il faut choisir l'indice de la tuile !");
		    			System.out.println("Les indices commencent à 0 !");	
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

			System.out.println("Le joueur qui a gagné est : " + composant.getListJoueurs()[i].getPseudo());
		}
    }
}
