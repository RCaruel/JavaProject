package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mainPackage.Grille.GameBoard;
import mainPackage.Grille.Pawn;
import mainPackage.Grille.Player;



public class ControlButton implements ActionListener {

	Composant composant = new Composant();
	
    private Fenetre f;

    public ControlButton(Fenetre f) {
        
        this.f = f;
        this.f.setControlButton(this);
        this.composant = composant;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// LE JEU COMMENCE QUAND ON APPUIE SUR LE BOUTON "COMMNCER LA PARTIE"
		System.out.println("Début de la partie");
		composant.setNombreJoueurs(Integer.valueOf(((PlateauGraphic)f.getImageMenu()).getJ1().getText()));
		System.out.println(composant.getNombreJoueurs());
		f.setComposant(composant);
		f.switchFrame(1);

        /*GameBoard gameboard = new GameBoard(5,6);
		
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
		f.setVisible(true);*/
        
		
	}

}
