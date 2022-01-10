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

import controller.StudentiController;
import model.Predmet;
import model.Student;

public class DialogDodajPredmetStudentu extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1319798372759531393L;
	private JTableNepolozeniPredmeti predmetiTable;
	private JList<Object> predmetiList;
	
	public DialogDodajPredmetStudentu(Student student, JTableNepolozeniPredmeti predmetiTable) {
		
		super();
		
		this.predmetiTable = predmetiTable;
		
		setSize(500, 500);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Dodaj predmet");
		
		JPanel dialogPanel = new JPanel();
		BorderLayout dialogLayout = new BorderLayout();
		dialogPanel.setLayout(dialogLayout);
		
		JPanel panLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panLabel, BoxLayout.X_AXIS);
		panLabel.setLayout(labelLayout);
		panLabel.setPreferredSize(new Dimension(500, 50));
		JLabel predmetiLabel = new JLabel("Predmeti:");
		
		Dimension dimension = new Dimension(100, 30);
		predmetiLabel.setPreferredSize(dimension);
		
		panLabel.add(Box.createHorizontalStrut(25));
		panLabel.add(predmetiLabel);
		panLabel.add(Box.createHorizontalGlue());
		
		dialogPanel.add(panLabel, BorderLayout.NORTH);
		
		predmetiList = new JList<Object>(new AbstractListModelNePredmetiStudenata(student));
		predmetiList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane predmetiScrollPane = new JScrollPane(predmetiList);
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
				if(predmetiList.getSelectedIndex() > -1) {
					int[] niz=predmetiList.getSelectedIndices();
					int[] selektovano= new int[niz.length];
					
					for(int i=niz.length-1,j=0; i!=-1; i--,j++)
						selektovano[j]=niz[i];
					
					
					for(int selectedIndex : selektovano) {
						Predmet predmetZaDodati= (StudentiController.getInstance().listaPredmetaZaDodavanje(student)).get(selectedIndex);
						student.getNepolozeniPred().add(predmetZaDodati.getPredmetID());
						predmetZaDodati.getSpisakNepolozenih().add(student.getBrIndeksa());
						azurirajPrikaz();
						dispose();
					}
					
					azurirajPrikaz();
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Morate selektovati neki predmet", "Greška pri dodavanju studenta na predmet", JOptionPane.ERROR_MESSAGE);
					return;
			}});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});

	}
	
	public void azurirajPrikaz() {
		AbstractTableModelNepolozeniPredmeti predmetiModel = (AbstractTableModelNepolozeniPredmeti) predmetiTable.getModel();
		predmetiModel.fireTableDataChanged();
		validate();
	}
	
}
