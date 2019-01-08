package mainPackage;

class ia {

    static int[] choixtuileia(Joueurs joueurs, String[] listdominos, Composant composant) {
        int[] pos = new int[]{-1, -1, -1, -1};
        joueurs.setChoixTuile(listdominos[0]);
        int scoremax = -1;
        int[] score;

        for (int i = 0; i < listdominos.length; i++) {
            for (int j = 1; j <= 2; j++) {
                for (int x = 0; x < joueurs.getMap().length; x++) {
                    for (int y = 0; y < joueurs.getMap().length; y++) {
                        try { 
                            if (joueurs.getMap()[x][y].equals("0")) {
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdominos[i] + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x][y - 1])[1]) || joueurs.getMap()[x][y - 1].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdominos[i], j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            if (j == 1) pos = new int[]{score[1], score[2], score[3], score[4]};
                                            if (j == 2) pos = new int[]{score[3], score[4], score[1], score[2]};
                                            joueurs.setChoixTuile(listdominos[i]);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdominos[i] + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x][y + 1])[1]) || joueurs.getMap()[x][y + 1].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdominos[i], j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            if (j == 1) pos = new int[]{score[1], score[2], score[3], score[4]};
                                            if (j == 2) pos = new int[]{score[3], score[4], score[1], score[2]};
                                            joueurs.setChoixTuile(listdominos[i]);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdominos[i] + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x - 1][y])[1]) || joueurs.getMap()[x - 1][y].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdominos[i], j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            if (j == 1) pos = new int[]{score[1], score[2], score[3], score[4]};
                                            if (j == 2) pos = new int[]{score[3], score[4], score[1], score[2]};
                                            joueurs.setChoixTuile(listdominos[i]);
                                        }
                                    }
                                } catch (Exception e) {
                                }
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdominos[i] + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x + 1][y])[1]) || joueurs.getMap()[x + 1][y].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdominos[i], j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            if (j == 1) pos = new int[]{score[1], score[2], score[3], score[4]};
                                            if (j == 2) pos = new int[]{score[3], score[4], score[1], score[2]};
                                            joueurs.setChoixTuile(listdominos[i]);
                                        }
                                    }
                                } catch (Exception e) {
                                }

                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return pos;
    }

    private static int[] calculscorepot(Joueurs joueurs, int x, int y, String dominos, int j, Composant composant) {
        int[] retour = new int[]{0, 0, 0, 0, 0};
        int scoremax = 0;
        int score;

        try {
            if (joueurs.getMap()[x][y - 1].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x][y - 1] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x, y - 1};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x][y - 1] = "0";
            }
        } catch (Exception e) {
        }

        try {
            if (joueurs.getMap()[x][y + 1].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x][y + 1] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x, y + 1};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x][y + 1] = "0";
            }
        } catch (Exception e) {
        }

        try {
            if (joueurs.getMap()[x - 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x - 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x - 1, y};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x - 1][y] = "0";
            }
        } catch (Exception e) {
        }

        try {
            if (joueurs.getMap()[x + 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x + 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x + 1, y};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x + 1][y] = "0";
            }
        } catch (Exception e) {
        }

        return retour;
    }
}
