package mainPackage;

class CalcScore {

    /**
     *
     * @param joueurs le joueur dont on veut calculer le score.
     * @param composant la boite du jeu.
     * @return retourne la valeure du terrain.
     */

    static int play(Joueurs joueurs, Composant composant, boolean bool){
        String[][] map = new String[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                map[i][j] = joueurs.getMap()[i][j];
            }
        }
        return calcule(map, composant, bool);
    }

    private static int calcule(String[][] map, Composant composant, boolean bool){

        int score = 0;
        int[] sc;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

                //calcul du score à partir de cette tuile si elle n'a pas la valeur "999"
                try {
                    if (not(map[i][j].equals("999"))) {
                        String value = composant.getDominos().get(map[i][j])[1];
                        sc = calcScore(map, composant, i, j, value, 1, Integer.valueOf(composant.getDominos().get(map[i][j])[0]));
                        if (bool) System.out.println(sc[1] + "*" + sc[0]);
                        score += sc[1] * sc[0];
                    }
                }catch (NullPointerException ignored){}
            }
        }

        if (bool) System.out.println("------------------------------------");
        return score;

    }

    /**
     * fct qui retroune faux si la condition est vraie et inversement.
     * @param bool boolean
     * @return not bool
     */

    private static boolean not(boolean bool) {
        return !bool;
    }

    /**
     *
     * @param map map du joueur
     * @param composant boite de jeu
     * @param i position i sur la map du joueur
     * @param j position j sur la map du joueur
     * @param value valeur du type du terrain qu'on test
     * @param score score actuel
     * @param couronnes nombre actuel de couronne
     * @return le score du joueur.
     */

    private static int[] calcScore(String[][] map, Composant composant, int i, int j, String value, int score, int couronnes) {
        int[] calcul;
        map[i][j]= "999";

        //Essai de calcul du score à partir de la map à la position [i][j+1]
        try {
            if (composant.getDominos().get(map[i][j+1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j+1,value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i][j+1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException | NullPointerException ignored){ }

        //Essai de calcul du score à partir de la map à la position [i+1][j]
        try {
            if (composant.getDominos().get(map[i+1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i+1,j, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i+1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];

            }
        }catch(IndexOutOfBoundsException | NullPointerException ignored){}

        //Essai de calcul du score à partir de la map à la position [i][j-1]
        try {
            if (composant.getDominos().get(map[i][j-1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j-1, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i][j-1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException | NullPointerException ignored){}

        //Essai de calculer le score à partir de la map à la position [i-1][j]
        try {
            if (composant.getDominos().get(map[i-1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i-1,j, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i-1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException | NullPointerException ignored){}

        return new int[]{score, couronnes};
    }

    /**
     * fonction qui calcule la taille de la map
     * @param map
     * @return
     */
    static int scoreMap(String[][] map){
        int score = 0;

        for (String[] aMap : map) {
            for (int j = 0; j < map.length; j++) {
                if (!(aMap[j].equals("0"))) {
                    score++;
                }
            }
        }

        return score;
    }

    /**
     * Fonction qui calcul le nombre de couronnes sur la map
     * @param map
     * @param composant
     * @return
     */
    static int nbCouronnes(String[][] map, Composant composant){
        int score = 0;

        for (String[] aMap : map) {
            for (int j = 0; j < map.length; j++) {
                try {
                    score += Integer.valueOf(composant.getDominos().get(aMap[j])[0]);
                }catch (NullPointerException ignore){}
            }
        }

        return score;
    }
}