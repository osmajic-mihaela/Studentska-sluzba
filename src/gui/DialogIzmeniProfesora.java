package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.KatedraController;
import controller.PredmetiController;
import controller.ProfesoriController;
import model.Predmet;
import model.Profesor;

public class DialogIzmeniProfesora extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private boolean ispravno[] = {true, true, true, true, true, true, true, true, true, true};
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStan;
	private String kontaktTelefon;
	private String email;
	private String adresaKanc;
	private String brLicne;
	private String godRadnogStaza;
	private String ulicaStan;
	private String brojStan;
	private String brojKanc;
	private String ulicaKanc;
	private String grad;
	private String drzava;
	private String zvanje;
	private String gradKanc;
	
	public DialogIzmeniProfesora(int selectedIndex){
		
		Profesor profesor = ProfesoriController.getInstance().getListaSvihProfesora().get(selectedIndex);
		setTitle("Izmeni profesora");
		setSize(500, 500);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JTabbedPane  tabbedPane = new JTabbedPane();
		
		JPanel panelInformacije = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(panelInformacije, BoxLayout.Y_AXIS);
		panelInformacije.setLayout(dialogLayout);
		tabbedPane.addTab("Informacije", panelInformacije );
		
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panNorth = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panNorth, BoxLayout.Y_AXIS);
		panNorth.setLayout(boxCenter);
		
		Dimension dimension = new Dimension(150, 20);
		
		JPanel panelIme = new JPanel();
		JLabel lblIme = new JLabel("Ime*");
		lblIme.setPreferredSize(dimension);
		JTextField txtIme = new JTextField(profesor.getIme());
		txtIme.setPreferredSize(dimension);
        panelIme.add(Box.createHorizontalStrut(10));
        panelIme.add(lblIme);
        panelIme.add(txtIme);
        panelIme.add(Box.createHorizontalStrut(10));
		
        JPanel panelPrezime=new JPanel();
        JLabel lblPrezime=new JLabel("Prezime*");
        lblPrezime.setPreferredSize(dimension);
        JTextField txtPrezime=new JTextField(profesor.getPrezime());
        txtPrezime.setPreferredSize(dimension);
        panelPrezime.add(Box.createHorizontalStrut(10));
        panelPrezime.add(lblPrezime);
        panelPrezime.add(txtPrezime);
        panelPrezime.add(Box.createHorizontalStrut(10));
        
        
        JPanel panelDatum = new JPanel();
        JLabel lblDatum = new JLabel("Datum rodjenja*");
        lblDatum.setPreferredSize(dimension);
        JTextField txtDatum = new JTextField((profesor.getDatumRodj()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        txtDatum.setPreferredSize(dimension);
        panelDatum.add(Box.createHorizontalStrut(10));
        panelDatum.add(lblDatum);
        panelDatum.add(txtDatum);
        panelDatum.add(Box.createHorizontalStrut(10));
        

        JPanel panelAdresa = new JPanel();
        JLabel lblAdresa = new JLabel("Adresa stanovanja*");
        JTextField txtAdresa = new JTextField(profesor.getAdresaStan().toString());
        lblAdresa.setPreferredSize(dimension);
        txtAdresa.setPreferredSize(dimension);
        panelAdresa.add(Box.createHorizontalStrut(10));
        panelAdresa.add(lblAdresa);
        panelAdresa.add(txtAdresa);
        panelAdresa.add(Box.createHorizontalStrut(10));
        
        JPanel panelTelefon= new JPanel();
        JLabel lblTelefon= new JLabel("Broj telefona*");
        JTextField txtTelefon = new JTextField(profesor.getKontaktBroj());
        lblTelefon.setPreferredSize(dimension);
        txtTelefon.setPreferredSize(dimension);
        panelTelefon.add(Box.createHorizontalStrut(10));
        panelTelefon.add(lblTelefon);
        panelTelefon.add(txtTelefon);
        panelTelefon.add(Box.createHorizontalStrut(10));

        JPanel panelEmail = new JPanel();
        JLabel lblEmail = new JLabel("E-mail adresa*");
        JTextField txtEmail = new JTextField(profesor.getEmail());
        lblEmail.setPreferredSize(dimension);
        txtEmail.setPreferredSize(dimension);
        panelEmail.add(Box.createHorizontalStrut(10));
        panelEmail.add(lblEmail);
        panelEmail.add(txtEmail);
        panelEmail.add(Box.createHorizontalStrut(10));
        
        JPanel panelAdresaKanc = new JPanel();
        JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
        JTextField txtAdresaKanc = new JTextField(profesor.getAdresaKancelar().toString());
        lblAdresaKanc.setPreferredSize(dimension);
        txtAdresaKanc.setPreferredSize(dimension);
        panelAdresaKanc.add(Box.createHorizontalStrut(10));
        panelAdresaKanc.add(lblAdresaKanc);
        panelAdresaKanc.add(txtAdresaKanc);
        panelAdresaKanc.add(Box.createHorizontalStrut(10));
        
        JPanel panelBrLicne = new JPanel();
        JLabel lblBrLicne = new JLabel("Broj li�ne karte*");
        JTextField txtBrLicne = new JTextField(profesor.getBrLicne()+"");
        lblBrLicne.setPreferredSize(dimension);
        txtBrLicne.setPreferredSize(dimension);
        panelBrLicne.add(Box.createHorizontalStrut(10));
        panelBrLicne.add(lblBrLicne);
        panelBrLicne.add(txtBrLicne);
        panelBrLicne.add(Box.createHorizontalStrut(10));
		
        JPanel panelZvanje = new JPanel();
        JLabel lblZvanje = new JLabel("Zvanje*");
        JTextField txtZvanje = new JTextField(profesor.getZvanje());
        lblZvanje.setPreferredSize(dimension);
        txtZvanje.setPreferredSize(dimension);
        panelZvanje.add(Box.createHorizontalStrut(10));
        panelZvanje.add(lblZvanje);
        panelZvanje.add(txtZvanje);
        panelZvanje.add(Box.createHorizontalStrut(10));
		
        JPanel panelGodRadnogStaza = new JPanel();
        JLabel lblGodRadnogStaza = new JLabel("Godina radnog sta�a*");
        JTextField txtGodRadnogStaza = new JTextField(profesor.getGodRadnogStaza()+"");
        lblGodRadnogStaza.setPreferredSize(dimension);
        txtGodRadnogStaza.setPreferredSize(dimension);
        txtGodRadnogStaza.setMaximumSize(dimension);
        txtGodRadnogStaza.setColumns(13);
        panelGodRadnogStaza.add(Box.createHorizontalStrut(10));
        panelGodRadnogStaza.add(lblGodRadnogStaza);
        panelGodRadnogStaza.add(txtGodRadnogStaza);
        panelGodRadnogStaza.add(Box.createHorizontalStrut(10));
		
		txtAdresa.setToolTipText("Primer: Ulica {broj}, grad, drzava");
		txtDatum.setToolTipText("Primer: dd-mm-yyyy");
		txtEmail.setToolTipText("Primer: email@gmail.com");
		
		panNorth.add(Box.createVerticalStrut(15));
        panNorth.add(panelIme);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelPrezime);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelDatum);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelAdresa);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelTelefon);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelEmail);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelAdresaKanc);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelBrLicne);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelZvanje);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panelGodRadnogStaza);
        panNorth.add(Box.createVerticalStrut(10));  
        panelInformacije.add(panNorth,BorderLayout.NORTH);
		
        JPanel panCenter=new JPanel();
		BoxLayout box=new BoxLayout(panCenter, BoxLayout.X_AXIS);
		panCenter.setLayout(box);
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100,25));
		
		JButton btnOdustani=new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100,25));
		
		panCenter.add(Box.createGlue());
		panCenter.add(btnPotvrdi);
		panCenter.add(Box.createHorizontalStrut(30));
		panCenter.add(btnOdustani);
		panCenter.add(Box.createGlue());
		
		panelInformacije.add(panCenter,BorderLayout.CENTER);
		
		JPanel panBottom=new JPanel();
		panBottom.setPreferredSize(new Dimension(150,15));
		panelInformacije.add(panBottom,BorderLayout.SOUTH);
		
		btnPotvrdi.setEnabled(true);
		
		ime = profesor.getIme();
		prezime = profesor.getPrezime();
		datumRodjenja = (profesor.getDatumRodj()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		kontaktTelefon = profesor.getKontaktBroj();
		adresaStan = profesor.getAdresaStan().toString();
		adresaKanc = profesor.getAdresaKancelar().toString();
		brLicne = profesor.getBrLicne()+"";
		email = profesor.getEmail();
		godRadnogStaza = profesor.getGodRadnogStaza()+"";
		ulicaStan = profesor.getAdresaStan().getUlica();
		brojStan = profesor.getAdresaStan().getBroj();
		grad = profesor.getAdresaStan().getGrad();
		drzava = profesor.getAdresaStan().getDrzava();
		ulicaKanc = profesor.getAdresaKancelar().getUlica();
		brojKanc = profesor.getAdresaKancelar().getBroj();
		zvanje = profesor.getZvanje();
		
		btnOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Profesor p : ProfesoriController.getInstance().getListaSvihProfesora()) {
					if((p != ProfesoriController.getInstance().getListaSvihProfesora().get(selectedIndex)) && (p.getBrLicne() == Integer.parseInt(brLicne))) {
						JOptionPane.showMessageDialog(null, "Profesor sa datim brojem li�ne karte ve� postoji u sistemu", "Gre�ka pri izmeni profesora", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				String brojeviDatuma[] = datumRodjenja.split("-");
				
				if(brojeviDatuma[0].length() == 1) {
					brojeviDatuma[0] = "0" + brojeviDatuma[0];
					datumRodjenja = brojeviDatuma[0]+"-"+brojeviDatuma[1]+"-"+brojeviDatuma[2];
				}
				
				if(brojeviDatuma[1].length() == 1) {
					brojeviDatuma[1] = "0" + brojeviDatuma[1];
					datumRodjenja = brojeviDatuma[0]+"-"+brojeviDatuma[1]+"-"+brojeviDatuma[2];
				}
				
				adressStan(txtAdresa.getText());
				adressKanc(txtAdresaKanc.getText());
				LocalDate datumRodj = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				int godRadnog = Integer.parseInt(godRadnogStaza);
				int brLicneKarte = Integer.parseInt(brLicne);
				Profesor profesor = new Profesor(ime, prezime, datumRodj, kontaktTelefon, email, brLicneKarte, zvanje, godRadnog, ulicaStan, brojStan, grad, drzava,gradKanc, ulicaKanc, brojKanc);
				ProfesoriController.getInstance().izmeniProfesora(selectedIndex, profesor);
				dispose();
			}
		});
		zvanje = txtZvanje.getText();
		txtIme.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				ime = txtIme.getText();
				String imeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(ime, imeRegex, 0)) {
					txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				ime = txtIme.getText();
				String imeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(ime, imeRegex, 0)) {
					txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				ime = txtIme.getText();
				String imeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(ime, imeRegex, 0)) {
					txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				}
				else {
					txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtPrezime.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				prezime = txtPrezime.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(prezime, prezimeRegex, 1))
					txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
	
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				prezime = txtPrezime.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(prezime, prezimeRegex, 1))
					txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
	
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				prezime = txtPrezime.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				if(!proveraUnosaPolja(prezime, prezimeRegex, 1))
					txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
	
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtDatum.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				datumRodjenja = txtDatum.getText();
				String datumRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				if(!proveraUnosaPolja(datumRodjenja, datumRegex, 2))
					txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				datumRodjenja = txtDatum.getText();
				String datumRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				if(!proveraUnosaPolja(datumRodjenja, datumRegex, 2))
					txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				datumRodjenja = txtDatum.getText();
				String datumRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				if(!proveraUnosaPolja(datumRodjenja, datumRegex, 2))
					txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtAdresa.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				adresaStan = txtAdresa.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaStan, adresaRegex, 3))
					txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				adresaStan = txtAdresa.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaStan, adresaRegex, 3))
					txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				adresaStan = txtAdresa.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaStan, adresaRegex, 3))
					txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtTelefon.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				kontaktTelefon = txtTelefon.getText();
				String brTelRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				if(!proveraUnosaPolja(kontaktTelefon, brTelRegex, 4))
					txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				kontaktTelefon = txtTelefon.getText();
				String brTelRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				if(!proveraUnosaPolja(kontaktTelefon, brTelRegex, 4))
					txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				kontaktTelefon = txtTelefon.getText();
				String brTelRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				if(!proveraUnosaPolja(kontaktTelefon, brTelRegex, 4))
					txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}
		});
		
		txtEmail.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				email = txtEmail.getText();
				String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				boolean pr=!proveraUnosaPolja(email, emailRegex, 5);
				if(pr)
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				email = txtEmail.getText();
				String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				boolean pr=!proveraUnosaPolja(email, emailRegex, 5);
				if(pr)
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				email = txtEmail.getText();
				String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				boolean pr=!proveraUnosaPolja(email, emailRegex, 5);
				if(pr)
					txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtAdresaKanc.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				adresaKanc = txtAdresaKanc.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaKanc, adresaRegex, 6))
					txtAdresaKanc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresaKanc.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				adresaKanc = txtAdresaKanc.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaKanc, adresaRegex, 6))
					txtAdresaKanc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresaKanc.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				adresaKanc = txtAdresaKanc.getText();
				String adresaRegex ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
				if(!proveraUnosaPolja(adresaKanc, adresaRegex, 6))
					txtAdresaKanc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtAdresaKanc.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtBrLicne.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				brLicne = txtBrLicne.getText();
				String brLicneKarteRegex = "\\d{9}";
				if(!proveraUnosaPolja(brLicne, brLicneKarteRegex, 7))
					txtBrLicne.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtBrLicne.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				brLicne = txtBrLicne.getText();
				String brLicneKarteRegex = "\\d{9}";
				if(!proveraUnosaPolja(brLicne, brLicneKarteRegex, 7))
					txtBrLicne.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtBrLicne.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				brLicne = txtBrLicne.getText();
				String brLicneKarteRegex = "\\d{9}";
				if(!proveraUnosaPolja(brLicne, brLicneKarteRegex, 7))
					txtBrLicne.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtBrLicne.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtGodRadnogStaza.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				godRadnogStaza = txtGodRadnogStaza.getText();
				String godRadnogStazaRegex = "\\b([0-9]|[1-9][0-9])\\b";
				if(!proveraUnosaPolja(godRadnogStaza, godRadnogStazaRegex, 8))
					txtGodRadnogStaza.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtGodRadnogStaza.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				godRadnogStaza = txtGodRadnogStaza.getText();
				String godRadnogStazaRegex = "\\b([0-9]|[1-9][0-9])\\b";
				if(!proveraUnosaPolja(godRadnogStaza, godRadnogStazaRegex, 8))
					txtGodRadnogStaza.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtGodRadnogStaza.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				godRadnogStaza = txtGodRadnogStaza.getText();
				String godRadnogStazaRegex = "\\b([0-9]|[1-9][0-9])\\b";
				if(!proveraUnosaPolja(godRadnogStaza, godRadnogStazaRegex, 8))
					txtGodRadnogStaza.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else {
					txtGodRadnogStaza.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
				btnPotvrdi.setEnabled(enablePotvrdi());
			}
		});
		
		txtZvanje.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					zvanje = txtZvanje.getText();
					String zvanjeRegex = "[a-zA-Z]+";
					if(!proveraUnosaPolja(zvanje, zvanjeRegex, 9))
						txtZvanje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtZvanje.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
	
				@Override
				public void removeUpdate(DocumentEvent e) {
					zvanje = txtZvanje.getText();
					String zvanjeRegex = "[a-zA-Z]+";
					if(!proveraUnosaPolja(zvanje, zvanjeRegex, 9))
						txtZvanje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtZvanje.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					zvanje = txtZvanje.getText();
					String zvanjeRegex = "[a-zA-Z]+";
					if(!proveraUnosaPolja(zvanje, zvanjeRegex, 9))
						txtZvanje.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtZvanje.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
			});
		
		
		///////////////////////////////////////////////////////////////	
		
		JPanel panelPredmeti = new JPanel();
		panelPredmeti.setLayout( new BorderLayout());
		tabbedPane.addTab("Predmeti", panelPredmeti);
		
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel btnPredmetiPanel = new JPanel();
		BoxLayout btnPredmetiLayout = new BoxLayout(btnPredmetiPanel, BoxLayout.X_AXIS);
		btnPredmetiPanel.setLayout(btnPredmetiLayout);

		JButton btnDodajPredmet = new JButton("Dodaj predmet");
		btnDodajPredmet.setPreferredSize(new Dimension(150, 30));
		JButton btnUkloniPredmet = new JButton("Ukloni predmet");
		btnUkloniPredmet.setPreferredSize(new Dimension(150, 30));
		
		btnPredmetiPanel.add(Box.createHorizontalStrut(25));
		btnPredmetiPanel.add(btnDodajPredmet);
		btnPredmetiPanel.add(Box.createHorizontalStrut(10));
		btnPredmetiPanel.add(btnUkloniPredmet);
		btnPredmetiPanel.add(Box.createHorizontalGlue());
		btnPredmetiPanel.setPreferredSize(new Dimension(750, 50));
		
		panelPredmeti.add(btnPredmetiPanel, BorderLayout.NORTH);
		
		JTablePredmetiPoProfesoru predmetiProfesora = new JTablePredmetiPoProfesoru(profesor);
		JScrollPane predmetiScrollPane = new JScrollPane(predmetiProfesora);
		predmetiScrollPane.setPreferredSize(new Dimension(400, 400));
		panelPredmeti.add(predmetiScrollPane, BorderLayout.CENTER);
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(25, 750));
		panelPredmeti.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25, 750));
		panelPredmeti.add(eastPanel, BorderLayout.EAST);
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(750, 50));
		panelPredmeti.add(southPanel, BorderLayout.SOUTH);
		
		btnDodajPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajPredmetProfesoru ddpp = new DialogDodajPredmetProfesoru(profesor,predmetiProfesora);
				ddpp.setVisible(true);
			}
			
		});
		
		btnUkloniPredmet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(predmetiProfesora.getSelectedRow() > -1) {
					
					String[] options = new String[2];
					options[0] = new String ("Da");
					options[1] = new String ("Ne");
					int code = JOptionPane.showOptionDialog(MainFrame.getInstance().getContentPane(), "Da li ste sigurni da želite da uklonite predmet?", "Brisanje predmeta", 0, JOptionPane.QUESTION_MESSAGE, null, options, null);
					
					if (code == JOptionPane.YES_OPTION) {
						
						//int selectedRows[] = predmetiProfesora.getSelectedRows();
						int i= predmetiProfesora.getSelectedRow();

						//for(int i=selectedRows.length-1; i!=-1; i--) {
							Predmet pr=PredmetiController.getInstance().getPredmetByID(profesor.getPredmetiKojePred().get(i));
							if(pr.getPredmetID().equals(profesor.getProfesorID()))
								pr.setProfesor("");
							//KatedraController.getInstance().proveraBrisanjaProfesora(pr.getPredmetID(),profesor);
							ProfesoriController.getInstance().obrisiPredmetProfesoru(i, profesor);
							azurirajPrikaz(predmetiProfesora);
						//}
						
						
					}
				}else
					 JOptionPane.showMessageDialog(null, "Morate selektovati neki predmet", "Greška pri uklanjanju predmeta", JOptionPane.ERROR_MESSAGE);
					return;
			}
			
		});
	}
	private boolean proveraUnosaPolja(String txt,String regex,int i) {
		if(txt.matches(regex)) {
			ispravno[i] = true;
			return true;
		}
		
		ispravno[i] = false;
		return false;
	}
	
	private boolean enablePotvrdi() {
		
		for(boolean i : ispravno) {
			if(i == false)
				return false;
		}
		
		return true;
	}
	private void adressStan(String adresa) {
		String delovi[] = adresa.split(",");	
		int i = 0;
		for(char c : delovi[0].toCharArray())
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
				i = delovi[0].indexOf(c);
		
		ulicaStan = (delovi[0].substring(0, i-1)).trim();
		brojStan = (delovi[0].substring(i)).trim();
		grad = (delovi[1]).trim();
		drzava = (delovi[2]).trim();
	}
	
	private void adressKanc(String adresa) {
		String delovi[] = adresa.split(",");
		
	
		int i=0;
		for(char c:delovi[0].toCharArray())
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
				i=delovi[0].indexOf(c);
		
		ulicaKanc = (delovi[0].substring(0, i-1)).trim();
		brojKanc = (delovi[0].substring(i)).trim();
		gradKanc = delovi[1].trim();
	}
	
	public void azurirajPrikaz(JTablePredmetiPoProfesoru predmetiProfesora) {
		AbstractTableModelPredmetiPoProfesoru predmetiModel = (AbstractTableModelPredmetiPoProfesoru) predmetiProfesora.getModel();
		predmetiModel.fireTableDataChanged();
		validate();
	}
}
