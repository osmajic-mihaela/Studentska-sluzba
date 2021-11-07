package Model;

import java.util.ArrayList;
import java.util.HashSet;

enum SEMESTAR{ZIMSKI,LETNJI};

public class Predmet {
	
	private String predmetID;
	private String nazivPredmeta;
	private SEMESTAR semestar;
	private int godStudija;
	private String profesor;
	private int brESPB;
	private ArrayList<String> spisakPolozenih;  //ID ocene 
	private ArrayList<String> spisakNepolozenih;  //ID predmeta
	
	public Predmet(String predmetID, String nazivPredmeta, SEMESTAR semestar, int godStudija, String profesor,
			int eSPB) {
		super();
		this.predmetID = predmetID;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.profesor = profesor;
		
		if(godStudija>0 && godStudija<5)
			this.godStudija = godStudija;
		else
			System.out.println("Nemoguce");
		

		
		if(eSPB>0)
			this.brESPB = eSPB;
		else
			System.out.println("Nemoguce");
		
		this.spisakPolozenih = new ArrayList<String>();
		this.spisakNepolozenih = new ArrayList<String>();
	}

	public String getPredmetID() {
		return predmetID;
	}

	public void setPredmetID(String predmetID) {
		this.predmetID = predmetID;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public SEMESTAR getSemestar() {
		return semestar;
	}

	public void setSemestar(SEMESTAR semestar) {
		this.semestar = semestar;
	}

	public int getGodStudija() {
		return godStudija;
	}

	public void setGodStudija(int godStudija) {
		if(godStudija>0 && godStudija<5)
			this.godStudija = godStudija;
		else
			System.out.println("Nemoguce");
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

	public void setSpisakPolozenih(ArrayList<String> spisakPolozenih) {
		this.spisakPolozenih = spisakPolozenih;
	}

	public void setSpisakNepolozenih(ArrayList<String> spisakNepolozenih) {
		this.spisakNepolozenih = spisakNepolozenih;
	}
	
	
	
	
	
}
