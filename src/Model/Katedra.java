package Model;

import java.util.ArrayList;

public class Katedra {
	
	private String katedraID; //sifra katedre
	private String nazivKatedre;
	private String sefKatedreID;
	private ArrayList<String> profesoriNaKatedri; //ProfesorID
	
	
	public Katedra(String katedraID, String nazivKatedre, String sefKatedreID) {
		super();
		this.katedraID = katedraID;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedreID = sefKatedreID;
		this.profesoriNaKatedri = new ArrayList<String>();
	}


	public String getKatedraID() {
		return katedraID;
	}


	public void setKatedraID(String katedraID) {
		this.katedraID = katedraID;
	}


	public String getNazivKatedre() {
		return nazivKatedre;
	}


	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}


	public String getSefKatedreID() {
		return sefKatedreID;
	}


	public void setSefKatedreID(String sefKatedreID) {
		this.sefKatedreID = sefKatedreID;
	}


	public ArrayList<String> getProfesoriNaKatedri() {
		return profesoriNaKatedri;
	}


	public void setProfesoriNaKatedri(ArrayList<String> profesoriNaKatedri) {
		this.profesoriNaKatedri = profesoriNaKatedri;
	}



    
	
   
	
	
}
