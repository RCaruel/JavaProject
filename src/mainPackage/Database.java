package mainPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database {

    //--- Données pour lire le fichier dominos.csv ---//

    static String RESOURCES_PATH = "src/ressources/";
    static String DOMINOS_FILE_NAME = "dominos.csv";
    static String ligne = "";
    static String SEPARATOR = ",";
    static String[] cartes;

    //--- Données qui contiennent les scores de chaque joueurs ---//

    static int scorePlayer1;
    static int scorePlayer2;
    static int scorePlayer3;
    static int scorePlayer4;
    

    //--- Données qui contient la map de chaque joueurs ---//

    String[][] mapPlayer1 = new String[5][5];
    String[][] mapPlayer2 = new String[5][5];
    String[][] mapPlayer3 = new String[5][5];
    String[][] mapPlayer4 = new String[5][5];

    //--- Donnée qui contient tous les dominos séparés en moitiés ---//

    static Map<String , String[]> dominos = new HashMap<>();

    public static void init(){

        scorePlayer1 = 0;
        scorePlayer2 = 0;
        scorePlayer3 = 0;
        scorePlayer4 = 0;



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

}
