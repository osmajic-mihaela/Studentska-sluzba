package gui;

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
		
	addMouseListener(new MouseListener() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
