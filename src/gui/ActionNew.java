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
		 if(TabbedPane.getInstance().getSelectedIndex()==0) {
			DialogDodajStudenta dialog = new DialogDodajStudenta();
			dialog.setVisible(true);
		 } else if(TabbedPane.getInstance().getSelectedIndex()==1) { 
			 DialogDodajProfesora dialog = new DialogDodajProfesora();
			 dialog.setVisible(true);
		 } else if(TabbedPane.getInstance().getSelectedIndex()==2) {
			DialogDodajPredmet dialog = new DialogDodajPredmet();
			dialog.setVisible(true);
		 }
	}
}
