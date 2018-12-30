package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ControlButton implements ActionListener {

    private Plateau p;
    private Fenetre f;

    public ControlButton(Plateau p, Fenetre f) {
        this.p = p;
        this.f = f;
        this.f.setControlButton(this);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
