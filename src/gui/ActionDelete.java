package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.StudentiController;

public class ActionDelete extends AbstractAction {

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
		 String selectedTab=StatusBar.lblSluzba.getText();
		 if(selectedTab.equals("Studentska služba - Studenti")) {
			 
			 if(JTableStudenti.getInstance().getSelectedRow()>-1) {
				 	String[] options = new String[2];
					options[0] = new String ("Da");
					options[1] = new String ("Ne");
					int code = JOptionPane.showOptionDialog(MainFrame.getInstance().getContentPane(), "Da li ste sigurni da želite da obrišete studenta?", "Brisanje studenta", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
					
					if (code == JOptionPane.YES_OPTION) {
						StudentiController.getInstance().obrisiStudenta(JTableStudenti.getInstance().getSelectedRow());
					}
				}
			 else
				 JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta", "Greška pri brisanju studenta", JOptionPane.ERROR_MESSAGE);
				return;
			 
		 } else if(selectedTab.equals("Studentska služba - Profesori")) { 
			 //
		 } else if(selectedTab.equals("Studentska služba - Predmeti")) {
			 //
		 }
		
	}
}
