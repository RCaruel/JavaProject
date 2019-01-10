package mainPackage;

class CalcScore {

    /**
     *
     * @param joueurs
     * @param composant
     * @return
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

    static int calcule(String[][] map, Composant composant, boolean bool){

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
                }catch (NullPointerException e){} 
            }
        }

        if (bool) System.out.println("------------------------------------");
        return score;

    }

    /**
     * fct qui retroune faux si la condition est vraie et inversement.
     * @param bool
     * @return not bool
     */

    static boolean not(boolean bool) {
        if (bool){
            return false;
        }else{
            return true;
        }
    }

    /**
     *
     * @param map
     * @param composant
     * @param i
     * @param j
     * @param value
     * @param score
     * @param couronnes
     * @return
     */

    static int[] calcScore(String[][] map, Composant composant, int i, int j, String value, int score, int couronnes) {
        int[] calcul;
        map[i][j]= "999";

        //Essai de calcul du score à partir de la map à la position [i][j+1]
        try {
            if (composant.getDominos().get(map[i][j+1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j+1,value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i][j+1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i+1][j]
        try {
            if (composant.getDominos().get(map[i+1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i+1,j, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i+1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];

            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i][j-1]
        try {
            if (composant.getDominos().get(map[i][j-1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j-1, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i][j-1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calculer le score à partir de la map à la position [i-1][j]
        try {
            if (composant.getDominos().get(map[i-1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i-1,j, value,score+1, couronnes + Integer.valueOf(composant.getDominos().get(map[i-1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        return new int[]{score, couronnes};
    }

    static int scoreMap(String[][] map, Composant composant){
        int score = 0;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                if (!(map[i][j].equals("0"))){
                    score++;
                }
            }
        }

        return score;
    }

    static int nbCouronnes(String[][] map, Composant composant){
        int score = 0;

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                score += Integer.valueOf(composant.getDominos().get(map[i][j])[0]);
            }
        }

        return score;
    }
}