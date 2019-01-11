package mainPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//type database, variable final
public class Composant {

    int nombreDominos;
    int nombreJoueurs;
    Joueurs[] listJoueurs = new Joueurs[4];
    Map<String , String[]> dominos = new HashMap<>(); 

    public int getNombreDominos() {
        return this.nombreDominos;
    }

    public int getNombreJoueurs() {
        return this.nombreJoueurs;
    }

    public Map<String, String[]> getDominos() {
        return this.dominos;
    }

    public Joueurs[] getListJoueurs() {
        return listJoueurs;
    }

    public void setDominos() {
        String RESOURCES_PATH = "src/ressources/";
        String DOMINOS_FILE_NAME = "dominos.csv";
        String ligne = "";
        String SEPARATOR = ",";
        String[] cartes;

        try {
            File file = new File(RESOURCES_PATH + DOMINOS_FILE_NAME);

            BufferedReader buff = new BufferedReader(new FileReader(file));

            int i = 0;

            while ((ligne = (buff).readLine()) != null) {

                cartes = ligne.split(SEPARATOR);

                if (i > 0) {
                    //Remplissage du dictionnaire contenant toutes les demi-cartes
                    this.dominos.put(cartes[4] + "1", new String[]{cartes[0], cartes[1]});
                    this.dominos.put(cartes[4] + "2", new String[]{cartes[2], cartes[3]});
                }

                i++;
            }

            //Ajout du chateau dans le dictionnaire des dominos
            this.dominos.put("501", new String[]{"0", "chateau"});
            this.dominos.put("0", new String[]{"0", "vide"});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNombreDominos(int nombreDominos) {
        this.nombreDominos = nombreDominos;
    }

    public void setNombreJoueurs(int nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
        this.listJoueurs = new Joueurs[nombreJoueurs];
    }
}
