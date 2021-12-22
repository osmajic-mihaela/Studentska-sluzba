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
				"profa id", "nebitna adresa kanca", 12345, "doktor nauka", 10, "ulica", "broj", "grad", "drzava", "ulica kanca", "broj kanca"));
		profesori.add(new Profesor("mika", "mikic", LocalDate.parse("01-01-1990", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "+38160123", "mikamikic@gmail.com",
				"profa id", "nebitna adresa kanca", 12345, "doktor nauka", 10, "ulica", "broj", "grad", "drzava", "ulica kanca", "broj kanca"));
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
	}
