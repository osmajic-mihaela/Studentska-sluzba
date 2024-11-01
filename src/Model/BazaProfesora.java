package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.Serijalizacija;

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
		/*profesori.add(new Profesor("Milos", "Nikolic", LocalDate.parse("12.12.1965.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/356-785", "milos.nikolic@mailinator.com",
				 123123123, "REDOVNI_PROFESOR", 1, "�afarikova", "2", "Novi Sad", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Nikola", "Mirkovic", LocalDate.parse("01.01.1978.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/368-456", "nikola.mirkovic@mailinator.com",
				 321321321, "REDOVNI_PROFESOR", 2, "Nikole Tesle", "56", "Novi Sad", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Ilija", "Petkovic", LocalDate.parse("03.09.1988.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/215-314", "ilija.petkovic@mailinator.com",
				 456456456, "VANREDNI_PROFESOR", 3, "Bulevar Patrijarha Pavla", "3", "Beograd","Novi Sad", "Srbija", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Mitar", "Petrovic", LocalDate.parse("25.07.1976.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/884-640", "mitar.petrovic@mailinator.com",
				 789789789, "VANREDNI_PROFESOR", 4, "Stra�ilovska", "6a", "Novi Sad","Novi Sad", "Srbija", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Vasa", "Micic", LocalDate.parse("14.02.1970.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/212-114", "vasa.micic@mailinator.com",
				 100100144, "DOCENT", 5 , "Nikole Pa�i�a", "2d", "Kikinda", "Srbija", "Novi Sad","Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Srdjan", "Miletic", LocalDate.parse("20.04.1966.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/978-225", "srdjan.miletic@mailinator.com",
				 200020244, "DOCENT", 6, "Bulevar Kralja Petra", "22", "Ni�", "Srbija", "Novi Sad","Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Branislav", "Mihajlovic", LocalDate.parse("28.06.1980.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/778-323", "branislav.mihajlovic@mailinator.com",
				 559585632, "REDOVNI_PROFESOR", 7, "Tolstojeva", "31", "Novi Sad", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Marko", "Markovi�", LocalDate.parse("31.01.1985.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/899-659", "marko.markovic@mailinator.com",
				 334968855, "REDOVNI_PROFESOR", 8, "Mariceva", "11", "Kragujevac", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Milos", "Milakovi�", LocalDate.parse("21.09.1975.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/122-326", "milos.milakovic@mailinator.com",
				 730703654, "VANREDNI_PROFESOR", 9, "Stra�ilovska", "3", "Beograd", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Lazar", "Bratić", LocalDate.parse("13.11.1973.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/156-326", "lazar.bratic@mailinator.com",
                600378644, "VANREDNI_PROFESOR", 3, "Nikole Pa�i�a", "6a", "Novi Sad", "Srbija","Novi Sad", "Nikole Pa�i�a", "6a"));

		profesori.add(new Profesor("Ljeposava", "Dražić", LocalDate.parse("11.08.1964.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021/888-156", "ljeposava.drazic@mailinator.com",
                158496152, "DOCENT", 31, "Bulevar kralja Petra", "2d", "Ni�", "Srbija","Novi Sad", "Nikole Pašića", "6a"));
		profesori.add(new Profesor("Miroljub", "Dragić", LocalDate.parse("02.03.1959.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021456125", "miroljub.dragic@mailinator.com",
				777348595, "DOCENT", 42, "Knez Mihajlova", "22", "Ni�", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Bogdan", "Rekavi�", LocalDate.parse("23.06.1977.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021886455", "stanka.milic@mailinator.com",
				721254363, "VANREDNI_PROFESOR", 18, "Bulevar Kralja Petra", "2d", "Ni�", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Stanka", "Mili�", LocalDate.parse("03.03.1991.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021945155", "stanka.milic@mailinator.com",
				225533448, "DOCENT", 7, "Bulevar Partrijaha Pavla", "3", "Beograd", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Milica", "Vukovi�", LocalDate.parse("18.10.1967.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021746659", "milica.vukovic@mailinator.com",
				111555888, "VANREDNI_PROFESOR", 14, "Mari�eva", "11", "Kragujevac", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Miša", "Mi�i�", LocalDate.parse("20.10.1969.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021489326", "misa.misic@mailinator.com",
				300300344, "DOCENT", 19, "Šafarikova", "10", "Novi Sad", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Branko", "Marici�", LocalDate.parse("18.01.1973.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021487265", "branko.maricic@mailinator.com",
				400400444, "DOCENT", 22, "Nikole Tesle", "56", "Novi Sad", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Branislav", "Lukovic", LocalDate.parse("08.04.1982.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021159478", "branislav.lukovic@mailinator.com",
				500500544, "REDOVNI_PROFESOR", 9, "Bulevar Patrijaha Pavla", "3", "Beograd", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));
		profesori.add(new Profesor("Branimir", "Obradovi�", LocalDate.parse("17.01.1979.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")), "021922333", "branimir.obradovic@mailinator.com",
				600600644, "DOCENT", 17, "�afarikova", "10", "Novi Sad", "Srbija", "Novi Sad", "Nikole Pa�i�a", "6a"));*/
		
		try {
			this.profesori = Serijalizacija.getInstance().deserijalizacijaProfesora();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void obrisiPredmetProfesoru(int indexPredmeta,Profesor profesor) {
		profesor.getPredmetiKojePred().remove(indexPredmeta);
	}
	
	public Profesor getProfesorByID(String id) {
		Profesor ret = null;
		for(Profesor p : profesori) {
			if(p.getProfesorID() == id) {
				ret = p;
			}
		}
		return ret;
	}
	
	public ArrayList<Profesor> getProfesoriPredmeta(String id){
		
		ArrayList<Profesor> predavaci = new ArrayList<Profesor>();
		for(Profesor p : profesori) {
			if(p.getPredmetiKojePred().contains(id)) {
				predavaci.add(p);
			}
		}
		return predavaci;	
	}
}
