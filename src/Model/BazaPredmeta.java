package model;

import java.util.ArrayList;
import java.util.List;

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
		kolone.add("Broj ESPB bodova");
		kolone.add("Godina na kojoj se predmet izvodi");
		kolone.add("Semestar u kome se predmet izvodi");
	}
	
	private void initPredmeti() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("12345", "OISISI", Semestar.ZIMSKI, "pera peric", 6, GodinaStudiranja.TRECA));
		predmeti.add(new Predmet("12345", "OISISI", Semestar.ZIMSKI, "pera peric", 6, GodinaStudiranja.TRECA));
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
				return predmet.getPredmetID();
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
		predmet.setPredmetID(p.getPredmetID());
		predmet.setNazivPredmeta(p.getNazivPredmeta());
		predmet.setSemestar(p.getSemestar());
		predmet.setBrESPB(p.getBrESPB());
		predmet.setGodStudija(p.getGodStudija());
		predmet.setProfesor(p.getProfesor());	
	}
	
}
