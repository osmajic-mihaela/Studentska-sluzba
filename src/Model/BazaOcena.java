package model;

import java.util.List;

import controller.KatedraController;
import controller.PredmetiController;
import controller.Serijalizacija;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
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
		try {
			this.ocene = Serijalizacija.getInstance().deserijalizacijaOcena();
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
	
	public String getValueAt(Student student,int row, int column) {
		List<Ocena> listaOcenaStudenta= new ArrayList<Ocena>();
		for(Ocena oc : getPredmeti() )
		{
			if(oc.getStudentIndeks().equalsIgnoreCase(student.getBrIndeksa())) {
				listaOcenaStudenta.add(oc);
			}
		}
		Ocena ocena = listaOcenaStudenta.get(row);
		switch(column) {
			case 0:
				String[] katedra = { "ma", "fz", "eo", "ps","it","p" };
		        List<String> listaKatedri= KatedraController.getInstance().getSifreSvihKatedri();
				return katedra[listaKatedri.indexOf(ocena.getPredmetID().substring(0, 3))]+ocena.getPredmetID().substring(3);
			case 1:
				return BazaPredmeta.getInstance().getPredmetByID(ocena.getPredmetID()).getNazivPredmeta();
			case 2:
				return BazaPredmeta.getInstance().getPredmetByID(ocena.getPredmetID()).getBrESPB()+"";
			case 3:
				return ocena.getVrednostOcene().getVrednost()+"";
			case 4:
				return (ocena.getDatumPolaganja()).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
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
	
	public void obrisiOceneStudenta(Student st) {
		int i= ocene.size();
		for(i= ocene.size()-1; i!=-1; i--) {
			if(ocene.get(i).getStudentIndeks().equals(st.getBrIndeksa())) {
				PredmetiController.getInstance().obrisiOcenuPolozeni(ocene.get(i).getOcenaID(), ocene.get(i).getPredmetID());
				ocene.remove(i);
			}
				
		}
	}
}
