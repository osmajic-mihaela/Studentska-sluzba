package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
		
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
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		JPanel panel= new JPanel();
		Color siva = new Color(222, 222, 222);
		panel.setBackground(siva);
		this.add(panel);
		
		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar statusBar= new StatusBar(screenWidth);
		add(statusBar, BorderLayout.SOUTH);
		
	}
}
