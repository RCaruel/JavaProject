package mainPackage;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

class Manuel extends JDialog {

    // On affiche le manuel d'utilisation dans une JDialog
	
	Manuel() {
		this.setSize(550, 350);
		this.setTitle("Manuel d'utilisation");
		this.setLocationRelativeTo(null);
		//this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JTextArea man = new JTextArea();
        man.setText("Pour une utilisation console lancez le Main.java et suivez les instruction de la console.\r\n"
                + "Pour une utilisation graphique lancez le Main_bis.java puis réglez les paramétres de la partie en "
		  		+ "appuyant sur “commencer la partie”. Une fois les paramètres remplis cliquez sur “lancer la partie”. "
		  		+ "Pour déplacer une tuile placez votre souris sur la tuile et gardez le clic gauche de votre souris enfoncé, "
		  		+ "relâchez le pour déposer votre tuile. Cliquez sur “Valider” quand vous avez terminé votre tour.");
        man.setEditable(false);
        man.setFont(new Font("Serif", Font.BOLD, 16));
        man.setLineWrap(true);
        man.setWrapStyleWord(true);

        JTabbedPane onglet = new JTabbedPane();
        onglet.addTab("Comment jouer ?", new JScrollPane(man));

        this.getContentPane().add(onglet, BorderLayout.CENTER);
        this.setVisible(true);
		  
	}

}
