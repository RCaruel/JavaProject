

//tour de jeux//


package mainPackage;
import java.io.BufferedReader;
import java.awt.List;
import java.io.*;
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



public class Jouer {
	
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<String> roi = new ArrayList<String>();
    static String[][][] mapPlayer = new String[4][5][5];
	static int nbDominos;
	static int[] indicedominos;
	
    static String RESOURCES_PATH = "src/ressources/";
    static String DOMINOS_FILE_NAME = "dominos.csv";
    static String ligne = "";
    static String SEPARATOR = ",";
    static String[] cartes;
	static Map<String , String[]> dominos = new HashMap<>();
	
	public static void play() {
		mapDominos();
		debutjeux();
		tour();
	}
    
	public static void mapDominos(){

        // Lecture du fichier dominos.csv
        try {
            File file = new File(RESOURCES_PATH + DOMINOS_FILE_NAME);

            BufferedReader buff = new BufferedReader(new FileReader(file));

            int i = 0;

            while ((ligne = (buff).readLine()) != null) {

                cartes = ligne.split(SEPARATOR);

                if (i > 0) {
                    //Remplissage du dictionnaire contenant toutes les demi-cartes
                    dominos.put(cartes[4] + "1", new String[]{cartes[0], cartes[1]});
                    dominos.put(cartes[4] + "2", new String[]{cartes[2], cartes[3]});
                }

                i++;
            }

            //Ajout du chateau dans le dictionnaire des dominos
            dominos.put("500", new String[]{"0", "chateau"});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
    public static void debutjeux() {

		System.out.println("choisir le nombre de joueurs :");
		int nbJoueurs = scan.nextInt();
		
	    // initialisation des plateaux
	    for (int i = 0; i < nbJoueurs; i++) {
	    	mapPlayer[i][2][2] = "500 ";
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
	    indicedominos = new int[nbDominos];
	    
	    for ( int i = 0; i < nbDominos; i++) {
	    	indicedominos[i] = domi[i];
	    }
	    
	    System.out.print("[ ");
	    for (int i = 0; i < nbDominos; i++) {
	    	System.out.print(indicedominos[i] + " ");
	    }
	    System.out.print("]");
	    
	    System.out.println(" ");
	    System.out.println("Ordre de jeux");
	    System.out.println(roi);
	    System.out.println("");
	    
	    //Affichage plateau
	    for (int i = 0; i < nbJoueurs; i++) {
	    	for (int j = 0; j < 5; j++) {
	    		System.out.print("[ ");
	    		for (int k = 0; k < 5; k++) {
	    			System.out.print(mapPlayer[i][j][k] + " ");
	    		}
	    		System.out.print("]");
	    		System.out.println(" ");
	    		System.out.println(" ");
	    	}
	    	System.out.println();
	    	System.out.println();
	    }       
	}

    public static void tour(){
    	
    	int compteurtour = 0;
    	
    	while (3*compteurtour < nbDominos) {
	    	//tire nb de roi cartes
	    	ArrayList<Integer> listedominos = new ArrayList<Integer>();
	    	ArrayList<String> newroi = new ArrayList<String>();
	    	for (int i = 0; i < roi.size(); i++) {
	    		listedominos.set(i,indicedominos[i+3*compteurtour]);
	    	}
	    	Collections.sort(listedominos);
	    	
	    	for (int i = 0; i < roi.size(); i++) {
	    		System.out.println("Tuile disponible : ");
	    		System.out.print("[ ");
	    	    for (int j = 0; j < roi.size(); j++) {
	    	    	System.out.print(listedominos.get(j) + " ");
	    	    }
	    	    System.out.print("]");
	    		
	    		System.out.println("le joueur : " + roi.get(i) + " choisie une tuile.");
	    		int indicetuile = scan.nextInt();
	    		listedominos.remove(indicetuile);
	    		newroi.set(indicetuile, roi.get(i));
	    	}
	    	for (int i = 0; i < roi.size(); i++) {
	    		roi.set(i, newroi.get(i));
	    		newroi.remove(i);
	    	}
	    	compteurtour+=1;
    	}
    	
    	
    	

    	
    	
    	
    	
    	
    	
    }

}
