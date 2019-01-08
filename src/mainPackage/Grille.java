package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Grille {
	
	private static final int PREFERRED_SIZE = 70;
	 
	private static final Color BROWN_SQUARE = new Color(0x99, 0x66, 0x00);
	private static final Color BEIGE_SQUARE = new Color(0x99, 0x66, 0x00);
	private static final Color SELECTION_COLOR = new Color(0xFF,0xA4,0x77);
	public static final ImageIcon CHATEAU = resizePicture(new ImageIcon("chateau.jpg"),60,60);
	public static final ImageIcon GRASS = resizePicture(new ImageIcon("grass.png"),60,60);
	public static final ImageIcon MINES = resizePicture(new ImageIcon("mines.png"),60,60);
	public static final ImageIcon DESERT = resizePicture(new ImageIcon("desert.png"),60,60);
	public static final ImageIcon WATER = resizePicture(new ImageIcon("water.png"),60,60);
	public static final ImageIcon WHEAT = resizePicture(new ImageIcon("wheat.png"),60,60);
	public static final ImageIcon FORET = resizePicture(new ImageIcon("foret.png"),60,60);
	
	
	 public static ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


	        Image img = imageIcon.getImage();
	        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
	        imageIcon=new ImageIcon(imgResize);

	        return imageIcon;
	    }
 
	/**public static void main(String[] args) {
 
		JFrame frame = new JFrame("Démo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
 
		GameBoard gameboard = new GameBoard(10,10);
		
			gameboard.setPiece(6,6,new Pawn(Player.CHATEAU));
			gameboard.setPiece(0,2,new Pawn(Player.GRASS));
			gameboard.setPiece(0,3,new Pawn(Player.MINES));
			gameboard.setPiece(0,4,new Pawn(Player.DESERT));
			gameboard.setPiece(0,5,new Pawn(Player.WATER));
			gameboard.setPiece(0,7,new Pawn(Player.WHEAT));
			gameboard.setPiece(0,8,new Pawn(Player.FORET));
			
			
		
		frame.add(gameboard);
		frame.pack();
		frame.setSize(1000,1000);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
 
	}**/
 
	public static class GameBoard extends JPanel {
 
		private static final long serialVersionUID = 1L;
 
		private final int nbColumns;
		private final int nbLines;
		private final Controller controller;
 
		public GameBoard(int nbColumns, int nbLines) {
			super(new GridLayout(nbLines, nbColumns));
 
			this.nbColumns=nbColumns;
			this.nbLines=nbLines;
			this.controller = new Controller(this); // le contrôleur doit avoir acces à la vue et au modèle
			setSize(500,500);
		}
 
		public int getNbLines() {
			return nbLines;
		}
 
		public int getNbColumns() {
			return nbColumns;
		}
 
		public void setPiece(int column, int line, Piece piece) {
			controller.setPiece(column, line, piece);
		}
 
		public Square getSquare(int column, int line) {
			return controller.getSquare(column, line);
		}
 
	}
 
	public enum Player {
		
		CHATEAU, GRASS, MINES, DESERT, WATER, WHEAT, FORET}
 
	public enum PieceType {
		PAWN(CHATEAU,GRASS, MINES, DESERT, WATER, WHEAT, FORET);
		
 
		final ImageIcon chateauImage;
		final ImageIcon grassImage;
		final ImageIcon minesImage;
		final ImageIcon desertImage;
		final ImageIcon waterImage;
		final ImageIcon wheatImage;
		final ImageIcon foretImage;
 
		private PieceType( ImageIcon chateauImage, ImageIcon grassImage,ImageIcon minesImage, ImageIcon desertImage, ImageIcon waterImage, ImageIcon wheatImage, ImageIcon foretImage) {
			
			this.chateauImage = chateauImage;
			this.grassImage = grassImage;
			this.minesImage = minesImage;
			this.desertImage = desertImage;
			this.waterImage = waterImage;
			this.wheatImage = wheatImage;
			this.foretImage = foretImage;
		}
 
		public ImageIcon getImage(Player player) {
			switch(player) {
			case CHATEAU:
				return chateauImage;
			case GRASS: 
				return grassImage;
			case MINES : 
				return minesImage;
			case DESERT : 
				return desertImage;
			case WATER : 
				return waterImage;
			case WHEAT : 
				return wheatImage;
			case FORET : 
				return foretImage;
			
			default:
				throw new IllegalStateException("Unknown player "+player);
			}
		}
 
	}
 
	public static abstract class Piece {
 
		private final Player player;
		private final PieceType type;
		public Piece(PieceType type, Player player) {
			this.type=type;
			this.player=player;
		}
 
		public PieceType getType() {
			return type;
		}
 
		public Player getPlayer() {
			return player;
		}
 
		public ImageIcon getImage() {
			return getType().getImage(player);
		} 
 
	}
 
	public static class Pawn extends Piece {
		public Pawn(Player player) {
			super(PieceType.PAWN,player);
		}
	}
 
	public static class Square extends JPanel {
 
		private static final long serialVersionUID = 1L;
 
		private final Color color;
		private final int column;
		private final int line;
		private Piece piece; 
 
		public Square(int column, int line, Color color) {
			super(new BorderLayout()); // centrer la pièce
			this.color=color;
			setBackground(color);
			this.column=column;
			this.line=line;
			setBorder(BorderFactory.createMatteBorder (3, 3, 3, 3, Color.black));
			setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
		}
 
		public int getLine() {
			return line;
		}
 
		public int getColumn() {
			return column;
		}
 
		public void setPiece(Piece piece) {
			this.piece=piece;
			if ( piece==null ) {
				removeAll();
			}
			else {
				add(new JLabel(piece.getImage()));
				revalidate();
			}
		}
 
		public Piece getPiece() {
			return piece;
		}
 
		public boolean isEmpty() {
			return piece==null;
		}
 
		public void setSelection(boolean selection) {
			setBackground(selection?SELECTION_COLOR:color);
		} 
 
	}
 
	public static class Controller {
 
		private final GameBoard board;
		private final Square[][] squares;
		private Square currentMove;
 
		public Controller(GameBoard board) {
			this.board=board;
			this.squares=new Square[board.getNbLines()][board.getNbColumns()];
			final int nbPieces=board.getNbLines()*board.getNbColumns();
			for(int i=0; i<nbPieces; i++) {
				final int line = i/board.getNbColumns();
				final int column = i%board.getNbColumns();
				final Square square = new Square(column, line, i%2==line%2?BROWN_SQUARE:BEIGE_SQUARE);
				board.add(square);
				squares[line][column]=square;
			}
			MouseAdapter mouseAdapter = new MouseAdapter() {
 
				@Override
				public void mouseClicked(MouseEvent e) {
					Square square = (Square) e.getSource();
					if ( !square.isEmpty() ) {
						if ( isMoving() ) {
							if ( square.getPiece()==currentMove.getPiece() ) {
								// cancel move
								stopMove();
								board.repaint();
								
								
							}
							else if ( square.getPiece().getPlayer()==currentMove.getPiece().getPlayer() ) {
								JOptionPane.showMessageDialog(board, "Une pièce à vous est déjà dans cette case","Mouvement impossible", JOptionPane.WARNING_MESSAGE);
								
							}
							/**else if ( moveIsAllowed(currentMove.getPiece(), currentMove, square) ) {
								doCapture(square);
								moveTo(currentMove, square);
								stopMove(); 
								board.repaint();
							}**/
						}
						else {//selection de l'image
							startMove(square);
							board.repaint();
						}
					}
					else if ( isMoving() ) {//deposer l'image
						moveTo(currentMove, square);
						stopMove();
						
					}
				}
 
			};
			for(Square[] line : squares) {
				for(Square square : line) {
					square.addMouseListener(mouseAdapter);
				}
			}
		}
 
		/**
                 * Cette méthode ne teste pas si la pièce à le droit de se trouver dans cette case
                 * @param column
                 * @param line
                 * @param piece
                 */
		public void setPiece(int column, int line, Piece piece) {
			if ( squares[column][line].isEmpty() ) {
				squares[column][line].setPiece(piece);
			}
			else {
				throw new IllegalStateException("Case occupée");
			}
		}
 
		private void moveTo(Square fromSquare, Square toSquare) {
			final Piece piece = fromSquare.getPiece();
			if ( piece==null ) throw new IllegalStateException("Pas de pièce dans la case de départ");
			if ( moveIsAllowed(piece, fromSquare, toSquare) ) {
				toSquare.setPiece(piece);
				fromSquare.setPiece(null);
			}
			/**else {
				JOptionPane.showMessageDialog(board, "Ce mouvement n'est pas autorisé par les règles des Echecs","Mouvement impossible", JOptionPane.WARNING_MESSAGE);
			}**/
		}
 
		private void stopMove() {
			if ( currentMove!=null ) {
				currentMove.setSelection(false);
				currentMove=null;
			}
		} 
 
		/**private void doCapture(Square square) {
			// TODO
			square.setPiece(null); // temp
		}**/
 
		private boolean moveIsAllowed(Piece piece, Square fromSquare, Square toSquare) {
			return true; // TODO
		}
 
		public Square getSquare(int column, int line) {
			return squares[line][column];
		}
 
		public boolean isMoving() {
			return currentMove!=null;
		}
 
		private void startMove(Square square) {
			if ( currentMove!=null ) {
				stopMove();
			}
			currentMove=square;
			square.setSelection(true);
		}
 
	} 

}
