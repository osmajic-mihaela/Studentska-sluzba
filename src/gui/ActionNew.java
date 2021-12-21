package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ActionNew extends AbstractAction {

/**
	 * 
	 */
	private static final long serialVersionUID = -1395170291201064114L;

	public ActionNew(Component parent)  {
		
		if(parent instanceof MenuBar) {
			putValue(NAME,"New");
			putValue(MNEMONIC_KEY,KeyEvent.VK_N);
		}
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		putValue(SHORT_DESCRIPTION,"Dodaj novi entitet");
		putValue(SMALL_ICON,new ImageIcon("images/new.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selected=StatusBar.lblSluzba.getText();
		 
		 if(selected.equals("Studentska slu�ba - Studenti")) {
			//
		 } else if(selected.equals("Studentska slu�ba - Profesori")) { 
			 //
		 } else if(selected.equals("Studentska slu�ba - Predmeti")) {
			 //
		 }
	}
}
