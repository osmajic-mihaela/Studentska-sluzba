package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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

import controller.PredmetiController;
import model.GodinaStudiranja;
import model.Predmet;
import model.Semestar;

public class DialogIzmeniPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -435154876618529101L;
	private Boolean[] ispravnaPolja = {true, true, true};
	private String sifra;
	private String naziv;
	private String espb;
	private Semestar semestar;
	private String prof;
	
	public DialogIzmeniPredmet(int selectedIndex){
		
		Predmet predmet = PredmetiController.getInstance().getListaSvihPredmeta().get(selectedIndex);
		setTitle("Izmena predmeta");
		setSize(500,400);
		setModal(true);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel panNorth=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panNorth, BoxLayout.Y_AXIS);
		panNorth.setLayout(boxCenter);
	    
		Dimension dim=new Dimension(150,20);
		Dimension dim1=new Dimension(250,20);

        JPanel panSifra=new JPanel();
        JLabel lblSifra=new JLabel("Sifra*");
        lblSifra.setPreferredSize(dim);
        JTextField txtSifra=new JTextField(predmet.getPredmetID());
        txtSifra.setPreferredSize(dim1);
        panSifra.add(Box.createHorizontalStrut(10));
        panSifra.add(lblSifra);
        panSifra.add(txtSifra);
        panSifra.add(Box.createHorizontalStrut(10));
        
		JPanel panNaziv=new JPanel();
        JLabel lblNaziv=new JLabel("Naziv*");
        lblNaziv.setPreferredSize(dim);
        JTextField txtNaziv=new JTextField(predmet.getNazivPredmeta());
        txtNaziv.setPreferredSize(dim1);
        panNaziv.add(Box.createHorizontalStrut(10));
        panNaziv.add(lblNaziv);
        panNaziv.add(txtNaziv);
        panNaziv.add(Box.createHorizontalStrut(10));
		
        JPanel panESPB=new JPanel();
        JLabel lblESPB=new JLabel("ESPB*");
        lblESPB.setPreferredSize(dim);
        JTextField txtESPB=new JTextField(predmet.getBrESPB()+"");
        txtESPB.setPreferredSize(dim1);
        panESPB.add(Box.createHorizontalStrut(10));
        panESPB.add(lblESPB);
        panESPB.add(txtESPB);
        panESPB.add(Box.createHorizontalStrut(10));
        
        JPanel panTrenutnaGod= new JPanel();
        JLabel lblTrenutnaGod= new JLabel("Trenutna godina studija*");
        String[] godineStudija = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
        JComboBox<String> comboTrenutnaGod=new JComboBox<>(godineStudija);
        lblTrenutnaGod.setPreferredSize(dim);
        comboTrenutnaGod.setPreferredSize(dim1);
        panTrenutnaGod.add(Box.createHorizontalStrut(10));
        panTrenutnaGod.add(lblTrenutnaGod);
        panTrenutnaGod.add(comboTrenutnaGod);
        panTrenutnaGod.add(Box.createHorizontalStrut(10));
        
        JPanel panSemestar= new JPanel();
        JLabel lblSemestar= new JLabel("Semestar:");
        JComboBox<Semestar> comboSemestar=new JComboBox<>();
        comboSemestar.setModel(new DefaultComboBoxModel<>(Semestar.values()));
        lblSemestar.setPreferredSize(dim);
        comboSemestar.setPreferredSize(dim1);
        panSemestar.add(Box.createHorizontalStrut(10));
        panSemestar.add(lblSemestar);
        panSemestar.add(comboSemestar);
        panSemestar.add(Box.createHorizontalStrut(10));
        
        JPanel panProf=new JPanel();
        JLabel lblProf=new JLabel("Profesor*");
        lblProf.setPreferredSize(dim);
        JTextField txtProf=new JTextField();
        txtProf.setPreferredSize(new Dimension(165,25));
        JButton batMin=new JButton("-");
        JButton batPlus=new JButton("+");
        panProf.add(Box.createHorizontalStrut(10));
        panProf.add(lblProf);
        panProf.add(txtProf);
        panProf.add(batPlus);
        panProf.add(batMin);
        panProf.add(Box.createHorizontalStrut(10));
        
        panNorth.add(Box.createVerticalStrut(25));
        panNorth.add(panSifra);
        panNorth.add(Box.createVerticalStrut(10));
        panNorth.add(panNaziv);
        panNorth.add(Box.createVerticalStrut(10));
        panNorth.add(panESPB);
        panNorth.add(Box.createVerticalStrut(10));
        panNorth.add(panTrenutnaGod);
        panNorth.add(Box.createVerticalStrut(10));
        panNorth.add(panSemestar);
        panNorth.add(Box.createVerticalStrut(10));
        panNorth.add(panProf);
        //panNorth.add(Box.createVerticalStrut(10));  
        add(panNorth,BorderLayout.NORTH);
        
        
        JPanel panCenter=new JPanel();
		BoxLayout box=new BoxLayout(panCenter, BoxLayout.X_AXIS);
		panCenter.setLayout(box);
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100,25));
		
		JButton btnOdustani=new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100,25));
		
		panCenter.add(Box.createHorizontalStrut(100));
		panCenter.add(btnPotvrdi);
		panCenter.add(Box.createGlue());
		panCenter.add(btnOdustani);
		panCenter.add(Box.createHorizontalStrut(100));
		
		add(panCenter,BorderLayout.CENTER);
		
		JPanel panBottom=new JPanel();
		panBottom.setPreferredSize(new Dimension(25,15));
		add(panBottom,BorderLayout.SOUTH);
        
		btnPotvrdi.setEnabled(true);
		
		sifra=predmet.getPredmetID();
		naziv=predmet.getNazivPredmeta();
		espb=predmet.getBrESPB()+"";
		comboTrenutnaGod.setSelectedIndex(predmet.getGodStudija().ordinal());
		comboSemestar.setSelectedIndex(predmet.getSemestar().ordinal());
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String godinaStudija =comboTrenutnaGod.getSelectedItem().toString();
				GodinaStudiranja godStudiranja;
				
				
				if(godinaStudija=="I (prva)")
					godStudiranja=GodinaStudiranja.PRVA;
				else if(godinaStudija=="II (druga)")
					godStudiranja=GodinaStudiranja.DRUGA;
				else if(godinaStudija=="III (treća)")
					godStudiranja=GodinaStudiranja.TRECA;
				else
					godStudiranja=GodinaStudiranja.CETVRTA;
				
				if(comboSemestar.getSelectedItem().toString()=="ZIMSKI")
					semestar= Semestar.ZIMSKI;
				else
					semestar= Semestar.LETNJI;
				
				for (Predmet p: PredmetiController.getInstance().getListaSvihPredmeta()) {
					if (p.getPredmetID().equals(sifra) && (p!=PredmetiController.getInstance().getListaSvihPredmeta().get(selectedIndex))) {
						JOptionPane.showMessageDialog(null, "Predmet sa datom sifrom već postoji u sistemu", "Greška pri izmeni predmeta", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			
				int espbInt=Integer.parseInt(espb);
				Predmet predmet= new Predmet(sifra,naziv,semestar,"Nema prof",espbInt ,godStudiranja);
				PredmetiController.getInstance().izmeniPredmet(selectedIndex,predmet);
				
				dispose();
				
				
			}
		});
		
		txtSifra.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				sifra = txtSifra.getText();
				String regex_sifra = "\s*[\\p{L}]+[0-9]*\s*";
				if(!proveraUnosaPolja(sifra, regex_sifra, 0))
					txtSifra.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtSifra.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				sifra = txtSifra.getText();
				String regex_sifra = "\s*[\\p{L}]+[0-9]*\s*";
				if(!proveraUnosaPolja(sifra, regex_sifra, 0))
					txtSifra.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtSifra.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				sifra = txtSifra.getText();
				String regex_sifra = "\s*[\\p{L}]+[0-9]*\s*";
				if(!proveraUnosaPolja(sifra, regex_sifra, 0))
					txtSifra.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtSifra.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());	
				
			}
		});
		
	txtNaziv.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
					naziv = txtNaziv.getText();
					String regex_naziv = "\s*[\\p{L}]+\s*[\\p{L}]*\s*[1-9]?\s*";
					
					if(!proveraUnosaPolja(naziv, regex_naziv, 1))
						txtNaziv.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
					else
						txtNaziv.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
					
					btnPotvrdi.setEnabled(enablePotvrdi());					
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				naziv = txtNaziv.getText();
				String regex_naziv = "\s*[\\p{L}]+\s*[\\p{L}]*\s*[1-9]?\s*";
				
				if(!proveraUnosaPolja(naziv, regex_naziv, 1))
					txtNaziv.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtNaziv.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());	
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				naziv = txtNaziv.getText();
				String regex_naziv = "\s*[\\p{L}]+\s*[\\p{L}]*\s*[1-9]?\s*";
				
				if(!proveraUnosaPolja(naziv, regex_naziv, 1))
					txtNaziv.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtNaziv.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());	
				
			}
		});
	
	txtESPB.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
				espb= txtESPB.getText();
				String regex_espb= "\s*[1-9][0-9]?\s*";
				
				if(!proveraUnosaPolja(espb, regex_espb, 2))
					txtESPB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				else
					txtESPB.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
				
				btnPotvrdi.setEnabled(enablePotvrdi());					
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			espb= txtESPB.getText();
			String regex_espb= "\s*[1-9][0-9]?\s*";
			
			if(!proveraUnosaPolja(espb, regex_espb, 2))
				txtESPB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			else
				txtESPB.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
			
			btnPotvrdi.setEnabled(enablePotvrdi());	
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			espb= txtESPB.getText();
			String regex_espb= "\s*[1-9][0-9]?\s*";
			
			if(!proveraUnosaPolja(espb, regex_espb, 2))
				txtESPB.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			else
				txtESPB.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
			
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
	
}