package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5171114834376020068L;
	private static TabbedPane instance=null;
	
	public static TabbedPane getInstance() {
		if(instance==null) {
			instance=new TabbedPane();
		}
		return instance;
	}
	
	private TabbedPane() {
		
		addTab("Studenti", new TableTab("Studenti"));
		addTab("Profesori", new TableTab("Profesori"));
		addTab("Predmeti", new TableTab("Predmeti"));
		setBackground(Color.WHITE);
		
		addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			 int index=(int)((JTabbedPane)e.getComponent()).getSelectedIndex();
			 
			 if(index==0) {
				StatusBar.lblSluzba.setText("Studentska slu�ba - Studenti");
			 } else if(index==1) {
				 StatusBar.lblSluzba.setText("Studentska slu�ba - Profesori");
			 }else if(index==2) {
				 StatusBar.lblSluzba.setText("Studentska slu�ba - Predmeti");
			 }else{
					StatusBar.lblSluzba.setText("Studentska slu�ba - Studenti");
				 }
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	});
		
		
		
		
		
	}
}
