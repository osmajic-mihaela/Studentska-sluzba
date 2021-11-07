package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Profesor extends Osoba {
	
	
	
	private String ProfesorID;
	private String adresaKancelar;
	private String brLicne;
	private String zvanje;
	private int godRadnogStaza;
	private ArrayList<String>predmetiKojePred;
	
	public Profesor(String ime,String prezime, String datumRodj,String kontaktBroj,String email,
			String profesorID, String adresaKancelar, String brLicne,String zvanje, int godStaza,
			String ulica, int broj, String grad, String drzava ) {
		this.ime=ime;
		this.prezime=prezime;
		this.datumRodj=datumRodj;
		this.kontaktBroj=kontaktBroj;
		this.email=email;
		this.brLicne=brLicne;
		this.adresaStan= new Adresa(ulica,broj,grad,drzava);
		this.adresaKancelar=adresaKancelar;
		this.zvanje=zvanje;
		this.godRadnogStaza=godStaza;
		this.predmetiKojePred=new ArrayList<String>();
		this.ProfesorID=""+Math.abs(brLicne.hashCode());
	}
	
	
	public String getProfesorID() {
		return ProfesorID;
	}

	public String getAdresaKancelar() {
		return adresaKancelar;
	}
	public void setAdresaKancelar(String adresaKancelar) {
		this.adresaKancelar = adresaKancelar;
	}
	public String getBrLicne() {
		return brLicne;
	}
	public void setBrLicne(String brLicne) {
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
	public void setProfesorID(String profesorID) {
		ProfesorID = profesorID;
	}
	public void setPredmetiKojePred(ArrayList<String> predmetiKojePred) {
		this.predmetiKojePred = predmetiKojePred;
	}
	
		
}
