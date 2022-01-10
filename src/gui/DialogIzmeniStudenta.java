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
import javax.swing.JComboBox;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import controller.PredmetiController;
import controller.StudentiController;
import model.GodinaStudiranja;
import model.Status;
import model.Student;

public class DialogIzmeniStudenta extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7125950941987504204L;
	private Boolean[] ispravnaPolja = {true, true, true, true, true, true, true};
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresa;
	private String brTelefona;
	private String email;
	private String indeks;
	private String godUpisa;
	private String ulica;
	private String broj;
	private String grad;
	private String drzava;
	
	public DialogIzmeniStudenta(int selectedIndex) {
		
		Student student = StudentiController.getInstance().getListaSvihStudenata().get(selectedIndex);
		setTitle("Izmena studenta");
		setSize(600,600);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JTabbedPane  tabbedPane = new JTabbedPane();
		
		JPanel panelInformacije = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(panelInformacije, BoxLayout.Y_AXIS);
		panelInformacije.setLayout(dialogLayout);
		tabbedPane.addTab("Informacije", panelInformacije );
		
		JPanel panelPolozeni = new JPanel();
		BorderLayout polozeniLayout = new BorderLayout();
		panelPolozeni.setLayout(polozeniLayout);
		tabbedPane.addTab("Polozeni", panelPolozeni);

		JPanel panelNepolozeni = new JPanel();
		BorderLayout nepolozeniLayout = new BorderLayout();
		panelNepolozeni.setLayout(nepolozeniLayout);
		tabbedPane.addTab("Nepolozeni", panelNepolozeni);
		
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panNorth=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panNorth, BoxLayout.Y_AXIS);
		panNorth.setLayout(boxCenter);
		
		Dimension dim=new Dimension(150,20);
		
		JPanel panIme=new JPanel();
        JLabel lblIme=new JLabel("Ime*");
        lblIme.setPreferredSize(dim);
        JTextField txtIme=new JTextField(student.getIme());
        txtIme.setPreferredSize(dim);
        panIme.add(Box.createHorizontalStrut(10));
        panIme.add(lblIme);
        panIme.add(txtIme);
        panIme.add(Box.createHorizontalStrut(10));
		
        JPanel panPrezime=new JPanel();
        JLabel lblPrezime=new JLabel("Prezime*");
        lblPrezime.setPreferredSize(dim);
        JTextField txtPrezime=new JTextField(student.getPrezime());
        txtPrezime.setPreferredSize(dim);
        panPrezime.add(Box.createHorizontalStrut(10));
        panPrezime.add(lblPrezime);
        panPrezime.add(txtPrezime);
        panPrezime.add(Box.createHorizontalStrut(10));
        
        
        JPanel panDatum=new JPanel();
        JLabel lblDatum=new JLabel("Datum rodjenja*");
        lblDatum.setPreferredSize(dim);
        JTextField txtDatum=new JTextField((student.getDatumRodj()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        txtDatum.setPreferredSize(dim);
        panDatum.add(Box.createHorizontalStrut(10));
        panDatum.add(lblDatum);
        panDatum.add(txtDatum);
        panDatum.add(Box.createHorizontalStrut(10));
        

        JPanel panAdresa = new JPanel();
        JLabel lblAdresa = new JLabel("Adresa stanovanja*");
        JTextField txtAdresa = new JTextField(student.getAdresaStan().toString());
        lblAdresa.setPreferredSize(dim);
        txtAdresa.setPreferredSize(dim);
        panAdresa.add(Box.createHorizontalStrut(10));
        panAdresa.add(lblAdresa);
        panAdresa.add(txtAdresa);
        panAdresa.add(Box.createHorizontalStrut(10));
        
        JPanel panTelefon= new JPanel();
        JLabel lblTelefon= new JLabel("Broj telefona*");
        JTextField txtTelefon = new JTextField(student.getKontaktBroj());
        lblTelefon.setPreferredSize(dim);
        txtTelefon.setPreferredSize(dim);
        panTelefon.add(Box.createHorizontalStrut(10));
        panTelefon.add(lblTelefon);
        panTelefon.add(txtTelefon);
        panTelefon.add(Box.createHorizontalStrut(10));

        JPanel panEmail= new JPanel();
        JLabel lblEmail= new JLabel("E-mail adresa*");
        JTextField txtEmail= new JTextField(student.getEmail());
        lblEmail.setPreferredSize(dim);
        txtEmail.setPreferredSize(dim);
        panEmail.add(Box.createHorizontalStrut(10));
        panEmail.add(lblEmail);
        panEmail.add(txtEmail);
        panEmail.add(Box.createHorizontalStrut(10));
        
        JPanel panIndeks= new JPanel();
        JLabel lblIndeks= new JLabel("Broj indeksa*");
        JTextField txtIndeks= new JTextField(student.getBrIndeksa());
        lblIndeks.setPreferredSize(dim);
        txtIndeks.setPreferredSize(dim);
        panIndeks.add(Box.createHorizontalStrut(10));
        panIndeks.add(lblIndeks);
        panIndeks.add(txtIndeks);
        panIndeks.add(Box.createHorizontalStrut(10));
        
        JPanel panGodUpisa= new JPanel();
        JLabel lblGodUpisa= new JLabel("Godina upisa*");
        JTextField txtGodUpisa= new JTextField(student.getGodUpisa()+"");
        txtGodUpisa.setEditable(false);
        lblGodUpisa.setPreferredSize(dim);
        txtGodUpisa.setPreferredSize(dim);
        panGodUpisa.add(Box.createHorizontalStrut(10));
        panGodUpisa.add(lblGodUpisa);
        panGodUpisa.add(txtGodUpisa);
        panGodUpisa.add(Box.createHorizontalStrut(10));
		
        JPanel panTrenutnaGod= new JPanel();
        JLabel lblTrenutnaGod= new JLabel("Trenutna godina studija*");
        String[] godineStudija = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
        JComboBox<String> comboTrenutnaGod=new JComboBox<>(godineStudija);
        lblTrenutnaGod.setPreferredSize(dim);
        comboTrenutnaGod.setPreferredSize(dim);
        panTrenutnaGod.add(Box.createHorizontalStrut(10));
        panTrenutnaGod.add(lblTrenutnaGod);
        panTrenutnaGod.add(comboTrenutnaGod);
        panTrenutnaGod.add(Box.createHorizontalStrut(10));
        
        JPanel panNacinFin= new JPanel();
        JLabel lblNacinFin= new JLabel("Način polaganja*");
        String[] bs = { "Budžet", "Samofinansiranje" };
        JComboBox<String> comboNacinFin=new JComboBox<>(bs);
        lblNacinFin.setPreferredSize(dim);
        comboNacinFin.setPreferredSize(dim);
        panNacinFin.add(Box.createHorizontalStrut(10));
        panNacinFin.add(lblNacinFin);
        panNacinFin.add(comboNacinFin);
        panNacinFin.add(Box.createHorizontalStrut(10));
        
        txtIme.setToolTipText("Primer: Imenko");
        txtPrezime.setToolTipText("Primer: Prezimenić");
        txtAdresa.setToolTipText("Primer: JNA 3a,Novi Sad,Srbija");
        txtDatum.setToolTipText("Primer: 22-8-2000");
        txtEmail.setToolTipText("Primer: username@gmail.com");
        txtIndeks.setToolTipText("Primer: RA116-2019");
        txtTelefon.setToolTipText("Primer: +381641111111");
        
        panNorth.add(Box.createVerticalStrut(15));
        panNorth.add(panIme);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panPrezime);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panDatum);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panAdresa);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panTelefon);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panEmail);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panIndeks);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panGodUpisa);
        panNorth.add(Box.createVerticalStrut(5));
        panNorth.add(panTrenutnaGod);
        panNorth.add(panNacinFin);
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
		panCenter.add(Box.createHorizontalStrut(130));
		
		panelInformacije.add(panCenter,BorderLayout.CENTER);
		
		JPanel panBottom=new JPanel();
		panBottom.setPreferredSize(new Dimension(150,15));
		panelInformacije.add(panBottom,BorderLayout.SOUTH);
	
		//pack();
		btnPotvrdi.setEnabled(true);
		
		ime = student.getIme();
		prezime = student.getPrezime();
		datumRodjenja =(student.getDatumRodj()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		brTelefona = student.getKontaktBroj();
		adresa = student.getAdresaStan().toString();
		indeks = student.getBrIndeksa();
		email = student.getEmail();
		godUpisa = student.getGodUpisa()+"";
		ulica=student.getAdresaStan().getUlica();
		broj=student.getAdresaStan().getBroj();
		grad=student.getAdresaStan().getGrad();
		drzava=student.getAdresaStan().getDrzava();
		
		
		
		comboNacinFin.setSelectedIndex(student.getStatus().ordinal());
		comboTrenutnaGod.setSelectedIndex(student.getTrenutnaGodStud().ordinal());
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String godinaStudija =comboTrenutnaGod.getSelectedItem().toString();
				Status status;
				GodinaStudiranja godStudiranja;
				
				
				if(godinaStudija=="I (prva)")
					godStudiranja=GodinaStudiranja.PRVA;
				else if(godinaStudija=="II (druga)")
					godStudiranja=GodinaStudiranja.DRUGA;
				else if(godinaStudija=="III (treća)")
					godStudiranja=GodinaStudiranja.TRECA;
				else
					godStudiranja=GodinaStudiranja.CETVRTA;
				
				if(comboNacinFin.getSelectedItem().toString()=="Budžet")
					status = Status.B;
				else
					status= Status.S;
				
				for (Student s : StudentiController.getInstance().getListaSvihStudenata()) {
					if ((s!=StudentiController.getInstance().getListaSvihStudenata().get(selectedIndex)) &&(s.getBrIndeksa().equals(indeks))) {
						JOptionPane.showMessageDialog(null, "Student sa datim indeksom već postoji u sistemu", "Greška pri izmeni studenta", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			
				String delovi[]=datumRodjenja.split("-");
				
				if(delovi[0].length()==1) {
					delovi[0]="0"+delovi[0];
					datumRodjenja=delovi[0]+"-"+delovi[1]+"-"+delovi[2];}
				if(delovi[1].length()==1) {
					delovi[1]="0"+delovi[1];
					datumRodjenja=delovi[0]+"-"+delovi[1]+"-"+delovi[2];
				}
				
				adress(txtAdresa.getText());
				LocalDate datumRodj =LocalDate.parse(datumRodjenja,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				int upis=Integer.parseInt(godUpisa);
				Student student = new Student(ime, prezime, datumRodj,brTelefona,email,upis,godStudiranja, status,ulica,broj,grad,drzava,indeks,0.00);
				StudentiController.getInstance().izmeniStudenta(selectedIndex, student);
				
				dispose();
				
			}
		});

			txtIme.getDocument().addDocumentListener(new DocumentListener() {
	
				@Override
				public void removeUpdate(DocumentEvent e) {
					ime = txtIme.getText();
					String regex_ime = "[[\\p{L}]\s]+";
			
					if(!proveraUnosaPolja(ime, regex_ime, 0))
						txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
			
					btnPotvrdi.setEnabled(enablePotvrdi());					
				}
	
				@Override
				public void insertUpdate(DocumentEvent e) {
					ime = txtIme.getText();
					String regex_ime = "[[\\p{L}]\s]+";
					if(!proveraUnosaPolja(ime, regex_ime, 0))
						txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					ime = txtIme.getText();
					String regex_ime = "[[\\p{L}]\s]+";
					if(!proveraUnosaPolja(ime, regex_ime, 0))
						txtIme.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIme.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
		
				}
			});

			txtPrezime.getDocument().addDocumentListener(new DocumentListener() {
	
				@Override
				public void removeUpdate(DocumentEvent e) {
					prezime = txtPrezime.getText();
					String regex_prezime = "[\\p{L}\s]+";
					if(!proveraUnosaPolja(prezime, regex_prezime, 1))
						txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
	
				@Override
				public void insertUpdate(DocumentEvent e) {
					prezime =txtPrezime.getText();
					String regex_prezime = "[\\p{L}\s]+";
					if(!proveraUnosaPolja(prezime, regex_prezime, 1))
						txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					prezime = txtPrezime.getText();
					String regex_prezime = "[\\p{L}\s]+";
					if(!proveraUnosaPolja(prezime, regex_prezime, 1))
						txtPrezime.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtPrezime.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
			});

			txtDatum.getDocument().addDocumentListener(new DocumentListener() {
	
				@Override
				public void removeUpdate(DocumentEvent e) {
					datumRodjenja = txtDatum.getText();
					String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
					if(!proveraUnosaPolja(datumRodjenja, regex_datumRodjenja, 2))
						txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
		
				@Override
				public void insertUpdate(DocumentEvent e) {
					datumRodjenja = txtDatum.getText();
					String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
					if(!proveraUnosaPolja(datumRodjenja, regex_datumRodjenja, 2))
						txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
			
				}
		
				@Override
				public void changedUpdate(DocumentEvent e) {
					datumRodjenja = txtDatum.getText();
					String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
					if(!proveraUnosaPolja(datumRodjenja, regex_datumRodjenja, 2))
						txtDatum.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
				txtDatum.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());
			
				}
			});

			txtAdresa.getDocument().addDocumentListener(new DocumentListener() {
	
				@Override
				public void removeUpdate(DocumentEvent e) {
					adresa = txtAdresa.getText();
					String regex_adresa ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
					if(!proveraUnosaPolja(adresa, regex_adresa, 3))
						txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else {
						txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
	
				@Override
				public void insertUpdate(DocumentEvent e) {
					adresa = txtAdresa.getText();
					String regex_adresa ="\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
					if(!proveraUnosaPolja(adresa, regex_adresa, 3))
						txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else {
						txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
					btnPotvrdi.setEnabled(enablePotvrdi());
		
				}
	
				@Override
				public void changedUpdate(DocumentEvent e) {
					adresa = txtAdresa.getText();
					String regex_adresa = "\s*[\\p{L}]+\s*[[\\p{L}]*\\s*]*\\d+\\w?\s*\\,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*,\s*[\\p{L}]+\s*[[\\p{L}]*\s*]*";
					if(!proveraUnosaPolja(adresa, regex_adresa, 3))
						txtAdresa.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else {
						txtAdresa.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					}
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
			});

			txtIndeks.getDocument().addDocumentListener(new DocumentListener() {
	
				@Override
				public void removeUpdate(DocumentEvent e) {
		
					indeks = txtIndeks.getText();
					String regex_brIndeksa = "[A-Za-z]{1,3}-[0-9]{1,3}-[2][0-9]{3}";
					if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
						txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		
					if( !proveraUnosaPolja(indeks, regex_brIndeksa, 4) ) {
						txtGodUpisa.setText("");
						godUpisa="";	
					}else {
						godUpisa=indeks.substring(indeks.lastIndexOf("-")+1);}
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
	
				@Override
				public void insertUpdate(DocumentEvent e) {
		
					indeks = txtIndeks.getText();
					String regex_brIndeksa = "[A-Za-z]{1,3}-[0-9]{1,3}-[2][0-9]{3}";
					if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
						txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
		
						if(indeks.indexOf("-")!=-1)
					godUpisa=indeks.substring(indeks.lastIndexOf("-")+1);
					txtGodUpisa.setText(godUpisa);
					btnPotvrdi.setEnabled(enablePotvrdi());	
		}
		
				@Override
				public void changedUpdate(DocumentEvent e) {
					indeks = txtIndeks.getText();
					String regex_brIndeksa = "[A-Za-z]{1,3}-[0-9]{1,3}-[2][0-9]{3}";
					if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
						txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
					if(indeks.indexOf("-")!=-1)
						godUpisa=indeks.substring(indeks.lastIndexOf("-")+1);
					txtGodUpisa.setText(godUpisa);
					btnPotvrdi.setEnabled(enablePotvrdi());
				}
			});
			
			txtTelefon.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					brTelefona = txtTelefon.getText();
					String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
					if(!proveraUnosaPolja(brTelefona, regex_brojTelefona, 5))
						txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					brTelefona = txtTelefon.getText();
					String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
					if(!proveraUnosaPolja(brTelefona, regex_brojTelefona, 5))
						txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					brTelefona  = txtTelefon.getText();
					String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
					if(!proveraUnosaPolja(brTelefona, regex_brojTelefona, 5))
						txtTelefon.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtTelefon.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
			});
			
			txtEmail.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					email = txtEmail.getText();
					String regex_email = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
					boolean pr=!proveraUnosaPolja(email, regex_email, 6);
					if(pr)
						txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					email = txtEmail.getText();
					String regex_email = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
					boolean pr=!proveraUnosaPolja(email, regex_email, 6);
					if(pr)
						txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					
					email = txtEmail.getText();
					String regex_email = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
					boolean pr=!proveraUnosaPolja(email, regex_email, 6);
					if(pr)
						txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtEmail.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					
					btnPotvrdi.setEnabled(enablePotvrdi());	
				}
			});
					
			
		JPanel btnNepolozeniPanel = new JPanel();
		BoxLayout btnNepolozeniLayout = new BoxLayout(btnNepolozeniPanel, BoxLayout.X_AXIS);
		btnNepolozeniPanel.setLayout(btnNepolozeniLayout);
		btnNepolozeniPanel.setPreferredSize(new Dimension(750, 70));
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(new Dimension(70, 30));
		btnNepolozeniPanel.add(Box.createHorizontalStrut(50));
		btnNepolozeniPanel.add(btnDodaj);
		
		JButton btnObrisi = new JButton("Obri�i");
		btnObrisi.setPreferredSize(new Dimension(70, 30));
		btnNepolozeniPanel.add(Box.createHorizontalStrut(25));
		btnNepolozeniPanel.add(btnObrisi);
		
		JButton btnPolaganje = new JButton("Polaganje");
		btnPolaganje.setPreferredSize(new Dimension(100, 30));
		btnNepolozeniPanel.add(Box.createHorizontalStrut(25));
		btnNepolozeniPanel.add(btnPolaganje);
		
		btnNepolozeniPanel.add(Box.createHorizontalGlue());
		panelNepolozeni.add(btnNepolozeniPanel, BorderLayout.NORTH);
		
		JPanel leviPanel = new JPanel();
		leviPanel.setPreferredSize(new Dimension(50, 750));
		panelNepolozeni.add(leviPanel, BorderLayout.WEST);
		
		JPanel desniPanel = new JPanel();
		desniPanel.setPreferredSize(new Dimension(50, 750));
		panelNepolozeni.add(desniPanel, BorderLayout.EAST);
		
		JPanel donjiPanel = new JPanel();
		donjiPanel.setPreferredSize(new Dimension(750, 50));
		panelNepolozeni.add(donjiPanel, BorderLayout.SOUTH);
		
		JTableNepolozeniPredmeti nepolozeniPredmeti = new JTableNepolozeniPredmeti(student);
		JScrollPane nepolozeniScrollPane = new JScrollPane(nepolozeniPredmeti);
		nepolozeniScrollPane.setPreferredSize(new Dimension(300, 300));
		panelNepolozeni.add(nepolozeniScrollPane, BorderLayout.CENTER);
		
		btnDodaj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajPredmetStudentu ddps = new DialogDodajPredmetStudentu(student, nepolozeniPredmeti);
				ddps.setVisible(true);
			}
		});
		
		btnObrisi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nepolozeniPredmeti.getSelectedRow() > -1) {
					
					String[] options = new String[2];
					options[0] = new String ("Da");
					options[1] = new String ("Ne");
					int code = JOptionPane.showOptionDialog(MainFrame.getInstance().getContentPane(), "Da li ste sigurni da želite da uklonite predmet?", "Uklanjanje predmeta", 0, JOptionPane.QUESTION_MESSAGE, null, options, null);
					
					if (code == JOptionPane.YES_OPTION) {
						
						int selectedRows[] = nepolozeniPredmeti.getSelectedRows();

						for(int i=selectedRows.length-1; i!=-1; i--) {
							
							student.getNepolozeniPred().remove(i);
							String idPredmetaZaBrisanje=(String)nepolozeniPredmeti.getValueAt(i, 0) ;
							PredmetiController.getInstance().getPredmetByID(idPredmetaZaBrisanje).getSpisakNepolozenih().remove(student.getBrIndeksa());
							azurirajPrikazNepolozenih(nepolozeniPredmeti);
						}
						
						
					}
				}else
					 JOptionPane.showMessageDialog(null, "Morate selektovati neki predmet", "Greška pri uklanjanju predmeta", JOptionPane.ERROR_MESSAGE);
					return;
			}
		});
		
		btnPolaganje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nepolozeniPredmeti.getSelectedRow() > -1) {
					DialogUpisOcene duo = new DialogUpisOcene(nepolozeniPredmeti, student);
					duo.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Morate selektovati neki predmet", "Gre�ka pri upisivanju ocene", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		
		//////////////////////////////////////////////////////////////////
		JPanel btnPolozeniPanel = new JPanel();
		btnPolozeniPanel.setLayout(new BoxLayout(btnPolozeniPanel, BoxLayout.X_AXIS));
		
		JButton btnPonistiOcenu = new JButton("Ponisti ocenu");
		btnPonistiOcenu.setPreferredSize(new Dimension(150, 30));
		
		btnPolozeniPanel.add(Box.createHorizontalStrut(25));
		btnPolozeniPanel.add(btnPonistiOcenu);
		btnPolozeniPanel.add(Box.createHorizontalGlue());
		btnPolozeniPanel.setPreferredSize(new Dimension(750, 50));
		panelPolozeni.add(btnPolozeniPanel, BorderLayout.NORTH);
		
		
		JTablePolozeniIspiti polozeniPredmeti = new JTablePolozeniIspiti(student);
		JScrollPane polozeniScrollPane = new JScrollPane(polozeniPredmeti);
		polozeniScrollPane.setPreferredSize(new Dimension(300, 300));
		panelPolozeni.add(polozeniScrollPane, BorderLayout.CENTER);
		
		JPanel levi = new JPanel();
		levi.setPreferredSize(new Dimension(25, 750));
		panelPolozeni.add(levi, BorderLayout.WEST);
		
		JPanel desni = new JPanel();
		desni.setPreferredSize(new Dimension(25, 750));
		panelPolozeni.add(desni, BorderLayout.EAST);
		
		JPanel donji = new JPanel();
		donji.setLayout(new BoxLayout(donji, BoxLayout.Y_AXIS));
		panelPolozeni.add(donji, BorderLayout.SOUTH);
		
		JPanel panelOcene1 = new JPanel();
		panelOcene1.setLayout(new BoxLayout(panelOcene1, BoxLayout.X_AXIS));
		
		JPanel panelBodovi1 = new JPanel();
		panelBodovi1.setLayout(new BoxLayout(panelBodovi1, BoxLayout.X_AXIS));
		
		JLabel srednjaOcena = new JLabel("Prosecna ocena:  " + student.getProsecnaOcena());
		panelOcene1.add(Box.createHorizontalGlue());
		panelOcene1.add(srednjaOcena);
		panelOcene1.add(Box.createHorizontalStrut(30));
		
		JLabel ukupniBodovi = new JLabel("Ukupno ESPB:  " + student.getUkupnoESPB());
		panelBodovi1.add(Box.createHorizontalGlue());
		panelBodovi1.add(ukupniBodovi);
		panelBodovi1.add(Box.createHorizontalStrut(30));
		
		donji.add(Box.createVerticalStrut(10));
		donji.add(panelOcene1);
		donji.add(Box.createVerticalStrut(10));
		donji.add(panelBodovi1);
		donji.add(Box.createVerticalStrut(10));
		
		polozeniPredmeti.getModel().addTableModelListener(new TableModelListener() {	
		
		@Override
		public void tableChanged(TableModelEvent arg0) {
		
			srednjaOcena.setText("Prosecna ocena:  " + student.getProsecnaOcena());
			ukupniBodovi.setText("Ukupno ESPB:  " + student.getUkupnoESPB());
		
			StudentiController.getInstance().updatePrikaz();
		
		
			}
		
		});

		
		
		}
		
	private boolean proveraUnosaPolja(String txt,String regex,int i) {
		if(txt.matches(regex)) {
			ispravnaPolja[i]=true;
			return true;
		}
		
		ispravnaPolja[i]=false;
		return false;
	}
	
	private boolean enablePotvrdi() {
		
		for(boolean ispravno : ispravnaPolja ) {
			if(ispravno==false)
				return false;
		}
		
		return true;
	}
	
	private void adress(String adresa) {
		String delovi[]=adresa.split(",");
		//System.out.println(delovi[0]);
		//System.out.println(delovi[1]);
		//System.out.println(delovi[2]);
	
		int i=0;
		for(char c:delovi[0].toCharArray())
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
				i=delovi[0].indexOf(c);
		
		ulica=(delovi[0].substring(0, i-1)).trim();
		broj=(delovi[0].substring(i)).trim();
		grad=(delovi[1]).trim();
		drzava=(delovi[2]).trim();
	}
	
	public void azurirajPrikazNepolozenih(JTableNepolozeniPredmeti nepolozeniPredmeti) {
		AbstractTableModelNepolozeniPredmeti nepolozeniModel= (AbstractTableModelNepolozeniPredmeti) nepolozeniPredmeti.getModel();
		nepolozeniModel.fireTableDataChanged();
		validate();
	}
}
