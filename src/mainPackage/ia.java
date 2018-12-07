package mainPackage;

import java.util.ArrayList;

public class ia {
	
	static ArrayList<Integer> nbcouronne = new ArrayList<Integer>();
	
	public static void choixtuileia() {
		for (int j = 0; j < Jouer.roi.size(); j++) {
			if (Jouer.choixtuile[j] != Jouer.listedominos.get(j)) {
				System.out.println(nbcouronne.add(Jouer.dominos.get()));
			}
		}
	}

}
