package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra implements Serializable{
	
	@Override
	public String toString() {
		return "Katedra [katedraID=" + katedraID + ", nazivKatedre=" + nazivKatedre + ", sefKatedreID=" + sefKatedreID
				+ ", profesoriNaKatedri=" + profesoriNaKatedri + ", predmetiNaKatedri=" + predmetiNaKatedri + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 6899883632570306892L;
	private String katedraID; //sifra katedre
	private String nazivKatedre;
	private String sefKatedreID;
	private ArrayList<String> profesoriNaKatedri; //ProfesorID
	private ArrayList<String> predmetiNaKatedri;
	
	
	public Katedra(String katedraID, String nazivKatedre, String sefKatedreID) {
		super();
		this.katedraID = katedraID;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedreID = sefKatedreID;
		this.profesoriNaKatedri = new ArrayList<String>();
		this.predmetiNaKatedri= new ArrayList<>();
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


	public ArrayList<String> getPredmetiNaKatedri() {
		return predmetiNaKatedri;
	}


	public void setPredmetiNaKatedri(ArrayList<String> predmetiNaKatedri) {
		this.predmetiNaKatedri = predmetiNaKatedri;
	}
    
	
   
	
	
}
