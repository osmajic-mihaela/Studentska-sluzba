package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor extends Osoba {
	
	
	
	private String profesorID;
	private String adresaKancelar;
	private int brLicne;
	private String zvanje;
	private int godRadnogStaza;
	private ArrayList<String>predmetiKojePred;
	
	public Profesor(String ime,String prezime, LocalDate datumRodj,String kontaktBroj,String email,
			String profesorID, String adresaKancelar, int brLicne,String zvanje, int godStaza,
			String ulica, String broj, String grad, String drzava ) {
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


	public String getAdresaKancelar() {
		return adresaKancelar;
	}
	public void setAdresaKancelar(String adresaKancelar) {
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
