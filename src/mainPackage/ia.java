package mainPackage;

import java.util.ArrayList;

public class ia {
	
	static ArrayList<Integer> nbcouronne = new ArrayList<Integer>();
	
	public static int[] choixtuileia(Joueurs ia, String[] listdominos) {
		int[] pos = new int[4];
		for (int i = 0; i < listdominos.length; i++) {
			for (int x = 0; x < ia.getMap().length; x++){
				for (int y = 0; y < ia.getMap().length; y++){
					try{
						//modifier : test sur la moitié de la tuile.
						if (ia.getMap()[x][y].equals(ia.getMap()[x][y-1])){
							calculscorepot();
						}
					}catch(Exception e){}
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
