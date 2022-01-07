package gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.BazaOcena;
import model.BazaPredmeta;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.VrednostOcene;

public class DialogUpisOcene extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private boolean ispravno = false;
	private JTableNepolozeniPredmeti nepolozeni;
	private String datumPolaganja;
	
	public DialogUpisOcene(JTableNepolozeniPredmeti nepolozeni, Student student) {
		
		super();
		
		this.nepolozeni = nepolozeni;
		
		String id = student.getNepolozeniPred().get(nepolozeni.getSelectedRow());
		Predmet predmet = BazaPredmeta.getInstance().getPredmetByID(id);
		
		setSize(270, 300);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Upis ocene");
		
		Dimension dim = new Dimension(100, 25);
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogPanelLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogPanelLayout);
		
		FlowLayout panelLayout = new FlowLayout(FlowLayout.CENTER);
		
		dialogPanel.add(Box.createVerticalStrut(15));
		JPanel sifraPredmetaPanel = new JPanel();
		sifraPredmetaPanel.setLayout(panelLayout);
		JLabel sifraPredmetaLbl = new JLabel("Sifra*");
		JTextField sifraPredmetaTxt = new JTextField(predmet.getPredmetID());
		sifraPredmetaTxt.setEditable(false);
		sifraPredmetaLbl.setPreferredSize(dim);
		sifraPredmetaTxt.setPreferredSize(dim);
		dialogPanel.add(Box.createHorizontalStrut(30));
		sifraPredmetaPanel.add(sifraPredmetaLbl);
		sifraPredmetaPanel.add(sifraPredmetaTxt);
		dialogPanel.add(Box.createHorizontalStrut(30));
		dialogPanel.add(sifraPredmetaPanel);
		
		JPanel nazivPredmetaPanel = new JPanel();
		nazivPredmetaPanel.setLayout(panelLayout);
		JLabel nazivPredmetaLbl = new JLabel("Naziv*");
		JTextField nazivPredmetaTxt = new JTextField(predmet.getNazivPredmeta());
		nazivPredmetaTxt.setEditable(false);
		nazivPredmetaLbl.setPreferredSize(dim);
		nazivPredmetaTxt.setPreferredSize(dim);
		dialogPanel.add(Box.createHorizontalStrut(30));
		nazivPredmetaPanel.add(nazivPredmetaLbl);
		nazivPredmetaPanel.add(nazivPredmetaTxt);
		dialogPanel.add(Box.createHorizontalStrut(30));
		dialogPanel.add(nazivPredmetaPanel);
		
		JPanel vrednostOcenePanel = new JPanel();
		vrednostOcenePanel.setLayout(panelLayout);
		JLabel vrednostOceneLbl = new JLabel("Ocena*");
		String[] oceneVr = {"6", "7", "8", "9", "10"};
		JComboBox<String> vrednostOcene = new JComboBox<>(oceneVr);
		vrednostOceneLbl.setPreferredSize(dim);
		vrednostOcene.setPreferredSize(dim);
		dialogPanel.add(Box.createHorizontalStrut(30));
		vrednostOcenePanel.add(vrednostOceneLbl);
		vrednostOcenePanel.add(vrednostOcene);
		dialogPanel.add(Box.createHorizontalStrut(30));
		dialogPanel.add(vrednostOcenePanel);
		
		JPanel datumPolaganjaPanel = new JPanel();
		datumPolaganjaPanel.setLayout(panelLayout);
		JLabel datumPolaganjaLbl = new JLabel("Datum*");
		JTextField datumPolaganjaTxt = new JTextField();
		datumPolaganjaTxt.setToolTipText("dd-mm-yyyy");
		datumPolaganjaLbl.setPreferredSize(dim);
		datumPolaganjaTxt.setPreferredSize(dim);
		dialogPanel.add(Box.createHorizontalStrut(30));
		datumPolaganjaPanel.add(datumPolaganjaLbl);
		datumPolaganjaPanel.add(datumPolaganjaTxt);
		dialogPanel.add(Box.createHorizontalStrut(30));
		dialogPanel.add(datumPolaganjaPanel);
		dialogPanel.add(Box.createVerticalStrut(50));
		
		
		JPanel btnPanel = new JPanel(panelLayout);
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100, 25));
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100, 25));
		
		btnPanel.add(btnPotvrdi);
		btnPanel.add(btnOdustani);
		
		dialogPanel.add(btnPanel, BorderLayout.SOUTH);
		
		add(dialogPanel, BorderLayout.CENTER);
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vrOcene = vrednostOcene.getSelectedItem().toString();
				VrednostOcene vrOc;
				
				if(vrOcene.equals("6")) {
					vrOc = VrednostOcene.SEST;
				}
				
				else if(vrOcene.equals("7")) {
					vrOc = VrednostOcene.SEDAM;
				}
				
				else if(vrOcene.equals("8")) {
					vrOc = VrednostOcene.OSAM;
				}
				
				else if(vrOcene.equals("9")) {
					vrOc = VrednostOcene.DEVET;
				}
				
				else if(vrOcene.equals("10")) {
					vrOc = VrednostOcene.DESET;
				}
				
				LocalDate datumPol = LocalDate.parse(datumPolaganja, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				
				BazaOcena.getInstance().dodajOcenu(new Ocena(predmet.getPredmetID(), student.getBrIndeksa(), vrOc, datumPol ));
				
				dispose();
			}
		});
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		datumPolaganjaTxt.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				datumPolaganja = datumPolaganjaTxt.getText();
				String datumRegex = "[0-3][0-9]-[01][0-9]-[12][0-9]{3}";
				if(!datumPolaganja.matches(datumRegex)) {
					datumPolaganjaTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					datumPolaganjaTxt.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					ispravno = true;
				}
				btnPotvrdi.setEnabled(ispravno);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				datumPolaganja = datumPolaganjaTxt.getText();
				String datumRegex = "[0-3][0-9]-[01][0-9]-[12][0-9]{3}";
				if(!datumPolaganja.matches(datumRegex)) {
					datumPolaganjaTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					datumPolaganjaTxt.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					ispravno = true;
				}
				btnPotvrdi.setEnabled(ispravno);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				datumPolaganja = datumPolaganjaTxt.getText();
				String datumRegex = "[0-3][0-9]-[01][0-9]-[12][0-9]{3}";
				if(!datumPolaganja.matches(datumRegex)) {
					datumPolaganjaTxt.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					datumPolaganjaTxt.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					ispravno = true;
				}
				btnPotvrdi.setEnabled(ispravno);
			}
		});	
	}
}
