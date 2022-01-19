package model;

import java.util.ArrayList;


public class Predmet {
	
	private String predmetID;   //sifra predmeta
	private String nazivPredmeta;
	private Semestar semestar;
	private GodinaStudiranja godStudija;
	private String profesor;
	private int brESPB;
	private ArrayList<String> spisakPolozenih;  //ID ocene 
	private ArrayList<String> spisakNepolozenih;  //ID studenta
	
	public Predmet(String predmetID, String nazivPredmeta, Semestar semestar, String profesor,
			int eSPB, GodinaStudiranja godinaStudija) {
		super();
		this.predmetID = predmetID;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.profesor = profesor;
		this.godStudija=godinaStudija;
		
		if(eSPB>0)
			this.brESPB = eSPB;
		else
			System.out.println("Nemoguce"); //izmena greske
		
		this.spisakPolozenih = new ArrayList<String>();
		this.spisakNepolozenih = new ArrayList<String>();
	}

	public String getPredmetID() {
		return predmetID;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public GodinaStudiranja getGodStudija() {
		return godStudija;
	}

	public void setGodStudija(GodinaStudiranja godStudija) {
		this.godStudija = godStudija;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public int getBrESPB() {
		return brESPB;
	}

	public void setBrESPB(int brESPB) {
		this.brESPB = brESPB;
	}

	public ArrayList<String> getSpisakPolozenih() {
		return spisakPolozenih;
	}

	public ArrayList<String> getSpisakNepolozenih() {
		return spisakNepolozenih;
	}

	public void setPredmetID(String predmetID) {
		this.predmetID = predmetID;
	}

	public void setSpisakPolozenih(ArrayList<String> spisakPolozenih) {
		this.spisakPolozenih = spisakPolozenih;
	}

	public void setSpisakNepolozenih(ArrayList<String> spisakNepolozenih) {
		this.spisakNepolozenih = spisakNepolozenih;
	}

	public void obrisiNepolozeniByID(String id) {
		int counter = 0;
		for(String s : spisakNepolozenih) {
			if(s == id) {
				spisakNepolozenih.remove(counter);
				break;
			}
			counter += 1;
		}
	}
	
	public void obrisiPolozeniByID(String id) {
		int counter = 0;
		for(String s : spisakPolozenih) {
			if(s == id) {
				spisakPolozenih.remove(counter);
				break;
			}
			counter += 1;
		}
	}


	
	
	
	
}
