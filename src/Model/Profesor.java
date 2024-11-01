package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Osoba implements Serializable{
	
	
	
	@Override
	public String toString() {
		return "Profesor [profesorID=" + profesorID + ", adresaKancelar=" + adresaKancelar + ", brLicne=" + brLicne
				+ ", zvanje=" + zvanje + ", godRadnogStaza=" + godRadnogStaza + ", predmetiKojePred=" + predmetiKojePred
				+ ", ime=" + ime + ", prezime=" + prezime + ", datumRodj=" + datumRodj + ", kontaktBroj=" + kontaktBroj
				+ ", email=" + email + ", adresaStan=" + adresaStan + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1769055405408562885L;
	private String profesorID;
	private Adresa adresaKancelar;
	private int brLicne;
	private String zvanje;
	private int godRadnogStaza;
	private ArrayList<String>predmetiKojePred;
	
	public Profesor(String ime,String prezime, LocalDate datumRodj,String kontaktBroj,String email,
			 int brLicne,String zvanje, int godStaza, String ulica, String broj, String grad,
			 String drzava,String gradKanc, String ulicaKanc,String brojKanc ) {
		this.ime=ime;
		this.prezime=prezime;
		this.datumRodj=datumRodj;
		this.kontaktBroj=kontaktBroj;
		this.email=email;
		this.brLicne=brLicne;
		this.adresaStan= new Adresa(ulica,broj,grad,drzava);
		this.adresaKancelar=new Adresa(ulicaKanc,brojKanc,gradKanc,drzava);
		this.zvanje=zvanje;
		this.godRadnogStaza=godStaza;
		this.predmetiKojePred=new ArrayList<String>();
		this.profesorID=""+Math.abs((""+brLicne).hashCode());
	}
	
	
	public String getProfesorID() {
		return profesorID;
	}
	

	public void setProfesorID(String profesorID) {
		this.profesorID = profesorID;
	}


	public void setPredmetiKojePred(ArrayList<String> predmetiKojePred) {
		this.predmetiKojePred = predmetiKojePred;
	}


	public Adresa getAdresaKancelar() {
		return adresaKancelar;
	}
	public void setAdresaKancelar(Adresa adresaKancelar) {
		this.adresaKancelar = adresaKancelar;
	}
	public int getBrLicne() {
		return brLicne;
	}
	public void setBrLicne(int brLicne) {
		this.brLicne = brLicne;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public int getGodRadnogStaza() {
		return godRadnogStaza;
	}
	public void setGodRadnogStaza(int godRadnogStaza) {
		this.godRadnogStaza = godRadnogStaza;
	}
	public ArrayList<String> getPredmetiKojePred() {
		return predmetiKojePred;
	}
	
}
