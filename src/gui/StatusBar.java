package gui;

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

	public StatusBar(int s){
		
		

		BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(box);

		
		JLabel lblSluzba= new JLabel("Studentska služba");

		
		String date=(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))).toString();
		JLabel lblDatum=new JLabel(date);
	
		
		add(Box.createHorizontalStrut(10));
		add(lblSluzba);
		add(Box.createHorizontalGlue());
		add(lblDatum);
		add(Box.createHorizontalStrut(10));
		
		
		
	}
}
