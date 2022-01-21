package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.KatedraController;
import model.Katedra;
import model.Profesor;

public class DialogSefaKatedre extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967867352884955444L;
	private JTableKatedre katedraTable;
	private JList<Object> katedraList;

	public DialogSefaKatedre(Katedra katedra,JTableKatedre tabela) {
		katedraTable=tabela;
		setTitle("Dodaj sefa katedre");
		setSize(500,400);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		
		JPanel dialogPanel = new JPanel();
		BorderLayout dialogLayout = new BorderLayout();
		dialogPanel.setLayout(dialogLayout);
		
		JPanel panLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panLabel, BoxLayout.X_AXIS);
		panLabel.setLayout(labelLayout);
		panLabel.setPreferredSize(new Dimension(500, 50));
		JLabel predmetiLabel = new JLabel("Profesori:");
		
		Dimension dimension = new Dimension(100, 30);
		predmetiLabel.setPreferredSize(dimension);
		
		panLabel.add(Box.createHorizontalStrut(25));
		panLabel.add(predmetiLabel);
		panLabel.add(Box.createHorizontalGlue());
		
		dialogPanel.add(panLabel, BorderLayout.NORTH);
		
		katedraList = new JList<Object>(new AbstractListModelSefaKatedre(katedra));
		katedraList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane predmetiScrollPane = new JScrollPane(katedraList);
		predmetiScrollPane.setPreferredSize(new Dimension(200, 200));
		dialogPanel.add(predmetiScrollPane, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		BoxLayout btnLayout = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(btnLayout);
		btnPanel.setPreferredSize(new Dimension(500, 50));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100, 30));
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100, 30));
		
		btnPanel.add(Box.createHorizontalGlue());
		btnPanel.add(btnPotvrdi);
		btnPanel.add(Box.createHorizontalStrut(25));
		btnPanel.add(btnOdustani);
		btnPanel.add(Box.createHorizontalStrut(25));
		dialogPanel.add(btnPanel, BorderLayout.SOUTH);
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(25, 500));
		dialogPanel.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25, 500));
		dialogPanel.add(eastPanel, BorderLayout.EAST);
		
		add(dialogPanel, BorderLayout.CENTER);
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(katedraList.getSelectedIndex() > -1) {
					int index=katedraList.getSelectedIndex();
					
					Profesor profesorZaDodati= (KatedraController.getInstance().getProfesoriZaSefa(katedra)).get(index);
					katedra.setSefKatedreID(profesorZaDodati.getProfesorID());
					azurirajPrikaz();
					dispose();
					
					
				}else 
					JOptionPane.showMessageDialog(null, "Morate selektovati nekog profesora", "Greska pri dodavanju sefa katedre", JOptionPane.ERROR_MESSAGE);
					return;
			}});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelKatedre katedreModel = (AbstractTableModelKatedre) katedraTable.getModel();
		katedreModel.fireTableDataChanged();
		validate();
	}
}
