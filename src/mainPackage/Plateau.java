package mainPackage;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Plateau extends JPanel {
	
	private Image image; 
    private JButton button;
	private JTextField NbJoueurs;
	
	
	public Plateau(Image image) {
		this.image = image; 
		JButton butt = new JButton("C'est Parti !");
		JTextField j = new JTextField("Combien de joeurs ?");
		setLayout(null);
		
	}
	

}
