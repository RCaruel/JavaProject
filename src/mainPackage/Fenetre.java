package mainPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
	Composant composant;
	//* Composants graphiques
    //* Panel principal
    private JPanel fenetre, imagePlateau, imageMenu, imageParam;
    //* Menu
    private JMenuBar menuBar;
    private JMenu menuPrincipal, menuAutre;
    private JMenuItem quitItem, resizeItem, newgameItem;
    //* Boutons Param partie
    private JButton buttonLancePartie;
    //* Autres
    //private Plateau plateau;
    private boolean petiteFenetre;
    private int xFenetre;
    private int yFenetre;



    public Fenetre(){
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
        switchFrame(0);
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

    void switchFrame(int test){
        if (test == 1){

            ImageIcon imgNull =new ImageIcon( "fond3.png");


            // this.imagePlateau.add(image);
            this.imageParam = new Param(resizePicture(imgNull, 1000,1000).getImage(), composant);
            JLabel image = new JLabel(resizePicture(imgNull, 1000,1000));
            //imagePlateau.add();
            setContentPane(imageParam);
            //for(int i = 0; i < )
            this.imagePlateau.add(image);
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

        //*  Ajout des items *\\

        this.menuPrincipal.add(this.newgameItem);
        this.menuPrincipal.add(this.resizeItem);
        this.menuPrincipal.addSeparator();
        this.menuPrincipal.add(this.quitItem);

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

    void setComposant(Composant composant){
        this.composant = composant;
    }
    
    public JPanel getImagePlateau() {
        return imagePlateau;
    }

    public JPanel getImageMenu() {
        return imageMenu;
    }
}
