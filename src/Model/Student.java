package Model;

import java.util.ArrayList;
import java.util.HashSet;

enum STATUS{B,S};

public class Student extends Osoba {
	
	
	private String brIndeksa;
	private int godUpisa;
	private int trenutnaGodStud;
	private double prosecnaOcena;
	private STATUS status;
	private ArrayList<String> polozeniPred; //kljuc je sifra ocene
	private ArrayList<String> nepolozeniPred; //PredmetID 
	

	public Student(String ime,String prezime, String datumRodj,String kontaktBroj,String email,
			int godUpisa, int trenutnaGodStud, STATUS status, 
			String ulica, int broj, String grad, String drzava,
			String brIndeksa) {
		
		this.ime=ime;
		this.prezime=prezime;
		this.datumRodj=datumRodj;
		this.kontaktBroj=kontaktBroj;
		this.email=email;
		this.brIndeksa=brIndeksa;
		this.godUpisa=godUpisa;
		this.trenutnaGodStud=1;
		this.prosecnaOcena=0;
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


	public int getTrenutnaGodStud() {
		return trenutnaGodStud;
	}
     
	public void setTrenutnaGodStudija(int god) {
		this.trenutnaGodStud=god;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}


	public STATUS getStatus() {
		return status;
	}


	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	
	public ArrayList<String> getPolozeniPred() {
		return polozeniPred;
	}


	public ArrayList<String> getNepolozeniPred() {
		return nepolozeniPred;
	}


	public void setTrenutnaGodStud(int trenutnaGodStud) {
		this.trenutnaGodStud = trenutnaGodStud;
	}


	public void setPolozeniPred(ArrayList<String> polozeniPred) {
		this.polozeniPred = polozeniPred;
	}


	public void setNepolozeniPred(ArrayList<String> nepolozeniPred) {
		this.nepolozeniPred = nepolozeniPred;
	}

    

}
