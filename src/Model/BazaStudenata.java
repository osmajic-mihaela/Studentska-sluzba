package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.PredmetiController;
import controller.Serijalizacija;


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
		
		studenti.add(new Student("Marko","Milosevic", LocalDate.parse("12.03.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")) ,"021/333-555","marko.milosevic@mailinator.com",
				2020, GodinaStudiranja.PRVA , Status.B, 
				"Ĺ afarikova", "2", "Novi Sad","Srbija",
				"RA-2-2020", 0.00));
		
		studenti.add(new Student("Marija","MiliÄ‡",LocalDate.parse("12.01.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/555-2222","marija.milic@mailinator.com",
				2019, GodinaStudiranja.DRUGA , Status.S, 
				"Nikole Tesle", "56", "Novi Sad","Srbija",
				"RA-2-2019", 0.00));
		
		studenti.add(new Student("Nikola","Nikolic",LocalDate.parse("30.08.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/135-463","nikola.nikolic@mailinator.com",
				2019, GodinaStudiranja.PRVA , Status.B, 
				"Bulevar Patrijaha Pavla", "3", "Beograd","Srbija",
				"RA-3-2017", 0.00));
		
		studenti.add(new Student("Pera","Peric",LocalDate.parse("07.06.1995.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/903-463","pera.peric@mailinator.com",
				2015, GodinaStudiranja.TRECA , Status.S, null,
				"RA-137-2015", 0.00));
		
		studenti.add(new Student("Sofija","Ilic",LocalDate.parse("06.05.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/731-067","sofija.ilic@mailinator.com",
				2019, GodinaStudiranja.TRECA , Status.B, 
				"Nikole PaĹˇiÄ‡a", "2d", "Novi Sad","Srbija",
				"RA-5-2019", 0.00));
		
		studenti.add(new Student("Martina","Lukic",LocalDate.parse("16.05.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/4333-800","martina.lukic@mailinator.com",
				2018, GodinaStudiranja.TRECA , Status.S, 
				"Bulevar Kralja Petra", "22", "NiĹˇ","Srbija",
				"RA-8-2018", 0.00));
		
		studenti.add(new Student("Stojan","Stojakovic",LocalDate.parse("19.10.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/3130-007","stojan.stojakovic@mailinator.com",
				2017, GodinaStudiranja.PRVA , Status.B, 
				"Tolstojeva", "31", "Novi Sad","Srbija",
				"RA-10-2017", 0.00));
		
		studenti.add(new Student("Milan","Milanovic",LocalDate.parse("02.11.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"015/313-061","milan.milanovic@mailinator.com",
				2017, GodinaStudiranja.DRUGA , Status.S, 
				"MariÄ‡eva", "11", "Kragujevac","Srbija",
				"RA-12-2017", 0.00));
		
		studenti.add(new Student("Miroslav","Milic",LocalDate.parse("11.10.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/351-091","miroslav.milic@mailinator.com",
				2019, GodinaStudiranja.DRUGA , Status.B, 
				"StraĹľilovska", "3", "Beograd","Srbija",
				"RA-16-2019", 0.00));
		
		studenti.add(new Student("Stefan","GojiÄ‡",LocalDate.parse("01.05.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"015/324-500","stefan.gojic@mailinator.com",
				2015, GodinaStudiranja.TRECA , Status.S, 
				"Nikole PaĹˇiÄ‡a", "6a", "Novi Sad","Srbija",
				"RA-21-2015", 0.00));
		
		studenti.add(new Student("Anastasija","Jokic",LocalDate.parse("11.07.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/2333-900","anastasija.jokic@mailinator.com",
				2020, GodinaStudiranja.TRECA , Status.B, 
				"Bulevar Kralja Petra", "2d", "NiĹˇ","Srbija",
				"RA-9-2020", 0.00));
		

		studenti.add(new Student("MiloĹˇ","MiliÄ‡",LocalDate.parse("21.10.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/8172-372","milos.milic@mailinator.com",
		                2021, GodinaStudiranja.PRVA , Status.S, 
		                "Nikole Tesle", "56", "Novi Sad","Srbija",
		                "SW-12-2021", 0.00));
						
		studenti.add(new Student("Mikica","KovaceviÄ‡",LocalDate.parse("23.03.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/1992-371","mikica.kovacevic@mailinator.com",
		                2017, GodinaStudiranja.TRECA , Status.S, 
		                "Nikole PaĹˇiÄ‡a", "2d", "Kikinda","Srbija",
		                "RA-226-2017", 0.00));
		
		studenti.add(new Student("Purisa","Ä�orÄ‘eviÄ‡",LocalDate.parse("23.03.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/1543-370","purisa.djordjevic@mailinator.com",
		                2018, GodinaStudiranja.DRUGA , Status.B, 
		                "Bulevar Patrijaha Pavla", "3", "Beograd" ,"Srbija",
		                "SW-27-2018", 0.00));
						
		studenti.add(new Student("Milisav","PerkoviÄ‡",LocalDate.parse("28.09.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"012/1122-369","milisav.pejkovic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.S, 
		                "Knez Mihajlova", "22", "Beograd" ,"Srbija",
		                "SW-17-2016", 0.00));
						
		studenti.add(new Student("Mirko","Alicic",LocalDate.parse("21.07.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"012/1122-368","mirko.alicic@mailinator.com",
		                2018, GodinaStudiranja.TRECA , Status.S, 
		                "Bulevar Kralja Petra", "2d", "NiĹˇ" ,"Srbija",
		                "SW-17-2015", 0.00));
						
		studenti.add(new Student("Vladimir","IliÄ‡",LocalDate.parse("31.08.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/1122-367","vladimir.ilic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.B, 
		                "Nikole PaĹˇiÄ‡a", "6a", "Novi Sad" ,"Srbija",
		                "SW-4-2014", 0.00));
						
		studenti.add(new Student("Isidora","MikiÄ‡",LocalDate.parse("31.12.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/1122-366","isidora.mikic@mailinator.com",
		                2018, GodinaStudiranja.DRUGA , Status.B, 
		                "StraĹľilovska", "3", "Beograd" ,"Srbija",
		                "RA-1-2019", 0.00));
						
		studenti.add(new Student("Jovan","LaziÄ‡",LocalDate.parse("22.01.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"025/1189-479","jovan.lazic@mailinator.com",
		                2018, GodinaStudiranja.PRVA , Status.B, 
		                "MariÄ‡eva", "11", "Kragujevac" ,"Srbija",
		                "RA-23-2020", 0.00));
						
		studenti.add(new Student("Lena","IviÄ‡",LocalDate.parse("11.05.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"024/333-555","lena.ivic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.B, 
		                "Tolstojeva", "31", "Novi Sad" ,"Srbija",
		                "RA-154-2016", 0.00));
						
		studenti.add(new Student("Tomislav","NovakoviÄ‡",LocalDate.parse("25.02.1996.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"011/1188-379","tomislav.novakovic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.B, 
		                "Bulevar Kralja Petra", "22", "NiĹˇ" ,"Srbija",
		                "RA-14-2018", 0.00));
						
		studenti.add(new Student("Martin","StojanoviÄ‡",LocalDate.parse("01.05.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"024/321-775","martin.stojanovic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.S, 
		                null, "RA-13-2018", 0.00));
		 
		studenti.add(new Student("Nikola","MiĹˇkoviÄ‡",LocalDate.parse("03.08.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"022/123-456","nikola.miskovic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.S, 
		                "StraĹľilovska", "6a", "Novi Sad" ,"Srbija",
		                "RA-12-2018", 0.00));
						
		studenti.add(new Student("Jovan","DeretiÄ‡",LocalDate.parse("10.09.1998.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"002/200-300","jovan.deretic@mailinator.com",
		                2018, GodinaStudiranja.CETVRTA , Status.B, 
		                "Bulevar Patrijaha Pavla", "3", "Beograd" ,"Srbija",
		                "RA-11-2018", 0.00));
						
		studenti.add(new Student("Mika","MikiÄ‡",LocalDate.parse("05.11.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"015/101-909","mika.mikic@mailinator.com",
		                2018, GodinaStudiranja.PRVA , Status.S, 
		                "Nikole Tesle", "56", "Novi Sad" ,"Srbija",
		                "RA-1-2020", 0.00));
						
		studenti.add(new Student("Ana","DaboviÄ‡",LocalDate.parse("12.12.2001.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"014/303-007","ana.dabovic@mailinator.com",
		                2018, GodinaStudiranja.PRVA , Status.B, 
		                null,"RA-30-2019", 0.00));
						
		studenti.add(new Student("Bogdan","BogdanoviÄ‡",LocalDate.parse("23.07.1999.", DateTimeFormatter.ofPattern("dd.MM.yyyy.")),"021/231-231","bogdan.bogdanovic@mailinator.com",
		                2018, GodinaStudiranja.TRECA , Status.S, 
		                "Knez Mihajlova", "22", "Beograd" ,"Srbija",
		                "RA-4-2017", 0.00));
		
		
		/*try {
			this.studenti = Serijalizacija.getInstance().deserijalizacijaStudenta();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
				return "B";
			return "S";

		case 5:
			return student.getProsecnaOcena()+"";
		default:
			return null;
		}
	}
	
	public Boolean dodajStudenda(Student s) {
		return this.studenti.add(s);
		
	}
	
	public void izmeniStudenta(int i, Student s) {
		Student stari = studenti.get(i);
		if(!stari.getBrIndeksa().equals(s.getBrIndeksa())) {
			BazaOcena.getInstance().izmenaStudenta(stari.getBrIndeksa(),s.getBrIndeksa());
			PredmetiController.getInstance().izmenaStudenta(stari.getBrIndeksa(),s.getBrIndeksa());
		}
		
		
		stari.setIme(s.getIme());
		stari.setPrezime(s.getPrezime());
		stari.setDatumRodj(s.getDatumRodj());
		stari.setAdresaStan(s.getAdresaStan());
		stari.setBrIndeksa(s.getBrIndeksa());
		stari.setEmail(s.getEmail());
		stari.setGodUpisa(s.getGodUpisa());
		stari.setTrenutnaGodStud(s.getTrenutnaGodStud());
		stari.setKontaktBroj(s.getKontaktBroj());
		stari.setStatus(s.getStatus());
		
	}
	
	public void obrisiStudenta(int index) {
		this.studenti.remove(index);
	}
	
	public List<Predmet> getListaNePredmeta(Student student){

		
		List<Predmet> predmetiZaDodavanje= new ArrayList<Predmet>();
		
			 
			 for(Predmet prIzSvih : BazaPredmeta.getInstance().getPredmeti()) {
				 if(!student.getNepolozeniPred().contains(prIzSvih.getPredmetID())  && !student.getPolozeniPred().contains(prIzSvih.getPredmetID()+student.getBrIndeksa()) && prIzSvih.getGodStudija().ordinal()<= student.getTrenutnaGodStud().ordinal()   ) {
					 predmetiZaDodavanje.add(prIzSvih);
				 }
			 }
			 
		
		 return predmetiZaDodavanje;
	}
	
	public void izmenaPredmeta(String staraSifra,String novaSifra) {
		for(Student pr : studenti) {
			for(String sifra : pr.getNepolozeniPred()) {
				if(sifra.equalsIgnoreCase(staraSifra)) {
					int i= pr.getNepolozeniPred().indexOf(sifra);
					pr.getNepolozeniPred().add(i,novaSifra);
				}
			}
			
			for(String sifra : pr.getPolozeniPred()) {
				if(sifra.contains(staraSifra)) {
					String stDeo=sifra.replace(staraSifra, "").trim();
					int i= pr.getPolozeniPred().indexOf(sifra);
					pr.getPolozeniPred().add(i,novaSifra+stDeo);
				}
			}
		}
		
	}
}
