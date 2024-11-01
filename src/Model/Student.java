package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public class Student extends Osoba implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7245652909927581551L;
	/**
	 * 
	 */
	
	private String brIndeksa;
	private int godUpisa;
	private GodinaStudiranja trenutnaGodStud;
	private double prosecnaOcena;
	private Status status;
	private ArrayList<String> polozeniPred; //ocenaID
	private ArrayList<String> nepolozeniPred; //PredmetID 
	private int ukupnoESPB;
	

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
		this.ukupnoESPB=0;
		
	}
	
	public Student(String ime,String prezime, LocalDate datumRodj,String kontaktBroj,String email,
			int godUpisa, GodinaStudiranja trenutnaGodStud, Status status,Adresa adresa,
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
		this.adresaStan=adresa;
	    this.nepolozeniPred= new ArrayList<String>();
		this.polozeniPred= new ArrayList<String>();
		this.ukupnoESPB=0;
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


	public int getUkupnoESPB() {
		return ukupnoESPB;
	}


	public void setUkupnoESPB(int ukupnoESPB) {
		this.ukupnoESPB = ukupnoESPB;
	}


	private void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	public void azurirajOcenaESPB() {
		int bodovi = 0;
		double prosek = 0;
		int counter = 0;
		for(String s : polozeniPred) {
			Ocena o = BazaOcena.getInstance().getOcenaByID(s);
			if(o.getVrednostOcene() == VrednostOcene.SEST) {
				prosek += 6;
			}
			else if(o.getVrednostOcene() == VrednostOcene.SEDAM) {
				prosek += 7;
			}
			else if(o.getVrednostOcene() == VrednostOcene.OSAM) {
				prosek += 8;
			}
			else if(o.getVrednostOcene() == VrednostOcene.DEVET) {
				prosek += 9;
			}
			else if(o.getVrednostOcene() == VrednostOcene.DESET) {
				prosek += 10;	
			}
			
			counter += 1;
			String id = o.getPredmetID();
			Predmet p = BazaPredmeta.getInstance().getPredmetByID(id);
			bodovi += p.getBrESPB();
			
		}
		if(counter == 0) {
			prosek = 0;
		}
		prosek = prosek/counter;
		prosek = Math.round(prosek * 100.0) / 100.0;
		this.setProsecnaOcena(prosek);
		this.setUkupnoESPB(bodovi);
	}
	
	public void obrisiNepolozeni(int id) {
		
		nepolozeniPred.remove(id);
	}
	
	public void obrisiPolozeni(String id) {
		int index = -1;
		for(String s : polozeniPred) {
			if(id == s) {
				index = polozeniPred.indexOf(s);
			}
		}
		polozeniPred.remove(index);
	}

	@Override
	public String toString() {
		return "Student [brIndeksa=" + brIndeksa + ", godUpisa=" + godUpisa + ", trenutnaGodStud=" + trenutnaGodStud
				+ ", prosecnaOcena=" + prosecnaOcena + ", status=" + status + ", polozeniPred=" + polozeniPred
				+ ", nepolozeniPred=" + nepolozeniPred + ", ukupnoESPB=" + ukupnoESPB + ", ime=" + ime + ", prezime="
				+ prezime + ", datumRodj=" + datumRodj + ", kontaktBroj=" + kontaktBroj + ", email=" + email
				+ ", adresaStan=" + adresaStan + "]";
	}
}
