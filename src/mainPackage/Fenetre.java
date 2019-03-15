package mainPackage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Class qui gère toutes les différentes fenêtres
 */

public class Fenetre extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//* Composants graphiques
    //* Panel principal
    private JPanel fenetre, imagePlateau, imageMenu, imageParam, imageChoixTuiles, imagePlacementTuiles, imageVictoire, imagegraphique;

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

    /**
     * Constructeur de cette classe
     * @param composant
     * @throws IOException 
     * @throws FileNotFoundException 
     */

    Fenetre(Composant composant){
        this.petiteFenetre = true;
        ImageIcon icon = new ImageIcon(this.getClass().getResource("ressources/icone.png"));
        Image imgIcon = resizePicture(icon, 100,100).getImage();

        //* Création fenêtre
        creerFenetre();
        initMenu();
        addToWindow();
        pack();

        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Kingdomino");
        setIconImage(imgIcon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setAlwaysOnTop(true);
        setResizable(false); 
        setLocationRelativeTo(null);//Mettre la fenetre au milieu de l'ecran
        switchFrame(4, new Joueurs(), new ArrayList<>(), composant, 0,0,0,0,0);
    }

    //* Méthodes pour créer la fenêtre
    private void creerFenetre() {
        //* Création de tout les composants graphiques de la fenetre ( sauf Menu )
        ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/fond1.png"));
        ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));

        this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 1000,1000).getImage());
        
        JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

        this.imagePlateau = new PlateauJeuGraphic();

        this.imageMenu.add(image);

        //* Création de l'image de fond ( plateau )



    }

    void switchFrame(int test, Joueurs joueurs, ArrayList<Integer> listedominos, Composant composant, int x1, int y1, int x2, int y2, int i){
        if (test == 1){

            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));

            // this.imagePlateau.add(image);
            this.imageParam = new Param(resizePicture(imageIcon, 1000,1000).getImage(), composant, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            this.imageParam.add(image);
            setContentPane(imageParam);
            revalidate();
            this.imageParam.repaint();

        }else if(test == 0){
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/bg.jpg"));

            this.imageMenu = new PlateauGraphic(resizePicture(imageIcon, 1000,1000).getImage());
            //JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

            //this.imageMenu.add(image);
            setContentPane(imageMenu);
            revalidate();
            this.imageMenu.repaint();
            
        }else if(test == 2){
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));


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
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));
            ImageIcon imgTmp2 = new ImageIcon(this.getClass().getResource("ressources/header.jpg"));


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
            joueurs.setCouleur("rouge");
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));

            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));

            this.imageVictoire = new PlateauVictory(resizePicture(imageIcon, 1000,1000).getImage(), joueurs, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

            this.imageVictoire.add(image);
            setContentPane(imageVictoire);
            revalidate();
            this.imageVictoire.repaint();
        }else if (test == 5){
            composant.setNombreJoueurs(4);
            String[] couleurs = new String[]{"bleu", "rouge", "vert", "jaune"};
            for (int j = 0; j < composant.getListJoueurs().length; j++){
                composant.getListJoueurs()[j] = new Joueurs();
                composant.getListJoueurs()[j].setCouleur(couleurs[j]);
                composant.getListJoueurs()[j].setEvolution(new int[]{0,j,j,3*j,4*j,6*j,7*j,10*j,15*j,16*j,22*j,30*j});
            }
            this.imagegraphique = new ImageGraphique(composant);
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            this.imagegraphique.add(image);
            setContentPane(imagegraphique);
            revalidate();
            this.imagegraphique.repaint();
        }

    }

    private ImageIcon resizePicture(ImageIcon imageIcon, int width, int height){


        Image img = imageIcon.getImage();
        Image imgResize = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        imageIcon=new ImageIcon(imgResize);

        return imageIcon;
    }

    private void initMenu() {
        //* Création des componsants du menu *\\

        //* Barre de menu *\\
        this.menuBar = new JMenuBar();

        //*  menu *\\
        this.menuPrincipal = new JMenu("Option");
        this.menuAutre = new JMenu("Aide");

        //* sous menu avec les actions pour chaque item du sous menu *\\
        this.newgameItem = new JMenuItem("Nouvelle partie");
        newgameItem.addActionListener(arg0 -> new Controleur());

        this.resizeItem = new JMenuItem("Afficher les règles");
        resizeItem.addActionListener(arg0 -> new AffichageTuto());

        this.quitItem = new JMenuItem("Quitter");
        quitItem.addActionListener(arg0 -> setVisible(false));
        
        this.manualItem = new JMenuItem("Manuel d'utilisation");
        manualItem.addActionListener(arg0 -> new Manuel());
        

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

    void affWinner(Joueurs joueurs){
        JOptionPane.showMessageDialog(this, "Le vainqueur est " + joueurs.getPseudo() + " avec un score de " + joueurs.getScore(), "Fin de la partie", JOptionPane.WARNING_MESSAGE);
    }

    private void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        this.fenetre = new JPanel();
        this.fenetre.add(this.imageMenu);
        setContentPane(this.fenetre);
    }




    //* Méthodes pour initialiser les controleurs

    void setControlButton(ControlButton cb){
        ((PlateauGraphic)this.imageMenu).getButton().addActionListener(cb);
    }

    JPanel getImageMenu() {
        return imageMenu;
    }
}
