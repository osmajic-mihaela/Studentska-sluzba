package gui;

import java.awt.Cursor;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
			
			JMenu file= new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			JMenu edit= new JMenu("Edit");
			edit.setMnemonic(KeyEvent.VK_E);
			JMenu help= new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			
			JMenuItem miNew= new JMenuItem("New", new ImageIcon("images/new.png"));
			JMenuItem save= new JMenuItem("Save",new ImageIcon("images/save.png"));
			Icon icOpen= new ImageIcon("images/open.png");
			JMenu open= new JMenu("Open");
			open.setIcon(icOpen);
			JMenuItem close= new JMenuItem("Close",new ImageIcon("images/close.png"));
			
			JMenuItem oStudent= new JMenuItem("Studenti",new ImageIcon("images/student.png"));
			JMenuItem oProfesor= new JMenuItem("Profesori",new ImageIcon("images/profesor.png"));
			JMenuItem oPredmet= new JMenuItem("Predmeti",new ImageIcon("images/predmeti.png"));
			JMenuItem oKatedra= new JMenuItem("Katedre",new ImageIcon("images/katedra.png"));
			
			
			JMenuItem miEdit= new JMenuItem("Edit",new ImageIcon("images/edit.png"));
			JMenuItem delete= new JMenuItem("Delete",new ImageIcon("images/delete.png"));
			
			
			JMenuItem miHelp=new JMenuItem("Help",new ImageIcon("images/help.png"));
			JMenuItem about=new JMenuItem("About",new ImageIcon("images/about.png"));
			
			miNew.setMnemonic(KeyEvent.VK_N);
			open.setMnemonic(KeyEvent.VK_O);
			save.setMnemonic(KeyEvent.VK_S);
			close.setMnemonic(KeyEvent.VK_C);
			
			oStudent.setMnemonic(KeyEvent.VK_S);
			oProfesor.setMnemonic(KeyEvent.VK_P);
			oPredmet.setMnemonic(KeyEvent.VK_R);
			oKatedra.setMnemonic(KeyEvent.VK_K);
			
			miEdit.setMnemonic(KeyEvent.VK_E);
			delete.setMnemonic(KeyEvent.VK_L);
			
			miHelp.setMnemonic(KeyEvent.VK_H);
			about.setMnemonic(KeyEvent.VK_A);
			
			miNew.setAccelerator(KeyStroke.getKeyStroke("control N"));
			save.setAccelerator(KeyStroke.getKeyStroke("control S"));
			close.setAccelerator(KeyStroke.getKeyStroke("control C"));
			
			oStudent.setAccelerator(KeyStroke.getKeyStroke("control alt S"));
			oProfesor.setAccelerator(KeyStroke.getKeyStroke("control alt P"));
			oPredmet.setAccelerator(KeyStroke.getKeyStroke("control alt R"));
			oKatedra.setAccelerator(KeyStroke.getKeyStroke("control alt K"));
			
			miEdit.setAccelerator(KeyStroke.getKeyStroke("control E"));
			delete.setAccelerator(KeyStroke.getKeyStroke("control D"));
			
			miHelp.setAccelerator(KeyStroke.getKeyStroke("control H"));
			about.setAccelerator(KeyStroke.getKeyStroke("control A"));
			
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			file.setCursor(cursor);
			edit.setCursor(cursor);
			help.setCursor(cursor);
			
			miNew.setCursor(cursor);
			save.setCursor(cursor);
			close.setCursor(cursor);
			
			oStudent.setCursor(cursor);
			oProfesor.setCursor(cursor);
			oPredmet.setCursor(cursor);
			oKatedra.setCursor(cursor);
			
			miEdit.setCursor(cursor);
			delete.setCursor(cursor);
			
			miHelp.setCursor(cursor);
			about.setCursor(cursor);
			
			
			add(file);
			add(edit);
			add(help);
			
			file.add(miNew);
			file.addSeparator();
			file.add(save);
			file.addSeparator();
			file.add(open);
			file.addSeparator();
			file.add(close);
			
			open.add(oStudent);
			open.addSeparator();
			open.add(oPredmet);
			open.addSeparator();
			open.add(oProfesor);
			open.addSeparator();
			open.add(oKatedra);
			
			edit.add(miEdit);
			edit.addSeparator();
			edit.add(delete);
			
			help.add(miHelp);
			help.addSeparator();
			help.add(about);
			
	
	}
}
