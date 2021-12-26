package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.StudentiController;
import model.GodinaStudiranja;
import model.Status;
import model.Student;

public class DialogDodajStudenta extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3241071042742691924L;
	
	private Boolean[] ispravnaPolja = {false, false, false, false, false, false, false};
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
	
	public DialogDodajStudenta() {
		
		setTitle("Dodavanje studenta");
		setSize(500,500);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel panNorth=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panNorth, BoxLayout.Y_AXIS);
		panNorth.setLayout(boxCenter);
	    
		Dimension dim=new Dimension(150,20);

        JPanel panIme=new JPanel();
        JLabel lblIme=new JLabel("Ime*");
        lblIme.setPreferredSize(dim);
        JTextField txtIme=new JTextField();
        txtIme.setPreferredSize(dim);
        panIme.add(Box.createHorizontalStrut(10));
        panIme.add(lblIme);
        panIme.add(txtIme);
        panIme.add(Box.createHorizontalStrut(10));
        
		JPanel panPrezime=new JPanel();
        JLabel lblPrezime=new JLabel("Prezime*");
        lblPrezime.setPreferredSize(dim);
        JTextField txtPrezime=new JTextField();
        txtPrezime.setPreferredSize(dim);
        panPrezime.add(Box.createHorizontalStrut(10));
        panPrezime.add(lblPrezime);
        panPrezime.add(txtPrezime);
        panPrezime.add(Box.createHorizontalStrut(10));
        
        
        JPanel panDatum=new JPanel();
        JLabel lblDatum=new JLabel("Datum rodjenja*");
        lblDatum.setPreferredSize(dim);
        JTextField txtDatum=new JTextField();
        txtDatum.setPreferredSize(dim);
        panDatum.add(Box.createHorizontalStrut(10));
        panDatum.add(lblDatum);
        panDatum.add(txtDatum);
        panDatum.add(Box.createHorizontalStrut(10));
        
       
      
        
        JPanel panAdresa = new JPanel();
        JLabel lblAdresa = new JLabel("Adresa stanovanja*");
        JTextField txtAdresa = new JTextField();
        lblAdresa.setPreferredSize(dim);
        txtAdresa.setPreferredSize(dim);
        panAdresa.add(Box.createHorizontalStrut(10));
        panAdresa.add(lblAdresa);
        panAdresa.add(txtAdresa);
        panAdresa.add(Box.createHorizontalStrut(10));
        
        JPanel panTelefon= new JPanel();
        JLabel lblTelefon= new JLabel("Broj telefona*");
        JTextField txtTelefon = new JTextField();
        lblTelefon.setPreferredSize(dim);
        txtTelefon.setPreferredSize(dim);
        panTelefon.add(Box.createHorizontalStrut(10));
        panTelefon.add(lblTelefon);
        panTelefon.add(txtTelefon);
        panTelefon.add(Box.createHorizontalStrut(10));

        JPanel panEmail= new JPanel();
        JLabel lblEmail= new JLabel("E-mail adresa*");
        JTextField txtEmail= new JTextField();
        lblEmail.setPreferredSize(dim);
        txtEmail.setPreferredSize(dim);
        panEmail.add(Box.createHorizontalStrut(10));
        panEmail.add(lblEmail);
        panEmail.add(txtEmail);
        panEmail.add(Box.createHorizontalStrut(10));
        
        JPanel panIndeks= new JPanel();
        JLabel lblIndeks= new JLabel("Broj indeksa*");
        JTextField txtIndeks= new JTextField();
        lblIndeks.setPreferredSize(dim);
        txtIndeks.setPreferredSize(dim);
        panIndeks.add(Box.createHorizontalStrut(10));
        panIndeks.add(lblIndeks);
        panIndeks.add(txtIndeks);
        panIndeks.add(Box.createHorizontalStrut(10));
        
        JPanel panGodUpisa= new JPanel();
        JLabel lblGodUpisa= new JLabel("Godina upisa*");
        JTextField txtGodUpisa= new JTextField();
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
        
        
        panNorth.add(Box.createVerticalStrut(50));
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
        add(panNorth,BorderLayout.NORTH);
       
      
		
		JPanel panCenter=new JPanel();
		BoxLayout box=new BoxLayout(panCenter, BoxLayout.X_AXIS);
		panCenter.setLayout(box);
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100,25));
		
		JButton btnOdustani=new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100,25));
		
		panCenter.add(Box.createHorizontalStrut(130));
		panCenter.add(btnPotvrdi);
		panCenter.add(Box.createGlue());
		panCenter.add(btnOdustani);
		panCenter.add(Box.createHorizontalStrut(130));
		
		add(panCenter,BorderLayout.CENTER);
		
		JPanel panBottom=new JPanel();
		panBottom.setPreferredSize(new Dimension(150,15));
		add(panBottom,BorderLayout.SOUTH);
	
		//pack();
		btnPotvrdi.setEnabled(false);
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});

		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
					if (s.getBrIndeksa().equals(indeks)) {
						JOptionPane.showMessageDialog(null, "Student sa datim indeksom već postoji u sistemu", "Greška pri unosu novog studenta", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				adress(adresa);
				String delovi[]=datumRodjenja.split("-");
				
				if(delovi[0].length()==1) {
					delovi[0]="0"+delovi[0];
					datumRodjenja=delovi[0]+"-"+delovi[1]+"-"+delovi[2];}
				if(delovi[1].length()==1) {
					delovi[1]="0"+delovi[1];
					datumRodjenja=delovi[0]+"-"+delovi[1]+"-"+delovi[2];
				}
				
				LocalDate datumRodj =LocalDate.parse(datumRodjenja,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				int upis=Integer.parseInt(godUpisa);
				Student student = new Student(ime, prezime, datumRodj,brTelefona,email,upis,godStudiranja, status,ulica,broj,grad,drzava,indeks,0.00);
				StudentiController.getInstance().dodajStudenta(student);
				
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
				String regex_brIndeksa = "[A-Za-z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
				if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
					txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				if( !proveraUnosaPolja(indeks, regex_brIndeksa, 4) ) {
					txtGodUpisa.setText("");
					godUpisa="";	
				}else {
					godUpisa=indeks.substring(indeks.indexOf("-")+1);}
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				indeks = txtIndeks.getText();
				String regex_brIndeksa = "[A-Za-z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
				if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
					txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				if(indeks.indexOf("-")!=-1)
					godUpisa=indeks.substring(indeks.indexOf("-")+1);
				txtGodUpisa.setText(godUpisa);
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				indeks = txtIndeks.getText();
				String regex_brIndeksa = "[A-Za-z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
				if(!proveraUnosaPolja(indeks, regex_brIndeksa, 4))
					txtIndeks.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtIndeks.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				btnPotvrdi.setEnabled(enablePotvrdi());	
				if(indeks.indexOf("-")!=-1)
					godUpisa=indeks.substring(indeks.indexOf("-")+1);
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
		int i=0;
		for(char c:delovi[0].toCharArray())
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
				i=delovi[0].indexOf(c);
		
		ulica=delovi[0].substring(0, i-1);
		broj=delovi[0].substring(i);
		grad=delovi[1];
		drzava=delovi[2];
	}
}
