package mainPackage;

public class CalcScore {

    /**
     * Fct qui fait appel à la fonction  calcScore pour calculer le score de la map
     * @param map
     * @param database
     * @return le score du joueur
     */

    public static int play(String[][] map, Database database){

        int score = 0;
        int[] sc;

        // Boucle qui parcours la map du joueur
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

                //calcul du score à partir de cette tuile si elle n'a pas la valeur "999"
                try {
                    if (not(map[i][j].equals("999"))) {
                        String value = map[i][j];
                        sc = calcScore(map, database, i, j, value, 1, 0);
                        System.out.println(value + " - " + sc[0] + "x" + sc[1]);
                        score += sc[1] * sc[0];
                    }
                }catch (NullPointerException e){}
            }
        }

        return score;

    }

    /**
     * fct qui retroune faux si la condition est vraie et inversement.
     * @param bool
     * @return not bool
     */

    public static boolean not(boolean bool) {
        if (bool){
            return false;
        }else{
            return true;
        }
    }

    /**
     *
     * @param map
     * @param database
     * @param i
     * @param j
     * @param value
     * @param score
     * @param couronnes
     * @return Score d'un type de case sur la map
     */

    public static int[] calcScore(Object[][] map, Database database, int i, int j, String value, int score, int couronnes) {
        int[] calcul;
        map[i][j]= "999";

        //Essai de calcul du score à partir de la map à la position [i][j+1]
        try {
            if (database.dominos.get(map[i][j+1])[1].equals(value)) {
                calcul = calcScore(map, database, i,j+1,value,score+1, couronnes + Integer.valueOf(database.dominos.get(map[i][j+1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i+1][j]
        try {
            if (database.dominos.get(map[i+1][j])[1].equals(value)) {
                calcul = calcScore(map, database, i+1,j, value,score+1, couronnes + Integer.valueOf(database.dominos.get(map[i+1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];

            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i][j-1]
        try {
            if (database.dominos.get(map[i][j-1])[1].equals(value)) {
                calcul = calcScore(map, database, i,j-1, value,score+1, couronnes + Integer.valueOf(database.dominos.get(map[i][j-1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calculer le score à partir de la map à la position [i-1][j]
        try {
            if (database.dominos.get(map[i-1][j])[1].equals(value)) {
                calcul = calcScore(map, database, i-1,j, value,score+1, couronnes + Integer.valueOf(database.dominos.get(map[i-1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        return new int[]{score, couronnes};
    }
}