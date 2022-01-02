package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {

	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora() {
		
		initProfesori();
		
		kolone = new ArrayList<String>(); 
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Zvanje");
		kolone.add("E-mail adresa");
	}
	
	private void initProfesori() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("mika", "mikic", LocalDate.parse("01-01-1990", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "+38160123", "mikamikic@gmail.com",
				 12345, "doktor nauka", 10, "ulica", "broj", "grad", "drzava", "ulica kanca", "broj kanca"));
		profesori.add(new Profesor("mika", "mikic", LocalDate.parse("01-01-1990", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "+38160123", "mikamikic@gmail.com",
				 12345, "doktor nauka", 10, "ulica", "broj", "grad", "drzava", "ulica kanca", "broj kanca"));
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch(column) {
			case 0:
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return profesor.getZvanje();
			case 3:
				return profesor.getEmail();
			default:
				return null;
		}
	}
	
	public void dodajProfesora(Profesor profesor) {
		this.profesori.add(profesor);
	}
	
	public void izmeniProfesora(int index, Profesor novi) {
		Profesor stari = profesori.get(index);
		stari.setIme(novi.getIme());
		stari.setPrezime(novi.getPrezime());
		stari.setKontaktBroj(novi.getKontaktBroj());
		stari.setEmail(novi.getEmail());
		stari.setAdresaStan(novi.getAdresaStan().getUlica(),novi.getAdresaStan().getBroj(), novi.getAdresaStan().getGrad(), novi.getAdresaStan().getDrzava());
		stari.setDatumRodj(novi.getDatumRodj());
		stari.setPredmetiKojePred(novi.getPredmetiKojePred());
		stari.setAdresaKancelar(novi.getAdresaKancelar());
		stari.setBrLicne(novi.getBrLicne());
		stari.setZvanje(novi.getZvanje());
		stari.setGodRadnogStaza(novi.getGodRadnogStaza());
	}
	
	public void obrisiProfesora(int index) {
		this.profesori.remove(index);
	}
	
	public List<Predmet> getListaNePredmeta(Profesor profesor){
	
		
		if(profesor.getPredmetiKojePred().isEmpty()) {
			return BazaPredmeta.getInstance().getPredmeti();
		}
			
		List<Predmet> predmetiKojeNePredaje= new ArrayList<Predmet>();
		
			 
			 for(Predmet prIzSvih : BazaPredmeta.getInstance().getPredmeti()) {
				 if(!profesor.getPredmetiKojePred().contains(prIzSvih.getPredmetID())) {
					 predmetiKojeNePredaje.add(prIzSvih);
				 }
			 }
			 
		
		 return predmetiKojeNePredaje;
	}
}
