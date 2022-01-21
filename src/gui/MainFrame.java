package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Serijalizacija;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame implements WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		
		return instance;
	}
	
	private MainFrame() {
		initPosition();
		createMenuBar();
		createToolBar();
		createTableTab();
		createStatusBar();
	}

	private void initPosition() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3/4, screenHeight * 3/4);
		setTitle("Studentska služba");
		ImageIcon logo = new ImageIcon("images/ftn-logo22px.png");
		this.setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
				
		JPanel panel= new JPanel();
		Color siva = new Color(222, 222, 222);
		panel.setBackground(siva);
		this.add(panel);
	}
	
	private void createMenuBar() {
		MenuBar menuBar = MenuBar.getInstance();
		setJMenuBar(menuBar);
	}
	
	private void createToolBar() {
		ToolBar toolBar = ToolBar.getInstance();
		add(toolBar, BorderLayout.NORTH);
	}
	
	private void createStatusBar() {
		StatusBar statusBar = StatusBar.getInstance();
		add(statusBar, BorderLayout.SOUTH);
	}
	
	private void createTableTab() {
		TablePanel tab=TablePanel.getInstance();
		add(tab,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.setVisible(true);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		String[] options = new String[2];
		options[0] = new String("Da");
		options[1] = new String("Ne");
		int code = JOptionPane.showOptionDialog(MainFrame.getInstance().getContentPane(),"Da li ste sigurni da zelite da zatvorite aplikaciju?","Zatvaranje aplikacije?", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
		if (code != JOptionPane.YES_OPTION) {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			try {
				Serijalizacija.getInstance().serijalizacijaStudenta();
				Serijalizacija.getInstance().serijalizacijaProfesora();
				Serijalizacija.getInstance().serijalizacijaPredmeta();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
