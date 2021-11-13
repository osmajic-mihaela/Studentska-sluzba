package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Student extends Osoba {
	
	
	private String brIndeksa;
	private int godUpisa;
	private GodinaStudiranja trenutnaGodStud;
	private double prosecnaOcena;
	private Status status;
	private ArrayList<String> polozeniPred; //ocenaID
	private ArrayList<String> nepolozeniPred; //PredmetID 
	

	public Student(String ime,String prezime, LocalDate datumRodj,String kontaktBroj,String email,
			int godUpisa, GodinaStudiranja trenutnaGodStud, Status status, 
			String ulica, String broj, String grad, String drzava,
			String brIndeksa, double prosecnaOcena) {
		
		this.ime=ime;
		this.prezime=prezime;
		this.datumRodj=datumRodj;
		this.kontaktBroj=kontaktBroj;
		this.email=email;
		this.brIndeksa=brIndeksa;
		this.godUpisa=godUpisa;
		this.trenutnaGodStud=trenutnaGodStud;
		this.prosecnaOcena=prosecnaOcena;
		this.status=status;
		this.adresaStan=new Adresa(ulica,broj,grad,drzava);
	    this.nepolozeniPred= new ArrayList<String>();
		this.polozeniPred= new ArrayList<String>();
		
	}


	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}


	public int getGodUpisa() {
		return godUpisa;
	}


	public void setGodUpisa(int godUpisa) {
		this.godUpisa = godUpisa;
	}


	public GodinaStudiranja getTrenutnaGodStud() {
		return trenutnaGodStud;
	}
     
	public void setTrenutnaGodStud(GodinaStudiranja trenutnaGodStud) {
		this.trenutnaGodStud = trenutnaGodStud;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public ArrayList<String> getPolozeniPred() {
		return polozeniPred;
	}
	public ArrayList<String> getNepolozeniPred() {
		return nepolozeniPred;
	}


	public void setPolozeniPred(ArrayList<String> polozeniPred) {
		this.polozeniPred = polozeniPred;
	}


	public void setNepolozeniPred(ArrayList<String> nepolozeniPred) {
		this.nepolozeniPred = nepolozeniPred;
	}
	


}
