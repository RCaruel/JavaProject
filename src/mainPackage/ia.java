package mainPackage;

class ia {

    static int[] choixtuileia(Joueurs joueurs, String[] listdominos, Composant composant) {
        int[] pos = new int[]{-1, -1, -1, -1};
        joueurs.setChoixTuile(listdominos[0]);
        int scoremax = -1;
        int[] score;

        for (String listdomino : listdominos) {
            for (int j = 1; j <= 2; j++) {
                for (int x = 0; x < joueurs.getMap().length; x++) {
                    for (int y = 0; y < joueurs.getMap().length; y++) {
                        try {
                            if (joueurs.getMap()[x][y].equals("0")) {
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdomino + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x][y - 1])[1]) || joueurs.getMap()[x][y - 1].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception ignored) {}
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdomino + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x][y + 1])[1]) || joueurs.getMap()[x][y + 1].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception ignored) {}
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdomino + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x - 1][y])[1]) || joueurs.getMap()[x - 1][y].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception ignored) {}
                                try {
                                    //modifier : test sur la moitié de la tuile.
                                    if ((composant.getDominos().get(listdomino + String.valueOf(j)))[1].equals(composant.getDominos().get(joueurs.getMap()[x + 1][y])[1]) || joueurs.getMap()[x + 1][y].equals("500")) {
                                        score = calculscorepot(joueurs, x, y, listdomino, j, composant);

                                        if (score[0] > scoremax) {
                                            scoremax = score[0];
                                            pos = new int[]{score[1 + (j - 1) * 2], score[2 + (j - 1) * 2], score[3 - (j - 1) * 2], score[4 - (j - 1) * 2]};
                                            joueurs.setChoixTuile(listdomino);
                                        }
                                    }
                                } catch (Exception ignored) {}
                            }
                        } catch (Exception ignored) {}
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
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x][y + 1].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x][y + 1] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x, y + 1};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x][y + 1] = "0";
            }
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x - 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x - 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x - 1, y};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x - 1][y] = "0";
            }
        } catch (Exception ignored) {}

        try {
            if (joueurs.getMap()[x + 1][y].equals("0")) {
                joueurs.getMap()[x][y] = dominos + String.valueOf(j);
                joueurs.getMap()[x + 1][y] = dominos + String.valueOf(2 / j);


                score = CalcScore.play(joueurs, composant, false);

                if (score > scoremax) retour = new int[]{score, x, y, x + 1, y};

                joueurs.getMap()[x][y] = "0";
                joueurs.getMap()[x + 1][y] = "0";
            }
        } catch (Exception ignored) {}

        return retour;
    }
}
