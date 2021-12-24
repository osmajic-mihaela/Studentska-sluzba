package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class BazaStudenata {
	private static BazaStudenata instance=null;
	
	public static BazaStudenata getInstance() {
		if(instance==null) {
			instance=new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
		
		initStudenti();
		
		kolone=new ArrayList<String>();
		kolone.add("Indeks");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Godina studija");
		kolone.add("Status");
		kolone.add("Prosek");
		
	}
	
	private void initStudenti() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Mihaela","Osmajic", LocalDate.parse("12-12-2019", DateTimeFormatter.ofPattern("dd-MM-yyyy")) ,"+38164","N@gmail.com",
				2019, GodinaStudiranja.TRECA , Status.B, 
				"Radoja Dakica", "53a", "Novi Sad","Srbija",
				"RA116-2019", 9.10));
		
		studenti.add(new Student("Petar","Obradovic",LocalDate.parse("12-12-2019", DateTimeFormatter.ofPattern("dd-MM-yyyy")),"+38164","N@gmail.com",
				2019, GodinaStudiranja.TRECA , Status.B, 
				"Radoja Dakica", "53a", "Novi Sad","Srbija",
				"RA51-2019", 9.10));
	}
	
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student= this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return	student.getTrenutnaGodStud().getBr()+"";
		case 4:
			if(student.getStatus()==Status.B)
				return "Budžet";
			return "Samofinansiranje";
		case 5:
			return student.getProsecnaOcena()+"";
		default:
			return null;
		}
	}
	
	public Boolean dodajStudenda(Student s) {
		return this.studenti.add(s);
		
	}
}
