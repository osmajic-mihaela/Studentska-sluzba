package gui;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class DialogAbout extends JDialog {
	
	public DialogAbout() {
		super();
		
		setSize(700,500);
		setLocationRelativeTo(MainFrame.getInstance());
		setTitle("About");
		
		JTextArea opis = new JTextArea(300,300);
		
		
		String text = 
				
				"\n Verzija aplikacije: Studentska služba v1.0\n\r"+
				"Aplikacija za potrebe referenta studentske službe\n\n\r"+
				"Aplikacija je implementirana upotrebom Java programskog jezika.\n\r"+
				"Grafička korisička sprega razvijena je upotrebom Swing biblioteke.\n\r"+
			    "Glavni prozor aplikacije sadrži MeniBar, ToolBar, tabele sa entitetima i StatusBar.\n\r"+
						
			    "\n\r"+
				"\n\n\n Student 1 - Mihaela Osmajić"
				+ "\nRođena u Novom Sadu 06.04. 2000. . \n Trenutno pohađa 3. godinu osnovnih akademskih studija na Fakultetu tehničkih nauka na smeru Računarstvo i automatika.\n Pohađala prirodno-matematički smer Gimnazije 'Jovan Jovanović Zmaj'."
				+ "\n Student 2 - Petar Obradović"
				+ "\nRođen u Novom Sadu 11.09.2000. . \n Trenutno pohađa 3. godinu osnovnih akademskih studija na Fakultetu tehničkih nauka na smeru Računarstvo i automatika.\n Pohađao smer laboratorijski tehničar medicinske škole '7. april'.";
		opis.setText(text);
		add(opis);
		setVisible(true);
	
	}
}
