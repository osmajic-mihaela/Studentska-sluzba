package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.KatedraController;
import controller.ProfesoriController;
import controller.Serijalizacija;
import controller.StudentiController;


public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta() {
		
		initPredmeti();
		
		kolone = new ArrayList<String>();
		kolone.add("�ifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Godina");
		kolone.add("Semestar");
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("e421", "OISISI", Semestar.ZIMSKI, "pera peric", 6, GodinaStudiranja.TRECA));
		predmeti.add(new Predmet("e432", "nans", Semestar.ZIMSKI, "pera peric", 4, GodinaStudiranja.TRECA));
		predmeti.add(new Predmet("e455", "Baze podataka", Semestar.ZIMSKI, "pera peric", 8, GodinaStudiranja.TRECA));
		
		try {
			this.predmeti = Serijalizacija.getInstance().deserijalizacijaPredmeta();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Predmet> getPredmeti(){
		return predmeti;
	}
	
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch(column) {
			case 0:
				String[] katedra = { "ma", "fz", "eo", "ps","it","p" };
		        List<String> listaKatedri= KatedraController.getInstance().getSifreSvihKatedri();
				return katedra[listaKatedri.indexOf(predmet.getPredmetID().substring(0, 3))]+predmet.getPredmetID().substring(3);
			case 1:
				return predmet.getNazivPredmeta();
			case 2:
				return predmet.getBrESPB()+"";
			case 3:
				return predmet.getGodStudija()+"";
			case 4:
				return predmet.getSemestar()+"";
			default:
				return null;
		}	
	}
	
	public void obrisiPredmet(int index) {
		this.predmeti.remove(index);
	}
	
	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}
	
	public void izmeniPredmet(int i, Predmet p) {	
		Predmet predmet = predmeti.get(i);
		if(!predmet.getPredmetID().equalsIgnoreCase(p.getPredmetID())) {
			StudentiController.getInstance().izmeniPredmet(predmet.getPredmetID(),p.getPredmetID());
			BazaOcena.getInstance().izmeniPredmet(predmet.getPredmetID(),p.getPredmetID());
		}
		predmet.setPredmetID(p.getPredmetID());
		predmet.setNazivPredmeta(p.getNazivPredmeta());
		predmet.setSemestar(p.getSemestar());
		predmet.setBrESPB(p.getBrESPB());
		predmet.setGodStudija(p.getGodStudija());
		predmet.setProfesor(p.getProfesor());	
	}
	
	public int getIndexByID(String sifra) {
		int i=0;	
		
			for(Predmet pr : predmeti) {
				if(pr.getPredmetID()==sifra)
					break;
				++i;
			}
		
		return i;
	}
	
	public Predmet getPredmetByID(String id) {
		Predmet predmet = null;
		for(Predmet pr : predmeti) {
			if(pr.getPredmetID().equals(id)) {
				predmet = pr;
				break;
			}
		}
		return predmet;
	}
	
	public void obrisiOcenuPolozeni(String ocenaID, String predmetID) {
		Predmet predmet= getPredmetByID(predmetID);
		int i=predmet.getSpisakPolozenih().indexOf(ocenaID);
		predmet.getSpisakPolozenih().remove(i);
	}
	
	
	public void obrisiStudentaSaNepolozenih(String studentIndeks) {
		for(Predmet pr : predmeti) {
			if(pr.getSpisakNepolozenih().contains(studentIndeks)) {
				int i= pr.getSpisakNepolozenih().indexOf(studentIndeks);
				pr.getSpisakNepolozenih().remove(i);
			}
		}
	}
	
	public void izmenaStudenta(String staraSifra,String novaSifra) {
		for(Predmet pr : predmeti) {
			for(String sifra : pr.getSpisakNepolozenih()) {
				if(sifra.equalsIgnoreCase(staraSifra)) {
					int i= pr.getSpisakNepolozenih().indexOf(sifra);
					pr.getSpisakNepolozenih().add(i,novaSifra);
				}
			}
			
			for(String sifra : pr.getSpisakPolozenih()) {
				if(sifra.contains(staraSifra)) {
					String prDeo=sifra.replace(staraSifra, "").trim();
					int i= pr.getSpisakPolozenih().indexOf(sifra);
					pr.getSpisakPolozenih().add(i,prDeo+novaSifra);
				}
			}
		}
		
	}
}
