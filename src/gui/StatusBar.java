package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1120385921841858593L;
	private static StatusBar instance=null;
	public static JLabel lblSluzba= new JLabel("Studentska služba - Studenti");
	
	public static StatusBar getInstance(){
		if(instance==null) {
			instance=new StatusBar();
		}
		return instance;
	}

	private StatusBar(){
		
		BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(box);
		setPreferredSize(new Dimension(100,27));
		setBackground(Color.WHITE);

		
		
		JLabel lblDatum=new JLabel();
		ActionListener al= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String date=(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy"))).toString();
				lblDatum.setText(date);
			}
		};
		
		Timer timer= new Timer(1000,al);
		timer.setInitialDelay(0);
		timer.start();
		
		
		add(Box.createHorizontalStrut(10));
		add(lblSluzba);
		add(Box.createHorizontalGlue());
		add(lblDatum);
		add(Box.createHorizontalStrut(10));
			
		
	}
}
