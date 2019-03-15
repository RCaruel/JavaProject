package mainPackage;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Class qui gère toutes les différentes fenêtres
 */

class Fenetre extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JPanel imageMenu;

    /**
     * Constructeur de cette classe
     * @param composant boite du jeu
     */

    Fenetre(Composant composant){
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

        new PlateauJeuGraphic();

        this.imageMenu.add(image);

        //* Création de l'image de fond ( plateau )



    }

    void switchFrame(int test, Joueurs joueurs, ArrayList<Integer> listedominos, Composant composant, int x1, int y1, int x2, int y2, int i){
        if (test == 1){

            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));

            // this.imagePlateau.add(image);
            JPanel imageParam = new Param(resizePicture(imageIcon, 1000, 1000).getImage(), composant, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            imageParam.add(image);
            setContentPane(imageParam);
            revalidate();
            imageParam.repaint();

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
            JPanel imageChoixTuiles = new JeuPlateau(resizePicture(imageIcon, 1000, 1000).getImage(), composant, listedominos, joueurs, x1, y1, i, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            imageChoixTuiles.add(image);
            setContentPane(imageChoixTuiles);
            revalidate();
            imageChoixTuiles.repaint();
            setSize(1000,1000);
        }else if(test == 3){
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));


            // this.imagePlateau.add(image);
            JPanel imagePlacementTuiles = new JeuTerrain(resizePicture(imageIcon, 1000, 1000).getImage(), composant, listedominos, joueurs, x1, y1, x2, y2, i, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            //for(int i = 0; i < )
            imagePlacementTuiles.add(image);
            setContentPane(imagePlacementTuiles);
            revalidate();
            imagePlacementTuiles.repaint();
            setSize(1000,1000);
        }else if (test == 4){
            joueurs.setCouleur("rouge");
            ImageIcon imageIcon =new ImageIcon( this.getClass().getResource("ressources/parchemin.jpg"));

            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));

            JPanel imageVictoire = new PlateauVictory(resizePicture(imageIcon, 1000, 1000).getImage(), joueurs, this);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));

            imageVictoire.add(image);
            setContentPane(imageVictoire);
            revalidate();
            imageVictoire.repaint();
        }else if (test == 5){
            composant.setNombreJoueurs(4);
            String[] couleurs = new String[]{"bleu", "rouge", "vert", "jaune"};
            for (int j = 0; j < composant.getListJoueurs().length; j++){
                composant.getListJoueurs()[j] = new Joueurs();
                composant.getListJoueurs()[j].setCouleur(couleurs[j]);
                composant.getListJoueurs()[j].setEvolution(new int[]{0,j,j,3*j,4*j,6*j,7*j,10*j,15*j,16*j,22*j,30*j});
            }
            JPanel imagegraphique = new ImageGraphique(composant);
            ImageIcon imgNull =new ImageIcon( this.getClass().getResource("ressources/fond3.png"));
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            imagegraphique.add(image);
            setContentPane(imagegraphique);
            revalidate();
            imagegraphique.repaint();
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
        //* Menu
        JMenuBar menuBar = new JMenuBar();

        //*  menu *\\
        JMenu menuPrincipal = new JMenu("Option");
        JMenu menuAutre = new JMenu("Aide");

        //* sous menu avec les actions pour chaque item du sous menu *\\
        JMenuItem newgameItem = new JMenuItem("Nouvelle partie");
        newgameItem.addActionListener(arg0 -> new Controleur());

        JMenuItem resizeItem = new JMenuItem("Afficher les règles");
        resizeItem.addActionListener(arg0 -> new AffichageTuto());

        JMenuItem quitItem = new JMenuItem("Quitter");
        quitItem.addActionListener(arg0 -> setVisible(false));

        JMenuItem manualItem = new JMenuItem("Manuel d'utilisation");
        manualItem.addActionListener(arg0 -> new Manuel());
        

        //*  Ajout des items *\\

        menuPrincipal.add(newgameItem);
        menuPrincipal.add(resizeItem);
        menuPrincipal.addSeparator();
        menuPrincipal.add(quitItem);
        
        menuAutre.add(manualItem);

        menuBar.add(menuPrincipal);
        menuBar.add(menuAutre);

        setJMenuBar(menuBar);

    }

    void affWinner(Joueurs joueurs){
        JOptionPane.showMessageDialog(this, "Le vainqueur est " + joueurs.getPseudo() + " avec un score de " + joueurs.getScore(), "Fin de la partie", JOptionPane.WARNING_MESSAGE);
    }

    private void addToWindow() {
        //* Ajouts des composants graphique dans la fenêtre principales
        //* Composants graphiques
        //* Panel principal
        JPanel fenetre = new JPanel();
        fenetre.add(this.imageMenu);
        setContentPane(fenetre);
    }




    //* Méthodes pour initialiser les controleurs

    void setControlButton(ControlButton cb){
        ((PlateauGraphic)this.imageMenu).getButton().addActionListener(cb);
    }

    JPanel getImageMenu() {
        return imageMenu;
    }
}
