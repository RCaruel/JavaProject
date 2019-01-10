package mainPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import mainPackage.Grille.GameBoard;
import mainPackage.Grille.Pawn;
import mainPackage.Grille.Player;



public class ControlButton implements ActionListener {

    
    private Fenetre f;

    public ControlButton(Fenetre f) {
        
        this.f = f;
        this.f.setControlButton(this); 
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// LE JEU COMMENCE QUAND ON APPUIE SUR LE BOUTON "COMMNCER LA PARTIE"
		
		System.out.println("Début de la partie");
        f.switchFrame();
        String j1 = ((PlateauGraphic)f.getImageMenu()).getJ1().getText();
        if (j1.length() == 0)
            j1 = "Joueur 1";
        String j2 = ((PlateauGraphic)f.getImageMenu()).getJ2().getText();
        if (j2.length() == 0)
            j2 = "Joueur 2";
        System.out.println("Le joueur 1 s'appele : " + j1 );
        System.out.println("Le joueur 2 s'appele : " + j2 );
       
        GameBoard gameboard = new GameBoard(6,6);
		
		gameboard.setPiece(2,3,new Pawn(Player.CHATEAU)); 
		gameboard.setPiece(0,0,new Pawn(Player.GRASS));
		gameboard.setPiece(0,1,new Pawn(Player.MINES));
		gameboard.setPiece(0,2,new Pawn(Player.DESERT));
		gameboard.setPiece(0,3,new Pawn(Player.WATER));
		gameboard.setPiece(0,4,new Pawn(Player.WHEAT));
		gameboard.setPiece(0,5,new Pawn(Player.FORET));
		f.add(gameboard);
		gameboard.setBorder(BorderFactory.createMatteBorder (3, 3, 3, 3, Color.black));
 
		f.pack();
		f.setSize(1000,1000);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
    
        //SUITE A FAIRE 
        
		
	}

}
