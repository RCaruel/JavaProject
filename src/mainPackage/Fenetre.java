package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



	
public class Fenetre extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//* Composants graphiques
    //* Panel principal
    private JPanel fenetre, imagePlateau, imageMenu, imageParam, imageChoixTuiles, imagePlacementTuiles, imageVictoire;
    //* Menu
    private JMenuBar menuBar;
    private JMenu menuPrincipal, menuAutre;
    private JMenuItem quitItem, resizeItem, newgameItem, manualItem;
    //* Boutons Param partie
    private JButton buttonLancePartie;
    //* Autres
    //private Plateau plateau;
    private boolean petiteFenetre;
    private int xFenetre;
    private int yFenetre;



    public Fenetre(Composant composant){
        this.petiteFenetre = true;
        this.xFenetre = 1000; 
        this.yFenetre = 1000;
        //this.plateau = plateau;
        //* Création fenêtre
        creerFenetre();
        initMenu();
        addToWindow();
        pack();
       
        setSize(this.xFenetre, this.yFenetre);
        setTitle("Kingdomino");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false); 
        setLocationRelativeTo(null);//Mettre la fenetre au milieu de l'ecran
        switchFrame(0, new Joueurs(), new ArrayList<Integer>(), composant, 0,0,0,0,0);
    }

    //* Méthodes pour créer la fenêtre
    public void creerFenetre() {
        //* Création de tout les composants graphiques de la fenetre ( sauf Menu )
        ImageIcon imageIcon =new ImageIcon( "fond1.png");
        ImageIcon imgNull =new ImageIcon( "fond3.png");

        this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 1000,1000).getImage());
        
        JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

        this.imagePlateau = new PlateauJeuGraphic();

        this.imageMenu.add(image);

        //* Création de l'image de fond ( plateau )



    }

    void switchFrame(int test, Joueurs joueurs, ArrayList<Integer> listedominos, Composant composant, int x1, int y1, int x2, int y2, int i){
        if (test == 1){

            ImageIcon imageIcon =new ImageIcon( "parchemin.jpg");
            ImageIcon imgNull =new ImageIcon( "fond3.png");
            ImageIcon imgTmp2 = new ImageIcon("header.jpg");

            // this.imagePlateau.add(image);
            this.imageParam = new Param(resizePicture(imageIcon, 1000,1000).getImage(), composant, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            this.imageParam.add(image);
            setContentPane(imageParam);
            revalidate();
            this.imageParam.repaint();
            setSize(1000,1000);

        }else if(test == 0){
            ImageIcon imageIcon =new ImageIcon( "bg.jpg");

            ImageIcon imgNull =new ImageIcon( "fond3.png");
            
            ImageIcon imgTmp2 = new ImageIcon("header.jpg");

            this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 1000,1000).getImage());
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

            this.imageMenu.add(image);
            setContentPane(imageMenu);
            revalidate();
            this.imageMenu.repaint();
            
        }else if(test == 2){
            ImageIcon imageIcon =new ImageIcon( "parchemin.jpg");
            ImageIcon imgNull =new ImageIcon( "fond3.png");
            ImageIcon imgTmp2 = new ImageIcon("header.jpg");


            // this.imagePlateau.add(image);
            this.imageChoixTuiles = new JeuPlateau(resizePicture(imageIcon, 1000,1000).getImage(), composant, listedominos, joueurs, x1, y1, i, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            this.imageChoixTuiles.add(image);
            setContentPane(imageChoixTuiles);
            revalidate();
            this.imageChoixTuiles.repaint();
            setSize(1000,1000);
        }else if(test == 3){
            ImageIcon imageIcon =new ImageIcon( "parchemin.jpg");
            ImageIcon imgNull =new ImageIcon( "fond3.png");
            ImageIcon imgTmp2 = new ImageIcon("header.jpg");


            // this.imagePlateau.add(image);
            this.imagePlacementTuiles = new JeuTerrain(resizePicture(imageIcon, 1000,1000).getImage(), composant, listedominos, joueurs, x1, y1, x2, y2, i, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            this.imagePlacementTuiles.add(image);
            setContentPane(imagePlacementTuiles);
            revalidate();
            this.imagePlacementTuiles.repaint();
            setSize(1000,1000);
        }else if (test == 4){
            ImageIcon imageIcon =new ImageIcon( "parchemin.jpg");

            ImageIcon imgNull =new ImageIcon( "fond3.png");

            ImageIcon imgTmp2 = new ImageIcon("header.jpg");

            this.imageVictoire = new PlateauVictory(resizePicture(imageIcon, 1000,1000).getImage(), joueurs, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

            this.imageVictoire.add(image);
            setContentPane(imageVictoire);
            revalidate();
            this.imageVictoire.repaint();
        }

    }
    public ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    public void initMenu() {
        //* Création des componsants du menu *\\

        //* Barre de menu *\\
        this.menuBar = new JMenuBar();

        //*  menu *\\
        this.menuPrincipal = new JMenu("Option");
        this.menuAutre = new JMenu("Aide");

        //* sous menu avec les actions pour chaque item du sous menu *\\
        this.newgameItem = new JMenuItem("Nouvelle partie");
        newgameItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Controleur c = new Controleur();
        		
        	}
        });
        this.resizeItem = new JMenuItem("Afficher les règles");
        resizeItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		AffichageTuto aff = new AffichageTuto();
        		
        		
        	}
        });
        this.quitItem = new JMenuItem("Quitter");
        quitItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        		
        	}
        });
        
        this.manualItem = new JMenuItem("Manuel d'utilisation");
        manualItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Manuel manu = new Manuel();
        		
        	}
        });
        

        //*  Ajout des items *\\

        this.menuPrincipal.add(this.newgameItem);
        this.menuPrincipal.add(this.resizeItem);
        this.menuPrincipal.addSeparator();
        this.menuPrincipal.add(this.quitItem);
        
        this.menuAutre.add(this.manualItem);

        this.menuBar.add(this.menuPrincipal);
        this.menuBar.add(this.menuAutre);

        setJMenuBar(this.menuBar);

    }

    public void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        this.fenetre = new JPanel();
        this.fenetre.add(this.imageMenu);
        setContentPane(this.fenetre);
    }




    //* Méthodes pour initialiser les controleurs

    public void setControlButton(ControlButton cb){
        ((PlateauGraphic)this.imageMenu).getButton().addActionListener(cb);
    }
    
    public JPanel getImagePlateau() {
        return imagePlateau;
    }

    public JPanel getImageMenu() {
        return imageMenu;
    }
}
