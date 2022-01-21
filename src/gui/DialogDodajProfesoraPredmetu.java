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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.StudentiController;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import controller.ProfesoriController;
public class DialogDodajProfesoraPredmetu extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JList<Object> profesoriList;
	
	public DialogDodajProfesoraPredmetu(Predmet predmet, JTextField txtProf, JButton plus, JButton minus) {
		setTitle("Odaberi profesora");
		setSize(500, 500);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		
		JPanel mainPanel = new JPanel();
		BorderLayout mainLayout = new BorderLayout();
		mainPanel.setLayout(mainLayout);
		
		JPanel panLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panLabel, BoxLayout.X_AXIS);
		panLabel.setLayout(labelLayout);
		panLabel.setPreferredSize(new Dimension(500, 50));
		JLabel profesoriLabel = new JLabel("Profesori: ");
		
		Dimension dimension = new Dimension(100, 30);
		profesoriLabel.setPreferredSize(dimension);
		
		panLabel.add(Box.createHorizontalStrut(25));
		panLabel.add(profesoriLabel);
		panLabel.add(Box.createHorizontalGlue());
		
		mainPanel.add(panLabel, BorderLayout.NORTH);
		
		profesoriList = new JList<Object>(new AbstractListModelProfesorPredmetu(predmet));
		profesoriList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane profesoriScrollPane = new JScrollPane(profesoriList);
		profesoriScrollPane.setPreferredSize(new Dimension(200, 200));
		mainPanel.add(profesoriScrollPane, BorderLayout.CENTER);
		
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
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(25, 500));
		mainPanel.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25, 500));
		mainPanel.add(eastPanel, BorderLayout.EAST);
		
		add(mainPanel, BorderLayout.CENTER);
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(profesoriList.getSelectedIndex() > -1) {
					
					int index = profesoriList.getSelectedIndex();
					//dodaj u kontroler
					Profesor prof = ProfesoriController.getInstance().getProfesoriPredmeta(predmet.getPredmetID(), index);
					predmet.setProfesor(prof.getProfesorID());
					txtProf.setText(prof.getIme() + " " + prof.getPrezime());
					plus.setEnabled(false);
					minus.setEnabled(true);
					dispose();
				
				}else
					JOptionPane.showMessageDialog(null, "Morate selektovati nekog profesora", "Greška pri dodavanju profesora na predmet", JOptionPane.ERROR_MESSAGE);
					return;
			}});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}});
	}		
}

