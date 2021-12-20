package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class ActionDelete extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2694704154530598727L;
	public ActionDelete(Component parent) {
		
		if(parent instanceof MenuBar) {
			putValue(NAME,"Delete");
			putValue(MNEMONIC_KEY,KeyEvent.VK_L);
		}
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		putValue(SHORT_DESCRIPTION,"Obrisi entitet");
		putValue(SMALL_ICON,new ImageIcon("images/delete.png"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedTab= StatusBar.lblSluzba.getText();
		
		if(selectedTab.equals("Studentska služba - Studenti")) {
			
			if(JTableStudenti.getInstance().getSelectedRow()>-1) {
				DialogObrisiStudenta dialog = new DialogObrisiStudenta(JTableStudenti.getInstance().getSelectedRow());
				dialog.setVisible(true);
				}
			else
			 JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta", "Greska pri brisanju studenta", JOptionPane.ERROR_MESSAGE);
			
			return;
			
		}else if(selectedTab.equals("Studentska služba - Profesori")) {
			//TODO dodaj
		}else {
			//TODO dodaj
		}
		
	}
	
	
}
