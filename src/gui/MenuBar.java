package gui;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2224477752461936734L;
	private static MenuBar instance=null;
	

	public static MenuBar getInstance() {
		if(instance==null) {
			instance=new MenuBar();
		}
		return instance;
	}
	
	private MenuBar() {

			JMenu file= new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			JMenu edit= new JMenu("Edit");
			edit.setMnemonic(KeyEvent.VK_E);
			JMenu help= new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			
			JMenuItem miNew= new JMenuItem(new ActionNew(this));
			JMenuItem save= new JMenuItem("Save",new ImageIcon("images/save.png"));
			Icon icOpen= new ImageIcon("images/open.png");
			JMenu open= new JMenu("Open");
			open.setIcon(icOpen);
			JMenuItem close= new JMenuItem("Close",new ImageIcon("images/close.png"));
			
			JMenuItem oStudent= new JMenuItem("Studenti",new ImageIcon("images/student.png"));
			JMenuItem oProfesor= new JMenuItem("Profesori",new ImageIcon("images/profesor.png"));
			JMenuItem oPredmet= new JMenuItem("Predmeti",new ImageIcon("images/predmeti.png"));
			JMenuItem oKatedra= new JMenuItem("Katedre",new ImageIcon("images/katedra.png"));
			
			
			JMenuItem miEdit= new JMenuItem(new ActionEdit(this));
			JMenuItem delete= new JMenuItem(new ActionDelete(this));
			
			
			JMenuItem miHelp=new JMenuItem("Help",new ImageIcon("images/help.png"));
			JMenuItem about=new JMenuItem("About",new ImageIcon("images/about.png"));
			
			open.setMnemonic(KeyEvent.VK_O);
			save.setMnemonic(KeyEvent.VK_S);
			close.setMnemonic(KeyEvent.VK_C);
			
			oStudent.setMnemonic(KeyEvent.VK_S);
			oProfesor.setMnemonic(KeyEvent.VK_P);
			oPredmet.setMnemonic(KeyEvent.VK_R);
			oKatedra.setMnemonic(KeyEvent.VK_K);
			
			miHelp.setMnemonic(KeyEvent.VK_H);
			about.setMnemonic(KeyEvent.VK_A);
			
			save.setAccelerator(KeyStroke.getKeyStroke("control S"));
			close.setAccelerator(KeyStroke.getKeyStroke("control C"));
			
			oStudent.setAccelerator(KeyStroke.getKeyStroke("control alt S"));
			oProfesor.setAccelerator(KeyStroke.getKeyStroke("control alt P"));
			oPredmet.setAccelerator(KeyStroke.getKeyStroke("control alt R"));
			oKatedra.setAccelerator(KeyStroke.getKeyStroke("control alt K"));
			
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
			
			close.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] options= new String[2];
					options[0]= new String("Da");
					options[0]= new String("Ne");
					int code= JOptionPane.showOptionDialog(Frame.getInstance().getContentPane(), "Da li ste sigurni da �elite da zatvorite aplikaciju?", "Zatvaranje aplikacije", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
					
					if (code == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					
				}
			});
			
			oStudent.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					TabbedPane.getInstance().setSelectedIndex(0);
					StatusBar.lblSluzba.setText("Studentska služba - Studenti");
					
				}
			});
			
			oProfesor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					TabbedPane.getInstance().setSelectedIndex(1);
					StatusBar.lblSluzba.setText("Studentska služba - Profesori");
					
				}
			});
			
			oPredmet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					TabbedPane.getInstance().setSelectedIndex(2);
					StatusBar.lblSluzba.setText("Studentska služba - Predmeti");
					
				}
			});
			
			
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
