package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Novi entitet (Ctrl + N)");
		btnNew.setIcon(new ImageIcon("images/new.png"));
		add(btnNew);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmena odabranog entiteta (Ctrl + E)");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Brisanje odabranog entiteta (Ctrl + D)");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		add(btnDelete);
		
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		btnNew.setCursor(cursor);
		btnEdit.setCursor(cursor);
		btnDelete.setCursor(cursor);
		
		//pravi razmak izmedju pocetna 3 dugmeta i search polja
		add(Box.createHorizontalGlue());
		
		//podesavanje sirine search polja
		JTextField search = new JTextField("Unesite pretragu...");
		search.setColumns(20);
		search.setMaximumSize(new Dimension(100, 35));
		add(search);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Pretraga");
		btnSearch.setIcon(new ImageIcon("images/magnifying_glass.png"));
		add(btnSearch);
		
		setFloatable(false);
	}
}
