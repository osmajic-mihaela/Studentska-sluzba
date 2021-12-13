package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar(){
		
		

		BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(box);
		setPreferredSize(new Dimension(100,27));
		setBackground(Color.WHITE);

		
		JLabel lblSluzba= new JLabel("Studentska slu�ba");

		
		String date=(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))).toString();
		JLabel lblDatum=new JLabel(date);
	
		
		add(Box.createHorizontalStrut(10));
		add(lblSluzba);
		add(Box.createHorizontalGlue());
		add(lblDatum);
		add(Box.createHorizontalStrut(10));
		
		
		
	}
}
