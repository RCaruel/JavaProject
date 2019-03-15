package mainPackage;

class ia {

    /**
     * IA qui teste toutes les possibilités => brutal.
     * @param joueurs
     * @param listdom
     * @param composant
     * @return
     */
    static int[] choixtuileia(Joueurs joueurs, String[] listdom, Composant composant) {
        int[] pos = new int[]{-1, -1, -1, -1};
        joueurs.setChoixTuile(listdom[0]);
        int scoremax = -1;
        int[] score;

        for (String listdomino : listdom) {
            for (int j = 1; j <= 2; j++) {
                for (int x = 0; x < joueurs.getMap().length; x++) {
                    for (int y = 0; y < joueurs.getMap().length; y++) {
                        try {
                            if (joueurs.getMapId(x,y).equals("0")) {
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if (composant.getDominos().get(listdomino + String.valueOf(j))[1].equals(composant.getDominos().get(joueurs.getMapId( x, y - 1))[1]) || joueurs.getMapId(x, y - 1).equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.print("");

                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if (composant.getDominos().get(listdomino + String.valueOf(j))[1].equals(composant.getDominos().get(joueurs.getMapId(x, y+1))[1]) || joueurs.getMapId(x, y+1).equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("");
                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if (composant.getDominos().get(listdomino + String.valueOf(j))[1].equals(composant.getDominos().get(joueurs.getMapId(x - 1,y))[1]) || joueurs.getMapId(x - 1, y).equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("");
                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if (composant.getDominos().get(listdomino + String.valueOf(j))[1].equals(composant.getDominos().get(joueurs.getMapId(x + 1, y))[1]) || joueurs.getMapId(x + 1, y).equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("");
                                }
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return pos;
    }

    private static int[] calculscorepot(Joueurs joueurs, int x, int y, String dominos, int j, Composant composant) {
        int[] retour = new int[]{0, 0, 0, 0, 0};
        int scoremax = -1; //pas = 0
        int score;

        try {
            if (joueurs.getMap()[x][y - 1].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x][y - 1] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax){
                    retour = new int[]{score, x, y, x, y - 1};
                    scoremax = score;
                }

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x][y - 1] = "0";
            }
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x][y + 1].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x][y + 1] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax){
                    retour = new int[]{score, x, y, x, y + 1};
                    scoremax = score;
                }

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x][y + 1] = "0";
            }
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x - 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x - 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax){
                    retour = new int[]{score, x, y, x - 1, y};
                    scoremax = score;
                }

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x - 1][y] = "0";
            }
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x + 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x + 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax){
                    retour = new int[]{score, x, y, x + 1, y};
                    scoremax = score;
                }

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x + 1][y] = "0";
            }
        } catch (Exception ignored) {}

        return retour;
    }
}
