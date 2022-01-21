package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.KatedraController;
import model.Katedra;

public class DialogKatedre extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8475442813123806433L;
	private static DialogKatedre instance= null;
	
	public static DialogKatedre getInstance() {
		
		if(instance==null)
			instance= new DialogKatedre();
		
		return instance;
	}
	
	private DialogKatedre() {
		
		setTitle("Katedre");
		setSize(600,600);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel main=new JPanel();
		main.setLayout(new BorderLayout());
		
		JPanel gore= new JPanel();
		gore.setPreferredSize(new Dimension(300,50));
		main.add(gore,BorderLayout.NORTH);
		
		JPanel centar= new JPanel();		
		
		JTableKatedre katedre= new JTableKatedre();
		JScrollPane sc= new JScrollPane(katedre);
		centar.add(sc);
		
		main.add(centar, BorderLayout.CENTER);
		
		JPanel dole= new JPanel();
		JButton btnDodajSefa= new JButton("Dodaj sefa katedre");
		JButton btnUkloniSefa= new JButton("Ukloni sefa katedre");
		dole.add(btnDodajSefa);
		dole.add(btnUkloniSefa);		
		btnDodajSefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Katedra katedra= KatedraController.getInstance().getListaSvihKatedri().get(katedre.getSelectedRow());
				DialogSefaKatedre dsk= new DialogSefaKatedre(katedra, katedre);
				dsk.setVisible(true);
			}
		});
		
		btnUkloniSefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Katedra katedra= KatedraController.getInstance().getListaSvihKatedri().get(katedre.getSelectedRow());
				katedra.setSefKatedreID("");
				azurirajTabelu(katedre);
			}
		});
		
		main.add(dole, BorderLayout.SOUTH);
		
		add(main);
		
		
	}
	
	public void azurirajTabelu(JTableKatedre katedre) {
		AbstractTableModelKatedre k = (AbstractTableModelKatedre) katedre.getModel();
		k.fireTableDataChanged();
		validate();
	}
}
