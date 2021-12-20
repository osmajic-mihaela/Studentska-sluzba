package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TablePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4493128626883961928L;
	private static TablePanel instance=null;
	
	public static TablePanel getInstance() {
		if(instance==null) {
			instance= new TablePanel();
		}
		
		return instance;
	}

	private TablePanel() {
		super();
		setLayout(new BorderLayout());

		JPanel panNorth = new JPanel();
		JPanel panSouth = new JPanel();
		JPanel panWest = new JPanel();
		JPanel panEast = new JPanel();
		TabbedPane tabbedPane = TabbedPane.getInstance();
		
		panNorth.setPreferredSize(new Dimension(1100, 10));
		panSouth.setPreferredSize(new Dimension(1100, 15));
		panWest.setPreferredSize(new Dimension(20, 500));
		panEast.setPreferredSize(new Dimension(20, 500));
		
		
		add(panNorth, BorderLayout.NORTH);
		add(panSouth, BorderLayout.SOUTH);
		add(panWest, BorderLayout.WEST);
		add(panEast, BorderLayout.EAST);
		add(tabbedPane, BorderLayout.CENTER);
		
		
		setVisible(true);
		
	}
}
