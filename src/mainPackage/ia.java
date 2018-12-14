package mainPackage;

import java.util.ArrayList;

public class ia {
	
	static ArrayList<Integer> nbcouronne = new ArrayList<Integer>();
	
	public static int[] choixtuileia(Joueurs ia, String[] listdominos, Composant composant) {
		int[] pos = new int[4];
		for (int i = 0; i < listdominos.length; i++) {
			for (int j = 1; j <= 2; j++) {
				for (int x = 0; x < ia.getMap().length; x++) {
					for (int y = 0; y < ia.getMap().length; y++) {
						try {
							//modifier : test sur la moitié de la tuile.
							if (composant.getDominos().get(listdominos[i])[j].equals(ia.getMap()[x][y - 1])) {
								calculscorepot();
							}
						} catch (Exception e) {
						}
					}
				}
			}
		}
		return pos;
	}

	static int calculscorepot(){
		int scoremax = 0;
		return scoremax;
	}

}
