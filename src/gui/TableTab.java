package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TableTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5396352358675572808L;
	private String tableName;
	JTableStudenti tabelaStudenata;
	JTableProfesori tabelaProfesora;
	private JScrollPane scrollPane;
	
	public TableTab(String tableName) {
		
		setLayout(new BorderLayout());
		this.tableName=tableName;
		
		if(tableName=="Studenti") {
			tabelaStudenata = JTableStudenti.getInstance();
			scrollPane = new JScrollPane(tabelaStudenata);
		} else if(tableName=="Profesori") {
			tabelaProfesora = JTableProfesori.getInstance();
			scrollPane = new JScrollPane(tabelaProfesora);
		} else if(tableName=="Predmeti")
		{
			//tabelaPredmeta = JTablePredmeti.getInstance();
			//scrollPane = new JScrollPane(tabelaPredmeta);
		}
		
		JPanel panNorth = new JPanel();
		JPanel panSouth = new JPanel();
		JPanel panWest = new JPanel();
		JPanel panEast = new JPanel();
		
		add(panNorth, BorderLayout.NORTH);
		add(panSouth, BorderLayout.SOUTH);
		add(panWest, BorderLayout.WEST);
		add(panEast, BorderLayout.EAST);
		
		panNorth.setPreferredSize(new Dimension(1100, 30));
		panSouth.setPreferredSize(new Dimension(1100, 20));
		panWest.setPreferredSize(new Dimension(60, 500));
		panEast.setPreferredSize(new Dimension(60, 500));
		
		add(scrollPane, BorderLayout.CENTER);
			
	}
}
