package model;

import java.util.List;
import java.util.ArrayList;

public class BazaOcena {
	
	private static BazaOcena instance = null;
	
	public static BazaOcena getInstance() {
		if(instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private List<Ocena> ocene;
	private List<String> kolone;
	
	private BazaOcena() {
		
		initOcene();
		
		kolone = new ArrayList<String>();
		kolone.add("Sifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Ocena");
		kolone.add("Datum");
	}
	
	private void initOcene() {
		this.ocene = new ArrayList<Ocena>();
	}
	
	public List<Ocena> getPredmeti(){
		return ocene;
	}
	
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.ocene.get(row);
		switch(column) {
			case 0:
				return ocena.getPredmetID();
			case 1:
				return BazaPredmeta.getInstance().getPredmetByID(ocena.getPredmetID()).getNazivPredmeta();
			case 2:
				return BazaPredmeta.getInstance().getPredmetByID(ocena.getPredmetID()).getBrESPB()+"";
			case 3:
				return ocena.getVrednostOcene()+"";
			case 4:
				return ocena.getDatumPolaganja()+"";
			default:
				return null;
		}	
	}
	
	public void dodajOcenu(Ocena o) {
		ocene.add(o);
	}
	public Ocena getOcenaByID(String id) {
		Ocena ocena = null;
		for(Ocena o : ocene) {
			if(o.getOcenaID().equals(id)) {
				ocena = o;
			}
		}
		return ocena;
	}
	
	public int getIndexByID(String id) {
		int index = 0;
		for(Ocena o : ocene) {
			if(o.getOcenaID().equals(id)) {
				break;
			}
			index++;
		}
		return index;
	}
	
	public void obrisiOcenu(String id) {
		ocene.remove(getIndexByID(id));
	}
}
