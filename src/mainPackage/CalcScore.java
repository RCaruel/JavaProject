package mainPackage;

public class CalcScore {

    /**
     *
     * @param joueurs
     * @param composant
     * @return
     */

    public static int play(Joueurs joueurs, Composant composant){

        int score = 0;
        int[] sc;

        for (int i = 0; i < joueurs.getMap().length; i++) {
            for (int j = 0; j < joueurs.getMap().length; j++) {

                //calcul du score à partir de cette tuile si elle n'a pas la valeur "999"
                try {
                    if (not(joueurs.getMap()[i][j].equals("999"))) {
                        String value = joueurs.getMap()[i][j];
                        sc = calcScore(joueurs.getMap(), composant, i, j, value, 1, 0);
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
     * @param composant
     * @param i
     * @param j
     * @param value
     * @param score
     * @param couronnes
     * @return
     */

    public static int[] calcScore(String[][] map, Composant composant, int i, int j, String value, int score, int couronnes) {
        int[] calcul;
        map[i][j]= "999";

        //Essai de calcul du score à partir de la map à la position [i][j+1]
        try {
            if (composant.dominos.get(map[i][j+1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j+1,value,score+1, couronnes + Integer.valueOf(composant.dominos.get(map[i][j+1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i+1][j]
        try {
            if (composant.dominos.get(map[i+1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i+1,j, value,score+1, couronnes + Integer.valueOf(composant.dominos.get(map[i+1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];

            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calcul du score à partir de la map à la position [i][j-1]
        try {
            if (composant.dominos.get(map[i][j-1])[1].equals(value)) {
                calcul = calcScore(map, composant, i,j-1, value,score+1, couronnes + Integer.valueOf(composant.dominos.get(map[i][j-1])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        //Essai de calculer le score à partir de la map à la position [i-1][j]
        try {
            if (composant.dominos.get(map[i-1][j])[1].equals(value)) {
                calcul = calcScore(map, composant, i-1,j, value,score+1, couronnes + Integer.valueOf(composant.dominos.get(map[i-1][j])[0]));
                score = calcul[0];
                couronnes = calcul[1];
            }
        }catch(IndexOutOfBoundsException e){

        }catch (NullPointerException e){}

        return new int[]{score, couronnes};
    }
}