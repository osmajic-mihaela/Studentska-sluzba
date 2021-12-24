package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ActionEdit extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424188997600775054L;
	public ActionEdit(Component parent) {
		
		if(parent instanceof MenuBar) {
			putValue(NAME,"Edit");
			putValue(MNEMONIC_KEY,KeyEvent.VK_E);
		}
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		putValue(SHORT_DESCRIPTION,"Izmeni entitet");
		putValue(SMALL_ICON,new ImageIcon("images/edit.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 String selectedTab=StatusBar.lblSluzba.getText();
		 if(selectedTab.equals("Studentska služba - Studenti")) {
			 
			/* if(JTableStudenti.getInstance().getSelectedRow()>-1) {
					DialogIzmeniStudenta dialog = new DialogIzmeniStudenta(JTableStudenti.getInstance().getSelectedRow());
					dialog.setVisible(true);
					}
			 else
				 JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta", "Greska pri izmeni studenta", JOptionPane.ERROR_MESSAGE);
				return;*/
			 
		 } else if(selectedTab.equals("Studentska služba - Profesori")) { 
			 //
		 } else if(selectedTab.equals("Studentska služba - Predmeti")) {
			 //
		 }
		
	}

}
